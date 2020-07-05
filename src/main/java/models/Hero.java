package models;

import java.util.ArrayList;

public class Hero {
    private String heroName;
    private int heroAge;
    private String heroAbility;
    private String heroWeakness;
    private static ArrayList<Hero> allHeros = new ArrayList<>();
    private int id;

    public Hero(String heroName, int heroAge, String heroAbility, String heroWeakness){
        this.heroName = heroName;
        this.heroAge = heroAge;
        this.heroAbility = heroAbility;
        this.heroWeakness = heroWeakness;
        this.id = allHeros.size();
        allHeros.add(this);
    }

    public String getHeroName() { return heroName; }

    public int getHeroAge() { return heroAge; }

    public String getHeroAbility() { return heroAbility; }

    public String getHeroWeakness() { return heroWeakness; }

    public static ArrayList<Hero> getAllHeros() { return allHeros; }

    public int getId() { return id; }
}
