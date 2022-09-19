package com.example.alice.BKModelo;

import java.util.ArrayList;
import java.util.List;

public class BKAlmacigosservice {

    public static List<BKAlmacigos> bkAlmacigos = new ArrayList<>();

    //se valida la insersion, la eliminacion y la actualizacion
    public static void addbkalmacigos (BKAlmacigos bkalmacigos){
        bkAlmacigos.add(bkalmacigos);
    }

    public static void removebkalmacigos (BKAlmacigos bkalmacigos){
        bkAlmacigos.remove(bkalmacigos);
    }

    public static void updatebkalmacigos (BKAlmacigos bkalmacigos){
        bkAlmacigos.set(bkAlmacigos.indexOf(bkalmacigos),bkalmacigos);
    }
}
