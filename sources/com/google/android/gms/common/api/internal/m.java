package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

public final class m implements a.f, ServiceConnection {

    /* renamed from: l  reason: collision with root package name */
    private static final String f38674l = m.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final String f38675a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38676b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f38677c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f38678d;

    /* renamed from: e  reason: collision with root package name */
    private final f f38679e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f38680f;

    /* renamed from: g  reason: collision with root package name */
    private final n f38681g;

    /* renamed from: h  reason: collision with root package name */
    private IBinder f38682h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f38683i;

    /* renamed from: j  reason: collision with root package name */
    private String f38684j;

    /* renamed from: k  reason: collision with root package name */
    private String f38685k;

    private final void g() {
        if (Thread.currentThread() != this.f38680f.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        this.f38683i = false;
        this.f38682h = null;
        this.f38679e.f(1);
    }

    public final void connect(@NonNull d.c cVar) {
        g();
        String.valueOf(this.f38682h);
        if (isConnected()) {
            try {
                disconnect("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f38677c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f38675a).setAction(this.f38676b);
            }
            boolean bindService = this.f38678d.bindService(intent, this, g.a());
            this.f38683i = bindService;
            if (!bindService) {
                this.f38682h = null;
                this.f38681g.g(new ConnectionResult(16));
            }
            String.valueOf(this.f38682h);
        } catch (SecurityException e10) {
            this.f38683i = false;
            this.f38682h = null;
            throw e10;
        }
    }

    public final void disconnect() {
        g();
        String.valueOf(this.f38682h);
        try {
            this.f38678d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f38683i = false;
        this.f38682h = null;
    }

    public final void dump(@NonNull String str, FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, String[] strArr) {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void e(IBinder iBinder) {
        this.f38683i = false;
        this.f38682h = iBinder;
        String.valueOf(iBinder);
        this.f38679e.c(new Bundle());
    }

    public final void f(String str) {
        this.f38685k = str;
    }

    @NonNull
    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    @NonNull
    public final String getEndpointPackageName() {
        String str = this.f38675a;
        if (str != null) {
            return str;
        }
        p.k(this.f38677c);
        return this.f38677c.getPackageName();
    }

    public final String getLastDisconnectMessage() {
        return this.f38684j;
    }

    public final int getMinApkVersion() {
        return 0;
    }

    public final void getRemoteService(i iVar, Set<Scope> set) {
    }

    @NonNull
    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    @NonNull
    public final Intent getSignInIntent() {
        return new Intent();
    }

    public final boolean isConnected() {
        g();
        return this.f38682h != null;
    }

    public final boolean isConnecting() {
        g();
        return this.f38683i;
    }

    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.f38680f.post(new b2(this, iBinder));
    }

    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        this.f38680f.post(new a2(this));
    }

    public final void onUserSignOut(@NonNull d.e eVar) {
    }

    public final boolean providesSignIn() {
        return false;
    }

    public final boolean requiresGooglePlayServices() {
        return false;
    }

    public final boolean requiresSignIn() {
        return false;
    }

    public final void disconnect(@NonNull String str) {
        g();
        this.f38684j = str;
        disconnect();
    }
}
