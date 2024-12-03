package com.leanplum.callbacks;

import com.leanplum.Var;

public abstract class VariableCallback<T> implements Runnable {
    private Var<T> variable;

    public abstract void handle(Var<T> var);

    public void run() {
        synchronized (this.variable) {
            handle(this.variable);
        }
    }

    public void setVariable(Var<T> var) {
        this.variable = var;
    }
}
