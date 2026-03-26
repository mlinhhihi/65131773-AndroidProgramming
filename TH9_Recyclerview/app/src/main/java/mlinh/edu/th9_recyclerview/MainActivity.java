package mlinh.edu.th9_recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recylerViewtDatas;
    RecyclerView recyclerViewLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //3
        recylerViewtDatas = getDataForRecyclerView();
        //4
        recyclerViewLandscape =findViewById(R.id.recyclerLand);
        //5
            //chiều dọc
//                    RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
//                    recyclerViewLandscape.setLayoutManager(layoutLinear);
            //chiều ngang
//            RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
//            recyclerViewLandscape.setLayoutManager(layoutLinearHorizonal);
            //lưới
        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(this, 1);
        recyclerViewLandscape.setLayoutManager(layoutGrid);

        //6
        landScapeAdapter = new LandScapeAdapter(this, recylerViewtDatas);
        //7
        recyclerViewLandscape.setAdapter(landScapeAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
    ArrayList<LandScape> getDataForRecyclerView() {
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("cantho", "địa điểm check in Cần Thơ");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(new LandScape("hoguom", "Hồ Gươm Hà Nội"));
        dsDuLieu.add(new LandScape("nhatrang", "Quảng Trường 2-4 Nha Trang"));
        dsDuLieu.add(new LandScape("danang", "Cầu Rồng Đà Nẵng"));
    return dsDuLieu;
    }
}

























