package com.example.codenextapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Button aboutButton;
    Button newsButton;
    Button programsButton;
    ScrollView scrollView;
    View aboutSection;
    View aboutSection1;
    View newsSection;
    View programsSection;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutButton = findViewById(R.id.aboutButton);
        newsButton = findViewById(R.id.newsButton);
        programsButton = findViewById(R.id.programsButton);
        scrollView = findViewById(R.id.scrollView);
        aboutSection = findViewById(R.id.think);
        aboutSection1 = findViewById(R.id.make);
        newsSection = findViewById(R.id.news);
        programsSection = findViewById(R.id.foundationsDescription4);
        list = findViewById(R.id.list);

        ArrayList<Program> arr = new ArrayList<>();
        arr.add(new Program("Team Edge", "A rigorous high school program for 10th and 11th graders that includes CS, academic enrichment, leadership development, and navigating the college application/college-going experience for students and their families. Each Team Edge student receives a Google mentor in their 10th grade year."));
        ArrayAdapter<Program> adapter = new ArrayAdapter<Program>(this, android.R.layout.simple_list_item_1, arr);
        list.setAdapter(adapter);

        count();
    }

    public void count() {
        new CountDownTimer(100000, 1) {

            public void onTick(long millisUntilFinished) {

                Rect scrollBounds = new Rect();
                scrollView.getHitRect(scrollBounds);

                //about section
                if (aboutSection.getLocalVisibleRect(scrollBounds) || aboutSection1.getLocalVisibleRect(scrollBounds)) {
                    aboutButton.setBackgroundColor(getResources().getColor(R.color.gray));
                    newsButton.setBackgroundColor(Color.WHITE);
                    programsButton.setBackgroundColor(Color.WHITE);
                }

                //news section
                if (newsSection.getLocalVisibleRect(scrollBounds)) {
                    aboutButton.setBackgroundColor(Color.WHITE);
                    newsButton.setBackgroundColor(getResources().getColor(R.color.gray));
                    programsButton.setBackgroundColor(Color.WHITE);
                }

                //programs sections
                if (programsSection.getLocalVisibleRect(scrollBounds)) {
                    aboutButton.setBackgroundColor(Color.WHITE);
                    newsButton.setBackgroundColor(Color.WHITE);
                    programsButton.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }

            public void onFinish() {
                count();
            }
        }.start();
    }

    public void scrollToAbout(View view) {
        View targetView = findViewById(R.id.codeNextLogo);
        targetView.getParent().requestChildFocus(targetView,targetView);
    }

    public void scrollToNews(View view) {
        View targetView = findViewById(R.id.workshopsDescription3);
        targetView.getParent().requestChildFocus(targetView,targetView);
    }

    public void scrollToPrograms(View view) {
        View targetView = findViewById(R.id.teamEdgeDescription7);
        targetView.getParent().requestChildFocus(targetView,targetView);
    }

    public void apply(View view) {
        Intent intent = new Intent(MainActivity.this, ApplicationActivity.class);
        startActivity(intent);
    }
}

