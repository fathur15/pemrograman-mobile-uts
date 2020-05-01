package pemrogramanmobile.ubg.gofood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private RecyclerView.Adapter recycleView_Adapter;
    private RecyclerView.LayoutManager recycleView_LayoutMangaer;
    private ArrayList<makanan> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Menu diskon");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recycleView = findViewById(R.id.recyclerview);

        list.addAll(dataMakanan.getListData());

        initRecyclerView();
    }

    public void showDetail(){
        BottomSheetDialog detail = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.detail, null);

        detail.setContentView(view);
        detail.show();
    }

    private void initRecyclerView(){
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        makananAdapter adapter = new makananAdapter(list);
        recycleView.setAdapter(adapter);
    }
}
