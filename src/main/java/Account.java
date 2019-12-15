public class Account {
    private String name,password;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        if(password.length()<2)
            return "HII";
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
