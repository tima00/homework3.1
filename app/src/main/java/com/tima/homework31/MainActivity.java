package com.tima.homework31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private  Button openBtn;
    private EditText editText;

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         openBtn = findViewById(R.id.open_btn);
         editText = findViewById(R.id.text_view);
         image = findViewById(R.id.image);

        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("text",editText.getText().toString());
                startActivity(intent);
            }
        });


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        startActivity(intent);
        Intent intent1 = new Intent(Intent.EXTRA_TEXT);
        startActivityForResult(intent,2);





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode==2){
            image.setImageURI(data.getData());
        }
    }
}