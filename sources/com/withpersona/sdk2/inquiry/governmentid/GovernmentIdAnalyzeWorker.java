package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.j;
import com.withpersona.sdk2.camera.ExtractedTexts;
import com.withpersona.sdk2.camera.GovernmentIdFeed;
import com.withpersona.sdk2.camera.ParsedIdSideOrNone;
import com.withpersona.sdk2.camera.e;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.network.AutocaptureState;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;

public final class GovernmentIdAnalyzeWorker implements j<b> {

    /* renamed from: b  reason: collision with root package name */
    private final Context f25336b;

    /* renamed from: c  reason: collision with root package name */
    private final IdConfig.Side f25337c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25338d;

    /* renamed from: e  reason: collision with root package name */
    private final GovernmentIdFeed f25339e;

    /* renamed from: f  reason: collision with root package name */
    private AutocaptureState f25340f = new AutocaptureState((List) null, 1, (DefaultConstructorMarker) null);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f25345a;

        /* renamed from: b  reason: collision with root package name */
        private final GovernmentIdFeed f25346b;

        public a(Context context, GovernmentIdFeed governmentIdFeed) {
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            kotlin.jvm.internal.j.g(governmentIdFeed, "governmentIdFeed");
            this.f25345a = context;
            this.f25346b = governmentIdFeed;
        }

        public final GovernmentIdAnalyzeWorker a(IdConfig.Side side, String str) {
            kotlin.jvm.internal.j.g(side, "side");
            kotlin.jvm.internal.j.g(str, "idClassKey");
            return new GovernmentIdAnalyzeWorker(this.f25345a, side, str, this.f25346b);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f25347a = new a();

            private a() {
                super((DefaultConstructorMarker) null);
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$b$b  reason: collision with other inner class name */
        public static final class C0308b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final GovernmentId f25348a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0308b(GovernmentId governmentId) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(governmentId, "governmentId");
                this.f25348a = governmentId;
            }

            public final GovernmentId a() {
                return this.f25348a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0308b) && kotlin.jvm.internal.j.b(this.f25348a, ((C0308b) obj).f25348a);
            }

            public int hashCode() {
                return this.f25348a.hashCode();
            }

            public String toString() {
                return "Success(governmentId=" + this.f25348a + PropertyUtils.MAPPED_DELIM2;
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
        public static final /* synthetic */ int[] f25349a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.withpersona.sdk2.camera.ParsedIdSideOrNone$Side[] r0 = com.withpersona.sdk2.camera.ParsedIdSideOrNone.Side.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.camera.ParsedIdSideOrNone$Side r1 = com.withpersona.sdk2.camera.ParsedIdSideOrNone.Side.Front     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.camera.ParsedIdSideOrNone$Side r1 = com.withpersona.sdk2.camera.ParsedIdSideOrNone.Side.Back     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f25349a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker.c.<clinit>():void");
        }
    }

    public GovernmentIdAnalyzeWorker(Context context, IdConfig.Side side, String str, GovernmentIdFeed governmentIdFeed) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(side, "side");
        kotlin.jvm.internal.j.g(str, "idClassKey");
        kotlin.jvm.internal.j.g(governmentIdFeed, "governmentIdFeed");
        this.f25336b = context;
        this.f25337c = side;
        this.f25338d = str;
        this.f25339e = governmentIdFeed;
    }

    /* access modifiers changed from: private */
    public final GovernmentId c(ParsedIdSideOrNone.b bVar) {
        GovernmentId.Side side;
        RawExtraction rawExtraction;
        String absolutePath = r.a(bVar.b(), this.f25336b).getAbsolutePath();
        kotlin.jvm.internal.j.f(absolutePath, "parsedIdSide.bitmap.save…tId(context).absolutePath");
        List e10 = p.e(new Frame(absolutePath, (String) null, 2, (DefaultConstructorMarker) null));
        int i10 = c.f25349a[bVar.f().ordinal()];
        if (i10 == 1) {
            side = GovernmentId.Side.FRONT;
        } else if (i10 == 2) {
            side = GovernmentId.Side.BACK;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        GovernmentId.Side side2 = side;
        String str = this.f25338d;
        GovernmentId.CaptureMethod captureMethod = GovernmentId.CaptureMethod.f25318a;
        e c10 = bVar.c();
        if (c10 != null) {
            rawExtraction = q0.a(c10);
        } else {
            rawExtraction = null;
        }
        return new GovernmentId.GovernmentIdImage(e10, side2, str, captureMethod, rawExtraction, e(bVar));
    }

    private final GovernmentIdDetails e(ParsedIdSideOrNone.b bVar) {
        GovernmentIdDetails j10;
        e c10 = bVar.c();
        if (c10 != null && (j10 = o.j(c10)) != null) {
            return j10;
        }
        ExtractedTexts d10 = bVar.d();
        if (d10 != null) {
            return o.k(d10);
        }
        return null;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof GovernmentIdAnalyzeWorker) || ((GovernmentIdAnalyzeWorker) jVar).f25337c != this.f25337c) {
            return false;
        }
        return true;
    }

    public final AutocaptureState d() {
        return this.f25340f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GovernmentIdAnalyzeWorker)) {
            return false;
        }
        GovernmentIdAnalyzeWorker governmentIdAnalyzeWorker = (GovernmentIdAnalyzeWorker) obj;
        return kotlin.jvm.internal.j.b(this.f25336b, governmentIdAnalyzeWorker.f25336b) && this.f25337c == governmentIdAnalyzeWorker.f25337c && kotlin.jvm.internal.j.b(this.f25338d, governmentIdAnalyzeWorker.f25338d) && kotlin.jvm.internal.j.b(this.f25339e, governmentIdAnalyzeWorker.f25339e);
    }

    public final void f(AutocaptureState autocaptureState) {
        kotlin.jvm.internal.j.g(autocaptureState, "<set-?>");
        this.f25340f = autocaptureState;
    }

    public int hashCode() {
        return (((((this.f25336b.hashCode() * 31) + this.f25337c.hashCode()) * 31) + this.f25338d.hashCode()) * 31) + this.f25339e.hashCode();
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return new GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1(this.f25339e, this);
    }

    public String toString() {
        return "GovernmentIdAnalyzeWorker(context=" + this.f25336b + ", side=" + this.f25337c + ", idClassKey=" + this.f25338d + ", governmentIdFeed=" + this.f25339e + PropertyUtils.MAPPED_DELIM2;
    }
}
