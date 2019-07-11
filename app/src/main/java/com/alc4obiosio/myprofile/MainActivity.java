package com.alc4obiosio.myprofile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button mProfile;
    Button mAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mProfile.setOnClickListener(v -> profile());

        mAbout.setOnClickListener(v -> about());
    }

    private void initViews() {
        mProfile = findViewById(R.id.btn_profile);
        mAbout = findViewById(R.id.btn_about);
    }

    private void profile() {
        startActivity(new Intent(this, MyProfileActivity.class));
    }

    private void about() {
        startActivity(new Intent(this, AboutActivity.class));
    }
}
