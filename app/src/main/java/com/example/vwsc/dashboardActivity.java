package com.example.vwsc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class dashboardActivity extends AppCompatActivity {
    private TextView username;
    private CardView m1,m2,m3,m4,m5,m6,m7,m8;
    private Context mcontext;
    String url = "https://www.youtube.com/watch?v=Eu3FjH1gByo&t=62s";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutId:
                Intent intent = new Intent(this, aboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.creatorId:
                Intent in = new Intent(this,creatorActivity.class);
                startActivity(in);
                return true;
            case R.id.logoutId:
                final AlertDialog.Builder alert = new AlertDialog.Builder(dashboardActivity.this);
                alert.setTitle("लॉगआउट प्रक्रिया");
                alert.setMessage("क्या आप लॉगआउट करना चाहते हैं?");
                alert.setPositiveButton("हाँ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        final ProgressDialog dialog = new ProgressDialog(dashboardActivity.this);
                        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        dialog.setIndeterminate(true);
                        dialog.setMessage("लॉगआउट किया जाता है...");
                        dialog.show();
                        Intent in = new Intent(dashboardActivity.this, loginActivity.class);
                        startActivity(in);
                    }
                }).setNegativeButton("नहीं", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = alert.create();
                alertDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        username = findViewById(R.id.user_name);
        String namegot = getIntent().getStringExtra("namepassed");
        username.setText(namegot);

        m1 = findViewById(R.id.module1_read);
        m2 = findViewById(R.id.module1_watch);
        m3 = findViewById(R.id.module2_read);
        m4 = findViewById(R.id.module2_watch);
        m5 = findViewById(R.id.module3_read);
        m6 = findViewById(R.id.module3_watch);
        m7 = findViewById(R.id.module4_read);
        m8 = findViewById(R.id.module4_watch);

        allOnClick();
    }

    void allOnClick() {
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "मॉड्यूल 1 पढ़ें", Toast.LENGTH_SHORT).show();
                moduleOpen();
            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "मॉड्यूल 1 देखें", Toast.LENGTH_SHORT).show();
                /*CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(mcontext, Uri.parse(url));*/
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "मॉड्यूल 2 पढ़ें", Toast.LENGTH_SHORT).show();
                moduleOpen();
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "मॉड्यूल 2 देखें", Toast.LENGTH_SHORT).show();

            }
        });
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "मॉड्यूल 3 पढ़ें", Toast.LENGTH_SHORT).show();
                moduleOpen();
            }
        });
        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "मॉड्यूल 3 देखें", Toast.LENGTH_SHORT).show();
            }
        });
        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "मॉड्यूल 4 पढ़ें", Toast.LENGTH_SHORT).show();
                moduleOpen();
            }
        });
        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "मॉड्यूल 4 देखें", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void moduleOpen() {
        Intent i = new Intent(dashboardActivity.this,module1Activity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}