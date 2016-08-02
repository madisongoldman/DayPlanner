package app.com.example.android.newdayplanner;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageButton btn1, btn2, btn3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defineButtons();
    }

    public void defineButtons() {
        findViewById(R.id.toDoList).setOnClickListener(buttonClickListener);

        findViewById(R.id.dailyChecklist).setOnClickListener(buttonClickListener);
        findViewById(R.id.importantDates).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener () {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.toDoList:
                    startActivity(new Intent(MainActivity.this,ToDoList.class));
                    break;
                case R.id.dailyChecklist:
                    startActivity(new Intent(MainActivity.this,DailyChecklist.class));
                    break;
                case R.id.importantDates:
                    //startActivity(new Intent(MainActivity.this,ImportantDates.class));
                    Intent i = new Intent();

                    ComponentName cn = new ComponentName("com.android.calendar", "com.android.calendar.LaunchActivity");

                    i.setComponent(cn);
                    startActivity(i);

            }
        }
    };
}
