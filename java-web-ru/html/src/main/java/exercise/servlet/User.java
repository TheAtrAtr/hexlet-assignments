package exercise.servlet;

public class User {

    private String firstName;
    private String lastName;
    private String id;
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String id, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
