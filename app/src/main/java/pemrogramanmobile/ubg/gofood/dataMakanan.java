package pemrogramanmobile.ubg.gofood;

import java.util.ArrayList;

public class dataMakanan {
    private static String judul [] = {
            "Makanan 1", "Makanan 2", "Makanan 3", "Makanan 4", "Makanan 5"
    };
    private static String desc [] = {
            "Isi Paket (Ayam Goreng + Nasi}",
            "Isi Paket (Ayam Goreng + Nasi}",
            "Isi Paket (Ayam Goreng + Nasi}",
            "Nasi goreng Telur",
            "Soto Ayam"
    };
    private  static String harga[] = {
            "25.000", "27.000", "20.000", "19.000", "29.000"
    };
    private  static String hargaDiskon[] = {
            "22.000", "21.000", "18.000", "15.000", "23.000"
    };
    private static int gambar[]={
            R.drawable.makanan1,
            R.drawable.makanan2,
            R.drawable.makanan3,
            R.drawable.makanan4,
            R.drawable.makanan5,
    };

    static ArrayList<makanan>  getListData(){
        ArrayList<makanan> listMakanan = new ArrayList<>();
        for (int i = 0; i<judul.length; i++){
            makanan m = new makanan();
            m.setNama(judul[i]);
            m.setDesc(desc[i]);
            m.setHarga(harga[i]);
            m.setHarga_diskon(hargaDiskon[i]);
            m.setGambar(gambar[i]);
            listMakanan.add(m);
        }
        return listMakanan;
    }
}
