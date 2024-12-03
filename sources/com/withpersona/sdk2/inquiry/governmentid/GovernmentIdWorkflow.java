package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import coil.ImageLoader;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.h;
import com.squareup.workflow1.j;
import com.squareup.workflow1.l;
import com.squareup.workflow1.o;
import com.squareup.workflow1.ui.SnapshotParcelsKt;
import com.squareup.workflow1.ui.modal.AlertScreen;
import com.withpersona.sdk2.camera.AutoCaptureRule;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.capture_tips.d;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.HoldStillHint;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.LowLightHint;
import com.withpersona.sdk2.inquiry.governmentid.network.CaptureOptionNativeMobile;
import com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker;
import com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig;
import com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcRenderer;
import com.withpersona.sdk2.inquiry.governmentid.nfc.f;
import com.withpersona.sdk2.inquiry.governmentid.video_capture.VideoCaptureRenderer;
import com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition;
import com.withpersona.sdk2.inquiry.shared.ui.e;
import com.withpersona.sdk2.inquiry.steps.ui.m;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.reflect.KTypeProjection;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okio.ByteString;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

public final class GovernmentIdWorkflow extends h<a, GovernmentIdState, b, Object> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f25506a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageLoader f25507b;

    /* renamed from: c  reason: collision with root package name */
    private final SubmitVerificationWorker.a f25508c;

    /* renamed from: d  reason: collision with root package name */
    private final GovernmentIdAnalyzeWorker.a f25509d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final DocumentSelectWorker f25510e;

    /* renamed from: f  reason: collision with root package name */
    private final GovernmentIdHintWorker.b f25511f;

    /* renamed from: g  reason: collision with root package name */
    private final PermissionRequestWorkflow f25512g;

    /* renamed from: h  reason: collision with root package name */
    private final VideoCaptureRenderer f25513h;

    /* renamed from: i  reason: collision with root package name */
    private final PassportNfcRenderer f25514i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f25581a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25582b;

        /* renamed from: c  reason: collision with root package name */
        private final List<IdConfig> f25583c;

        /* renamed from: d  reason: collision with root package name */
        private final String f25584d;

        /* renamed from: e  reason: collision with root package name */
        private final String f25585e;

        /* renamed from: f  reason: collision with root package name */
        private final String f25586f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f25587g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f25588h;

        /* renamed from: i  reason: collision with root package name */
        private final List<CaptureOptionNativeMobile> f25589i;

        /* renamed from: j  reason: collision with root package name */
        private final StepStyles$GovernmentIdStepStyle f25590j;

        /* renamed from: k  reason: collision with root package name */
        private final C0309a f25591k;

        /* renamed from: l  reason: collision with root package name */
        private final int f25592l;

        /* renamed from: m  reason: collision with root package name */
        private final String f25593m;

        /* renamed from: n  reason: collision with root package name */
        private final String f25594n;

        /* renamed from: o  reason: collision with root package name */
        private final GovernmentIdPages f25595o;

        /* renamed from: p  reason: collision with root package name */
        private final long f25596p;

        /* renamed from: q  reason: collision with root package name */
        private final PassportNfcConfig f25597q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f25598r;

        /* renamed from: s  reason: collision with root package name */
        private final Integer f25599s;

        /* renamed from: t  reason: collision with root package name */
        private final com.withpersona.sdk2.inquiry.governmentid.video_capture.a f25600t;

        /* renamed from: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a$a  reason: collision with other inner class name */
        public static final class C0309a {
            private final String A;
            private final String B;
            private final String C;
            private final String D;
            private final String E;
            private final String F;
            private final String G;
            private final String H;
            private final String I;
            private final String J;
            private final String K;
            private final String L;
            private final String M;
            private final String N;
            private final String O;
            private final String P;
            private final String Q;
            private final String R;
            private final String S;
            private final String T;
            private final String U;
            private final String V;
            private final String W;
            private final String X;
            private final String Y;
            private final String Z;

            /* renamed from: a  reason: collision with root package name */
            private final String f25601a;

            /* renamed from: a0  reason: collision with root package name */
            private final String f25602a0;

            /* renamed from: b  reason: collision with root package name */
            private final String f25603b;

            /* renamed from: b0  reason: collision with root package name */
            private final String f25604b0;

            /* renamed from: c  reason: collision with root package name */
            private final String f25605c;

            /* renamed from: c0  reason: collision with root package name */
            private final String f25606c0;

            /* renamed from: d  reason: collision with root package name */
            private final String f25607d;

            /* renamed from: d0  reason: collision with root package name */
            private final String f25608d0;

            /* renamed from: e  reason: collision with root package name */
            private final String f25609e;

            /* renamed from: e0  reason: collision with root package name */
            private final String f25610e0;

            /* renamed from: f  reason: collision with root package name */
            private final String f25611f;

            /* renamed from: g  reason: collision with root package name */
            private final String f25612g;

            /* renamed from: h  reason: collision with root package name */
            private final String f25613h;

            /* renamed from: i  reason: collision with root package name */
            private final String f25614i;

            /* renamed from: j  reason: collision with root package name */
            private final String f25615j;

            /* renamed from: k  reason: collision with root package name */
            private final String f25616k;

            /* renamed from: l  reason: collision with root package name */
            private final String f25617l;

            /* renamed from: m  reason: collision with root package name */
            private final String f25618m;

            /* renamed from: n  reason: collision with root package name */
            private final String f25619n;

            /* renamed from: o  reason: collision with root package name */
            private final String f25620o;

            /* renamed from: p  reason: collision with root package name */
            private final String f25621p;

            /* renamed from: q  reason: collision with root package name */
            private final Map<String, String> f25622q;

            /* renamed from: r  reason: collision with root package name */
            private final Map<String, String> f25623r;

            /* renamed from: s  reason: collision with root package name */
            private final Map<String, String> f25624s;

            /* renamed from: t  reason: collision with root package name */
            private final String f25625t;

            /* renamed from: u  reason: collision with root package name */
            private final String f25626u;

            /* renamed from: v  reason: collision with root package name */
            private final Map<IdConfig.Side, String> f25627v;

            /* renamed from: w  reason: collision with root package name */
            private final Map<IdConfig.Side, String> f25628w;

            /* renamed from: x  reason: collision with root package name */
            private final String f25629x;

            /* renamed from: y  reason: collision with root package name */
            private final String f25630y;

            /* renamed from: z  reason: collision with root package name */
            private final String f25631z;

            public C0309a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, String str17, String str18, Map<IdConfig.Side, String> map4, Map<IdConfig.Side, String> map5, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52) {
                String str53 = str;
                String str54 = str2;
                String str55 = str3;
                String str56 = str4;
                String str57 = str5;
                String str58 = str6;
                String str59 = str7;
                String str60 = str8;
                String str61 = str9;
                String str62 = str10;
                String str63 = str11;
                String str64 = str12;
                String str65 = str13;
                String str66 = str14;
                String str67 = str16;
                j.g(str53, "title");
                j.g(str54, "prompt");
                j.g(str55, "choose");
                j.g(str56, "instructionsDisclaimer");
                j.g(str57, "scanFront");
                j.g(str58, "scanBack");
                j.g(str59, "scanPdf417");
                j.g(str60, "scanFrontOrBack");
                j.g(str61, "scanSignature");
                j.g(str62, "capturing");
                j.g(str63, "confirmCapture");
                j.g(str64, "captureDisclaimer");
                j.g(str65, "buttonSubmit");
                j.g(str66, "buttonRetake");
                j.g(str15, "processingTitle");
                j.g(str16, "processingDescription");
                j.g(map, "idClassToName");
                j.g(map2, "chooseCaptureMethodTitle");
                j.g(map3, "chooseCaptureMethodBody");
                j.g(str17, "chooseCaptureMethodCameraButton");
                j.g(str18, "chooseCaptureMethodUploadButton");
                j.g(map4, "reviewSelectedImageTitle");
                j.g(map5, "reviewSelectedImageBody");
                j.g(str19, "reviewSelectedImageConfirmButton");
                j.g(str20, "reviewSelectedImageChooseAnotherButton");
                this.f25601a = str53;
                this.f25603b = str54;
                this.f25605c = str55;
                this.f25607d = str56;
                this.f25609e = str57;
                this.f25611f = str58;
                this.f25612g = str59;
                this.f25613h = str60;
                this.f25614i = str61;
                this.f25615j = str62;
                this.f25616k = str63;
                this.f25617l = str64;
                this.f25618m = str65;
                this.f25619n = str66;
                this.f25620o = str15;
                this.f25621p = str16;
                this.f25622q = map;
                this.f25623r = map2;
                this.f25624s = map3;
                this.f25625t = str17;
                this.f25626u = str18;
                this.f25627v = map4;
                this.f25628w = map5;
                this.f25629x = str19;
                this.f25630y = str20;
                this.f25631z = str21;
                this.A = str22;
                this.B = str23;
                this.C = str24;
                this.D = str25;
                this.E = str26;
                this.F = str27;
                this.G = str28;
                this.H = str29;
                this.I = str30;
                this.J = str31;
                this.K = str32;
                this.L = str33;
                this.M = str34;
                this.N = str35;
                this.O = str36;
                this.P = str37;
                this.Q = str38;
                this.R = str39;
                this.S = str40;
                this.T = str41;
                this.U = str42;
                this.V = str43;
                this.W = str44;
                this.X = str45;
                this.Y = str46;
                this.Z = str47;
                this.f25602a0 = str48;
                this.f25604b0 = str49;
                this.f25606c0 = str50;
                this.f25608d0 = str51;
                this.f25610e0 = str52;
            }

            public final String A() {
                return this.G;
            }

            public final String B() {
                return this.S;
            }

            public final String C() {
                return this.Q;
            }

            public final String D() {
                return this.R;
            }

            public final String E() {
                return this.f25610e0;
            }

            public final String F() {
                return this.f25608d0;
            }

            public final String G() {
                return this.f25606c0;
            }

            public final String H() {
                return this.f25604b0;
            }

            public final Map<String, String> I() {
                return this.f25622q;
            }

            public final String J() {
                return this.f25602a0;
            }

            public final String K() {
                return this.Z;
            }

            public final String L() {
                return this.Y;
            }

            public final String M() {
                return this.X;
            }

            public final String N() {
                return this.f25607d;
            }

            public final String O() {
                return this.O;
            }

            public final String P() {
                return this.P;
            }

            public final String Q() {
                return this.N;
            }

            public final String R() {
                return this.M;
            }

            public final String S() {
                return this.f25621p;
            }

            public final String T() {
                return this.f25620o;
            }

            public final String U() {
                return this.f25603b;
            }

            public final Map<IdConfig.Side, String> V() {
                return this.f25628w;
            }

            public final String W() {
                return this.f25630y;
            }

            public final String X() {
                return this.f25629x;
            }

            public final Map<IdConfig.Side, String> Y() {
                return this.f25627v;
            }

            public final String Z() {
                return this.f25611f;
            }

            public final String a() {
                return this.F;
            }

            public final String a0() {
                return this.f25609e;
            }

            public final String b() {
                return this.E;
            }

            public final String b0() {
                return this.f25613h;
            }

            public final String c() {
                return this.W;
            }

            public final String c0() {
                return this.f25612g;
            }

            public final String d() {
                return this.V;
            }

            public final String d0() {
                return this.f25614i;
            }

            public final String e() {
                return this.U;
            }

            public final String e0() {
                return this.f25601a;
            }

            public final String f() {
                return this.T;
            }

            public final String g() {
                return this.f25619n;
            }

            public final String h() {
                return this.f25618m;
            }

            public final String i() {
                return this.K;
            }

            public final String j() {
                return this.L;
            }

            public final String k() {
                return this.J;
            }

            public final String l() {
                return this.I;
            }

            public final String m() {
                return this.f25617l;
            }

            public final String n() {
                return this.f25615j;
            }

            public final String o() {
                return this.f25605c;
            }

            public final Map<String, String> p() {
                return this.f25624s;
            }

            public final String q() {
                return this.f25625t;
            }

            public final Map<String, String> r() {
                return this.f25623r;
            }

            public final String s() {
                return this.f25626u;
            }

            public final String t() {
                return this.f25616k;
            }

            public final String u() {
                return this.D;
            }

            public final String v() {
                return this.C;
            }

            public final String w() {
                return this.B;
            }

            public final String x() {
                return this.A;
            }

            public final String y() {
                return this.f25631z;
            }

            public final String z() {
                return this.H;
            }
        }

        public a(String str, String str2, List<IdConfig> list, String str3, String str4, String str5, boolean z10, boolean z11, List<? extends CaptureOptionNativeMobile> list2, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, C0309a aVar, int i10, String str6, String str7, GovernmentIdPages governmentIdPages, long j10, PassportNfcConfig passportNfcConfig, boolean z12, Integer num, com.withpersona.sdk2.inquiry.governmentid.video_capture.a aVar2) {
            String str8 = str2;
            List<IdConfig> list3 = list;
            String str9 = str3;
            String str10 = str4;
            String str11 = str5;
            List<? extends CaptureOptionNativeMobile> list4 = list2;
            C0309a aVar3 = aVar;
            String str12 = str6;
            String str13 = str7;
            PassportNfcConfig passportNfcConfig2 = passportNfcConfig;
            com.withpersona.sdk2.inquiry.governmentid.video_capture.a aVar4 = aVar2;
            j.g(str, "sessionToken");
            j.g(str8, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
            j.g(list3, "enabledIdClasses");
            j.g(str9, "inquiryId");
            j.g(str10, "fromStep");
            j.g(str11, "fromComponent");
            j.g(list4, "enabledCaptureOptionsNativeMobile");
            j.g(aVar3, "strings");
            j.g(str12, "fieldKeyDocument");
            j.g(str13, "fieldKeyIdClass");
            j.g(passportNfcConfig2, "passportNfcConfig");
            j.g(aVar4, "videoCaptureConfig");
            this.f25581a = str;
            this.f25582b = str8;
            this.f25583c = list3;
            this.f25584d = str9;
            this.f25585e = str10;
            this.f25586f = str11;
            this.f25587g = z10;
            this.f25588h = z11;
            this.f25589i = list4;
            this.f25590j = stepStyles$GovernmentIdStepStyle;
            this.f25591k = aVar3;
            this.f25592l = i10;
            this.f25593m = str12;
            this.f25594n = str13;
            this.f25595o = governmentIdPages;
            this.f25596p = j10;
            this.f25597q = passportNfcConfig2;
            this.f25598r = z12;
            this.f25599s = num;
            this.f25600t = aVar4;
        }

        public final boolean a() {
            return this.f25587g;
        }

        public final boolean b() {
            return this.f25588h;
        }

        public final String c() {
            return this.f25582b;
        }

        public final List<CaptureOptionNativeMobile> d() {
            return this.f25589i;
        }

        public final List<IdConfig> e() {
            return this.f25583c;
        }

        public final String f() {
            return this.f25593m;
        }

        public final String g() {
            return this.f25594n;
        }

        public final String h() {
            return this.f25586f;
        }

        public final String i() {
            return this.f25585e;
        }

        public final boolean j() {
            return this.f25589i.size() > 1;
        }

        public final int k() {
            return this.f25592l;
        }

        public final String l() {
            return this.f25584d;
        }

        public final long m() {
            return this.f25596p;
        }

        public final GovernmentIdPages n() {
            return this.f25595o;
        }

        public final PassportNfcConfig o() {
            return this.f25597q;
        }

        public final String p() {
            return this.f25581a;
        }

        public final boolean q() {
            return this.f25598r;
        }

        public final C0309a r() {
            return this.f25591k;
        }

        public final StepStyles$GovernmentIdStepStyle s() {
            return this.f25590j;
        }

        public final Integer t() {
            return this.f25599s;
        }

        public final com.withpersona.sdk2.inquiry.governmentid.video_capture.a u() {
            return this.f25600t;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f25632a = new a();

            private a() {
                super((DefaultConstructorMarker) null);
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$b$b  reason: collision with other inner class name */
        public static final class C0310b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0310b f25633a = new C0310b();

            private C0310b() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f25634a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                j.g(internalErrorInfo, "cause");
                this.f25634a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f25634a;
            }
        }

        public static final class d extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final d f25635a = new d();

            private d() {
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
        public static final /* synthetic */ int[] f25636a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f25637b;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        static {
            /*
                com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig$PassportNfcOption[] r0 = com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig.PassportNfcOption.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig$PassportNfcOption r2 = com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig.PassportNfcOption.Optional     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig$PassportNfcOption r3 = com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig.PassportNfcOption.Required     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig$PassportNfcOption r4 = com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig.PassportNfcOption.RequiredIfSupported     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f25636a = r0
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side[] r0 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r4 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Front     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Back     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.FrontOrBack     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.BarcodePdf417     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.PassportSignature     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                f25637b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.c.<clinit>():void");
        }
    }

    public GovernmentIdWorkflow(Context context, ImageLoader imageLoader, SubmitVerificationWorker.a aVar, GovernmentIdAnalyzeWorker.a aVar2, DocumentSelectWorker documentSelectWorker, GovernmentIdHintWorker.b bVar, PermissionRequestWorkflow permissionRequestWorkflow, VideoCaptureRenderer videoCaptureRenderer, PassportNfcRenderer passportNfcRenderer) {
        j.g(context, "applicationContext");
        j.g(imageLoader, "imageLoader");
        j.g(aVar, "submitVerificationWorkerFactory");
        j.g(aVar2, "governmentIdAnalyzeWorkerFactory");
        j.g(documentSelectWorker, "documentSelectWorker");
        j.g(bVar, "governmentIdHintWorkerFactory");
        j.g(permissionRequestWorkflow, "permissionRequestWorkflow");
        j.g(videoCaptureRenderer, "videoCaptureRenderer");
        j.g(passportNfcRenderer, "passportNfcRenderer");
        this.f25506a = context;
        this.f25507b = imageLoader;
        this.f25508c = aVar;
        this.f25509d = aVar2;
        this.f25510e = documentSelectWorker;
        this.f25511f = bVar;
        this.f25512g = permissionRequestWorkflow;
        this.f25513h = videoCaptureRenderer;
        this.f25514i = passportNfcRenderer;
    }

    /* access modifiers changed from: private */
    public static final l<a, GovernmentIdState, b> A(GovernmentIdWorkflow governmentIdWorkflow, IdPart.SideIdPart sideIdPart, GovernmentIdState governmentIdState, String str, String str2) {
        return Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new GovernmentIdWorkflow$renderScreen$onFileSelected$1(governmentIdState, new GovernmentId.GovernmentIdImage(p.e(new Frame(str, (String) null, 2, (DefaultConstructorMarker) null)), governmentIdWorkflow.E(sideIdPart.a()), ((GovernmentIdState.ChooseCaptureMethod) governmentIdState).p().g1(), GovernmentId.CaptureMethod.f25320c, (RawExtraction) null, (GovernmentIdDetails) null, 32, (DefaultConstructorMarker) null), str2), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void B(a aVar, GovernmentIdWorkflow governmentIdWorkflow, h<? super a, GovernmentIdState, ? extends b, ? extends Object>.defpackage.a aVar2, GovernmentIdState governmentIdState, IdConfig idConfig, boolean z10, Boolean bool) {
        boolean z11;
        Boolean bool2;
        List<IdPart> list;
        PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage;
        a aVar3 = aVar;
        GovernmentIdWorkflow governmentIdWorkflow2 = governmentIdWorkflow;
        boolean z12 = z10;
        boolean z13 = false;
        if (!idConfig.e() || !f.a(aVar)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 && com.withpersona.sdk2.inquiry.nfc.a.f27071a.b(governmentIdWorkflow2.f25506a)) {
            z13 = true;
        }
        if (!z13 || bool != null) {
            GovernmentIdState governmentIdState2 = governmentIdState;
            IdConfig idConfig2 = idConfig;
            if (z11 && aVar.o().c() == PassportNfcConfig.PassportNfcOption.Required) {
                com.withpersona.sdk2.inquiry.nfc.a aVar4 = com.withpersona.sdk2.inquiry.nfc.a.f27071a;
                if (!aVar4.b(governmentIdWorkflow2.f25506a)) {
                    GovernmentIdPages n10 = aVar.n();
                    if (n10 != null) {
                        passportNfcNfcNotSupportedPage = n10.d();
                    } else {
                        passportNfcNfcNotSupportedPage = null;
                    }
                    if (passportNfcNfcNotSupportedPage != null) {
                        if (aVar4.c()) {
                            aVar2.c().d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new GovernmentIdWorkflow$renderScreen$selectIdClass$2(z12, aVar), 1, (Object) null));
                            return;
                        } else if (aVar.n().c() != null) {
                            aVar2.c().d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new GovernmentIdWorkflow$renderScreen$selectIdClass$3(z12, aVar), 1, (Object) null));
                            return;
                        } else {
                            aVar2.c().d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, GovernmentIdWorkflow$renderScreen$selectIdClass$4.f25641a, 1, (Object) null));
                            return;
                        }
                    }
                }
            }
            bool2 = bool;
        } else {
            int i10 = c.f25636a[aVar.o().c().ordinal()];
            if (i10 != 1) {
                if (i10 == 2 || i10 == 3) {
                    bool2 = Boolean.TRUE;
                } else {
                    bool2 = bool;
                }
                GovernmentIdState governmentIdState3 = governmentIdState;
                IdConfig idConfig3 = idConfig;
            } else {
                GovernmentIdState governmentIdState4 = governmentIdState;
                aVar2.c().d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new GovernmentIdWorkflow$renderScreen$selectIdClass$1(governmentIdState, z12, idConfig), 1, (Object) null));
                return;
            }
        }
        if (!z13 || !j.b(bool2, Boolean.TRUE)) {
            list = idConfig.c();
        } else {
            list = p.e(IdPart.PassportNfcPart.f25675a);
        }
        GovernmentIdWorkflowUtilsKt.i(governmentIdState, aVar2, aVar, (GovernmentId) null, idConfig, z10, list, 0, 128, (Object) null);
    }

    static /* synthetic */ void C(a aVar, GovernmentIdWorkflow governmentIdWorkflow, h.a aVar2, GovernmentIdState governmentIdState, IdConfig idConfig, boolean z10, Boolean bool, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if ((i10 & 64) != 0) {
            bool = null;
        }
        B(aVar, governmentIdWorkflow, aVar2, governmentIdState, idConfig, z11, bool);
    }

    /* access modifiers changed from: private */
    public final GovernmentId.Side E(IdConfig.Side side) {
        int i10 = c.f25637b[side.ordinal()];
        if (i10 == 1) {
            return GovernmentId.Side.FRONT;
        }
        if (i10 == 2) {
            return GovernmentId.Side.BACK;
        }
        if (i10 == 3) {
            return GovernmentId.Side.FRONT;
        }
        if (i10 == 4) {
            return GovernmentId.Side.BACK;
        }
        if (i10 == 5) {
            return GovernmentId.Side.BACK;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean F(GovernmentIdState governmentIdState) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21 = true;
        if (governmentIdState instanceof GovernmentIdState.CountdownToCapture) {
            z10 = true;
        } else {
            z10 = governmentIdState instanceof GovernmentIdState.WaitForAutocapture;
        }
        if (z10) {
            z11 = true;
        } else {
            z11 = governmentIdState instanceof GovernmentIdState.MrzScan;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = governmentIdState instanceof GovernmentIdState.FinalizeVideo;
        }
        if (z12) {
            return true;
        }
        if (governmentIdState instanceof GovernmentIdState.ChooseCaptureMethod) {
            z13 = true;
        } else {
            z13 = governmentIdState instanceof GovernmentIdState.PassportNfcConfirmDetails;
        }
        if (z13) {
            z14 = true;
        } else {
            z14 = governmentIdState instanceof GovernmentIdState.PassportNfcInstructions;
        }
        if (z14) {
            z15 = true;
        } else {
            z15 = governmentIdState instanceof GovernmentIdState.PassportNfcScan;
        }
        if (z15) {
            z16 = true;
        } else {
            z16 = governmentIdState instanceof GovernmentIdState.ReviewSelectedImage;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = governmentIdState instanceof GovernmentIdState.ShowInstructions;
        }
        if (z17) {
            z18 = true;
        } else {
            z18 = governmentIdState instanceof GovernmentIdState.Submit;
        }
        if (z18) {
            z19 = true;
        } else {
            z19 = governmentIdState instanceof GovernmentIdState.VerifyPassportDetails;
        }
        if (z19) {
            z20 = true;
        } else {
            z20 = governmentIdState instanceof GovernmentIdState.ReviewCapturedImage;
        }
        if (!z20) {
            z21 = governmentIdState instanceof GovernmentIdState.PassportNfcError;
        }
        if (z21) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final e G(Object obj, GovernmentIdState governmentIdState) {
        ScreenTransition screenTransition;
        if (governmentIdState.g()) {
            screenTransition = ScreenTransition.SLIDE_OUT;
        } else {
            screenTransition = ScreenTransition.SLIDE_IN;
        }
        return new e(obj, screenTransition);
    }

    private final d n(a aVar, IdConfig.Side side) {
        d dVar;
        String M;
        String L;
        String K;
        String J;
        String H;
        String G;
        String F;
        String E;
        String f10;
        String e10;
        String d10;
        String c10;
        int i10 = c.f25637b[side.ordinal()];
        if (i10 == 1) {
            String B = aVar.r().B();
            if (B == null || (M = aVar.r().M()) == null || (L = aVar.r().L()) == null || (K = aVar.r().K()) == null || (J = aVar.r().J()) == null) {
                return null;
            }
            dVar = new d(B, M, L, K, J);
        } else if (i10 == 2) {
            String B2 = aVar.r().B();
            if (B2 == null || (H = aVar.r().H()) == null || (G = aVar.r().G()) == null || (F = aVar.r().F()) == null || (E = aVar.r().E()) == null) {
                return null;
            }
            dVar = new d(B2, H, G, F, E);
        } else if (i10 == 3) {
            return null;
        } else {
            if (i10 == 4) {
                String B3 = aVar.r().B();
                if (B3 == null || (f10 = aVar.r().f()) == null || (e10 = aVar.r().e()) == null || (d10 = aVar.r().d()) == null || (c10 = aVar.r().c()) == null) {
                    return null;
                }
                dVar = new d(B3, f10, e10, d10, c10);
            } else if (i10 == 5) {
                return null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return dVar;
    }

    private final String o(a.C0309a aVar, IdConfig.Side side, String str) {
        Map<String, String> p10 = aVar.p();
        String str2 = p10.get(side.c() + SignatureVisitor.SUPER + str);
        if (str2 != null) {
            return str2;
        }
        String str3 = aVar.p().get(side.c());
        if (str3 != null) {
            return str3;
        }
        String string = this.f25506a.getString(o0.pi2_governmentid_choose_capture_method_body_default);
        j.f(string, "applicationContext.getSt…ture_method_body_default)");
        return string;
    }

    private final String p(a.C0309a aVar, IdConfig.Side side, String str) {
        Map<String, String> r10 = aVar.r();
        String str2 = r10.get(side.c() + SignatureVisitor.SUPER + str);
        if (str2 != null) {
            return str2;
        }
        String str3 = aVar.r().get(side.c());
        if (str3 != null) {
            return str3;
        }
        String string = this.f25506a.getString(o0.pi2_governmentid_choose_capture_method_title_default);
        j.f(string, "applicationContext.getSt…ure_method_title_default)");
        return string;
    }

    private final List<EnabledIdClass> q(a aVar) {
        List<IdConfig> e10 = aVar.e();
        ArrayList arrayList = new ArrayList(r.t(e10, 10));
        for (IdConfig idConfig : e10) {
            int a10 = idConfig.a();
            String str = aVar.r().I().get(idConfig.g1());
            if (str == null) {
                str = idConfig.g1();
            }
            arrayList.add(new EnabledIdClass(a10, idConfig, str));
        }
        return arrayList;
    }

    private final String r(a.C0309a aVar, IdConfig.Side side) {
        String str = aVar.V().get(side);
        if (str != null) {
            return str;
        }
        String string = this.f25506a.getString(o0.pi2_governmentid_review_selected_image_body_default);
        j.f(string, "applicationContext.getSt…ected_image_body_default)");
        return string;
    }

    private final String s(a.C0309a aVar, IdConfig.Side side) {
        String str = aVar.Y().get(side);
        if (str != null) {
            return str;
        }
        String string = this.f25506a.getString(o0.pi2_governmentid_review_selected_image_title_default);
        j.f(string, "applicationContext.getSt…cted_image_title_default)");
        return string;
    }

    private final String t(GovernmentIdState governmentIdState) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21 = true;
        if (governmentIdState instanceof GovernmentIdState.CountdownToCapture) {
            z10 = true;
        } else {
            z10 = governmentIdState instanceof GovernmentIdState.ReviewCapturedImage;
        }
        if (z10) {
            z11 = true;
        } else {
            z11 = governmentIdState instanceof GovernmentIdState.WaitForAutocapture;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = governmentIdState instanceof GovernmentIdState.FinalizeVideo;
        }
        if (z12) {
            return "camera_screen";
        }
        if (governmentIdState instanceof GovernmentIdState.ChooseCaptureMethod) {
            z13 = true;
        } else {
            z13 = governmentIdState instanceof GovernmentIdState.PassportNfcConfirmDetails;
        }
        if (z13) {
            z14 = true;
        } else {
            z14 = governmentIdState instanceof GovernmentIdState.PassportNfcInstructions;
        }
        if (z14) {
            z15 = true;
        } else {
            z15 = governmentIdState instanceof GovernmentIdState.PassportNfcScan;
        }
        if (z15) {
            z16 = true;
        } else {
            z16 = governmentIdState instanceof GovernmentIdState.ReviewSelectedImage;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = governmentIdState instanceof GovernmentIdState.ShowInstructions;
        }
        if (z17) {
            z18 = true;
        } else {
            z18 = governmentIdState instanceof GovernmentIdState.Submit;
        }
        if (z18) {
            z19 = true;
        } else {
            z19 = governmentIdState instanceof GovernmentIdState.VerifyPassportDetails;
        }
        if (z19) {
            z20 = true;
        } else {
            z20 = governmentIdState instanceof GovernmentIdState.MrzScan;
        }
        if (!z20) {
            z21 = governmentIdState instanceof GovernmentIdState.PassportNfcError;
        }
        if (z21) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String u(a.C0309a aVar, Hint hint) {
        if (j.b(hint, HoldStillHint.f25797a)) {
            return aVar.C();
        }
        if (j.b(hint, LowLightHint.f25798a)) {
            return aVar.D();
        }
        if (hint == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final com.squareup.workflow1.ui.h<Object> w(Object obj, String str) {
        return new com.squareup.workflow1.ui.h<>(obj, str);
    }

    private final Object y(a aVar, GovernmentIdState governmentIdState, h<? super a, GovernmentIdState, ? extends b, ? extends Object>.defpackage.a aVar2) {
        String str;
        com.withpersona.sdk2.inquiry.modal.b<Object, Object> bVar;
        String str2;
        a aVar3 = aVar;
        GovernmentIdState governmentIdState2 = governmentIdState;
        h<? super a, GovernmentIdState, ? extends b, ? extends Object>.defpackage.a aVar4 = aVar2;
        Class<GovernmentIdHintWorker> cls = GovernmentIdHintWorker.class;
        d0 d0Var = new d0(aVar4, this);
        PassportNfcPromptPage passportNfcPromptPage = null;
        if (governmentIdState2 instanceof GovernmentIdState.ShowInstructions) {
            aVar4.a("check_if_single_id_class", new GovernmentIdWorkflow$renderScreen$1(aVar, this, aVar2, governmentIdState, (kotlin.coroutines.c<? super GovernmentIdWorkflow$renderScreen$1>) null));
            GovernmentIdState.ShowInstructions showInstructions = (GovernmentIdState.ShowInstructions) governmentIdState2;
            Screen.InstructionsScreen instructionsScreen = new Screen.InstructionsScreen(aVar.r().e0(), aVar.r().U(), aVar.r().o(), aVar.r().N(), q(aVar), new GovernmentIdWorkflow$renderScreen$screen$1(aVar3, this, aVar4, governmentIdState2), aVar.a(), aVar.b(), aVar.s(), new GovernmentIdWorkflow$renderScreen$screen$2(aVar4), new GovernmentIdWorkflow$renderScreen$screen$3(aVar4), showInstructions.getError(), new GovernmentIdWorkflow$renderScreen$screen$4(aVar4, this, governmentIdState2));
            if (!showInstructions.p()) {
                return new com.withpersona.sdk2.inquiry.modal.b(instructionsScreen, q.j(), "passport_nfc_prompt");
            }
            IdConfig o10 = showInstructions.o();
            if (o10 != null) {
                GovernmentIdPages n10 = aVar.n();
                if (n10 != null) {
                    passportNfcPromptPage = n10.e();
                }
                if (passportNfcPromptPage != null) {
                    ArrayList arrayList = new ArrayList();
                    String J = passportNfcPromptPage.J();
                    if (J == null) {
                        str2 = "";
                    } else {
                        str2 = J;
                    }
                    String str3 = "";
                    GovernmentIdWorkflow$renderScreen$positiveButtonClick$1 governmentIdWorkflow$renderScreen$positiveButtonClick$1 = r0;
                    Screen.InstructionsScreen instructionsScreen2 = instructionsScreen;
                    GovernmentIdWorkflow$renderScreen$positiveButtonClick$1 governmentIdWorkflow$renderScreen$positiveButtonClick$12 = new GovernmentIdWorkflow$renderScreen$positiveButtonClick$1(o10, aVar, this, aVar2, governmentIdState);
                    arrayList.add(new Pair(str2, governmentIdWorkflow$renderScreen$positiveButtonClick$1));
                    String a10 = passportNfcPromptPage.a();
                    arrayList.add(new Pair(a10 == null ? str3 : a10, new GovernmentIdWorkflow$renderScreen$negativeButtonClick$1(o10, aVar, this, aVar2, governmentIdState)));
                    return com.withpersona.sdk2.inquiry.modal.c.a(m.i(m.f27597a, com.withpersona.sdk2.inquiry.steps.ui.b.a(passportNfcPromptPage), arrayList, new GovernmentIdWorkflow$renderScreen$2(aVar3, aVar4, this, governmentIdState2), (String) null, 8, (Object) null), instructionsScreen2, "passport_nfc_prompt");
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String str4 = "";
        if (governmentIdState2 instanceof GovernmentIdState.ChooseCaptureMethod) {
            GovernmentIdState.ChooseCaptureMethod chooseCaptureMethod = (GovernmentIdState.ChooseCaptureMethod) governmentIdState2;
            IdPart.SideIdPart o11 = chooseCaptureMethod.o();
            if (chooseCaptureMethod.n()) {
                o.l(aVar4, this.f25510e, kotlin.jvm.internal.l.k(DocumentSelectWorker.class), str4, new GovernmentIdWorkflow$renderScreen$3(this, o11, governmentIdState2));
            }
            return new ChooseCaptureMethodView(aVar.d(), p(aVar.r(), o11.a(), chooseCaptureMethod.p().g1()), o(aVar.r(), o11.a(), chooseCaptureMethod.p().g1()), aVar.r().q(), aVar.r().s(), new GovernmentIdWorkflow$renderScreen$4(aVar4, this, governmentIdState2, aVar3), new GovernmentIdWorkflow$renderScreen$5(aVar4, this, governmentIdState2), aVar.a(), new GovernmentIdWorkflow$renderScreen$6(aVar4), aVar.b(), new GovernmentIdWorkflow$renderScreen$7(aVar4), chooseCaptureMethod.getError(), new GovernmentIdWorkflow$renderScreen$8(aVar4, this, governmentIdState2), aVar.s());
        }
        String str5 = str4;
        if (governmentIdState2 instanceof GovernmentIdState.WaitForAutocapture) {
            GovernmentIdState.WaitForAutocapture waitForAutocapture = (GovernmentIdState.WaitForAutocapture) governmentIdState2;
            IdConfig.IdSideConfig d10 = waitForAutocapture.s().d(waitForAutocapture.p().a());
            o.l(aVar4, this.f25509d.a(waitForAutocapture.p().a(), waitForAutocapture.s().g1()), kotlin.jvm.internal.l.k(GovernmentIdAnalyzeWorker.class), str5, new GovernmentIdWorkflow$renderScreen$9(this, governmentIdState2));
            o.l(aVar4, this.f25511f.a(waitForAutocapture.p().a(), waitForAutocapture.s().g1()), kotlin.jvm.internal.l.k(cls), str5, new GovernmentIdWorkflow$renderScreen$10(this));
            if (d10.c().c()) {
                o.l(aVar4, j.a.b(com.squareup.workflow1.j.f23138a, j.d(d10.c().a(), 0), (String) null, 2, (Object) null), kotlin.jvm.internal.l.l(com.squareup.workflow1.j.class, KTypeProjection.f32152c.a(kotlin.jvm.internal.l.k(Unit.class))), str5, new GovernmentIdWorkflow$renderScreen$11(this, governmentIdState2));
            }
            ArrayList arrayList2 = new ArrayList();
            if (waitForAutocapture.q() != null) {
                Map f10 = g0.f(gk.h.a(AlertScreen.Button.POSITIVE, this.f25506a.getString(17039370)));
                String string = this.f25506a.getString(o0.pi2_error_image_capture_failed);
                kotlin.jvm.internal.j.f(string, "applicationContext.getSt…ror_image_capture_failed)");
                arrayList2.add(new AlertScreen(f10, string, (String) null, false, new GovernmentIdWorkflow$renderScreen$12(aVar4, this), 12, (DefaultConstructorMarker) null));
            }
            int i10 = c.f25637b[waitForAutocapture.p().a().ordinal()];
            if (i10 == 1) {
                str = aVar.r().a0();
            } else if (i10 == 2) {
                str = aVar.r().Z();
            } else if (i10 == 3) {
                str = aVar.r().b0();
            } else if (i10 == 4) {
                str = aVar.r().c0();
            } else if (i10 == 5) {
                str = aVar.r().d0();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            String m10 = aVar.r().m();
            IdConfig.Side a11 = waitForAutocapture.p().a();
            Screen.CameraScreen.ManualCapture t10 = waitForAutocapture.t();
            Screen.Overlay d11 = d10.d();
            boolean a12 = aVar.a();
            boolean b10 = aVar.b();
            List<AutoCaptureRule> a13 = d10.a().a().a();
            int h10 = governmentIdState.h();
            StepStyles$GovernmentIdStepStyle s10 = aVar.s();
            int k10 = aVar.k();
            Function1<Throwable, Unit> d12 = GovernmentIdWorkflowUtilsKt.d(aVar2);
            boolean b11 = aVar.u().b();
            long a14 = aVar.u().a();
            GovernmentIdState.WaitForAutocapture waitForAutocapture2 = (GovernmentIdState.WaitForAutocapture) governmentIdState2;
            String u10 = u(aVar.r(), waitForAutocapture2.r());
            d n11 = n(aVar3, waitForAutocapture2.p().a());
            GovernmentIdWorkflow$renderScreen$screen$5 governmentIdWorkflow$renderScreen$screen$5 = r3;
            GovernmentIdWorkflow$renderScreen$screen$5 governmentIdWorkflow$renderScreen$screen$52 = new GovernmentIdWorkflow$renderScreen$screen$5(this, governmentIdState2, aVar3, aVar4);
            GovernmentIdWorkflow$renderScreen$screen$6 governmentIdWorkflow$renderScreen$screen$6 = r3;
            GovernmentIdWorkflow$renderScreen$screen$6 governmentIdWorkflow$renderScreen$screen$62 = new GovernmentIdWorkflow$renderScreen$screen$6(d0Var);
            GovernmentIdWorkflow$renderScreen$screen$7 governmentIdWorkflow$renderScreen$screen$7 = r1;
            GovernmentIdWorkflow$renderScreen$screen$7 governmentIdWorkflow$renderScreen$screen$72 = new GovernmentIdWorkflow$renderScreen$screen$7(aVar4);
            GovernmentIdWorkflow$renderScreen$screen$8 governmentIdWorkflow$renderScreen$screen$8 = r1;
            GovernmentIdWorkflow$renderScreen$screen$8 governmentIdWorkflow$renderScreen$screen$82 = new GovernmentIdWorkflow$renderScreen$screen$8(aVar4, this);
            GovernmentIdWorkflow$renderScreen$screen$9 governmentIdWorkflow$renderScreen$screen$9 = r1;
            GovernmentIdWorkflow$renderScreen$screen$9 governmentIdWorkflow$renderScreen$screen$92 = new GovernmentIdWorkflow$renderScreen$screen$9(aVar4, this, governmentIdState2);
            GovernmentIdWorkflow$renderScreen$screen$10 governmentIdWorkflow$renderScreen$screen$10 = r1;
            GovernmentIdWorkflow$renderScreen$screen$10 governmentIdWorkflow$renderScreen$screen$102 = new GovernmentIdWorkflow$renderScreen$screen$10(this, aVar4, aVar3);
            Screen.CameraScreen cameraScreen = new Screen.CameraScreen(str, m10, a11, t10, d11, governmentIdWorkflow$renderScreen$screen$5, a12, b10, governmentIdWorkflow$renderScreen$screen$6, governmentIdWorkflow$renderScreen$screen$7, false, a13, h10, s10, (Function1) null, governmentIdWorkflow$renderScreen$screen$8, d12, k10, governmentIdWorkflow$renderScreen$screen$9, governmentIdWorkflow$renderScreen$screen$10, b11, false, (Function1) null, false, a14, false, u10, n11, 48250880, (DefaultConstructorMarker) null);
            if (waitForAutocapture2.o()) {
                bVar = GovernmentIdWorkflowUtilsKt.k(cameraScreen, this.f25506a, aVar2, aVar, true, this.f25512g);
            } else if (!waitForAutocapture2.n() || !aVar.u().b()) {
                bVar = com.withpersona.sdk2.inquiry.permissions.b.c(cameraScreen);
            } else {
                bVar = GovernmentIdWorkflowUtilsKt.j(cameraScreen, this.f25506a, aVar2, aVar, true, this.f25512g);
            }
            return new com.squareup.workflow1.ui.modal.c(bVar, arrayList2);
        } else if (governmentIdState2 instanceof GovernmentIdState.CountdownToCapture) {
            GovernmentIdState.CountdownToCapture countdownToCapture = (GovernmentIdState.CountdownToCapture) governmentIdState2;
            IdConfig.IdSideConfig d13 = countdownToCapture.p().d(countdownToCapture.n().a());
            o.l(aVar4, this.f25511f.a(countdownToCapture.n().a(), countdownToCapture.p().g1()), kotlin.jvm.internal.l.k(cls), str5, new GovernmentIdWorkflow$renderScreen$13(this));
            String n12 = aVar.r().n();
            String m11 = aVar.r().m();
            IdConfig.Side a15 = countdownToCapture.n().a();
            Screen.CameraScreen.ManualCapture manualCapture = Screen.CameraScreen.ManualCapture.Disabled;
            Screen.Overlay d14 = d13.d();
            boolean a16 = aVar.a();
            boolean b12 = aVar.b();
            List<AutoCaptureRule> a17 = d13.a().a().a();
            int h11 = governmentIdState.h();
            StepStyles$GovernmentIdStepStyle s11 = aVar.s();
            int k11 = aVar.k() - 1;
            Function1<Throwable, Unit> d15 = GovernmentIdWorkflowUtilsKt.d(aVar2);
            boolean b13 = aVar.u().b();
            long a18 = aVar.u().a();
            String u11 = u(aVar.r(), ((GovernmentIdState.CountdownToCapture) governmentIdState2).o());
            GovernmentIdWorkflow$renderScreen$14 governmentIdWorkflow$renderScreen$14 = r3;
            GovernmentIdWorkflow$renderScreen$14 governmentIdWorkflow$renderScreen$142 = new GovernmentIdWorkflow$renderScreen$14(d0Var);
            GovernmentIdWorkflow$renderScreen$15 governmentIdWorkflow$renderScreen$15 = r1;
            GovernmentIdWorkflow$renderScreen$15 governmentIdWorkflow$renderScreen$152 = new GovernmentIdWorkflow$renderScreen$15(aVar4);
            GovernmentIdWorkflow$renderScreen$16 governmentIdWorkflow$renderScreen$16 = r1;
            GovernmentIdWorkflow$renderScreen$16 governmentIdWorkflow$renderScreen$162 = new GovernmentIdWorkflow$renderScreen$16(governmentIdState2, aVar3, aVar4, this);
            GovernmentIdWorkflow$renderScreen$17 governmentIdWorkflow$renderScreen$17 = r1;
            GovernmentIdWorkflow$renderScreen$17 governmentIdWorkflow$renderScreen$172 = new GovernmentIdWorkflow$renderScreen$17(aVar4, this, governmentIdState2);
            GovernmentIdWorkflow$renderScreen$18 governmentIdWorkflow$renderScreen$18 = r1;
            GovernmentIdWorkflow$renderScreen$18 governmentIdWorkflow$renderScreen$182 = new GovernmentIdWorkflow$renderScreen$18(this, aVar4, aVar3);
            return new com.squareup.workflow1.ui.modal.c(com.withpersona.sdk2.inquiry.permissions.b.c(new Screen.CameraScreen(n12, m11, a15, manualCapture, d14, (Function1) null, a16, b12, governmentIdWorkflow$renderScreen$14, governmentIdWorkflow$renderScreen$15, true, a17, h11, s11, governmentIdWorkflow$renderScreen$16, governmentIdWorkflow$renderScreen$17, d15, k11, (Function0) null, governmentIdWorkflow$renderScreen$18, b13, false, (Function1) null, false, a18, false, u11, (d) null, 182714400, (DefaultConstructorMarker) null)), (List) null, 2, (DefaultConstructorMarker) null);
        } else if (governmentIdState2 instanceof GovernmentIdState.ReviewCapturedImage) {
            GovernmentIdState.ReviewCapturedImage reviewCapturedImage = (GovernmentIdState.ReviewCapturedImage) governmentIdState2;
            return new com.squareup.workflow1.ui.modal.c(com.withpersona.sdk2.inquiry.permissions.b.c(new Screen.a(this.f25507b, aVar.r().t(), aVar.r().m(), reviewCapturedImage.o().d(reviewCapturedImage.n().a()).d(), ((Frame) CollectionsKt___CollectionsKt.N(reviewCapturedImage.p().U1())).a(), new GovernmentIdWorkflow$renderScreen$19(governmentIdState2, aVar4, aVar3), aVar.r().h(), new GovernmentIdWorkflow$renderScreen$20(aVar4, this, governmentIdState2), aVar.r().g(), aVar.a(), aVar.b(), new GovernmentIdWorkflow$renderScreen$21(d0Var), aVar.s(), reviewCapturedImage.getError(), new GovernmentIdWorkflow$renderScreen$22(aVar4, this, governmentIdState2))), (List) null, 2, (DefaultConstructorMarker) null);
        } else if (governmentIdState2 instanceof GovernmentIdState.ReviewSelectedImage) {
            GovernmentIdState.ReviewSelectedImage reviewSelectedImage = (GovernmentIdState.ReviewSelectedImage) governmentIdState2;
            IdPart.SideIdPart n13 = reviewSelectedImage.n();
            ImageLoader imageLoader = this.f25507b;
            String s12 = s(aVar.r(), n13.a());
            String r10 = r(aVar.r(), n13.a());
            String X = aVar.r().X();
            String W = aVar.r().W();
            String a19 = ((Frame) CollectionsKt___CollectionsKt.N(reviewSelectedImage.q().U1())).a();
            String c10 = ((Frame) CollectionsKt___CollectionsKt.N(reviewSelectedImage.q().U1())).c();
            String o12 = reviewSelectedImage.o();
            boolean a20 = aVar.a();
            boolean b14 = aVar.b();
            String error = reviewSelectedImage.getError();
            StepStyles$GovernmentIdStepStyle s13 = aVar.s();
            GovernmentIdWorkflow$renderScreen$23 governmentIdWorkflow$renderScreen$23 = r1;
            GovernmentIdWorkflow$renderScreen$23 governmentIdWorkflow$renderScreen$232 = new GovernmentIdWorkflow$renderScreen$23(governmentIdState2, aVar4, aVar3);
            GovernmentIdWorkflow$renderScreen$24 governmentIdWorkflow$renderScreen$24 = r1;
            GovernmentIdWorkflow$renderScreen$24 governmentIdWorkflow$renderScreen$242 = new GovernmentIdWorkflow$renderScreen$24(aVar4);
            GovernmentIdWorkflow$renderScreen$25 governmentIdWorkflow$renderScreen$25 = r1;
            GovernmentIdWorkflow$renderScreen$25 governmentIdWorkflow$renderScreen$252 = new GovernmentIdWorkflow$renderScreen$25(aVar4);
            GovernmentIdWorkflow$renderScreen$26 governmentIdWorkflow$renderScreen$26 = r1;
            GovernmentIdWorkflow$renderScreen$26 governmentIdWorkflow$renderScreen$262 = new GovernmentIdWorkflow$renderScreen$26(aVar4);
            GovernmentIdWorkflow$renderScreen$27 governmentIdWorkflow$renderScreen$27 = r1;
            GovernmentIdWorkflow$renderScreen$27 governmentIdWorkflow$renderScreen$272 = new GovernmentIdWorkflow$renderScreen$27(aVar4, this, governmentIdState2);
            return new ReviewSelectedImageView(imageLoader, s12, r10, X, W, a19, c10, o12, governmentIdWorkflow$renderScreen$23, governmentIdWorkflow$renderScreen$24, a20, governmentIdWorkflow$renderScreen$25, b14, governmentIdWorkflow$renderScreen$26, error, governmentIdWorkflow$renderScreen$27, s13);
        } else if (governmentIdState2 instanceof GovernmentIdState.Submit) {
            GovernmentIdState.Submit submit = (GovernmentIdState.Submit) governmentIdState2;
            o.l(aVar4, this.f25508c.a(aVar.p(), aVar.l(), aVar.h(), aVar.i(), submit.m(), submit.n()), kotlin.jvm.internal.l.k(SubmitVerificationWorker.class), str5, new GovernmentIdWorkflow$renderScreen$28(this));
            return new Screen.b(aVar.r().T(), aVar.r().S(), aVar.s(), new GovernmentIdWorkflow$renderScreen$29(aVar4, this));
        } else if (governmentIdState2 instanceof GovernmentIdState.PassportNfcInstructions) {
            return this.f25514i.g(aVar3, (GovernmentIdState.PassportNfcInstructions) governmentIdState2, aVar4);
        } else {
            if (governmentIdState2 instanceof GovernmentIdState.MrzScan) {
                return this.f25514i.b(aVar3, (GovernmentIdState.MrzScan) governmentIdState2, aVar4);
            }
            if (governmentIdState2 instanceof GovernmentIdState.VerifyPassportDetails) {
                return this.f25514i.i(aVar3, (GovernmentIdState.VerifyPassportDetails) governmentIdState2, aVar4);
            }
            if (governmentIdState2 instanceof GovernmentIdState.PassportNfcScan) {
                return this.f25514i.h(aVar3, (GovernmentIdState.PassportNfcScan) governmentIdState2, aVar4);
            }
            if (governmentIdState2 instanceof GovernmentIdState.PassportNfcConfirmDetails) {
                return this.f25514i.e(aVar3, (GovernmentIdState.PassportNfcConfirmDetails) governmentIdState2, aVar4);
            }
            if (governmentIdState2 instanceof GovernmentIdState.PassportNfcError) {
                return this.f25514i.f(aVar3, (GovernmentIdState.PassportNfcError) governmentIdState2, aVar4);
            }
            if (governmentIdState2 instanceof GovernmentIdState.FinalizeVideo) {
                return this.f25513h.b(aVar3, (GovernmentIdState.FinalizeVideo) governmentIdState2, aVar4);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final void z(h.a aVar, GovernmentIdWorkflow governmentIdWorkflow, b bVar) {
        kotlin.jvm.internal.j.g(aVar, "$context");
        kotlin.jvm.internal.j.g(governmentIdWorkflow, "this$0");
        kotlin.jvm.internal.j.g(bVar, "it");
        aVar.c().d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new GovernmentIdWorkflow$renderScreen$sink$1$1(bVar), 1, (Object) null));
    }

    /* renamed from: D */
    public Snapshot g(GovernmentIdState governmentIdState) {
        kotlin.jvm.internal.j.g(governmentIdState, "state");
        return SnapshotParcelsKt.a(governmentIdState);
    }

    /* renamed from: v */
    public GovernmentIdState d(a aVar, Snapshot snapshot) {
        boolean z10;
        kotlin.jvm.internal.j.g(aVar, "props");
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
                kotlin.jvm.internal.j.f(obtain, "obtain()");
                byte[] N = b10.N();
                obtain.unmarshall(N, 0, N.length);
                obtain.setDataPosition(0);
                parcelable = obtain.readParcelable(Snapshot.class.getClassLoader());
                kotlin.jvm.internal.j.d(parcelable);
                kotlin.jvm.internal.j.f(parcelable, "parcel.readParcelable<T>…class.java.classLoader)!!");
                obtain.recycle();
            }
            GovernmentIdState governmentIdState = (GovernmentIdState) parcelable;
            if (governmentIdState != null) {
                return governmentIdState;
            }
        }
        return new GovernmentIdState.ShowInstructions((IdPart) null, (List) null, (List) null, (GovernmentIdState) null, 0, (IdConfig) null, false, (String) null, 255, (DefaultConstructorMarker) null);
    }

    /* renamed from: x */
    public Object f(a aVar, GovernmentIdState governmentIdState, h<? super a, GovernmentIdState, ? extends b, ? extends Object>.defpackage.a aVar2) {
        kotlin.jvm.internal.j.g(aVar, "renderProps");
        kotlin.jvm.internal.j.g(governmentIdState, "renderState");
        kotlin.jvm.internal.j.g(aVar2, IdentityHttpResponse.CONTEXT);
        Object y10 = y(aVar, governmentIdState, aVar2);
        String t10 = t(governmentIdState);
        if (t10 != null) {
            y10 = w(y10, t10);
        }
        if (!F(governmentIdState)) {
            aVar2.a("close_camera", new GovernmentIdWorkflow$render$2(this, (kotlin.coroutines.c<? super GovernmentIdWorkflow$render$2>) null));
        }
        return G(y10, governmentIdState);
    }

    public static abstract class Screen {

        public static final class InstructionsScreen extends Screen implements Parcelable {
            public static final Parcelable.Creator<InstructionsScreen> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f25544a;

            /* renamed from: b  reason: collision with root package name */
            private final String f25545b;

            /* renamed from: c  reason: collision with root package name */
            private final String f25546c;

            /* renamed from: d  reason: collision with root package name */
            private final String f25547d;

            /* renamed from: e  reason: collision with root package name */
            private final List<EnabledIdClass> f25548e;

            /* renamed from: f  reason: collision with root package name */
            private final Function1<IdConfig, Unit> f25549f;

            /* renamed from: g  reason: collision with root package name */
            private final boolean f25550g;

            /* renamed from: h  reason: collision with root package name */
            private final boolean f25551h;

            /* renamed from: j  reason: collision with root package name */
            private final StepStyles$GovernmentIdStepStyle f25552j;

            /* renamed from: k  reason: collision with root package name */
            private final Function0<Unit> f25553k;

            /* renamed from: l  reason: collision with root package name */
            private final Function0<Unit> f25554l;

            /* renamed from: m  reason: collision with root package name */
            private final String f25555m;

            /* renamed from: n  reason: collision with root package name */
            private final Function0<Unit> f25556n;

            public static final class a implements Parcelable.Creator<InstructionsScreen> {
                /* renamed from: a */
                public final InstructionsScreen createFromParcel(Parcel parcel) {
                    Parcel parcel2 = parcel;
                    kotlin.jvm.internal.j.g(parcel2, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList.add(EnabledIdClass.CREATOR.createFromParcel(parcel2));
                    }
                    return new InstructionsScreen(readString, readString2, readString3, readString4, arrayList, (Function1) parcel.readSerializable(), parcel.readInt() != 0, parcel.readInt() != 0, (StepStyles$GovernmentIdStepStyle) parcel2.readParcelable(InstructionsScreen.class.getClassLoader()), (Function0) parcel.readSerializable(), (Function0) parcel.readSerializable(), parcel.readString(), (Function0) parcel.readSerializable());
                }

                /* renamed from: b */
                public final InstructionsScreen[] newArray(int i10) {
                    return new InstructionsScreen[i10];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InstructionsScreen(String str, String str2, String str3, String str4, List<EnabledIdClass> list, Function1<? super IdConfig, Unit> function1, boolean z10, boolean z11, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, Function0<Unit> function0, Function0<Unit> function02, String str5, Function0<Unit> function03) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(str, "title");
                kotlin.jvm.internal.j.g(str2, "prompt");
                kotlin.jvm.internal.j.g(str3, "chooseText");
                kotlin.jvm.internal.j.g(str4, "disclaimer");
                kotlin.jvm.internal.j.g(list, "enabledIdClasses");
                kotlin.jvm.internal.j.g(function1, "selectIdClass");
                kotlin.jvm.internal.j.g(function0, "onBack");
                kotlin.jvm.internal.j.g(function02, "onCancel");
                kotlin.jvm.internal.j.g(function03, "onErrorDismissed");
                this.f25544a = str;
                this.f25545b = str2;
                this.f25546c = str3;
                this.f25547d = str4;
                this.f25548e = list;
                this.f25549f = function1;
                this.f25550g = z10;
                this.f25551h = z11;
                this.f25552j = stepStyles$GovernmentIdStepStyle;
                this.f25553k = function0;
                this.f25554l = function02;
                this.f25555m = str5;
                this.f25556n = function03;
            }

            public final boolean a() {
                return this.f25550g;
            }

            public final boolean c() {
                return this.f25551h;
            }

            public final String d() {
                return this.f25546c;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f25547d;
            }

            public final List<EnabledIdClass> f() {
                return this.f25548e;
            }

            public final Function0<Unit> g() {
                return this.f25553k;
            }

            public final String getError() {
                return this.f25555m;
            }

            public final Function0<Unit> h() {
                return this.f25554l;
            }

            public final Function0<Unit> i() {
                return this.f25556n;
            }

            public final String j() {
                return this.f25545b;
            }

            public final Function1<IdConfig, Unit> k() {
                return this.f25549f;
            }

            public final StepStyles$GovernmentIdStepStyle l() {
                return this.f25552j;
            }

            public final String m() {
                return this.f25544a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                kotlin.jvm.internal.j.g(parcel, "out");
                parcel.writeString(this.f25544a);
                parcel.writeString(this.f25545b);
                parcel.writeString(this.f25546c);
                parcel.writeString(this.f25547d);
                List<EnabledIdClass> list = this.f25548e;
                parcel.writeInt(list.size());
                for (EnabledIdClass writeToParcel : list) {
                    writeToParcel.writeToParcel(parcel, i10);
                }
                parcel.writeSerializable((Serializable) this.f25549f);
                parcel.writeInt(this.f25550g ? 1 : 0);
                parcel.writeInt(this.f25551h ? 1 : 0);
                parcel.writeParcelable(this.f25552j, i10);
                parcel.writeSerializable((Serializable) this.f25553k);
                parcel.writeSerializable((Serializable) this.f25554l);
                parcel.writeString(this.f25555m);
                parcel.writeSerializable((Serializable) this.f25556n);
            }
        }

        public static abstract class Overlay implements Parcelable {

            public static final class Barcode extends Overlay {
                public static final Parcelable.Creator<Barcode> CREATOR = new a();

                /* renamed from: a  reason: collision with root package name */
                public static final Barcode f25557a = new Barcode();

                public static final class a implements Parcelable.Creator<Barcode> {
                    /* renamed from: a */
                    public final Barcode createFromParcel(Parcel parcel) {
                        kotlin.jvm.internal.j.g(parcel, "parcel");
                        parcel.readInt();
                        return Barcode.f25557a;
                    }

                    /* renamed from: b */
                    public final Barcode[] newArray(int i10) {
                        return new Barcode[i10];
                    }
                }

                private Barcode() {
                    super((DefaultConstructorMarker) null);
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    kotlin.jvm.internal.j.g(parcel, "out");
                    parcel.writeInt(1);
                }
            }

            public static final class Custom extends Overlay {
                public static final Parcelable.Creator<Custom> CREATOR = new a();

                /* renamed from: a  reason: collision with root package name */
                private final UiComponent.RemoteImage f25558a;

                public static final class a implements Parcelable.Creator<Custom> {
                    /* renamed from: a */
                    public final Custom createFromParcel(Parcel parcel) {
                        kotlin.jvm.internal.j.g(parcel, "parcel");
                        return new Custom((UiComponent.RemoteImage) parcel.readParcelable(Custom.class.getClassLoader()));
                    }

                    /* renamed from: b */
                    public final Custom[] newArray(int i10) {
                        return new Custom[i10];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Custom(UiComponent.RemoteImage remoteImage) {
                    super((DefaultConstructorMarker) null);
                    kotlin.jvm.internal.j.g(remoteImage, "customImage");
                    this.f25558a = remoteImage;
                }

                public final UiComponent.RemoteImage a() {
                    return this.f25558a;
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    kotlin.jvm.internal.j.g(parcel, "out");
                    parcel.writeParcelable(this.f25558a, i10);
                }
            }

            public static final class GenericFront extends Overlay {
                public static final Parcelable.Creator<GenericFront> CREATOR = new a();

                /* renamed from: a  reason: collision with root package name */
                public static final GenericFront f25559a = new GenericFront();

                public static final class a implements Parcelable.Creator<GenericFront> {
                    /* renamed from: a */
                    public final GenericFront createFromParcel(Parcel parcel) {
                        kotlin.jvm.internal.j.g(parcel, "parcel");
                        parcel.readInt();
                        return GenericFront.f25559a;
                    }

                    /* renamed from: b */
                    public final GenericFront[] newArray(int i10) {
                        return new GenericFront[i10];
                    }
                }

                private GenericFront() {
                    super((DefaultConstructorMarker) null);
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    kotlin.jvm.internal.j.g(parcel, "out");
                    parcel.writeInt(1);
                }
            }

            public static final class Passport extends Overlay {
                public static final Parcelable.Creator<Passport> CREATOR = new a();

                /* renamed from: a  reason: collision with root package name */
                public static final Passport f25560a = new Passport();

                public static final class a implements Parcelable.Creator<Passport> {
                    /* renamed from: a */
                    public final Passport createFromParcel(Parcel parcel) {
                        kotlin.jvm.internal.j.g(parcel, "parcel");
                        parcel.readInt();
                        return Passport.f25560a;
                    }

                    /* renamed from: b */
                    public final Passport[] newArray(int i10) {
                        return new Passport[i10];
                    }
                }

                private Passport() {
                    super((DefaultConstructorMarker) null);
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    kotlin.jvm.internal.j.g(parcel, "out");
                    parcel.writeInt(1);
                }
            }

            public static final class Rectangle extends Overlay {
                public static final Parcelable.Creator<Rectangle> CREATOR = new a();

                /* renamed from: a  reason: collision with root package name */
                public static final Rectangle f25561a = new Rectangle();

                public static final class a implements Parcelable.Creator<Rectangle> {
                    /* renamed from: a */
                    public final Rectangle createFromParcel(Parcel parcel) {
                        kotlin.jvm.internal.j.g(parcel, "parcel");
                        parcel.readInt();
                        return Rectangle.f25561a;
                    }

                    /* renamed from: b */
                    public final Rectangle[] newArray(int i10) {
                        return new Rectangle[i10];
                    }
                }

                private Rectangle() {
                    super((DefaultConstructorMarker) null);
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    kotlin.jvm.internal.j.g(parcel, "out");
                    parcel.writeInt(1);
                }
            }

            private Overlay() {
            }

            public /* synthetic */ Overlay(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class a extends Screen {

            /* renamed from: a  reason: collision with root package name */
            private final ImageLoader f25562a;

            /* renamed from: b  reason: collision with root package name */
            private final String f25563b;

            /* renamed from: c  reason: collision with root package name */
            private final String f25564c;

            /* renamed from: d  reason: collision with root package name */
            private final Overlay f25565d;

            /* renamed from: e  reason: collision with root package name */
            private final String f25566e;

            /* renamed from: f  reason: collision with root package name */
            private final Function0<Unit> f25567f;

            /* renamed from: g  reason: collision with root package name */
            private final String f25568g;

            /* renamed from: h  reason: collision with root package name */
            private final Function0<Unit> f25569h;

            /* renamed from: j  reason: collision with root package name */
            private final String f25570j;

            /* renamed from: k  reason: collision with root package name */
            private final boolean f25571k;

            /* renamed from: l  reason: collision with root package name */
            private final boolean f25572l;

            /* renamed from: m  reason: collision with root package name */
            private final Function0<Unit> f25573m;

            /* renamed from: n  reason: collision with root package name */
            private final StepStyles$GovernmentIdStepStyle f25574n;

            /* renamed from: p  reason: collision with root package name */
            private final String f25575p;

            /* renamed from: q  reason: collision with root package name */
            private final Function0<Unit> f25576q;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ImageLoader imageLoader, String str, String str2, Overlay overlay, String str3, Function0<Unit> function0, String str4, Function0<Unit> function02, String str5, boolean z10, boolean z11, Function0<Unit> function03, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, String str6, Function0<Unit> function04) {
                super((DefaultConstructorMarker) null);
                String str7 = str2;
                Overlay overlay2 = overlay;
                String str8 = str3;
                Function0<Unit> function05 = function0;
                String str9 = str4;
                Function0<Unit> function06 = function02;
                String str10 = str5;
                Function0<Unit> function07 = function03;
                Function0<Unit> function08 = function04;
                kotlin.jvm.internal.j.g(imageLoader, "imageLoader");
                kotlin.jvm.internal.j.g(str, "message");
                kotlin.jvm.internal.j.g(str7, "disclaimer");
                kotlin.jvm.internal.j.g(overlay2, "overlay");
                kotlin.jvm.internal.j.g(str8, "imagePath");
                kotlin.jvm.internal.j.g(function05, "acceptImage");
                kotlin.jvm.internal.j.g(str9, "acceptText");
                kotlin.jvm.internal.j.g(function06, "retryImage");
                kotlin.jvm.internal.j.g(str10, "retryText");
                kotlin.jvm.internal.j.g(function07, Close.ELEMENT);
                kotlin.jvm.internal.j.g(function08, "onErrorDismissed");
                this.f25562a = imageLoader;
                this.f25563b = str;
                this.f25564c = str7;
                this.f25565d = overlay2;
                this.f25566e = str8;
                this.f25567f = function05;
                this.f25568g = str9;
                this.f25569h = function06;
                this.f25570j = str10;
                this.f25571k = z10;
                this.f25572l = z11;
                this.f25573m = function07;
                this.f25574n = stepStyles$GovernmentIdStepStyle;
                this.f25575p = str6;
                this.f25576q = function08;
            }

            public final Function0<Unit> a() {
                return this.f25567f;
            }

            public final String c() {
                return this.f25568g;
            }

            public final boolean d() {
                return this.f25571k;
            }

            public final boolean e() {
                return this.f25572l;
            }

            public final Function0<Unit> f() {
                return this.f25573m;
            }

            public final String g() {
                return this.f25564c;
            }

            public final String getError() {
                return this.f25575p;
            }

            public final ImageLoader h() {
                return this.f25562a;
            }

            public final String i() {
                return this.f25566e;
            }

            public final String j() {
                return this.f25563b;
            }

            public final Function0<Unit> k() {
                return this.f25576q;
            }

            public final Overlay l() {
                return this.f25565d;
            }

            public final Function0<Unit> m() {
                return this.f25569h;
            }

            public final String n() {
                return this.f25570j;
            }

            public final StepStyles$GovernmentIdStepStyle o() {
                return this.f25574n;
            }
        }

        public static final class b extends Screen {

            /* renamed from: a  reason: collision with root package name */
            private final String f25577a;

            /* renamed from: b  reason: collision with root package name */
            private final String f25578b;

            /* renamed from: c  reason: collision with root package name */
            private final StepStyle f25579c;

            /* renamed from: d  reason: collision with root package name */
            private final Function0<Unit> f25580d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, String str2, StepStyle stepStyle, Function0<Unit> function0) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(str, "title");
                kotlin.jvm.internal.j.g(str2, "description");
                kotlin.jvm.internal.j.g(function0, "onBack");
                this.f25577a = str;
                this.f25578b = str2;
                this.f25579c = stepStyle;
                this.f25580d = function0;
            }

            public final String a() {
                return this.f25578b;
            }

            public final Function0<Unit> c() {
                return this.f25580d;
            }

            public final StepStyle d() {
                return this.f25579c;
            }

            public final String e() {
                return this.f25577a;
            }
        }

        private Screen() {
        }

        public /* synthetic */ Screen(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final class CameraScreen extends Screen {
            private final boolean B;
            private final boolean C;
            private final Function1<File, Unit> D;
            private final boolean E;
            private final long F;
            private final boolean G;
            private final String H;
            private final d I;

            /* renamed from: a  reason: collision with root package name */
            private final String f25515a;

            /* renamed from: b  reason: collision with root package name */
            private final String f25516b;

            /* renamed from: c  reason: collision with root package name */
            private final IdConfig.Side f25517c;

            /* renamed from: d  reason: collision with root package name */
            private final ManualCapture f25518d;

            /* renamed from: e  reason: collision with root package name */
            private final Overlay f25519e;

            /* renamed from: f  reason: collision with root package name */
            private final Function1<List<String>, Unit> f25520f;

            /* renamed from: g  reason: collision with root package name */
            private final boolean f25521g;

            /* renamed from: h  reason: collision with root package name */
            private final boolean f25522h;

            /* renamed from: j  reason: collision with root package name */
            private final Function0<Unit> f25523j;

            /* renamed from: k  reason: collision with root package name */
            private final Function0<Unit> f25524k;

            /* renamed from: l  reason: collision with root package name */
            private final boolean f25525l;

            /* renamed from: m  reason: collision with root package name */
            private final List<AutoCaptureRule> f25526m;

            /* renamed from: n  reason: collision with root package name */
            private final int f25527n;

            /* renamed from: p  reason: collision with root package name */
            private final StepStyles$GovernmentIdStepStyle f25528p;

            /* renamed from: q  reason: collision with root package name */
            private final Function1<List<String>, Unit> f25529q;

            /* renamed from: t  reason: collision with root package name */
            private final Function1<Throwable, Unit> f25530t;

            /* renamed from: w  reason: collision with root package name */
            private final Function1<Throwable, Unit> f25531w;

            /* renamed from: x  reason: collision with root package name */
            private final int f25532x;

            /* renamed from: y  reason: collision with root package name */
            private final Function0<Unit> f25533y;

            /* renamed from: z  reason: collision with root package name */
            private final Function0<Unit> f25534z;

            public enum ManualCapture {
                Disabled,
                Enabled,
                Hidden
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ CameraScreen(java.lang.String r33, java.lang.String r34, com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side r35, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture r36, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.Overlay r37, kotlin.jvm.functions.Function1 r38, boolean r39, boolean r40, kotlin.jvm.functions.Function0 r41, kotlin.jvm.functions.Function0 r42, boolean r43, java.util.List r44, int r45, com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle r46, kotlin.jvm.functions.Function1 r47, kotlin.jvm.functions.Function1 r48, kotlin.jvm.functions.Function1 r49, int r50, kotlin.jvm.functions.Function0 r51, kotlin.jvm.functions.Function0 r52, boolean r53, boolean r54, kotlin.jvm.functions.Function1 r55, boolean r56, long r57, boolean r59, java.lang.String r60, com.withpersona.sdk2.inquiry.governmentid.capture_tips.d r61, int r62, kotlin.jvm.internal.DefaultConstructorMarker r63) {
                /*
                    r32 = this;
                    r0 = r62
                    r1 = r0 & 32
                    if (r1 == 0) goto L_0x000a
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$1 r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.AnonymousClass1.f25535a
                    r8 = r1
                    goto L_0x000c
                L_0x000a:
                    r8 = r38
                L_0x000c:
                    r1 = r0 & 16384(0x4000, float:2.2959E-41)
                    if (r1 == 0) goto L_0x0015
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$2 r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.AnonymousClass2.f25536a
                    r17 = r1
                    goto L_0x0017
                L_0x0015:
                    r17 = r47
                L_0x0017:
                    r1 = 32768(0x8000, float:4.5918E-41)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x0022
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$3 r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.AnonymousClass3.f25537a
                    r18 = r1
                    goto L_0x0024
                L_0x0022:
                    r18 = r48
                L_0x0024:
                    r1 = 262144(0x40000, float:3.67342E-40)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x002e
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$4 r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.AnonymousClass4.f25538a
                    r21 = r1
                    goto L_0x0030
                L_0x002e:
                    r21 = r51
                L_0x0030:
                    r1 = 2097152(0x200000, float:2.938736E-39)
                    r1 = r1 & r0
                    r2 = 0
                    if (r1 == 0) goto L_0x0039
                    r24 = r2
                    goto L_0x003b
                L_0x0039:
                    r24 = r54
                L_0x003b:
                    r1 = 4194304(0x400000, float:5.877472E-39)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x0045
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$5 r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.AnonymousClass5.f25539a
                    r25 = r1
                    goto L_0x0047
                L_0x0045:
                    r25 = r55
                L_0x0047:
                    r1 = 8388608(0x800000, float:1.17549435E-38)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x0050
                    r1 = 1
                    r26 = r1
                    goto L_0x0052
                L_0x0050:
                    r26 = r56
                L_0x0052:
                    r1 = 33554432(0x2000000, float:9.403955E-38)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x005a
                    r29 = r2
                    goto L_0x005c
                L_0x005a:
                    r29 = r59
                L_0x005c:
                    r1 = 67108864(0x4000000, float:1.5046328E-36)
                    r1 = r1 & r0
                    r2 = 0
                    if (r1 == 0) goto L_0x0065
                    r30 = r2
                    goto L_0x0067
                L_0x0065:
                    r30 = r60
                L_0x0067:
                    r1 = 134217728(0x8000000, float:3.85186E-34)
                    r0 = r0 & r1
                    if (r0 == 0) goto L_0x006f
                    r31 = r2
                    goto L_0x0071
                L_0x006f:
                    r31 = r61
                L_0x0071:
                    r2 = r32
                    r3 = r33
                    r4 = r34
                    r5 = r35
                    r6 = r36
                    r7 = r37
                    r9 = r39
                    r10 = r40
                    r11 = r41
                    r12 = r42
                    r13 = r43
                    r14 = r44
                    r15 = r45
                    r16 = r46
                    r19 = r49
                    r20 = r50
                    r22 = r52
                    r23 = r53
                    r27 = r57
                    r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.<init>(java.lang.String, java.lang.String, com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$Overlay, kotlin.jvm.functions.Function1, boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, java.util.List, int, com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, boolean, kotlin.jvm.functions.Function1, boolean, long, boolean, java.lang.String, com.withpersona.sdk2.inquiry.governmentid.capture_tips.d, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final Overlay A() {
                return this.f25519e;
            }

            public final int B() {
                return this.f25532x;
            }

            public final boolean D() {
                return this.G;
            }

            public final StepStyles$GovernmentIdStepStyle E() {
                return this.f25528p;
            }

            public final boolean F() {
                return this.B;
            }

            public final Function1<List<String>, Unit> a() {
                return this.f25529q;
            }

            public final List<AutoCaptureRule> c() {
                return this.f25526m;
            }

            public final int d() {
                return this.f25527n;
            }

            public final IdConfig.Side e() {
                return this.f25517c;
            }

            public final boolean f() {
                return this.f25525l;
            }

            public final Function0<Unit> g() {
                return this.f25524k;
            }

            public final boolean h() {
                return this.f25521g;
            }

            public final boolean i() {
                return this.f25522h;
            }

            public final ManualCapture j() {
                return this.f25518d;
            }

            public final d k() {
                return this.I;
            }

            public final Function0<Unit> l() {
                return this.f25534z;
            }

            public final Function0<Unit> m() {
                return this.f25523j;
            }

            public final String n() {
                return this.f25516b;
            }

            public final boolean o() {
                return this.E;
            }

            public final boolean p() {
                return this.C;
            }

            public final String q() {
                return this.H;
            }

            public final Function0<Unit> r() {
                return this.f25533y;
            }

            public final Function1<List<String>, Unit> s() {
                return this.f25520f;
            }

            public final long t() {
                return this.F;
            }

            public final String u() {
                return this.f25515a;
            }

            public final Function1<Throwable, Unit> w() {
                return this.f25531w;
            }

            public final Function1<Throwable, Unit> x() {
                return this.f25530t;
            }

            public final Function1<File, Unit> z() {
                return this.D;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CameraScreen(String str, String str2, IdConfig.Side side, ManualCapture manualCapture, Overlay overlay, Function1<? super List<String>, Unit> function1, boolean z10, boolean z11, Function0<Unit> function0, Function0<Unit> function02, boolean z12, List<? extends AutoCaptureRule> list, int i10, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, Function1<? super List<String>, Unit> function12, Function1<? super Throwable, Unit> function13, Function1<? super Throwable, Unit> function14, int i11, Function0<Unit> function03, Function0<Unit> function04, boolean z13, boolean z14, Function1<? super File, Unit> function15, boolean z15, long j10, boolean z16, String str3, d dVar) {
                super((DefaultConstructorMarker) null);
                String str4 = str;
                String str5 = str2;
                IdConfig.Side side2 = side;
                ManualCapture manualCapture2 = manualCapture;
                Overlay overlay2 = overlay;
                Function1<? super List<String>, Unit> function16 = function1;
                Function0<Unit> function05 = function0;
                Function0<Unit> function06 = function02;
                List<? extends AutoCaptureRule> list2 = list;
                Function1<? super List<String>, Unit> function17 = function12;
                Function1<? super Throwable, Unit> function18 = function13;
                Function1<? super Throwable, Unit> function19 = function14;
                Function0<Unit> function07 = function03;
                Function0<Unit> function08 = function04;
                kotlin.jvm.internal.j.g(str4, "message");
                kotlin.jvm.internal.j.g(str5, "disclaimer");
                kotlin.jvm.internal.j.g(side2, "autoCaptureSide");
                kotlin.jvm.internal.j.g(manualCapture2, "captureButtonState");
                kotlin.jvm.internal.j.g(overlay2, "overlay");
                kotlin.jvm.internal.j.g(function16, "manuallyCapture");
                kotlin.jvm.internal.j.g(function05, Close.ELEMENT);
                kotlin.jvm.internal.j.g(function06, "back");
                kotlin.jvm.internal.j.g(list2, "autoCaptureRules");
                kotlin.jvm.internal.j.g(function17, "autoCapture");
                kotlin.jvm.internal.j.g(function18, "onCaptureError");
                kotlin.jvm.internal.j.g(function19, "onCameraError");
                kotlin.jvm.internal.j.g(function07, "manualCaptureClicked");
                kotlin.jvm.internal.j.g(function08, "checkPermissions");
                kotlin.jvm.internal.j.g(function15, "onVideoFinalized");
                this.f25515a = str4;
                this.f25516b = str5;
                this.f25517c = side2;
                this.f25518d = manualCapture2;
                this.f25519e = overlay2;
                this.f25520f = function16;
                this.f25521g = z10;
                this.f25522h = z11;
                this.f25523j = function05;
                this.f25524k = function06;
                this.f25525l = z12;
                this.f25526m = list2;
                this.f25527n = i10;
                this.f25528p = stepStyles$GovernmentIdStepStyle;
                this.f25529q = function17;
                this.f25530t = function18;
                this.f25531w = function19;
                this.f25532x = i11;
                this.f25533y = function07;
                this.f25534z = function08;
                this.B = z13;
                this.C = z14;
                this.D = function15;
                this.E = z15;
                this.F = j10;
                this.G = z16;
                this.H = str3;
                this.I = dVar;
            }
        }
    }
}
