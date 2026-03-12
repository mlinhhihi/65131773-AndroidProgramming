package mlinh.edu.appcong;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    }
    // đây là bộ lắng nghe và xử lý sự kiện click đến nút tính tổng
    public void XuLyCong(View view){
        //tìm, tham chiếu đến điều khiển trên tệp xml, mapping sang java file
        EditText editTextsoA = findViewById(R.id.edta);
        EditText editTextsoB = findViewById(R.id.edtb);
        EditText editTextKetQua = findViewById(R.id.edtKQ);
        // lấy dữ liệu về ở điều khiển số A
        String strA = editTextsoA.getText().toString();     //strA = "2"
        // lấy dữ liệu về ở điều khiển số B
        String strB = editTextsoB.getText().toString();     //strB = "4"
        //chuển dữ liệu sang dạng số
        int so_A =  Integer.parseInt(strA);
        int so_B =  Integer.parseInt(strB);
        //Tính toán theo yêu cầu
        int  tong =  so_A + so_B;       //6
        String strTong = String.valueOf(tong);      //chuyển sang dạng chuỗi: "6"
        editTextKetQua.setText(strTong);
    }

    public void XuLyTru(View view) {
        //tìm, tham chiếu đến điều khiển trên tệp xml, mapping sang java file
        EditText editTextsoA = findViewById(R.id.edta);
        EditText editTextsoB = findViewById(R.id.edtb);
        EditText editTextKetQua = findViewById(R.id.edtKQ);
        // lấy dữ liệu về ở điều khiển số A
        String strA = editTextsoA.getText().toString();     //strA = "2"
        // lấy dữ liệu về ở điều khiển số B
        String strB = editTextsoB.getText().toString();     //strB = "4"
        //chuyển dữ liệu sang dạng số
        int so_A =  Integer.parseInt(strA);
        int so_B =  Integer.parseInt(strB);
        //Tính toán theo yêu cầu
        int  hieu =  so_A - so_B;       //6
        String strTong = String.valueOf(hieu);      //chuyển sang dạng chuỗi: "6"
        editTextKetQua.setText(strTong);
    }
}