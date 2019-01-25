package threads.mail;

public class User {
    private String userName;
    private String email;

    /**
     * @author Sergey gavrilov (sarmexin@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
