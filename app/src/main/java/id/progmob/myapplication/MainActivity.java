package id.progmob.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int pval = 0;
    public static final String edit_text_nim = "id.andikawidiantr.latihan2.textnim";
    public static final String edit_text = "id.andikawidiantr.latihan2.text";
    public static final String cek_box = "id.andikawidiantr.latihan2.cek";
    public static final String radio_button = "id.andikawidiantr.latihan2.radio";
    public static final String seek_bar = "id.andikawidiantr.latihan2.seek";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nim = (EditText)findViewById(R.id.isinim);
        EditText nama = (EditText)findViewById(R.id.isinama);
        EditText alamat = (EditText)findViewById(R.id.isialamat);
        RadioGroup jk = (RadioGroup)findViewById(R.id.isijeniskelamin);
        CheckBox hobby1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox hobby2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox hobby3 = (CheckBox) findViewById(R.id.checkBox3);
        SeekBar sBar = (SeekBar) findViewById(R.id.umur);
        TextView angka = (TextView) findViewById(R.id.angkaumur);

        final Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {
                nim.setText(null);
                nama.setText(null);
                alamat.setText(null);
                jk.clearCheck();
                hobby1.setChecked(false);
                hobby2.setChecked(false);
                hobby3.setChecked(false);
                sBar.setProgress(0);
                angka.setText(null);

            }
        });

//        SeekBar sBar = (SeekBar) findViewById(R.id.umur);

        angka.setText(sBar.getProgress() + "/" + sBar.getMax());
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                angka.setText(pval + "/" + seekBar.getMax());
            }
        });

        final Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {

                Intent intent = new Intent(MainActivity.this,hasil.class);
                //inisialisasi intent

                EditText nimuser = (EditText)findViewById(R.id.isinim);
                //inisialisasi editext
                String usernim = nimuser.getText().toString();
                //mengambil nilai string text berdasarkan input di editext
                intent.putExtra(edit_text_nim,usernim);

                EditText namauser = (EditText)findViewById(R.id.isinama);
                //inisialisasi editext
                String username = namauser.getText().toString();
                //mengambil nilai string text berdasarkan input di editext
                intent.putExtra(edit_text,username);
                //intent akan mempassing membawa atau meneruskan nilai yang ada di editext dengan tipe data key value

                RadioGroup jeniskelamin = (RadioGroup) findViewById(R.id.isijeniskelamin);
                //inisialisasi editext
                RadioButton selectedRadioButton  = (RadioButton)findViewById(jeniskelamin.getCheckedRadioButtonId());
                String yourVote = selectedRadioButton.getText().toString();
                //mengambil nilai string text berdasarkan input di editext
                intent.putExtra(radio_button,yourVote);
                //intent akan mempassing membawa atau meneruskan nilai yang ada di editext dengan tipe data key value

                CheckBox hobby1 = (CheckBox) findViewById(R.id.checkBox);
                CheckBox hobby2 = (CheckBox) findViewById(R.id.checkBox2);
                CheckBox hobby3 = (CheckBox) findViewById(R.id.checkBox3);

                //inisialisasi editext
                String msg="";
                if(hobby1.isChecked())
                    msg = msg + " Makan ";
                if(hobby2.isChecked())
                    msg = msg + " Belajar ";
                if(hobby3.isChecked())
                    msg = msg + " Todur ";
                //mengambil nilai string text berdasarkan input di editext
                intent.putExtra(cek_box,msg);
                //intent akan mempassing membawa atau meneruskan nilai yang ada di editext dengan tipe data key value

                //inisialisasi editext
                String umur1 = angka.getText().toString();
                //mengambil nilai string text berdasarkan input di editext
                intent.putExtra(seek_bar,umur1);

                startActivity(intent);
                //menjalankan dan mememulai intent
            }
        });
    }
}