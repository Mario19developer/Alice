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

import com.example.alice.Vistas_BK_Consolidacion.bkConsolidacionAgregar;
import com.example.alice.Vistas_BK_Consolidacion.bkConsolidacionLista;
import com.google.android.material.tabs.TabLayout;

public class BkMenuConsolidacion extends AppCompatActivity {

    // instancian en el layout
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    //se intancia un adaptador
    Adapterpager adapterpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bk_menu_consolidacion);

        //seteo de layout
        //toolbar = findViewById(R.id.tool_bar);
        tabLayout = findViewById(R.id.tab_bar);
        viewPager = findViewById(R.id.view_pager);
        //setSupportActionBar(toolbar);

        //se genera el adaptador
        adapterpager = new Adapterpager(getSupportFragmentManager());
        viewPager.setAdapter(adapterpager);

        tabLayout.setupWithViewPager(viewPager);
    }

    public class  Adapterpager extends FragmentPagerAdapter {

        public Adapterpager(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    bkConsolidacionAgregar f0 = new bkConsolidacionAgregar();
                    return f0;
                case 1:
                    bkConsolidacionLista f1 = new bkConsolidacionLista();
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