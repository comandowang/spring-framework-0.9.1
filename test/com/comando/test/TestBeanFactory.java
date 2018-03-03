package com.comando.test;

/**
 * Created by comando on 2018/2/27.
 */

import com.comando.beans.IPet;
import com.comando.beans.ISpecies;
import com.comando.beans.Owner;
import com.comando.editor.OwnerEditor;
import com.interface21.beans.factory.xml.XmlBeanFactory;

import java.beans.PropertyEditorManager;
import java.util.List;
import java.util.ListIterator;


public class TestBeanFactory {
    public static void main(String[] args) {
        TestBeanFactory tb = new TestBeanFactory();
        tb.useFactory("test/pets.xml");
    }
    public void useFactory(String file) {
        PropertyEditorManager.registerEditor(List.class, OwnerEditor.class);

        XmlBeanFactory fac = new XmlBeanFactory(file, null);
        // Find bean isabelle
        Owner isabelle = (Owner)fac.getBean("isabelle");
        System.out.println("Found bean: " + isabelle.getName() + " with pets: ");
        ListIterator iter = isabelle.getPets().listIterator();
        while (iter.hasNext()) {
            IPet pet = (IPet)iter.next();
            ISpecies sp = pet.getSpecies();
            System.out.println(pet.getName() + " of species " + sp.getName());
        }
    }

}
