package me.xiazdong.recyclerviewdemo.demo0;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import me.xiazdong.recyclerviewdemo.R;

/**
 * Created by luo on 2019/8/19.
 * 简单 Adapter
 */

public class SimpleAdapter extends   RecyclerView.Adapter<SimpleAdapter.MyHolder>  {
    private final Context mContext;
    private final List mList;
    private OnItemListener onItemListener;
;

    public SimpleAdapter(Context mContext, List mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public SimpleAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_0, parent, false);
        MyHolder holder = new MyHolder(view);
        view.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleAdapter.MyHolder holder, final int position) {

        holder.number.setText( mList.get(position).toString());
        holder.title.setText("标题");

        holder.rl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemListener!=null){
                    onItemListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView number;
        TextView title;
        RelativeLayout rl_item;
        public MyHolder(View itemView) {
            super(itemView);

             number = (TextView) itemView.findViewById(R.id.number);
              title = (TextView) itemView.findViewById(R.id.title);
             rl_item = (RelativeLayout) itemView.findViewById(R.id.rl_item);
        }
    }

    //点击Item
    public interface OnItemListener {
        public void onItemClick(int points);
    }

    public OnItemListener getOnItemListener() {
        return onItemListener;
    }

    public void setOnItemListener(OnItemListener onItemListener1) {
        this.onItemListener = onItemListener1;
    }
}
