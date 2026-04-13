package linh65131773.edu.bottom_navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cau1Fragment extends Fragment {


    EditText editText_Met;
    EditText editText_Kilomet;
    Button btnChuyen;


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
        editText_Met = viewCau1.findViewById(R.id.edtSoMet);
        editText_Kilomet = viewCau1.findViewById(R.id.edtSoKm);
        btnChuyen = viewCau1.findViewById(R.id.btnDoi);
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String duLieuMet = editText_Met.getText().toString();
                String dulieuKm = editText_Kilomet.getText().toString();
                //
                if(!duLieuMet.isEmpty()) //user có nhâp dữ liệu mét -> cần đổi sang km
                {
                    double met = Double.parseDouble(duLieuMet);
                    double km = met / 1000;

                    editText_Kilomet.setText(String.valueOf(km));
                    Toast.makeText(viewCau1.getContext(), "m - > km", Toast.LENGTH_SHORT).show();
                }
                else //km -> m
                {

                    double km = Double.parseDouble(dulieuKm);
                    double met = km * 1000;

                    editText_Met.setText(String.valueOf(met));
                    Toast.makeText(viewCau1.getContext(), "km - > m", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return viewCau1;
    }
}