package com.example.alice.BKModelo;

import java.util.ArrayList;
import java.util.List;

public class BKMortandadservice {

    public static List<BKMortandad> bkMortandads = new ArrayList<>();

    //se valida la insersion, la eliminacion y la actualizacion
    public static void addbkMortandad (BKMortandad bkMortandad){
        bkMortandads.add(bkMortandad);
    }

    public static void removebkMortandad (BKMortandad bkMortandad){
        bkMortandads.remove(bkMortandad);
    }

    public static void updatebkMortandad (BKMortandad bkMortandad){
        bkMortandads.set(bkMortandads.indexOf(bkMortandad),bkMortandad);
    }
}
