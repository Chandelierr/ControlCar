package courcedesign.controlcar.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wangmengjie on 2017/10/17.
 */

public class JudgeIsLogin {
    private Context mContext;

    public JudgeIsLogin(Context context) {
        mContext = context;
    }

    public void setLoginState() {
        SharedPreferences sp = mContext.getSharedPreferences("isLogin", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("IsLogin", true);
        editor.apply();
    }

    public boolean getLoginState() {
        SharedPreferences sp = mContext.getSharedPreferences("isLogin", 0);
        return sp.getBoolean("IsLogin", false);
    }
}
