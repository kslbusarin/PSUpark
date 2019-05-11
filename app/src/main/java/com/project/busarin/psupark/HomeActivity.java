package com.project.busarin.psupark;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private ImageView mImage1;
    private ImageView mImage2;

    public DatabaseReference myRef;
    private TextView mAvailable2;
    private TextView mValues2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindWidget();
        setWidgetEventListener();

        mAvailable2 = (TextView) findViewById(R.id.available2);
        mValues2 = (TextView) findViewById(R.id.values2);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map1 = (Map) dataSnapshot.child("building_a").getValue();
                String avai = String.valueOf(map1.get("a00"));
                mAvailable2.setText(avai);
                String valu = String.valueOf(map1.get("a01"));
                mValues2.setText(valu);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void setWidgetEventListener(){

        mImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Main7Activity.class));
            }
        });

        mImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    private void bindWidget(){
        mImage1 = (ImageView)findViewById(R.id.image1);
        mImage2 = (ImageView)findViewById(R.id.image2);
    }
}
