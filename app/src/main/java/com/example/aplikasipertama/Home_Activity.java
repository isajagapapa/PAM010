package com.example.aplikasipertama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

//    Deklarasikan variabel dengan jenis data listview
    private ListView list;

//    Memanggil class ListViewAdapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

//    Deklarasikan array untuk menyimpan nama
    String[] listNama;

//    Memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

//    Membuat objek bundle
    Bundle bundle = new Bundle();

//    Membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

//        Menyimpan nama didalam array listNama
        listNama = new String[]{"Fais", "Fidi", "Ilham", "Kurniawan", "Baim", "Aldi", "Taher","Nissa", "Riziex", "Bening"};

        list = findViewById(R.id.listKontak);

//        Membuat objek dari class ClassNama menjadi arrayList
        classNamaArrayList = new ArrayList<>();

//        Membaca seluruh data pada array ListNama
        for (int i = 0; i < listNama.length; i++){
//            Membuat objek class nama da
            ClassNama classNama = new ClassNama(listNama[i]);
//            Binds strings ke array
            classNamaArrayList.add(classNama);
        }

//        Membuat objek dari listViewAdapter
        adapter = new ListViewAdapter(this);

//        Binds adapter ke ListView
        list.setAdapter(adapter);

//        Membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

//                Memasukkan value dari variabe nama dengan kunci "a"
//                dan dimasukkan kedalam bundle
                bundle.putString("a",nama.trim());

//                Membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

//                Membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);

//                Menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

//                Menampilkan popup menu
                pm.show();
            }
        });
    }

//    Event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}