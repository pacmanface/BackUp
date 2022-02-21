package com.pacmanface.dates;

import java.lang.reflect.*;

public class DatesTestDrive {
    
    public static void main(String[] args) {
        DatesTestDrive testDrive = new DatesTestDrive();
        testDrive.go();
    }

    private void go(){
        PersonBean joe = new PersonBeanImpl();
        PersonBean owner = getOwnerProxy(joe);
        try{
            owner.setGender("male");
            System.out.println("proceed");
            owner.setInterests("sixpackbeer");
            System.out.println("proceed");
            owner.setName("josse b.");
            System.out.println("proceed");
            owner.setHotOrNotRating(100);
            System.out.println("proceed");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("operation aborted");
        }
    }

    public static PersonBean getOwnerProxy(PersonBean p){
        return (PersonBean) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new OwnerInvocationHandler(p));
    }

    public static PersonBean getNonOwnerProxy(PersonBean p){
        return (PersonBean) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new NonOwnerInvocationHandler(p));
    }
}
