package cn.sichuan.tangsong.view;

import cn.sichuan.tangsong.Main;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by tangsong on 11/9/14.
 */
public class MenuScreen extends AbsScreen {


    public MenuScreen(final Main main) {
        super(main);

        //——————————UI————————————
        // Create a table that fills the screen. Everything else will go inside this table.
        //创建一个表格容器
        Table table = new Table();
        table.setFillParent(true);
        mStage.addActor(table);

        //创建按钮
        // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
        final TextButton btnModeA = new TextButton("Mode A", mSkin);
        btnModeA.pad(10);
        final TextButton btnModeWord = new TextButton("Mode Word", mSkin);
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
                main.setScreen(new ModeAScreen(main));
                dispose();
            }
        });

        table.row();
    }
}