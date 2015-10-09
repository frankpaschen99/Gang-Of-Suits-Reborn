package com.frank.gangofsuits.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	private Texture texture;
	private Sprite sprite;
	
	public Player() {
		texture = new Texture(Gdx.files.internal("char_sprite.png"));
		sprite = new Sprite(texture);
		sprite.setPosition(0, 0);
		sprite.setRotation(0);
	}
	
	public void draw(SpriteBatch batch) {
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
	
	public void moveUp() {
		
	}
	
	public void moveDown() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
}
