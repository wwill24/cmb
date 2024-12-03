package com.withpersona.sdk2.inquiry.shared.ui;

import gk.g;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView$loadFromUrl$1", f = "ThemeableLottieAnimationView.kt", l = {65}, m = "invokeSuspend")
final class ThemeableLottieAnimationView$loadFromUrl$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ ThemeableLottieAnimationView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ThemeableLottieAnimationView$loadFromUrl$1(String str, ThemeableLottieAnimationView themeableLottieAnimationView, c<? super ThemeableLottieAnimationView$loadFromUrl$1> cVar) {
        super(2, cVar);
        this.$url = str;
        this.this$0 = themeableLottieAnimationView;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ThemeableLottieAnimationView$loadFromUrl$1(this.$url, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((ThemeableLottieAnimationView$loadFromUrl$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final String str = this.$url;
            final ThemeableLottieAnimationView themeableLottieAnimationView = this.this$0;
            AnonymousClass1 r52 = new Function0<Unit>() {
                public final void invoke() {
                    try {
                        InputStream openStream = new URL(str).openStream();
                        j.f(openStream, "URL(url).openStream()");
                        themeableLottieAnimationView.B(openStream, (String) null);
                    } catch (InterruptedIOException unused) {
                    }
                }
            };
            this.label = 1;
            if (InterruptibleKt.c((CoroutineContext) null, r52, this, 1, (Object) null) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
