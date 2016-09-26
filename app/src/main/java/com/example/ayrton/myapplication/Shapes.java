package com.example.ayrton.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import yuku.ambilwarna.AmbilWarnaDialog;


public class Shapes extends ActionBarActivity {
    private int selectedColor = 0xffffff00;
    private ShapeDrawable drawable;
    private Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    private Canvas canvas = new Canvas(b);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);


        /*spinner code */
        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"Square", "Triangle", "octogon", "Pentagon", "Circle", "Rectangle"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shapes, menu);
        return true;
    }

    public void selectColor(View view) {


         AmbilWarnaDialog dialog = new AmbilWarnaDialog(Shapes.this, 0xff000000, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                selectedColor = color;
                System.out.println("User selected" + selectedColor);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }
        });

            dialog.show();
    }

  /*---------------------------------------------------

   */


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
