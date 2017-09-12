package win.namespace.print.layoutui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_jump;
    private Button btn_percent_jump;
    private Button btn_jumpListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏系统
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //跳转
        btn_jump = (Button) findViewById(R.id.btn1);
        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFrameLayoutActivity.actionStart(MainActivity.this);
            }
        });

        btn_percent_jump = (Button) findViewById(R.id.btn2);
        btn_percent_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PercentLayoutActivity.startActio(MainActivity.this);
            }
        });

        //跳转listView
        btn_jumpListView = (Button) findViewById(R.id.btn4);
        btn_jumpListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListViewActivity.startAction(MainActivity.this);
            }
        });
    }
}
