package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.mygdx.game.Constants.SCREEN_HEIGHT;
import static com.mygdx.game.Constants.SCREEN_WIDTH;

/**
 * Created by luisa on 11/5/2016.
 */
public class SettingMenu implements Screen {

    final GameClass game;
    private Stage stage;
    private Texture texture;
    Preferences prefs;
    String gender;



    public SettingMenu(GameClass game) {
        this.game = game;
        if (game.isMale)
            gender = "Male";
        else
            gender = "Female";

        texture = new Texture(Gdx.files.internal("PixelMenu1.png"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


//            ResourceManager.loadTitleMusic();

    }

    @Override
    public void show()
    {
        loadPreferences();
        stage = new Stage();

        Table table = new Table(game.getSkin());
        table.setFillParent(true);
        table.center();

        final CheckBox checkSound = new CheckBox("Music", game.getSkin());
        checkSound.setChecked(prefs.getBoolean("sound"));
        checkSound.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                prefs.putBoolean("sound", checkSound.isChecked());
            }
        });

        TextButton genderButton = new TextButton(gender, game.getSkin());
        if(game.isMale){genderButton.setColor(Color.CYAN);}
        else{genderButton.setColor(Color.PINK);}
        genderButton.addListener(new ClickListener(){
            public void touchUp(InputEvent event, float x, float y, int pointer, int button)
            {


                if(gender.equals("Male"))
                    game.isMale = false;
                else
                    game.isMale = true;

                game.setScreen(new SettingMenu(game));
            }
        });




        TextButton AcceptButton = new TextButton("ACCEPT", game.getSkin());
        AcceptButton.setColor(1,.6f,.5f,1f);
        AcceptButton.addListener(new ClickListener()
        {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button)
            {
                ResourceManager.stopTitleMusic();
                dispose();

                if(!checkSound.isChecked()){
                    //make volume 0
                }

                game.setScreen(new MainMenu(game));
            }
        });
        TextButton configButton = new TextButton("CANCEL", game.getSkin());
        //configButton.setColor(Color.BLUE);
        configButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                ResourceManager.stopTitleMusic();
                game.setScreen(new MainMenu(game));
            }
        });

        TextButton empty = new TextButton("",game.getSkin());

        table.add(checkSound).padTop(150).padRight(-50);
        table.add(genderButton).width(90).padTop(150).padRight(300).padLeft(-150);
        table.row().height(50);
        table.add(AcceptButton).center().width(300).pad(5f).padLeft(150);
        table.row().height(0);
        table.add(empty);

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        stage.getBatch().begin();
        stage.getBatch().draw(texture, 1, 1, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.getBatch().end();

        stage.draw();
    }

    private void loadPreferences() {

        prefs = Gdx.app.getPreferences(Constants.APP);

        if (!prefs.contains("sound"))
            prefs.putBoolean("sound", true);

        if (!prefs.contains("difficult"))
            prefs.putBoolean("difficult", true);
    }

    @Override
    public void resize(int width, int height)
    {
        //stage.setViewport(width, height);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
