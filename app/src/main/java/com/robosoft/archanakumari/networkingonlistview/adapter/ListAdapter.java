package com.robosoft.archanakumari.networkingonlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.robosoft.archanakumari.networkingonlistview.R;
import com.robosoft.archanakumari.networkingonlistview.dto.ListItem;

import java.util.List;

/**
 * Created by archanakumari on 15/12/15.
 */
public class ListAdapter extends ArrayAdapter<ListItem>{
    private final LayoutInflater mInfater;

    private static class Viewholder {

        private TextView firstName;

        private TextView lastName;


    }

    public ListAdapter(Context context, List<ListItem> listItems) {

        super(context, 0, listItems);

        mInfater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        Viewholder holder;

        if (convertView == null) {

            holder = new Viewholder();

            convertView = mInfater.inflate(R.layout.list_item_view, parent, false);

            holder.firstName = (TextView) convertView.findViewById(R.id.first_name);

            holder.lastName = (TextView) convertView.findViewById(R.id.last_name);

            convertView.setTag(holder);

        } else {

            holder = (Viewholder) convertView.getTag();

        }

        ListItem item = getItem(position);

        holder.firstName.setText(item.ver);

        holder.lastName.setText(item.name);

        return convertView;

    }
}
