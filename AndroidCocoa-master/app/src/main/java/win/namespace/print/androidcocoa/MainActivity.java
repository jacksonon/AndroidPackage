package win.namespace.print.androidcocoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//定义MainActivity，继承自Activity类
public class MainActivity extends AppCompatActivity {

    //定义传值键
    public final static String EXTRA_MESSAGE = "win.namespace.android.MESSAGE";

    //重写，实现onCreate抽象方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //调用父类方法
        super.onCreate(savedInstanceState);
        //加载R.layout.activity_main的布局文件
        setContentView(R.layout.activity_main);
    }

    //public函数、无返回值、参数唯一View类型，代表被点击的视图
    public void sendMessage(View view) {
        //Intent是在不同组建提供运行时绑定的对象
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //寻找到对应控件
        EditText editText = (EditText) findViewById(R.id.edittext1);
        //获取控件上值
        String message = editText.getText().toString();
        //putExtra方法进行传值
        intent.putExtra(EXTRA_MESSAGE, message);
        //完成新的Activity启动
        startActivity(intent);
    }
}
