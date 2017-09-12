package win.namespace.print.layoutui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView my_listView;

    private String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    private List<SingleShow> showList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //隐藏原有
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //初始化数据源
        initMyList();

        //数据源与界面绑定
        //当前界面 + 定制的单个cell + 展示数据
        SingleAdapter myAdapter = new SingleAdapter(ListViewActivity.this, R.layout.single_item, showList);
        //单个数据与list绑定
        ListView listView = (ListView) findViewById(R.id.ui_listView);
        //刷新单个Cell
        listView.setAdapter(myAdapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingleShow singleShow = showList.get(i);
                Toast.makeText(ListViewActivity.this, singleShow.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        /* 基本使用
        //获取
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this, android.R.layout.simple_list_item_1, data);
        my_listView = (ListView) findViewById(R.id.ui_listView);
        my_listView.setAdapter(adapter);
        */
    }

    private void initMyList() {
        for (int i = 0; i < 20; i++) {
            SingleShow obj = new SingleShow("好玩么", R.mipmap.ic_launcher);
            showList.add(obj);
        }
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, ListViewActivity.class);
        context.startActivity(intent);
    }
}
