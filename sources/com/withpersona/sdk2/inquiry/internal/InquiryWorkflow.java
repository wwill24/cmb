package com.withpersona.sdk2.inquiry.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.h;
import com.squareup.workflow1.o;
import com.squareup.workflow1.ui.SnapshotParcelsKt;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.network.CaptureOptionNativeMobile;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig;
import com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker;
import com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker;
import com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.TransitionBackWorker;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.StaticInquiryTemplate;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.network.ErrorResponse;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.sandbox.SandboxFlags;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.selfie.v;
import com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition;
import com.withpersona.sdk2.inquiry.shared.ui.e;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import okio.ByteString;

public final class InquiryWorkflow extends h<a, InquiryState, Output, Object> {

    /* renamed from: a  reason: collision with root package name */
    private final CreateInquiryWorker.a f26232a;

    /* renamed from: b  reason: collision with root package name */
    private final CreateInquirySessionWorker.a f26233b;

    /* renamed from: c  reason: collision with root package name */
    private final CheckInquiryWorker.b f26234c;

    /* renamed from: d  reason: collision with root package name */
    private final TransitionBackWorker.a f26235d;

    /* renamed from: e  reason: collision with root package name */
    private final GovernmentIdWorkflow f26236e;

    /* renamed from: f  reason: collision with root package name */
    private final SelfieWorkflow f26237f;

    /* renamed from: g  reason: collision with root package name */
    private final UiWorkflow f26238g;

    /* renamed from: h  reason: collision with root package name */
    private final DocumentWorkflow f26239h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final SandboxFlags f26240i;

    public static abstract class Output implements Parcelable {

        public static final class Cancel extends Output implements com.withpersona.sdk2.inquiry.modal.a {
            public static final Parcelable.Creator<Cancel> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26241a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26242b;

            /* renamed from: c  reason: collision with root package name */
            private final StepStyle f26243c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26244d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26245e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26246f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26247g;

            public static final class a implements Parcelable.Creator<Cancel> {
                /* renamed from: a */
                public final Cancel createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Cancel(parcel.readString(), parcel.readString(), (StepStyle) parcel.readParcelable(Cancel.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final Cancel[] newArray(int i10) {
                    return new Cancel[i10];
                }
            }

            public Cancel(String str, String str2, StepStyle stepStyle, String str3, String str4, String str5, String str6) {
                super((DefaultConstructorMarker) null);
                this.f26241a = str;
                this.f26242b = str2;
                this.f26243c = stepStyle;
                this.f26244d = str3;
                this.f26245e = str4;
                this.f26246f = str5;
                this.f26247g = str6;
            }

            public String a() {
                return this.f26247g;
            }

            public StepStyle b() {
                return this.f26243c;
            }

            public String c() {
                return this.f26246f;
            }

            public final String d() {
                return this.f26241a;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26242b;
            }

            public String getMessage() {
                return this.f26245e;
            }

            public String getTitle() {
                return this.f26244d;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26241a);
                parcel.writeString(this.f26242b);
                parcel.writeParcelable(this.f26243c, i10);
                parcel.writeString(this.f26244d);
                parcel.writeString(this.f26245e);
                parcel.writeString(this.f26246f);
                parcel.writeString(this.f26247g);
            }
        }

        public static final class Complete extends Output {
            public static final Parcelable.Creator<Complete> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26248a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26249b;

            /* renamed from: c  reason: collision with root package name */
            private final Map<String, InquiryField> f26250c;

            public static final class a implements Parcelable.Creator<Complete> {
                /* renamed from: a */
                public final Complete createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        linkedHashMap.put(parcel.readString(), parcel.readParcelable(Complete.class.getClassLoader()));
                    }
                    return new Complete(readString, readString2, linkedHashMap);
                }

