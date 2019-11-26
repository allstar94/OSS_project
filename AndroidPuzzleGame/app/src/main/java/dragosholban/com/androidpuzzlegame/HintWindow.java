package dragosholban.com.androidpuzzlegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
<<<<<<< HEAD
//<<<<<<< HEAD
//taehoon git
//=======

//>>>>>>> master
=======
>>>>>>> TaeHoon/master
public class HintWindow extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_now);
    }

    public void onbackButtonCliked(View v){

        Toast.makeText(getApplicationContext(), "퍼즐 화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
        finish();
    }
}