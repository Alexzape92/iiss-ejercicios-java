import java.util.*;

public class GroupOfUsers3 {
    private static Map<String, Integer> usersWithPoints_Group1 =
      new HashMap<String, Integer>() {{
        put("User1", 800);
        put("User2", 550);
        put("User3", 20);
        put("User4", 300);
    }};
    
    private static Map<String, Integer> usersWithPoints_Group2 =
      new HashMap<String, Integer>() {{
        put("User1", 10);
        put("User2", 990);
        put("User3", 760);
        put("User4", 230);
    }};
    
    private static Map<String, Integer> usersWithPoints_Group3 =
      new HashMap<String, Integer>() {{
        put("User1", 1000);
        put("User2", 200);
        put("User3", 5);
        put("User4", 780);
    }};

    private List<String> orderUsersByPoints(Map<String, Integer> usersWithPoints) {
        List<String> users = new ArrayList<String>();
        
        //Sorting users by points
        usersWithPoints.entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEachOrdered(x -> users.add(x.getKey()));
        
        return users;
    }

    private List<String> capitalizeUsers(List<String> users) {
        List<String> usersCapitalized = new ArrayList<String>();
        
        users.forEach(x -> usersCapitalized.add(x.toUpperCase()));
        
        return usersCapitalized;
    }

    public List<ArrayList<String>> getUsers() {
        List<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
        
        //Sorting users by points
        List<String> users1 = orderUsersByPoints(usersWithPoints_Group1);
        
        List<String> users2 = orderUsersByPoints(usersWithPoints_Group2);

        List<String> users3 = orderUsersByPoints(usersWithPoints_Group3);
        
        //Capitalizing the names of the users
        users1 = capitalizeUsers(users1);
        users2 = capitalizeUsers(users2);
        users3 = capitalizeUsers(users3);
        
        //Adding users to the main list
        users.add((ArrayList<String>)users1);
        users.add((ArrayList<String>)users2);
        users.add((ArrayList<String>)users3);
        
        return users;
    }

    public static void main(String[] args) {
        GroupOfUsers3 groupOfUsers = new GroupOfUsers3();
        
        List<ArrayList<String>> users = groupOfUsers.getUsers();
        
        System.out.println("The users are: " + users);
    }
}