                /* renamed from: b */
                public final Complete[] newArray(int i10) {
                    return new Complete[i10];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Complete(String str, String str2, Map<String, ? extends InquiryField> map) {
                super((DefaultConstructorMarker) null);
                j.g(str, "inquiryId");
                j.g(str2, "inquiryStatus");
                j.g(map, "fields");
                this.f26248a = str;
                this.f26249b = str2;
                this.f26250c = map;
            }

            public final Map<String, InquiryField> d() {
                return this.f26250c;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26248a;
            }

            public final String f() {
                return this.f26249b;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26248a);
                parcel.writeString(this.f26249b);
                Map<String, InquiryField> map = this.f26250c;
                parcel.writeInt(map.size());
                for (Map.Entry next : map.entrySet()) {
                    parcel.writeString((String) next.getKey());
                    parcel.writeParcelable((Parcelable) next.getValue(), i10);
                }
            }
        }

        public static final class Error extends Output {
            public static final Parcelable.Creator<Error> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26251a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26252b;

            /* renamed from: c  reason: collision with root package name */
            private final InternalErrorInfo f26253c;

            public static final class a implements Parcelable.Creator<Error> {
                /* renamed from: a */
                public final Error createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Error(parcel.readString(), parcel.readString(), (InternalErrorInfo) parcel.readParcelable(Error.class.getClassLoader()));
                }

                /* renamed from: b */
                public final Error[] newArray(int i10) {
                    return new Error[i10];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(String str, String str2, InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                j.g(internalErrorInfo, "cause");
                this.f26251a = str;
                this.f26252b = str2;
                this.f26253c = internalErrorInfo;
            }

            public final InternalErrorInfo d() {
                return this.f26253c;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26252b;
            }

            public final String f() {
                return this.f26251a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26251a);
                parcel.writeString(this.f26252b);
                parcel.writeParcelable(this.f26253c, i10);
            }
        }

        private Output() {
        }

