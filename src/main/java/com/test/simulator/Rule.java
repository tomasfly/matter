package com.test.simulator;

import java.util.HashMap;
import java.util.List;

public class Rule implements TransitionRuleInterface {

    HashMap<String, Integer> stateOfMatterTotal = new HashMap<String, Integer>();

    public Rule() {
        this.initResultHashMap();
    }

    private void initResultHashMap() {
        stateOfMatterTotal.put("G", 0);
        stateOfMatterTotal.put("S", 0);
        stateOfMatterTotal.put("L", 0);
        stateOfMatterTotal.put("P", 0);
        stateOfMatterTotal.put("X", 0);
    }

    private void addObject(String stateOfMatter) throws Exception {
        if (!stateOfMatterTotal.containsKey(stateOfMatter)) {
            throw new Exception("State of matter code not found");
        }
        stateOfMatterTotal.put(stateOfMatter, stateOfMatterTotal.get(stateOfMatter) + 1);
    }

    @Override
    public String ImplementRule(List<String> objects, List<String> transitionCodes) {

        Boolean isDiPresent = false;

        for (String tc : transitionCodes) {
            if (tc.equals("Di")) {
                isDiPresent = true;
            }
        }

        for (String object : objects) {
            if (object.equals("L") && isDiPresent == false) {
                try {
                    this.addObject("X");
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