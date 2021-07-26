package observer;

import java.util.List;

public class Subscriber implements Observer{
    String name;

    Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> phones){
        System.out.println("Dear " + name + "\nWe have some changes in goods" + phones);
    }

    }
