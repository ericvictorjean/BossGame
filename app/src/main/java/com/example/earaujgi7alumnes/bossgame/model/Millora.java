package com.example.earaujgi7alumnes.bossgame.model;

import java.util.ArrayList;

/**
 * Created by mcalvico7.alumnes on 02/05/17.
 */

public class Millora {
    private int cost;
    private int dany, vida;


    public Millora(int c, int d, int v) {
        cost = c;
        dany = d;
        vida = v;
    }

    public String getCost() {
        return String.valueOf(cost);
    }

    public String getValor() {
        if (dany != 0) return String.valueOf(dany);
        return String.valueOf(vida);
    }

    private static int lastContactId = 0;

    public static ArrayList<Millora> createMillorasList(int numContacts) {
        ArrayList<Millora> contacts = new ArrayList<Millora>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Millora(i,i+2,i+3));
        }

        return contacts;
    }
}
