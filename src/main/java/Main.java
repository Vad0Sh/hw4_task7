import Entity.Animal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnimalHelper bh = new AnimalHelper();
        String[] names = {"Cat", "Tiger", "Cheetah"};

        for (String name : names) {
            Animal animal = new Animal();
            animal.setName(name);
            bh.add(animal);
        }

        List<Animal> animalList = bh.getAll();

        for (Animal animal : animalList) {
            System.out.println(animal.getId() + " " + animal.getName());
        }

        Animal animal = bh.getById(2);
        System.out.println(animal.getName());
    }

}
