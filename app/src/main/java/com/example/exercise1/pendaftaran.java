package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class pendaftaran extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        edtNama.findViewById(R.id.edNama);
        edtAlamat.findViewById(R.id.edAlamat);
        edtEmail.findViewById(R.id.EdEmail);
        edtPassword.findViewById(R.id.edPass);
        edtrepass.findViewById(R.id.edrepass);
        btnSimpan.findViewById(R.id.btSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    Snackbar.make(view, "Wajib isi seluruh data!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil",
                                Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "Password dan Repassword harus sama!!",
                                Snackbar.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
}