package com.spring;

/**
 * @author ilebedyuk
 */
public class PerformerImpl implements Performer {
    public void doSmth() {
        System.out.println(print());
    }

    public String print() {
        return "Performer is working...";
    }
}
