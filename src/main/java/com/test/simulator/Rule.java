package com.test.simulator;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Rule implements TransitionRuleInterface {

    private final int oneInAmillion = 500000;

    HashMap<String, Integer> stateOfMatterTotal = new HashMap<String, Integer>();

    public Rule(List<String> objects) {
        this.initResultHashMap(objects);
    }

    private void initResultHashMap(List<String> objects) {
        stateOfMatterTotal.put("G", 0);
        stateOfMatterTotal.put("S", 0);
        stateOfMatterTotal.put("L", 0);
        stateOfMatterTotal.put("P", 0);
        stateOfMatterTotal.put("X", 0);
        for (String string : objects) {
            try {
                this.addObject(string);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addObject(String stateOfMatter) throws Exception {
        if (!stateOfMatterTotal.containsKey(stateOfMatter)) {
            throw new Exception("State of matter code not found");
        }
        stateOfMatterTotal.put(stateOfMatter, stateOfMatterTotal.get(stateOfMatter) + 1);
    }

    private void substractObject(String stateOfMatter) throws Exception {
        if (!stateOfMatterTotal.containsKey(stateOfMatter)) {
            throw new Exception("State of matter code not found");
        }
        stateOfMatterTotal.put(stateOfMatter, stateOfMatterTotal.get(stateOfMatter) - 1);
    }

    @Override
    public String ImplementRule(List<String> objects, List<String> transitionCodes) {

        Boolean isHeatPresent = false;
        Boolean isPressurePresent = false;
        Boolean isDionizationPresent = false;
        Boolean isColdPresent = false;
        // check if any transition code is present
        for (String tc : transitionCodes) {
            if (tc.equals("Ht")) {
                isHeatPresent = true;
            }
            if (tc.equals("Pr")) {
                isPressurePresent = true;
            }
            if (tc.equals("Di")) {
                isDionizationPresent = true;
            }
            if (tc.equals("Co")) {
                isColdPresent = true;
            }
        }

        for (String object : objects) {
            // Deionization prevents Liquids turning into X, stays Liquid after applying it;
            if (object.equals("L") && isDionizationPresent == false) {
                try {
                    this.substractObject("L");
                    this.addObject("X");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Heat turns Gas into Solid;
            // Cold turns Gas into Solid;
            if (object.equals("G") && (isHeatPresent || isColdPresent)) {
                try {
                    this.substractObject("G");
                    this.addObject("S");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Pressure turns Plasma into Solid;
            if (object.equals("P") && isPressurePresent == true) {
                try {
                    this.substractObject("P");
                    this.addObject("S");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // If Deionization is mixed with Pressure, Solid turns into Gas;
            if (object.equals("S") && (isDionizationPresent && isPressurePresent)) {
                try {
                    this.substractObject("S");
                    this.addObject("G");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Applying Heat and Cold at the same time, matter turns into X;
            if (isHeatPresent && isColdPresent) {
                try {
                    this.substractObject(object);
                    this.addObject("X");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // One time in a million the planet’s God shows his alien power and turns X
            // matter into Solid, which is impossible for humankind.
            int result = new Random().nextInt(1000000) + 1;
            if (object.equals("X") && oneInAmillion == result) {
                try {
                    this.substractObject("X");
                    this.addObject("S");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "G:" + stateOfMatterTotal.get("G") + ",S:" + stateOfMatterTotal.get("S") + ",L:"
                + stateOfMatterTotal.get("L") + ",P:" + stateOfMatterTotal.get("P") + ",X:"
                + stateOfMatterTotal.get("X") + "";
    }
}