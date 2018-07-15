package com.lukesoft.archcomponentsdemo.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by lukesoft on 2018/07/12.
 **/
@Dao
public interface StudentDao {
    @Insert
    void insert(Student student);

    @Query("SELECT * from student ORDER BY name ASC")
    LiveData<List<Student>> getAllStudents();

    @Delete
    void delete(Student student);

    @Query("SELECT * from student WHERE id = :id")
    Student getMyFavoriteStudentById(int id);
}
