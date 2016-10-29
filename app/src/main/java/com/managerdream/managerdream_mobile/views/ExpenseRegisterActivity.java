package com.managerdream.managerdream_mobile.views;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.managerdream.managerdream_mobile.R;
import com.managerdream.managerdream_mobile.dao.ExpenseDao;
import com.managerdream.managerdream_mobile.entities.Expense;

/**
 * Created by Home on 28/10/2016.
 */

public class ExpenseRegisterActivity extends AppCompatActivity {
    private ExpenseDao expenseDao;
    private EditText editTextPrice,editTextId, editTextDescription;
    private Button btnAdd,btnviewAll,btnDelete,btnviewUpdate;
    private Expense expense;

    private Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_register);
        Firebase.setAndroidContext(this);
        expenseDao = new ExpenseDao(this);

        editTextPrice = (EditText)findViewById(R.id.editText_price);
        editTextId = (EditText)findViewById(R.id.editText_id);
        editTextDescription = (EditText)findViewById(R.id.editText_description);

        firebase = new Firebase("https://managerdream-mobile.firebaseio.com/");
        expense = new Expense();

        btnAdd = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);

        Add();
        viewAll();
        Update();
        Delete();
    }
    public void Delete() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            expense.setId(Integer.parseInt(editTextId.getText().toString()));
                            Integer deletedRows = expenseDao.delete(expense);
                            if (deletedRows > 0) {
                                Firebase child = firebase.child("Expense" + expense.getId());
                                child.setValue(null);
                                Toast.makeText(ExpenseRegisterActivity.this, "User Deleted", Toast.LENGTH_LONG).show();
                            }else
                                Toast.makeText(ExpenseRegisterActivity.this, "Unregistered User", Toast.LENGTH_LONG).show();

                        }
                        catch (NumberFormatException e){
                            Toast.makeText(ExpenseRegisterActivity.this,"Invalid fields",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public void Update() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            expense.setPrice(Integer.parseInt(editTextPrice.getText().toString()));
                            expense.setDescription(editTextDescription.getText().toString());
                            expense.setId(Integer.parseInt(editTextId.getText().toString()));

                            boolean isUpdate = expenseDao.update(expense);
                            if(isUpdate == true) {
                                Firebase child = firebase.child("Expense" + expense.getId());
                                child.setValue(expense);
                                Toast.makeText(ExpenseRegisterActivity.this, "User Updated", Toast.LENGTH_LONG).show();
                            }else
                                Toast.makeText(ExpenseRegisterActivity.this,"User not Updated",Toast.LENGTH_LONG).show();
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(ExpenseRegisterActivity.this,"Invalid fields",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public  void Add() {
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            expense.setPrice(Integer.parseInt(editTextPrice.getText().toString()));
                            expense.setDescription(editTextDescription.getText().toString());
                            expense.setId(Integer.parseInt(editTextId.getText().toString()));

                            boolean isInserted = expenseDao.insert(expense);
                            if(isInserted == true){
                                Firebase child = firebase.child("Expense" + expense.getId());
                                child.setValue(expense);
                                Toast.makeText(ExpenseRegisterActivity.this,"User Inserted",Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(ExpenseRegisterActivity.this,"User not Inserted",Toast.LENGTH_LONG).show();
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(ExpenseRegisterActivity.this,"Invalid fields",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void viewAll()  {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Cursor res = expenseDao.search();
                            if (res.getCount() == 0) {
                                showMessage("Error", "Nothing found");
                                return;
                            }

                            StringBuffer buffer = new StringBuffer();
                            while (res.moveToNext()) {
                                buffer.append("--EXPENSE--" + "\n");
                                buffer.append("Id :" + res.getString(0) + "\n");
                                buffer.append("Price :" + res.getString(1) + "\n");
                                buffer.append("Description: " + res.getString(2)+ "\n");
                            }
                            showMessage("Expenses", buffer.toString());
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
