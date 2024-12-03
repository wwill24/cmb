package com.google.firebase.database.android;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.core.Platform;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.persistence.DefaultPersistenceManager;
import com.google.firebase.database.core.persistence.LRUCachePolicy;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.AndroidLogger;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.bytebuddy.utility.JavaConstant;

public class AndroidPlatform implements Platform {
    private static final String APP_IN_BACKGROUND_INTERRUPT_REASON = "app_in_background";
    /* access modifiers changed from: private */
    public final Context applicationContext;
    private final Set<String> createdPersistenceCaches = new HashSet();
    private final FirebaseApp firebaseApp;

    public AndroidPlatform(FirebaseApp firebaseApp2) {
        this.firebaseApp = firebaseApp2;
        if (firebaseApp2 != null) {
            this.applicationContext = firebaseApp2.getApplicationContext();
            return;
        }
        throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
    }

    public PersistenceManager createPersistenceManager(com.google.firebase.database.core.Context context, String str) {
        String sessionPersistenceKey = context.getSessionPersistenceKey();
        String str2 = str + JavaConstant.Dynamic.DEFAULT_NAME + sessionPersistenceKey;
        if (!this.createdPersistenceCaches.contains(str2)) {
            this.createdPersistenceCaches.add(str2);
            return new DefaultPersistenceManager(context, new SqlPersistenceStorageEngine(this.applicationContext, context, str2), new LRUCachePolicy(context.getPersistenceCacheSizeBytes()));
        }
        throw new DatabaseException("SessionPersistenceKey '" + sessionPersistenceKey + "' has already been used.");
    }

    public String getPlatformVersion() {
        return "android-" + FirebaseDatabase.getSdkVersion();
    }

    public File getSSLCacheDirectory() {
        return this.applicationContext.getApplicationContext().getDir("sslcache", 0);
    }

    public String getUserAgent(com.google.firebase.database.core.Context context) {
        return Build.VERSION.SDK_INT + "/Android";
    }

    public EventTarget newEventTarget(com.google.firebase.database.core.Context context) {
        return new AndroidEventTarget();
    }

    public Logger newLogger(com.google.firebase.database.core.Context context, Logger.Level level, List<String> list) {
        return new AndroidLogger(level, list);
    }

    public PersistentConnection newPersistentConnection(com.google.firebase.database.core.Context context, ConnectionContext connectionContext, HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        final PersistentConnectionImpl persistentConnectionImpl = new PersistentConnectionImpl(connectionContext, hostInfo, delegate);
        this.firebaseApp.addBackgroundStateChangeListener(new FirebaseApp.BackgroundStateChangeListener() {
            public void onBackgroundStateChanged(boolean z10) {
                if (z10) {
                    persistentConnectionImpl.interrupt(AndroidPlatform.APP_IN_BACKGROUND_INTERRUPT_REASON);
                } else {
                    persistentConnectionImpl.resume(AndroidPlatform.APP_IN_BACKGROUND_INTERRUPT_REASON);
                }
            }
        });
        return persistentConnectionImpl;
    }

    public RunLoop newRunLoop(com.google.firebase.database.core.Context context) {
        final LogWrapper logger = context.getLogger("RunLoop");
        return new DefaultRunLoop() {
            public void handleException(final Throwable th2) {
                final String messageForException = DefaultRunLoop.messageForException(th2);
                logger.error(messageForException, th2);
                new Handler(AndroidPlatform.this.applicationContext.getMainLooper()).post(new Runnable() {
                    public void run() {
                        throw new RuntimeException(messageForException, th2);
                    }
                });
                getExecutorService().shutdownNow();
            }
        };
    }
}
