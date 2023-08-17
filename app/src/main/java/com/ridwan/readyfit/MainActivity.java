package com.ridwan.readyfit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button aboutBTN;
    Dialog mDialog;
    ListView listView;
    String mTitle [] = {"Latihan Awal","Latihan Tahap Menengah","Latihan Tahap AKhir","BMI Test","Resep Makanan Sehat"};
    String mDesc [] = {"Minggu Pertama","Minggu kedua","Minggu ketiga","Cek BMI anda","Resep Makanan Sehat Rendah Kalori"};
    int image[] = {R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.bm,R.drawable.whelp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        aboutBTN = findViewById(R.id.aboutBTN);
        mDialog = new Dialog(this);
        aboutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.setContentView(R.layout.activity_pop_push);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mDialog.show();
            }
        });

        myAdapter adapter = new myAdapter(this,mTitle,mDesc,image);
        listView.setAdapter(adapter );


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 ){
                    Intent i = new Intent(getApplicationContext(),SplashLat1.class);
                    startActivity(i);
                } if(position == 1 ){
                    Intent i = new Intent(getApplicationContext(),SplashLat2.class);
                    startActivity(i);
                } if(position == 2 ){
                    Intent i = new Intent(getApplicationContext(),SplashLat3.class);
                    startActivity(i);
                } if(position == 3 ){
                    Intent i = new Intent(getApplicationContext(),MainLatNaik.class);
                    startActivity(i);
                } if(position == 4 ){
                    Intent i = new Intent(getApplicationContext(),MainLatPush.class);
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
            super(c, R.layout.row , R.id.textview1 , title);
            this.context = c;
            this.rTitle = title;
            this.rDesc = desc;
            this.rImage = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row , parent, false);
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
