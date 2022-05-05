package com.jamdev.finalexamsguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mobileButton;
    private RelativeLayout parallelButton;
    private RelativeLayout softwareButton;
    private RelativeLayout discreteButton;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // These 3 lines hide the title and action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        try {

            db = this.openOrCreateDatabase("examsdb", MODE_PRIVATE, null);
            db.execSQL("CREATE Table IF NOT EXISTS exam (name VARCHAR, url VARCHAR)");
            // To be ran once and then commented out
            db.execSQL("INSERT INTO exam (name, url) VALUES ('Mobile Computing', 'https://developer.android.com/docs')");
            db.execSQL("INSERT INTO exam (name, url) VALUES ('Parallel Programming', 'https://www.open-mpi.org/doc/')");
            db.execSQL("INSERT INTO exam (name, url) VALUES ('Software Engineering', 'https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-use-case-diagram/')");
            db.execSQL("INSERT INTO exam (name, url) VALUES ('Discrete Structures 2', 'https://www.cl.cam.ac.uk/projects/raspberrypi/tutorials/turing-machine/one.html')");

        } catch (Exception e){
            e.printStackTrace();
        }

        mobileButton = findViewById(R.id.panel_mobile);
        parallelButton = findViewById(R.id.panel_parallel);
        softwareButton = findViewById(R.id.panel_software);
        discreteButton = findViewById(R.id.panel_discrete);

        mobileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "";
                Cursor c = db.rawQuery("SELECT url FROM exam WHERE name = \"Mobile Computing\"", null);
                int n = c.getColumnIndex("url");
                c.moveToFirst();
                URL = c.getString(n);
                Intent goToWebPage = new Intent(getApplicationContext(), WebViewActivity.class);
                goToWebPage.putExtra("URL", URL);
                startActivity(goToWebPage);
            }
        });

        parallelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "";
                Cursor c = db.rawQuery("SELECT url FROM exam WHERE name = \"Parallel Programming\"", null);
                int n = c.getColumnIndex("url");
                c.moveToFirst();
                URL = c.getString(n);
                Intent goToWebPage = new Intent(getApplicationContext(), WebViewActivity.class);
                goToWebPage.putExtra("URL", URL);
                startActivity(goToWebPage);
            }
        });

        softwareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "";
                Cursor c = db.rawQuery("SELECT url FROM exam WHERE name = \"Software Engineering\"", null);
                int n = c.getColumnIndex("url");
                c.moveToFirst();
                URL = c.getString(n);
                Intent goToWebPage = new Intent(getApplicationContext(), WebViewActivity.class);
                goToWebPage.putExtra("URL", URL);
                startActivity(goToWebPage);
            }
        });

        discreteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "";
                Cursor c = db.rawQuery("SELECT url FROM exam WHERE name = \"Discrete Structures 2\"", null);
                int n = c.getColumnIndex("url");
                c.moveToFirst();
                URL = c.getString(n);
                Intent goToWebPage = new Intent(getApplicationContext(), WebViewActivity.class);
                goToWebPage.putExtra("URL", URL);
                startActivity(goToWebPage);
            }
        });


    }
}