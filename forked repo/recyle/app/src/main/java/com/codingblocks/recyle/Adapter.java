package com.codingblocks.recyle;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {


    private List<name> list ;

    public Adapter(List<name> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false) ;
        return  new viewholder(view) ;
     }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewholder viewholder, int i) {
        String fname = list.get(i).getFname() ;
        String lname = list.get(i).getLname() ;
        viewholder.setData(fname,lname);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder
    {
        TextView fname ;
        TextView Lname ;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            fname = itemView.findViewById(R.id.firstname) ;
            Lname = itemView.findViewById(R.id.lastname) ;
        }
        public void setData(String namef,String namel)
        {
            fname.setText(namef);
            Lname.setText(namel);
        }
    }
}
