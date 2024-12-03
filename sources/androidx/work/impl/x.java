package androidx.work.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.ExistingWorkPolicy;
import b2.f;
import b2.h;
import b2.l;
import b2.n;
import h2.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class x extends l {

    /* renamed from: j  reason: collision with root package name */
    private static final String f7645j = f.i("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    private final e0 f7646a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7647b;

    /* renamed from: c  reason: collision with root package name */
    private final ExistingWorkPolicy f7648c;

    /* renamed from: d  reason: collision with root package name */
    private final List<? extends n> f7649d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f7650e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f7651f;

    /* renamed from: g  reason: collision with root package name */
    private final List<x> f7652g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7653h;

    /* renamed from: i  reason: collision with root package name */
    private h f7654i;

    public x(@NonNull e0 e0Var, @NonNull List<? extends n> list) {
        this(e0Var, (String) null, ExistingWorkPolicy.KEEP, list, (List<x>) null);
    }

    private static boolean i(@NonNull x xVar, @NonNull Set<String> set) {
        set.addAll(xVar.c());
        Set<String> l10 = l(xVar);
        for (String contains : set) {
            if (l10.contains(contains)) {
                return true;
            }
        }
        List<x> e10 = xVar.e();
        if (e10 != null && !e10.isEmpty()) {
            for (x i10 : e10) {
                if (i(i10, set)) {
                    return true;
                }
            }
        }
        set.removeAll(xVar.c());
        return false;
    }

    @NonNull
    public static Set<String> l(@NonNull x xVar) {
        HashSet hashSet = new HashSet();
        List<x> e10 = xVar.e();
        if (e10 != null && !e10.isEmpty()) {
            for (x c10 : e10) {
                hashSet.addAll(c10.c());
            }
        }
        return hashSet;
    }

    @NonNull
    public h a() {
        if (!this.f7653h) {
            d dVar = new d(this);
            this.f7646a.p().c(dVar);
            this.f7654i = dVar.d();
        } else {
            f e10 = f.e();
            String str = f7645j;
            e10.k(str, "Already enqueued work ids (" + TextUtils.join(", ", this.f7650e) + ")");
        }
        return this.f7654i;
    }

    @NonNull
    public ExistingWorkPolicy b() {
        return this.f7648c;
    }

    @NonNull
    public List<String> c() {
        return this.f7650e;
    }

    public String d() {
        return this.f7647b;
    }

    public List<x> e() {
        return this.f7652g;
    }

    @NonNull
    public List<? extends n> f() {
        return this.f7649d;
    }

    @NonNull
    public e0 g() {
        return this.f7646a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f7653h;
    }

    public void k() {
        this.f7653h = true;
    }

    public x(@NonNull e0 e0Var, String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<? extends n> list, List<x> list2) {
        this.f7646a = e0Var;
        this.f7647b = str;
        this.f7648c = existingWorkPolicy;
        this.f7649d = list;
        this.f7652g = list2;
        this.f7650e = new ArrayList(list.size());
        this.f7651f = new ArrayList();
        if (list2 != null) {
            for (x xVar : list2) {
                this.f7651f.addAll(xVar.f7651f);
            }
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            String b10 = ((n) list.get(i10)).b();
            this.f7650e.add(b10);
            this.f7651f.add(b10);
        }
    }
}
