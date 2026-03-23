package mlinh.edu.th7_listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        //Hiển thị dữ liệu lên listview
        //B1+: Cần có dữ liệu
        // ?? từ đâu có: từ cơ sở dữ liệu (sql, no-sql, xml, ...)
        //  ở bài này chúng ta hard-code (cho sẵn) dữ liệu trực tiếp
        //Cần biến phù hợp để chứa dữ liệu
        ArrayList<String> dsTenTinhThanhVN; //khai báo
        dsTenTinhThanhVN = new ArrayList<String>(); // tạo thể hiện cụ thể, xin mới
            //thêm dữ liệu ở đây (đúng ra phải đọc từ một nguồn - nhưng ta hard-code để demo)
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đồng Nai");
        dsTenTinhThanhVN.add("Khánh Hòa");
        dsTenTinhThanhVN.add("Bình Thuận");
        dsTenTinhThanhVN.add("Phú Yên");

        //B2. Tạo adapter
        ArrayAdapter<String> adapterTinhThanh; //Khai báo
        adapterTinhThanh = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dsTenTinhThanhVN
        );
        //B3: Gắn vào điều khiển hiển thị ListView
        // B3.1: Tìm
        ListView lvTenTinhThanh = findViewById(R.id.lvDSTinhThanh);
        //B3.2: Gắn
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
        //B3.3: Lắng nghe và xử lý sự kiện người dùng tương tác

    }
}