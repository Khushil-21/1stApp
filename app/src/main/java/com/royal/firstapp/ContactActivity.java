package com.royal.firstapp;

import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactActivity extends AppCompatActivity {

    ImageButton imgBtnCall;
    ImageButton imgBtnChat;
    ImageButton imgBtnPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgBtnCall = findViewById(R.id.imgBtnCall);
        imgBtnChat  = findViewById(R.id.imgBtnChat);
        imgBtnPerson = findViewById(R.id.imgBtnPerson);

        Drawable chatTwoTone = ContextCompat.getDrawable(getApplicationContext(),R.drawable.chat_twotone_32);
        Drawable chatOutline = ContextCompat.getDrawable(getApplicationContext(),R.drawable.chat_outline_32);

        Drawable callTwoTone = ContextCompat.getDrawable(getApplicationContext(),R.drawable.call_twotone_32);
        Drawable callOutline  = ContextCompat.getDrawable(getApplicationContext(),R.drawable.call_outline_32);

        Drawable personTwoTone = ContextCompat.getDrawable(getApplicationContext(),R.drawable.person_twotone_32);
        Drawable personOutline  = ContextCompat.getDrawable(getApplicationContext(),R.drawable.person_outline_32);


        imgBtnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnCall.setImageDrawable(callOutline);
                imgBtnChat.setImageDrawable(chatTwoTone);
                imgBtnPerson.setImageDrawable(personOutline);
            }
        });

        imgBtnPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnCall.setImageDrawable(callOutline);
                imgBtnChat.setImageDrawable(chatOutline);
                imgBtnPerson.setImageDrawable(personTwoTone);
            }
        });

        imgBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnCall.setImageDrawable(callTwoTone);
                imgBtnChat.setImageDrawable(chatOutline);
                imgBtnPerson.setImageDrawable(personOutline);
            }
        });



    }
}