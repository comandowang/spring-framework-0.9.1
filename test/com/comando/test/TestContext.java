package com.comando.test;

import com.comando.beans.*;
import com.comando.editor.OwnerEditor;
import com.interface21.beans.BeanWrapper;
import com.interface21.beans.BeanWrapperImpl;
import com.interface21.beans.BeansException;
import com.interface21.context.ApplicationContext;
import com.interface21.context.NoSuchMessageException;
import com.interface21.context.support.FileSystemXmlApplicationContext;
import junit.framework.TestCase;

import java.beans.PropertyEditorManager;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;

/**
 * Created by comando on 2018/3/4.
 */
public class TestContext extends TestCase {

    private ApplicationContext ctx;

    protected void setUp() throws Exception {

        PropertyEditorManager.registerEditor(List.class, OwnerEditor.class);

        String parentContext = "test/appContext.xml";
        String childContext = "test/babyContext.xml";

        try {
            ctx = new FileSystemXmlApplicationContext(new String[]
                    {parentContext, childContext});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testAppContext() {
        System.out.println(222);

    }

    public void appContext() {
    }

    public void listBeans() {
        try {
            IPet pet = (IPet)ctx.getBean("bodo");
            if (null != pet)
                System.out.println("Found " + pet.getName() + " of species " +
                        pet.getSpecies().getName());
            pet = (IPet)ctx.getBean("raphael");
            if (null != pet)
                System.out.println("Found " + pet.getName() + " of species " +
                        pet.getSpecies().getName());
            pet = (IPet)ctx.getBean("pixel");
            if (null != pet)
                System.out.println("Found " + pet.getName() + " of species " +
                        pet.getSpecies().getName());
            ApplicationContext parent = ctx.getParent();
            if (null != parent) {
                IOwner o = (IOwner)parent.getBean("isabelle");
                if (null != o)
                    System.out.println("Found " + o.getName());
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    public void testSharedObject() {
        class Foo {
            void foo() {
                System.out.println("I am a Foo shared object");
            }
        }
        ctx.shareObject("foo", new Foo());
        Foo foo = (Foo)ctx.sharedObject("foo");
        if (null != foo)
            foo.foo();
    }

    public void testMessages() {
        try {
            System.out.println(ctx.getMessage("tutorial.context.defaultmsg",
                    null, Locale.getDefault()));
            Object[] arguments = {new Date(System.currentTimeMillis())};
            System.out.println(ctx.getMessage("tutorial.context.othermsg",
                    arguments, Locale.getDefault()));
        } catch(NoSuchMessageException e) {
            e.printStackTrace();
        }
    }
}
