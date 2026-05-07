package vn.edu.mlinh123.vieccanlam;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingtoolbar.FloatingToolbarLayout;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ThemTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tasks);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lấy dữ liệu
                EditText editTextName = findViewById(R.id.edtTenCV);
                EditText editTextMessage = findViewById(R.id.edtMessage);
                EditText editTextDate = findViewById(R.id.edtDate);
                EditText editTextPrio = findViewById(R.id.edtPrio);

                String tenCV = editTextName.getText().toString();
                String message = editTextMessage.getText().toString();
                String date = editTextDate.getText().toString();
                String prio = editTextPrio.getText().toString();
                //Gói vào đối tượng
                TASKS tasks = new TASKS(date, message, tenCV, prio);
                //Kết nối DB, và thêm
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("TASKS");
                String key = databaseReference.push().getKey();

                HashMap<String, Object> item  = new HashMap<String, Object>();
                item.put(key, tasks.toFirebaseObject());

                databaseReference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error==null) finish();
                    }
                });
            }
        });
    }
}
