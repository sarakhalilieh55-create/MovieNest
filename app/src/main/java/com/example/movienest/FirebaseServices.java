package com.example.movienest;
<<<<<<< HEAD
import android.net.Uri;
=======

import android.net.Uri;

>>>>>>> 60da0d6 (newer one)
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

<<<<<<< HEAD

public class FirebaseServices {
    private static FirebaseServices instance;
=======
public class FirebaseServices {
    private  static FirebaseServices instance;
>>>>>>> 60da0d6 (newer one)
    private FirebaseAuth auth;
    private FirebaseFirestore fire;
    private FirebaseStorage storage;
    private Uri selectedImageURL;

    public Uri getSelectedImageURL() {
        return selectedImageURL;
    }

    public void setSelectedImageURL(Uri selectedImageURL) {
        this.selectedImageURL = selectedImageURL;
    }

<<<<<<< HEAD
    public FirebaseServices() {
        auth = FirebaseAuth.getInstance();
        fire = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();


    }


=======
    public  FirebaseServices ()
    {
        auth=FirebaseAuth.getInstance();
        fire=FirebaseFirestore.getInstance();
        storage=FirebaseStorage.getInstance();
    }

>>>>>>> 60da0d6 (newer one)
    public FirebaseAuth getAuth() {
        return auth;
    }

    public FirebaseFirestore getFire() {
        return fire;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

<<<<<<< HEAD
    public static FirebaseServices getInstance() {
        if (instance == null) {
            instance = new FirebaseServices();
=======
    public  static FirebaseServices getInstance(){
        if (instance==null){
            instance=new FirebaseServices();
>>>>>>> 60da0d6 (newer one)

        }
        return instance;
    }
<<<<<<< HEAD

}
=======
}
>>>>>>> 60da0d6 (newer one)
