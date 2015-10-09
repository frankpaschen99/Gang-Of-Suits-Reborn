package com.frank.gangofsuits;

import com.badlogic.gdx.Game;
import com.frank.gangofsuits.stage.IntroStage;

public class GangOfSuits extends Game {
	public void create() {
		setScreen(new IntroStage(this));
	}

	public void render() {
		super.render();
	}
}
