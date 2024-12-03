package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.d;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public abstract class f<T extends IInterface> extends d<T> implements a.f, h0 {
    private static volatile Executor zaa;
    private final e zab;
    private final Set zac;
    private final Account zad;

    protected f(@NonNull Context context, @NonNull Handler handler, int i10, @NonNull e eVar) {
        super(context, handler, g.b(context), c.p(), i10, (d.a) null, (d.b) null);
        this.zab = (e) p.k(eVar);
        this.zad = eVar.a();
        this.zac = zaa(eVar.d());
    }

    private final Set zaa(@NonNull Set set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope contains : validateScopes) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    public final Account getAccount() {
        return this.zad;
    }

    /* access modifiers changed from: protected */
    public final Executor getBindServiceExecutor() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final e getClientSettings() {
        return this.zab;
    }

    @NonNull
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    @NonNull
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.emptySet();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Set<Scope> validateScopes(@NonNull Set<Scope> set) {
        return set;
    }

    protected f(@NonNull Context context, @NonNull Looper looper, int i10, @NonNull e eVar) {
        this(context, looper, g.b(context), c.p(), i10, eVar, (com.google.android.gms.common.api.internal.f) null, (n) null);
    }

    @Deprecated
    protected f(@NonNull Context context, @NonNull Looper looper, int i10, @NonNull e eVar, @NonNull d.b bVar, @NonNull d.c cVar) {
        this(context, looper, i10, eVar, (com.google.android.gms.common.api.internal.f) bVar, (n) cVar);
    }

    protected f(@NonNull Context context, @NonNull Looper looper, int i10, @NonNull e eVar, @NonNull com.google.android.gms.common.api.internal.f fVar, @NonNull n nVar) {
        this(context, looper, g.b(context), c.p(), i10, eVar, (com.google.android.gms.common.api.internal.f) p.k(fVar), (n) p.k(nVar));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected f(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.NonNull android.os.Looper r12, @androidx.annotation.NonNull com.google.android.gms.common.internal.g r13, @androidx.annotation.NonNull com.google.android.gms.common.c r14, int r15, @androidx.annotation.NonNull com.google.android.gms.common.internal.e r16, com.google.android.gms.common.api.internal.f r17, com.google.android.gms.common.api.internal.n r18) {
        /*
            r10 = this;
            r9 = r10
            r0 = r17
            r1 = r18
            r2 = 0
            if (r0 != 0) goto L_0x000a
            r6 = r2
            goto L_0x0010
        L_0x000a:
            com.google.android.gms.common.internal.f0 r3 = new com.google.android.gms.common.internal.f0
            r3.<init>(r0)
            r6 = r3
        L_0x0010:
            if (r1 != 0) goto L_0x0014
            r7 = r2
            goto L_0x001a
        L_0x0014:
            com.google.android.gms.common.internal.g0 r0 = new com.google.android.gms.common.internal.g0
            r0.<init>(r1)
            r7 = r0
        L_0x001a:
            java.lang.String r8 = r16.j()
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            r9.zab = r0
            android.accounts.Account r1 = r16.a()
            r9.zad = r1
            java.util.Set r0 = r16.d()
            java.util.Set r0 = r10.zaa(r0)
            r9.zac = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.f.<init>(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.g, com.google.android.gms.common.c, int, com.google.android.gms.common.internal.e, com.google.android.gms.common.api.internal.f, com.google.android.gms.common.api.internal.n):void");
    }
}
