// Base class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class AnimalDogDemo {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        Dog dog = new Dog();

        System.out.print("Animal says: ");
        genericAnimal.makeSound();

        System.out.print("Dog says: ");
        dog.makeSound();
    }
}
