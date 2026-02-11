package com.example.movienest;

import android.annotation.SuppressLint;

import com.google.firebase.firestore.auth.User;

public abstract class UserCallback {
    public abstract void onUserLoaded(@SuppressLint("RestrictedApi") User user);
}
