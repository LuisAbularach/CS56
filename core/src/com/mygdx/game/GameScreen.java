package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;


/**
 * Created by luisa on 10/21/2016.
 */
public class GameScreen implements Screen{

    final GameClass game;
    ShaderProgram shader;
    public Batch spriteBatch;
    public BitmapFont font;
    public SpriteManager spriteManager;
    Texture img;
    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    Sprite sprite;
    Texture texture;
    SpriteBatch sb;
    Character p;

    public GameScreen(GameClass game, int x, int y)
    {
        this.game = game;

        spriteBatch = new SpriteBatch();
        font = new BitmapFont();

        ResourceManager.loadAllResources();
        spriteManager = new SpriteManager(game, x, y);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        spriteManager.update(delta);
        spriteManager.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
