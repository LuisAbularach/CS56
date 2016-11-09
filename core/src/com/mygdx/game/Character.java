package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 * Created by luisa on 10/22/2016.
 */
public class Character {

    public enum State
    {
        RIGHT, LEFT, UP, DOWN, STOP, ATTACK, DEAD
    }

    public State state;

    public String lastMove;

    float stateTime;
    public int frame;
    Animation rightAnimation;
    Animation leftAnimation;
    Animation upAnimation;
    Animation downAnimation;

    Animation downAttackAnimation;
    Animation upAttackAnimation;
    Animation leftAttackAnimation;
    Animation rightAttackAnimation;

    Animation deadAnimation;

    TextureRegion currentFrame;
    Texture texture;
    Sprite sprite;
    String JavaChar;
    public TextureRegion heart;

    public Rectangle rect;
    boolean dead;

    int sw;

    public Vector2 position = new Vector2();
    public Vector2 velocity = new Vector2();
    public String name;

    float x;
    float y;


    public Character(float x, float y, String name,Vector2 velocity)
    {
        if(GameClass.isMale){
            JavaChar = Constants.Male;
        }
        else{
            JavaChar = Constants.Female;
        }

        texture = new Texture(Gdx.files.internal(JavaChar));

        sprite = new Sprite(texture);

        sprite.setPosition(1590,815);
    }

    public void update(float dt, String name)
    {
        if(name.equals("player")) {


            switch (state) {
                case LEFT:
                    sprite.setFlip(true, false);


                    //Temp
                    if(JavaChar.equals("JavaGirlOnHBBack.png"))
                        sprite.setFlip(false,false);
                    lastMove = "LEFT";
                    break;
                case RIGHT:
                    sprite.setFlip(false, false);
                    lastMove = "RIGHT";

                    //Temp
                    if(JavaChar.equals("JavaGirlOnHBBack.png"))
                        sprite.setFlip(true,false);
                    break;
                case UP:
                    //Only done for female
                    if (JavaChar.equals("JavaGirlOnHB.png"))
                    {
                        JavaChar = "JavaGirlOnHBBack.png";
                    texture = new Texture("JavaGirlOnHBBack.png");
                    sprite = new Sprite(texture);
                    sprite.setPosition(x, y);
                    lastMove = "UP";
                    }
                    break;
                case DOWN:
                    if (JavaChar.equals("JavaGirlOnHBBack.png"))
                    {
                        JavaChar = "JavaGirlOnHB.png";
                        texture = new Texture("JavaGirlOnHB.png");
                        sprite = new Sprite(texture);
                        sprite.setPosition(x, y);
                        lastMove = "UP";
                    }
                    lastMove = "DOWN";
                    break;
            }


//            rect.x = position.x;
//            rect.y = position.y;
//            rect.setWidth(currentFrame.getRegionWidth() / 2);
//            rect.setHeight(currentFrame.getRegionHeight() / 2);


            stateTime += dt;

            velocity.scl(dt);
//        rect.set(position.x, position.y, rect.getWidth(), rect.getHeight());
            position.add(velocity);
        }
        }


       public void getCoordinates(float xPosition, float yPosition){
           x = xPosition;
           y = yPosition;
       }


    public void render() {

    }
}

