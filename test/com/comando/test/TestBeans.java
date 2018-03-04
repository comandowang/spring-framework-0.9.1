package com.comando.test;

import com.comando.beans.*;
import com.interface21.beans.BeanWrapper;
import com.interface21.beans.BeanWrapperImpl;
import junit.framework.TestCase;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by comando on 2018/3/4.
 */
public class TestBeans extends TestCase {

    public void testSimple() {
        Species cat = new Species();
        Species dog = new Species();
        Owner owner = new Owner();
        Pet bodo = new Pet();
        Pet pixel = new Pet();
        ArrayList list = new ArrayList();
        list.add(bodo);
        list.add(pixel);
        BeanWrapper bwbodo = new BeanWrapperImpl(bodo);
        BeanWrapper bwpixel = new BeanWrapperImpl(pixel);
        BeanWrapper bwo = new BeanWrapperImpl(owner);
        try {
            bwbodo.setPropertyValue("name", "Bodo");
            bwbodo.setPropertyValue("age", new Integer(4));
            bwbodo.setPropertyValue("species", new Species());
            bwbodo.setPropertyValue("species.name", "Cat");
            bwpixel.setPropertyValue("name", "Pixel");
            bwpixel.setPropertyValue("age", new Integer(11));
            bwpixel.setPropertyValue("species", new Species());
            bwpixel.setPropertyValue("species.name", "Dog");
            bwo.setPropertyValue("name", "Isabelle");
            bwo.setPropertyValue("pets", list);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        String isabelle = (String)bwo.getPropertyValue("name");
        System.out.println("Bodo's owner is " + isabelle);
        List pets = (List)bwo.getPropertyValue("pets");
        System.out.println(isabelle + "'s pets are: ");
        ListIterator iter = pets.listIterator();
        while (iter.hasNext()) {
            IPet pet = (IPet)iter.next();
            ISpecies sp = pet.getSpecies();
            System.out.println(pet.getName() + " of species " + sp.getName());
        }
    }
}
