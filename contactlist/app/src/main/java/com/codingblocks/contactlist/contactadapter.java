package com.codingblocks.contactlist;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class contactadapter extends RecyclerView.Adapter<contactadapter.viewHolder>

{
  Context context ;
    ImageButton calls, msgs;

    public contactadapter(Context context, ImageButton calls, ImageButton msgs, TextView name, TextView phone, List<contactinfo> list) {
        this.context = context;

        this.name = name;
        this.phone = phone;
        this.list = list;
    }

    TextView name, phone;
    RelativeLayout layout;
 private List<contactinfo> list;

    public contactadapter(List<contactinfo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public contactadapter.viewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contactview,viewGroup,false);
        context = viewGroup.getContext() ;

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull contactadapter.viewHolder viewHolder, int i) {
String name=list.get(i).getName();
String number=list.get(i).getNumber();
String image=list.get(i).getLink();
       viewHolder.setData(name,number,image);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }
     class viewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener
     {  CircleImageView image;
         TextView name,number;
       ImageButton call,msg
;

         public viewHolder(@NonNull View itemView) {
             super(itemView);
  image=(itemView).findViewById(R.id.image);
  name=(itemView).findViewById(R.id.name);
            // phone = (itemView).findViewById(R.id.number);
             name = (itemView).findViewById(R.id.name);
            number=(itemView).findViewById(R.id.number);
             call=(itemView).findViewById(R.id.call);
             msg=(itemView).findViewById(R.id.msg);
             call.setOnClickListener(this);
             msg.setOnClickListener(this);
             context = itemView.getContext() ;
         }

         public void setData(String mname, String mnumber, String mimage) {
             name.setText(mname);
             number.setText(mnumber);
             Picasso.with(context).load(mimage).into(image);
         }

         @Override
         public void onClick(View v) {
             String input=number.getText().toString();
             Intent intent =new Intent();

             switch (v.getId()) {
                 case (R.id.call):

                     int perm = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE);
                     if (perm == PackageManager.PERMISSION_GRANTED) {
                         if(!input.startsWith("tel:"))
                         {
                          input="tel:"+input;


                         }

                             intent.setAction(Intent.ACTION_CALL);
                         intent.setData(Uri.parse(input));

                         context.startActivity(intent);


                     }
                     else
                     {
                         ActivityCompat.requestPermissions((AppCompatActivity)context,new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.SEND_SMS},120);
                     }
                     break;
                 case(R.id.msg):
                             {
                                 Intent intent1=new Intent(context,inbox.class);
                                 intent1.putExtra("name",number.getText().toString());
                                 context.startActivity(intent1);



                             }
                 case(R.id.relativeLayout):
                 {
                     layout.setOnLongClickListener(new View.OnLongClickListener() {
                         @Override
                         public boolean onLongClick(View v) {
                             Intent intent =new Intent(context,Edit_details.class);


                             return  true;
                         }
                     });





                 }

             }

         }

     }

}
