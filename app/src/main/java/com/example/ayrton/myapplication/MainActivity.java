package com.example.ayrton.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.database.Cursor;
import android.content.ContentResolver;
import android.app.Dialog;
import android.app.AlertDialog;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void loadBBC(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bbc.co.uk/news")));
    }

    public void dialNumber(View view) {
        Intent result = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"));
        startActivity(result);
    }

    public void openContacts(View view) {
        ArrayList contactList = new ArrayList();


        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null,null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                contactList.add(name);
                System.out.println(contactList);
            }
            AlertDialog.Builder alertDialogBuild = new AlertDialog.Builder(this);
            alertDialogBuild.setTitle("Contacts");
            alertDialogBuild.setMessage(contactList.toString());
           // alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            AlertDialog alertDialog = alertDialogBuild.create();
            alertDialog.show();
        }
    }

    public void loadShapeActivity(View view) {
        Intent intent = new Intent(this, Shapes.class);
        startActivity(intent);

    }

    public void loadMap(View view) {

        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Swansea University+SA2 8PP");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        System.out.println("Map");
      //  if (mapIntent.resolveActivity(getPackageManager()) != null) {
            System.out.println("if works");
            startActivity(mapIntent);

       // }

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
