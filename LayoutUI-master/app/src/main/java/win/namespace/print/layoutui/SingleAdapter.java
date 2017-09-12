package win.namespace.print.layoutui;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by print on 2017/3/13.
 */

//需要传入相应的类型，不然下面无法获取到相关类型的实例，不知道Array数组里保存的是什么
public class SingleAdapter extends ArrayAdapter<SingleShow> {
    private int sourceId;


    public SingleAdapter(Context context, int resource, List<SingleShow> objects) {
        super(context, resource, objects);
        sourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //创建返回的视图

        //获取当前CELL的singleshow实例
        SingleShow singleShow = getItem(position);
        //获取返回的视图
        //View view = LayoutInflater.from(getContext()).inflate(sourceId, parent, false);
        //获取视图上的控件并且设置
        //ImageView imageView = (ImageView) view.findViewById(R.id.single_imageview);
        //TextView textView = (TextView) view.findViewById(R.id.single_textview);
        //设置图片以及文字
        //imageView.setImageResource(singleShow.getImageId());
        //textView.setText(singleShow.getName());

        //提升ListView的运行效率 convertView,常规优化
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(sourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.singleImageView = (ImageView) view.findViewById(R.id.single_imageview);
            viewHolder.singleTextView = (TextView) view.findViewById(R.id.single_textview);
            //将Viewholder存储在View当中
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //使用viewholder将对一个图片文字赋值
        viewHolder.singleImageView.setImageResource(singleShow.getImageId());
        viewHolder.singleTextView.setText(singleShow.getName());

        return view;
    }

    //创建一个类，用来减少对控件实例进行缓存
    class ViewHolder {
        ImageView singleImageView;
        TextView singleTextView;
    }
}
