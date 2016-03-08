package com.example.student.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends ActionBarActivity {


    public static int[] BtnNumberIds = {
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txt = (EditText)findViewById(R.id.editText);


        for(int i = 0; i < BtnNumberIds.length; i++ ){
            final Button btn = (Button)findViewById(BtnNumberIds[i]);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vw) {
                    txt.setText(txt.getText().toString() + btn.getText().toString());
                }
            });
        }

        final ImageButton btnBack = (ImageButton)findViewById(R.id.button_delete);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                String s = txt.getText().toString();
                if(s.length() > 0)
                    txt.setText(s.substring(0, s.length() - 1));
            }
        });

        final ImageButton btncall = (ImageButton)findViewById(R.id.button_call);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + txt.getText().toString()));
                startActivity(intent);    		}
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
