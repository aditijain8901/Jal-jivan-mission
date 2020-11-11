package com.example.vwsc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class module1Activity extends AppCompatActivity {
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
        pdfView = findViewById(R.id.pdf_module1);
        pdfView.fromAsset("Jal jivan mission module1.pdf").load();
    }
}