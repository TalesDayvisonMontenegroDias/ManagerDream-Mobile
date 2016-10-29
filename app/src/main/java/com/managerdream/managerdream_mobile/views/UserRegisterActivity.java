package com.managerdream.managerdream_mobile.views;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.managerdream.managerdream_mobile.R;
import com.managerdream.managerdream_mobile.dao.UserDao;
import com.managerdream.managerdream_mobile.entities.User;

public class UserRegisterActivity extends AppCompatActivity {
    private UserDao userDao;
    private EditText editTextCredit,editTextId;
    private Button btnAddData,btnviewAll,btnDelete,btnviewUpdate;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        userDao = new UserDao(this);

        editTextId = (EditText)findViewById(R.id.editText_id);
        editTextCredit = (EditText)findViewById(R.id.editText_credit);



        user = new User();

        btnAddData = (Button)findViewById(R.id.button_add);
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
                            user.setId(Integer.parseInt(editTextId.getText().toString()));
                            Integer deletedRows = userDao.delete(user);
                            if (deletedRows > 0)
                                Toast.makeText(UserRegisterActivity.this, "User Deleted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(UserRegisterActivity.this, "Unregistered User", Toast.LENGTH_LONG).show();

                        }
                        catch (NumberFormatException e){
                            Toast.makeText(UserRegisterActivity.this,"Invalid fields",Toast.LENGTH_LONG).show();
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
                            user.setCredit(Integer.parseInt(editTextCredit.getText().toString()));
                            user.setId(Integer.parseInt(editTextId.getText().toString()));

                            boolean isUpdate = userDao.update(user);
                            if(isUpdate == true)
                                Toast.makeText(UserRegisterActivity.this,"User Updated",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(UserRegisterActivity.this,"User not Updated",Toast.LENGTH_LONG).show();
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(UserRegisterActivity.this,"Invalid fields",Toast.LENGTH_LONG).show();
                        }
                        }
                }
        );
    }
    public  void Add() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            user.setCredit(Integer.parseInt(editTextCredit.getText().toString()));
                            user.setId(Integer.parseInt(editTextId.getText().toString()));

                            boolean isInserted = userDao.insert(user);
                            if(isInserted == true){
                                Toast.makeText(UserRegisterActivity.this,"User Inserted",Toast.LENGTH_LONG).show();
                                Intent InicialIntent = new Intent(v.getContext(), InicialActivity.class);
                                InicialIntent.putExtra("creditValue", editTextCredit.getText().toString());
                                startActivity(InicialIntent);
                            }
                            else
                                Toast.makeText(UserRegisterActivity.this,"User not Inserted",Toast.LENGTH_LONG).show();
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(UserRegisterActivity.this,"Invalid fields",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Cursor res = userDao.search();
                            if (res.getCount() == 0) {
                                showMessage("Error", "Nothing found");
                                return;
                            }

                            StringBuffer buffer = new StringBuffer();
                            while (res.moveToNext()) {
                                buffer.append("--USER--" + "\n");
                                buffer.append("Id :" + res.getString(0) + "\n");
                                buffer.append("Credit :" + res.getString(1) + "\n");
                            }

                            showMessage("Users", buffer.toString());
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

    public void onButtonClick(View v) {
        Button btnSwitch = (Button) findViewById(R.id.button_expense);

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserRegisterActivity.this,
                        ExpenseRegisterActivity.class));
            }
        });
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
