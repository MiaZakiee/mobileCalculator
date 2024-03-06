package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {
    Boolean isOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        BUTTONS
        Button btnZero = (Button) findViewById(R.id.btnZero);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSub = (Button) findViewById(R.id.btnSub);
        Button btnMul = (Button) findViewById(R.id.btnMul);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnDec = (Button) findViewById(R.id.btnDec);

        TextView tvDown = (TextView) findViewById(R.id.tvDown);
        TextView tvUp = (TextView) findViewById(R.id.tvUp);

        // CALCULATOR STACK
        Stack<Float> stacc = new Stack<>();
        StringBuilder up = new StringBuilder("");
        StringBuilder down = new StringBuilder("");
//       DOWN = ONLY 1 VALUE WHEN ADDING OR GETTING RESULT SHIT P
        List<Button> buttons = new ArrayList<>();

        buttons.add(btnZero);
        buttons.add(btnAdd);
        buttons.add(btnSub);
        buttons.add(btnMul);
        buttons.add(btnDiv);
        buttons.add(btnDec);
        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        buttons.add(btn9);

        for (Button b : buttons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (b.getText().toString()) {
                        case "+":
//                          checks if "down string" is empty
                            if (down.length() == 0 || up.length() == 0 || b.getText().toString().equals("+")) {
                                return;
                            } else {
                                up.append(down + " + ");
                                down.setLength(0);
                            }

                            break;
                        case "-":
                            break;
                        case "*":
                            break;
                        case "/":
                            break;
                        case ".":

                            break;
                        case "=":
                            break;
                        default:
                            isOperator = false;
                            down.append(b.getText().toString());
                            tvDown.setText(down);
                            break;
                    }
                }
            });
        }
    }
}