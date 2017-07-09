package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateContactAcitivity extends Activity {

    private DatabaseReference Database;
    private Button submitButton;
    private EditText businessNumberField,nameField,primaryBusinessField,addressField,provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Database = FirebaseDatabase.getInstance().getReference();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        businessNumberField = (EditText) findViewById(R.id.businessNumber);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String ID = appState.firebaseReference.push().getKey();
        String businessNumber = businessNumberField.getText().toString();
        String name = nameField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact person = new Contact(ID,businessNumber,name,primaryBusiness,address,province);
        appState.firebaseReference.child(ID).setValue(person);
        Database.child("contacts").child(ID).setValue(person);
        finish();


    }
}
