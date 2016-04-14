package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.changrichmond.game.FlappyDemo;

import gameobjects.Bird;
import gameobjects.Tube;

public class PlayState extends State {
	private static final int TUBE_SPACING = 125;
	private static final int TUBE_COUNT = 4;
	
	private Bird bird;
	private Texture bg;
	
	private Array<Tube> tubes;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		bird = new Bird(50, 300);
		cam.setToOrtho(false, FlappyDemo.WIDTH/2, FlappyDemo.HEIGHT/2);
		bg = new Texture("bg.png");
		
		tubes = new Array<Tube>();
		for(int i = 0; i < TUBE_COUNT; i++)
			tubes.add(new Tube(i *(TUBE_SPACING + Tube.TUBE_WIDTH)));
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
		cam.position.x = bird.getPosition().x + 80;
		
		for(Tube tube : tubes)
		{
			if(cam.position.x - cam.viewportWidth / 2 > tube.getPosBotTube().x + tube.getTopTube().getWidth())
				tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
			if(tube.collides(bird.getBounds())) {
				gsm.set(new PlayState(gsm));
			}
		}
		
		cam.update();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(bg, cam.position.x - (cam.viewportWidth/2), 0);
		batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
		for(Tube tube : tubes) {
			batch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
			batch.draw(tube.getBottomTube(), tube.getPosBotTube().x,  tube.getPosBotTube().y);
		}
		batch.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
