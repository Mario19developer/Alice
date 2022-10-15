package com.example.alice.BKModelo;

import java.util.ArrayList;
import java.util.List;

public class BKTrasplanteservice {

    public static List<BKTrasplante> bkTrasplantes = new ArrayList<>();

    //se valida la insersion, la eliminacion y la actualizacion
    public static void addbktrasplante (BKTrasplante bktrasplante){
        bkTrasplantes.add(bktrasplante);
    }

    public static void removebktrasplante (BKTrasplante bktrasplante){
        bkTrasplantes.remove(bktrasplante);
    }

    public static void updatebktrasplante (BKTrasplante bktrasplante){
        bkTrasplantes.set(bkTrasplantes.indexOf(bktrasplante),bktrasplante);
    }
}
