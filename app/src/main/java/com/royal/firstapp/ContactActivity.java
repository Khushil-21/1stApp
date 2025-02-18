package com.royal.firstapp;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.royal.firstapp.fragments.CallFragment;
import com.royal.firstapp.fragments.ChatFragment;
import com.royal.firstapp.fragments.PersonFragment;

public class ContactActivity extends AppCompatActivity {

    ImageButton imgBtnCall;
    ImageButton imgBtnChat;
    ImageButton imgBtnPerson;
    Button btnToProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this); // this is the reason of overlapping of the layout on top
        setContentView(R.layout.activity_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgBtnCall = findViewById(R.id.imgBtnCall);
        imgBtnChat  = findViewById(R.id.imgBtnChat);
        btnToProduct = findViewById(R.id.btnToProduct);
        imgBtnPerson = findViewById(R.id.imgBtnPerson);

        Drawable chatTwoTone = ContextCompat.getDrawable(getApplicationContext(),R.drawable.chat_twotone_32);
        Drawable chatOutline = ContextCompat.getDrawable(getApplicationContext(),R.drawable.chat_outline_32);

        Drawable callTwoTone = ContextCompat.getDrawable(getApplicationContext(),R.drawable.call_twotone_32);
        Drawable callOutline  = ContextCompat.getDrawable(getApplicationContext(),R.drawable.call_outline_32);

        Drawable personTwoTone = ContextCompat.getDrawable(getApplicationContext(),R.drawable.person_twotone_32);
        Drawable personOutline  = ContextCompat.getDrawable(getApplicationContext(),R.drawable.person_outline_32);

        imgBtnChat.setImageDrawable(chatTwoTone);
        imgBtnCall.setImageDrawable(callOutline);
        imgBtnPerson.setImageDrawable(personOutline);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameMasterContact,new ChatFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        imgBtnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnCall.setImageDrawable(callOutline);
                imgBtnChat.setImageDrawable(chatTwoTone);
                imgBtnPerson.setImageDrawable(personOutline);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameMasterContact,new ChatFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        imgBtnPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnCall.setImageDrawable(callOutline);
                imgBtnChat.setImageDrawable(chatOutline);
                imgBtnPerson.setImageDrawable(personTwoTone);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameMasterContact,new PersonFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        imgBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnCall.setImageDrawable(callTwoTone);
                imgBtnChat.setImageDrawable(chatOutline);
                imgBtnPerson.setImageDrawable(personOutline);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameMasterContact,new CallFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnToProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddProductActivity.class);
                startActivity(intent);
            }
        });




    }
}