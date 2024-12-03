package com.google.mlkit.common.sdkinternal;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f21399a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f21400b;

    public /* synthetic */ e0(n nVar, Runnable runnable) {
        this.f21399a = nVar;
        this.f21400b = runnable;
    }

    public final void run() {
        n nVar = this.f21399a;
        Runnable runnable = this.f21400b;
        i0 i0Var = new i0(nVar, (h0) null);
        try {
            runnable.run();
            i0Var.close();
            return;
        } catch (Throwable th2) {
            try {
                Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(th, new Object[]{th2});
            } catch (Exception unused) {
            }
        }
        throw th;
    }
}
