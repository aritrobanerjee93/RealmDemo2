package com.example.realmdemo2;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        name = findViewById(R.id.main_name_et);
        email = findViewById(R.id.main_email_et);
        phone = findViewById(R.id.main_phone_et);
        age = findViewById(R.id.main_age_et);
    }

    public void onSubmitPressed(View view){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        try {
            Person person = realm.createObject(Person.class, System.currentTimeMillis() / 1000);
            person.setName(name.getText().toString());
            person.setEmail(email.getText().toString());
            person.setPhone(phone.getText().toString());
            person.setAge(Integer.parseInt(age.getText().toString()));
            realm.commitTransaction();
            Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex){
            realm.cancelTransaction();
            Toast.makeText(mContext, "Failure" + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    public void onDisplayButtonPressed(View view){
        Intent intent = new Intent(this,DisplayActivity.class);
        startActivity(intent);
    }
}
