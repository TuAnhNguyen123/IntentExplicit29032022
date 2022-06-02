package com.example.intentexplicit29032022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] arrNameImages;
    ImageView imgRandom,imgPick;
    int valueImgRandom;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPick = findViewById(R.id.imgPick);
        imgRandom = findViewById(R.id.imgRandom);
        random = new Random();
        arrNameImages = getResources().getStringArray(R.array.arr_images);
        RandomImage(imgRandom);
        imgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GalleryImageActivity.class);
                intent.putExtra("array",arrNameImages);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case    R.id.item_random:
                RandomImage(imgRandom);
                break;
        }
        return true;
    }
    private void RandomImage(ImageView imageView){
        int indexRandom= random.nextInt(arrNameImages.length);
        valueImgRandom = getResources().getIdentifier(
                arrNameImages[indexRandom],
                "drawable",
                getPackageName()
        );
        imageView.setImageResource(valueImgRandom);
    }
}