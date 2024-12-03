package com.mparticle.internal;

import com.mparticle.j0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/mparticle/internal/KitsLoadedCallback;", "", "", "setKitsLoaded", "Lcom/mparticle/j0;", "callback", "onKitsLoaded", "onKitsLoadedRunnable", "Lcom/mparticle/j0;", "", "loaded", "Z", "<init>", "()V", "android-core_release"}, k = 1, mv = {1, 7, 1})
public final class KitsLoadedCallback {
    private volatile boolean loaded;
    private volatile j0 onKitsLoadedRunnable;

    public final void onKitsLoaded(j0 j0Var) {
        j.g(j0Var, "callback");
        synchronized (this) {
            if (this.loaded) {
                j0Var.a();
            } else {
                this.onKitsLoadedRunnable = j0Var;
            }
            Unit unit = Unit.f32013a;
        }
    }

    public final void setKitsLoaded() {
        synchronized (this) {
            if (!this.loaded) {
                this.loaded = true;
                j0 j0Var = this.onKitsLoadedRunnable;
                if (j0Var != null) {
                    j0Var.a();
                }
            }
            Unit unit = Unit.f32013a;
        }
    }
}
