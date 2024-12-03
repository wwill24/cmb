package com.leanplum.callbacks;

public abstract class InboxSyncedCallback implements Runnable {
    private boolean success;

    public abstract void onForceContentUpdate(boolean z10);

    public void run() {
        onForceContentUpdate(this.success);
    }

    public void setSuccess(boolean z10) {
        this.success = z10;
    }
}
