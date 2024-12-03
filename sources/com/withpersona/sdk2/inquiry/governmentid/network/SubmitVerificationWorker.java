package com.withpersona.sdk2.inquiry.governmentid.network;

import android.util.Base64;
import com.facebook.internal.AnalyticsEvents;
import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.governmentid.Frame;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.RawExtraction;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import org.apache.commons.beanutils.PropertyUtils;

public final class SubmitVerificationWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f25878b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f25879c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f25880d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f25881e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b f25882f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final GovernmentIdRequestArguments f25883g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final PassportNfcRequestArguments f25884h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ui.a f25885i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ji.a f25886j;

    /* renamed from: k  reason: collision with root package name */
    private final wi.a f25887k;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f25888a;

        /* renamed from: b  reason: collision with root package name */
        private final ui.a f25889b;

        /* renamed from: c  reason: collision with root package name */
        private final ji.a f25890c;

        /* renamed from: d  reason: collision with root package name */
        private final wi.a f25891d;

        public a(b bVar, ui.a aVar, ji.a aVar2, wi.a aVar3) {
            kotlin.jvm.internal.j.g(bVar, "service");
            kotlin.jvm.internal.j.g(aVar, "dataCollector");
            kotlin.jvm.internal.j.g(aVar2, "fallbackModeManager");
            kotlin.jvm.internal.j.g(aVar3, "imageHelper");
            this.f25888a = bVar;
            this.f25889b = aVar;
            this.f25890c = aVar2;
            this.f25891d = aVar3;
        }

        public final SubmitVerificationWorker a(String str, String str2, String str3, String str4, GovernmentIdRequestArguments governmentIdRequestArguments, PassportNfcRequestArguments passportNfcRequestArguments) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "inquiryId");
            String str5 = str3;
            kotlin.jvm.internal.j.g(str5, "fromComponent");
            String str6 = str4;
            kotlin.jvm.internal.j.g(str6, "fromStep");
            return new SubmitVerificationWorker(str, str2, str6, str5, this.f25888a, governmentIdRequestArguments, passportNfcRequestArguments, this.f25889b, this.f25890c, this.f25891d);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo.NetworkErrorInfo f25892a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo.NetworkErrorInfo networkErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(networkErrorInfo, "cause");
                this.f25892a = networkErrorInfo;
            }

            public final InternalErrorInfo.NetworkErrorInfo a() {
                return this.f25892a;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$b$b  reason: collision with other inner class name */
        public static final class C0311b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final GenericFileUploadErrorResponse.DocumentErrorResponse f25893a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0311b(GenericFileUploadErrorResponse.DocumentErrorResponse documentErrorResponse) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(documentErrorResponse, "cause");
                this.f25893a = documentErrorResponse;
            }

            public final GenericFileUploadErrorResponse.DocumentErrorResponse a() {
                return this.f25893a;
            }
        }

        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final c f25894a = new c();

            private c() {
                super((DefaultConstructorMarker) null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25895a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$Side[] r0 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.Side.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$Side r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.Side.FRONT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$Side r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.Side.BACK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$Side r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.Side.FRONT_AND_BACK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f25895a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker.c.<clinit>():void");
        }
    }

    public SubmitVerificationWorker(String str, String str2, String str3, String str4, b bVar, GovernmentIdRequestArguments governmentIdRequestArguments, PassportNfcRequestArguments passportNfcRequestArguments, ui.a aVar, ji.a aVar2, wi.a aVar3) {
        kotlin.jvm.internal.j.g(str, "sessionToken");
        kotlin.jvm.internal.j.g(str2, "inquiryId");
        kotlin.jvm.internal.j.g(str3, "fromStep");
        kotlin.jvm.internal.j.g(str4, "fromComponent");
        kotlin.jvm.internal.j.g(bVar, "service");
        kotlin.jvm.internal.j.g(aVar, "dataCollector");
        kotlin.jvm.internal.j.g(aVar2, "fallbackModeManager");
        kotlin.jvm.internal.j.g(aVar3, "imageHelper");
        this.f25878b = str;
        this.f25879c = str2;
        this.f25880d = str3;
        this.f25881e = str4;
        this.f25882f = bVar;
        this.f25883g = governmentIdRequestArguments;
        this.f25884h = passportNfcRequestArguments;
        this.f25885i = aVar;
        this.f25886j = aVar2;
        this.f25887k = aVar3;
    }

    /* access modifiers changed from: private */
    public final void m(GovernmentIdRequestArguments governmentIdRequestArguments, List<w.c> list) {
        String str;
        this.f25885i.b(new GovernmentIdStepData(this.f25880d, governmentIdRequestArguments.d()));
        for (GovernmentId governmentId : governmentIdRequestArguments.d()) {
            for (Frame frame : governmentId.U1()) {
                if (r.J(frame.c(), "image/", false, 2, (Object) null)) {
                    this.f25887k.a(new File(frame.a()));
                }
            }
            int i10 = c.f25895a[governmentId.I0().ordinal()];
            if (i10 == 1) {
                str = "front";
            } else if (i10 == 2) {
                str = "back";
            } else if (i10 == 3) {
                str = "front_and_back";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            w.c.a aVar = w.c.f33214c;
            list.addAll(q.m(aVar.b("data[attributes][fields][" + governmentIdRequestArguments.c() + PropertyUtils.INDEXED_DELIM2, governmentId.g1()), aVar.b("data[attributes][fields][" + governmentIdRequestArguments.a() + "][files][][page]", str), aVar.b("data[attributes][fields][" + governmentIdRequestArguments.a() + "][files][][capture_method]", governmentId.M1().toString())));
            list.addAll(o(governmentIdRequestArguments, governmentId.U1()));
            if (governmentId instanceof GovernmentId.GovernmentIdImage) {
                RawExtraction e10 = ((GovernmentId.GovernmentIdImage) governmentId).e();
                if (e10 != null) {
                    list.add(aVar.b("data[attributes][client-extraction-raws][][type]", e10.a()));
                    list.add(aVar.b("data[attributes][client-extraction-raws][][value]", e10.c()));
                }
                list.add(aVar.b("data[attributes][fields][" + governmentIdRequestArguments.a() + "][files][][type]", "image"));
            } else if (governmentId instanceof GovernmentId.GovernmentIdVideo) {
                list.add(aVar.b("data[attributes][fields][" + governmentIdRequestArguments.a() + "][files][][type]", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void n(PassportNfcRequestArguments passportNfcRequestArguments, List<w.c> list) {
        String d10 = passportNfcRequestArguments.d();
        String encodeToString = Base64.encodeToString(h.c(passportNfcRequestArguments.a()), 0);
        String encodeToString2 = Base64.encodeToString(h.c(passportNfcRequestArguments.c()), 0);
        String encodeToString3 = Base64.encodeToString(h.c(passportNfcRequestArguments.e()), 0);
        w.c.a aVar = w.c.f33214c;
        kotlin.jvm.internal.j.f(encodeToString, "dg1");
        list.add(aVar.b("data[attributes][fields][" + d10 + "][raw_nfc_data][dg1]", encodeToString));
        kotlin.jvm.internal.j.f(encodeToString2, "dg2");
        list.add(aVar.b("data[attributes][fields][" + d10 + "][raw_nfc_data][dg2]", encodeToString2));
        kotlin.jvm.internal.j.f(encodeToString3, "sod");
        list.add(aVar.b("data[attributes][fields][" + d10 + "][raw_nfc_data][sod]", encodeToString3));
    }

    private static final List<w.c> o(GovernmentIdRequestArguments governmentIdRequestArguments, List<Frame> list) {
        ArrayList arrayList = new ArrayList();
        for (Frame frame : list) {
            w.c.a aVar = w.c.f33214c;
            boolean unused = v.x(arrayList, p.e(aVar.c("data[attributes][fields][" + governmentIdRequestArguments.a() + "][files][][frames][]", new File(frame.a()).getName(), z.f33274a.a(new File(frame.a()), v.f33190e.b(frame.c())))));
        }
        return arrayList;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof SubmitVerificationWorker) || !kotlin.jvm.internal.j.b(this.f25878b, ((SubmitVerificationWorker) jVar).f25878b)) {
            return false;
        }
        return true;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new SubmitVerificationWorker$run$1(this, (kotlin.coroutines.c<? super SubmitVerificationWorker$run$1>) null));
    }
}
