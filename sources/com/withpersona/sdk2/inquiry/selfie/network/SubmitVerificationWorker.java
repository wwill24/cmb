package com.withpersona.sdk2.inquiry.selfie.network;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import com.withpersona.sdk2.inquiry.selfie.v;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class SubmitVerificationWorker implements j<b> {

    /* renamed from: b  reason: collision with root package name */
    private final String f27413b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f27414c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final v f27415d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final List<Selfie> f27416e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final a f27417f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f27418g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f27419h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final String f27420i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ui.a f27421j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final ji.a f27422k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final wi.a f27423l;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a f27424a;

        /* renamed from: b  reason: collision with root package name */
        private final ui.a f27425b;

        /* renamed from: c  reason: collision with root package name */
        private final ji.a f27426c;

        /* renamed from: d  reason: collision with root package name */
        private final wi.a f27427d;

        public a(a aVar, ui.a aVar2, ji.a aVar3, wi.a aVar4) {
            kotlin.jvm.internal.j.g(aVar, "service");
            kotlin.jvm.internal.j.g(aVar2, "dataCollector");
            kotlin.jvm.internal.j.g(aVar3, "fallbackModeManager");
            kotlin.jvm.internal.j.g(aVar4, "imageHelper");
            this.f27424a = aVar;
            this.f27425b = aVar2;
            this.f27426c = aVar3;
            this.f27427d = aVar4;
        }

        public final SubmitVerificationWorker a(String str, String str2, String str3, String str4, v vVar, String str5, List<? extends Selfie> list) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            String str6 = str2;
            kotlin.jvm.internal.j.g(str6, "inquiryId");
            String str7 = str3;
            kotlin.jvm.internal.j.g(str7, "fromComponent");
            String str8 = str4;
            kotlin.jvm.internal.j.g(str8, "fromStep");
            v vVar2 = vVar;
            kotlin.jvm.internal.j.g(vVar2, "selfieType");
            String str9 = str5;
            kotlin.jvm.internal.j.g(str9, "fieldKeySelfie");
            List<? extends Selfie> list2 = list;
            kotlin.jvm.internal.j.g(list2, "selfies");
            return new SubmitVerificationWorker(str, str6, vVar2, list2, this.f27424a, str8, str7, str9, this.f27425b, this.f27426c, this.f27427d);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f27428a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f27428a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f27428a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.j.b(this.f27428a, ((a) obj).f27428a);
            }

            public int hashCode() {
                return this.f27428a.hashCode();
            }

            public String toString() {
                return "Error(cause=" + this.f27428a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$b$b  reason: collision with other inner class name */
        public static final class C0330b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0330b f27429a = new C0330b();

            private C0330b() {
                super((DefaultConstructorMarker) null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SubmitVerificationWorker(String str, String str2, v vVar, List<? extends Selfie> list, a aVar, String str3, String str4, String str5, ui.a aVar2, ji.a aVar3, wi.a aVar4) {
        kotlin.jvm.internal.j.g(str, "sessionToken");
        kotlin.jvm.internal.j.g(str2, "inquiryId");
        kotlin.jvm.internal.j.g(vVar, "selfieType");
        kotlin.jvm.internal.j.g(list, "selfies");
        kotlin.jvm.internal.j.g(aVar, "service");
        kotlin.jvm.internal.j.g(str3, "fromStep");
        kotlin.jvm.internal.j.g(str4, "fromComponent");
        kotlin.jvm.internal.j.g(str5, "fieldKeySelfie");
        kotlin.jvm.internal.j.g(aVar2, "dataCollector");
        kotlin.jvm.internal.j.g(aVar3, "fallbackModeManager");
        kotlin.jvm.internal.j.g(aVar4, "imageHelper");
        this.f27413b = str;
        this.f27414c = str2;
        this.f27415d = vVar;
        this.f27416e = list;
        this.f27417f = aVar;
        this.f27418g = str3;
        this.f27419h = str4;
        this.f27420i = str5;
        this.f27421j = aVar2;
        this.f27422k = aVar3;
        this.f27423l = aVar4;
    }

    /* access modifiers changed from: private */
    public final void n(ui.a aVar, List<? extends Selfie> list) {
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (next instanceof Selfie.SelfieImage) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(arrayList, 10)), 16));
        for (Object next2 : arrayList) {
            linkedHashMap.put(((Selfie.SelfieImage) next2).d(), next2);
        }
        aVar.b(new SelfieStepData(this.f27418g, (Selfie) linkedHashMap.get(Selfie.Direction.CENTER), (Selfie) linkedHashMap.get(Selfie.Direction.LEFT), (Selfie) linkedHashMap.get(Selfie.Direction.RIGHT)));
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof SubmitVerificationWorker) || !kotlin.jvm.internal.j.b(this.f27413b, ((SubmitVerificationWorker) jVar).f27413b)) {
            return false;
        }
        return true;
    }

    public final String m() {
        return this.f27413b;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new SubmitVerificationWorker$run$1(this, (c<? super SubmitVerificationWorker$run$1>) null));
    }
}
