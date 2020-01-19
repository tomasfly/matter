package com.test.simulator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;

public class SimulatorTest {

    List<String> objects = new ArrayList<>();
    List<String> tc = new ArrayList<>();

    @Test
    public void testSimulator() {
        objects.add("G");
        tc.add("Co");        
        Simulator simulator = new Simulator();
        assertTrue("Input not valid", simulator.validations(tc, objects));
        try {
            System.out.print(simulator.ExecuteRule(objects, tc)+"\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
