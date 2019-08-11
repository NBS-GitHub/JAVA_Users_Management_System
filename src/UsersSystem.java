import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class UsersSystem {
    List<User> usersList = new ArrayList<>();

    public UsersSystem() {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("welcome.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        System.out.println();
    }

    //////////////////////////////////////////////////////////////////////////

    public void addUser(String firstName, String lastName, boolean hasPremium) {
        User user = new User(firstName, lastName, hasPremium);
        usersList.add(user);
        writeUsersToFile();
        System.out.println();
    }

    //////////////////////////////////////////////////////////////////////////

    public void removeUser(int id) {
        User user = searchUserById(id);
        boolean isUserTrue = checkIfUserIsTrue(user);
        if(isUserTrue) {
            usersList.remove(id);
            System.out.printf("User with id %d has been removed.\n", id);
            writeUsersToFile();
        }
    }

    //////////////////////////////////////////////////////////////////////////

    public void showFirstName(int id) {
        User user = searchUserById(id);
        boolean isUserTrue = checkIfUserIsTrue(user);
        if(isUserTrue) {
            String firstName = user.getFirstName();
            System.out.printf("User id: %d. First name: %s.\n", id, firstName);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    public void changeFirstName(int id, String newFirstName) {
        User user = searchUserById(id);
        boolean isUserTrue = checkIfUserIsTrue(user);
        if(isUserTrue) {
            user.changeFirstName(newFirstName);
            System.out.printf("User id: %d. First name edited. New first name: %s.\n", id, newFirstName);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    public void showLastName(int id) {
        User user = searchUserById(id);
        boolean isUserTrue = checkIfUserIsTrue(user);
        if(isUserTrue) {
            String lastName = user.getLastName();
            System.out.printf("User id: %d. Last name: %s.\n", id, lastName);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    public void changeLastName(int id, String newLastName) {
        User user = searchUserById(id);
        boolean isUserTrue = checkIfUserIsTrue(user);
        if (isUserTrue) {
            user.changeLastName(newLastName);
            System.out.printf("User id: %d. Last name edited. New last name: %s.\n", id, newLastName);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    public void showPremiumStatus(int id) {
        User user = searchUserById(id);
        boolean isUserTrue = checkIfUserIsTrue(user);
        if (isUserTrue) {
            boolean premiumStatus = user.getPremiumStatus();
            System.out.printf("User id: %d. Premium status: %b.\n", id, premiumStatus);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    public void changePremiumStatus(int id) {
        User user = searchUserById(id);
        boolean isUserTrue = checkIfUserIsTrue(user);
        if (isUserTrue) {
            boolean newPremiumStatus = user.changePremiumStatus();
            System.out.printf("User id: %d. Premium status changed. Current premium status: %b.\n", id, newPremiumStatus);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    public void showUserInfo(int id) {
        User user = searchUserById(id);
        boolean isUserTrue = checkIfUserIsTrue(user);
        if (isUserTrue) {
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            boolean premiumStatus = user.getPremiumStatus();
            System.out.printf("INFO - User id: %d.\nFirst name: %s.\nLast name: %s\nHas premium: %b.\n", id, firstName, lastName, premiumStatus);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    public void showUsersCount() {
        System.out.printf("Users count: %d.\n",  usersList.size());
    }

    //////////////////////////////////////////////////////////////////////////

    private User searchUserById(int id) {
        Integer userIndex = null;
        for(int i=0; i<usersList.size(); i++) {
            if(usersList.get(i).id == id) {
                userIndex = i;
                break;
            }
        }
        if (userIndex == null) {
            System.out.println("User with the given id not found.\n");
            FakeUser user = new FakeUser("noname", "noname", false);
            return user;
        }
        User user = usersList.get(userIndex);
        return user;
    }

    //////////////////////////////////////////////////////////////////////////

    private void writeUsersToFile() {
        try {
            Formatter formatter = new Formatter("usersList.txt");
            for(User aUser: usersList)
                formatter.format(String.format("User id: %d.\n\tFirst name: %s.\n\tLast name: %s.\n\tHas premium: %b.\n\n", aUser.id, aUser.getFirstName(), aUser.getLastName(), aUser.getPremiumStatus()));
            formatter.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    //////////////////////////////////////////////////////////////////////////

    private boolean checkIfUserIsTrue (User user) {
        if (user instanceof FakeUser)
            return false;
        return true;
    }
}