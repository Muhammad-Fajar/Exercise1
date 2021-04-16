package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnBelum;
    EditText edemail, edpassword;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBelum=findViewById(R.id.btBlm);
        btnLogin=findViewById(R.id.btSignIn);
        edemail=findViewById(R.id.edEmail);
        edpassword=findViewById(R.id.edPassword);

        btnBelum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), pendaftaran.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                String email = "admin@mail.com";
                String pass = "123";

                if (nama.isEmpty() || password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password wajib diisi!!",
                            Toast.LENGTH_LONG);
                    t.show();
                } else {
                    if (nama.equals(email) && password.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login sukses",
                                Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                        i.putExtras(b);

                        startActivity(i);
                    } else{
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login gagal",
                                Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }
}