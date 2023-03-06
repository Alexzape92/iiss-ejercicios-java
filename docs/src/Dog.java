
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
