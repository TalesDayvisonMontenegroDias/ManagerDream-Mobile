package com.managerdream.managerdream_mobile.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.managerdream.managerdream_mobile.R;

public class SetCategory extends AppCompatActivity {

    private Button btnAddFood, btnAddRecreation, btnAddCreditCard, btnAddWater, btnAddLight,
            btnAddPhone, btnAddNet, btnAddEducation, btnAddRent, btnAddSecure, btnAddTransport, btnAddOther, btnAddTV;

    public String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_category);

        btnAddFood = (Button) findViewById(R.id.btnFood);
        btnAddCreditCard = (Button) findViewById(R.id.btnCreditCard);
        btnAddWater = (Button) findViewById(R.id.btnWater);
        btnAddEducation = (Button) findViewById(R.id.btnEducation);
        btnAddLight = (Button) findViewById(R.id.btnLight);
        btnAddNet = (Button) findViewById(R.id.btnNet);
        btnAddPhone = (Button) findViewById(R.id.btnPhone);
        btnAddRent = (Button) findViewById(R.id.btnRent);
        btnAddTransport = (Button) findViewById(R.id.btnTransport);
        btnAddSecure = (Button) findViewById(R.id.btnSecure);
        btnAddRecreation = (Button) findViewById(R.id.btnRecreation);
        btnAddTV = (Button) findViewById(R.id.btnTV);
        btnAddOther = (Button) findViewById(R.id.bntOther);

        btnAddFood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddFood.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);

                    }
                }
        );

        btnAddCreditCard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddCreditCard.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddWater.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddWater.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddEducation.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddEducation.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddLight.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddLight.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddNet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddNet.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddPhone.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddPhone.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddRent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddRent.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddTransport.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddTransport.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddSecure.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddSecure.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddRecreation.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddRecreation.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddTV.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddTV.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
        btnAddOther.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        categoryName = btnAddOther.getText().toString();
                        Intent myIntent = new Intent(v.getContext(), ExpenseRegisterActivity.class);
                        myIntent.putExtra("categoryName", categoryName);
                        startActivity(myIntent);
                    }
                }
        );
    }

}
