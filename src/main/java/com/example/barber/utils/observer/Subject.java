package com.example.barber.utils.observer;
import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers;

    protected Subject() {
    }

    protected Subject(Observer observer) {

        this(new ArrayList<>()); //inizializzo la lista di observer con un ArrayList vuoto
        this.attach(observer);
    }

    protected Subject(List<Observer> list) {
        this.observers = list;
    }
    public void attach(Observer obs) {
        this.observers.add(obs);
    }

    public void notify(Object object) {
        for (Observer observer : observers) {
            observer.update(object);
        }
    }
}
