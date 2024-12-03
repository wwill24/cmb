package com.google.firebase.perf;

import androidx.annotation.Keep;
import cd.f;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

@Keep
public class FirebasePerfRegistrar implements ComponentRegistrar {
    private static final String EARLY_LIBRARY_NAME = "fire-perf-early";
    private static final String LIBRARY_NAME = "fire-perf";

    static {
        FirebaseSessionsDependencies.INSTANCE.addDependency(SessionSubscriber.Name.PERFORMANCE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ FirebasePerfEarly lambda$getComponents$0(Qualified qualified, ComponentContainer componentContainer) {
        return new FirebasePerfEarly((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseSessions) componentContainer.get(FirebaseSessions.class), componentContainer.getProvider(StartupTime.class).get(), (Executor) componentContainer.get(qualified));
    }

    /* access modifiers changed from: private */
    public static FirebasePerformance providesFirebasePerformance(ComponentContainer componentContainer) {
        componentContainer.get(FirebasePerfEarly.class);
        return DaggerFirebasePerformanceComponent.builder().firebasePerformanceModule(new FirebasePerformanceModule((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getProvider(RemoteConfigComponent.class), componentContainer.getProvider(f.class))).build().getFirebasePerformance();
    }

    @Keep
    public List<Component<?>> getComponents() {
        Class<FirebasePerfEarly> cls = FirebasePerfEarly.class;
        Class<FirebaseApp> cls2 = FirebaseApp.class;
        Qualified<Executor> qualified = Qualified.qualified(UiThread.class, Executor.class);
        return Arrays.asList(new Component[]{Component.builder(FirebasePerformance.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) cls2)).add(Dependency.requiredProvider((Class<?>) RemoteConfigComponent.class)).add(Dependency.required((Class<?>) FirebaseInstallationsApi.class)).add(Dependency.requiredProvider((Class<?>) f.class)).add(Dependency.required((Class<?>) cls)).factory(new a()).build(), Component.builder(cls).name(EARLY_LIBRARY_NAME).add(Dependency.required((Class<?>) cls2)).add(Dependency.required((Class<?>) FirebaseSessions.class)).add(Dependency.optionalProvider((Class<?>) StartupTime.class)).add(Dependency.required((Qualified<?>) qualified)).eagerInDefaultApp().factory(new b(qualified)).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME)});
    }
}
