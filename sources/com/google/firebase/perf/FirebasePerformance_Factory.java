package com.google.firebase.perf;

import cd.f;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import fj.d;
import fk.a;

public final class FirebasePerformance_Factory implements d<FirebasePerformance> {
    private final a<ConfigResolver> configResolverProvider;
    private final a<FirebaseApp> firebaseAppProvider;
    private final a<FirebaseInstallationsApi> firebaseInstallationsApiProvider;
    private final a<Provider<RemoteConfigComponent>> firebaseRemoteConfigProvider;
    private final a<RemoteConfigManager> remoteConfigManagerProvider;
    private final a<SessionManager> sessionManagerProvider;
    private final a<Provider<f>> transportFactoryProvider;

    public FirebasePerformance_Factory(a<FirebaseApp> aVar, a<Provider<RemoteConfigComponent>> aVar2, a<FirebaseInstallationsApi> aVar3, a<Provider<f>> aVar4, a<RemoteConfigManager> aVar5, a<ConfigResolver> aVar6, a<SessionManager> aVar7) {
        this.firebaseAppProvider = aVar;
        this.firebaseRemoteConfigProvider = aVar2;
        this.firebaseInstallationsApiProvider = aVar3;
        this.transportFactoryProvider = aVar4;
        this.remoteConfigManagerProvider = aVar5;
        this.configResolverProvider = aVar6;
        this.sessionManagerProvider = aVar7;
    }

    public static FirebasePerformance_Factory create(a<FirebaseApp> aVar, a<Provider<RemoteConfigComponent>> aVar2, a<FirebaseInstallationsApi> aVar3, a<Provider<f>> aVar4, a<RemoteConfigManager> aVar5, a<ConfigResolver> aVar6, a<SessionManager> aVar7) {
        return new FirebasePerformance_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static FirebasePerformance newInstance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, Provider<f> provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver, SessionManager sessionManager) {
        return new FirebasePerformance(firebaseApp, provider, firebaseInstallationsApi, provider2, remoteConfigManager, configResolver, sessionManager);
    }

    public FirebasePerformance get() {
        return newInstance(this.firebaseAppProvider.get(), this.firebaseRemoteConfigProvider.get(), this.firebaseInstallationsApiProvider.get(), this.transportFactoryProvider.get(), this.remoteConfigManagerProvider.get(), this.configResolverProvider.get(), this.sessionManagerProvider.get());
    }
}
