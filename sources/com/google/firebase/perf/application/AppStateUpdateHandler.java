package com.google.firebase.perf.application;

import androidx.annotation.NonNull;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;

public abstract class AppStateUpdateHandler implements AppStateMonitor.AppStateCallback {
    private final WeakReference<AppStateMonitor.AppStateCallback> appStateCallback;
    private final AppStateMonitor appStateMonitor;
    private ApplicationProcessState currentAppState;
    private boolean isRegisteredForAppState;

    protected AppStateUpdateHandler() {
        this(AppStateMonitor.getInstance());
    }

    public ApplicationProcessState getAppState() {
        return this.currentAppState;
    }

    public WeakReference<AppStateMonitor.AppStateCallback> getAppStateCallback() {
        return this.appStateCallback;
    }

    /* access modifiers changed from: protected */
    public void incrementTsnsCount(int i10) {
        this.appStateMonitor.incrementTsnsCount(i10);
    }

    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        ApplicationProcessState applicationProcessState2 = this.currentAppState;
        ApplicationProcessState applicationProcessState3 = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (applicationProcessState2 == applicationProcessState3) {
            this.currentAppState = applicationProcessState;
        } else if (applicationProcessState2 != applicationProcessState && applicationProcessState != applicationProcessState3) {
            this.currentAppState = ApplicationProcessState.FOREGROUND_BACKGROUND;
        }
    }

    /* access modifiers changed from: protected */
    public void registerForAppState() {
        if (!this.isRegisteredForAppState) {
            this.currentAppState = this.appStateMonitor.getAppState();
            this.appStateMonitor.registerForAppState(this.appStateCallback);
            this.isRegisteredForAppState = true;
        }
    }

    /* access modifiers changed from: protected */
    public void unregisterForAppState() {
        if (this.isRegisteredForAppState) {
            this.appStateMonitor.unregisterForAppState(this.appStateCallback);
            this.isRegisteredForAppState = false;
        }
    }

    protected AppStateUpdateHandler(@NonNull AppStateMonitor appStateMonitor2) {
        this.isRegisteredForAppState = false;
        this.currentAppState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.appStateMonitor = appStateMonitor2;
        this.appStateCallback = new WeakReference<>(this);
    }
}
