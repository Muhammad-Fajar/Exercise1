package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.view.MenuInflater;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;


public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;

    private ListViewAdapter adapter;

    String[] listNama;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();

    Intent intent;
    private View searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        listNama = new String[]{"Maman","Ilham","Jajang",
                "fikri", "Udin", "Intan", "Vina", "Gigi",
                "Vian", "Lutfi"};

        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();

        for(int i = 0; i < listNama.length; i++){

            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }

        adapter = new ListViewAdapter(this);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nama = classNamaArrayList.get(position).getName();

                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                pm.setOnMenuItemClickListener(Home_Activity.this);

                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}