package com.example.dell.apptest;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CustomView customView;
    Button add,drop;
    EditText edit;
    MyDbHandler myDbHandler;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        myDbHandler=new MyDbHandler(this,null,null,1);

        printDatabase();
        //a custom view (bitmap animated)
        customView=new CustomView(this);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        initializer();
        printDatabase();
        
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Products products = new Products(edit.getText().toString());
                myDbHandler.addProduct(products);
                printDatabase();

            }
        });

        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDbHandler.deleteProduct(edit.getText().toString());
                printDatabase();
            }
        });
    }

    void initializer(){
    
        add=(Button)findViewById(R.id.b1);
        drop=(Button)findViewById(R.id.b2);
        edit=(EditText)findViewById(R.id.edit);      
    }

    void printDatabase(){

        String content=myDbHandler.dbToString();
        text.setText(content);
    }
}
