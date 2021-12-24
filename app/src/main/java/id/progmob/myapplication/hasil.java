package id.progmob.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class hasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Intent intent = getIntent();
        //mengambil nilai dari intent
        String nim = intent.getStringExtra(MainActivity.edit_text_nim);
        //mengambil nilai yang diteruskan dari class mainactivity
        TextView printnim = (TextView)findViewById(R.id.nim);
        printnim.setText(nim);

        //mengambil nilai dari intent
        String nama = intent.getStringExtra(MainActivity.edit_text);
        //mengambil nilai yang diteruskan dari class mainactivity
        TextView printnama = (TextView)findViewById(R.id.name);
        printnama.setText(nama);
        //inisialisasi objek textview
        String jk = intent.getStringExtra(MainActivity.radio_button);
        //mengambil nilai yang diteruskan dari class mainactivity

        //menampilkan output nilai dari editext
        TextView printjk = (TextView)findViewById(R.id.gender);
        //inisialisasi objek textview
        printjk.setText(jk);

        //mengambil nilai dari intent
        String hobby = intent.getStringExtra(MainActivity.cek_box);
        //mengambil nilai yang diteruskan dari class mainactivity
        TextView printhobby = (TextView)findViewById(R.id.hobi);
        printhobby.setText(hobby);
        //inisialisasi objek textview

        //mengambil nilai dari intent
        String alamat = intent.getStringExtra(MainActivity.edit_text);
        //mengambil nilai yang diteruskan dari class mainactivity
        TextView printalamat = (TextView)findViewById(R.id.alamat);
        printalamat.setText(alamat);

        String umur = intent.getStringExtra(MainActivity.seek_bar);
        //mengambil nilai yang diteruskan dari class mainactivity
        TextView printumur = (TextView)findViewById(R.id.age);
        printumur.setText(umur);
        //inisialisasi objek textview

    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT).show();
    }

    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
    }

    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "On pause", Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "On stop", Toast.LENGTH_SHORT).show();
    }
}