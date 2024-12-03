package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ne.b;

class SyncTask implements Runnable {
    /* access modifiers changed from: private */
    public final FirebaseMessaging firebaseMessaging;
    private final long nextDelaySeconds;
    @SuppressLint({"ThreadPoolCreation"})
    ExecutorService processorExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("firebase-iid-executor"));
    private final PowerManager.WakeLock syncWakeLock;

    static class ConnectivityChangeReceiver extends BroadcastReceiver {
        private SyncTask task;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.task = syncTask;
        }

        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.task;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                SyncTask.isDebugLogEnabled();
                this.task.firebaseMessaging.enqueueTaskWithDelaySeconds(this.task, 0);
                this.task.getContext().unregisterReceiver(this);
                this.task = null;
            }
        }

        public void registerReceiver() {
            SyncTask.isDebugLogEnabled();
            this.task.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public SyncTask(FirebaseMessaging firebaseMessaging2, long j10) {
        this.firebaseMessaging = firebaseMessaging2;
        this.nextDelaySeconds = j10;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean isDebugLogEnabled() {
        return Log.isLoggable(Constants.TAG, 3);
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.firebaseMessaging.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    public boolean isDeviceConnected() {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean maybeRefreshToken() throws IOException {
        try {
            if (this.firebaseMessaging.blockingGetToken() == null) {
                return false;
            }
            Log.isLoggable(Constants.TAG, 3);
            return true;
        } catch (IOException e10) {
            if (GmsRpc.isErrorMessageForRetryableError(e10.getMessage())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Token retrieval failed: ");
                sb2.append(e10.getMessage());
                sb2.append(". Will retry token retrieval");
                return false;
            } else if (e10.getMessage() == null) {
                return false;
            } else {
                throw e10;
            }
        } catch (SecurityException unused) {
            return false;
        }
    }

    @SuppressLint({"WakelockTimeout"})
    public void run() {
        if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
            this.syncWakeLock.acquire();
        }
        try {
            this.firebaseMessaging.setSyncScheduledOrRunning(true);
            if (!this.firebaseMessaging.isGmsCorePresent()) {
                this.firebaseMessaging.setSyncScheduledOrRunning(false);
                if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    this.syncWakeLock.release();
                }
            } else if (!ServiceStarter.getInstance().hasAccessNetworkStatePermission(getContext()) || isDeviceConnected()) {
                if (maybeRefreshToken()) {
                    this.firebaseMessaging.setSyncScheduledOrRunning(false);
                } else {
                    this.firebaseMessaging.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                }
                if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    return;
                }
                this.syncWakeLock.release();
            } else {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    this.syncWakeLock.release();
                }
            }
        } catch (IOException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb2.append(e10.getMessage());
            sb2.append(". Won't retry the operation.");
            this.firebaseMessaging.setSyncScheduledOrRunning(false);
            if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
            }
        } catch (Throwable th2) {
            if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                this.syncWakeLock.release();
            }
            throw th2;
        }
    }
}
