package mlinh.edu.th6_xulysukien_tinhtong;

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
    EditText editTextSoA;
    EditText editTextSoB;
    EditText editTextKQ;
    Button nutCong;
    Button nutTru;
    Button nutNhan;
    Button nutChia;
    void TimDieuKhien(){
        editTextSoA = (EditText)findViewById(R.id.edta);
        editTextSoB = (EditText)findViewById(R.id.edtb);
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void XuLyCong(View view){
        String so_a = editTextSoA.getText().toString();
        String so_b = editTextSoB.getText().toString();

        float num1 = Float.parseFloat(so_a);
        float num2 = Float.parseFloat(so_b);
        //
        float tong = num1 + num2;
        //
        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyTru(View view){
        String so_a = editTextSoA.getText().toString();
        String so_b = editTextSoB.getText().toString();

        float num1 = Float.parseFloat(so_a);
        float num2 = Float.parseFloat(so_b);
        //
        float hieu = num1 - num2;
        //
        String chuoiKQ = String.valueOf(hieu);
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyNhan(View view){
        String so_a = editTextSoA.getText().toString();
        String so_b = editTextSoB.getText().toString();

        float num1 = Float.parseFloat(so_a);
        float num2 = Float.parseFloat(so_b);
        //
        float tich = num1 * num2;
        //
        String chuoiKQ = String.valueOf(tich);
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyChia(View view){
        String so_a = editTextSoA.getText().toString();
        String so_b = editTextSoB.getText().toString();

        float num1 = Float.parseFloat(so_a);
        float num2 = Float.parseFloat(so_b);
        //
        float thuong = num1 / num2;
        //
        String chuoiKQ = String.valueOf(thuong);
        editTextKQ.setText(chuoiKQ);
    }
}