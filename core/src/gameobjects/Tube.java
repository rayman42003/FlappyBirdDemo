package gameobjects;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tube {
	public static final int TUBE_WIDTH = 52;
	private static final int VARIANCE = 130;
	private static final int TUBE_GAP = 100;
	private static final int TOP_TUBE_MIN_HEIGHT = 120;
		
	private Texture topTube;
	private Texture botTube;
	
	private Vector2 topPos;
	private Vector2 botPos;
	
	private Rectangle topBounds;
	private Rectangle botBounds;
	
	private Random rand;
	
	public Tube(float x) {
		topTube = new Texture("toptube.png");
		botTube = new Texture("bottomtube.png");
		
		rand = new Random();
		topPos = new Vector2(x, rand.nextInt(VARIANCE) + TUBE_GAP + TOP_TUBE_MIN_HEIGHT);
		botPos = new Vector2(x, topPos.y - TUBE_GAP - botTube.getHeight());
		
		topBounds = new Rectangle(topPos.x, topPos.y, topTube.getWidth(), topTube.getHeight());
		botBounds = new Rectangle(botPos.x, botPos.y, botTube.getWidth(), botTube.getHeight());
	}
	
	public void reposition(float x) {
		topPos.set(x, rand.nextInt(VARIANCE) + TUBE_GAP + TOP_TUBE_MIN_HEIGHT);
		botPos.set(x, topPos.y - TUBE_GAP - botTube.getHeight());
		
		topBounds.setPosition(topPos.x, topPos.y);
		botBounds.setPosition(botPos.x, botPos.y);
	}
	
	public boolean collides(Rectangle rect)
	{
		return rect.overlaps(topBounds) || rect.overlaps(botBounds);
	}
	
	public Texture getTopTube() {
		return topTube;
	}

	public Texture getBottomTube() {
		return botTube;
	}

	public Vector2 getPosTopTube() {
		return topPos;
	}

	public Vector2 getPosBotTube() {
		return botPos;
	}
	
}
