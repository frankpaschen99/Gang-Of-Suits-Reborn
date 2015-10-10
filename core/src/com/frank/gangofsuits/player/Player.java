package com.frank.gangofsuits.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

		float playerSpeed = 10.0f;
		float velocityX = 0.0f;
		float velocityY = 0.0f;
		
		if(Gdx.input.isKeyPressed(Input.Keys.A)) 
			velocityX -= Gdx.graphics.getDeltaTime() * playerSpeed;
		if(Gdx.input.isKeyPressed(Input.Keys.D)) 
			velocityX += Gdx.graphics.getDeltaTime() * playerSpeed;
		if(Gdx.input.isKeyPressed(Input.Keys.W)) 
			velocityY += Gdx.graphics.getDeltaTime() * playerSpeed;
		if(Gdx.input.isKeyPressed(Input.Keys.S)) 
			velocityY -= Gdx.graphics.getDeltaTime() * playerSpeed;

		float length = (float) Math.sqrt((Math.pow(velocityX, 2)) + (Math.pow(velocityY, 2)));
		if (length > 0.0f) {
			velocityX /= length;
			velocityY /= length;
		}
	    sprite.translate(velocityX, velocityY);
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
