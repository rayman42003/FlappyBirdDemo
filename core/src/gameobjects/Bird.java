package gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Bird {
	private static final int GRAVITY = -15;
	private Texture texture;
	private Vector3 position;
	private Vector3 velocity;
	
	public Bird(int x, int y)
	{
		position = new Vector3(x, y, 0);
		velocity = new Vector3();
		texture = new Texture("bird.png");
	}
	
	public void jump() {
		velocity.y = 250;
	}
	
	public void update(float delta) {
		velocity.add(0, GRAVITY, 0);
		velocity.scl(delta);
		position.add(0, velocity.y, 0);
		velocity.scl(1/delta);
		if(position.y < 0)
			position.y =0;
	}

	public Texture getTexture() {
		return texture;
	}

	public Vector3 getPosition() {
		return position;
	}
}
