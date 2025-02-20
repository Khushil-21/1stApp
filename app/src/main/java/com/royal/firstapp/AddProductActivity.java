package com.royal.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddProductActivity extends AppCompatActivity {
    //img 3edit 1tv 1buto

    Button btnSubmit;

    EditText edtName;
    EditText edtQty;
    EditText edtPrice;
    Spinner spinnerCategory;
    Button btnToContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        //  bind
        btnSubmit = findViewById(R.id.btnAddProductSubmit); //R  //binding
        edtName = findViewById(R.id.edtAddProductName);
        edtPrice = findViewById(R.id.edtAddProductPrice);
        edtQty = findViewById(R.id.edtAddProductQty);
        spinnerCategory = findViewById(R.id.spinnerAddProductCategory);
        btnToContact = findViewById(R.id.btnToProduct);

        String categories[] = {"Select Category", "MobilePhone 18%", "Accessories 28%", "HomeAppliances 9%"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinnerCategory.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("addproduct", "button clicked.....");

                boolean isError = false;
                String productName = edtName.getText().toString();
                String strPrice = edtPrice.getText().toString();//read -> String
                String strQty = edtQty.getText().toString();//read ->qty
                String category = spinnerCategory.getSelectedItem().toString();

                Log.i("addproduct", productName);
                Log.i("addproduct", strPrice);
                Log.i("addproduct", strQty);
                Log.i("category", category);


                //validation
                if (productName.isEmpty()) {
                    edtName.setError("ProductName Required");
                    isError = true;
                }

                if (strQty.isEmpty()) {
                    edtQty.setError("Qty Required");
                    isError = true;
                }

                if (strPrice.isEmpty()) {
                    edtPrice.setError("Price Required");
                    isError = true;
                }

                if (isError) {
                    Toast.makeText(getApplicationContext(), "Please correct Error(s)", Toast.LENGTH_LONG).show();
                } else {
                    //price
                    float payable = (Float.parseFloat(strQty) * Float.parseFloat(strPrice)) * getGST(category);
                    Toast.makeText(getApplicationContext(), "Total Payable : " + payable, Toast.LENGTH_LONG).show();
                }
                //calucalte price if no error
                //payable = totalPrice + gst
                ///      125000 + 18%gst

                //display on toaster
            }
        });

        btnToContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddProductActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

    }

    public float getGST(String category) {
        Log.i("category23", category);
        switch (category) {
            case "MobilePhone 18%":
                return 1.18f;
            case "Accessories 28%":
                return 1.28f;
            case "HomeAppliances 9%":
                return 1.09f;
            default:
                return 1.0f;
        }
    }
}