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
import com.frank.gangofsuits.entities.NPC;
import com.frank.gangofsuits.entities.Player;
import com.frank.gangofsuits.utilities.Constants;

public class IntroStage implements Screen {
	/* Player */
	private Player player;
	
	/* Game/Rendering */
	private GangOfSuits game;
	private Batch batch;
	
	/* Camera */
	public static OrthographicCamera camera;
	
	/* Tiled Map */
	private OrthogonalTiledMapRenderer renderer;
	private TiledMap map;
	private TiledMapTileLayer collisionObjectLayer;
	private MapObjects objects;

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
		
		// Remove later
		// printLayerInfo(collisionObjectLayer);
	}
	@Override
	public void show() {

	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
	    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
 
	     /* For each RectangleMapObject in the TiledMapTileLayer's collection of objects, test if the rectangle
	        of the tiled object overlaps our player's. */
		for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
		    Rectangle rectangle = rectangleObject.getRectangle();
		    
		    if (Intersector.overlaps(rectangle, player.getBoundingRect())) {
		        // Handle collision
		    	System.out.println('(' + player.getBoundingRect().x + ", " + player.getBoundingRect().y + ')');
		    }
		}
	    
		// Update everything
		player.update();
		camera.update();
		
		renderer.setView(camera);
		renderer.render();

		// Render everything in the scene
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
	// Debug
	private void printLayerInfo(TiledMapTileLayer t) {
		System.out.println("TiledMapTileLayer Information" + '\n' + "Name: " + t.getName() + '\n' + "Width: " + t.getWidth() + '\n' + "Height: " + t.getHeight());
	}
}
