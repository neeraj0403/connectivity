package com.codingblocks.newfirebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class newfireadapter extends RecyclerView.Adapter<newfireadapter.ViewHolder> {

    public newfireadapter(ArrayList<details> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public  ArrayList<details> list;
    Context context;

    public newfireadapter(ArrayList<details> list) {
        this.list=list;

    }

    @NonNull
    @Override
    public newfireadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("in", " i am in onCreateViewHolder of adapter");
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_firebase,viewGroup,false);
        context=viewGroup.getContext();
        return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull newfireadapter.ViewHolder viewHolder, int i) {
        Log.d("in", " i am in onbindviewholder of adapter");
  String name=list.get(i).getName();
  String age=list.get(i).getAge();
  String contact=list.get(i).getPhone();
  viewHolder.setdata(name,age,contact);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
TextView name,age,phone;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
            phone=itemView.findViewById(R.id.phone);
            context = itemView.getContext() ;

        }

        public void setdata(String nname, String aage, String ccontact) {
            Log.d("in", " i am in set data");
         name.setText(nname);
         age.setText(aage);
         phone.setText(ccontact);


        }
    }
}
