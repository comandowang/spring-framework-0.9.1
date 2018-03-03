package com.comando.beans;

/**
 * Created by comando on 2018/2/27.
 */
public class Species implements ISpecies {
    public Species() {
    }

    public Species(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

