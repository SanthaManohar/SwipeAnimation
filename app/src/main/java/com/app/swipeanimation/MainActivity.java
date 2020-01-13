package com.app.swipeanimation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;

    CircleImageView imageView;
    TextView name,position,company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.relativelay);
        imageView = findViewById(R.id.profile_image);
        name = findViewById(R.id.name);
        position = findViewById(R.id.position);
        company = findViewById(R.id.company);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                Pair[] pairs = new Pair[4];

                pairs[0] = new Pair<View,String>(imageView,"imageTransition");
                pairs[1] = new Pair<View,String>(name,"nameTransition");
                pairs[2] = new Pair<View,String>(position,"positionTransition");
                pairs[3] = new Pair<View,String>(company,"companyTransition");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }else {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }



            }
        });

    }
}
