package com.lukesoft.archcomponentsdemo.presentation.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.lukesoft.archcomponentsdemo.R;
import com.lukesoft.archcomponentsdemo.data.Student;
import com.lukesoft.archcomponentsdemo.presentation.view.adapter.StudentListAdapter;
import com.lukesoft.archcomponentsdemo.presentation.viewmodel.StudentViewModel;

import java.util.List;


public class ListStudentsActivity extends AppCompatActivity {
    public static final int NEW_STUDENT_ACTIVITY_REQUEST_CODE = 1;
    protected StudentViewModel viewModel;

    /**
     * Called when the Activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        initUI();
    }


    /**
     * Initialise UI components on the main screen
     */
    private void initUI() {
        //init Window Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //init RecyclerView (which displays the list of students)
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final StudentListAdapter adapter = new StudentListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //init the add button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListStudentsActivity.this, AddStudentActivity.class);
                startActivityForResult(intent, NEW_STUDENT_ACTIVITY_REQUEST_CODE);
            }
        });

        viewModel.getStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable final List<Student> students) {
                // Update the cached copy of the students in the adapter.
                adapter.setStudents(students);
            }
        });
    }

    /**
     * Receives a new student name sent from the AddStudentActivity window
     * in the form of an intent
     */
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_STUDENT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Student student = new Student(data.getStringExtra(AddStudentActivity.EXTRA_REPLY));
            viewModel.insert(student);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
