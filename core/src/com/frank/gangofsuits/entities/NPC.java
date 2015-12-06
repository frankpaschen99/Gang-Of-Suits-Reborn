package com.frank.gangofsuits.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.frank.gangofsuits.GangOfSuits;
import com.frank.gangofsuits.utilities.PlayerState;

public class NPC {
	private Sprite sprite;
	private PlayerState state;
	private int health = 100;
	private GangOfSuits game;
	
	public NPC(GangOfSuits game, String texture, Vector2 position) {
		this.game = game;
		
		sprite = new Sprite(new Texture(Gdx.files.internal(texture)));
		sprite.setPosition(position.x, position.y);
		sprite.setRotation(0);
	}
	public void draw(Batch batch) {
		batch.draw(sprite, sprite.getX(), sprite.getY());
	}
	public void update() {

	}
	public void moveTo(Vector2 destination) {
		// Gradually move other the sprite from the current position to the destination
	}
}
