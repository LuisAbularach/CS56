package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class SpriteManager{
        GameClass game;

        int sw;

        public OrthographicCamera camera;
        Batch batch;
        int i = 0;
        public Array<Rectangle> tiles;

        Player p;

        public static int gamestatus;
        public static final int GAME_PAUSED = 0;
        public static final int GAME_RUNNING = 1;
        public boolean giroYellow;
        public int sw4;
        public int sw5;
        public BitmapFont font;
        public int x1, x2;
         private Pause pause;


        private Pool<Rectangle> rectPool = new Pool<Rectangle>()
        {
            @Override
            protected Rectangle newObject()
            {
                return new Rectangle();
            }
        };


        public SpriteManager(GameClass game, int x, int y)
        {
            this.game = game;


            gamestatus = GAME_RUNNING;

            camera = new OrthographicCamera();

            camera.setToOrtho(false,Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
            font = new BitmapFont();
            x1 = 400;
            x2 = 700;

            camera.update();

            if(game.sw == 0)
            {
                game.levelManager = new LevelManager(this);

                game.sw = 1;
                p = new Player(Constants.PLAYER_WIDTH,Constants.PLAYER_HEIGHT);
            }

            game.levelManager.loadCurrentLevel();

            batch = game.levelManager.mapRenderer.getBatch();


            if(game.levelManager.getCurrentLevel() == 0)
                p = new Player(x, y);
            else if(game.levelManager.getCurrentLevel() == 1)
                p = new Player(x, y);
            else if(game.levelManager.getCurrentLevel() == 2)
                p = new Player(x, y);
            else if(game.levelManager.getCurrentLevel() == 3)
                p = new Player(x, y);

            sw = 0;

            tiles = new Array<Rectangle>();



        }

    public void update(float dt) {
        camera.position.set(p.sprite.getX(), p.sprite.getY(), 0);

        handleInput();
//        checkCollisions();


        p.update(dt, "player");
    }

    private void handleInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
            p.SPEED = 15f;
        }
        else{p.SPEED = 5;}
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && gamestatus == GAME_RUNNING)
        {
            p.sprite.translate(-p.SPEED,0);
            p.state = Player.State.LEFT;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && gamestatus == GAME_RUNNING)
        {
            p.sprite.translate(p.SPEED,0);
            p.state = Player.State.RIGHT;

        }
        else if (Gdx.input.isKeyPressed(Input.Keys.UP) && gamestatus == GAME_RUNNING)
        {
            p.sprite.translate(0,p.SPEED);
            p.getCoordinates(p.sprite.getX(),p.sprite.getY());
            p.state = Player.State.UP;

        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && gamestatus == GAME_RUNNING)
        {
            p.sprite.translate(0,-p.SPEED);
            p.getCoordinates(p.sprite.getX(),p.sprite.getY());
            p.state = Player.State.DOWN;

        }
        else if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)&&gamestatus == GAME_RUNNING){
        gamestatus = GAME_PAUSED;
//            do {
//                pause = new Pause(game);
//            }while(gamestatus == GAME_PAUSED);
//            game.setScreen(new MainMenu(game));
        }
        else
        {
            p.velocity.x = 0;
            p.velocity.y = 0;
            p.state = Player.State.STOP;
        }

        if(gamestatus == GAME_PAUSED){
            pause = new Pause(game);
            game.setScreen(pause);
        }
    }

    private void checkCollisions() {
//        if(p.velocity.x < 0){
//
//        }
//        if(p.velocity.y > 0){
//
//        }

        float oldx = p.sprite.getX(), oldY = p.sprite.getY();

    }

    public void render()
    {
        camera.update();
        game.levelManager.mapRenderer.setView(camera);
        game.levelManager.mapRenderer.render();

        batch.begin();
        p.sprite.draw(batch);
        batch.end();


    }
}
