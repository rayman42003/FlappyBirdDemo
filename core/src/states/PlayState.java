package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.changrichmond.game.FlappyDemo;

import gameobjects.Bird;
import gameobjects.Tube;

public class PlayState extends State {
	private Bird bird;
	private Texture bg;
	private Tube tube;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		bird = new Bird(50, 300);
		cam.setToOrtho(false, FlappyDemo.WIDTH/2, FlappyDemo.HEIGHT/2);
		bg = new Texture("bg.png");
		tube = new Tube(100);
	}

	@Override
	protected void handleInput() {
		if(Gdx.input.justTouched())
			bird.jump();
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
		batch.draw(bg, cam.position.x - (cam.viewportWidth/2), 0);
		batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
		batch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
		batch.draw(tube.getBottomTube(), tube.getPosBotTube().x,  tube.getPosBotTube().y);
		batch.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
