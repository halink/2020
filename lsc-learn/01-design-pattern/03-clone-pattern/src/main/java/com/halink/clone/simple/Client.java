package com.halink.clone.simple;

public class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public PrototypeA startClone() {
        return (PrototypeA) this.prototype.clone();
    }
}
