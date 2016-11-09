package com.mygdx.game;


import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class LevelManager
{
    private int currentLevel;
    private SpriteManager spriteManager;

    public static Array<Rectangle> terreno = new Array<Rectangle>();
    public static Array<Rectangle> transiciones1 = new Array<Rectangle>();
    public static Array<Rectangle> transiciones2 = new Array<Rectangle>();
    public static Array<Rectangle> transiciones3 = new Array<Rectangle>();
    public static Array<Rectangle> endGame = new Array<Rectangle>();

    //UNUSED
    public static Array<Polygon> terreno2 = new Array<Polygon>();

    TiledMap map;
    //TiledMapTileLayer collisionLayer;
    MapLayer collisionLayer;
    MapLayer collisionLayer3;
    MapLayer transicionesLayer1;
    MapLayer transicionesLayer2;
    MapLayer transicionesLayer3;
    MapLayer endGameLayer;

    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;

    OrthogonalTiledMapRenderer mapRenderer;

    private static float ppt = 0;

    public LevelManager(SpriteManager spriteManager)
    {
        this.spriteManager = spriteManager;
        currentLevel = 0;

        //spriteManager.enemies = new Array<Enemy>();
    }

    public void loadCurrentLevel()
    {
        //Load "Main map" for now



        tiledMap = new TmxMapLoader().load("Overworld.tmx");
        collisionLayer = tiledMap.getLayers().get("collision");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        mapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

    }

    public void setLevel(int i)
    {
        currentLevel = i;
    }



    private void loadTerreno()
    {
        for (MapObject ro : collisionLayer.getObjects())
        {
            if (ro instanceof TextureMapObject)
            {
                continue;
            }
            //Shape shape;

            if (ro instanceof RectangleMapObject)
            {
                terreno.add(((RectangleMapObject)ro).getRectangle());
            }
            else if (ro instanceof PolygonMapObject)
            {
                terreno2.add(((PolygonMapObject)ro).getPolygon());
            }
            else
            {
                continue;
            }
        }
    }

    public void restarCurrentLevel()
    {
        currentLevel = 0;
    }

    public void passNextLevel()
    {
        currentLevel++;
    }

    public void reduceLevel()
    {
        if(currentLevel != 0)
            currentLevel--;
    }

    public int getCurrentLevel()
    {
        return this.currentLevel;
    }



    public SpriteManager getSpriteManager() {
        return spriteManager;
    }
}
