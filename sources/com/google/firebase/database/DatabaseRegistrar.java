package com.google.firebase.database;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
public class DatabaseRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rtdb";

    /* access modifiers changed from: private */
    public static /* synthetic */ FirebaseDatabaseComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseDatabaseComponent((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getDeferred(InternalAuthProvider.class), componentContainer.getDeferred(InteropAppCheckTokenProvider.class));
    }

    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseDatabaseComponent.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.deferred((Class<?>) InternalAuthProvider.class)).add(Dependency.deferred((Class<?>) InteropAppCheckTokenProvider.class)).factory(new a()).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME)});
    }
}
