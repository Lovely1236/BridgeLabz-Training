/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
class Animal{
      String name;
      int age;
      void sound(){
          System.out.println("Animal makes a sound");
      }
}
class Dog extends Animal{
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal{
    @Override
    void sound() {
        System.out.println("cat's meow");
    }
}
class Bird extends Animal{
    @Override
    void sound() {
        System.out.println("Bird chirp");
    }
}

public class Animals{
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        Animal myBird = new Bird();
        myAnimal.sound(); // Output: Animal makes a sound
        myDog.sound();    // Output: Dog barks
        myCat.sound();
        myBird.sound();
    }
}
