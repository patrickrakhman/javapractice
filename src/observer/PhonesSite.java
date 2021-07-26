package observer;

import java.util.ArrayList;
import java.util.List;

public class PhonesSite implements Observed {
    List<String> phones = new ArrayList<>();
    List<Observer> subscribers = new ArrayList<>();

    public void addPhone (String phone){
        this.phones.add(phone);
        notifyObserver();
    }


    public void  removePhone (String phone){
        this.phones.remove(phone);
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer){
        this.subscribers.add(observer);

    }

    public void removeObserver(Observer observer){
        this.subscribers.remove(observer);

    }

    @Override
    public void notifyObserver() {
        for(Observer observer : subscribers){
            observer.handleEvent(this.phones);
        }

    }


}
