package com.example.alice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.alice.Vistas_GH_Brotes.ghBrotesAgregar;
import com.example.alice.Vistas_GH_Brotes.ghBrotesLista;
import com.google.android.material.tabs.TabLayout;

public class GhMenuBrotes extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    Adapterpager adapterpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gh_menu_brotes);

        tabLayout = findViewById(R.id.tab_bar);
        viewPager = findViewById(R.id.view_pager);

        adapterpager = new Adapterpager(getSupportFragmentManager());
        viewPager.setAdapter(adapterpager);

        tabLayout.setupWithViewPager(viewPager);
    }

    public class Adapterpager extends FragmentPagerAdapter {

        public Adapterpager(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    ghBrotesAgregar f0 = new ghBrotesAgregar();
                    return f0;
                case 1:
                    ghBrotesLista f1 = new ghBrotesLista();
                    return f1;
            }
            return null;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Agregar";
                case 1:
                    return "Registros";
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}