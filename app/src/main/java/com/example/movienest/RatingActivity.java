package com.example.movienest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RatingActivity extends AppCompatActivity {

    public void showRateDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_rating, null);

        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.show();

        TextView later = view.findViewById(R.id.laterBtn);
        TextView rate = view.findViewById(R.id.rateBtn);

        later.setOnClickListener(v -> {

            finishAffinity(); // إغلاق التطبيق

        });

        rate.setOnClickListener(v -> {

            Intent intent = new Intent(RatingActivity.this, RatingActivity.class);
            startActivity(intent);

        });
    }
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showRateDialog();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rating);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}