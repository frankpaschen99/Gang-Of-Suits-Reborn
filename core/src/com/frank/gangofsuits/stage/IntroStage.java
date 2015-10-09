package com.frank.gangofsuits.stage;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.player.Player;
import com.frank.gangofsuits.utilities.Constants;

public class IntroStage implements Screen {
	private Player player;
	private TiledMap map;
	private Camera camera;
	private Viewport viewport;
	private GangOfSuits game;
	
	public IntroStage(GangOfSuits game) {
		this.game = game;
		this.viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		this.camera = new OrthographicCamera();
	}
	@Override
	public void show() {

	}
	@Override
	public void render(float delta) {

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
