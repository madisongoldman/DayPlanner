package app.com.example.android.newdayplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class WaterIcon extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_icon);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String totalMessage = quantity + " glasses";
        String message = null;
        if (quantity < 8) {
            message = "Keep going! You should be drinking 8 glasses of water a day. You only need " + (8 - quantity) + " more!";
        } else {
            message = "Good job! You've drank the recommended amount of water today!";
        }
        displayMessage(totalMessage);
        displayMessage(message);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView totalGlassesView = (TextView) findViewById(R.id.quantity);
        totalGlassesView.setText(message);
    }

    //Increment button
    public void increment(View view) {
        quantity += 1;
        display(quantity);
    }

    //Decrement button
    public void decrement(View view) {
        quantity -= 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.total_glasses);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given total on the screen.
     */
    private void displayTotal(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.total_glasses);
        priceTextView.setText(number);
    }

    /*public void openNewActivity(View view) {
        Intent intent = new Intent(WaterIcon.this,DailyChecklist.class);
        startActivity(intent);
    }
    */


}

