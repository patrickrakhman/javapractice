package com.nix.lesson8.weekEnam;

public enum WeekEnam {
    SUNDAY("Sunday","Weekend"), MONDAY("Monday","Weekday"), TUESDAY("Tuesday","Weekday"), WEDNESDAY("Wednesday","Weekday"), THURSDAY("Thursday","Weekday"), FRIDAY("Friday","Weekday"), SATURDAY("Saturday","Weekend");

    private String name;
    private String type;

    WeekEnam(String name, String type){
        this.name = name;
        this.type = type;

    }

    public  String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;

    }
    public  String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return  name +
                " is " + type;

    }



}

