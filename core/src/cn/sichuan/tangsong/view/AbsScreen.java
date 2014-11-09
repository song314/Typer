package cn.sichuan.tangsong.view;

import cn.sichuan.tangsong.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by tangsong on 11/9/14.
 */
public class AbsScreen implements Screen {

    protected Skin mSkin;
    protected Stage mStage;

    public AbsScreen(Main main) {
        mStage = new Stage();
        Gdx.input.setInputProcessor(mStage);
        //创建皮肤
        createSkin();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        mStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        mStage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        mStage.dispose();
        mSkin.dispose();
    }

    protected void createSkin() {
        // A skin can be loaded via JSON or defined programmatically, either is fine. Using a skin is optional but strongly
        // recommended solely for the convenience of getting a texture, region, etc as a drawable, tinted drawable, etc.
        mSkin = new Skin();

        // Generate a 1x1 white texture and store it in the skin named "white".
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        mSkin.add("white", new Texture(pixmap));

        // Store the default libgdx font under the name "default".
        mSkin.add("default", new BitmapFont());

        // Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = mSkin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = mSkin.newDrawable("white", Color.DARK_GRAY);
//        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
        textButtonStyle.over = mSkin.newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = mSkin.getFont("default");
        mSkin.add("default", textButtonStyle);
    }

}
