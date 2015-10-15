package com.frank.gangofsuits.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.stages.DeathScreen;
import com.frank.gangofsuits.stages.IntroStage;
import com.frank.gangofsuits.utilities.Constants;

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
		
		sprite = new Sprite(new Texture(Gdx.files.internal("spritesheets/char_sprite.png")));
		sprite.setPosition((Constants.WORLD_WIDTH / 2) - (sprite.getWidth()), (Constants.WORLD_HEIGHT / 2) - (sprite.getHeight()));
		sprite.setRotation(0);
	}
	
	public void draw(Batch batch) {
		batch.draw(sprite, sprite.getX(), sprite.getY());
	}
	public void update() {
		if (health <= 0 && !invincible) {
			state = PlayerState.DEAD;
			game.setScreen(new DeathScreen());
		}

		Vector3 velocity = new Vector3();
		float walkSpeed = 10;
		
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			Vector3 velUp = new Vector3();
			velUp.y = 1;
			velocity.add(velUp);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			Vector3 velDown = new Vector3();
			velDown.y = -1;
			velocity.add(velDown);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			Vector3 velLeft = new Vector3();
			velLeft.x = -1;
			velocity.add(velLeft);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			Vector3 velRight = new Vector3();
			velRight.x = 1;
			velocity.add(velRight);
		}
		
		float length = (float) Math.sqrt((Math.pow(velocity.x, 2)) + (Math.pow(velocity.y, 2)));

		if (length > 0.001) {
			velocity.nor();
			IntroStage.camera.translate(velocity.x, velocity.y);
		    sprite.translate(velocity.x, velocity.y);
		}
		/* Issue #1 still not fixed
	    IntroStage.camera.translate(velocityX, velocityY);
	    Vector3 camPosition = IntroStage.camera.position;
	    sprite.setPosition(camPosition.x, camPosition.y);*/
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
	public void setInvincible(boolean isInvincible) {
		this.invincible = isInvincible;
	}
	public Vector2 getPosition() {
		return new Vector2(sprite.getX(), sprite.getY());
	}
}
