package DTO;

public class User_DTO 
{
    private int userID;
    private String username;
    private String password;
    private String userRole;

    public User_DTO() {
    }

    public User_DTO(int userID, String username, String password, String userRole) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    
}
