package win.namespace.print.ooxx;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by print on 2017/3/14.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    //存储数据数组
    private List<CustomClass> mCustomList;

    //视图持有者。持有当前视图
    public class ViewHolder extends RecyclerView.ViewHolder {
        View cusView;//声明:保存最外层实例
        ImageView cusImageView;
        TextView cusTextView;

        public ViewHolder(View view) {
            super(view);
            cusView = view;//赋值
            cusImageView = (ImageView) view.findViewById(R.id.cus_imageview);
            cusTextView = (TextView) view.findViewById(R.id.cus_textview);
        }
    }

    //赋值数据：给当前适配器数据赋值
    public CustomAdapter(List<CustomClass> customList) {
        mCustomList = customList;
    }

    //创建视图持有者，将从layout上加载的视图赋值进去
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        //添加点击事件
        holder.cusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取当前位置
                int position = holder.getAdapterPosition();
                //提取数据
                CustomClass cus = mCustomList.get(position);
                Toast.makeText(view.getContext(), cus.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        //图片点击事件
        holder.cusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positon = holder.getAdapterPosition();
                CustomClass cus = mCustomList.get(positon);
                Toast.makeText(view.getContext(), cus.getName() + "展示图片", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    //视图持有者viewholder的单个实例赋值
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CustomClass cus = mCustomList.get(position);
        holder.cusImageView.setImageResource(cus.getImageId());
        holder.cusTextView.setText(cus.getName());
    }

    //返回总共要显示的数目
    @Override
    public int getItemCount() {
        return mCustomList.size();
    }
}
