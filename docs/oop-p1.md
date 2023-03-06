# Práctica 1: Herencia, composición y polimorfismo

## Ejercicios propuestos

### Ejercicio 1

Dados los siguientes fragmentos de código, responder a las siguientes preguntas:

#### `ElementsSet.java`

```java
public class ElementsSet<E> extends HashSet<E> {
    //Number of attempted elements insertions using the "add" method
    private int numberOfAddedElements = 0;

    public ElementsSet() {}

    @Override
    public boolean add(E element) {
        numberOfAddedElements++; //Counting the element added
        return super.add(element);
    } 

    @Override
    public boolean addAll(Collection<? extends E> elements) {
        numberOfAddedElements += elements.size(); //Counting the elements added
        return super.addAll(elements);
    } 

    public int getNumberOfAddedElements() {
        return numberOfAddedElements;
    }
}
```

#### `Main.java`

```java
    ...
    ElementsSet<String> set = new ElementsSet<String>();
    set.addAll(Arrays.asList("One", "Two", "Three"));
    System.out.println(set.getNumberOfAddedElements());
    ...
```

#### Preguntas propuestas

a) ¿Es el uso de la herencia adecuado para la implementación de la clase `ElementsSet`? ¿Qué salida muestra la función `System.out.println` al invocar el método `getNumberOfAddedElements`, 3 o 6?

    Realmente no es necesaria esta herencia, ya que estamos redefiniendo métodos de HashSet en los cuales llamamos al propio método de HashSet. System.out.println imprime 6, debido a las relaciones y dependencias derivadas de la herencia.

b) En el caso de que haya algún problema en la implementación anterior, proponga una solución alternativa usando composición/delegación que resuelva el problema.

    Este es el código generado:

```java
public class ej1<E>{
    private HashSet<E> set = new HashSet<E>();
    private int numberOfAddedElements = 0;

    public boolean add(E element){
        numberOfAddedElements++;
        return set.add(element);
    }

    public boolean addAll(Collection<? extends E> elements) {
        numberOfAddedElements += elements.size();
        return set.addAll(elements);
    }

    public int getNumberOfAddedElements(){
        return numberOfAddedElements;
    }

    public static void main(String[] args) {
        ej1<String> set = new ej1<String>();
        set.addAll(Arrays.asList("One", "Two", "Three"));
        System.out.println(set.getNumberOfAddedElements());
    }
}
```
    Utilizamos la delegación para solventar el problema, quedando un código de mucha más calidad.


### Ejercicio 2

Dado los siguientes fragmentos de código responder a las siguientes preguntas:

#### `Animal.java`

```java
public abstract class Animal {
    //Number of legs the animal holds
    protected int numberOfLegs = 0;

    public abstract String speak();
    public abstract boolean eat(String typeOfFeed);
    public abstract int getNumberOfLegs();
}
```

#### `Cat.java`

```java
public class Cat extends Animal {
    @Override
    public String speak() {
        return "Meow";
    }

    @Override
    public boolean eat(String typeOfFeed) {
        if(typeOfFeed.equals("fish")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getNumberOfLegs() {
        return super.numberOfLegs;
    }
}
```

#### `Dog.java`

```java
public class Dog extends Animal {
    @Override
    public String speak() {
        return "Woof";
    }

    @Override
    public boolean eat(String typeOfFeed) {
        if(typeOfFeed.equals("meat")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getNumberOfLegs() {
        return super.numberOfLegs;
    }
}
```

#### `Main.java`

```java
    ...
    Animal cat = new Cat();
    Animal dog = new Dog();
    System.out.println(cat.speak());
    System.out.println(dog.speak());
    ...
```

#### Preguntas propuestas

a) ¿Es correcto el uso de herencia en la implementación de las clases `Cat` y `Dog`? ¿Qué beneficios se obtienen?

    El principal beneficio que obtenemos es el poder tratar tanto las clases Cat y Dog como Animal. Sin embargo, esta forma de herencia es incorrecta, ya que estamos heredando (extend) una clase puramente abstracta, con un único atributo que ni siquiera estamos modificando en ninguna subclase (el número de piernas siempre será 0). Sería más correcto usar una interfaz para heredar sólo la interfaz, no el comportamiento.

b) En el caso de que el uso de la herencia no sea correcto, proponga una solución alternativa. ¿Cuáles son los beneficios de la solución propuesta frente a la original.

#### `Animal.java`
```java
public interface Animal {
    public String speak();
    public boolean eat(String typeOfFeed);
    public int getNumberOfLegs();
}
```

#### `Cat.java`
```java

public class Cat implements Animal{
    private int numberOfLegs = 4;

    public String speak(){
        return "Meow";
    }

    public boolean eat(String typeOfFeed){
        if(typeOfFeed.equals("fish"))
            return true;
        else
            return false;
    }

    public int getNumberOfLegs(){
        return numberOfLegs;
    }
}
```

#### `Dog.java`
```java

public class Dog implements Animal{
    private int numberOfLegs = 4;

    public String speak(){
        return "Woof";
    }

    public boolean eat(String typeOfFeed){
        if(typeOfFeed.equals("meat"))
            return true;
        else
            return false;
    }

    public int getNumberOfLegs(){
        return numberOfLegs;
    }
}
```

#### `Main.java`
```java

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        System.out.println(cat.speak());
        System.out.println(dog.speak());
    }
}
```

    Como se puede ver, así queda mucho más organizado. Tenemos a Animal como una interfaz, ahorrándonos usar una herencia completa de una clase abstracta, en la cual todos sus métodos eran abstractos, lo cual no tiene mucho sentido. Además, podemos establecer a cada subclase el número de patas que tiene, para que funcione correctamente.