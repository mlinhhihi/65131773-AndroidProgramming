package mlinh.edu.th8_tuychinhlv;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Tìm Listview
        ListView lvDSMonAN = (ListView) findViewById(R.id.lvDsMonAn);
        //Chuẩn bị dữ liệu
        ArrayList<MonAn> dsMonAN = new ArrayList<MonAn>();
        MonAn m1 = new MonAn("Cơm cà ri Heo/Gà chiên xù", 69000, "Mô tả ở đây", R.drawable.comcrheoga);
        dsMonAN.add(m1);
        dsMonAN.add(new MonAn("Cơm lươn Nhật Bản", 99000, "Mô tả ở đây", R.drawable.comluon));
        dsMonAN.add(new MonAn("Cuộn trứng Tamago", 38000, "Mô tả ở đây", R.drawable.cuontruongtmg));
        dsMonAN.add(new MonAn("MISO soup", 18000, "Mô tả ở đây", R.drawable.misosup));
        dsMonAN.add(new MonAn("UDON xào", 75000, "Mô tả ở đây", R.drawable.udonxao));

        //Tạo Adapter
        MonAnAdapter adapter = new MonAnAdapter(this, dsMonAN);
        lvDSMonAN.setAdapter(adapter);

        //bắt xử lý sự kiện
        lvDSMonAN.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //lấy phần tử được chọn
                MonAn monAnChon = dsMonAN.get(position);
                //làm gì đó, tùy bài
                Toast.makeText(MainActivity.this, monAnChon.getTenMonAn(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}