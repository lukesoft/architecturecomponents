package com.lukesoft.archcomponentsdemo.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lukesoft.archcomponentsdemo.R;
import com.lukesoft.archcomponentsdemo.data.Student;

import java.util.List;


/**
 * Created by lukesoft on 2018/07/12.
 **/
public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {

    private final LayoutInflater mInflater;
    private List<Student> mStudents; // Cached copy of students
    public StudentListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {
        View itemView = mInflater.inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder,
                                 int position) {
        if (mStudents != null) {
            Student current = mStudents.get(position);
            holder.studentItemView.setText(current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.studentItemView.setText("No Student");
        }
    }

    public void setStudents(List<Student> students) {
        mStudents = students;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mStudents has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mStudents != null)
            return mStudents.size();
        else return 0;
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        private final TextView studentItemView;

        private StudentViewHolder(View itemView) {
            super(itemView);
            studentItemView = itemView.findViewById(R.id.txtStudentName);
        }
    }
}