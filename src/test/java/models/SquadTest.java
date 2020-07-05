package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("Rangers");
        assertEquals(true, squad instanceof Squad);
    }
}
