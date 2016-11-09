package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.mygdx.game.Constants.FIRSTX;
import static com.mygdx.game.Constants.FIRSTY;


/**
 * Created by luisa on 10/21/2016.
 */
public class MainMenu implements Screen {
    GameClass game;
    private Stage stage;
    private Texture texture;


    public MainMenu(GameClass gameClass) {
        this.game = gameClass;

        texture = new Texture(Gdx.files.internal("PixelMenu1.png"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        ResourceManager.loadTitleMusic();

    }


    @Override
    public void show() {
        stage = new Stage();

        //Create a Table layout
        Table table = new Table(game.getSkin());
        table.setFillParent(true);
        table.center();

        //PLAY BUTTON
        TextButton playButton = new TextButton("PLAY NEW GAME", game.getSkin());
        playButton.setColor(Color.BROWN);
        playButton.addListener(new ClickListener()
        {
            //Activate transition when START BUTTON is clicked
            public void touchUp(InputEvent event, float x, float y, int pointer, int button)
            {
                ResourceManager.stopTitleMusic();
                dispose();

                game.setScreen(new Transition(game));
                Gdx.input.setInputProcessor(new InputAdapter(){
                            @Override
                            public boolean keyDown(int keycode) {
                                if(keycode == Input.Keys.ENTER) {
                                    game.setScreen(new GameScreen(game,FIRSTX, FIRSTY));
                                }
                                return super.keyDown(keycode);
                                                }});
            }
        });

        //Configuration (We would activate difficulty settings here) - not functioning
        TextButton configButton = new TextButton("Settings", game.getSkin());
        configButton.setColor(1,.6f,.5f,.8f);
        configButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                ResourceManager.stopTitleMusic();
                dispose();
                game.setScreen(new SettingMenu(game));

            }
        });

        //EXIT BUTTON ends program
        TextButton exitButton = new TextButton("EXIT", game.getSkin());
        exitButton.setColor(1,.6f,.5f,.8f); //Color fills screen

        exitButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                ResourceManager.stopTitleMusic();
                dispose();
                System.exit(0);
            }
        });

        //An invisible button to use fix color problem for exit button
        TextButton Holder = new TextButton("", game.getSkin());


        //Set table layout
        table.row().height(100);
        table.add(playButton.center()).center().width(300).pad(5f).padTop(150f).padRight(120);
        table.row().height(30);
        table.add(configButton).center().width(250).pad(5f).padRight(120);
        table.row().height(30);
        table.add(exitButton).center().width(250).pad(5f).padRight(120);
        table.row().height(10);
        table.add(Holder).center().width(10).pad(5f).padRight(120);
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
}
