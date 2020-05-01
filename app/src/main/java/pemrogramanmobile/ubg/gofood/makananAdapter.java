package pemrogramanmobile.ubg.gofood;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class makananAdapter extends RecyclerView.Adapter<makananAdapter.ListViewHolder> {
    private ArrayList<makanan> listMakanan;

    public makananAdapter(ArrayList<makanan> list){
        this.listMakanan = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        makanan m = listMakanan.get(position);
        Glide.with(holder.itemView).load(m.getGambar()).apply(new RequestOptions().override(100,100)).into(holder.gambar);
        holder.hargaDiskon.setText(m.getHarga_diskon());
        holder.harga.setText(m.getHarga());
        holder.title.setText(m.getNama());
        holder.desc.setText(m.getDesc());
        holder.harga.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDialog detail = new BottomSheetDialog(holder.itemView.getContext());

                View view = LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.detail, null);
                TextView judul = view.findViewById(R.id.detail_judul);
                TextView desc = view.findViewById(R.id.detail_desc);
                TextView harga = view.findViewById(R.id.detail_harga);
                TextView hargaDiskon = view.findViewById(R.id.detail_hargaDiskon);
                ImageView gambar = view.findViewById(R.id.detail_img);

                Glide.with(holder.itemView).load(listMakanan.get(holder.getAdapterPosition()).getGambar()).apply(new RequestOptions()).into(gambar);
                judul.setText(listMakanan.get(holder.getAdapterPosition()).getNama());
                desc.setText(listMakanan.get(holder.getAdapterPosition()).getDesc());
                harga.setText(listMakanan.get(holder.getAdapterPosition()).getHarga());
                hargaDiskon.setText(listMakanan.get(holder.getAdapterPosition()).getHarga_diskon());
                harga.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

                detail.setContentView(view);
                detail.show();
//                Toast.makeText(holder.itemView.getContext(), "Tambahkan"+listMakanan.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView title, desc, harga, hargaDiskon;
        ImageView gambar;
        Button btnTambah;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            gambar = itemView.findViewById(R.id.image_item);
            title = itemView.findViewById(R.id.title_item);
            desc = itemView.findViewById(R.id.desc_item);
            harga = itemView.findViewById(R.id.harga_item);
            hargaDiskon = itemView.findViewById(R.id.hargadiskon_item);
            btnTambah = itemView.findViewById(R.id.btn_tambah);
        }
    }
}
