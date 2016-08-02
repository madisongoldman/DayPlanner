package app.com.example.android.newdayplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class ShowerIcon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_icon);
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
                    String no = "A shower is a good 'reset' button for the day. Try showering, and if you're still feeling anxious, try some other methods from the Daily Reminders page";
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
