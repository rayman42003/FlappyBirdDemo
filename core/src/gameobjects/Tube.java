package gameobjects;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Tube {
	public static final int TUBE_WIDTH = 52;
	private static final int VARIANCE = 130;
	private static final int TUBE_GAP = 100;
	private static final int TOP_TUBE_MIN_HEIGHT = 120;
		
	private Texture topTube;
	private Texture bottomTube;
	
	private Vector2 posTopTube;
	private Vector2 posBotTube;
	
	private Random rand;
	
	public Tube(float x) {
		topTube = new Texture("toptube.png");
		bottomTube = new Texture("bottomtube.png");
		
		rand = new Random();
		posTopTube = new Vector2(x, rand.nextInt(VARIANCE) + TUBE_GAP + TOP_TUBE_MIN_HEIGHT);
		posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
	}
	
	public void reposition(float x) {
		posTopTube.set(x, rand.nextInt(VARIANCE) + TUBE_GAP + TOP_TUBE_MIN_HEIGHT);
		posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
	}

	public Texture getTopTube() {
		return topTube;
	}

	public Texture getBottomTube() {
		return bottomTube;
	}

	public Vector2 getPosTopTube() {
		return posTopTube;
	}

	public Vector2 getPosBotTube() {
		return posBotTube;
	}
	
}
