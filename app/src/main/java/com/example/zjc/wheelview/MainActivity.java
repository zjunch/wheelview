package com.example.zjc.wheelview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void show(View view) {
        showDialog(1);
    }
    /**
     * 打开弹窗
     * @param index
     */
    private void showDialog(final String index) {
        final ClassCustomDialog dialog = new ClassCustomDialog(MainActivity.this, index);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.mystyle); // 添加动画
        dialog.show();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = (int) (display.getWidth()); // 设置宽度
        dialog.getWindow().setAttributes(lp);
        switch (Integer.valueOf(index)) {
            case 1:
                dialog.getTosave().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(dialog.getCurrentWheelItem()!=null){
                          //  dialog.getCurrentWheelItem();
                            //do something
                            dialog.dismiss();
                        }
                    }
                });
                dialog.getCancle().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
            default:
                break;
        }
    }

}
