package com.comando.beans;

/**
 * Created by comando on 2018/2/27.
 */
public class Pet implements IPet {
    public Pet() {
    }

    public Pet(String name, int age, ISpecies sp) {
        this.name = name;
        this.age = age;
        species = sp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(ISpecies sp) {
        species = sp;
    }

    public ISpecies getSpecies() {
        return species;
    }

    private String name;
    private int age;
    private ISpecies species;
}
