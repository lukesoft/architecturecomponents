package com.lukesoft.archcomponentsdemo.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lukesoft.archcomponentsdemo.R;


public class AddStudentActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.lukesoft.studentlistdemo.presentation.view.activity.REPLY";

    /**
     * Called when the Activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        initUI();
    }

    /**
     * Initialise UI components on the main screen
     */
    private void initUI() {
        //Input Field
        final EditText editText = findViewById(R.id.editStudentName);

        //Add Button
        Button addButton = findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editText.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = editText.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }

                finish();

            }
        });
    }
}
