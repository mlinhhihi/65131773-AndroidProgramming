package thigk2.truongthimylinh.edu.thigk_65131773;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Cau2Fragment extends Fragment {

    ArrayList<String> dsTenTinhThanhVN;
    // TODO: Rename and change types and number of parameters
    public static Cau2Fragment newInstance(String param1, String param2) {
        Cau2Fragment fragment = new Cau2Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCau2 = inflater.inflate(R.layout.fragment_cau2, container, false);

        dsTenTinhThanhVN = new ArrayList<>();
        dsTenTinhThanhVN.add("Trương Thị Mỹ Linh");
        dsTenTinhThanhVN.add("TP Hồ Chí Minh");
        dsTenTinhThanhVN.add("Hải Dương");
        dsTenTinhThanhVN.add("Gia Lai");
        dsTenTinhThanhVN.add("Hải Phòng");
        dsTenTinhThanhVN.add("Đà Nẵng");
        dsTenTinhThanhVN.add("Cần Thơ");
        dsTenTinhThanhVN.add("Bà Rịa - Vũng Tàu");
        dsTenTinhThanhVN.add("Khánh Hòa");
        dsTenTinhThanhVN.add("Kiên Giang");

        // B2: Adapter
        ArrayAdapter<String> adapterTinhThanh = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                dsTenTinhThanhVN
        );

        // B3: ListView
        ListView lvTenTinhThanh = viewCau2.findViewById(R.id.lvDSTinhThanh);
        lvTenTinhThanh.setAdapter(adapterTinhThanh);

        // B4: Click item
        lvTenTinhThanh.setOnItemClickListener((parent, view, position, id) -> {
            String tenTinh = dsTenTinhThanhVN.get(position);
            Toast.makeText(getContext(), tenTinh, Toast.LENGTH_LONG).show();
        });
        return viewCau2;
    }
}