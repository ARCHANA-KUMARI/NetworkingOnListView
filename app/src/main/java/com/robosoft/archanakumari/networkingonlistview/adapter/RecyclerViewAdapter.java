package com.robosoft.archanakumari.networkingonlistview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robosoft.archanakumari.networkingonlistview.R;
import com.robosoft.archanakumari.networkingonlistview.dto.ListItem;

import java.util.List;

/**
 * Created by archanakumari on 27/1/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {

    private Context context;
    private List<ListItem> list;
    private View mOneRow;

    public RecyclerViewAdapter(Context context, List<ListItem> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("Hello","I am in onCreateViewHolder");
        mOneRow = LayoutInflater.from(context).inflate(R.layout.child,parent,false);
        Viewholder viewholder = new Viewholder(mOneRow);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Log.i("Hello","I am in onBindViewHolder");
        ListItem listItem = new ListItem();
     holder.mTextname.setText(list.get(position).name);
     Log.i("Hello", "Name is" + listItem.name);
     Log.i("Hello","Name is by list"+list.get(position).name);
     holder.mTextver.setText(list.get(position).ver);
     Log.i("Hello", "Ver is" + listItem.ver);
        Log.i("Hello","Version is by list"+list.get(position).ver);
   //  holder.api.setText(listItem.api);
    }

    @Override
    public int getItemCount() {
        Log.i("Hello","List size is" + list.size());
        return list.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private TextView mTextname;
        private TextView mTextver;
        private TextView api;


       public Viewholder(View itemView) {
           super(itemView);
           Log.i("Hello","I A AM IN VIEWHOLDER CONSTRUCTOR");
           mTextname = (TextView) itemView.findViewById(R.id.name);
           mTextver = (TextView) itemView.findViewById(R.id.ver);
          // api = (TextView) itemView.findViewById(R.id.api);

       }
   }
}
