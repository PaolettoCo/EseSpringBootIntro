package com.example.democontroller;

public class Person {

    private String name;
    private String province;
    private String greeting;

    public Person(String name, String province) {
        this.name = name;
        this.province = province;
        this.greeting = "ciao " + name + ", com'è il tempo in " + province + "?";
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }

    public String getGreeting() {
        return greeting;
    }
}
