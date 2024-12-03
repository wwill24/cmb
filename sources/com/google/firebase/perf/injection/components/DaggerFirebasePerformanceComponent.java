package com.google.firebase.perf.injection.components;

import cd.f;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.FirebasePerformance_Factory;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesConfigResolverFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseAppFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesSessionManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import fj.c;
import fj.g;
import fk.a;

public final class DaggerFirebasePerformanceComponent implements FirebasePerformanceComponent {
    private a<FirebasePerformance> firebasePerformanceProvider;
    private a<ConfigResolver> providesConfigResolverProvider;
    private a<FirebaseApp> providesFirebaseAppProvider;
    private a<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
    private a<Provider<RemoteConfigComponent>> providesRemoteConfigComponentProvider;
    private a<RemoteConfigManager> providesRemoteConfigManagerProvider;
    private a<SessionManager> providesSessionManagerProvider;
    private a<Provider<f>> providesTransportFactoryProvider;

    public static final class Builder {
        private FirebasePerformanceModule firebasePerformanceModule;

        public FirebasePerformanceComponent build() {
            g.a(this.firebasePerformanceModule, FirebasePerformanceModule.class);
            return new DaggerFirebasePerformanceComponent(this.firebasePerformanceModule);
        }

        public Builder firebasePerformanceModule(FirebasePerformanceModule firebasePerformanceModule2) {
            this.firebasePerformanceModule = (FirebasePerformanceModule) g.b(firebasePerformanceModule2);
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(FirebasePerformanceModule firebasePerformanceModule) {
        this.providesFirebaseAppProvider = FirebasePerformanceModule_ProvidesFirebaseAppFactory.create(firebasePerformanceModule);
        this.providesRemoteConfigComponentProvider = FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory.create(firebasePerformanceModule);
        this.providesFirebaseInstallationsProvider = FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory.create(firebasePerformanceModule);
        this.providesTransportFactoryProvider = FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory.create(firebasePerformanceModule);
        this.providesRemoteConfigManagerProvider = FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory.create(firebasePerformanceModule);
        this.providesConfigResolverProvider = FirebasePerformanceModule_ProvidesConfigResolverFactory.create(firebasePerformanceModule);
        FirebasePerformanceModule_ProvidesSessionManagerFactory create = FirebasePerformanceModule_ProvidesSessionManagerFactory.create(firebasePerformanceModule);
        this.providesSessionManagerProvider = create;
        this.firebasePerformanceProvider = c.a(FirebasePerformance_Factory.create(this.providesFirebaseAppProvider, this.providesRemoteConfigComponentProvider, this.providesFirebaseInstallationsProvider, this.providesTransportFactoryProvider, this.providesRemoteConfigManagerProvider, this.providesConfigResolverProvider, create));
    }

    public FirebasePerformance getFirebasePerformance() {
        return this.firebasePerformanceProvider.get();
    }

    private DaggerFirebasePerformanceComponent(FirebasePerformanceModule firebasePerformanceModule) {
        initialize(firebasePerformanceModule);
    }
}
