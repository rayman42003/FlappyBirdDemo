package states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.changrichmond.game.FlappyDemo;

import gameobjects.Bird;

public class PlayState extends State {
	private Bird bird;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		bird = new Bird(50, 300);
		cam.setToOrtho(false, FlappyDemo.WIDTH/2, FlappyDemo.HEIGHT/2);
	}

	@Override
	protected void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
		handleInput();
		bird.update(delta);
		
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
		batch.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
