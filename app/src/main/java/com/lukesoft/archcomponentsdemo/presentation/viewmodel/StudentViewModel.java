package com.lukesoft.archcomponentsdemo.presentation.viewmodel;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.lukesoft.archcomponentsdemo.data.Student;
import com.lukesoft.archcomponentsdemo.domain.interactors.AddStudentUseCase;
import com.lukesoft.archcomponentsdemo.domain.interactors.GetStudentsUseCase;

import java.util.List;

/**
 * Created by lukesoft on 2018/07/12.
 **/
public class StudentViewModel extends ViewModel {
    private AddStudentUseCase mAddStudentUseCase;
    private GetStudentsUseCase mGetStudentsUseCase;

    private LiveData<List<Student>> mStudents;

    public StudentViewModel() {
        this.mAddStudentUseCase = new AddStudentUseCase();
        this.mGetStudentsUseCase = new GetStudentsUseCase();
        mStudents = mGetStudentsUseCase.get();
    }


    public LiveData<List<Student>> getStudents() {
        return mStudents;
    }

    public void insert(Student student) {
        mAddStudentUseCase.add(student);
    }
}
