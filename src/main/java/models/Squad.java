package models;

import java.util.ArrayList;

public class Squad {
    private String squadName;
    private static ArrayList<Squad> wholeSquad = new ArrayList<>();
    private int id;

    public Squad(String squadName){
        this.squadName =squadName;
        this.id = wholeSquad.size();
        wholeSquad.add(this);
    }


}
