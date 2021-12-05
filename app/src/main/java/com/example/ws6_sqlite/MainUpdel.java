package com.example.ws6_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Saccesoris;
    private EditText Enama, Eaccesoris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Saccesoris = i.getStringExtra("Iaccesoris");

        Enama = (EditText) findViewById(R.id.updel_nama);
        Eaccesoris = (EditText) findViewById(R.id.updel_accesoris);

        Enama.setText(Snama);
        Eaccesoris.setText(Saccesoris);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Saccesoris = String.valueOf(Eaccesoris.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Saccesoris.equals("")){
                    Eaccesoris.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi accesoris",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdatePemain(new Pemain(Sid, Snama, Saccesoris));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePemain(new Pemain(Sid, Snama, Saccesoris));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
