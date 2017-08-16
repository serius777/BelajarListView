package com.hudapc.iak.belajarlistview;

import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // TODO 2 buat objek untuk widget listView pada class
    ListView lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 3 berikan objek ListView yang dibuat dengan ListView yang ada di layout
        lvData = (ListView) findViewById(R.id.lvData);

        // TODO 4 buat data source yang akan ditampilkan pada ListView
        // TODO 4.1 menggunakan array String
        // jumlah data tetap, tidak bisa ditambah atau dikurangi
        String pesertaIak[] = new String[12];
        pesertaIak[0] = "Maylia";
        pesertaIak[1] = "Edy";
        pesertaIak[2] = "Purnama";
        pesertaIak[3] = "Satria";
        pesertaIak[4] = "Bayu";
        pesertaIak[5] = "Bratha";
        pesertaIak[6] = "Adhika";
        pesertaIak[7] = "Dharma";
        pesertaIak[8] = "Praba";
        pesertaIak[9] = "Ayu";
        pesertaIak[10] = "Gunawan";
        pesertaIak[11] = "Ria";
        // TODO 4.2 menggunakan ArrayList
        // Jumlah data bisa berubah2, dapat dikurangi, atau ditambah seiring jalnnya program.
        // untuk tambah data gunakan method add(data_yang_dimasukkan).
        // untuk menghapus data gunakan method remove(no_urut_data_yang dihapus).
        ArrayList<String> pesertaIAK = new ArrayList<>(); // jumlah data 0
        pesertaIAK.add("Maylia"); // jumlah data 1, no urut 0.
        pesertaIAK.add("Edy"); // jumlah data 2, no urut 1.
        pesertaIAK.add("Purnama"); // jumlah data 3, no urut 2.
        pesertaIAK.add("Satria"); // jumlah data 4, no urut 3.
        pesertaIAK.add("Bayu"); // jumlah data 5, no urut 4.
        pesertaIAK.add("Bratha"); // jumlah data 6, no urut 5.
        pesertaIAK.add("Adhika"); // jumlah data 7, no urut 6.
        pesertaIAK.add("Dharma"); // jumlah data 8, no urut 7.
        pesertaIAK.add("Praba"); // jumlah data 9, no urut 8.
        pesertaIAK.add("Ayu"); // jumlah data 10, no urut 9.
        pesertaIAK.add("Gunawan"); // jumlah data 11, no urut 10.
        pesertaIAK.add("Ria"); // jumlah data 12, no urut 11.
        pesertaIAK.add("serius"); // jumlah data 13, no urut 12.
        pesertaIAK.add("4g"); // jumlah data 14, no urut 13.
        // coba hapus data ke 13 (index 12)
        pesertaIAK.remove(12);
        //j umlah data yang baru 13. data yang sebelumnya berada setelah data ke 13 (index 12),
        // akan dimajukan 1 angka (data ke 14 jadi 13, 15 jadi 14, dst)

        // TODO 5 buat adapter untuk memasukkan data source ke tampilan.
        // Object dari Class ArrayAdapter berguna untuk memasukkan data ke dalam
        // tampilan (Layout) yang akan dimasukkan ke dalam ListView.
        // android menyediakan template layout yang bisa digunakan untuk menampilkan data ke layout, yaitu
        // dengan menggunakan
        //      R.layout.support_simple_spinner_dropdown_item
        // tetapi template itu haynya bisa digunakan untuk menampilkan data objek String.
        // jika ingin menggunakan layout buatan kita sendiri atau menggunakan data dari objek lain,
        // kita harus membuat class anak atau turunan dari class ArrayAdapter (Custom Adapter).
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                pesertaIAK);
        // bisa gunakan data source dari array (pesertaIak) atau arayList (pesertaIAK) silahkan dicoba.

        // lvData.setAdapter(adapter);
        // set adapter yang sudah dibuat ke dalam objek ListView dengan method setAdapter(adapter_yang_dibuat).
        // TODO 6 dasar listView selesai. cobajalankan aplikasi.

        // sebelum itu comment perintah untuk setAdapter terlebih dahulu.
        // TODO 7 buat class Siswa
        // bisa dilihat dari class Siswa pada projek ini sebagai contoh.

        // TODO 8 buat layout untuk 1 data siswa yang akan digunakan oleh Custom Adapter.
        // contoh bisa dilihat pada layout lv_layout_siswa

        // TODO 9 buat class turunan dari class ArrayAdapter
        // class turunan ini kita gunakan untuk memasukkan objek data siswa ke dalam Layout yang kita inginkan
        // (Custom Adapter)
        // contoh bisa dilihat pada class AdapterSiswa

        // TODO 10 buat data source dari untuk objek Siswa dengan menggunakan ArrayList
        ArrayList<Siswa> dataSiswa = new ArrayList<>();

        for(int i = 0; i < 30; i++)
        {
            // kita buat data pakai perulangan biar tidak banyak nulis
            Siswa tmpSiswa = new Siswa();
            tmpSiswa.setNoUrut(i + 1);
            tmpSiswa.setNamaSiswa("Siswa " + i);

            boolean gender = (i % 2 == 0);

            tmpSiswa.setGender(gender);
            dataSiswa.add(tmpSiswa);
        }

        // TODO 11 buat adapter dari class Cutom Adapter yag sudah dibuat.
        // masukkan this sebagai parameter Context, dan data source sebagai paramaeter List.
        AdapterSiswa customAdapter = new AdapterSiswa(this, dataSiswa);

        // TODO 12 set adapter kedalam ListView
        lvData.setAdapter(customAdapter);
        // jalankan aplikasi.
    }
}
