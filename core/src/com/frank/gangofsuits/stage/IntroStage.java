package com.frank.gangofsuits.stage;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.player.Player;

public class IntroStage implements Screen {
	private Player player;
	private TiledMap map;
	private OrthographicCamera camera;
	private GangOfSuits game;
	
	public IntroStage(GangOfSuits game) {
		this.game = game;
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
