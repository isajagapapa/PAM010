package com.example.aplikasipertama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
//    Deklarasi variabel dengan jenis data context
    Context mContext;

//    Deklarasi variabel dengan jenis data layout inflater
    LayoutInflater inflater;

//    Deklarasi variabel dengan jenis data arrayList
    private ArrayList<ClassNama> arraylist;

    public ListViewAdapter(Context context){
//        Memberi nilai mContext dengan context
        mContext = context;

//        Mengatur Layout inflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

//        Memberikan nilai arrayList dari class ClassNama
        this.arraylist = new ArrayList<ClassNama>();

//        Menambahkan semua element ke arrayList
        this.arraylist.addAll(Home_Activity.classNamaArrayList);
    }

    public class ViewHolder{
//        Mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }
    @Override

//    Fungsi untuk mengembalikan jumlah item yang akan ditampilkan dalam list
    public int getCount() {
//        Mengembalikan nilai berupa jumlah data array data
        return Home_Activity.classNamaArrayList.size();
    }

//    Fungsi ini digunakan untuk mendapatkan data item yang terkait
//    dengan posisi tertentu dalam kumpulan data untuk mendapatkan
//    data yang sesuai dari lokasi tertentu dalam pengumpulan
//    data item
    @Override
    public Object getItem(int i) {
        return Home_Activity.classNamaArrayList.get(i);
    }

//    Fungsi untuk mengembalikan "nilai" dari posisi item ke adaptor
    @Override
    public long getItemId(int i) {
        return i;
    }

//    Fungsi ini secara otomatis dipanggil ketika tampilan
//    item list siap untuk ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        deklarasikan variabel dengan jenis data VieHolder
        final ViewHolder holder;

//        Membuat kondisi apakah view null atau tidak
        if (view == null){

//            membuat objek view holder
            holder = new ViewHolder();

//            Mengatur Layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

//            set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

//            Menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);
        }else {
//            Mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
//        set item ke TextView
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

//        Mengembalikan nilai ke cariabel view
        return view;
    }
}
