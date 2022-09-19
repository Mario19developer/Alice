package com.example.alice.GHModelo;

import java.util.ArrayList;
import java.util.List;

public class GreenAlmacigosservice {

    public static List<GreenAlmacigos> greenalmacigoss = new ArrayList<>();

    //se valida la insersion, la eliminacion y la actualizacion
    public static void addalmacigos (GreenAlmacigos greenAlmacigos) {

        greenalmacigoss.add(greenAlmacigos);
    }

    public static void removealmacigos (GreenAlmacigos greenAlmacigos) {

        greenalmacigoss.remove(greenAlmacigos);
    }

    public static void updatealmacigos (GreenAlmacigos greenAlmacigos) {

        greenalmacigoss.set(greenalmacigoss.indexOf(greenAlmacigos),greenAlmacigos);
    }
}
