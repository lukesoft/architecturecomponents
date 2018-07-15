package com.lukesoft.archcomponentsdemo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.lukesoft.archcomponentsdemo.App;


/**
 * Created by lukesoft on 2018/07/12.
 **/
@Database(entities = {Student.class}, version = 1)
public abstract class StudentRoomDatabase extends RoomDatabase {
    public abstract StudentDao studentsDao();


    private static StudentRoomDatabase INSTANCE;
    static StudentRoomDatabase getDatabase() {
        if (INSTANCE == null) {
            synchronized (StudentRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(App.getAppInstance(),
                            StudentRoomDatabase.class, "students_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }

}