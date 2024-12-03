package com.coffeemeetsbagel.school.data;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import com.coffeemeetsbagel.store.q0;
import eb.d;
import hb.c;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

@SuppressLint({"CheckResult"})
public final class SchoolRepository {

    /* renamed from: d  reason: collision with root package name */
    public static final a f36355d = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f36356a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Resources f36357b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final eb.a f36358c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SchoolRepository(c cVar, Resources resources, eb.a aVar) {
        j.g(cVar, "sharedPrefsManager");
        j.g(resources, "resources");
        j.g(aVar, "localDb");
        this.f36356a = cVar;
        this.f36357b = resources;
        this.f36358c = aVar;
        w.A(new a(this)).v(new b(new Function1<Integer, b0<? extends List<? extends String>>>(this) {
            final /* synthetic */ SchoolRepository this$0;

            {
                this.this$0 = r1;
            }

            /* access modifiers changed from: private */
            public static final List d(SchoolRepository schoolRepository) {
                j.g(schoolRepository, "this$0");
                return nc.a.f41300a.a(q0.school_list, schoolRepository.f36357b);
            }

            /* renamed from: c */
            public final b0<? extends List<String>> invoke(Integer num) {
                j.g(num, "existingVersion");
                if (num.intValue() == 2) {
                    return w.C(q.j());
                }
                return w.A(new g(this.this$0));
            }
        })).K(dk.a.c()).D(new c(AnonymousClass3.f36359a)).v(new d(new Function1<List<? extends d>, b0<? extends List<? extends Long>>>(this) {
            final /* synthetic */ SchoolRepository this$0;

            {
                this.this$0 = r1;
            }

            /* access modifiers changed from: private */
            public static final List d(SchoolRepository schoolRepository, List list) {
                j.g(schoolRepository, "this$0");
                j.g(list, "$entities");
                return schoolRepository.f36358c.a(list);
            }

            /* renamed from: c */
            public final b0<? extends List<Long>> invoke(List<d> list) {
                j.g(list, "entities");
                return w.A(new h(this.this$0, list));
            }
        })).b(new e(new Function1<List<? extends Long>, Unit>(this) {
            final /* synthetic */ SchoolRepository this$0;

            {
                this.this$0 = r1;
            }

            public final void a(List<Long> list) {
                this.this$0.f36356a.c("KEY_SCHOOLS_VERSION", 2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.f32013a;
            }
        }), new f(AnonymousClass6.f36360a));
    }

    /* access modifiers changed from: private */
    public static final Integer g(SchoolRepository schoolRepository) {
        j.g(schoolRepository, "this$0");
        return Integer.valueOf(schoolRepository.f36356a.l("KEY_SCHOOLS_VERSION"));
    }

    /* access modifiers changed from: private */
    public static final b0 h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void l(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final w<List<d>> p() {
        w<List<d>> L = this.f36358c.getAll().o0(dk.a.c()).L();
        j.f(L, "localDb.getAll()\n       …          .firstOrError()");
        return L;
    }
}
