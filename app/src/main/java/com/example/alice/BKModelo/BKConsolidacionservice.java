package com.example.alice.BKModelo;

import java.util.ArrayList;
import java.util.List;

public class BKConsolidacionservice {

    public static List<BKConsolidacion> bkConsolidacion = new ArrayList<>();

    //se valida la insersion, la eliminacion y la actualizacion
    public static void addbkalmacigos (BKConsolidacion bkconsolidacion){
        bkConsolidacion.add(bkconsolidacion);
    }

    public static void removebkalmacigos (BKConsolidacion bkconsolidacion){
        bkConsolidacion.remove(bkconsolidacion);
    }

    public static void updatebkalmacigos (BKConsolidacion bkconsolidacion){
        bkConsolidacion.set(bkConsolidacion.indexOf(bkconsolidacion),bkconsolidacion);
    }
}
