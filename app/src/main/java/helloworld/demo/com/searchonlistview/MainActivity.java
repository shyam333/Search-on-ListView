package helloworld.demo.com.searchonlistview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editTextView;
    //List<Model> ItemModelList;
    CustomAdaptor customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        editTextView = (EditText) findViewById(R.id.txt);
        //ItemModelList = new ArrayList<Model>();
        customAdapter = new CustomAdaptor(this.getApplicationContext());//, ItemModelList);
        listView.setEmptyView(findViewById(R.id.listview));
        listView.setAdapter(customAdapter);

    }

    @SuppressLint("NewApi")
    public void addValue(View v) {
        String name = editTextView.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Plz enter Values",
                    Toast.LENGTH_SHORT).show();
        } else {
            Model md = new Model(name);
            customAdapter.addItem(md);
            //ItemModelList.add(md);
            //customAdapter.notifyDataSetChanged();
            editTextView.setText("");
        }
    }
}




