package com.google.firebase.sessions;

import androidx.annotation.Keep;
import cd.f;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a0\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "", "kotlin.jvm.PlatformType", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LIBRARY_NAME = "fire-sessions";
    private static final Qualified<CoroutineDispatcher> backgroundDispatcher;
    private static final Qualified<CoroutineDispatcher> blockingDispatcher;
    private static final Qualified<FirebaseApp> firebaseApp = Qualified.unqualified(FirebaseApp.class);
    private static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi = Qualified.unqualified(FirebaseInstallationsApi.class);
    private static final Qualified<f> transportFactory = Qualified.unqualified(f.class);

    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R8\u0010\b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR8\u0010\n\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\tR8\u0010\f\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000b0\u000b \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00050\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\tR8\u0010\u000e\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\r0\r \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\r0\r\u0018\u00010\u00050\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\tR8\u0010\u0010\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000f0\u000f \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00050\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar$Companion;", "", "", "LIBRARY_NAME", "Ljava/lang/String;", "Lcom/google/firebase/components/Qualified;", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlin.jvm.PlatformType", "backgroundDispatcher", "Lcom/google/firebase/components/Qualified;", "blockingDispatcher", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallationsApi", "Lcd/f;", "transportFactory", "<init>", "()V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Class<CoroutineDispatcher> cls = CoroutineDispatcher.class;
        backgroundDispatcher = Qualified.qualified(Background.class, cls);
        blockingDispatcher = Qualified.qualified(Blocking.class, cls);
    }

    /* access modifiers changed from: private */
    /* renamed from: getComponents$lambda-0  reason: not valid java name */
    public static final FirebaseSessions m4getComponents$lambda0(ComponentContainer componentContainer) {
        Object obj = componentContainer.get(firebaseApp);
        j.f(obj, "container.get(firebaseApp)");
        Object obj2 = componentContainer.get(firebaseInstallationsApi);
        j.f(obj2, "container.get(firebaseInstallationsApi)");
        Object obj3 = componentContainer.get(backgroundDispatcher);
        j.f(obj3, "container.get(backgroundDispatcher)");
        Object obj4 = componentContainer.get(blockingDispatcher);
        j.f(obj4, "container.get(blockingDispatcher)");
        Provider<f> provider = componentContainer.getProvider(transportFactory);
        j.f(provider, "container.getProvider(transportFactory)");
        return new FirebaseSessions((FirebaseApp) obj, (FirebaseInstallationsApi) obj2, (CoroutineDispatcher) obj3, (CoroutineDispatcher) obj4, provider);
    }

    public List<Component<? extends Object>> getComponents() {
        return q.m(Component.builder(FirebaseSessions.class).name(LIBRARY_NAME).add(Dependency.required((Qualified<?>) firebaseApp)).add(Dependency.required((Qualified<?>) firebaseInstallationsApi)).add(Dependency.required((Qualified<?>) backgroundDispatcher)).add(Dependency.required((Qualified<?>) blockingDispatcher)).add(Dependency.requiredProvider((Qualified<?>) transportFactory)).factory(new c()).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
