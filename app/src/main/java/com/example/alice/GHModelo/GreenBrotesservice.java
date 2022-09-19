package com.example.alice.GHModelo;

import java.util.ArrayList;
import java.util.List;

public class GreenBrotesservice {

    public static List<GreenBrotes> greenbrotes = new ArrayList<>();

    public static void addbrotes (GreenBrotes greenBrotes){
        greenbrotes.add(greenBrotes);
    }

    public static void removebrotes (GreenBrotes greenBrotes){
        greenbrotes.remove(greenBrotes);
    }

    public static void updatebrotes (GreenBrotes greenBrotes){
        greenbrotes.set(greenbrotes.indexOf(greenBrotes),greenBrotes);
    }
}
