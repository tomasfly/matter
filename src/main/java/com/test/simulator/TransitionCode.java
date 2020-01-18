package com.test.simulator;

public class TransitionCode{
    public TransitionCode(final String transitionCode) {
        setTransitionCode(transitionCode);        
    }

    String transitionCode;

    /**
     * @return the transitionCode
     */
    public String getTransitionCode() {
        return transitionCode;
    }

    /**
     * @param transitionCode the transitionCode to set
     */
    public void setTransitionCode(String transitionCode) {
        this.transitionCode = transitionCode;
    }    
}