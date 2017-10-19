package courcedesign.controlcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;

import courcedesign.controlcar.util.JudgeIsLogin;
import courcedesign.controlcar.view.JoinInOrUpActivity;

public class MainActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = "MainActivity";
    private static final int FROM_JOIN = 1;

    private JudgeIsLogin mJudgeIsLogin;

    private NavigationView mSelectNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (mJudgeIsLogin == null) {
            mJudgeIsLogin = new JudgeIsLogin(this);
        }
        if (!mJudgeIsLogin.getLoginState()) {
            Intent intent = new Intent();
            intent.setClass(this, JoinInOrUpActivity.class);
            startActivityForResult(intent, FROM_JOIN);
        } else {
            setContentView(R.layout.activity_main);
            mSelectNavigationView = (NavigationView) findViewById(R.id.select_navigationview);
            mSelectNavigationView.setNavigationItemSelectedListener(this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FROM_JOIN) {
            if (mJudgeIsLogin == null) {
                Log.w(TAG, "mJudgeIsLogin is null!");
                return;
            }
            mJudgeIsLogin.setLoginState();
            setContentView(R.layout.activity_main);
            mSelectNavigationView = (NavigationView) findViewById(R.id.select_navigationview);
            mSelectNavigationView.setNavigationItemSelectedListener(this);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.select_bluetooth:
                break;
            case R.id.select_wifi:
                break;
            //可以更多，只要在menu的布局文件里声明。
        }
        return false;
    }
}
