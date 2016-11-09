package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by luisa on 10/21/2016.
 */
public class ResourceManager  {
        private static TextureAtlas atlas;
        private static TextureAtlas atlas2;
        private static TextureAtlas atlas3;
        public static Music music;
        public static Music musicTitle;
        public static Music musicEnd;
        public static Music musicGameOver;
        public static Music BuildingMusic;
        public static Sound sound;

    public static void loadAllResources()
    {
//        atlas = new TextureAtlas(Gdx.files.internal("Sprites/all.atlas"));
        //sound.setVolume(10);
    }

    public static void loadTitleMusic()
    {
        musicTitle = Gdx.audio.newMusic(Gdx.files.internal("Music/SongMenu.mp3"));
        musicTitle.setLooping(true);
        musicTitle.setVolume(5);
        startMusicTitle();
    }

    public static void loadEndGameMusic()
    {
        musicEnd = Gdx.audio.newMusic(Gdx.files.internal("Music/SongMenu.mp3"));
        //musicEnd.setLooping(true);
        musicEnd.setVolume(5);
        startEndMusic();
    }

    public static void stopTitleMusic()
    {
        musicTitle.stop();
    }

    public static void loadMusic()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("Music/SongMenu.mp3"));
        music.setLooping(true);
        music.setVolume(5);
        startMusic();


    }

    public static void loadGameOverMusic()
    {

        musicGameOver = Gdx.audio.newMusic(Gdx.files.internal("MUSIC LOST GAME"));
        musicGameOver.setLooping(true);
        musicGameOver.setVolume(5);
        startGameOverMusic();

    }

    public static void loadBuildingMusic()
    {
        BuildingMusic = Gdx.audio.newMusic(Gdx.files.internal("Building Music location"));
        BuildingMusic.setLooping(true);
        BuildingMusic.setVolume(5);
        startGameOverMusic();

        startCastleMusic();

        sound = Gdx.audio.newSound(Gdx.files.internal("sword attack.ogg"));
    }

    public static void startGameOverMusic()
    {
        musicGameOver.play();
    }

    public static void startCastleMusic()
    {
        BuildingMusic.play();
    }

    public static void stopBuildingMusic()
    {
        BuildingMusic.stop();
    }

    public static void stopGameOverMusic()
    {
        if(musicGameOver != null)
            musicGameOver.stop();
    }

    public static Music getGameOverMusic()
    {
        return musicGameOver;
    }

    public static TextureAtlas getAtlas()
    {
        return atlas;
    }

    public static TextureAtlas getAtlas2()
    {
        return atlas2;
    }

    public static TextureAtlas getAtlas3()
    {
        return atlas3;
    }

    public Sound getSound()
    {
        return sound;
    }

    public static void stopSound()
    {
        sound.dispose();
    }

    public static void startSound()
    {
        sound.play();
    }

    public static Music getMusic()
    {
        return music;
    }

    public static void stopMusic()
    {
        music.dispose();
    }

    public static void startMusic()
    {
        music.play();
    }

    public static void startMusicTitle()
    {
        musicTitle.play();
    }

    public static void startEndMusic()
    {
        musicEnd.play();
    }

    public static void stopEndMusic()
    {
        musicEnd.stop();
    }

    public static Music getEndMusic()
    {
        return musicEnd;
    }
}
