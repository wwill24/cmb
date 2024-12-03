package com.facebook.internal;

import android.util.Pair;
import com.facebook.CallbackManager;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class a implements androidx.activity.result.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CallbackManager f37842a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f37843b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f37844c;

    public /* synthetic */ a(CallbackManager callbackManager, int i10, Ref$ObjectRef ref$ObjectRef) {
        this.f37842a = callbackManager;
        this.f37843b = i10;
        this.f37844c = ref$ObjectRef;
    }

    public final void a(Object obj) {
        DialogPresenter.m111startActivityForResultWithAndroidX$lambda2(this.f37842a, this.f37843b, this.f37844c, (Pair) obj);
    }
}
