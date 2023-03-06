
import java.util.*;
import java.util.HashSet;


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