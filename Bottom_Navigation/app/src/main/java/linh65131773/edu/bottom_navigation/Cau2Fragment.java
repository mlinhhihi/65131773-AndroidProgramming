package linh65131773.edu.bottom_navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Cau2Fragment extends Fragment {


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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewCau2 = inflater.inflate(R.layout.fragment_cau2, container, false);
        //Tìm Listview
        ListView lvDSMonAN = viewCau2.findViewById(R.id.lvDsMonAn);
        //Chuẩn bị dữ liệu
        ArrayList<MonAn> dsMonAN = new ArrayList<MonAn>();
        MonAn m1 = new MonAn("Cơm cà ri Heo/Gà chiên xù", 69000, "Mô tả ở đây", R.drawable.comcrheoga);
        dsMonAN.add(m1);
        dsMonAN.add(new MonAn("Cơm lươn Nhật Bản", 99000, "Mô tả ở đây", R.drawable.comluon));
        dsMonAN.add(new MonAn("Cuộn trứng Tamago", 38000, "Mô tả ở đây", R.drawable.cuontruongtmg));
        dsMonAN.add(new MonAn("MISO soup", 18000, "Mô tả ở đây", R.drawable.misosup));
        dsMonAN.add(new MonAn("UDON xào", 75000, "Mô tả ở đây", R.drawable.udonxao));

        //Tạo Adapter
        MonAnAdapter adapter = new MonAnAdapter(viewCau2.getContext(), dsMonAN);
        lvDSMonAN.setAdapter(adapter);

        //bắt xử lý sự kiện
        lvDSMonAN.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //lấy phần tử được chọn
                MonAn monAnChon = dsMonAN.get(position);
                //làm gì đó, tùy bài
                Toast.makeText(getContext(), monAnChon.getTenMonAn(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewCau2;
    }

}