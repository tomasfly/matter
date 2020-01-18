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
        objects.add("G");
        objects.add("S");
        objects.add("X");
        tc.add("Ht");
        tc.add("Ht");
        Simulator simulator = new Simulator();
        assertTrue("Input not valid", simulator.validations(tc, objects));
        try {
            System.out.print(simulator.ExecuteRule(objects, tc));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
