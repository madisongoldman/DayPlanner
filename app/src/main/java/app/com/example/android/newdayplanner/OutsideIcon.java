package app.com.example.android.newdayplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OutsideIcon extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outside_icon);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btn = (Button) findViewById(R.id.submitbutton);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                RadioButton yesButton = (RadioButton) findViewById(R.id.yesbutton);
                RadioButton noButton = (RadioButton) findViewById(R.id.nobutton);

                if(selectedId == yesButton.getId()) {
                    String yes = "Great! If you're still feeling anxious, try some other methods from the Daily Reminders page";
                    displayMessage(yes);
                }
                else if (selectedId == noButton.getId()) {
                    String no = "Even if it's not physical activity, thirty minutes outside every day is a great way to manage depression or anxiety! Try reading in a park, going for a run, or even just taking a walk around your neighborhood.";
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
