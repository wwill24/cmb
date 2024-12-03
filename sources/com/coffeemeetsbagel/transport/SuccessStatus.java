package com.coffeemeetsbagel.transport;

import java.io.Serializable;

public class SuccessStatus implements Serializable {
    public final String mSuccessMessage;

    public SuccessStatus(String str) {
        this.mSuccessMessage = str;
    }
}
