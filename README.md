Steps to use simulator:

1. Go to src/test/java/com/test/simulator/SimulatorTest.java and update the values you want to test in the testSimulator() method. For example:

        objects.add("G");
        tc.add("Co");
Will add one Gas object and will apply Cold to it.

Matter can have one of these states:
● G: Gas
● S: Solid
● L: Liquid
● P: Plasma
● X: X state

This is the list of available transitions:
● Ht: Heat
● Pr: Pressure
● Di: Deionization
● Co: Cold

You can add multiple objects and transition codes. For example:

        objects.add("G");
        objects.add("G");
        objects.add("G");
        tc.add("Co");
        tc.add("Ht");
2. Execute:
mvn clean install
Actual result:
2. In the console you will see the totals for each state of matter. For example:
G:0,S:1,L:0,P:0,X:0   
