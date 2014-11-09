package cn.sichuan.tangsong;

import cn.sichuan.tangsong.view.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
        this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
        super.render();
	}

    @Override
    public void dispose() {
        batch.dispose();
        super.dispose();
    }
}
