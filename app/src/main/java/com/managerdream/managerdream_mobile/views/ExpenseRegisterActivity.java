package com.managerdream.managerdream_mobile.views;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.managerdream.managerdream_mobile.R;
import com.managerdream.managerdream_mobile.dao.ExpenseDao;
import com.managerdream.managerdream_mobile.entities.Expense;

/**
 * Created by Home on 28/10/2016.
 */

public class ExpenseRegisterActivity extends SetCategory {

    private ExpenseDao expenseDao;
    private EditText editTextPrice,editTextId, editTextDescription;
    private Button btnAdd, btnviewAll, btnDelete,btnviewUpdate, btnAddCategory;
    private Expense expense;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_register);
        expenseDao = new ExpenseDao(this);

        editTextPrice = (EditText)findViewById(R.id.editText_price);
        editTextId = (EditText)findViewById(R.id.editText_id);
        editTextDescription = (EditText)findViewById(R.id.editText_description);



        expense = new Expense();

        btnAdd = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);


        btnAddCategory = (Button) findViewById(R.id.btnAddCategory);


        btnAddCategory.setText(getIntent().getStringExtra("categoryName"));

        if(btnAddCategory.getText().equals("")){

            btnAddCategory.setText("Category");
        }


        btnAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpenseRegisterActivity.this,
                        SetCategory.class));


            }
        });


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
                            if (deletedRows > 0)
                                Toast.makeText(ExpenseRegisterActivity.this, "User Deleted", Toast.LENGTH_LONG).show();
                            else
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
                            expense.setCategory(btnAddCategory.getText().toString());

                            boolean isUpdate = expenseDao.update(expense);
                            if(isUpdate == true){
                                Toast.makeText(ExpenseRegisterActivity.this,"User Updated",Toast.LENGTH_LONG).show();
                                Intent InicialIntent = new Intent(v.getContext(), InicialActivity.class);
                                InicialIntent.putExtra("creditValue", editTextPrice.getText().toString());
                                startActivity(InicialIntent);

                                }
                            else
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
                            expense.setCategory(btnAddCategory.getText().toString());

                            boolean isInserted = expenseDao.insert(expense);
                            if(isInserted == true){
                                Toast.makeText(ExpenseRegisterActivity.this,"User Inserted",Toast.LENGTH_LONG).show();
                                Intent InicialIntent = new Intent(v.getContext(), InicialActivity.class);
                                InicialIntent.putExtra("creditValue", editTextPrice.getText().toString());
                                startActivity(InicialIntent);
                            }
                            else
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
                                buffer.append("Category :" + res.getString(3) + "\n");
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
