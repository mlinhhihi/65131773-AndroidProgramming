package linh65131773.edu.bottom_navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Cau3Fragment extends Fragment {

    //khai báo các biến toàn cục
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recylerViewtDatas;
    //khai báo các biến đại diện cho các view tương tác
    RecyclerView recyclerViewLandscape;


    public Cau3Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Cau3Fragment newInstance(String param1, String param2) {
        Cau3Fragment fragment = new Cau3Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recylerViewtDatas = new ArrayList<>();
        recylerViewtDatas.add(new LandScape("cantho", "địa điểm check in Cần Thơ"));
        recylerViewtDatas.add(new LandScape("hoguom", "Hồ Gươm Hà Nội"));
        recylerViewtDatas.add(new LandScape("nhatrang", "Quảng Trường 2-4 Nha Trang"));
        recylerViewtDatas.add(new LandScape("danang", "Cầu Rồng Đà Nẵng"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewCau3 = inflater.inflate(R.layout.fragment_cau3, container, false);
        //Tìm điều khiển  recycler
        recyclerViewLandscape = viewCau3.findViewById(R.id.rycCau3);
        //tạo layout manager
        //chiều dọc
//        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(viewCau3.getContext());
//        recyclerViewLandscape.setLayoutManager(layoutLinear);
        //chiều ngang
//            RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
//            recyclerViewLandscape.setLayoutManager(layoutLinearHorizonal);
//        //lưới
        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(viewCau3.getContext(), 2);
        recyclerViewLandscape.setLayoutManager(layoutGrid);

        //tạo adapter gắn vào nguồn dữ liệu
        landScapeAdapter = new LandScapeAdapter(viewCau3.getContext(), recylerViewtDatas);
        //gắn adapter vào recycler
        recyclerViewLandscape.setAdapter(landScapeAdapter);

        return viewCau3;
    }
}