/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpp;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Marcin
 */
public class Fork extends Semaphore {
    private final int id;
    public Fork(int id) {
        super(1, true);
        this.id = id;
    }

    public int getId() {
        return id;
    }  
}
