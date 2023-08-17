package com.ridwan.readyfit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Resep_Activity extends Activity {
    final Context context = this;
    @Override


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView hdr = (ImageView) findViewById(R.id.hdr);
        TextView ftr = (TextView) findViewById(R.id.ftr);
        Button btn_malang = (Button) findViewById(R.id.btn_malang);
        Button btn_tlpenting = (Button) findViewById(R.id.btn_tlpenting);
        Button btn_tmpenting = (Button) findViewById(R.id.btn_tmpenting);
        Button btn_rsakit = (Button) findViewById(R.id.btn_rsakit);
        Button btn_pwisata = (Button) findViewById(R.id.btn_pwisata);

        hdr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi jika header di click
            }
        });


        btn_pwisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_tmpenting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });

        btn_tlpenting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi tombol telp penting
            }
        });

        btn_rsakit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi tombol RS
            }
        });

        btn_pwisata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi tombol Pariwisata
            }
        });




        ftr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi jika header di click
            }
        });
    }





    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("exit");
            //alertDialog.setIcon(R.drawable.appicon);

            alertDialog.setMessage("Do you really want to exit?");
            alertDialog.setButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    return;
                } });
            alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    return;
                }});
            alertDialog.show();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}