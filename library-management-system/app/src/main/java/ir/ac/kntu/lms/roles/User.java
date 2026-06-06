package ir.ac.kntu.lms.roles;

import ir.ac.kntu.lms.financial.Wallet;

public abstract class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String id;
    private Wallet wallet;
    
    public User(){}

    public User(String firstName, String lastName, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.wallet = new Wallet();
        this.id = calculateId();
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nFull name: ").append(firstName).append(" ").append(lastName);
        sb.append("\nPhone number: ").append(phoneNumber);
        sb.append("\nEmail: ").append(email);
        sb.append("\nId: ").append(id);
        return sb.toString();
    }

    private String sumOfAscciiForFields(String field) {
        int output = 0;
        for (char c: field.toCharArray()) {
            output += c;
        }
        return Integer.toString(output % 10);
    }

    private String calculateId() {
        StringBuilder sb = new StringBuilder();
        sb.append(sumOfAscciiForFields(this.firstName)).append(sumOfAscciiForFields(this.lastName));
        sb.append(sumOfAscciiForFields(this.phoneNumber)).append(sumOfAscciiForFields(this.email));
        sb.append(sumOfAscciiForFields(password));
        return sb.toString();
    }

    public double getWalletBalance() {
        return wallet.getBalance();
    }

    public void depositToWallet(double value) {
        wallet.deposit(value);
    }

    public void withdrawFromWallet(double value) {
        wallet.withdrawal(value);
    }

    public void displayTransactions() {
        wallet.displayTransactions();
    }

    public void displayTransactions(int numberOfTransaction) {
        wallet.displayTransactions(numberOfTransaction);
    }


    protected  String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected String getEmail() {
        return email;
    }

    protected String getPassword() {
        return password;
    }

    protected String getId() {
        return id;
    }

    protected Wallet getWallet() {
        return wallet;
    }

    protected void setId(String id) {
        this.id = id;
    }
    
}


