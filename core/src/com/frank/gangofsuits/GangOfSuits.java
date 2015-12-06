package com.frank.gangofsuits;

import com.badlogic.gdx.Game;
import com.frank.gangofsuits.stages.IntroStage;

public class GangOfSuits extends Game {
	public void create() {
		// Will initially set the screen to the main menu, then the IntroStage from there
		setScreen(new IntroStage(this));
	}

	public void render() {
		super.render();
	}
}
