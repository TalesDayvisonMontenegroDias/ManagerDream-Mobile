package com.managerdream.managerdream_mobile.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.managerdream.managerdream_mobile.R;
import com.managerdream.managerdream_mobile.entities.Expense;

public class InicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
    }

    public void onButtonClick(View v) {
        Button btnSwitchToUser = (Button) findViewById(R.id.button_rent);

        btnSwitchToUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicialActivity.this,
                        UserRegisterActivity.class));
            }
        });

        Button btnSwitchToExpense = (Button) findViewById(R.id.button_expense);
        btnSwitchToExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicialActivity.this,
                        ExpenseRegisterActivity.class));
            }
        });
    }

}
