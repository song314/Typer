package cn.sichuan.tangsong.view;

import cn.sichuan.tangsong.Main;
import cn.sichuan.tangsong.controler.CharChecker;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by tangsong on 11/9/14.
 */
public class ModeAScreen extends AbsScreen {

    private String mText = "asd fgh jkl";

    private CharChecker mChecker = new CharChecker();


    public ModeAScreen(final Main game) {
        super(game);

        //——————————UI————————————
        // Create a table that fills the screen. Everything else will go inside this table.
        //创建一个表格容器
        Table table = new Table();
        table.setFillParent(true);
        mStage.addActor(table);

        //创建按钮
        // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
        final TextButton btnModeA = new TextButton(mText, mSkin);
        btnModeA.pad(10);
        final TextButton btnModeWord = new TextButton("BBBBBBBB", mSkin);
        btnModeWord.pad(10);
        table.add(btnModeA);
        table.row();
        table.add(btnModeWord);

        // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
        // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
        // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
        // revert the checked state.
        btnModeA.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("jump ~!!!!!!!!!!");
                game.setScreen(new ModeAScreen(game));
                dispose();
            }
        });

        table.row();

        MyInputProcessor inputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);

        mChecker.setText(mText);

    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public class MyInputProcessor implements InputProcessor {


        @Override
        public boolean keyDown (int keycode) {
            return false;
        }

        @Override
        public boolean keyUp (int keycode) {
            return false;
        }

        @Override
        public boolean keyTyped (char character) {
            boolean right = mChecker.typed(character);
            System.out.println("key typed : " + character + ", xxx = " + right);
            return false;
        }

        @Override
        public boolean touchDown (int x, int y, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchUp (int x, int y, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchDragged (int x, int y, int pointer) {
            return false;
        }

        @Override
        public boolean mouseMoved (int x, int y) {
            return false;
        }

        @Override
        public boolean scrolled (int amount) {
            return false;
        }
    }
}