        public /* synthetic */ Output(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static abstract class a {

        /* renamed from: com.withpersona.sdk2.inquiry.internal.InquiryWorkflow$a$a  reason: collision with other inner class name */
        public static final class C0315a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f26254a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26255b;

            /* renamed from: c  reason: collision with root package name */
            private final Environment f26256c;

            /* renamed from: d  reason: collision with root package name */
            private final Integer f26257d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0315a(String str, String str2, Environment environment, Integer num) {
                super((DefaultConstructorMarker) null);
                j.g(str, "inquiryId");
                j.g(environment, "environment");
                this.f26254a = str;
                this.f26255b = str2;
                this.f26256c = environment;
                this.f26257d = num;
            }

            public Environment a() {
                return this.f26256c;
            }

            public Integer b() {
                return this.f26257d;
            }

            public final String c() {
                return this.f26254a;
            }

            public final String d() {
                return this.f26255b;
            }
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f26258a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26259b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26260c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26261d;

            /* renamed from: e  reason: collision with root package name */
            private final Map<String, InquiryField> f26262e;

            /* renamed from: f  reason: collision with root package name */
            private final StaticInquiryTemplate f26263f;

            /* renamed from: g  reason: collision with root package name */
            private final boolean f26264g;

            /* renamed from: h  reason: collision with root package name */
            private final Environment f26265h;

            /* renamed from: i  reason: collision with root package name */
            private final Integer f26266i;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, String str2, String str3, String str4, Map<String, ? extends InquiryField> map, StaticInquiryTemplate staticInquiryTemplate, boolean z10, Environment environment, Integer num) {
                super((DefaultConstructorMarker) null);
                j.g(environment, "environment");
                this.f26258a = str;
                this.f26259b = str2;
                this.f26260c = str3;
                this.f26261d = str4;
                this.f26262e = map;
                this.f26263f = staticInquiryTemplate;
                this.f26264g = z10;
                this.f26265h = environment;
                this.f26266i = num;
            }

            public Environment a() {
                return this.f26265h;
            }

            public Integer b() {
                return this.f26266i;
            }

            public final String c() {
                return this.f26260c;
            }

            public final Map<String, InquiryField> d() {
                return this.f26262e;
            }

            public final String e() {
                return this.f26261d;
            }

            public final boolean f() {
                return this.f26264g;
            }

            public final StaticInquiryTemplate g() {
                return this.f26263f;
            }

            public final String h() {
                return this.f26258a;
            }

            public final String i() {
                return this.f26259b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Environment a();

        public abstract Integer b();
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final StepStyle f26267a;

            /* renamed from: b  reason: collision with root package name */
            private final boolean f26268b;

            /* renamed from: c  reason: collision with root package name */
            private final Function0<Unit> f26269c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(StepStyle stepStyle, boolean z10, Function0<Unit> function0) {
                super((DefaultConstructorMarker) null);
                j.g(function0, "onBack");
                this.f26267a = stepStyle;
                this.f26268b = z10;
                this.f26269c = function0;
            }

            public final Function0<Unit> a() {
                return this.f26269c;
            }

            public final StepStyle b() {
                return this.f26267a;
            }

            public final boolean c() {
                return this.f26268b;
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
        public static final /* synthetic */ int[] f26270a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f26271b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        static {
            /*
                com.withpersona.sdk2.inquiry.internal.TransitionStatus[] r0 = com.withpersona.sdk2.inquiry.internal.TransitionStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.internal.TransitionStatus r2 = com.withpersona.sdk2.inquiry.internal.TransitionStatus.CheckingForNextState     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.internal.TransitionStatus r3 = com.withpersona.sdk2.inquiry.internal.TransitionStatus.TransitioningBack     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f26270a = r0
                com.withpersona.sdk2.inquiry.internal.network.NextStep$Document$StartPage[] r0 = com.withpersona.sdk2.inquiry.internal.network.NextStep.Document.StartPage.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.internal.network.NextStep$Document$StartPage r3 = com.withpersona.sdk2.inquiry.internal.network.NextStep.Document.StartPage.PROMPT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.withpersona.sdk2.inquiry.internal.network.NextStep$Document$StartPage r1 = com.withpersona.sdk2.inquiry.internal.network.NextStep.Document.StartPage.REVIEW     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                f26271b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.InquiryWorkflow.c.<clinit>():void");
        }
    }

    public InquiryWorkflow(CreateInquiryWorker.a aVar, CreateInquirySessionWorker.a aVar2, CheckInquiryWorker.b bVar, TransitionBackWorker.a aVar3, GovernmentIdWorkflow governmentIdWorkflow, SelfieWorkflow selfieWorkflow, UiWorkflow uiWorkflow, DocumentWorkflow documentWorkflow, SandboxFlags sandboxFlags) {
        j.g(aVar, "createInquiryWorker");
        j.g(aVar2, "inquirySessionWorker");
        j.g(bVar, "checkInquiryWorker");
        j.g(aVar3, "transitionBackWorker");
        j.g(governmentIdWorkflow, "governmentIdWorkflow");
        j.g(selfieWorkflow, "selfieWorkflow");
        j.g(uiWorkflow, "uiWorkflow");
        j.g(documentWorkflow, "documentWorkflow");
        j.g(sandboxFlags, "sandboxFlags");
        this.f26232a = aVar;
        this.f26233b = aVar2;
        this.f26234c = bVar;
        this.f26235d = aVar3;
        this.f26236e = governmentIdWorkflow;
        this.f26237f = selfieWorkflow;
        this.f26238g = uiWorkflow;
        this.f26239h = documentWorkflow;
        this.f26240i = sandboxFlags;
    }

    /* access modifiers changed from: private */
    public final boolean l(InternalErrorInfo internalErrorInfo) {
        if (!(internalErrorInfo instanceof InternalErrorInfo.NetworkErrorInfo) || !(((InternalErrorInfo.NetworkErrorInfo) internalErrorInfo).getResponseError() instanceof ErrorResponse.Error.InconsistentTransitionError)) {
            return false;
        }
        return true;
    }

    private final Object n(a aVar, InquiryState.CreateInquiryFromTemplate createInquiryFromTemplate, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar2, Function0<Unit> function0) {
        o.l(aVar2, this.f26232a.a(createInquiryFromTemplate.l(), createInquiryFromTemplate.m(), aVar.a(), createInquiryFromTemplate.i(), createInquiryFromTemplate.k(), createInquiryFromTemplate.j()), l.k(CreateInquiryWorker.class), "", new InquiryWorkflow$renderCreateInquiryFromTemplate$1(this, createInquiryFromTemplate));
        return new b.a(createInquiryFromTemplate.b(), true, function0);
    }

    private final Object o(a aVar, InquiryState.CreateInquirySession createInquirySession, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar2, Function0<Unit> function0) {
        o.l(aVar2, this.f26233b.a(createInquirySession.c()), l.k(CreateInquirySessionWorker.class), "", new InquiryWorkflow$renderCreateInquirySession$1(this, createInquirySession));
        return new b.a(createInquirySession.b(), true, function0);
    }

    private final Object p(InquiryState.DocumentStepRunning documentStepRunning, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar) {
        DocumentWorkflow.StartPage startPage;
        boolean z10;
        boolean z11;
        boolean z12;
        String f10 = documentStepRunning.f();
        DocumentWorkflow documentWorkflow = this.f26239h;
        String d10 = documentStepRunning.d();
        String c10 = documentStepRunning.c();
        String f11 = documentStepRunning.f();
        String l10 = documentStepRunning.l();
        String l11 = documentStepRunning.k().c().h().d().l();
        String k10 = documentStepRunning.k().c().h().d().k();
        String j10 = documentStepRunning.k().c().h().d().j();
        String c11 = documentStepRunning.k().c().h().d().c();
        String c12 = documentStepRunning.k().c().h().c().c();
        String a10 = documentStepRunning.k().c().h().c().a();
        String f12 = documentStepRunning.k().c().f();
        String g10 = documentStepRunning.k().c().g();
        String e10 = documentStepRunning.k().c().e();
        int i10 = c.f26271b[documentStepRunning.k().c().j().ordinal()];
        String str = f10;
        if (i10 == 1) {
            startPage = DocumentWorkflow.StartPage.Prompt;
        } else if (i10 == 2) {
            startPage = DocumentWorkflow.StartPage.Review;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        DocumentWorkflow.StartPage startPage2 = startPage;
        int d11 = documentStepRunning.k().c().d();
        Boolean a11 = documentStepRunning.k().c().a();
        if (a11 != null) {
            z10 = a11.booleanValue();
        } else {
            z10 = false;
        }
        Boolean c13 = documentStepRunning.k().c().c();
        if (c13 != null) {
            z11 = c13.booleanValue();
        } else {
            z11 = true;
        }
        Object b10 = aVar.b(documentWorkflow, new DocumentWorkflow.b(d10, c10, f11, l10, l11, k10, j10, c11, c12, a10, f12, g10, e10, startPage2, documentStepRunning.m(), d11, z10, z11, documentStepRunning.k().c().h().d().h(), documentStepRunning.k().c().h().d().g(), documentStepRunning.k().c().h().d().e(), documentStepRunning.k().c().h().d().f(), documentStepRunning.b()), str, new InquiryWorkflow$renderDocumentStep$2(this, documentStepRunning));
        if (documentStepRunning.g() != TransitionStatus.TransitioningBack) {
            z12 = true;
        } else {
            z12 = false;
        }
        return new ni.b(b10, z12, documentStepRunning.f());
    }

    private final Object q(a aVar, InquiryState.GovernmentIdStepRunning governmentIdStepRunning, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar2, Function0<Unit> function0) {
        List list;
        boolean z10;
        String f10 = governmentIdStepRunning.f();
        GovernmentIdWorkflow governmentIdWorkflow = this.f26236e;
        String d10 = governmentIdStepRunning.d();
        String m10 = governmentIdStepRunning.m();
        List<Id> p10 = governmentIdStepRunning.p();
        ArrayList arrayList = new ArrayList();
        for (Id m11 : p10) {
            IdConfig m12 = com.withpersona.sdk2.inquiry.governmentid.o.m(m11, governmentIdStepRunning.m(), governmentIdStepRunning.x(), governmentIdStepRunning.A());
            if (m12 != null) {
                arrayList.add(m12);
            }
        }
        String c10 = governmentIdStepRunning.c();
        String f11 = governmentIdStepRunning.f();
        String s10 = governmentIdStepRunning.s();
        boolean k10 = governmentIdStepRunning.k();
        boolean l10 = governmentIdStepRunning.l();
        List<CaptureOptionNativeMobile> o10 = governmentIdStepRunning.o();
        StepStyles$GovernmentIdStepStyle D = governmentIdStepRunning.b();
        int t10 = governmentIdStepRunning.t();
        String q10 = governmentIdStepRunning.q();
        String r10 = governmentIdStepRunning.r();
        GovernmentIdPages z11 = governmentIdStepRunning.z();
        NextStep.GovernmentId.Localizations w10 = governmentIdStepRunning.w();
        List<NextStep.GovernmentId.LocalizationOverride> u10 = governmentIdStepRunning.u();
        if (u10 != null) {
            list = CollectionsKt___CollectionsKt.p0(u10);
        } else {
            list = null;
        }
        GovernmentIdWorkflow.a.C0309a e10 = com.withpersona.sdk2.inquiry.internal.network.a.e(w10, list);
        long x10 = governmentIdStepRunning.x();
        Integer b10 = aVar.b();
        PassportNfcConfig A = governmentIdStepRunning.A();
        boolean B = governmentIdStepRunning.B();
        com.withpersona.sdk2.inquiry.governmentid.video_capture.a aVar3 = r25;
        com.withpersona.sdk2.inquiry.governmentid.video_capture.a aVar4 = new com.withpersona.sdk2.inquiry.governmentid.video_capture.a(governmentIdStepRunning.n().contains(NextStep.GovernmentId.CaptureFileType.VIDEO), 0, 2, (DefaultConstructorMarker) null);
        Object b11 = aVar2.b(governmentIdWorkflow, new GovernmentIdWorkflow.a(d10, m10, arrayList, c10, f11, s10, k10, l10, o10, D, e10, t10, q10, r10, z11, x10, A, B, b10, aVar3), f10, new InquiryWorkflow$renderGovernmentIdStepRunning$2(this, governmentIdStepRunning));
        if (governmentIdStepRunning.g() != TransitionStatus.TransitioningBack) {
            z10 = true;
        } else {
            z10 = false;
        }
        return new ni.b(b11, z10, governmentIdStepRunning.f());
    }

    private final Object r(a aVar, InquiryState.SelfieStepRunning selfieStepRunning, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar2, Function0<Unit> function0) {
        v vVar;
        boolean z10;
        String f10 = selfieStepRunning.f();
        SelfieWorkflow selfieWorkflow = this.f26237f;
        String d10 = selfieStepRunning.d();
        String c10 = selfieStepRunning.c();
        String p10 = selfieStepRunning.p();
        String f11 = selfieStepRunning.f();
        boolean k10 = selfieStepRunning.k();
        boolean l10 = selfieStepRunning.l();
        String o10 = selfieStepRunning.o();
        boolean r10 = selfieStepRunning.r();
        SelfieWorkflow.b.a p11 = com.withpersona.sdk2.inquiry.internal.network.a.p(selfieStepRunning.q(), selfieStepRunning.m());
        if (selfieStepRunning.m()) {
            vVar = v.a.f27435a;
        } else {
            vVar = v.b.f27436a;
        }
        String f12 = selfieStepRunning.q().e().f();
        String e10 = selfieStepRunning.q().e().e();
        String c11 = selfieStepRunning.q().e().c();
        String d11 = selfieStepRunning.q().e().d();
        String k11 = selfieStepRunning.q().e().k();
        String j10 = selfieStepRunning.q().e().j();
        String i10 = selfieStepRunning.q().e().i();
        String h10 = selfieStepRunning.q().e().h();
        StepStyles$SelfieStepStyle s10 = selfieStepRunning.b();
        com.withpersona.sdk2.inquiry.selfie.video_capture.a aVar3 = r25;
        String str = f10;
        com.withpersona.sdk2.inquiry.selfie.video_capture.a aVar4 = new com.withpersona.sdk2.inquiry.selfie.video_capture.a(selfieStepRunning.n().contains(NextStep.Selfie.CaptureFileType.VIDEO), 0, 2, (DefaultConstructorMarker) null);
        SelfieWorkflow.b bVar = r3;
        SelfieWorkflow.b bVar2 = new SelfieWorkflow.b(d10, c10, p10, f11, k10, l10, o10, r10, p11, vVar, f12, e10, c11, d11, k11, j10, i10, h10, s10, aVar3);
        h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar5 = aVar2;
        Object b10 = aVar5.b(selfieWorkflow, bVar, str, new InquiryWorkflow$renderSelfieStep$1(this, selfieStepRunning));
        if (selfieStepRunning.g() != TransitionStatus.TransitioningBack) {
            z10 = true;
        } else {
            z10 = false;
        }
        return new ni.b(b10, z10, selfieStepRunning.f());
    }

    private final Object s(a aVar, InquiryState.ShowLoadingSpinner showLoadingSpinner, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar2, Function0<Unit> function0) {
        return new b.a(showLoadingSpinner.b(), showLoadingSpinner.i(), function0);
    }

    private final Object t(a aVar, InquiryState.UiStepRunning uiStepRunning, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar2, Function0<Unit> function0) {
        boolean z10;
        com.squareup.workflow1.ui.h hVar = new com.squareup.workflow1.ui.h((UiWorkflow.c) aVar2.b(this.f26238g, new UiWorkflow.a(uiStepRunning.d(), uiStepRunning.c(), uiStepRunning.getComponents(), uiStepRunning.q(), uiStepRunning.k(), uiStepRunning.l(), uiStepRunning.o(), uiStepRunning.b()), uiStepRunning.m(), new InquiryWorkflow$renderUiStep$1(this, uiStepRunning)), uiStepRunning.m());
        if (uiStepRunning.g() != TransitionStatus.TransitioningBack) {
            z10 = true;
        } else {
            z10 = false;
        }
        return new ni.b(hVar, z10, uiStepRunning.m());
    }

    /* access modifiers changed from: private */
    public final InquiryState.ShowLoadingSpinner u(r rVar) {
        return new InquiryState.ShowLoadingSpinner(rVar.d(), (TransitionStatus) null, rVar.c(), rVar.b(), false, 2, (DefaultConstructorMarker) null);
    }

    private final void v(a aVar, InquiryState inquiryState, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar2) {
        int i10;
        String d10 = inquiryState.d();
        String c10 = inquiryState.c();
        String f10 = inquiryState.f();
        TransitionStatus g10 = inquiryState.g();
        if (g10 == null) {
            i10 = -1;
        } else {
            i10 = c.f26270a[g10.ordinal()];
        }
        if (i10 != 1) {
            if (i10 == 2 && d10 != null && c10 != null && f10 != null) {
                o.l(aVar2, this.f26235d.a(d10, c10, f10), l.k(TransitionBackWorker.class), "", new InquiryWorkflow$runTransitionWorkerIfNeeded$2(this, inquiryState, d10));
            }
        } else if (d10 != null && c10 != null) {
            o.l(aVar2, this.f26234c.a(d10, c10), l.k(CheckInquiryWorker.class), "", new InquiryWorkflow$runTransitionWorkerIfNeeded$1(this, d10));
        }
    }

    private final com.withpersona.sdk2.inquiry.sandbox.b<Object> x(Object obj, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar) {
        return new com.withpersona.sdk2.inquiry.sandbox.b<>(obj, new InquiryWorkflow$wrapSandboxFabScreen$1(this, aVar), new InquiryWorkflow$wrapSandboxFabScreen$2(this));
    }

    private final e y(Object obj, InquiryState inquiryState) {
        ScreenTransition screenTransition;
        if (inquiryState.e()) {
            screenTransition = ScreenTransition.SLIDE_OUT;
        } else {
            screenTransition = ScreenTransition.SLIDE_IN;
        }
        return new e(obj, screenTransition);
    }

    /* renamed from: k */
    public InquiryState d(a aVar, Snapshot snapshot) {
        boolean z10;
        j.g(aVar, "props");
        boolean z11 = true;
        if (snapshot != null) {
            ByteString b10 = snapshot.b();
            if (b10.H() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Parcelable parcelable = null;
            if (!z10) {
                b10 = null;
            }
            if (b10 != null) {
                Parcel obtain = Parcel.obtain();
                j.f(obtain, "obtain()");
                byte[] N = b10.N();
                obtain.unmarshall(N, 0, N.length);
                obtain.setDataPosition(0);
                parcelable = obtain.readParcelable(Snapshot.class.getClassLoader());
                j.d(parcelable);
                j.f(parcelable, "parcel.readParcelable<T>…class.java.classLoader)!!");
                obtain.recycle();
            }
            InquiryState inquiryState = (InquiryState) parcelable;
            if (inquiryState != null) {
                return inquiryState;
            }
        }
        if (aVar instanceof a.b) {
            a.b bVar = (a.b) aVar;
            return new InquiryState.CreateInquiryFromTemplate(bVar.h(), bVar.i(), bVar.c(), bVar.e(), bVar.d(), bVar.g(), bVar.f());
        } else if (aVar instanceof a.C0315a) {
            a.C0315a aVar2 = (a.C0315a) aVar;
            String d10 = aVar2.d();
            if (!(d10 == null || d10.length() == 0)) {
                z11 = false;
            }
            if (z11) {
                return new InquiryState.CreateInquirySession(aVar2.c());
            }
            return new InquiryState.ShowLoadingSpinner(aVar2.d(), TransitionStatus.CheckingForNextState, aVar2.c(), (StepStyle) null, true);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: m */
    public Object f(a aVar, InquiryState inquiryState, h<? super a, InquiryState, ? extends Output, ? extends Object>.defpackage.a aVar2) {
        Object obj;
        j.g(aVar, "renderProps");
        j.g(inquiryState, "renderState");
        j.g(aVar2, IdentityHttpResponse.CONTEXT);
        v(aVar, inquiryState, aVar2);
        InquiryWorkflow$render$backAction$1 inquiryWorkflow$render$backAction$1 = new InquiryWorkflow$render$backAction$1(aVar2, this, inquiryState);
        if (inquiryState instanceof InquiryState.CreateInquiryFromTemplate) {
            obj = n(aVar, (InquiryState.CreateInquiryFromTemplate) inquiryState, aVar2, inquiryWorkflow$render$backAction$1);
        } else if (inquiryState instanceof InquiryState.CreateInquirySession) {
            obj = o(aVar, (InquiryState.CreateInquirySession) inquiryState, aVar2, inquiryWorkflow$render$backAction$1);
        } else if (inquiryState instanceof InquiryState.ShowLoadingSpinner) {
            obj = s(aVar, (InquiryState.ShowLoadingSpinner) inquiryState, aVar2, inquiryWorkflow$render$backAction$1);
        } else if (inquiryState instanceof InquiryState.GovernmentIdStepRunning) {
            obj = q(aVar, (InquiryState.GovernmentIdStepRunning) inquiryState, aVar2, inquiryWorkflow$render$backAction$1);
        } else if (inquiryState instanceof InquiryState.SelfieStepRunning) {
            obj = r(aVar, (InquiryState.SelfieStepRunning) inquiryState, aVar2, inquiryWorkflow$render$backAction$1);
        } else if (inquiryState instanceof InquiryState.UiStepRunning) {
            obj = t(aVar, (InquiryState.UiStepRunning) inquiryState, aVar2, inquiryWorkflow$render$backAction$1);
        } else if (inquiryState instanceof InquiryState.DocumentStepRunning) {
            obj = p((InquiryState.DocumentStepRunning) inquiryState, aVar2);
        } else if (inquiryState instanceof InquiryState.Complete) {
            throw new IllegalStateException("This state should never be reached.".toString());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        e y10 = y(obj, inquiryState);
        if (this.f26240i.b()) {
            return x(y10, aVar2);
        }
        return y10;
    }

    /* renamed from: w */
    public Snapshot g(InquiryState inquiryState) {
        j.g(inquiryState, "state");
        return SnapshotParcelsKt.a(inquiryState);
    }
}
