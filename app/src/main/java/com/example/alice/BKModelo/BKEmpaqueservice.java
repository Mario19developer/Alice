package com.example.alice.BKModelo;

import java.util.ArrayList;
import java.util.List;

public class BKEmpaqueservice {

    public static List<BKEmpaque> bkEmpaques = new ArrayList<>();

    //se valida la insersion, la eliminacion y la actualizacion
    public static void addbkalmacigos (BKEmpaque bkempaque){
        bkEmpaques.add(bkempaque);
    }

    public static void removebkalmacigos (BKEmpaque bkempaque){
        bkEmpaques.remove(bkempaque);
    }

    public static void updatebkalmacigos (BKEmpaque bkempaque){
        bkEmpaques.set(bkEmpaques.indexOf(bkempaque),bkempaque);
    }
}
