package com.frank.gangofsuits.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frank.gangofsuits.GangOfSuits;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GangOfSuits(), config);
		config.width = 800;
		config.height = 600;
		config.resizable = false;
	}
}
