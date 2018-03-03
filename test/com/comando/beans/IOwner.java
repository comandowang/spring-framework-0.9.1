package com.comando.beans;

import java.util.List;

/**
 * Created by comando on 2018/2/27.
 */
public interface IOwner {
    void setName(String name);

    String getName();

    void setPets(List pets);

    List getPets();
}