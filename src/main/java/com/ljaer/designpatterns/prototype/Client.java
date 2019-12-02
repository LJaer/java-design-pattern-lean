package com.ljaer.designpatterns.prototype;

public class Client {
    private Prototype prototype;
    public Client(Prototype prototype){
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype concretePrototpye){
        return concretePrototpye.clone();
    }
}
