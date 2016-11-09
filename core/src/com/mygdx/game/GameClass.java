package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameClass extends Game {
	SpriteBatch batch;
	public boolean paused;
	public Skin skin;
	public int sw;
	public LevelManager levelManager;
	TiledMapRenderer tiledMapRenderer;
	public static Boolean isMale = true;

	@Override
	public void create () {
		setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
			super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}

	public Skin getSkin()
	{
		if(skin == null)
			skin = new Skin(Gdx.files.internal("uiskin.json"));
		return skin;
	}

}
