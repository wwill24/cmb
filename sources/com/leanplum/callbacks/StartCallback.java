package com.leanplum.callbacks;

public abstract class StartCallback implements Runnable {
    private boolean success;

    public abstract void onResponse(boolean z10);

    public void run() {
        onResponse(this.success);
    }

    public void setSuccess(boolean z10) {
        this.success = z10;
    }
}
