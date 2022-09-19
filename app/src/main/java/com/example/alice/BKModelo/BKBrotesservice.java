package com.example.alice.BKModelo;

import java.util.ArrayList;
import java.util.List;

public class BKBrotesservice {

    public static List<BKBrotes> bkBrotes = new ArrayList<>();

    //se valida la insersion, la eliminacion y la actualizacion
    public static void addbkBrotes (BKBrotes bkbrotes){
        bkBrotes.add(bkbrotes);
    }

    public static void removebkBrotes (BKBrotes bkbrotes){
        bkBrotes.remove(bkbrotes);
    }

    public static void updatebkBrotes (BKBrotes bkbrotes){
        bkBrotes.set(bkBrotes.indexOf(bkbrotes),bkbrotes);
    }

}
