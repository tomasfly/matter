package com.test.simulator;

import java.util.HashMap;
import java.util.List;

public class Rule implements TransitionRuleInterface {

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
            if (object.equals("L") && isDionizationPresent == false) {
                try {
                    this.substractObject("L");
                    this.addObject("X");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (object.equals("G") && (isHeatPresent || isColdPresent)) {
                try {
                    this.substractObject("G");
                    this.addObject("S");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (object.equals("P") && isPressurePresent == true) {
                try {
                    this.substractObject("P");
                    this.addObject("S");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return "G:" + stateOfMatterTotal.get("G") + ",S:" + stateOfMatterTotal.get("S") + ",L:"
                + stateOfMatterTotal.get("L") + ",P:" + stateOfMatterTotal.get("P") + ",X:"
                + stateOfMatterTotal.get("X") + "";
    }
}