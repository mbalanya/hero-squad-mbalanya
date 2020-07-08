package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/*import org.junit.*;*/

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("Rangers");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void SquadInstantiatesWithContent_true() throws Exception {
        Squad squad = new Squad("Rangers");
        Squad squadId = new Squad("Rangers");
        assertEquals("Rangers", squad.getSquadName());
        assertEquals(2,squadId.getId());
    }


}
