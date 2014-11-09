package cn.sichuan.tangsong.controler;

/**
 * Created by tangsong on 11/9/14.
 */
public class CharChecker {
    private String mText;
    private int mIndex = 0;


    public void setText(String text) {
        mText = text;
    }

    public boolean typed(char c) {
        boolean flag = c == mText.charAt(mIndex);
        if (flag) {
            mIndex++;
        }
        return flag;
    }

}
