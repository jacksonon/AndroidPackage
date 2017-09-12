package win.namespace.print.layoutui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by print on 2017/3/13.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //动态加载titleLayout
        //LayoutInflater动态加载一个布局对象
        //第一个参数是加载的布局文件ID，第二个参数是加载好的布局的父视图
        LayoutInflater.from(context).inflate(R.layout.titlelayout, this);

        //获取按钮添加事件
        Button backBtn = (Button) findViewById(R.id.title_btn1);
        Button editBtn = (Button) findViewById(R.id.title_btn2);

        backBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });

        editBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "点击编辑按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
