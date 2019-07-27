package com.codingblocks.listview;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class personadapter extends BaseAdapter {
    final String TAG="text";
   private Context mcontext;
  private  int mresource;


    public personadapter(Context mcontext, int mresource,ArrayList<data> list) {
       
        this.mcontext = mcontext;
        this.mresource = mresource;
    }

    @Override
    public int getCount() {
        return 0   ;
    }

    @Override
    public data getItem(int position) {
        data DATA=new data(getItem(position).getName(),getItem(position).getTeachername(),getItem(position).getLecture());
        return DATA;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name=getItem(position).getName();
        Log.i(TAG,name);
        String tchname=getItem(position).getTeachername();
        String lecture=getItem(position).getLecture();
        LayoutInflater inflater= LayoutInflater.from(mcontext);
        convertView=inflater.inflate(mresource,parent,false);
        TextView name1=(convertView).findViewById(R.id.cbname);
        TextView  tname1=(convertView).findViewById(R.id.cbteachername);
        TextView lecture1=(convertView).findViewById(R.id.cblecture);
        name1.setText(name);
        tname1.setText(tchname);
        lecture1.setText(lecture);


        return convertView;
    }
}
