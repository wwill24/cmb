package com.coffeemeetsbagel.qna;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;
import za.b;
import za.c;
import za.e;
import za.f;
import za.g;
import za.i;

public abstract class QuestionDaoV2Impl implements e {
    /* access modifiers changed from: private */
    public static final OptionalInt v(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (OptionalInt) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Integer w(QuestionDaoV2Impl questionDaoV2Impl, String str, int i10) {
        j.g(questionDaoV2Impl, "this$0");
        j.g(str, "$questionGroupApiString");
        Integer F = questionDaoV2Impl.F(str);
        if (F != null) {
            i10 = F.intValue();
        }
        return Integer.valueOf(i10);
    }

    /* access modifiers changed from: private */
    public static final Pair x(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    public abstract List<Long> A(List<f> list);

    public abstract long B(g gVar);

    public abstract List<Long> C(List<b> list);

    public abstract List<Long> D(List<c> list);

    public abstract List<Long> E(List<f> list);

    public abstract Integer F(String str);

    public abstract h<List<String>> G(String str, String str2);

    public abstract h<List<QnaPair>> H(String str, String str2);

    public abstract w<List<Integer>> I(String str);

    public h<Pair<i, List<b>>> a(String str, String str2) {
        j.g(str, "profileId");
        j.g(str2, "questionId");
        h<Pair<i, List<b>>> n10 = h.n(u(str2), t(str, str2), new t(QuestionDaoV2Impl$getQuestionWithAnswers$1.f36215a));
        j.f(n10, "combineLatest(\n         …(questions[0], answers) }");
        return n10;
    }

    public List<Long> b(String str, g gVar, boolean z10) {
        long j10;
        List<Long> list;
        List<Long> list2;
        j.g(str, "profileId");
        j.g(gVar, "questionGroupEntity");
        p(str, gVar.d());
        List e10 = p.e(gVar.d());
        r(e10);
        s(e10);
        if (z10) {
            j10 = B(gVar);
        } else {
            j10 = ((Number) CollectionsKt___CollectionsKt.N(y(p.e(gVar)))).longValue();
        }
        if (z10) {
            list = E(gVar.e());
        } else {
            list = A(gVar.e());
        }
        List<f> e11 = gVar.e();
        ArrayList arrayList = new ArrayList(r.t(e11, 10));
        for (f f10 : e11) {
            arrayList.add(f10.f());
        }
        List u10 = r.u(arrayList);
        if (z10) {
            list2 = D(u10);
        } else {
            list2 = z(u10);
        }
        return CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.h0(p.e(Long.valueOf(j10)), C(gVar.f())), list2), list);
    }

    public abstract int c(String str, String str2);

    public List<Long> e(List<? extends Pair<String, ? extends List<g>>> list) {
        j.g(list, "qnaMap");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Pair d10 : list) {
            arrayList.add((List) d10.d());
        }
        List<g> u10 = r.u(arrayList);
        ArrayList arrayList2 = new ArrayList(r.t(u10, 10));
        for (g d11 : u10) {
            arrayList2.add(d11.d());
        }
        List F = CollectionsKt___CollectionsKt.F(arrayList2);
        ArrayList arrayList3 = new ArrayList(r.t(u10, 10));
        for (g e10 : u10) {
            arrayList3.add(e10.e());
        }
        List u11 = r.u(arrayList3);
        HashSet hashSet = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object next : u11) {
            if (hashSet.add(((f) next).b())) {
                arrayList4.add(next);
            }
        }
        ArrayList arrayList5 = new ArrayList(r.t(u10, 10));
        for (g e11 : u10) {
            List<f> e12 = e11.e();
            ArrayList arrayList6 = new ArrayList(r.t(e12, 10));
            for (f f10 : e12) {
                arrayList6.add(f10.f());
            }
            arrayList5.add(r.u(arrayList6));
        }
        List u12 = r.u(arrayList5);
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList7 = new ArrayList();
        for (Object next2 : u12) {
            if (hashSet2.add(((c) next2).a())) {
                arrayList7.add(next2);
            }
        }
        List<Long> y10 = y(u10);
        List<Long> A = A(arrayList4);
        List<Long> z10 = z(arrayList7);
        ArrayList arrayList8 = new ArrayList(r.t(list, 10));
        for (Pair pair : list) {
            q((String) pair.c(), F);
            Iterable<g> iterable = (Iterable) pair.d();
            ArrayList arrayList9 = new ArrayList(r.t(iterable, 10));
            for (g f11 : iterable) {
                arrayList9.add(f11.f());
            }
            arrayList8.add(r.u(arrayList9));
        }
        return CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.h0(C(r.u(arrayList8)), y10), z10), A);
    }

    public h<List<String>> g(String str, String str2) {
        j.g(str, "profileId");
        j.g(str2, "groupName");
        return G(str2, str);
    }

    public void h(String str, String str2, List<b> list) {
        j.g(str, "questionId");
        j.g(str2, "profileId");
        j.g(list, "answerList");
        c(str2, str);
        C(list);
    }

    public w<Integer> i(String str, int i10) {
        j.g(str, "questionGroupApiString");
        w<Integer> A = w.A(new s(this, str, i10));
        j.f(A, "fromCallable {\n         …ing) ?: default\n        }");
        return A;
    }

    public h<List<QnaPair>> k(String str, String str2) {
        j.g(str, "profileId");
        j.g(str2, "groupName");
        return H(str2, str);
    }

    public w<OptionalInt> l(String str) {
        j.g(str, "questionGroupApiString");
        w<R> D = I(str).D(new u(QuestionDaoV2Impl$getQuestionGroupMaxOptions$1.f36214a));
        j.f(D, "queryForMaxSubOptions(qu…Int.of(list[0])\n        }");
        return D;
    }

    public abstract int p(String str, String str2);

    public abstract int q(String str, List<String> list);

    public abstract int r(List<String> list);

    public abstract int s(List<String> list);

    public abstract h<List<b>> t(String str, String str2);

    public abstract h<List<i>> u(String str);

    public abstract List<Long> y(List<g> list);

    public abstract List<Long> z(List<c> list);
}
