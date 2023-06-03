package com.juthi.diucardmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MakeTeacherActivity extends AppCompatActivity {

    private TextInputEditText nameET, companyET, phoneET, gmailET, homeET, officeET, bioET, facebookET, instagramET, linkedinET, twitterET;
    private AutoCompleteTextView designationET;
    private MaterialButton uploadBtn;
    private String name, company, designation, phone, email, home, office, bio, facebook, instagram, linkedin, twitter;
    ArrayAdapter<String> adapterItems;
    String[] items = {"Lecturer",  "Assistant Professor",  "Associate Professor " ,  "Professor" };

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_teacher);

        getSupportActionBar().setTitle("Make Teacher Card");
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //init all textview
        nameET = findViewById(R.id.nameET);
        companyET = findViewById(R.id.companyET);
        designationET = findViewById(R.id.designationET);
        phoneET = findViewById(R.id.phoneET);
        gmailET = findViewById(R.id.gmailET);
        homeET = findViewById(R.id.homeET);
        officeET = findViewById(R.id.officeET);
        bioET = findViewById(R.id.bioET);
        facebookET = findViewById(R.id.facebookET);
        instagramET = findViewById(R.id.instagramET);
        linkedinET = findViewById(R.id.linkedinET);
        twitterET = findViewById(R.id.twitterET);

        /*init button*/
        uploadBtn = findViewById(R.id.uploadBtn);


        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);
        designationET.setAdapter(adapterItems);

        designationET.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

    }

    private void sendData() {
        name = nameET.getText().toString().trim();
        company = companyET.getText().toString().trim();
        designation = designationET.getText().toString().trim();
        phone = phoneET.getText().toString().trim();
        email = gmailET.getText().toString().trim();
        home = homeET.getText().toString().trim();
        office = officeET.getText().toString().trim();
        bio = bioET.getText().toString().trim();
        facebook = facebookET.getText().toString().trim();
        instagram = instagramET.getText().toString().trim();
        linkedin = linkedinET.getText().toString().trim();
        twitter = twitterET.getText().toString().trim();

        if (name.isEmpty()) {
            nameET.setError("Name is required");
            nameET.requestFocus();
        } else if (company.isEmpty()) {
            companyET.setError("University name is required");
            companyET.requestFocus();
        } else if (designation.isEmpty()) {
            designationET.setError("Designation is required");
            designationET.requestFocus();
        } else if (phone.isEmpty()) {
            phoneET.setError("Phone number is required");
            phoneET.requestFocus();
        } else if (email.isEmpty()) {
            gmailET.setError("Email is required");
            gmailET.requestFocus();
        } else if (home.isEmpty()) {
            homeET.setError("Home address is required");
            homeET.requestFocus();
        } else if (office.isEmpty()) {
            officeET.setError("Office or Institute address is required");
            officeET.requestFocus();
        } else if (bio.isEmpty()) {
            bioET.setError("Short Bio-data is required");
            bioET.requestFocus();
        } else if (facebook.isEmpty()) {
            facebookET.setError("Facebook username is required");
            facebookET.requestFocus();
        } else if (instagram.isEmpty()) {
            instagramET.setError("Instagram username is required");
            instagramET.requestFocus();
        } else if (linkedin.isEmpty()) {
            linkedinET.setError("LinkedIn username is required");
            linkedinET.requestFocus();
        } else if (twitter.isEmpty()) {
            twitterET.setError("Twitter username is required");
            twitterET.requestFocus();
        } else {

            Intent intent = new Intent(MakeTeacherActivity.this, TeacherCardActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("company", company);
            intent.putExtra("designation", designation);
            intent.putExtra("phone", phone);
            intent.putExtra("email", email);
            intent.putExtra("home", home);
            intent.putExtra("office", office);
            intent.putExtra("bio", bio);
            intent.putExtra("facebook", facebook);
            intent.putExtra("instagram", instagram);
            intent.putExtra("linkedin", linkedin);
            intent.putExtra("twitter", twitter);

            startActivity(intent);
            Toast.makeText(this, "Generate Identity Card", Toast.LENGTH_SHORT).show();
        }
    }


}