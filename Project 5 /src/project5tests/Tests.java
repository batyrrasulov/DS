package project5tests;

import org.junit.Test;
import project5.RecursiveStrings;
import static org.junit.Assert.*;

public class Tests {

    RecursiveStrings SlopSlapSlip = new RecursiveStrings("input.txt");

    @Test
    public void testIsSlip() {
        assertTrue(SlopSlapSlip.isSlip("DFG", false, true));
        assertTrue(SlopSlapSlip.isSlip("EFG", false, true));
        assertTrue(SlopSlapSlip.isSlip("DFFFFFG", false, true));
        assertTrue(SlopSlapSlip.isSlip("DFDFDFDFG", false, true));
        assertTrue(SlopSlapSlip.isSlip("DFEFFFFFG", false, true));

        assertFalse(SlopSlapSlip.isSlip("DFEFF", false, true));
        assertFalse(SlopSlapSlip.isSlip("EFAHG", false, true));
        assertFalse(SlopSlapSlip.isSlip("DEFG", false, true));
        assertFalse(SlopSlapSlip.isSlip("DG", false, true));
        assertFalse(SlopSlapSlip.isSlip("EFFFFDG", false, true));
    }

    @Test
    public void testIsSlap() {
        assertTrue(SlopSlapSlip.isSlap("AH", false, false, 0));
        assertTrue(SlopSlapSlip.isSlap("ABAHC", false, false, 0));
        assertTrue(SlopSlapSlip.isSlap("ABABAHCC", false, false, 0));
        assertTrue(SlopSlapSlip.isSlap("ADFGC", false, false, 0));
        assertTrue(SlopSlapSlip.isSlap("ADFFFFGC", false, false, 0));
        assertTrue(SlopSlapSlip.isSlap("ABAEFGCC", false, false, 0));
        assertTrue(SlopSlapSlip.isSlap("ADFDFGC", false, false, 0));

        assertFalse(SlopSlapSlip.isSlap("ABC", false, false, 0));
        assertFalse(SlopSlapSlip.isSlap("ABAH", false, false, 0));
        assertFalse(SlopSlapSlip.isSlap("DFGC", false, false, 0));
        assertFalse(SlopSlapSlip.isSlap("ABABAHC", false, false, 0));
        assertFalse(SlopSlapSlip.isSlap("SLAP", false, false, 0));
        assertFalse(SlopSlapSlip.isSlap("ADGC", false, false, 0));
    }

    @Test
    public void testIsSlop() {
        assertTrue(SlopSlapSlip.isSlop("AHDFG"));
        assertTrue(SlopSlapSlip.isSlop("ADFGCDFFFFFG"));
        assertTrue(SlopSlapSlip.isSlop("ABAEFGCCDFEFFFFFG"));

        assertFalse(SlopSlapSlip.isSlop("AHDFGA"));
        assertFalse(SlopSlapSlip.isSlop("DFGAH"));
        assertFalse(SlopSlapSlip.isSlop("ABABCC"));
    }
}
