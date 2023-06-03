package com.juthi.diucardmaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddTeacherActivity extends AppCompatActivity {

    private TextInputEditText nameET, designationET, emailET, mobileET;
    private Spinner ayatCategory;
    private Button uploadBtn;
    private String category;
    private ProgressDialog progressDialog;
    private String name, designation, email, mobile;
    private DatabaseReference reference, dbRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        getSupportActionBar().setTitle("Add Teacher Details");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*init id*/
        nameET = findViewById(R.id.nameET);
        designationET = findViewById(R.id.designationET);
        emailET = findViewById(R.id.emailET);
        mobileET = findViewById(R.id.mobileET);
        uploadBtn = findViewById(R.id.uploadBtn);
        ayatCategory = findViewById(R.id.ayatCategory);

        /*progress bar dialog*/
        progressDialog = new ProgressDialog(this);

        /*firebase database*/
        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");


        String[] items = new String[]{"Select Category", "Teacher"};
        ayatCategory.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items));


        ayatCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                category = ayatCategory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        uploadBtn.setOnClickListener(new View.OnClickListener() { // eikhane change ache AddStudentBtn
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });

    }


    private void checkValidation() {

        name = nameET.getText().toString().trim();
        designation = designationET.getText().toString().trim();
        email = emailET.getText().toString().trim();
        mobile = mobileET.getText().toString().trim();

        if (name.isEmpty()) {

            nameET.requestFocus();
            nameET.setError("Teacher Name is important");

        } else if (category.equals("Select Category")) {

            Toast.makeText(this, "Please provides teacher category", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog.setMessage("Uploading Details");
            progressDialog.show();
            insertData();
        }
    }

    // #######################################################################################################
    // ##################################### Insert Data Code ###############################################
    // #####################################################################################################

    private void insertData() {
        // set data on category
        dbRef = reference.child(category);
        final String uniquekey = dbRef.push().getKey();

        TeacherData uploadAllAyats = new TeacherData(name, designation, mobile, email, uniquekey);

        dbRef.child(uniquekey).setValue(uploadAllAyats).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                progressDialog.dismiss();
                Toast.makeText(AddTeacherActivity.this, "Details upload Successful", Toast.LENGTH_SHORT).show();

                nameET.setText("");
                designationET.setText("");
                emailET.setText("");
                mobileET.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(AddTeacherActivity.this, "Details upload Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

}