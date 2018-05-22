package br.com.poo.fatecpg.poo;

public class Customer {
    private String id;
    private String name;
    private double creditLimit;

    public Customer(String id, String name, double creditLimit) {
        this.id = id;
        this.name = name;
        this.creditLimit = creditLimit;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    
}
