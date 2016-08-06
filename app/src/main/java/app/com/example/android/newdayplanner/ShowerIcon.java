package app.com.example.android.newdayplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ShowerIcon extends AppCompatActivity {

    private RadioGroup radioGroup2;
    private RadioButton radioButton2;
    private Button btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_icon);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup);
        btn2 = (Button) findViewById(R.id.submitbutton);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup2.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton2 = (RadioButton) findViewById(selectedId);

                RadioButton yesButton = (RadioButton) findViewById(R.id.yesbutton);
                RadioButton noButton = (RadioButton) findViewById(R.id.nobutton);

                if(selectedId == yesButton.getId()) {
                    String yes = "Great! If you're still feeling anxious, try some other methods from the Daily Reminders page";
                    displayMessage(yes);
                }
                else if (selectedId == noButton.getId()) {
                    String no = "A shower is a good 'reset' button for the day. Try showering, and if you're still feeling anxious, try some other methods from the Daily Reminders page";
                    displayMessage(no);
                }

            }

        });


    }

    private void displayMessage(String message) {
        TextView messageTextView = (TextView) findViewById(R.id.messageTextView);
        messageTextView.setText(message);
    }


}