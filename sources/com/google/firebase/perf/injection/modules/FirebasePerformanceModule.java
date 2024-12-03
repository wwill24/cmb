package com.google.firebase.perf.injection.modules;

import androidx.annotation.NonNull;
import cd.f;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;

public class FirebasePerformanceModule {
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<RemoteConfigComponent> remoteConfigComponentProvider;
    private final Provider<f> transportFactoryProvider;

    public FirebasePerformanceModule(@NonNull FirebaseApp firebaseApp2, @NonNull FirebaseInstallationsApi firebaseInstallationsApi, @NonNull Provider<RemoteConfigComponent> provider, @NonNull Provider<f> provider2) {
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.remoteConfigComponentProvider = provider;
        this.transportFactoryProvider = provider2;
    }

    /* access modifiers changed from: package-private */
    public ConfigResolver providesConfigResolver() {
        return ConfigResolver.getInstance();
    }

    /* access modifiers changed from: package-private */
    public FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    /* access modifiers changed from: package-private */
    public FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    /* access modifiers changed from: package-private */
    public Provider<RemoteConfigComponent> providesRemoteConfigComponent() {
        return this.remoteConfigComponentProvider;
    }

    /* access modifiers changed from: package-private */
    public RemoteConfigManager providesRemoteConfigManager() {
        return RemoteConfigManager.getInstance();
    }

    /* access modifiers changed from: package-private */
    public SessionManager providesSessionManager() {
        return SessionManager.getInstance();
    }

    /* access modifiers changed from: package-private */
    public Provider<f> providesTransportFactoryProvider() {
        return this.transportFactoryProvider;
    }
}
