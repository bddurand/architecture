package com.bdurand.msposts.observer;

interface Observable {

    void attach(Observer o);
    void detach(Observer o);
    void notifyObserver();
}
