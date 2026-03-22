package mlinh.edu.th5_xulysukien1;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các đối tượng gắn với điều khiển tương ứng
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong;
    Button nutTru;
    Button nutNhan;
    Button nutChia;
    void TimDieuKhien(){
        editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        editTextKQ = (EditText)findViewById(R.id.edtKQ);
        nutCong = (Button)findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        //gắn bộ lắng nghe sự kiện và code xử lý cho từng nút

        View.OnClickListener boLangNgheCong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý cộng ở đây
                XuLy_Cong();
            }
        };
        nutCong.setOnClickListener(boLangNgheCong);
        //Inline
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý ở đây
                XuLy_Tru();
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý ở đây
                XuLy_Nhan();
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý chia
               XuLy_Chia();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    void XuLy_Cong(){
        //lấy dữ liệu
        String so_1 = editTextSo1.getText().toString();
        String so_2 = editTextSo2.getText().toString();

        float num1 = Float.parseFloat(so_1);
        float num2 = Float.parseFloat(so_2);
        //
        float tong = num1 + num2;
        //
        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);

    }
    void XuLy_Tru(){
        //lấy dữ liệu
        String so_1 = editTextSo1.getText().toString();
        String so_2 = editTextSo2.getText().toString();

        float num1 = Float.parseFloat(so_1);
        float num2 = Float.parseFloat(so_2);
        //
        float hieu = num1 - num2;
        //
        String chuoiKQ = String.valueOf(hieu);
        editTextKQ.setText(chuoiKQ);

    }
    void XuLy_Nhan(){
        //lấy dữ liệu
        String so_1 = editTextSo1.getText().toString();
        String so_2 = editTextSo2.getText().toString();

        float num1 = Float.parseFloat(so_1);
        float num2 = Float.parseFloat(so_2);
        //
        float tich = num1 * num2;
        //
        String chuoiKQ = String.valueOf(tich);
        editTextKQ.setText(chuoiKQ);

    }
    void XuLy_Chia(){
        //lấy dữ liệu
        String so_1 = editTextSo1.getText().toString();
        String so_2 = editTextSo2.getText().toString();

        float num1 = Float.parseFloat(so_1);
        float num2 = Float.parseFloat(so_2);
        //
        float thuong = num1 / num2;
        //
        String chuoiKQ = String.valueOf(thuong);
        editTextKQ.setText(chuoiKQ);

    }

}