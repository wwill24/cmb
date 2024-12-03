package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/AnalyticsUserIDStore;", "", "()V", "ANALYTICS_USER_ID_KEY", "", "TAG", "kotlin.jvm.PlatformType", "initialized", "", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "userID", "getUserID", "initAndWait", "", "initStore", "setUserID", "id", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AnalyticsUserIDStore {
    private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
    public static final AnalyticsUserIDStore INSTANCE = new AnalyticsUserIDStore();
    private static final String TAG = AnalyticsUserIDStore.class.getSimpleName();
    private static volatile boolean initialized;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static String userID;

    private AnalyticsUserIDStore() {
    }

    public static final String getUserID() {
        if (!initialized) {
            INSTANCE.initAndWait();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.readLock().lock();
        try {
            String str = userID;
            reentrantReadWriteLock.readLock().unlock();
            return str;
        } catch (Throwable th2) {
            lock.readLock().unlock();
            throw th2;
        }
    }

    private final void initAndWait() {
        if (!initialized) {
            ReentrantReadWriteLock reentrantReadWriteLock = lock;
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (initialized) {
                    reentrantReadWriteLock.writeLock().unlock();
                    return;
                }
                userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(ANALYTICS_USER_ID_KEY, (String) null);
                initialized = true;
                reentrantReadWriteLock.writeLock().unlock();
            } catch (Throwable th2) {
                lock.writeLock().unlock();
                throw th2;
            }
        }
    }

    public static final void initStore() {
        if (!initialized) {
            InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initStore$lambda-0  reason: not valid java name */
    public static final void m35initStore$lambda0() {
        INSTANCE.initAndWait();
    }

    public static final void setUserID(String str) {
        AppEventUtility.assertIsNotMainThread();
        if (!initialized) {
            INSTANCE.initAndWait();
        }
        InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new b(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUserID$lambda-1  reason: not valid java name */
    public static final void m36setUserID$lambda1(String str) {
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            userID = str;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.putString(ANALYTICS_USER_ID_KEY, userID);
            edit.apply();
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th2) {
            lock.writeLock().unlock();
            throw th2;
        }
    }
}
