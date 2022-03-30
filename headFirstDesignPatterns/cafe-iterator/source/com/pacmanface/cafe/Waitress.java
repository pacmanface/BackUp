package com.pacmanface.cafe;

public class Waitress {

    PancakeHouseMenu pancakes = null;
    SandwichPalaceMenu sandwiches = null;

    public Waitress(PancakeHouseMenu p, SandwichPalaceMenu s){
        pancakes = p;
        sandwiches = s;
    }

    public void printMenu(){
        MenuIterator iteratorOne = pancakes.createIterator();
        MenuIterator iteratorTwo = sandwiches.createIterator();
        printMenu(iteratorOne);
        printMenu(iteratorTwo);
    }

    public void printMenu(MenuIterator m){
        System.out.print("\nMENU\n");
        while(m.hasNext()){
            System.out.println(m.next().toString());
        }
    }
}
