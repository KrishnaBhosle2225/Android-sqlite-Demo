package com.krishna.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    String TAG = "SQLite Demo";
    Button btnDelete;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDelete = findViewById(R.id.btnDelete);
        db = new DatabaseHandler(this);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Deleting Record:...");
                db.deleteContact(new Contact(1, "Ajya", "99999"));
                readData();

            }
        });


//        Log.d(TAG, "Inserting Values");
//
        db.addContact(new Contact("Krushna", "55555"));
        db.addContact(new Contact("Sarvesh","9767113360"));
        db.addContact(new Contact("Bhagesh","7620252922"));


        Log.d(TAG, "Data Count: " + db.getContactCount());

        Log.d(TAG, "Reading Record ");
        readData();


    }

    public void readData() {
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String contactDetails = "Id :" + cn.getID() + ", Name :" + cn.getName() + ", Phone Number :" + cn.getPhoneNumber();

            Log.d(TAG, "Data : " + contactDetails);
        }
    }
}