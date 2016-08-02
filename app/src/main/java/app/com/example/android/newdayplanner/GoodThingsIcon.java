package app.com.example.android.newdayplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GoodThingsIcon extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "goodthings.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "goodthings.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        // ADD HERE
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        if (items.isEmpty()) {
            items.add("Use this to remind yourself of some good things");
            items.add("Hold to delete items");
        }



        setupListViewListener();
    }



    // Attaches a long click listener to the listview
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        writeItems();
                        return true;
                    }

                });
    }

   /* @Override
    public void onBackPressed() {
        try {
            Log.i("ON BACK PRESSED", "THE ON BACK PRESSED EVENT HAS OCCURED");

            PrintWriter pw = new PrintWriter(openFileOutput("ToDo.txt", Context.MODE_PRIVATE));

            for(String toDo : items) {
                pw.println(toDo);
            }

            pw.close();
        } catch(Exception e) {
            Log.i("ON BACK PRESSED",e.getMessage());
        }
    }
    */

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String toDo = etNewItem.getText().toString();
        itemsAdapter.add(toDo);
        etNewItem.setText("");
        writeItems();


    }
}
