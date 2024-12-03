package androidx.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f345a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f346b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f347c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private int f348d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f349e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f350f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Function0<Unit>> f351g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f352h = new i(this);

    public j(Executor executor, Function0<Unit> function0) {
        kotlin.jvm.internal.j.g(executor, "executor");
        kotlin.jvm.internal.j.g(function0, "reportFullyDrawn");
        this.f345a = executor;
        this.f346b = function0;
    }

    /* access modifiers changed from: private */
    public static final void d(j jVar) {
        kotlin.jvm.internal.j.g(jVar, "this$0");
        synchronized (jVar.f347c) {
            jVar.f349e = false;
            if (jVar.f348d == 0 && !jVar.f350f) {
                jVar.f346b.invoke();
                jVar.b();
            }
            Unit unit = Unit.f32013a;
        }
    }

    public final void b() {
        synchronized (this.f347c) {
            this.f350f = true;
            for (Function0 invoke : this.f351g) {
                invoke.invoke();
            }
            this.f351g.clear();
            Unit unit = Unit.f32013a;
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.f347c) {
            z10 = this.f350f;
        }
        return z10;
    }
}
