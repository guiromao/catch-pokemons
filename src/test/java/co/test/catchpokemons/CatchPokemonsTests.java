package co.test.catchpokemons;

import co.catchpokemons.CatchPokemons;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

import static org.junit.Assert.*;
import static co.catchpokemons.CatchPokemons.*;

@RunWith(JUnitParamsRunner.class)
public class CatchPokemonsTests {



    /**
     * Invalid directions should be valued as such
     * @param dir
     */
    @Test
    @Parameters({"1", "oens9", "nsesw", "nttta", "!!!"})
    public void makeSureMarkedAsInvalid(String dir){
        assertFalse(areValidDirections(dir.toUpperCase()));
    }

    /**
     * Valid directions should be valued as such
     * @param dir
     */
    @Test
    @Parameters({"e", "nses", "nsnsnsnsnsn", "neooosnnne"})
    public void makeSureDirectionsAreValid(String dir){
        assertTrue(areValidDirections(dir.toUpperCase()));
    }

    /**
     * Make sure the given directions return the right amount of caught pokemons
     */
    @Test
    public void countCatchesCorrectly(){
        assertEquals(0, countCatches(""));
        assertEquals(2, countCatches("E"));
        assertEquals(2, countCatches("NSNS"));
        assertEquals(7, countCatches("ONON ONSN"));
        assertEquals(4, countCatches("OSNO"));
    }

}
