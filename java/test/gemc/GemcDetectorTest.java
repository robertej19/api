package gemc;

import org.junit.*;
import static org.junit.Assert.*;
import static java.lang.System.out;

import java.util.*;

public class GemcDetectorTest {

    @Test
    public void testConstruction() {
        GemcDetector data = new GemcDetector();
    }

    @Test
    public void testGet() {
        GemcDetector data = new GemcDetector();
        assertEquals("root", data.get("mother"));
        assertEquals("",     data.get("description"));
        assertEquals("0*cm 0*cm 0*cm", data.get("pos"));
        assertEquals("ordered: zxy 0*deg 0*deg 0*deg", data.get("rotation"));
        assertEquals("808080", data.get("color"));
        assertEquals("G4Trap", data.get("type"));
        assertEquals("0*cm 0*deg 0*deg 0*cm 0*cm 0*cm 0*deg 0*cm 0*cm 0*cm 0*deg", data.get("dimensions"));
        assertEquals("Air", data.get("material"));
        assertEquals("no",  data.get("mfield"));
        assertEquals("1",   data.get("ncopy"));
        assertEquals("1",   data.get("pMany"));
        assertEquals("1",   data.get("exist"));
        assertEquals("1",   data.get("visible"));
        assertEquals("0",   data.get("style"));
        assertEquals("no",  data.get("sensitivity"));
        assertEquals("",    data.get("hit_type"));
        assertEquals("",    data.get("identifiers"));
    }

    @Test
    public void testSet() {
        GemcDetector data = new GemcDetector();
        data.put("mother","another");
        assertEquals(data.get("mother"), "another");
    }

    @Test(expected=UnsupportedOperationException.class)
    public void testLock() {
        GemcDetector data = new GemcDetector();
        data.put("key0","value0");
    }

    @Test
    public void testExample() {
        GemcDetector data = new GemcDetector();
        data.put("mother",      "mother_volume");
        data.put("description", "Description of this detector");
        data.put("pos",         "0*cm 0*cm 0*cm");
        data.put("rotation",    "ordered: zxy 0*deg 0*deg 0*deg");
        data.put("color",       "000050");
        data.put("type",        "G4Trap");
        data.put("dimensions",  "0*cm 0*deg 0*deg 0*cm 0*cm 0*cm 0*deg 0*cm 0*cm 0*cm 0*deg");
        data.put("material",    "Air");
        data.put("mfield",      "no");
        data.put("ncopy",       "1");
        data.put("pMany",       "1");
        data.put("exist",       "1");
        data.put("visible",     "1");
        data.put("style",       "0");
        data.put("sensitivity", "no");
        data.put("hit_type",    "");
        data.put("identifiers", "");

        String data_str = data.toString();
        String data_padstr = data.toPaddedString();
    }


    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("gemc.GemcDetectorTest");
    }
}
