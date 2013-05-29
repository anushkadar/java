/*
 * (C) Copyright 2009-2010 Direct FN Technologies Limited. All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * Direct FN Technologies and constitute a TRADE SECRET of Direct FN Technologies Limited.
 *
 * Direct FN Technologies Limited retains all title to and intellectual property rights
 * in these materials.
 */
package org.me.builder;

/**
 * org.me.builder.MapToFile
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * org.me.fileStore.MapToFile
 */
public class MapToFile {
    private static final long serialVersionUID = -5966618586666474164L;
    HashMap<Integer, String> games;
    Hashtable<String, ArrayList<Object>> baggage;
    HashSet<String> bookedTickets;

    public MapToFile() {
        super();
//        this.games = new HashMap<Integer, String>();
//        games.put(1,"Create");
//        this.baggage = new Hashtable<String, ArrayList<Object>>();
//        ArrayList list = new ArrayList<String>();
//        list.add("hi");
//        baggage.put("this",list);
//        this.bookedTickets = new HashSet<String>();
//        bookedTickets.add("Game");
//        //this.place = place;
    }


    public boolean store(File f) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(games);
            oos.writeObject(bookedTickets);
            oos.writeObject(baggage);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }


    public boolean load(File f) {
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.games = (HashMap<Integer, String>) ois.readObject();
            this.bookedTickets = (HashSet<String>) ois.readObject();
            this.baggage = (Hashtable<String, ArrayList<Object>>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }


    public static void main(String args[]) {
        File file = new File("file.ser");
        MapToFile mapTofile = new MapToFile();

        HashMap games = new HashMap<Integer, String>();
        games.put(1, "Cricket");
        games.put(2, "valiball");
        Hashtable baggage = new Hashtable<String, ArrayList<Object>>();
        ArrayList list = new ArrayList<String>();
        list.add("hi");
        list.add("bi");
        list.add("si");
        baggage.put("this", list);
        HashSet bookedTickets = new HashSet<String>();
        bookedTickets.add("Game");

        mapTofile.setBaggage(baggage);
        mapTofile.setBookedTickets(bookedTickets);
        mapTofile.setGames(games);

        mapTofile.store(file);

        mapTofile.setBaggage(null);
        mapTofile.setBookedTickets(null);
        mapTofile.setGames(null);

        mapTofile.load(file);

        log(mapTofile.getBaggage().get("this"));
        log(mapTofile.getBookedTickets());
        log(mapTofile.getGames());
    }

    public static void log(Object ob) {
        System.out.println(ob);
    }

    public HashMap<Integer, String> getGames() {
        return games;
    }

    public void setGames(HashMap<Integer, String> games) {
        this.games = games;
    }

    public Hashtable<String, ArrayList<Object>> getBaggage() {
        return baggage;
    }

    public void setBaggage(Hashtable<String, ArrayList<Object>> baggage) {
        this.baggage = baggage;
    }

    public HashSet<String> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(HashSet<String> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

}
