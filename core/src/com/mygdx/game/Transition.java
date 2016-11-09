package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by luisa on 10/21/2016.
 */
public class Transition implements Screen {
    GameClass game;
    private Stage stage;
    private Texture CutScene1,CutScene2;
    private boolean ispressed = false;

    public Transition(GameClass game) {
        this.game = game;


            CutScene1 = new Texture(Gdx.files.internal("Instructions.png"));
            CutScene1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            CutScene2 = new Texture(Gdx.files.internal("2.png"));
            CutScene2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);



    }

    @Override
    public void show() {
        stage = new Stage();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        stage.getBatch().begin();
        stage.getBatch().draw(CutScene1, 1, 1, Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)||ispressed)
        {
            ispressed = true;
            stage.getBatch().draw(CutScene2,1,1,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        }

        stage.getBatch().end();

        stage.draw();
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
