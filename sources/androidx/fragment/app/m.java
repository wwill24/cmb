package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.app.b;
import androidx.core.content.a;
import androidx.core.util.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class m<E> extends j {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f5861a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Context f5862b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Handler f5863c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5864d;

    /* renamed from: e  reason: collision with root package name */
    final FragmentManager f5865e;

    m(@NonNull h hVar) {
        this(hVar, hVar, new Handler(), 0);
    }

    public View c(int i10) {
        return null;
    }

    public boolean d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Activity e() {
        return this.f5861a;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Context f() {
        return this.f5862b;
    }

    @NonNull
    public Handler g() {
        return this.f5863c;
    }

    public void h(@NonNull String str, FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, String[] strArr) {
    }

    public abstract E i();

    @NonNull
    public LayoutInflater j() {
        return LayoutInflater.from(this.f5862b);
    }

    @Deprecated
    public void k(@NonNull Fragment fragment, @NonNull String[] strArr, int i10) {
    }

    public boolean l(@NonNull String str) {
        return false;
    }

    public void m(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            a.startActivity(this.f5862b, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void n(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 == -1) {
            b.l(this.f5861a, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public void o() {
    }

    m(Activity activity, @NonNull Context context, @NonNull Handler handler, int i10) {
        this.f5865e = new u();
        this.f5861a = activity;
        this.f5862b = (Context) h.h(context, "context == null");
        this.f5863c = (Handler) h.h(handler, "handler == null");
        this.f5864d = i10;
    }
}
