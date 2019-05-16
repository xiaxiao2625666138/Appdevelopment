package ebook;

public class Euser {
    private String name;
    private String password;
    private String phone;
    private String address;
    private String email;
    private char disabled;

    public Euser(){}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public char getDisabled() {
        return disabled;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDisabled(char disabled) {
        this.disabled = disabled;
    }
}
