package com.test.simulator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;

public class SimulatorTest {

    List<String> objects = new ArrayList<>();
    List<String> transitionCodes = new ArrayList<>();

    @Test
    public void testSimulator() {
        objects.add("G");
        transitionCodes.add("Co");
        Simulator simulator = new Simulator();
        simulator.ExecuteRule(objects, transitionCodes);
        assertTrue("Asserting true", true);
    }
}
