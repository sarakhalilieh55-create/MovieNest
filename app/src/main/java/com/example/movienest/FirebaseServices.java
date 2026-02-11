package com.example.movienest;

import android.annotation.SuppressLint;
import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.auth.User;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class FirebaseServices {
    private Object currentUser;
    private FirebaseAuth auth;

    @SuppressLint("RestrictedApi")
    public static FirebaseServices getInstance() {

        FirebaseServices o = null;
        return o;
    }

    public static FirebaseServices reloadInstance() {
        return null;
    }

    public void setCurrentUser(@SuppressLint("RestrictedApi") User currentUser) {
        this.currentUser = currentUser;
    }


    public FirebaseAuth getAuth() {
        return auth;
    }

    public void setAuth(FirebaseAuth auth) {
        this.auth = auth;
    }

    public DocumentReference getFire() {
        return null;
    }

    public Uri getSelectedImageURL() {

        return null;
    }

    public void setSelectedImageURL(Uri uri) {
    }

    public AtomicMarkableReference<Object> getStorage() {
        AtomicMarkableReference<Object> o = null;
        return o;
    }


}
    
