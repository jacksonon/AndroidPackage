package win.namespace.print.besttalk.MsgPackage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import win.namespace.print.besttalk.R;

/**
 * Created by print on 2017/3/15.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgView> {

    //数据源:需要初始化时候赋值
    private List<Msg> mMsgList;

    //内置类
    static class MsgView extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;
        LinearLayout rightLayout;

        TextView leftTextView;
        TextView rightTextView;

        //实例化
        public MsgView(View view) {
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.item_left);
            rightLayout = (LinearLayout) view.findViewById(R.id.item_right);
            leftTextView = (TextView) view.findViewById(R.id.leftmsg_textview);
            rightTextView = (TextView) view.findViewById(R.id.rightmsg_textview);
        }

    }

    //初始化以及数组赋值：
    public MsgAdapter(List<Msg> list) {
        mMsgList = list;
    }

    //持有视图初始化
    @Override
    public MsgView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new MsgView(view);
    }

    //视图绑定:赋值
    @Override
    public void onBindViewHolder(MsgView holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftTextView.setText(msg.getContent());
        } else {
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightTextView.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
