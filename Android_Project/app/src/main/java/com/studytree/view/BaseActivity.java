package com.studytree.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.studytree.ActivityCleanupStack;
import com.studytree.log.Logger;
import com.studytree.utils.permissions.PermissionUtils;
import com.studytree.utils.permissions.RequestPermissionListener;

/**
 * Activity基类
 * Title: BaseActivity
 * @date 2018/6/16 15:26
 * @author Freedom0013
 */
public class BaseActivity extends AppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉AppCompatActivity标题栏自定义
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Activity压栈
        ActivityCleanupStack.push(this);
    }

    /**
     * 权限请求监听器
     */
    public RequestPermissionListener mPermisssionListener = new RequestPermissionListener() {
        @Override
        public void onPermissionPass(int requestCode) {
            Logger.w(TAG,"已有权限");
        }

        @Override
        public void onPermissionAccreditSucceed(int requestCode) {
            Logger.w(TAG,"权限获取成功");
        }

        @Override
        public void onPermissionAccreditFailed(int requestCode, String PermissionName) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //判断用户是否点击不在提示按钮，true：未选中，false：选中
                boolean isTip = ActivityCompat.shouldShowRequestPermissionRationale(BaseActivity.this,PermissionName);
                if (isTip) {//表明用户没有彻底禁止弹出权限请求
//                    requestPermission(PermissionHelper.getInstance().filterPermissions(permissions));
                } else {//表明用户已经彻底禁止弹出权限请求
                    Logger.e(TAG, "==========警告！用户拒绝并不在提示权限==========permission = " + PermissionName);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            permissionsutils.popPermissionAlterDialog("我们需要必要的权限来保证应用的正常运行！", BaseActivity.this);
                        }
                    });
                }
            }
            Logger.e(TAG, "权限获取失败");
        }
    };

    /**
     * 权限检查类
     */
    public PermissionUtils permissionsutils = new PermissionUtils(BaseActivity.this,mPermisssionListener);

    @Override
    public void finish() {
        ActivityCleanupStack.pop(this.getClass());
        super.finish();
        System.gc();
    }

    /**
     * 隐藏软件盘
     */
    public void hideSoftKeyboard() {
        try {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
        }
    }

    /**
     * 显示软键盘
     * @param target 需要显示的EditText控件
     */
    public void showSoftKeyboard(EditText target) {
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInputFromWindow(target.getWindowToken(), 0, InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
        }
    }

    /**
     * 弹出String Toast
     * @param s 要弹出的信息
     */
    public void showToast(final String s){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
