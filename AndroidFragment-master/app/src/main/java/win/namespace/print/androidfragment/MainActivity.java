package win.namespace.print.androidfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        //replaceFragment(new RightFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                replaceFragment(new AnotherFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        //获取碎片支持
        FragmentManager manager = getSupportFragmentManager();
        //碎片事务，管理者开始一个新事物
        FragmentTransaction transaction = manager.beginTransaction();
        //事务调用替换，使新生成的fragement替代原有的视图
        transaction.replace(R.id.left_fragment, fragment);
        //加入到返回栈，可以执行返回操作
        transaction.addToBackStack(null);
        //提交事务
        transaction.commit();
    }
}
