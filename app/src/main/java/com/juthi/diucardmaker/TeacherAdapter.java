package com.juthi.diucardmaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter>{

    private List<TeacherData> list;
    public Context context;


    public TeacherAdapter(List<TeacherData> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public TeacherAdapter.TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.teacher_list_item, parent,false);

        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherAdapter.TeacherViewAdapter holder, int position) {

        TeacherData item = list.get(position);

        holder.nameTv.setText(item.getName());
        holder.destinationTv.setText(item.getDesignation());
        holder.gmailTv.setText(item.getEmail());
        holder.mobileTv.setText(item.getMobile());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView nameTv, destinationTv, gmailTv, mobileTv;
        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            destinationTv = itemView.findViewById(R.id.destinationTv);
            gmailTv = itemView.findViewById(R.id.gmailTv);
            mobileTv = itemView.findViewById(R.id.mobileTv);

        }
    }
}
