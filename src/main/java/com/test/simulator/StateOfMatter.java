package com.test.simulator;

public class StateOfMatter {

    public StateOfMatter(final String stateOfMatter) {
        setStateOfMatter(stateOfMatter);
    }

    String stateOfMatter;

    /**
     * @return the stateOfMatter
     */
    public String getStateOfMatter() {
        return stateOfMatter;
    }

    /**
     * @param stateOfMatter the stateOfMatter to set
     */
    public void setStateOfMatter(final String stateOfMatter) {
        this.stateOfMatter = stateOfMatter;
    }
}