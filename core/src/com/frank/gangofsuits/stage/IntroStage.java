package com.frank.gangofsuits.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.player.Player;
import com.frank.gangofsuits.utilities.Constants;

public class IntroStage implements Screen {
	private Player player;
	private TiledMap map;
	private GangOfSuits game;
	private SpriteBatch batch;
	
	// Sprite gives us more capabilities than Texture
	private Sprite background;
	
	// Camera+Viewport
	OrthographicCamera camera;
	
	public IntroStage(GangOfSuits game) {
		this.game = game;
		batch = new SpriteBatch();
		
		background = new Sprite(new Texture(Gdx.files.internal("map.png")));
		background.setSize(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		
		float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(Constants.WORLD_WIDTH * aspectRatio, Constants.WORLD_HEIGHT * aspectRatio);
		camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
	}
	@Override
	public void show() {

	}
	@Override
	public void render(float delta) {	
		camera.update();
		
		batch.begin();
		
		batch.setProjectionMatrix(camera.combined);
		batch.draw(background, 0, 0);
		
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
