package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.mygdx.game.SpriteManager.GAME_RUNNING;

/**
 * Created by luisa on 11/5/2016.
 */
public class Pause implements Screen {

   private Skin skin;
    private Stage stage;
    GameClass game;
    Texture texture;


    public Pause(GameClass game){
        this.game = game;


        texture = new Texture(Gdx.files.internal("Paused.png"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        show();
    }

    @Override
    public void show() {
        stage = new Stage();


        Table table = new Table(game.getSkin());
        table.setFillParent(true);
        table.center();

        TextButton continueButton = new TextButton("UNPAUSE", game.getSkin());
        //playButton.setColor(Color.BLUE);
        continueButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                SpriteManager.gamestatus = GAME_RUNNING;
                //stage.clear();

            }
        });
        TextButton activateButton = new TextButton("SOUND", game.getSkin());
        //playButton.setColor(Color.BLUE);
        continueButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //gamestatus = GAME_RUNNING;
//                if (!ResourceManager.getMusic().isPlaying()) {
//                    ResourceManager.startMusic();
//                }
                //stage.clear();
            }
        });
        TextButton desactivateButton = new TextButton("SAVE", game.getSkin());
        //playButton.setColor(Color.BLUE);
        continueButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //gamestatus = GAME_RUNNING;
//                if (ResourceManager.getMusic().isPlaying()) {
//                    ResourceManager.stopMusic();
//                }
            }
        });
        TextButton menu = new TextButton("MAIN MENU", game.getSkin());
        //menu.setColor(Color.BLUE);
        menu.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                ResourceManager.stopMusic();
//                game.dispose();
                game.setScreen(new MainMenu(game));
            }
        });
        TextButton exitButton = new TextButton("EXIT", game.getSkin());
        //exitButton.setColor(Color.BLUE);
        exitButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                ResourceManager.stopTitleMusic();
//                game.dispose();
                System.exit(0);
            }
        });

        table.row().height(50);
        table.add(continueButton).center().width(300).pad(5f);
        table.row().height(50);
        table.add(activateButton).center().width(300).pad(5f);
        table.row().height(50);
        table.add(desactivateButton).center().width(300).pad(5f);
        table.row().height(50);
        table.add(menu).center().width(300).pad(5f);
        table.row().height(50);
        table.add(exitButton).center().width(300).pad(5f);

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        stage.getBatch().begin();
        stage.getBatch().draw(texture, 1, 1, 1024, 576);
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

    public Skin getSkin()
    {
        if(skin == null)
            skin = new Skin(Gdx.files.internal("uiskin.json"));
        return skin;
    }
}
