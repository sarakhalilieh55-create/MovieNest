package com.example.movienest;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.UUID;

public class ImgActivity extends AppCompatActivity {
    ImageView imageView;
    Button btnSelect, btnUpload;

    Uri imageUri;

    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_img);

        imageView = findViewById(R.id.imageView);
        btnSelect = findViewById(R.id.btnSelect);
        btnUpload = findViewById(R.id.btnUpload);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        ActivityResultLauncher<String> imagePicker =
                registerForActivityResult(
                        new ActivityResultContracts.GetContent(),
                        uri -> {
                            if (uri != null) {
                                imageUri = uri;
                                imageView.setImageURI(uri);
                            }
                        });

        btnSelect.setOnClickListener(v ->
                imagePicker.launch("image/*")
        );

        btnUpload.setOnClickListener(v -> uploadImage());
    }

    private void uploadImage() {

        if (imageUri != null) {

            StorageReference fileRef = storageReference
                    .child("images/" + UUID.randomUUID().toString());

            fileRef.putFile(imageUri)
                    .addOnSuccessListener(taskSnapshot ->
                            Toast.makeText(this,
                                    "the photo has been uploaded successfully ",
                                    Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e ->
                            Toast.makeText(this,
                                    "the upload of the photo failed ",
                                    Toast.LENGTH_SHORT).show());
        }
    }
}