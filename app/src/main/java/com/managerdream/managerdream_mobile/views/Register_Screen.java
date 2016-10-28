package com.managerdream.managerdream_mobile.views;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.managerdream.managerdream_mobile.R;
import com.managerdream.managerdream_mobile.database.DatabaseHelper;

public class Register_Screen extends ActionBarActivity {
    DatabaseHelper myDb;
    EditText editTextCredit,editTextId;
    Button btnAddData,btnviewAll,btnDelete,btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__screen);
        myDb = new DatabaseHelper(this);

        editTextCredit = (EditText)findViewById(R.id.editText_credit);
        editTextId = (EditText)findViewById(R.id.editText_id);

        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Register_Screen.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register_Screen.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                                           editTextCredit.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Register_Screen.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register_Screen.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editTextCredit.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(Register_Screen.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register_Screen.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Credit :"+ res.getString(1)+"\n");
                        }

                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}