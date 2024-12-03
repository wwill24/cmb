package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.camera.view.h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.c;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.atomic.AtomicReference;

public abstract class i3 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    protected volatile boolean f38639a;

    /* renamed from: b  reason: collision with root package name */
    protected final AtomicReference f38640b = new AtomicReference((Object) null);

    /* renamed from: c  reason: collision with root package name */
    private final Handler f38641c = new zau(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    protected final c f38642d;

    i3(j jVar, c cVar) {
        super(jVar);
        this.f38642d = cVar;
    }

    /* access modifiers changed from: private */
    public final void a(ConnectionResult connectionResult, int i10) {
        this.f38640b.set((Object) null);
        b(connectionResult, i10);
    }

    /* access modifiers changed from: private */
    public final void d() {
        this.f38640b.set((Object) null);
        c();
    }

    private static final int e(f3 f3Var) {
        if (f3Var == null) {
            return -1;
        }
        return f3Var.a();
    }

    /* access modifiers changed from: protected */
    public abstract void b(ConnectionResult connectionResult, int i10);

    /* access modifiers changed from: protected */
    public abstract void c();

    public final void h(ConnectionResult connectionResult, int i10) {
        f3 f3Var = new f3(connectionResult, i10);
        AtomicReference atomicReference = this.f38640b;
        while (!h.a(atomicReference, (Object) null, f3Var)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.f38641c.post(new h3(this, f3Var));
    }

    public final void onActivityResult(int i10, int i11, Intent intent) {
        f3 f3Var = (f3) this.f38640b.get();
        if (i10 != 1) {
            if (i10 == 2) {
                int i12 = this.f38642d.i(getActivity());
                if (i12 == 0) {
                    d();
                    return;
                } else if (f3Var != null) {
                    if (f3Var.b().S() == 18 && i12 == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i11 == -1) {
            d();
            return;
        } else if (i11 == 0) {
            if (f3Var != null) {
                int i13 = 13;
                if (intent != null) {
                    i13 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                a(new ConnectionResult(i13, (PendingIntent) null, f3Var.b().toString()), e(f3Var));
                return;
            }
            return;
        }
        if (f3Var != null) {
            a(f3Var.b(), f3Var.a());
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, (PendingIntent) null), e((f3) this.f38640b.get()));
    }

    public final void onCreate(Bundle bundle) {
        f3 f3Var;
        super.onCreate(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.f38640b;
            if (bundle.getBoolean("resolving_error", false)) {
                f3Var = new f3(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                f3Var = null;
            }
            atomicReference.set(f3Var);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        f3 f3Var = (f3) this.f38640b.get();
        if (f3Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", f3Var.a());
            bundle.putInt("failed_status", f3Var.b().S());
            bundle.putParcelable("failed_resolution", f3Var.b().c0());
        }
    }

    public void onStart() {
        super.onStart();
        this.f38639a = true;
    }

    public void onStop() {
        super.onStop();
        this.f38639a = false;
    }
}
