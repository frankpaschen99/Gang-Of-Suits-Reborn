package com.frank.gangofsuits.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.entities.Player;
import com.frank.gangofsuits.utilities.Constants;

public class IntroStage implements Screen {
	private Player player;
	
	private GangOfSuits game;
	private Batch batch;
	
	public static OrthographicCamera camera;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMap map;
	private TiledMapTileLayer collisionObjectLayer;
	private MapObjects objects;
	
	public TiledMap getMap() {
		return map;
		
	}
	public IntroStage(GangOfSuits game) {
		this.game = game;
		player = new Player(game);
		map = new TmxMapLoader().load("maps/desert/desert.tmx");
		collisionObjectLayer = (TiledMapTileLayer)map.getLayers().get(Constants.OBJECT_LAYER_ID);
		objects = collisionObjectLayer.getObjects();
		renderer = new OrthogonalTiledMapRenderer(map, 1);
		batch = renderer.getBatch();
		camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
		camera.setToOrtho(false, Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		camera.update();	
	}
	@Override
	public void show() {

	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
	    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

	    /* 
	     * For each RectangleMapObject in the TiledMapTileLayer's collection of objects, test if the rectangle
	     * of the tiled object overlaps our player's.
	     * 
	     * This loop doesn't run yet because the Tiled map isn't divided into layers
	     */
	    
		for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
		    Rectangle rectangle = rectangleObject.getRectangle();
		    
		    if (Intersector.overlaps(rectangle, player.getRectangle())) {
		        // Handle collision
		    	System.out.println('(' + player.getRectangle().x + ", " + player.getRectangle().y + ')');
		    }
		}
	    
		player.update();
		camera.update();
		
		renderer.setView(camera);
		renderer.render();
		
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		
		player.draw(batch);
		
		batch.end();
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
