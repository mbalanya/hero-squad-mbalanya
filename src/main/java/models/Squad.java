package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private static ArrayList<Squad> wholeSquad = new ArrayList<>();
    private int id;
    private List<Hero> squadHeros;

    public Squad(String squadName){
        this.squadName =squadName;
        this.id = wholeSquad.size();
        wholeSquad.add(this);
        this.squadHeros = new ArrayList<Hero>();
    }

    public String getSquadName() { return squadName; }

    public static ArrayList<Squad> getWholeSquad() { return wholeSquad; }

    public int getId() { return id; }

    public static Squad findSquad(int id) { return wholeSquad.get(id-1); }

    public void addHeroToSquad(Hero newHero) { squadHeros.add(newHero); }

    public List<Hero> getSquadHeros() { return squadHeros; }
}
