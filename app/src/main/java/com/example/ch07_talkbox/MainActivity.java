package com.example.ch07_talkbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvEmail;

    EditText tvNameChangEdt1, tvEmailChangEdt2;

    Button button1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("enter user information");

        tvNameChangEdt1 = findViewById(R.id.tvNameChangeEdt1);
        tvEmailChangEdt2 = findViewById(R.id.tvEmailChangeEdt2);
        button1 = findViewById(R.id.btn1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("enter user information");
                dlgEdtName = dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = dialogView.findViewById(R.id.dlgEdt2);
                dlgEdtName.setText(tvNameChangEdt1.getText().toString());
                dlgEdtEmail.setText(tvEmailChangEdt2.getText().toString());
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);


                dlg.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvNameChangEdt1.setText(dlgEdtName.getText().toString());
                                tvEmailChangEdt2.setText(dlgEdtEmail.getText().toString());
                            }
                        }
                );
                dlg.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast toast = new Toast(MainActivity.this);
                                Display displays = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                                int offsetX = (int) (displays.getWidth() * Math.random());
                                int offsetY = (int) (displays.getHeight() * Math.random());
                                toast.setGravity(Gravity.TOP | Gravity.LEFT, offsetX, offsetY);
                                toastView = View.inflate(MainActivity.this, R.layout.toast, null);
                                toastText = toastView.findViewById(R.id.toastText1);
                                toastText.setText("x::" + offsetX + "y::" + offsetY);
                                toast.setView(toastView);
                                toast.show();
//
//                            Random ran = new Random();
//                            double a =  Math.random()*300;
//                            double b =  Math.random()*300;
//                            int z = (int)a;
//                            int x = (int)b;
//
//                            toast.setGravity(Gravity.NO_GRAVITY, x, z);
//                            toastText.setText("x::"+z+"y::"+x);
//                            toast.setView(toastView);
//                            toast.show();
                            }
                        }
                );
                dlg.show();
            }
        });


    }
}