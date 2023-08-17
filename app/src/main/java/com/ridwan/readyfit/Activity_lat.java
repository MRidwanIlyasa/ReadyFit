package com.ridwan.readyfit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Activity_lat extends AppCompatActivity {
    ListView listView1;

    String mTitle [] = {" Push Up "," Crunch Perut "," Lompat Jongkok "," Angkat Kaki ","Plank"};
    String mDesc [] = {"x5 - x11 (Bertambah x1 setiap hari)","x5 - x11 (Bertambah x1 setiap hari)","x5 - x11 (Bertambah x1 setiap hari)"
            ,"x10 - x16 (Bertambah x1 setiap hari)","20 detik"};
    int image[] = {R.drawable.preview,R.drawable.preview,R.drawable.preview,R.drawable.preview,R.drawable.preview};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lat);
        listView1 = findViewById(R.id.listview1);

        myAdapter adapter = new myAdapter(this,mTitle,mDesc,image);
        listView1.setAdapter(adapter );

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 ){
                    Intent i = new Intent(getApplicationContext(),MainLatPush.class);
                    startActivity(i);
                } if(position == 1 ){
                    Intent i = new Intent(getApplicationContext(),MainLatCrunch.class);
                    startActivity(i);
                } if(position == 2 ){
                    Intent i = new Intent(getApplicationContext(),MainLatLomjong.class);
                    startActivity(i);
                } if(position == 3 ){
                    Intent i = new Intent(getApplicationContext(),MainLatNaik.class);
                    startActivity(i);
                } if(position == 4 ){
                    Intent i = new Intent(getApplicationContext(),MainLatPlank.class);
                    startActivity(i);
                }
            }
        });
    }
    class myAdapter extends ArrayAdapter<String>{
        Context context ;
        String rTitle[];
        String rDesc[];
        int rImage[];

        myAdapter (Context c, String title[] , String desc[] , int images[]){
            super(c, R.layout.row_lat , R.id.textview1 , title);
            this.context = c;
            this.rTitle = title;
            this.rDesc = desc;
            this.rImage = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_lat , parent, false);
            ImageView imagess = row.findViewById(R.id.Image);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView mydesc = row.findViewById(R.id.textview2);

            imagess.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            mydesc.setText(rDesc[position]);

            return row;
        }
    }
}
