package com.example.otet.quizakbid;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

//class berdasarkan onClickListener
public class kuis extends Activity implements View.OnClickListener{

    //mendeklarasikan variabel di desain berdasarkan id dan bentuk implementsi

    TextView soal,skor,sisawaktu,pengguna;
    ImageView pilih_a,pilih_b,pilih_c,pilih_d,selesai;
    MediaPlayer klik;
    EditText login;
    Button btnlogin;



    //Membuat Array Pertanyaan
    String [] pertanyaan = {"1.Berapa fakultas di Universitas Semarang?",
                            "2.Apa warna jas Almamater Universitas Negeri Semarang?",
                            "3.Apa singkatan dari Unnes sendiri?",
                            "4.Unnes perguruan tinggi berwawasan?",
                            "5.Berapa jumlah prodi pada seluruh falkultas dan pascasarjana",
                             " "};

    //Jawaban dalam bentuk Array
    //================== Pilihan no 1 === Pilihan no 2 === Pilihan no 3 === Pilihan no 4 === Pilihan no 5============

    int [] pilihan_a = {R.drawable.asatu,R.drawable.adua,R.drawable.atiga,R.drawable.aempat,R.drawable.alima};
    int [] pilihan_b = {R.drawable.bsatu,R.drawable.bdua,R.drawable.btiga,R.drawable.bempat,R.drawable.blima};
    int [] pilihan_c = {R.drawable.csatu,R.drawable.cdua,R.drawable.ctiga,R.drawable.cempat,R.drawable.clima};
    int [] pilihan_d = {R.drawable.dsatu,R.drawable.ddua,R.drawable.dtiga,R.drawable.dempat,R.drawable.dlima};

    //Array Jawaban
    String [] jawaban = {"A","A","D","A","C"};

    //Variabel baru dengan kondisi default untuk proses logika di onCreate
    int indeks;
    int benar = 0;
    int menit=2,detik=59;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        //menyambungkan variabel berdasarkan ID di desain
        soal=(TextView)findViewById(R.id.soal);
        //untuk awal diset pada array 0 , jadi yang muncul pertama pertanyaan no 1
        soal.setText(pertanyaan[0]);

        //menyambungkan variabel berdasarkan ID di desain
        pilih_a=(ImageView)findViewById(R.id.jawaba);
        //untuk awal diset pada array 0 , jadi yang muncul pertama pilihan no 1
        pilih_a.setImageResource(pilihan_a[0]);
        //kondisi klik(sebagai tombol)
        pilih_a.setOnClickListener(this);

        pilih_b=(ImageView)findViewById(R.id.jawabb);
        pilih_b.setImageResource(pilihan_b[0]);
        pilih_b.setOnClickListener(this);

        pilih_c=(ImageView)findViewById(R.id.jawabc);
        pilih_c.setImageResource(pilihan_c[0]);
        pilih_c.setOnClickListener(this);

        pilih_d=(ImageView)findViewById(R.id.jawabd);
        pilih_d.setImageResource(pilihan_d[0]);
        pilih_d.setOnClickListener(this);

        selesai=(ImageView)findViewById(R.id.selesai);
        selesai.setOnClickListener(this);

        skor=(TextView)findViewById(R.id.skor);

        //timer
        sisawaktu=(TextView)findViewById(R.id.sisawaktu);

        //logika untuk membuat timer
        //memanggil CountDownTimer
        new CountDownTimer(100000000, 1000){

            //fungsi untuk detik
            public void onTick(long millisUntilFinished){

                detik-=1;

                //set timmer
                sisawaktu.setText(menit +" : "+ detik);

                //kondisi timer habis
                if(menit==0 && detik==0){
                    //skor,tbselesai akan kelihatan
                    skor.setText("Nilai ="+ String.valueOf(benar*2));
                    skor.setVisibility(View.VISIBLE);
                    selesai.setVisibility(View.VISIBLE);

                    //timer,soal,tbpilihan akan tersebunyi
                    sisawaktu.setVisibility(View.INVISIBLE);
                    soal.setVisibility(View.INVISIBLE);
                    pilih_a.setVisibility(View.INVISIBLE);
                    pilih_b.setVisibility(View.INVISIBLE);
                    pilih_c.setVisibility(View.INVISIBLE);
                    pilih_d.setVisibility(View.INVISIBLE);
                }
                //kondisi detik == -1
                if(detik == -1){
                    //menit akn berkurang 1
                    menit-=1;
                    //detik menjadi 59
                    detik+=60;
                    //set timer
                    sisawaktu.setText(menit+" : "+detik);
                }
            }

            public  void onFinish(){

            }
        }.start(); //menjalankan fungsi timer

        //menyambungkan file sound/suara
        klik = MediaPlayer.create(this,R.raw.klik);

        pengguna=(TextView)findViewById(R.id.pengguna);
        login=(EditText) findViewById(R.id.login);

        btnlogin=(Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);
    }

    //mendeklarasikan tombol dengan fungsi click
    @Override
    public void onClick(View v) {

        //ketika diklik sound/atau suara akan aktif
        klik.start();

        //apabila pilih A
        if(v ==  pilih_a){
            //jawaban benar
            if(jawaban[indeks].equals("A")){
                //nilai tambah 1
                benar++;
                //fungsi selanjutnya
                next();
            }else{
                //fungsi selanjutnya
                next();
            }
        }else if (v == pilih_b) {
                if (jawaban[indeks].equals("B")) {
                    benar++;
                    next();
                } else {
                    next();
                }
            } else if (v == pilih_c) {
                if (jawaban[indeks].equals("C")) {
                    benar++;
                    next();
                } else {
                    next();
                }
            } else if (v == pilih_d) {
                if (jawaban[indeks].equals("D")) {
                    benar++;
                    next();
                } else {
                    next();
                }
            } else if (v == selesai) {
                finish();

            //apabila klik btnlogin
            } else if(v == btnlogin){

                //set nama
                pengguna.setText(login.getText().toString());

                //property login dan btnlogin akan hilang
                login.setVisibility(View.INVISIBLE);
                btnlogin.setVisibility(View.INVISIBLE);

                //timer, soal, dan pilihan akan kelihatan
                sisawaktu.setVisibility(View.VISIBLE);
                soal.setVisibility(View.VISIBLE);
                pilih_a.setVisibility(View.VISIBLE);
                pilih_b.setVisibility(View.VISIBLE);
                pilih_c.setVisibility(View.VISIBLE);
                pilih_d.setVisibility(View.VISIBLE);

                //set detik
                detik=(detik*0)+59;

            }
        }



    //fungsi next
    private void next() {
        //kondisi apabila soal sudah selesai,
        //indeks == 4, karena soal ada 5, dihitung mulai 0,1,2,3,4
        if(indeks==4){
            skor.setText("Nilai ="+ String.valueOf(benar*2));
            skor.setVisibility(View.VISIBLE);
            selesai.setVisibility(View.VISIBLE);
            sisawaktu.setVisibility(View.INVISIBLE);
            soal.setVisibility(View.INVISIBLE);
            pilih_a.setVisibility(View.INVISIBLE);
            pilih_b.setVisibility(View.INVISIBLE);
            pilih_c.setVisibility(View.INVISIBLE);
            pilih_d.setVisibility(View.INVISIBLE);
            menit+=2;
        }else {
            indeks++;
            soal.setText(pertanyaan[indeks]);
            pilih_a.setImageResource(pilihan_a[indeks]);
            pilih_b.setImageResource(pilihan_b[indeks]);
            pilih_c.setImageResource(pilihan_c[indeks]);
            pilih_d.setImageResource(pilihan_d[indeks]);
        }
    }


}
