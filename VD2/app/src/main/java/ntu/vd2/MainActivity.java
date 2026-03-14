package ntu.vd2;

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //
        TimDieuKhien();
        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    void TimDieuKhien(){
        editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        editTextKQ = (EditText)findViewById(R.id.edtKQ);
        nutCong = (Button)findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    //Xử lý cộng
    public void XuLyCong(View v){
        //b1: lấy dữ liệu hai số
            //b1.1: tìm edtSo1&So2

            //b1.2: lấy dữ liệu từ hai đ.khiển
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
            //b1.3: chuyển dữ liệu từ chuỗi sang số
        float so_1 = Float.parseFloat(soThu1);
        float so_2 = Float.parseFloat(soThu2);
        //b2: tính toán
        float tong = so_1 + so_2;
        //b3: hiện KQ
            //b3.1:

            //b3.2: cbj dữ liệu xuất, biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(tong);
            //b3.3: gán kq lên . khiển
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý trừ
    public void XuLyTru(View v){

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        float so_1 = Float.parseFloat(soThu1);
        float so_2 = Float.parseFloat(soThu2);

        float hieu = so_1 - so_2;


        String chuoiKQ = String.valueOf(hieu);
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý nhân
    public void XuLyNhan(View v){

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        float so_1 = Float.parseFloat(soThu1);
        float so_2 = Float.parseFloat(soThu2);

        float tich = so_1 * so_2;


        String chuoiKQ = String.valueOf(tich);
        editTextKQ.setText(chuoiKQ);
    }//Xử lý chia
    public void XuLyChia(View v){

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        float so_1 = Float.parseFloat(soThu1);
        float so_2 = Float.parseFloat(soThu2);

        float thuong = so_1 / so_2;


        String chuoiKQ = String.valueOf(thuong);
        editTextKQ.setText(chuoiKQ);
    }
}