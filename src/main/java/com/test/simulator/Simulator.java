package com.test.simulator;

import java.util.List;

public class Simulator {

    StateOfMatter som;
    TransitionCode tc;
    Rule rule;

    public void StateOfMatterFactory(String stateOfMatter) {
        som = new StateOfMatter(stateOfMatter) {
        };
    }

    public void ExecuteRule(List<String> objects, List<String> transitionCodes) {
        rule = new Rule();
        rule.ImplementRule(objects, transitionCodes);
    }
}