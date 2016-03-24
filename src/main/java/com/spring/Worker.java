package com.spring;

/**
 * @author ilebedyuk
 */
public class Worker implements Performer {
    public void doSmth() {
        System.out.println(print());
    }
    public String print() {
        if(Math.random() < 0.5)
            throw new RuntimeException("Worker exception");
        return "Worker is working...";
    }
}
