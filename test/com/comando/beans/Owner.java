package com.comando.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by comando on 2018/2/27.
 */
public class Owner implements IOwner {
    public Owner() {
    }

    public Owner(String name, List pets) {
        this.name = name;
        setPets(pets);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPets(List pets) {
        this.pets.clear();
        this.pets.addAll(pets);
    }

    public List getPets() {
        return pets;
    }

    private String name;
    private ArrayList pets = new ArrayList();
}