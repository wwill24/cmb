package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class s<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f38464a;

    /* renamed from: b  reason: collision with root package name */
    final TaskCompletionSource<T> f38465b = new TaskCompletionSource<>();

    /* renamed from: c  reason: collision with root package name */
    final int f38466c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f38467d;

    s(int i10, int i11, Bundle bundle) {
        this.f38464a = i10;
        this.f38466c = i11;
        this.f38467d = bundle;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public final void c(zzq zzq) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzq);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb2.append("Failing ");
            sb2.append(valueOf);
            sb2.append(" with ");
            sb2.append(valueOf2);
        }
        this.f38465b.setException(zzq);
    }

    /* access modifiers changed from: package-private */
    public final void d(T t10) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 16 + valueOf2.length());
            sb2.append("Finishing ");
            sb2.append(valueOf);
            sb2.append(" with ");
            sb2.append(valueOf2);
        }
        this.f38465b.setResult(t10);
    }

    public final String toString() {
        int i10 = this.f38466c;
        int i11 = this.f38464a;
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Request { what=");
        sb2.append(i10);
        sb2.append(" id=");
        sb2.append(i11);
        sb2.append(" oneWay=");
        sb2.append(b());
        sb2.append("}");
        return sb2.toString();
    }
}
