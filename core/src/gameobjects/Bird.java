package gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
	private static final int GRAVITY = -15;
	private static final int MOVEMENT = 100;
	private Texture texture;
	private Vector3 position;
	private Vector3 velocity;
	private Rectangle bounds;
	
	public Bird(int x, int y)
	{
		position = new Vector3(x, y, 0);
		velocity = new Vector3();
		texture = new Texture("bird.png");
		
		bounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
	}
	
	public void jump() {
		velocity.y = 250;
	}
	
	public void update(float delta) {
		velocity.add(0, GRAVITY, 0);
		velocity.scl(delta);
		position.add(MOVEMENT * delta, velocity.y, 0);
		velocity.scl(1/delta);
		if(position.y < 0)
			position.y =0;
		bounds.setPosition(position.x, position.y);
	}

	public Texture getTexture() {
		return texture;
	}

	public Vector3 getPosition() {
		return position;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
}
