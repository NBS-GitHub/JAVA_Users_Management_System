# JAVA_Users_Management_System (UMS)

The UMS allows to add, remove and manipulate users.
The current users are also stored in an .txt file.

In order to create a Users Management System, instantiate the UsersSystem class.

Public methods of an instance:
- addUser(String firstName, String lastName, boolean hasPremium),
- removeUser(int id),
- showFirstName(int id),
- changeFirstName(int id, String newFirstName),
- showLastName(int id),
- changeLastName(int id, String newLastName),
- showPremiumStatus(int id),
- changePremiumStatus(int id),
- showUserInfo(int id),
- showUsersCount().

There are also following private utility methods:
- writeUsersToFile(),
- checkIfUserIsTrue (User user).

---
P.S. The main project method already contains the test of all instance methods.
