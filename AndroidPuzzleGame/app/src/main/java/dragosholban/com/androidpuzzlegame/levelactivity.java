package dragosholban.com.androidpuzzlegame;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
public class levelactivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelactivity);
    }
    public void level_1(View view) {
        Intent intent = new Intent(levelactivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void level_2(View view) {
        Intent intent = new Intent(levelactivity.this,MainActivity2.class);
        startActivity(intent);
    }
    public void level_3(View view) {
        Intent intent = new Intent(levelactivity.this,MainActivity3.class);
        startActivity(intent);
    }
}
