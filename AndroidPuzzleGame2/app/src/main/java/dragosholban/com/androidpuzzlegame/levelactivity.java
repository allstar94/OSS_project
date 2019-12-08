package dragosholban.com.androidpuzzlegame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class levelactivity extends AppCompatActivity {
    Button button1;
    Button button2;
    LinearLayout layout;
    byte[] bgData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelactivity);

        if (getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            bgData = extras.getByteArray("background_img");

            Bitmap bmp = BitmapFactory.decodeByteArray(bgData, 0, bgData.length);
            Drawable drawable = new BitmapDrawable(bmp);

            ConstraintLayout layout = findViewById(R.id.layout);
            layout.setBackground(drawable);
        }

    }
    public void level_1(View view) {
        Intent intent = new Intent(levelactivity.this, MainActivity.class);
        intent.putExtra("background_img", bgData);
        startActivity(intent);
    }
    public void level_2(View view) {
        Intent intent = new Intent(levelactivity.this, MainActivity2.class);
        intent.putExtra("background_img", bgData);
        startActivity(intent);
    }
    public void level_3(View view) {
        Intent intent = new Intent(levelactivity.this, MainActivity3.class);
        intent.putExtra("background_img", bgData);
        startActivity(intent);
    }
/*
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bgchange1){
            layout.setBackgroundResource(R.drawable.table_background);
        }else if(view.getId()==R.id.bgchange2){
            layout.setBackgroundResource(R.drawable.table_background2);
        }
    }
    */
}
