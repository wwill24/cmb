package com.google.android.gms.common.moduleinstall.internal;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.internal.base.zav;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import ie.d;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import je.h;
import je.j;

public final class i extends c implements ie.c {

    /* renamed from: a  reason: collision with root package name */
    private static final a.g f39125a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.C0480a f39126b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f39127c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f39128d = 0;

    static {
        a.g gVar = new a.g();
        f39125a = gVar;
        f fVar = new f();
        f39126b = fVar;
        f39127c = new a("ModuleInstall.API", fVar, gVar);
    }

    public i(Context context) {
        super(context, f39127c, a.d.f38515i, c.a.f38516c);
    }

    static final ApiFeatureRequest d(boolean z10, e... eVarArr) {
        boolean z11;
        p.l(eVarArr, "Requested APIs must not be null.");
        if (r0 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        p.b(z11, "Please provide at least one OptionalModuleApi.");
        for (e l10 : eVarArr) {
            p.l(l10, "Requested API must not be null.");
        }
        return ApiFeatureRequest.c0(Arrays.asList(eVarArr), z10);
    }

    public final Task<ModuleInstallResponse> b(d dVar) {
        k kVar;
        Class<ie.a> cls = ie.a.class;
        ApiFeatureRequest S = ApiFeatureRequest.S(dVar);
        ie.a b10 = dVar.b();
        Executor c10 = dVar.c();
        boolean e10 = dVar.e();
        if (S.Y().isEmpty()) {
            return Tasks.forResult(new ModuleInstallResponse(0));
        }
        if (b10 == null) {
            v.a a10 = v.a();
            a10.d(zav.zaa);
            a10.c(e10);
            a10.e(27304);
            a10.b(new je.i(this, S));
            return doRead(a10.a());
        }
        p.k(b10);
        if (c10 == null) {
            kVar = registerListener(b10, cls.getSimpleName());
        } else {
            kVar = l.b(b10, c10, cls.getSimpleName());
        }
        b bVar = new b(kVar);
        AtomicReference atomicReference = new AtomicReference();
        d dVar2 = new d(this, atomicReference, b10, S, bVar);
        e eVar = new e(this, bVar);
        p.a a11 = com.google.android.gms.common.api.internal.p.a();
        a11.g(kVar);
        a11.d(zav.zaa);
        a11.c(e10);
        a11.b(dVar2);
        a11.f(eVar);
        a11.e(27305);
        return doRegisterEventListener(a11.a()).onSuccessTask(new h(atomicReference));
    }

    public final Task<ModuleAvailabilityResponse> c(e... eVarArr) {
        ApiFeatureRequest d10 = d(false, eVarArr);
        if (d10.Y().isEmpty()) {
            return Tasks.forResult(new ModuleAvailabilityResponse(true, 0));
        }
        v.a a10 = v.a();
        a10.d(zav.zaa);
        a10.e(27301);
        a10.c(false);
        a10.b(new j(this, d10));
        return doRead(a10.a());
    }
}
