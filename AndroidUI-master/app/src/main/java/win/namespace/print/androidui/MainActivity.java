package win.namespace.print.androidui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //属性列表
    private Button showProgressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);

        //按钮
        Button myButton = (Button) findViewById(R.id.button_btn);
        //输入框
        final EditText editText12 = (EditText) findViewById(R.id.edit_Text);
        //图片显示
        final ImageView imageView12 = (ImageView) findViewById(R.id.image_View);
        //获取
        final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progress_bar);
        //展示按钮
        Button showAlertDialogButton = (Button) findViewById(R.id.show_AlertDialog);

        //按钮点击事件
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入框文字
                String inputText = editText12.getText().toString();
                //显示文字
                if (inputText.length() != 0) {
                    Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "您未输入任何东西", Toast.LENGTH_SHORT).show();
                }

                //修改按钮的可见性
                if (progressBar1.getVisibility() == View.GONE) {
                    progressBar1.setVisibility(View.VISIBLE);
                } else {
                    progressBar1.setVisibility(View.GONE);
                }
            }
        });

        //图片点击监听
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //修改图片
                imageView12.setImageResource(R.drawable.testimage);
            }
        });

        //展示AlertDialog
        showAlertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实例化
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                //标题
                dialog.setTitle("提示");
                //内容
                dialog.setMessage("你爱不爱我？");
                //是否可以用Back按键关闭对话框
                dialog.setCancelable(false);
                //确定按钮反映
                dialog.setPositiveButton("喜欢", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(MainActivity.this, "我爱你呦！", Toast.LENGTH_SHORT).show();
                    }
                });
                //取消按钮反映
                dialog.setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你真讨厌，大臭脚！", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

        //展示进度弹出窗
        showProgressBtn = (Button) findViewById(R.id.show_progressDialog);
        showProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("进度条");
                progressDialog.setMessage("正在下载");
                progressDialog.setCancelable(true);
                progressDialog.show();
                //progressDialog.dissmiss();
            }
        });
    }
}
