package com.juthi.diucardmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class StudentCardActivity extends AppCompatActivity {

    private TextView nameTv, companyTv, designationTv, phoneTv, emailTv, homeTv, officeTv, bioTv, facebookTv, instagramTv, linkedinTv, twitterTv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_card);


     //   getSupportActionBar().setTitle("Student ID Card");
     //   getSupportActionBar().setDisplayShowHomeEnabled(true);

        nameTv = findViewById(R.id.nameTv);
        companyTv = findViewById(R.id.companyTv);
        designationTv = findViewById(R.id.designationTv);
        phoneTv = findViewById(R.id.phoneTv);
        emailTv = findViewById(R.id.emailTv);
        homeTv = findViewById(R.id.homeTv);
        officeTv = findViewById(R.id.officeTv);
        bioTv = findViewById(R.id.bioTv);
        facebookTv = findViewById(R.id.facebookTv);
        instagramTv = findViewById(R.id.instagramTv);
        linkedinTv = findViewById(R.id.linkedinTv);
        twitterTv = findViewById(R.id.twitterTv);

        loadDetails();

    }

    private void loadDetails() {

        /*get all data from another activity*/
        String name = getIntent().getStringExtra("name");
        String company = getIntent().getStringExtra("company");
        String designation = getIntent().getStringExtra("designation");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        String home = getIntent().getStringExtra("home");
        String office = getIntent().getStringExtra("office");
        String bio = getIntent().getStringExtra("bio");
        String facebook = getIntent().getStringExtra("facebook");
        String instagram = getIntent().getStringExtra("instagram");
        String linkedin = getIntent().getStringExtra("linkedin");
        String twitter = getIntent().getStringExtra("twitter");

        /*set all text in textview*/
        nameTv.setText(name);
        companyTv.setText(company);
        designationTv.setText(designation);
        phoneTv.setText(phone);
        emailTv.setText(email);
        homeTv.setText(home);
        officeTv.setText(office);
        bioTv.setText(bio);
        facebookTv.setText(facebook);
        instagramTv.setText(instagram);
        linkedinTv.setText(linkedin);
        twitterTv.setText(twitter);
    }

}