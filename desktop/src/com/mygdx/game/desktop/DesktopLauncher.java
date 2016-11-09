package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1024;
		config.height = 576;
		config.title = "Mission Jupitor: A Maze Game";
		config.addIcon("JavaBoyOnHB.png", Files.FileType.Internal);
//		config.fullscreen = true;
		new LwjglApplication(new GameClass(), config);
	}
}
