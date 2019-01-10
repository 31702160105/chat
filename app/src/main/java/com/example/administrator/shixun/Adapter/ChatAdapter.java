package com.example.administrator.shixun.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.administrator.shixun.R;
import com.example.administrator.shixun.bean.MainBean;

import java.util.List;

/**
聊天适配器
 **/
public class ChatAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    List<MainBean> list;
    String name;
    public ChatAdapter(Context context, List<MainBean> list,String name){
        mInflater=LayoutInflater.from(context);
        this.list=list;
        this.name=name;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (list.get(position).getName().trim().equals(name.trim())){
            view=mInflater.inflate(R.layout.wechat_list_itemme,null);
            viewHolder=new ViewHolder();
            viewHolder.name=view.findViewById(R.id.list_name);
            viewHolder.chat=view.findViewById(R.id.list_content);
            viewHolder.time=view.findViewById(R.id.time);
        }else {
            view=mInflater.inflate(R.layout.wechat_list_item,null);
            viewHolder=new ViewHolder();
            viewHolder.name=view.findViewById(R.id.list_name);
            viewHolder.chat=view.findViewById(R.id.list_content);
            viewHolder.time=view.findViewById(R.id.time);
        }
        view.setTag(viewHolder);
        System.out.println(list.get(position).getName());
        viewHolder.name.setText(list.get(position).getName());
        viewHolder.chat.setText(list.get(position).getChat());
        viewHolder.time.setText(list.get(position).getTime());
        return view;
    }
    static class ViewHolder{
        TextView name;
        TextView chat;
        TextView time;
    }
}
