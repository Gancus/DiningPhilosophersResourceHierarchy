/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpp;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Marcin
 */
public class Table {
    private ArrayList<Fork> forks = new ArrayList<>();
    private ArrayList<Philosopher> philosophers = new ArrayList<>();
    
    public void startDinner(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            forks.add(new Fork(i + 1));
        }
        for (int i = 0; i < n; i++) {
            philosophers.add(new Philosopher(i + 1, forks.get(i), forks.get((i + 1) % n)));
            philosophers.get(i).test();
        }
        for (int i = 0; i < n; i++) {
            philosophers.get(i).start();
        }
        for (int i = 0; i < n; i++) {
            philosophers.get(i).join();
        }
    }
}
