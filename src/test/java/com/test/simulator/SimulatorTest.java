package com.test.simulator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;

public class SimulatorTest {

    List<String> objects = new ArrayList<>();
    List<String> tc = new ArrayList<>();

    @Test
    public void testSimulator() {
        // objects.add("G");
        // tc.add("Co");
        // This Test data should be read from an external file, most probably.

        
        objects.add("L");
        objects.add("L");
        objects.add("L");
        objects.add("L");
        tc.add("Di");
        // tc.add("Co");
        // tc.add("Co");
        Simulator simulator = new Simulator();
        assertTrue("Input not valid",simulator.validations(tc, objects));        
        System.out.print(simulator.ExecuteRule(objects, tc));        
    }
}
