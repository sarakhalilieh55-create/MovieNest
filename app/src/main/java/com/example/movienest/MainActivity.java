package com.example.movienest;
<<<<<<< HEAD

=======
>>>>>>> 60da0d6 (newer one)
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity {

=======


public class MainActivity extends AppCompatActivity {


>>>>>>> 60da0d6 (newer one)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

=======
>>>>>>> 60da0d6 (newer one)
    }

    @Override
    protected void onStart() {
        super.onStart();
        gotoLoginFragment();
    }

    private void gotoLoginFragment() {
<<<<<<< HEAD
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main, new LoginFragment());
        ft.commit();
    }
}
=======
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout,new LoginFragment());
        ft.commit();
    }



}
>>>>>>> 60da0d6 (newer one)
