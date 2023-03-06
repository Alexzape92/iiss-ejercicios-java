
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