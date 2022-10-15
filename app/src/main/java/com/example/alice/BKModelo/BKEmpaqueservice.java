package com.example.alice.BKModelo;

import java.util.ArrayList;
import java.util.List;

public class BKEmpaqueservice {

    public static List<BKEmpaque> bkEmpaques = new ArrayList<>();

    //se valida la insersion, la eliminacion y la actualizacion
    public static void addbkempaque (BKEmpaque bkempaque){
        bkEmpaques.add(bkempaque);
    }

    public static void removebkempaque (BKEmpaque bkempaque){
        bkEmpaques.remove(bkempaque);
    }

    public static void updatebkempaque (BKEmpaque bkempaque){
        bkEmpaques.set(bkEmpaques.indexOf(bkempaque),bkempaque);
    }
}
