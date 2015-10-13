package com.frank.gangofsuits.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.frank.gangofsuits.entities.Player;

public class MyLevelBaseClass implements Screen {

	private Player player;
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMap map;
	private Batch batch;
	
	protected MyLevelBaseClass(Player player, OrthographicCamera camera, String mapFile) {
		this.player = player;
		this.camera = camera;
		this.map = new TmxMapLoader().load(mapFile);
		this.renderer = new OrthogonalTiledMapRenderer(map, 1);
		this.batch = renderer.getBatch();
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
		batch.setTransformMatrix(camera.combined);
		
		// Drawing code here

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
