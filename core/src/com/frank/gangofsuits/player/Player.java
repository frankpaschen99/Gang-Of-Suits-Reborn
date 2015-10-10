package com.frank.gangofsuits.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.stage.DeathScreen;

enum PlayerState {
	ALIVE, DEAD
}
public class Player {
	private Sprite sprite;
	private PlayerState state = PlayerState.ALIVE;
	private int health = 100;
	private GangOfSuits game;
	private boolean invincible = false;
	
	public Player(GangOfSuits game) {
		this.game = game;
		
		sprite = new Sprite(new Texture(Gdx.files.internal("char_sprite.png")));
		sprite.setPosition(0, 0);
		sprite.setRotation(0);
	}
	
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
	public void update() {
		if (health <= 0 && !invincible) {
			state = PlayerState.DEAD;
			game.setScreen(new DeathScreen());
		}
	}
	public PlayerState getState() {
		return state;
	}
	public void setPlayerState(PlayerState newState) {
		this.state = newState;
	}
	public boolean isInvinsible() {
		return invincible;
	}
	public void invincibility(boolean isInvincible) {
		this.invincible = isInvincible;
	}
}
