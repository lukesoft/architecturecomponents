package com.lukesoft.archcomponentsdemo.domain.interactors;


import android.arch.lifecycle.LiveData;

import com.lukesoft.archcomponentsdemo.data.Student;
import com.lukesoft.archcomponentsdemo.data.StudentRepository;

import java.util.List;

/**
 * Created by lukesoft on 2018/07/12.
 **/
public class GetStudentsUseCase {
    private StudentRepository mRepository;

    public GetStudentsUseCase() {
        this.mRepository = new StudentRepository();
    }

    public LiveData<List<Student>> get() {
        return mRepository.getAllStudents();
    }
}
