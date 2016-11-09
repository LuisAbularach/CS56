package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by luisa on 10/22/2016.
 */
public class Player extends Character {
    public static float SPEED = 5f;

    public Player(float x, float y)
    {
        super(x, y, "player", new Vector2(0,0));
    }



}
