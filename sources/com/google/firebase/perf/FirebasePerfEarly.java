package com.google.firebase.perf;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.concurrent.Executor;

public class FirebasePerfEarly {
    public FirebasePerfEarly(FirebaseApp firebaseApp, FirebaseSessions firebaseSessions, StartupTime startupTime, Executor executor) {
        Context applicationContext = firebaseApp.getApplicationContext();
        final ConfigResolver instance = ConfigResolver.getInstance();
        instance.setApplicationContext(applicationContext);
        AppStateMonitor instance2 = AppStateMonitor.getInstance();
        instance2.registerActivityLifecycleCallbacks(applicationContext);
        instance2.registerForAppColdStart(new FirebasePerformanceInitializer());
        if (startupTime != null) {
            AppStartTrace instance3 = AppStartTrace.getInstance();
            instance3.registerActivityLifecycleCallbacks(applicationContext);
            executor.execute(new AppStartTrace.StartFromBackgroundRunnable(instance3));
        }
        firebaseSessions.register(new SessionSubscriber() {
            @NonNull
            public SessionSubscriber.Name getSessionSubscriberName() {
                return SessionSubscriber.Name.PERFORMANCE;
            }

            public boolean isDataCollectionEnabled() {
                if (!instance.isCollectionEnabledConfigValueAvailable()) {
                    return false;
                }
                return ConfigResolver.getInstance().isPerformanceMonitoringEnabled();
            }

            public void onSessionChanged(@NonNull SessionSubscriber.SessionDetails sessionDetails) {
                SessionManager.getInstance().updatePerfSession(PerfSession.createWithId(sessionDetails.getSessionId()));
            }
        });
        SessionManager.getInstance().initializeGaugeCollection();
    }
}
