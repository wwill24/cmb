package com.google.firebase.ktx;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.mparticle.identity.IdentityHttpResponse;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000fH\b\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u001a\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b\u001a\"\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"LIBRARY_NAME", "", "app", "Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/ktx/Firebase;", "getApp", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/FirebaseApp;", "options", "Lcom/google/firebase/FirebaseOptions;", "getOptions", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/FirebaseOptions;", "coroutineDispatcher", "Lcom/google/firebase/components/Component;", "Lkotlinx/coroutines/CoroutineDispatcher;", "T", "", "name", "initialize", "context", "Landroid/content/Context;", "com.google.firebase-firebase-common-ktx"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FirebaseKt {
    public static final String LIBRARY_NAME = "fire-core-ktx";

    public static final FirebaseApp app(Firebase firebase, String str) {
        j.g(firebase, "<this>");
        j.g(str, "name");
        FirebaseApp instance = FirebaseApp.getInstance(str);
        j.f(instance, "getInstance(name)");
        return instance;
    }

    private static final /* synthetic */ <T extends Annotation> Component<CoroutineDispatcher> coroutineDispatcher() {
        j.m(4, "T");
        Component.Builder<CoroutineDispatcher> builder = Component.builder(Qualified.qualified(Annotation.class, CoroutineDispatcher.class));
        j.m(4, "T");
        Component.Builder<CoroutineDispatcher> add = builder.add(Dependency.required((Qualified<?>) Qualified.qualified(Annotation.class, Executor.class)));
        j.l();
        Component<CoroutineDispatcher> build = add.factory(FirebaseKt$coroutineDispatcher$1.INSTANCE).build();
        j.f(build, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return build;
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        j.g(firebase, "<this>");
        FirebaseApp instance = FirebaseApp.getInstance();
        j.f(instance, "getInstance()");
        return instance;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        j.g(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        j.f(options, "Firebase.app.options");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        j.g(firebase, "<this>");
        j.g(context, IdentityHttpResponse.CONTEXT);
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions) {
        j.g(firebase, "<this>");
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(firebaseOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions);
        j.f(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions, String str) {
        j.g(firebase, "<this>");
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(firebaseOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        j.g(str, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions, str);
        j.f(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }
}
