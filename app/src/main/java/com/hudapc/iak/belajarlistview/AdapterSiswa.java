package com.hudapc.iak.belajarlistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by HUDA on 12/08/2017.
 */

// TODO 9.1 membuat class turunan (Custom Adapter) dari class ArrayAdapter dengan menggunakan data dari class Siswa.
public class AdapterSiswa extends ArrayAdapter<Siswa>
{
    // TODO 9.2 membuat constructor
    // constructor adalah method yang dipanggil ketika sebuah objek dibuat dengan kata kunci new.
    // constructor memiliki ciri
    //      public nama_class( parameter )
    // parameter pada constructor sifatnya opsional, boleh ada boleh tidak.
    // kalau constructor memiliki parameter, maka saat dipanggil harus memberikan paramater ke constructor itu.
    // jika tidak, maka jangan memasukkan parameter apapun saat memanggil constructor itu.
    // pada kasus ini, class turunan dari ArrayAdapter diharuskan membuat constructor, karena harus memanggil constructor
    // dari kelas induk (parent).
    public AdapterSiswa(@NonNull Context context,
                        @NonNull List<Siswa> objects)
    {
        // constructor class turunan ini hanya memerlukan 2 parameter
        // Context dan data siswa berupa objek List (ArrayList merupakan turunan dari List)

        super(context,
                0,
                objects);
        // di dalam constructor dari class turunan ArrayAdapter harus memanggil constructor parent classnya
        // dengan menggunakan method supper().
        // paramater yang dimasukkan yaitu Context, Layout, dan data berupa objek List
        // parameter Context untuk method super kitaberikan dari paramater constructor.
        // parameter Layout diberikan nilai 0, karena kita akan menggunakan layout batan kita sendiri.
        // parameter List kita berikan dari parameter constructor.
    }

    // TODO 9.3 membuat method getView
    // method ini harus dibuat untuk memberikan tampilan data ke dalam ListView
    @NonNull
    @Override
    public View getView(
            int position,
            @Nullable View convertView,
            @NonNull ViewGroup parent)
    {
        // buat objek View dan berikan dengan objek dari parameter
        View tmpV = convertView;
        // pastikan apakah objek View tadi masih null (kosong) atau tidak.
        if (tmpV == null)
        {
            // jika masih kosong, load file layout yang akan dipakai.
            // LayoutInflater merupakan objek yang digunakan untuk mengambil layout ke bentuk objek
            LayoutInflater inflatter = LayoutInflater.from(getContext());
            // gunakan method inflate() dari objek LayoutInflater untuk mengambil Layout yang akan dipakai.
            tmpV = inflatter.inflate(R.layout.lv_layout_siswa, null);
            // sampai di sini, objek View sudah terisi sesuai dengan layout yang digunakan
        }

        // ambil data Siswa sesuai dengan posisi yang diminta sistem.
        Siswa tmpSiswa = getItem(position);

        // buat objek Widget sesuai dengan yang ada pada layout, dan berikan objeknya sesuai dengan id.
        TextView tvNoUrut = (TextView) tmpV.findViewById(R.id.tvNoUrut);
        TextView tvNama = (TextView) tmpV.findViewById(R.id.tvNama);
        TextView tvGender = (TextView) tmpV.findViewById(R.id.tvGender);

        // set text sesuai dengan apa yang dimiliki oleh objek Siswa
        tvNoUrut.setText(String.valueOf(tmpSiswa.getNoUrut()));
        tvNama.setText(tmpSiswa.getNamaSiswa());
        if(tmpSiswa.getGender())
        {
            tvGender.setText("P");
        }
        else
        {
            tvGender.setText("W");
        }

        // terakhir berikan objek view ke sistem, yang nantinya akan ditampilkan ke ListView.
        return tmpV;
    }
}
