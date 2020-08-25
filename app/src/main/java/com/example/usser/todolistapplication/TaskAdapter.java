package com.example.usser.todolistapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class TaskAdapter extends RealmBaseAdapter<Task> {
    private static class ViewHolder {
        TextView deadline;
        TextView title;
    }

    public TaskAdapter(Context context, OrderedRealmCollection<Task> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null) {
            view = inflater.inflate(android.R.layout.simple_list_item_2, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.deadline = (TextView) view.findViewById(android.R.id.text1);
            viewHolder.title = (TextView) view.findViewById(android.R.id.text2);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Task task = adapterData.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = sdf.format(task.getDeadline());
        viewHolder.deadline.setText(formatDate);
        viewHolder.title.setText(task.getTitle());
        return view;
    }
}
