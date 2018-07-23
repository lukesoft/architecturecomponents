package com.lukesoft.archcomponentsdemo.domain.interactors;


import com.lukesoft.archcomponentsdemo.data.Student;
import com.lukesoft.archcomponentsdemo.data.StudentRepository;

/**
 * Created by lukesoft on 2018/07/12.
 **/
public class AddStudentUseCase {
    private StudentRepository mRepository;

    public AddStudentUseCase() {
        this.mRepository = new StudentRepository();
    }

    public void add(Student student) {
        mRepository.insert(student);
    }
}
