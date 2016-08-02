package app.com.example.android.newdayplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class OutsideIcon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outside_icon);
    }

    public void onRadioButtonClicked(View view) {
        //Has the button been selected??
        boolean checked = ((RadioButton) view).isChecked();

        //Check which one was clicked
        switch(view.getId()) {
            case R.id.yesbutton:
                if (checked) {
                    String yes = "Great! If you're still feeling anxious, try some other methods from the Daily Reminders page";
                    displayMessage(yes);
                }
                break;

            case R.id.nobutton:
                if (checked) {
                    String no = "Even if it's not physical activity, thirty minutes outside every day is a great way to manage depression or anxiety! Try reading in a park, going for a run, or even just taking a walk around your neighborhood.";
                    displayMessage(no);
                }

                break;
        }
    }

    private void displayMessage(String message) {
        TextView messageTextView = (TextView) findViewById(R.id.messageTextView);
        messageTextView.setText(message);
    }


}
