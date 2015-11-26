package com.frank.gangofsuits.entities;

import java.math.BigDecimal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.stages.IntroStage;
import com.frank.gangofsuits.utilities.Constants;

enum PlayerState {
	ALIVE, DEAD, INVINCIBLE
}
public class Player {
	private Sprite sprite;
	private PlayerState state = PlayerState.ALIVE;
	private GangOfSuits game;
	private static int health = 100 / Constants.DIFFICULTY;
	private static BigDecimal cash = new BigDecimal(5000);

	public Player(GangOfSuits game) {
		this.game = game;
		
		sprite = new Sprite(new Texture(Gdx.files.internal("spritesheets/char_sprite.png")));
		sprite.setPosition((Constants.WORLD_WIDTH / 2) - (sprite.getWidth() / 2), (Constants.WORLD_HEIGHT / 2) - (sprite.getHeight() / 2));
		sprite.setRotation(0);
	}
	
	public void draw(Batch batch) {
		batch.draw(sprite, sprite.getX(), sprite.getY());
	}
	public void update() {
		if (health <= 0 && state != PlayerState.INVINCIBLE) {
			state = PlayerState.DEAD;
		}

		Vector3 velocity = new Vector3();
		
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
		else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			Vector3 velLeft = new Vector3();
			velLeft.x = -1;
			velocity.add(velLeft);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			Vector3 velRight = new Vector3();
			velRight.x = 1;
			velocity.add(velRight);
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			// pause menu
		}
		
		float length = (float) Math.sqrt((Math.pow(velocity.x, 2)) + (Math.pow(velocity.y, 2)));

		if (length > 0.001) {
			velocity.nor();
			IntroStage.camera.translate(velocity.x, velocity.y);
		    sprite.translate(velocity.x, velocity.y);
		}
	}
	// Getters & Setters
	public PlayerState getState() {
		return state;
	}
	public void setPlayerState(PlayerState newState) {
		this.state = newState;
	}
	public Vector2 getPosition() {
		return new Vector2(sprite.getX(), sprite.getY());
	}
	public BigDecimal getCash() {
		return cash;
	}
	public void setCash(int newCash) {
		this.cash = new BigDecimal(newCash);
	}

	public Rectangle getRectangle() {
		return new Rectangle(sprite.getBoundingRectangle());
	}
}