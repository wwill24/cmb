package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.u2;
import com.google.android.gms.common.internal.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import ye.e;

@Deprecated
public abstract class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Set f38521a = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f38522a;

        /* renamed from: b  reason: collision with root package name */
        private final Set f38523b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set f38524c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private int f38525d;

        /* renamed from: e  reason: collision with root package name */
        private View f38526e;

        /* renamed from: f  reason: collision with root package name */
        private String f38527f;

        /* renamed from: g  reason: collision with root package name */
        private String f38528g;

        /* renamed from: h  reason: collision with root package name */
        private final Map f38529h = new androidx.collection.a();

        /* renamed from: i  reason: collision with root package name */
        private final Context f38530i;

        /* renamed from: j  reason: collision with root package name */
        private final Map f38531j = new androidx.collection.a();

        /* renamed from: k  reason: collision with root package name */
        private i f38532k;

        /* renamed from: l  reason: collision with root package name */
        private int f38533l = -1;

        /* renamed from: m  reason: collision with root package name */
        private c f38534m;

        /* renamed from: n  reason: collision with root package name */
        private Looper f38535n;

        /* renamed from: o  reason: collision with root package name */
        private com.google.android.gms.common.c f38536o = com.google.android.gms.common.c.p();

        /* renamed from: p  reason: collision with root package name */
        private a.C0480a f38537p = e.f42178c;

        /* renamed from: q  reason: collision with root package name */
        private final ArrayList f38538q = new ArrayList();

        /* renamed from: r  reason: collision with root package name */
        private final ArrayList f38539r = new ArrayList();

        public a(@NonNull Context context) {
            this.f38530i = context;
            this.f38535n = context.getMainLooper();
            this.f38527f = context.getPackageName();
            this.f38528g = context.getClass().getName();
        }

        @NonNull
        public a a(@NonNull a<Object> aVar) {
            p.l(aVar, "Api must not be null");
            this.f38531j.put(aVar, (Object) null);
            List<Scope> impliedScopes = ((a.e) p.l(aVar.c(), "Base client builder must not be null")).getImpliedScopes(null);
            this.f38524c.addAll(impliedScopes);
            this.f38523b.addAll(impliedScopes);
            return this;
        }

        @NonNull
        public a b(@NonNull b bVar) {
            p.l(bVar, "Listener must not be null");
            this.f38538q.add(bVar);
            return this;
        }

        @NonNull
        public a c(@NonNull c cVar) {
            p.l(cVar, "Listener must not be null");
            this.f38539r.add(cVar);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: com.google.android.gms.common.api.a} */
        /* JADX WARNING: Multi-variable type inference failed */
        @androidx.annotation.NonNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.common.api.d d() {
            /*
                r22 = this;
                r1 = r22
                java.util.Map r0 = r1.f38531j
                boolean r0 = r0.isEmpty()
                r2 = 1
                r0 = r0 ^ r2
                java.lang.String r3 = "must call addApi() to add at least one API"
                com.google.android.gms.common.internal.p.b(r0, r3)
                com.google.android.gms.common.internal.e r0 = r22.e()
                java.util.Map r3 = r0.k()
                androidx.collection.a r11 = new androidx.collection.a
                r11.<init>()
                androidx.collection.a r14 = new androidx.collection.a
                r14.<init>()
                java.util.ArrayList r15 = new java.util.ArrayList
                r15.<init>()
                java.util.Map r4 = r1.f38531j
                java.util.Set r4 = r4.keySet()
                java.util.Iterator r12 = r4.iterator()
                r13 = 0
                r4 = 0
                r16 = r4
                r17 = r13
            L_0x0036:
                boolean r4 = r12.hasNext()
                if (r4 == 0) goto L_0x00c1
                java.lang.Object r4 = r12.next()
                r10 = r4
                com.google.android.gms.common.api.a r10 = (com.google.android.gms.common.api.a) r10
                java.util.Map r4 = r1.f38531j
                java.lang.Object r18 = r4.get(r10)
                java.lang.Object r4 = r3.get(r10)
                if (r4 == 0) goto L_0x0051
                r4 = r2
                goto L_0x0052
            L_0x0051:
                r4 = r13
            L_0x0052:
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
                r11.put(r10, r5)
                com.google.android.gms.common.api.internal.m3 r9 = new com.google.android.gms.common.api.internal.m3
                r9.<init>(r10, r4)
                r15.add(r9)
                com.google.android.gms.common.api.a$a r4 = r10.a()
                java.lang.Object r4 = com.google.android.gms.common.internal.p.k(r4)
                r19 = r4
                com.google.android.gms.common.api.a$a r19 = (com.google.android.gms.common.api.a.C0480a) r19
                android.content.Context r5 = r1.f38530i
                android.os.Looper r6 = r1.f38535n
                r4 = r19
                r7 = r0
                r8 = r18
                r20 = r9
                r21 = r10
                r10 = r20
                com.google.android.gms.common.api.a$f r4 = r4.buildClient((android.content.Context) r5, (android.os.Looper) r6, (com.google.android.gms.common.internal.e) r7, r8, (com.google.android.gms.common.api.d.b) r9, (com.google.android.gms.common.api.d.c) r10)
                com.google.android.gms.common.api.a$c r5 = r21.b()
                r14.put(r5, r4)
                int r5 = r19.getPriority()
                if (r5 != r2) goto L_0x0094
                if (r18 == 0) goto L_0x0092
                r17 = r2
                goto L_0x0094
            L_0x0092:
                r17 = r13
            L_0x0094:
                boolean r4 = r4.providesSignIn()
                if (r4 == 0) goto L_0x0036
                if (r16 != 0) goto L_0x009f
                r16 = r21
                goto L_0x0036
            L_0x009f:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = r21.d()
                java.lang.String r3 = r16.d()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r2)
                java.lang.String r2 = " cannot be used with "
                r4.append(r2)
                r4.append(r3)
                java.lang.String r2 = r4.toString()
                r0.<init>(r2)
                throw r0
            L_0x00c1:
                if (r16 == 0) goto L_0x010f
                if (r17 != 0) goto L_0x00ef
                android.accounts.Account r3 = r1.f38522a
                if (r3 != 0) goto L_0x00cb
                r3 = r2
                goto L_0x00cc
            L_0x00cb:
                r3 = r13
            L_0x00cc:
                java.lang.Object[] r4 = new java.lang.Object[r2]
                java.lang.String r5 = r16.d()
                r4[r13] = r5
                java.lang.String r5 = "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead"
                com.google.android.gms.common.internal.p.q(r3, r5, r4)
                java.util.Set r3 = r1.f38523b
                java.util.Set r4 = r1.f38524c
                boolean r3 = r3.equals(r4)
                java.lang.Object[] r4 = new java.lang.Object[r2]
                java.lang.String r5 = r16.d()
                r4[r13] = r5
                java.lang.String r5 = "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead."
                com.google.android.gms.common.internal.p.q(r3, r5, r4)
                goto L_0x010f
            L_0x00ef:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = r16.d()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "With using "
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = ", GamesOptions can only be specified within GoogleSignInOptions.Builder"
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r0.<init>(r2)
                throw r0
            L_0x010f:
                java.util.Collection r3 = r14.values()
                int r16 = com.google.android.gms.common.api.internal.z0.v(r3, r2)
                com.google.android.gms.common.api.internal.z0 r2 = new com.google.android.gms.common.api.internal.z0
                android.content.Context r5 = r1.f38530i
                java.util.concurrent.locks.ReentrantLock r6 = new java.util.concurrent.locks.ReentrantLock
                r6.<init>()
                android.os.Looper r7 = r1.f38535n
                com.google.android.gms.common.c r9 = r1.f38536o
                com.google.android.gms.common.api.a$a r10 = r1.f38537p
                java.util.ArrayList r12 = r1.f38538q
                java.util.ArrayList r13 = r1.f38539r
                int r3 = r1.f38533l
                r4 = r2
                r8 = r0
                r0 = r15
                r15 = r3
                r17 = r0
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                java.util.Set r3 = com.google.android.gms.common.api.d.f38521a
                monitor-enter(r3)
                java.util.Set r0 = com.google.android.gms.common.api.d.f38521a     // Catch:{ all -> 0x0154 }
                r0.add(r2)     // Catch:{ all -> 0x0154 }
                monitor-exit(r3)     // Catch:{ all -> 0x0154 }
                int r0 = r1.f38533l
                if (r0 < 0) goto L_0x0153
                com.google.android.gms.common.api.internal.i r0 = r1.f38532k
                com.google.android.gms.common.api.internal.d3 r0 = com.google.android.gms.common.api.internal.d3.i(r0)
                int r3 = r1.f38533l
                com.google.android.gms.common.api.d$c r4 = r1.f38534m
                r0.j(r3, r2, r4)
            L_0x0153:
                return r2
            L_0x0154:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0154 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.d.a.d():com.google.android.gms.common.api.d");
        }

        @NonNull
        public final com.google.android.gms.common.internal.e e() {
            ye.a aVar = ye.a.f42166k;
            Map map = this.f38531j;
            a aVar2 = e.f42182g;
            if (map.containsKey(aVar2)) {
                aVar = (ye.a) this.f38531j.get(aVar2);
            }
            return new com.google.android.gms.common.internal.e(this.f38522a, this.f38523b, this.f38529h, this.f38525d, this.f38526e, this.f38527f, this.f38528g, aVar, false);
        }
    }

    @Deprecated
    public interface b extends f {
    }

    @Deprecated
    public interface c extends n {
    }

    @NonNull
    public static Set<d> i() {
        Set<d> set = f38521a;
        synchronized (set) {
        }
        return set;
    }

    public abstract void d();

    public abstract void e();

    public abstract void f(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr);

    @NonNull
    public <A extends a.b, R extends j, T extends com.google.android.gms.common.api.internal.d<R, A>> T g(@NonNull T t10) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T h(@NonNull T t10) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public <C extends a.f> C j(@NonNull a.c<C> cVar) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public Context k() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public Looper l() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean m();

    public abstract boolean n();

    public boolean o(@NonNull r rVar) {
        throw new UnsupportedOperationException();
    }

    public void p() {
        throw new UnsupportedOperationException();
    }

    public abstract void q(@NonNull c cVar);

    public abstract void r(@NonNull c cVar);

    public void s(u2 u2Var) {
        throw new UnsupportedOperationException();
    }

    public void t(u2 u2Var) {
        throw new UnsupportedOperationException();
    }
}
