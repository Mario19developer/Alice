package com.example.alice.GHModelo;

import java.util.ArrayList;
import java.util.List;

public class GreenTrasplanteservice {

    public static List<GreenTrasplante> greentrasplantes = new ArrayList<>();

    public static void addtrasplante (GreenTrasplante greenTrasplante){

        greentrasplantes.add(greenTrasplante);
    }

    public static void removetrasplante(GreenTrasplante greenTrasplante){

        greentrasplantes.remove(greenTrasplante);
    }

    public static void updatetrasplante(GreenTrasplante greenTrasplante){

        greentrasplantes.set(greentrasplantes.indexOf(greenTrasplante),greenTrasplante);
    }
}
