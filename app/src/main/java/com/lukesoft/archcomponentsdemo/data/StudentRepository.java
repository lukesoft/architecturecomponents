package com.lukesoft.archcomponentsdemo.data;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by lukesoft on 2018/07/12.
 **/
public class StudentRepository {

    private StudentDao mStudentDao;
    private LiveData<List<Student>> mAllStudents;

    public StudentRepository() {
        StudentRoomDatabase db = StudentRoomDatabase.getDatabase();
        mStudentDao = db.studentsDao();
        mAllStudents = mStudentDao.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return mAllStudents;
    }

    public void insert(Student student) {
        new insertAsyncTask(mStudentDao).execute(student);
    }

    private static class insertAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao mAsyncTaskDao;

        insertAsyncTask(StudentDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Student... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}