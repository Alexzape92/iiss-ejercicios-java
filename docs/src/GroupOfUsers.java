import java.util.*;

public class GroupOfUsers {
    private static Map<String, Integer> usersWithPoints =
      new HashMap<String, Integer>() {{
        put("User1", 800);
        put("User2", 550);
        put("User3", 20);
        put("User4", 300);
    }};

    public List<String> getUsers() {
        List<String> users = new ArrayList<String>();
        
        //Sorting users by points
        usersWithPoints.entrySet()
        .stream()
        .forEach(x -> users.add(x.getKey()));
       
        return users;
    }
    public List<String> getUsersSortedByPoints() {
        List<String> users = new ArrayList<String>();
        
        //Sorting users by points
        usersWithPoints.entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEachOrdered(x -> users.add(x.getKey()));
        
        return users;
      }
    
    public List<String> getUsersCapitalized() {
        List<String> users = new ArrayList<String>();
        
        //Capitalizing the names of the users
        usersWithPoints.entrySet()
        .stream()
        .forEach(x -> users.add(x.getKey().toUpperCase()));
        
        return users;
    }

    public List<String> getUsersSortedByPointsAndCapitalized() {
        List<String> users = getUsersSortedByPoints();
        
        //Sorting users by points
        List<String> finalUsers = new ArrayList<String>();
        users.forEach(x -> finalUsers.add(x.toUpperCase()));
        
        return users;
    }

    public static void main(String[] args) {
        GroupOfUsers group = new GroupOfUsers();
    List<String> users = group.getUsersSortedByPointsAndCapitalized();
    System.out.println("The users are: " + users);
    }
}
