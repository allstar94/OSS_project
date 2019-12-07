package dragosholban.com.androidpuzzlegame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
    }

    public void theme_1(View view) {
        Intent intent = new Intent(ThemeActivity.this,levelactivity.class);
        startActivity(intent);
    }

    public void theme_2(View view) {
        Intent intent = new Intent(ThemeActivity.this,levelactivity.class);
        startActivity(intent);
    }

    public void theme_3(View view) {
        Intent intent = new Intent(ThemeActivity.this,levelactivity.class);
        startActivity(intent);
    }

    public void theme_4(View view) { Intent intent = new Intent(ThemeActivity.this,levelactivity.class);
        startActivity(intent);
    }
}
