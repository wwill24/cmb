package com.leanplum.callbacks;

public abstract class VariablesChangedCallback implements Runnable {
    public void run() {
        variablesChanged();
    }

    public abstract void variablesChanged();
}
