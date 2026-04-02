package thom.edu.th13thaydoifragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FooterFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_footer, container, false);
        //find view
        Button b1 = v.findViewById(R.id.btn1);
        Button b2 = v.findViewById(R.id.btn2);
        Button b3 = v.findViewById(R.id.btn3);

        //
        FragmentManager fragmentManager = getParentFragmentManager();
        //
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContentHoder, new Fragment1())
                        .commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContentHoder, new Fragment2())
                        .commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContentHoder, new Fragment3())
                        .commit();
            }
        });
        return v;
    }
}