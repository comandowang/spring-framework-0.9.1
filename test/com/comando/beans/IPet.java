package com.comando.beans;

/**
 * Created by comando on 2018/2/27.
 */
public interface IPet {
    void setName(String name);

    String getName();

    int getAge();

    void setAge(int age);

    void setSpecies(ISpecies sp);

    ISpecies getSpecies();
}
