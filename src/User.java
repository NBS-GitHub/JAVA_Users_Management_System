public class User {
    private static int counter = 0;
    public int id;
    private String firstName;
    private String lastName;
    private boolean hasPremium;

    ///////////////////////////////////////////////////////////////////////////

    public User(String firstName, String lastName, boolean hasPremium) {
        this.id = counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasPremium = hasPremium;

        if(!(this instanceof FakeUser)) {
            counter++;
            System.out.printf("New user created:\nId: %d\nFirst name: %s\nLast name: %s\nHas premium: %b\n", id, firstName, lastName, hasPremium);
        }
      }

    ///////////////////////////////////////////////////////////////////////////

    public String getFirstName() {
        return firstName;
    }

    public void changeFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    ///////////////////////////////////////////////////////////////////////////

    public String getLastName() {
        return lastName;
    }
    public void changeLastName(String newLastName) {
        lastName = newLastName;
    }

    ///////////////////////////////////////////////////////////////////////////

    public boolean getPremiumStatus() {
        return hasPremium;
    }

    public boolean changePremiumStatus() {
        hasPremium = !hasPremium;
        return hasPremium;
    }
}