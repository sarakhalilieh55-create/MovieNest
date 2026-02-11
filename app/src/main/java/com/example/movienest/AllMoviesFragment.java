package com.example.movienest;

import static com.example.movienest.R.id.frameLayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllMoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllMoviesFragment extends Fragment {
    private RecyclerView recyclerView;
    private FirebaseServices fbs;
    private myAdapter1 myAdapter;
    private ArrayList<Movie> list, filteredList;
    private FloatingActionButton btnAdd;
    private SearchView srchView;
    private Button favIcon;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllMoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllMoviesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllMoviesFragment newInstance(String param1, String param2) {
        AllMoviesFragment fragment = new AllMoviesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_movies, container, false);
    }
    public void onStart() {
        super.onStart();
        init();
    }

    private void init() {
        recyclerView = getView().findViewById(R.id.rvMovielist);
        btnAdd = getView().findViewById(R.id.floatingButtonAddMovieList);
        fbs = FirebaseServices.getInstance();
        //carsMap = new HashMap<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        filteredList = new ArrayList<>();
        //carsMap = getCarsMap();
        myAdapter = new myAdapter1(getActivity(), list);
        recyclerView.setAdapter(myAdapter);



        myAdapter.setOnItemClickListener(new myAdapter1.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click here
                String selectedItem = list.get(position).getNameCar();
                Toast.makeText(getActivity(), "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
                Bundle args = new Bundle();
                args.putParcelable("movie", list.get(position)); // or use Parcelable for better performance

                FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();

                ft.commit();
            }
        });

        fbs.getFire().collection("cars").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot dataSnapshot: queryDocumentSnapshots.getDocuments()){
                    Movie car= dataSnapshot.toObject(Movie.class);
                    list.add(car);
                }


                myAdapter.notifyDataSetChanged();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        srchView = getView().findViewById(R.id.srchViewAllMovieFragment);
        srchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                applyFilter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //applyFilter(newText);
                return false;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAllMovieFragment();
            }
        });
        btnAdd.setVisibility(View.INVISIBLE); // currently hidden

        ((MainActivity)getActivity()).pushFragment(new AllMoviesFragment());
    }

    private void applyFilter(String query) {
        // TODO: add onBackspace - old and new query
        if (query.trim().isEmpty())
        {
            myAdapter = new myAdapter1((FragmentActivity) getContext(), list);
            recyclerView.setAdapter(myAdapter);
            //myAdapter.notifyDataSetChanged();
            return;
        }
        filteredList.clear();
        for(Movie movie : list)
        {
            if (movie.getnamemovie().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getnameseries().toLowerCase().contains(query.toLowerCase()) ||
                    movie.gettime().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getyear().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getsummerize().toLowerCase().contains(query.toLowerCase()) ||
                    movie.gettype().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getprodusers().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getactors().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getphoto().toLowerCase().contains(query.toLowerCase()) );

            {
                filteredList.add(movie);
            }
        }
        if (filteredList.size() == 0)
        {
            showNoDataDialogue();
            return;
        }

    }

    private void showNoDataDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("No Results");
        builder.setMessage("Try again!");
        builder.show();
    }




    public void gotoAllMovieFragment() {
        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayout,new AddMovieFragment());
        ft.commit();
    }



}