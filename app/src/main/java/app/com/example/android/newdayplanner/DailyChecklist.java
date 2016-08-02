package app.com.example.android.newdayplanner;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DailyChecklist extends AppCompatActivity {

    ImageButton btn1, btn2, btn3,btn4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_checklist);

        defineButtons();

    }

    public void defineButtons() {
        findViewById(R.id.waterIcon).setOnClickListener(buttonClickListener);
        findViewById(R.id.showerIcon).setOnClickListener(buttonClickListener);
        findViewById(R.id.outsideIcon).setOnClickListener(buttonClickListener);
        findViewById(R.id.goodThingsIcon).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener () {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.waterIcon:
                    startActivity(new Intent(DailyChecklist.this,WaterIcon.class));
                    break;
                case R.id.showerIcon:
                    startActivity(new Intent(DailyChecklist.this,ShowerIcon.class));
                    break;
                case R.id.outsideIcon:
                    startActivity(new Intent(DailyChecklist.this,OutsideIcon.class));
                    break;
                case R.id.goodThingsIcon:
                    startActivity(new Intent(DailyChecklist.this,GoodThingsIcon.class));

            }
        }
    };




}
