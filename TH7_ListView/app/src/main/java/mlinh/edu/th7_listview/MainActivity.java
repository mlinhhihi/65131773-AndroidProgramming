package mlinh.edu.th7_listview;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dsTenTinhThanhVN; //khai báo
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
            //
        dsTenTinhThanhVN = new ArrayList<String>(); // tạo thể hiện cụ thể, xin mới
            //thêm dữ liệu ở đây (đúng ra phải đọc từ một nguồn - nhưng ta hard-code để demo)
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Hải Phòng");
        dsTenTinhThanhVN.add("Đà Nẵng");
        dsTenTinhThanhVN.add("Cần Thơ");
        dsTenTinhThanhVN.add("Bà Rịa - Vũng Tàu");
        dsTenTinhThanhVN.add("Khánh Hòa");
        dsTenTinhThanhVN.add("Kiên Giang");
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
        //Gắn bộ lắng nghe vào
        lvTenTinhThanh.setOnItemClickListener(boLangNgheVaXL);
    }
    //Tạo bộ lắng nghe và xử lý sự kiện Onitemclick, đặt vào một biến
    //vd: boLangNgheVaXL
    AdapterView.OnItemClickListener boLangNgheVaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Code xử lý ở đây
            //position là vị trí phần tử vừa được click
            //Hiện lên màn hình thông báo nhanh về vị trí của phần tử vừa chọn, ví dụ xử lý ở đây
                //Hiện vị trí
            //Toast.makeText(MainActivity.this, "Bạn vừa chọn phần tử thứ "+String.valueOf(position),Toast.LENGTH_LONG).show();
                //Lấy gtri của phần tử thứ position
            String strTenTinhChon = dsTenTinhThanhVN.get(position);
            Toast.makeText(MainActivity.this, strTenTinhChon, Toast.LENGTH_LONG).show();
        }
    };
}