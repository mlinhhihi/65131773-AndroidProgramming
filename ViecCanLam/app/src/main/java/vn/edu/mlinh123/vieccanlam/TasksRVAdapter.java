package vn.edu.mlinh123.vieccanlam;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.Task;

import java.util.List;

public class TasksRVAdapter  extends RecyclerView.Adapter {
    List<TASKS> dataSource;

    public TasksRVAdapter(List<TASKS> dataSource) {
        this.dataSource = dataSource;
    }
    //
    public class TaskItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewTenVCL;
        TextView textViewTG;

        public int positon;
        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewTenVCL = itemView.findViewById(R.id.tvTenVCL);
            textViewTG = itemView.findViewById(R.id.tvThoiGian);
        }

        @Override
        public void onClick(View v) {
            //lấy vị trí
            int vtClicked = getAdapterPosition();
            //lục ở nguoond fuwx liệu
            TASKS tasksClicked  = dataSource.get(vtClicked);
            //Xử lý, ví dụ ở đây ta Toast
            Toast.makeText(v.getContext(), "Bạn vừa chọn việc" + tasksClicked.getName(), Toast.LENGTH_SHORT).show();

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_item,parent,false);
        TaskItemViewHolder viewHolder = new TaskItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        TaskItemViewHolder viewHolder = (TaskItemViewHolder) holder;
        viewHolder.positon = position;
        TASKS tasks = dataSource.get(position);
        ((TaskItemViewHolder) holder).textViewTenVCL.setText(tasks.getName()   );
        ((TaskItemViewHolder) holder).textViewTG.setText(tasks.getDate()   );
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
