package com.example.otet.quizakbid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//class berdasarkan onClickListener
public class MenuApp extends Activity implements View.OnClickListener {

    //mendeklarasikan variabel di desain berdasarkan id
    ImageView btnmulai;
    ImageView btnkeluar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);

        //properti yg ditampilkan di halaman
        btnmulai = (ImageView)findViewById(R.id.btnmulai);
        btnmulai.setOnClickListener(this);
        btnkeluar = (ImageView)findViewById(R.id.btnkeluar);
        btnkeluar.setOnClickListener(this);
    }

    //mendeklarasikan tombol dengan fungsi click
    @Override
    public void onClick(View v){

        //misal diclik btnmulai
        if(v==btnmulai){
            //berpindah dihalaman kuis
            Intent kuis = new Intent(MenuApp.this, kuis.class);
            startActivity(kuis);
        }
        //diklik btnkeluar
        if(v==btnkeluar){
            //keluar dari aplikasi
            finish();
        }
    }
}
