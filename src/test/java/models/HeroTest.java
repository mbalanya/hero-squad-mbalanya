package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = new Hero("Rangers", 20, "fight", "ego");
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void HeroInstantiatesWithContent_true() throws Exception {
        Hero hero = new Hero("Rangers", 20, "fight", "ego");
        assertEquals("Rangers", hero.getHeroName());
        assertEquals(20, hero.getHeroAge());
        assertEquals("fight", hero.getHeroAbility());
        assertEquals("ego", hero.getHeroWeakness());
        assertEquals(0, hero.getId());
    }


}
