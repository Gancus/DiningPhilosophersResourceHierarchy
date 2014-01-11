/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpp;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Marcin
 */
public class Philosopher extends Thread {
    private int id;
    private Fork left, right;
    private int eatCouter = 0;

    public Philosopher(int id, Fork left, Fork right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public void run() {
        while(eatCouter <= 100) {
            try {
                think();
                if(left.getId() > right.getId()) {
                    right.acquire();
                    left.acquire();
                    eat();
                    left.release();
                    right.release();

                } else {
                    left.acquire();
                    right.acquire();
                    eat();
                    right.release();  
                    left.release(); 
                }
            } catch (InterruptedException ex) {
                    System.out.println("Przerywanie " + this);
            }
        }
    }
    
    public void test() {
        System.out.println(this + " left: " + left + " right: " + right);
    }
    
    public void think() throws InterruptedException {
        /*System.out.println(this + " zaczyna myśleć");
        System.out.println(this + " myśli");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(this + " kończy myśleć");*/
    }
    
    public void eat() throws InterruptedException {
        System.out.println(this + " zaczyna jeść");
        System.out.println(this + " je");
        eatCouter++;
        //TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(this + " kończy jeść");
    }
    

    @Override
    public String toString() {
        return "Filozof{" + "id=" + id + '}';
    }
    
    
}
