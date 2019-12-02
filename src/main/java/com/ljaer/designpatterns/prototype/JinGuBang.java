package com.ljaer.designpatterns.prototype;

import java.io.Serializable;

public class JinGuBang implements Serializable {
    private static final long serialVersionUID = -4039032019048828754L;

    public float h = 100;
    public float d = 10;
    public void big(){
        this.h *=2;
        this.d *=2;
    }
    public void small(){
        this.h /=2;
        this.d /=2;
    }

}
