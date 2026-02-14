package com.example.movienest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.graphics.shapes.Utils;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.auth.User;

<<<<<<< HEAD

public class SignupFragment extends Fragment {
    private static final int GALLERY_REQUEST_CODE = 123;
    private EditText etUsername, etPassword, etConfirmPassword,
=======
public class SignupFragment extends Fragment {
    private static final int GALLERY_REQUEST_CODE = 123;
    private EditText etUsername,etPassword, etConfirmPassword,
>>>>>>> 60da0d6 (newer one)
            etFirstname, etLastname, etPhone, etAddress;
    ImageView ivUserPhoto;
    private Button btnSignup;
    private FirebaseServices fbs;
    private Object msg = distance();

<<<<<<< HEAD

=======
>>>>>>> 60da0d6 (newer one)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }
<<<<<<< HEAD

=======
>>>>>>> 60da0d6 (newer one)
    @Override
    public void onStart() {
        super.onStart();
        // connecting components
<<<<<<< HEAD
        fbs = FirebaseServices.getInstance();
        etUsername = getView().findViewById(R.id.etUsernameSignup);
        etPassword = getView().findViewById(R.id.etPasswordSignup);
=======
        fbs=FirebaseServices.getInstance();
        etUsername=getView().findViewById(R.id.etUsernameSignup);
        etPassword=getView().findViewById(R.id.etPasswordSignup);
>>>>>>> 60da0d6 (newer one)
        etFirstname = getView().findViewById(R.id.etFirstnameSignupFragment);
        etLastname = getView().findViewById(R.id.etLastnameSignupFragment);
        etConfirmPassword = getView().findViewById(R.id.etConfirmPasswordSignupFragment);
        etPhone = getView().findViewById(R.id.etPhoneSignupFragment);
        etAddress = getView().findViewById(R.id.etAddressSignupFragment);
<<<<<<< HEAD
        btnSignup = getView().findViewById(R.id.btnSignupSignup);
=======
        btnSignup=getView().findViewById(R.id.btnSignupSignup);
>>>>>>> 60da0d6 (newer one)
        ivUserPhoto = getView().findViewById(R.id.ivPhotoSignupFragment);
        ivUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Data validation
<<<<<<< HEAD
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
=======
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();
>>>>>>> 60da0d6 (newer one)
                String confirmPassword = etConfirmPassword.getText().toString();
                String firstname = etFirstname.getText().toString();
                String lastname = etLastname.getText().toString();
                String phone = etPhone.getText().toString();
                String address = etAddress.getText().toString();
                if (username.trim().isEmpty() || password.trim().isEmpty() || firstname.trim().isEmpty() ||
                        lastname.trim().isEmpty() || confirmPassword.trim().isEmpty() || phone.trim().isEmpty() ||
<<<<<<< HEAD
                        address.trim().isEmpty()) {
=======
                        address.trim().isEmpty())
                {
>>>>>>> 60da0d6 (newer one)
                    Toast.makeText(getActivity(), "some fields are empty", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (!password.equals(confirmPassword)) {
                    msg.toString();
                    return;
                }

//                if(fbs.getSelectedImageURL() == null){
//                    msg.showMessageDialog(getActivity(), "Image are Empty !");
//
//                }


//                if (fbs.getSelectedImageURL() == null)
//                {
//                    com.example.movienest.User user = new com.example.movienest.User(firstname, lastname, username, phone, address, "");
//                }
//                else {
//                    com.example.movienest.User user = new com.example.movienest.User(firstname, lastname, username, phone, address, fbs.getSelectedImageURL().toString());
//                }
                //Signup procedure
                Uri selectedImageUri = fbs.getSelectedImageURL();
                String imageURL = "";
                if (selectedImageUri != null) {
                    imageURL = selectedImageUri.toString();
                }
                @SuppressLint("RestrictedApi") User user = new User(firstname);

<<<<<<< HEAD
                fbs.getAuth().createUserWithEmailAndPassword(username, password)
=======
                fbs.getAuth().createUserWithEmailAndPassword(username,password)
>>>>>>> 60da0d6 (newer one)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

<<<<<<< HEAD
                                if (task.isSuccessful()) {
=======
                                if (task.isSuccessful())
                                {
>>>>>>> 60da0d6 (newer one)
                                    fbs.getFire().collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            gotoCarList();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.e("SignupFragment: signupOnClick: ", e.getMessage());
                                        }
                                    });
                                    // String firstName, String lastName, String username, String phone, String address, String photo) {
                                    Toast.makeText(getActivity(), "you have succesfully signed up", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
                                } else {
=======
                                }
                                else
                                {
>>>>>>> 60da0d6 (newer one)
                                    Toast.makeText(getActivity(), "failed to sign up! check user or password", Toast.LENGTH_SHORT).show();

                                }

                            }
                        });


            }
        });
<<<<<<< HEAD

=======
>>>>>>> 60da0d6 (newer one)
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == getActivity().RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            ivUserPhoto.setImageURI(selectedImageUri);

        }
    }

    private Object distance() {
        return getUtils();
    }

    @Nullable
    private static Utils getUtils() {
        return null;
    }

<<<<<<< HEAD
    public void gotoCarList() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main, new SignupFragment());
        ft.commit();

    }
}
=======
    public void gotoCarList()
    {
        FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout,new SignupFragment());
        ft.commit();
    }

}
>>>>>>> 60da0d6 (newer one)
