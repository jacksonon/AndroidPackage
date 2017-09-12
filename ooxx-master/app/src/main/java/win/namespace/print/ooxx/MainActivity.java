package win.namespace.print.ooxx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //创建新的数据源
    private List<CustomClass> cuslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCusList();
        RecyclerView showView = (RecyclerView) findViewById(R.id.ui_recyclerview);

        //瀑布流布局
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        showView.setLayoutManager(gridLayoutManager);

        //布局管理对象。瀑布流、横向滚动、线性布局
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //showView.setLayoutManager(layoutManager);
        //设置横向显示：
        //1.layout设置
        //2.此处设置
        //layoutManager.setOrientation(layoutManager.HORIZONTAL);
        //showView.setLayoutManager(layoutManager);

        //定制适配器：传递要适配的数据
        CustomAdapter adapter = new CustomAdapter(cuslist);
        //开始适配:根据适配的创建对适配视图、视图刷新、视图绑定、数量返回等
        showView.setAdapter(adapter);
    }

    private void initCusList() {
        for (int i = 0; i < 50; i++) {
            CustomClass cus = new CustomClass(getRandomLengthName("wang", i) + i, R.mipmap.ic_launcher);
            cuslist.add(cus);
        }
    }

    private String getRandomLengthName(String name, int index) {
        Random random = new Random();
        int lenth = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lenth; i++) {
            builder.append(name);
        }
        builder.append(index);
        return builder.toString();
    }
}
