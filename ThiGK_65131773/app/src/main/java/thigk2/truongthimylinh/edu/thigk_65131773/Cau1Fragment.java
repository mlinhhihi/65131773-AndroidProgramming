package thigk2.truongthimylinh.edu.thigk_65131773;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Cau1Fragment extends Fragment {


    EditText editText_ChieuDai;
    EditText editText_ChieuRong;
    Button btnChuVi;
    Button btnDienTich;
    TextView txtKetQua;


    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
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
        View viewCau1 = inflater.inflate(R.layout.fragment_cau1, container, false);
        //tìm điều khiển trong view này
        editText_ChieuDai = viewCau1.findViewById(R.id.edtChieuDai);
        editText_ChieuRong = viewCau1.findViewById(R.id.edtChieuRong);
        txtKetQua = viewCau1.findViewById(R.id.txtKetQua);
        btnChuVi = viewCau1.findViewById(R.id.btnChuVi);
        btnDienTich = viewCau1.findViewById(R.id.btnDienTich);

        //tính chu vi
        btnChuVi.setOnClickListener(v -> {
            String strDai = editText_ChieuDai.getText().toString().trim();
            String strRong = editText_ChieuRong.getText().toString().trim();

            if (strDai.isEmpty() || strRong.isEmpty()) {
                txtKetQua.setText("Vui lòng nhập đầy đủ!");
                return;
            }

            try {
                double dai = Double.parseDouble(strDai);
                double rong = Double.parseDouble(strRong);

                if (dai <= 0 || rong <= 0) {
                    txtKetQua.setText("Dữ liệu phải > 0!");
                    return;
                }

                double chuVi = 2 * (dai + rong);

                txtKetQua.setText("Chu vi: " + String.format("%.2f", chuVi));

            } catch (Exception e) {
                txtKetQua.setText("Dữ liệu không hợp lệ!");
            }
        });

        //tính diện tích
        btnDienTich.setOnClickListener(v -> {
            String strDai = editText_ChieuDai.getText().toString().trim();
            String strRong = editText_ChieuRong.getText().toString().trim();

            if (strDai.isEmpty() || strRong.isEmpty()) {
                txtKetQua.setText("Vui lòng nhập đầy đủ!");
                return;
            }

            try {
                double dai = Double.parseDouble(strDai);
                double rong = Double.parseDouble(strRong);

                if (dai <= 0 || rong <= 0) {
                    txtKetQua.setText("Dữ liệu phải > 0!");
                    return;
                }

                double dienTich = dai * rong;

                txtKetQua.setText("Diện tích: " + String.format("%.2f", dienTich));

            } catch (Exception e) {
                txtKetQua.setText("Dữ liệu không hợp lệ!");
            }
        });
        return viewCau1;
    }
}