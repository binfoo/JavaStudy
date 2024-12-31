package fanxing;

import java.util.ArrayList;
import java.util.List;

public class Tpf {

    public static void printAnimals(List<? extends Animal > list){
        for(Animal animal:list){
            System.out.println(animal + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        printAnimals(animals);
        printAnimals(dogs);
    }
}

class Animal {}
class Dog extends  Animal {}
