package com.test.simulator;

import java.util.List;

public class Simulator implements ValidationsInterface {

    StateOfMatter som;
    TransitionCode tc;
    Rule rule;

    String[] transitionCodes = { "Ht", "Pr", "Di", "Co" };
    String[] statesOfMatter = { "G", "S", "L", "P", "X" };

    public void StateOfMatterFactory(String stateOfMatter) {
        som = new StateOfMatter(stateOfMatter) {
        };
    }

    public void TransitionCodeFactory(String transitionCode) {
        tc = new TransitionCode(transitionCode);
    }

    public String ExecuteRule(List<String> objects, List<String> transitionCodes) {
        rule = new Rule();
        return rule.ImplementRule(objects, transitionCodes);
    }

    public Boolean validations(List<String> tc, List<String> objects) {
        
        Boolean tcValidations = this.ValidateTansitionCodes(tc);
        Boolean sofValidations = this.ValidateStateOfMatter(objects);        
        System.out.print(tcValidations.toString() + sofValidations.toString());
        return tcValidations && sofValidations;
    }

    @Override
    public Boolean ValidateTansitionCodes(List<String> tc) {
        if(tc.size()==0){
            return true;
        }
        Boolean isCodePresent = false;
        for (String code : tc) {
            for (int i = 0; i < transitionCodes.length; i++) {
                if (code.equals(transitionCodes[i])) {
                    isCodePresent = true;
                    break;
                } else {
                    isCodePresent = false;
                }

            }
        }
        return isCodePresent;
    }

    @Override
    public Boolean ValidateStateOfMatter(List<String> objects) {
        Boolean isPresent = false;
        for (String code : objects) {
            for (int i = 0; i < statesOfMatter.length; i++) {
                if (code.equals(statesOfMatter[i])) {
                    isPresent = true;
                    break;
                } else {
                    isPresent = false;
                }
            }
        }
        return isPresent;
    }
}