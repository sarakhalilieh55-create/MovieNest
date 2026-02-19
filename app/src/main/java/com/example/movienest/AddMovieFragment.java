package com.example.movienest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.provider.MediaStore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;




public class AddMovieFragment extends Fragment {
    private static final int GALLERY_REQUEST_CODE = 123;
    ImageView img;
    private String imageStr;
    private EditText etnamemovie,etnameseries,ettime,etyear,etsummarize,
            ettype,etproducers,etactors,etphoto;
    private Button btnAddmovie;
    private FirebaseServices fbs;
    // Required empty public constructor
    private float utils;




    String[] years={"select year of car","2023","2022","2021","2020","2019","2018","2017","2016","2015","2014",
            "2013","2012","2011","2010","2009","2008","2007","2006","2005","2004",
            "2003","2002","2001","2000"," Other..."};




    private AdapterView<Adapter> AdapterView;
    private String namemovie;
    private String nameseries;
    private String time;
    private String summarize;
    private String type;
    private String producers;
    private String actors;
    private String photo;
    private String year;
    private Throwable ex;
    private Movie movie;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    @SuppressLint("WrongViewCast")
    private void init() {
        // ---->    פרטי הוספת רכב    <----
        //editText
        fbs=FirebaseServices.getInstance();
        etnamemovie=getView().findViewById(R.id.etnamemovieAddMovieFragment);
        etnameseries=getView().findViewById(R.id.etnameseriesAddMovieFragment);
        ettime=getView().findViewById(R.id.ettimeAddMovieFragment);
        etyear=getView().findViewById(R.id.etyearAddMovieFragment);
        etsummarize=getView().findViewById(R.id.etsummarizeAddMovieFragment);
        ettype=getView().findViewById(R.id.ettypeAddMovieFragment);
        etproducers=getView().findViewById(R.id.etproducersAddMovieFragment);
        etactors=getView().findViewById(R.id.etactorsAddMovieFragment);
        etphoto=getView().findViewById(R.id.etphotoAddMovieFragment);
        btnAddmovie=getView().findViewById(R.id.btnAddmovieAddMovieFragment);
        img = getView().findViewById(R.id.ivmovieAddMovieFragment);

        {
            btnAddmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // adding to firestore  'car' collection

                addToFirestore();
            }

                private void addToFirestore() {

                }
            });




        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

    }



        namemovie=etnamemovie.getText().toString();
        nameseries=etnameseries.getText().toString();
        time=ettime.getText().toString();
        year=etyear.getText().toString();
        summarize = etsummarize.getText().toString();
        type=ettype.getText().toString();
        producers=etproducers.getText().toString();
        actors=etactors.getText().toString();
        photo=etphoto.getText().toString();


        if (namemovie.trim().isEmpty()                                        ||
                nameseries.trim().isEmpty()                                ||
                time.trim().isEmpty()                                     ||
                year.trim().isEmpty()                                      ||
                summarize.trim().isEmpty()                                    ||
                type.trim().isEmpty()                               ||
                producers.trim().isEmpty()                                       ||
                actors.trim().isEmpty()                                  ||
                photo.trim().isEmpty() );


        {
            Toast.makeText(getActivity(), "sorry some data missing incorrect !", Toast.LENGTH_SHORT).show();
            return;
        }


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
            img.setImageURI(selectedImageUri);

        }
    }

    public void gotoCarList() {

        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new CarListMapFragment());
        ft.commit();
    }

    public void toBigImg(View view) {
    }


    private class CarListMapFragment extends Fragment {
    }
}