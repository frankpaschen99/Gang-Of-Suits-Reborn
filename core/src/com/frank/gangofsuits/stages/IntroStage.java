package com.frank.gangofsuits.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.entities.Player;
import com.frank.gangofsuits.utilities.Constants;

public class IntroStage implements Screen {
	private Player player;
	
	// private GangOfSuits game;			Not used yet, but will be
	private Batch batch;
	
	public static OrthographicCamera camera;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMap map;
	
	public TiledMap getMap() {
		return map;
	}
	public IntroStage(GangOfSuits game) {
		// this.game = game;
		player = new Player(game);
		map = new TmxMapLoader().load("maps/desert/desert.tmx");
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
