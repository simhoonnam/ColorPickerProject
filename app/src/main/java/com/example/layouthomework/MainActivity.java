package com.example.layouthomework;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button colorB;
    int color = 0xffffff00;
    private LinearLayout lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefault();
    }

    private void setDefault() {
        colorB = (Button) findViewById(R.id.colorButton);
        colorB.setOnClickListener(this);
        lay = (LinearLayout) findViewById(R.id.asdfasdf);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.colorButton:
                openDialog(false);
                break;
        }
    }

    void openDialog(boolean supportsAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(MainActivity.this, color, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
                lay.setBackgroundColor(color);
                MainActivity.this.color = color;
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}
