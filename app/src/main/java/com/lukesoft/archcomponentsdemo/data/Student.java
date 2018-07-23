package com.lukesoft.archcomponentsdemo.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by lukesoft on 2018/07/12.
 **/
@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
