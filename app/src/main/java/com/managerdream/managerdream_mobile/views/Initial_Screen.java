package com.managerdream.managerdream_mobile.views;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.managerdream.managerdream_mobile.R;
import com.managerdream.managerdream_mobile.database.DatabaseHelper;

public class Initial_Screen extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private EditText userCredit, userID;
    private Button btnAddData, btnViewAllData, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial__screen);
        dbHelper = new DatabaseHelper(this);

        //userCredit = (EditText)findViewById(R.id.editUser_Credit);
        //userID = (EditText)findViewById(R.id,editUser_ID);

        //btnAddData = (Button)findViewById(R.id.button_add);
        //btnViewAllData = (Button)findViewById(R.id.button_viewAllData);
        //btnUpdate = (Button)findViewById(R.id.button_viewUpdate);

        addData();
        viewAllData();
        updateData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = dbHelper.insertData(userCredit.getText().toString());
                        if(isInserted = true)
                            Toast.makeText(Initial_Screen.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Initial_Screen.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAllData(){
        btnViewAllData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = dbHelper.getAllData();
                        if(res.getCount() == 0){
                            showMessage("Error","Empty DataBase");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("ID : " + res.getString(0)+"\n");
                            buffer.append("Credit: " + res.getString(1)+"\n");
                        }
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
    }

    public void updateData(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = dbHelper.updateData(userID.getText().toString(), userCredit.getText().toString());
                        if(isUpdated == true)
                            Toast.makeText(Initial_Screen.this,"Data Updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Initial_Screen.this,"Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_initial__screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
