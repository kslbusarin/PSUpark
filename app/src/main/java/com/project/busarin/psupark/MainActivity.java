package com.project.busarin.psupark;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class MainActivity extends AppCompatActivity {


    public DatabaseReference myRef;

    private TextView mFirebaseTextView7;
    private TextView mFirebaseTextView8;
    private TextView mFirebaseTextView9;
    private TextView mFirebaseTextView10;
    private String values[] = {
            "empty",
            "empty",
            "empty",
            "empty"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseTextView7 = (TextView) findViewById(R.id.firebaseTextView7);
        mFirebaseTextView8 = (TextView) findViewById(R.id.firebaseTextView8);
        mFirebaseTextView9 = (TextView) findViewById(R.id.firebaseTextView9);
        mFirebaseTextView10 = (TextView) findViewById(R.id.firebaseTextView10);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){

                Map map1 = (Map) dataSnapshot.child("building_a").getValue();
                values[0] = String.valueOf(map1.get("a07"));
                if (values[0].equals(String.valueOf("busy"))){
                    mFirebaseTextView7.setText("busy");
                    mFirebaseTextView7.setTextColor(Color.RED);}
                else{
                    mFirebaseTextView7.setText("empty");
                    mFirebaseTextView7.setTextColor(Color.BLACK);
                }

                values[1] = String.valueOf(map1.get("a08"));
                if (values[1].equals(String.valueOf("busy"))){
                    mFirebaseTextView8.setText("busy");
                    mFirebaseTextView8.setTextColor(Color.RED); }
                else{
                    mFirebaseTextView8.setText("empty");
                    mFirebaseTextView8.setTextColor(Color.BLACK);
                }
                values[2] = String.valueOf(map1.get("a09"));
                if (values[2].equals(String.valueOf("busy"))){
                    mFirebaseTextView9.setText("busy");
                    mFirebaseTextView9.setTextColor(Color.RED); }
                else{
                    mFirebaseTextView9.setText("empty");
                    mFirebaseTextView9.setTextColor(Color.BLACK);
                }

                values[3] = String.valueOf(map1.get("a10"));
                if (values[3].equals(String.valueOf("busy"))){
                    mFirebaseTextView10.setText("busy");
                    mFirebaseTextView10.setTextColor(Color.RED); }
                else{
                    mFirebaseTextView10.setText("empty");
                    mFirebaseTextView10.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });
    }
}
