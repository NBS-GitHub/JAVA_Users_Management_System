public class Main {
    public static void main(String[] args) {

        // Users Management System (UMS) - TEST

        // Instantiate the UMS:
        UsersSystem ums = new UsersSystem();

        System.out.println("\n----- Users Management System (UMS) - METHODS' TEST -----\n");

        // Methods' test:
        ums.addUser("John", "Doe", true);
        ums.addUser("Jane", "Brown", false);
        ums.addUser("Santa", "Claus", true);

        ums.removeUser(2);
        ums.removeUser(20); //  No such id in the list. FakeUser created.

        ums.addUser("John James", "Rambo", true);

        System.out.println();  //  empty line

        ums.showFirstName(1);
        ums.changeFirstName(1,"Claire");
        ums.showFirstName(1);

        System.out.println();  //  empty line

        ums.showLastName(1);
        ums.changeLastName(1, "Underwood");
        ums.showLastName(1);

        System.out.println();  //  empty line

        ums.showPremiumStatus(1);
        ums.changePremiumStatus(1);
        ums.showPremiumStatus(1);

        System.out.println();  //  empty line

        ums.showUserInfo(1);

        System.out.println();  //  empty line

        ums.showUsersCount();

    }
}