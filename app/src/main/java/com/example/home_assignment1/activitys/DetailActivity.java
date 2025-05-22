package com.example.home_assignment1.activitys;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home_assignment1.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.detail_image);
        TextView titleView = findViewById(R.id.detail_title);
        TextView descView = findViewById(R.id.detail_description);

        // קבל את הנתונים שהועברו מה-Intent
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        int imageResId = getIntent().getIntExtra("image", 0);

        titleView.setText(title);
        descView.setText(description);
        imageView.setImageResource(imageResId);
    }
}
