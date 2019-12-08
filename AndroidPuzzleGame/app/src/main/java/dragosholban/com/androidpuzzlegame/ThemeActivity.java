package dragosholban.com.androidpuzzlegame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        ImageButton theme1 = findViewById(R.id.imageButton);
        theme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemeActivity.this, levelactivity.class);
                intent.putExtra("background_img", getBackgroundImageData(view));
                startActivity(intent);
            }
        });
        ImageButton theme2 = findViewById(R.id.imageButton2);
        theme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemeActivity.this, levelactivity.class);
                intent.putExtra("background_img", getBackgroundImageData(view));
                startActivity(intent);
            }
        });
        ImageButton theme3 = findViewById(R.id.imageButton3);
        theme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemeActivity.this, levelactivity.class);
                intent.putExtra("background_img", getBackgroundImageData(view));
                startActivity(intent);
            }
        });
        ImageButton theme4 = findViewById(R.id.imageButton4);
        theme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemeActivity.this, levelactivity.class);
                intent.putExtra("background_img", getBackgroundImageData(view));
                startActivity(intent);
            }
        });
    }
//
//    public void theme1(View view) {
//        Intent intent = new Intent(ThemeActivity.this, levelactivity.class);
//        intent.putExtra("background_img", getBackgroundImageData(view));
//        startActivity(intent);
//    }
//    public void theme2(View view) {
//        Intent intent = new Intent(ThemeActivity.this, levelactivity.class);
//        intent.putExtra("background_img", getBackgroundImageData(view));
//        startActivity(intent);
//    }
//    public void theme3(View view) {
//        Intent intent = new Intent(ThemeActivity.this, levelactivity.class);
//        intent.putExtra("background_img", getBackgroundImageData(view));
//        startActivity(intent);
//    }
//    public void theme4(View view) {
//        Intent intent = new Intent(ThemeActivity.this, levelactivity.class);
//        intent.putExtra("background_img", getBackgroundImageData(view));
//        startActivity(intent);
//    }

    byte[] getBackgroundImageData(View view) {
        Bitmap bitmap = ((BitmapDrawable)((ImageView)view).getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        return baos.toByteArray();
    }
}
