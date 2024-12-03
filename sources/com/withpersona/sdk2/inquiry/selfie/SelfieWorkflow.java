package com.withpersona.sdk2.inquiry.selfie;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.h;
import com.squareup.workflow1.j;
import com.squareup.workflow1.o;
import com.squareup.workflow1.ui.SnapshotParcelsKt;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.permissions.Permission;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker;
import com.withpersona.sdk2.inquiry.selfie.video_capture.VideoCaptureRenderer;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import java.io.File;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import kotlin.reflect.KTypeProjection;
import okio.ByteString;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;

public final class SelfieWorkflow extends h<b, SelfieState, c, Object> {

    /* renamed from: g  reason: collision with root package name */
    public static final a f27274g = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f27275a;

    /* renamed from: b  reason: collision with root package name */
    private final SubmitVerificationWorker.a f27276b;

    /* renamed from: c  reason: collision with root package name */
    private final SelfieAnalyzeWorker.b f27277c;

    /* renamed from: d  reason: collision with root package name */
    private final SelfieDetectWorker f27278d;

    /* renamed from: e  reason: collision with root package name */
    private final PermissionRequestWorkflow f27279e;

    /* renamed from: f  reason: collision with root package name */
    private final VideoCaptureRenderer f27280f;

    public static abstract class Screen {

        public static final class CameraScreen extends Screen {

            /* renamed from: a  reason: collision with root package name */
            private final String f27281a;

            /* renamed from: b  reason: collision with root package name */
            private final a f27282b;

            /* renamed from: c  reason: collision with root package name */
            private final StepStyles$SelfieStepStyle f27283c;

            /* renamed from: d  reason: collision with root package name */
            private final Function0<Unit> f27284d;

            /* renamed from: e  reason: collision with root package name */
            private final Function1<Throwable, Unit> f27285e;

            /* renamed from: f  reason: collision with root package name */
            private final Function0<Unit> f27286f;

            /* renamed from: g  reason: collision with root package name */
            private final boolean f27287g;

            public enum Overlay {
                CLEAR,
                CENTER,
                CENTER_COMPLETE,
                LOOK_LEFT_HINT,
                LOOK_LEFT,
                LOOK_LEFT_COMPLETE,
                LOOK_RIGHT_HINT,
                LOOK_RIGHT,
                LOOK_RIGHT_COMPLETE,
                FINALIZING,
                COMPLETE_WITH_CAPTURE,
                COMPLETE
            }

            public static abstract class a {

                /* renamed from: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$a  reason: collision with other inner class name */
                public static final class C0328a extends a {

                    /* renamed from: a  reason: collision with root package name */
                    private final Overlay f27301a;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public C0328a(Overlay overlay) {
                        super((DefaultConstructorMarker) null);
                        j.g(overlay, "overlay");
                        this.f27301a = overlay;
                    }

                    public Overlay a() {
                        return this.f27301a;
                    }
                }

                public static final class b extends a {

                    /* renamed from: a  reason: collision with root package name */
                    private final int f27302a;

                    /* renamed from: b  reason: collision with root package name */
                    private final boolean f27303b;

                    /* renamed from: c  reason: collision with root package name */
                    private final long f27304c;

                    /* renamed from: d  reason: collision with root package name */
                    private final Overlay f27305d;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public b(int i10, boolean z10, long j10, Overlay overlay) {
                        super((DefaultConstructorMarker) null);
                        j.g(overlay, "overlay");
                        this.f27302a = i10;
                        this.f27303b = z10;
                        this.f27304c = j10;
                        this.f27305d = overlay;
                    }

                    public Overlay a() {
                        return this.f27305d;
                    }

                    public final int b() {
                        return this.f27302a;
                    }

                    public final long c() {
                        return this.f27304c;
                    }

                    public final boolean d() {
                        return this.f27303b;
                    }
                }

                public static final class c extends a {

                    /* renamed from: a  reason: collision with root package name */
                    private final Function1<File, Unit> f27306a;

                    /* renamed from: b  reason: collision with root package name */
                    private final Function0<Unit> f27307b;

                    /* renamed from: c  reason: collision with root package name */
                    private final boolean f27308c;

                    /* renamed from: d  reason: collision with root package name */
                    private final Overlay f27309d;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public c(Function1<? super File, Unit> function1, Function0<Unit> function0, boolean z10, Overlay overlay) {
                        super((DefaultConstructorMarker) null);
                        j.g(function1, "finalizeVideo");
                        j.g(function0, "onAnimationComplete");
                        j.g(overlay, "overlay");
                        this.f27306a = function1;
                        this.f27307b = function0;
                        this.f27308c = z10;
                        this.f27309d = overlay;
                    }

                    public Overlay a() {
                        return this.f27309d;
                    }

                    public final Function1<File, Unit> b() {
                        return this.f27306a;
                    }

                    public final Function0<Unit> c() {
                        return this.f27307b;
                    }

                    public final boolean d() {
                        return this.f27308c;
                    }
                }

                public static final class d extends a {

                    /* renamed from: a  reason: collision with root package name */
                    private final Function1<String, Unit> f27310a;

                    /* renamed from: b  reason: collision with root package name */
                    private final boolean f27311b;

                    /* renamed from: c  reason: collision with root package name */
                    private final Overlay f27312c;

                    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                    public /* synthetic */ d(Function1 function1, boolean z10, Overlay overlay, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                        this(function1, (i10 & 2) != 0 ? false : z10, overlay);
                    }

                    public Overlay a() {
                        return this.f27312c;
                    }

                    public final boolean b() {
                        return this.f27311b;
                    }

                    public final Function1<String, Unit> c() {
                        return this.f27310a;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public d(Function1<? super String, Unit> function1, boolean z10, Overlay overlay) {
                        super((DefaultConstructorMarker) null);
                        j.g(function1, "processImage");
                        j.g(overlay, "overlay");
                        this.f27310a = function1;
                        this.f27311b = z10;
                        this.f27312c = overlay;
                    }
                }

                public static final class e extends a {

                    /* renamed from: a  reason: collision with root package name */
                    private final Function0<Unit> f27313a;

                    /* renamed from: b  reason: collision with root package name */
                    private final Overlay f27314b;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public e(Function0<Unit> function0, Overlay overlay) {
                        super((DefaultConstructorMarker) null);
                        j.g(function0, "onCaptureClicked");
                        j.g(overlay, "overlay");
                        this.f27313a = function0;
                        this.f27314b = overlay;
                    }

                    public Overlay a() {
                        return this.f27314b;
                    }

                    public final Function0<Unit> b() {
                        return this.f27313a;
                    }
                }

                public static final class f extends a {

                    /* renamed from: a  reason: collision with root package name */
                    private final Function0<Unit> f27315a;

                    /* renamed from: b  reason: collision with root package name */
                    private final Overlay f27316b;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public f(Function0<Unit> function0, Overlay overlay) {
                        super((DefaultConstructorMarker) null);
                        j.g(function0, "poseHintComplete");
                        j.g(overlay, "overlay");
                        this.f27315a = function0;
                        this.f27316b = overlay;
                    }

                    public Overlay a() {
                        return this.f27316b;
                    }

                    public final Function0<Unit> b() {
                        return this.f27315a;
                    }
                }

                public static final class g extends a {

                    /* renamed from: a  reason: collision with root package name */
                    private final Function0<Unit> f27317a;

                    /* renamed from: b  reason: collision with root package name */
                    private final Overlay f27318b;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public g(Function0<Unit> function0, Overlay overlay) {
                        super((DefaultConstructorMarker) null);
                        j.g(function0, "previewReady");
                        j.g(overlay, "overlay");
                        this.f27317a = function0;
                        this.f27318b = overlay;
                    }

                    public Overlay a() {
                        return this.f27318b;
                    }

                    public final Function0<Unit> b() {
                        return this.f27317a;
                    }
                }

                public static final class h extends a {

                    /* renamed from: a  reason: collision with root package name */
                    private final Function0<Unit> f27319a;

                    /* renamed from: b  reason: collision with root package name */
                    private final boolean f27320b;

                    /* renamed from: c  reason: collision with root package name */
                    private final Overlay f27321c;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public h(Function0<Unit> function0, boolean z10, Overlay overlay) {
                        super((DefaultConstructorMarker) null);
                        j.g(function0, "onComplete");
                        j.g(overlay, "overlay");
                        this.f27319a = function0;
                        this.f27320b = z10;
                        this.f27321c = overlay;
                    }

                    public Overlay a() {
                        return this.f27321c;
                    }

                    public final boolean b() {
                        return this.f27320b;
                    }

                    public final Function0<Unit> c() {
                        return this.f27319a;
                    }
                }

                private a() {
                }

                public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public abstract Overlay a();
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CameraScreen(String str, a aVar, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle, Function0<Unit> function0, Function1<? super Throwable, Unit> function1, Function0<Unit> function02, boolean z10) {
                super((DefaultConstructorMarker) null);
                j.g(aVar, JingleS5BTransport.ATTR_MODE);
                j.g(function0, "cancel");
                j.g(function1, "onCameraError");
                j.g(function02, "onPermissionChanged");
                this.f27281a = str;
                this.f27282b = aVar;
                this.f27283c = stepStyles$SelfieStepStyle;
                this.f27284d = function0;
                this.f27285e = function1;
                this.f27286f = function02;
                this.f27287g = z10;
            }

            public final Function0<Unit> a() {
                return this.f27284d;
            }

            public final String b() {
                return this.f27281a;
            }

            public final a c() {
                return this.f27282b;
            }

            public final Function1<Throwable, Unit> d() {
                return this.f27285e;
            }

            public final Function0<Unit> e() {
                return this.f27286f;
            }

            public final StepStyles$SelfieStepStyle f() {
                return this.f27283c;
            }

            public final boolean g() {
                return this.f27287g;
            }
        }

        public static final class a extends Screen {

            /* renamed from: a  reason: collision with root package name */
            private final String f27322a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27323b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27324c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27325d;

            /* renamed from: e  reason: collision with root package name */
            private final StepStyles$SelfieStepStyle f27326e;

            /* renamed from: f  reason: collision with root package name */
            private final Function0<Unit> f27327f;

            /* renamed from: g  reason: collision with root package name */
            private final Function0<Unit> f27328g;

            /* renamed from: h  reason: collision with root package name */
            private final Function0<Unit> f27329h;

            /* renamed from: i  reason: collision with root package name */
            private final boolean f27330i;

            /* renamed from: j  reason: collision with root package name */
            private final boolean f27331j;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, String str3, String str4, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, boolean z10, boolean z11) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "prompt");
                j.g(str3, "disclosure");
                j.g(str4, "start");
                j.g(function0, "onClick");
                j.g(function02, "onBack");
                j.g(function03, "onCancel");
                this.f27322a = str;
                this.f27323b = str2;
                this.f27324c = str3;
                this.f27325d = str4;
                this.f27326e = stepStyles$SelfieStepStyle;
                this.f27327f = function0;
                this.f27328g = function02;
                this.f27329h = function03;
                this.f27330i = z10;
                this.f27331j = z11;
            }

            public final boolean a() {
                return this.f27330i;
            }

            public final boolean b() {
                return this.f27331j;
            }

            public final String c() {
                return this.f27324c;
            }

            public final Function0<Unit> d() {
                return this.f27328g;
            }

            public final Function0<Unit> e() {
                return this.f27329h;
            }

            public final Function0<Unit> f() {
                return this.f27327f;
            }

            public final String g() {
                return this.f27323b;
            }

            public final String h() {
                return this.f27325d;
            }

            public final StepStyles$SelfieStepStyle i() {
                return this.f27326e;
            }

            public final String j() {
                return this.f27322a;
            }
        }

        public static final class b extends Screen {

            /* renamed from: a  reason: collision with root package name */
            private final String f27332a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27333b;

            /* renamed from: c  reason: collision with root package name */
            private final StepStyle f27334c;

            /* renamed from: d  reason: collision with root package name */
            private final Function0<Unit> f27335d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, String str2, StepStyle stepStyle, Function0<Unit> function0) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "description");
                j.g(function0, "onBack");
                this.f27332a = str;
                this.f27333b = str2;
                this.f27334c = stepStyle;
                this.f27335d = function0;
            }

            public final String a() {
                return this.f27333b;
            }

            public final Function0<Unit> b() {
                return this.f27335d;
            }

            public final StepStyle c() {
                return this.f27334c;
            }

            public final String d() {
                return this.f27332a;
            }
        }

        private Screen() {
        }

        public /* synthetic */ Screen(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f27336a;

        /* renamed from: b  reason: collision with root package name */
        private final String f27337b;

        /* renamed from: c  reason: collision with root package name */
        private final String f27338c;

        /* renamed from: d  reason: collision with root package name */
        private final String f27339d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f27340e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27341f;

        /* renamed from: g  reason: collision with root package name */
        private final String f27342g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f27343h;

        /* renamed from: i  reason: collision with root package name */
        private final a f27344i;

        /* renamed from: j  reason: collision with root package name */
        private final v f27345j;

        /* renamed from: k  reason: collision with root package name */
        private final String f27346k;

        /* renamed from: l  reason: collision with root package name */
        private final String f27347l;

        /* renamed from: m  reason: collision with root package name */
        private final String f27348m;

        /* renamed from: n  reason: collision with root package name */
        private final String f27349n;

        /* renamed from: o  reason: collision with root package name */
        private final String f27350o;

        /* renamed from: p  reason: collision with root package name */
        private final String f27351p;

        /* renamed from: q  reason: collision with root package name */
        private final String f27352q;

        /* renamed from: r  reason: collision with root package name */
        private final String f27353r;

        /* renamed from: s  reason: collision with root package name */
        private final StepStyles$SelfieStepStyle f27354s;

        /* renamed from: t  reason: collision with root package name */
        private final com.withpersona.sdk2.inquiry.selfie.video_capture.a f27355t;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private final String f27356a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27357b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27358c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27359d;

            /* renamed from: e  reason: collision with root package name */
            private final String f27360e;

            /* renamed from: f  reason: collision with root package name */
            private final String f27361f;

            /* renamed from: g  reason: collision with root package name */
            private final String f27362g;

            /* renamed from: h  reason: collision with root package name */
            private final String f27363h;

            /* renamed from: i  reason: collision with root package name */
            private final String f27364i;

            /* renamed from: j  reason: collision with root package name */
            private final String f27365j;

            /* renamed from: k  reason: collision with root package name */
            private final String f27366k;

            /* renamed from: l  reason: collision with root package name */
            private final String f27367l;

            /* renamed from: m  reason: collision with root package name */
            private final String f27368m;

            public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
                j.g(str, "title");
                j.g(str2, "prompt");
                j.g(str3, "disclosure");
                j.g(str4, "startButton");
                j.g(str5, "selfieHintTakePhoto");
                j.g(str6, "selfieHintCenterFace");
                j.g(str7, "selfieHintFaceTooClose");
                j.g(str8, "selfieHintPoseNotCenter");
                j.g(str9, "selfieHintLookLeft");
                j.g(str10, "selfieHintLookRight");
                j.g(str11, "selfieHintHoldStill");
                j.g(str12, "processingTitle");
                j.g(str13, "processingDescription");
                this.f27356a = str;
                this.f27357b = str2;
                this.f27358c = str3;
                this.f27359d = str4;
                this.f27360e = str5;
                this.f27361f = str6;
                this.f27362g = str7;
                this.f27363h = str8;
                this.f27364i = str9;
                this.f27365j = str10;
                this.f27366k = str11;
                this.f27367l = str12;
                this.f27368m = str13;
            }

            public final String a() {
                return this.f27358c;
            }

            public final String b() {
                return this.f27368m;
            }

            public final String c() {
                return this.f27367l;
            }

            public final String d() {
                return this.f27357b;
            }

            public final String e() {
                return this.f27361f;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return j.b(this.f27356a, aVar.f27356a) && j.b(this.f27357b, aVar.f27357b) && j.b(this.f27358c, aVar.f27358c) && j.b(this.f27359d, aVar.f27359d) && j.b(this.f27360e, aVar.f27360e) && j.b(this.f27361f, aVar.f27361f) && j.b(this.f27362g, aVar.f27362g) && j.b(this.f27363h, aVar.f27363h) && j.b(this.f27364i, aVar.f27364i) && j.b(this.f27365j, aVar.f27365j) && j.b(this.f27366k, aVar.f27366k) && j.b(this.f27367l, aVar.f27367l) && j.b(this.f27368m, aVar.f27368m);
            }

            public final String f() {
                return this.f27362g;
            }

            public final String g() {
                return this.f27366k;
            }

            public final String h() {
                return this.f27364i;
            }

            public int hashCode() {
                return (((((((((((((((((((((((this.f27356a.hashCode() * 31) + this.f27357b.hashCode()) * 31) + this.f27358c.hashCode()) * 31) + this.f27359d.hashCode()) * 31) + this.f27360e.hashCode()) * 31) + this.f27361f.hashCode()) * 31) + this.f27362g.hashCode()) * 31) + this.f27363h.hashCode()) * 31) + this.f27364i.hashCode()) * 31) + this.f27365j.hashCode()) * 31) + this.f27366k.hashCode()) * 31) + this.f27367l.hashCode()) * 31) + this.f27368m.hashCode();
            }

            public final String i() {
                return this.f27365j;
            }

            public final String j() {
                return this.f27363h;
            }

            public final String k() {
                return this.f27360e;
            }

            public final String l() {
                return this.f27359d;
            }

            public final String m() {
                return this.f27356a;
            }

            public String toString() {
                return "Strings(title=" + this.f27356a + ", prompt=" + this.f27357b + ", disclosure=" + this.f27358c + ", startButton=" + this.f27359d + ", selfieHintTakePhoto=" + this.f27360e + ", selfieHintCenterFace=" + this.f27361f + ", selfieHintFaceTooClose=" + this.f27362g + ", selfieHintPoseNotCenter=" + this.f27363h + ", selfieHintLookLeft=" + this.f27364i + ", selfieHintLookRight=" + this.f27365j + ", selfieHintHoldStill=" + this.f27366k + ", processingTitle=" + this.f27367l + ", processingDescription=" + this.f27368m + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public b(String str, String str2, String str3, String str4, boolean z10, boolean z11, String str5, boolean z12, a aVar, v vVar, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle, com.withpersona.sdk2.inquiry.selfie.video_capture.a aVar2) {
            String str14 = str5;
            a aVar3 = aVar;
            v vVar2 = vVar;
            com.withpersona.sdk2.inquiry.selfie.video_capture.a aVar4 = aVar2;
            j.g(str, "sessionToken");
            j.g(str2, "inquiryId");
            j.g(str3, "fromComponent");
            j.g(str4, "fromStep");
            j.g(str14, "fieldKeySelfie");
            j.g(aVar3, "strings");
            j.g(vVar2, "selfieType");
            j.g(aVar4, "videoCaptureConfig");
            this.f27336a = str;
            this.f27337b = str2;
            this.f27338c = str3;
            this.f27339d = str4;
            this.f27340e = z10;
            this.f27341f = z11;
            this.f27342g = str14;
            this.f27343h = z12;
            this.f27344i = aVar3;
            this.f27345j = vVar2;
            this.f27346k = str6;
            this.f27347l = str7;
            this.f27348m = str8;
            this.f27349n = str9;
            this.f27350o = str10;
            this.f27351p = str11;
            this.f27352q = str12;
            this.f27353r = str13;
            this.f27354s = stepStyles$SelfieStepStyle;
            this.f27355t = aVar4;
        }

        public final boolean a() {
            return this.f27340e;
        }

        public final String b() {
            return this.f27349n;
        }

        public final String c() {
            return this.f27348m;
        }

        public final String d() {
            return this.f27347l;
        }

        public final String e() {
            return this.f27346k;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return j.b(this.f27336a, bVar.f27336a) && j.b(this.f27337b, bVar.f27337b) && j.b(this.f27338c, bVar.f27338c) && j.b(this.f27339d, bVar.f27339d) && this.f27340e == bVar.f27340e && this.f27341f == bVar.f27341f && j.b(this.f27342g, bVar.f27342g) && this.f27343h == bVar.f27343h && j.b(this.f27344i, bVar.f27344i) && j.b(this.f27345j, bVar.f27345j) && j.b(this.f27346k, bVar.f27346k) && j.b(this.f27347l, bVar.f27347l) && j.b(this.f27348m, bVar.f27348m) && j.b(this.f27349n, bVar.f27349n) && j.b(this.f27350o, bVar.f27350o) && j.b(this.f27351p, bVar.f27351p) && j.b(this.f27352q, bVar.f27352q) && j.b(this.f27353r, bVar.f27353r) && j.b(this.f27354s, bVar.f27354s) && j.b(this.f27355t, bVar.f27355t);
        }

        public final boolean f() {
            return this.f27341f;
        }

        public final String g() {
            return this.f27342g;
        }

        public final String h() {
            return this.f27338c;
        }

        public int hashCode() {
            int hashCode = ((((((this.f27336a.hashCode() * 31) + this.f27337b.hashCode()) * 31) + this.f27338c.hashCode()) * 31) + this.f27339d.hashCode()) * 31;
            boolean z10 = this.f27340e;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int i10 = (hashCode + (z10 ? 1 : 0)) * 31;
            boolean z12 = this.f27341f;
            if (z12) {
                z12 = true;
            }
            int hashCode2 = (((i10 + (z12 ? 1 : 0)) * 31) + this.f27342g.hashCode()) * 31;
            boolean z13 = this.f27343h;
            if (!z13) {
                z11 = z13;
            }
            int hashCode3 = (((((hashCode2 + (z11 ? 1 : 0)) * 31) + this.f27344i.hashCode()) * 31) + this.f27345j.hashCode()) * 31;
            String str = this.f27346k;
            int i11 = 0;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f27347l;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f27348m;
            int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f27349n;
            int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f27350o;
            int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f27351p;
            int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.f27352q;
            int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.f27353r;
            int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
            StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle = this.f27354s;
            if (stepStyles$SelfieStepStyle != null) {
                i11 = stepStyles$SelfieStepStyle.hashCode();
            }
            return ((hashCode11 + i11) * 31) + this.f27355t.hashCode();
        }

        public final String i() {
            return this.f27339d;
        }

        public final String j() {
            return this.f27337b;
        }

        public final String k() {
            return this.f27353r;
        }

        public final String l() {
            return this.f27352q;
        }

        public final String m() {
            return this.f27351p;
        }

        public final String n() {
            return this.f27350o;
        }

        public final v o() {
            return this.f27345j;
        }

        public final String p() {
            return this.f27336a;
        }

        public final boolean q() {
            return this.f27343h;
        }

        public final a r() {
            return this.f27344i;
        }

        public final StepStyles$SelfieStepStyle s() {
            return this.f27354s;
        }

        public final com.withpersona.sdk2.inquiry.selfie.video_capture.a t() {
            return this.f27355t;
        }

        public String toString() {
            return "Input(sessionToken=" + this.f27336a + ", inquiryId=" + this.f27337b + ", fromComponent=" + this.f27338c + ", fromStep=" + this.f27339d + ", backStepEnabled=" + this.f27340e + ", cancelButtonEnabled=" + this.f27341f + ", fieldKeySelfie=" + this.f27342g + ", skipPromptPage=" + this.f27343h + ", strings=" + this.f27344i + ", selfieType=" + this.f27345j + ", cameraPermissionsTitle=" + this.f27346k + ", cameraPermissionsRationale=" + this.f27347l + ", cameraPermissionsModalPositiveButton=" + this.f27348m + ", cameraPermissionsModalNegativeButton=" + this.f27349n + ", microphonePermissionsTitle=" + this.f27350o + ", microphonePermissionsRationale=" + this.f27351p + ", microphonePermissionsModalPositiveButton=" + this.f27352q + ", microphonePermissionsModalNegativeButton=" + this.f27353r + ", styles=" + this.f27354s + ", videoCaptureConfig=" + this.f27355t + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final a f27369a = new a();

            private a() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class b extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final b f27370a = new b();

            private b() {
                super((DefaultConstructorMarker) null);
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$c$c  reason: collision with other inner class name */
        public static final class C0329c extends c {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f27371a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0329c(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                j.g(internalErrorInfo, "cause");
                this.f27371a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f27371a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0329c) && j.b(this.f27371a, ((C0329c) obj).f27371a);
            }

            public int hashCode() {
                return this.f27371a.hashCode();
            }

            public String toString() {
                return "Error(cause=" + this.f27371a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static final class d extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final d f27372a = new d();

            private d() {
                super((DefaultConstructorMarker) null);
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27373a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f27374b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f27375c;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|19|20|21|22|23|24|25|26|27|28|29|30|31|33) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|27|28|29|30|31|33) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        static {
            /*
                com.withpersona.sdk2.inquiry.selfie.Selfie$Direction[] r0 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r2 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r3 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r4 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.CENTER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f27373a = r0
                com.withpersona.sdk2.inquiry.selfie.SelfieHintDirection[] r0 = com.withpersona.sdk2.inquiry.selfie.SelfieHintDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.selfie.SelfieHintDirection r4 = com.withpersona.sdk2.inquiry.selfie.SelfieHintDirection.LEFT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.withpersona.sdk2.inquiry.selfie.SelfieHintDirection r4 = com.withpersona.sdk2.inquiry.selfie.SelfieHintDirection.RIGHT     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                f27374b = r0
                com.withpersona.sdk2.inquiry.selfie.SelfieError[] r0 = com.withpersona.sdk2.inquiry.selfie.SelfieError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.selfie.SelfieError r4 = com.withpersona.sdk2.inquiry.selfie.SelfieError.FaceNotCentered     // Catch:{ NoSuchFieldError -> 0x004c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.withpersona.sdk2.inquiry.selfie.SelfieError r1 = com.withpersona.sdk2.inquiry.selfie.SelfieError.FaceTooClose     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.withpersona.sdk2.inquiry.selfie.SelfieError r1 = com.withpersona.sdk2.inquiry.selfie.SelfieError.FaceNotFound     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                com.withpersona.sdk2.inquiry.selfie.SelfieError r1 = com.withpersona.sdk2.inquiry.selfie.SelfieError.IncorrectPose     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                com.withpersona.sdk2.inquiry.selfie.SelfieError r1 = com.withpersona.sdk2.inquiry.selfie.SelfieError.FaceDetectionUnsupported     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.withpersona.sdk2.inquiry.selfie.SelfieError r1 = com.withpersona.sdk2.inquiry.selfie.SelfieError.Other     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                f27375c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.d.<clinit>():void");
        }
    }

    public SelfieWorkflow(Context context, SubmitVerificationWorker.a aVar, SelfieAnalyzeWorker.b bVar, SelfieDetectWorker selfieDetectWorker, PermissionRequestWorkflow permissionRequestWorkflow, VideoCaptureRenderer videoCaptureRenderer) {
        j.g(context, "applicationContext");
        j.g(aVar, "submitVerificationWorker");
        j.g(bVar, "selfieAnalyzeWorker");
        j.g(selfieDetectWorker, "selfieDetectWorker");
        j.g(permissionRequestWorkflow, "permissionRequestWorkflow");
        j.g(videoCaptureRenderer, "videoCaptureRenderer");
        this.f27275a = context;
        this.f27276b = aVar;
        this.f27277c = bVar;
        this.f27278d = selfieDetectWorker;
        this.f27279e = permissionRequestWorkflow;
        this.f27280f = videoCaptureRenderer;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieState$FinalizeVideoCapture} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieState$Submit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieState$ShowPoseHint} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieState$FinalizeVideoCapture} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieState$FinalizeVideoCapture} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieState$FinalizeVideoCapture} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.withpersona.sdk2.inquiry.selfie.SelfieState & com.withpersona.sdk2.inquiry.selfie.e> com.withpersona.sdk2.inquiry.selfie.SelfieState.CaptureTransition k(T r11, com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.b r12, com.withpersona.sdk2.inquiry.selfie.Selfie r13) {
        /*
            r10 = this;
            com.withpersona.sdk2.inquiry.selfie.SelfieState$CaptureTransition r0 = new com.withpersona.sdk2.inquiry.selfie.SelfieState$CaptureTransition
            r1 = r11
            com.withpersona.sdk2.inquiry.selfie.e r1 = (com.withpersona.sdk2.inquiry.selfie.e) r1
            java.util.List r2 = r1.f()
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L_0x002c
            com.withpersona.sdk2.inquiry.selfie.SelfieState$ShowPoseHint r12 = new com.withpersona.sdk2.inquiry.selfie.SelfieState$ShowPoseHint
            java.util.List r2 = r11.g()
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.i0(r2, r13)
            com.withpersona.sdk2.inquiry.selfie.e r11 = (com.withpersona.sdk2.inquiry.selfie.e) r11
            java.util.List r2 = r11.f()
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.G(r2, r3)
            boolean r11 = r11.a()
            r12.<init>(r13, r2, r11)
            goto L_0x0059
        L_0x002c:
            com.withpersona.sdk2.inquiry.selfie.video_capture.a r12 = r12.t()
            boolean r12 = r12.b()
            if (r12 == 0) goto L_0x004c
            com.withpersona.sdk2.inquiry.selfie.SelfieState$FinalizeVideoCapture r12 = new com.withpersona.sdk2.inquiry.selfie.SelfieState$FinalizeVideoCapture
            java.util.List r11 = r11.g()
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.i0(r11, r13)
            r4 = 3000(0xbb8, double:1.482E-320)
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            r2 = r12
            r2.<init>(r3, r4, r6, r7, r8, r9)
            goto L_0x0059
        L_0x004c:
            com.withpersona.sdk2.inquiry.selfie.SelfieState$Submit r12 = new com.withpersona.sdk2.inquiry.selfie.SelfieState$Submit
            java.util.List r11 = r11.g()
            java.util.List r11 = kotlin.collections.CollectionsKt___CollectionsKt.i0(r11, r13)
            r12.<init>(r11)
        L_0x0059:
            com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r11 = r1.c()
            r0.<init>(r12, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.k(com.withpersona.sdk2.inquiry.selfie.SelfieState, com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$b, com.withpersona.sdk2.inquiry.selfie.Selfie):com.withpersona.sdk2.inquiry.selfie.SelfieState$CaptureTransition");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen m(com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.b r12, com.withpersona.sdk2.inquiry.selfie.SelfieState.Capture r13, com.squareup.workflow1.h<? super com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.b, com.withpersona.sdk2.inquiry.selfie.SelfieState, ? extends com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.c, ? extends java.lang.Object>.defpackage.a r14) {
        /*
            r11 = this;
            java.util.List r0 = r13.f()
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.N(r0)
            r2 = r0
            com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r2 = (com.withpersona.sdk2.inquiry.selfie.Selfie.Direction) r2
            com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$b r0 = r11.f27277c
            com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker r0 = r0.a(r2)
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCapture$1 r1 = new com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCapture$1
            r1.<init>(r11, r13, r12)
            java.lang.Class<com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker> r3 = com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker.class
            wk.m r3 = kotlin.jvm.internal.l.k(r3)
            java.lang.String r4 = ""
            com.squareup.workflow1.o.l(r14, r0, r3, r4, r1)
            com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r0 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.LEFT
            if (r2 != r0) goto L_0x002e
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$b$a r0 = r12.r()
            java.lang.String r0 = r0.h()
            goto L_0x005c
        L_0x002e:
            com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r0 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.RIGHT
            if (r2 != r0) goto L_0x003b
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$b$a r0 = r12.r()
            java.lang.String r0 = r0.i()
            goto L_0x005c
        L_0x003b:
            com.withpersona.sdk2.inquiry.selfie.SelfieError r0 = r13.j()
            if (r0 == 0) goto L_0x004e
            com.withpersona.sdk2.inquiry.selfie.SelfieError r0 = r13.j()
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$b$a r1 = r12.r()
            java.lang.String r0 = r11.y(r0, r1)
            goto L_0x005c
        L_0x004e:
            com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r0 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.CENTER
            if (r2 != r0) goto L_0x005b
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$b$a r0 = r12.r()
            java.lang.String r0 = r0.e()
            goto L_0x005c
        L_0x005b:
            r0 = 0
        L_0x005c:
            int[] r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.d.f27373a
            int r3 = r2.ordinal()
            r1 = r1[r3]
            r3 = 1
            if (r1 == r3) goto L_0x0079
            r3 = 2
            if (r1 == r3) goto L_0x0076
            r3 = 3
            if (r1 != r3) goto L_0x0070
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.CENTER
            goto L_0x007b
        L_0x0070:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        L_0x0076:
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.LOOK_RIGHT
            goto L_0x007b
        L_0x0079:
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.LOOK_LEFT
        L_0x007b:
            r7 = r1
            boolean r1 = r13.e()
            if (r1 == 0) goto L_0x009b
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$d r9 = new com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$d
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCapture$mode$1 r8 = new com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCapture$mode$1
            r1 = r8
            r3 = r14
            r4 = r11
            r5 = r13
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            r5 = 0
            r1 = 2
            r2 = 0
            r3 = r9
            r4 = r8
            r6 = r7
            r7 = r1
            r8 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            r5 = r9
            goto L_0x00a1
        L_0x009b:
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$a r1 = new com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$a
            r1.<init>(r7)
            r5 = r1
        L_0x00a1:
            boolean r13 = r13.e()
            if (r13 != 0) goto L_0x00aa
            r11.w(r14)
        L_0x00aa:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle r6 = r12.s()
            kotlin.jvm.functions.Function1 r8 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflowUtilsKt.a(r14)
            com.withpersona.sdk2.inquiry.selfie.video_capture.a r13 = r12.t()
            boolean r10 = r13.b()
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen r13 = new com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCapture$2 r7 = new com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCapture$2
            r7.<init>(r14, r11)
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCapture$3 r9 = new com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCapture$3
            r9.<init>(r11, r14, r12)
            r3 = r13
            r4 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.m(com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$b, com.withpersona.sdk2.inquiry.selfie.SelfieState$Capture, com.squareup.workflow1.h$a):com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen");
    }

    private final Screen n(b bVar, SelfieState.CaptureTransition captureTransition, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        Screen.CameraScreen.Overlay overlay;
        StepStyles$SelfieStepStyle s10 = bVar.s();
        if (captureTransition.i() instanceof SelfieState.Submit) {
            overlay = Screen.CameraScreen.Overlay.COMPLETE_WITH_CAPTURE;
        } else {
            int i10 = d.f27373a[captureTransition.h().ordinal()];
            if (i10 == 1) {
                overlay = Screen.CameraScreen.Overlay.LOOK_LEFT_COMPLETE;
            } else if (i10 == 2) {
                overlay = Screen.CameraScreen.Overlay.LOOK_RIGHT_COMPLETE;
            } else if (i10 == 3) {
                overlay = Screen.CameraScreen.Overlay.CENTER_COMPLETE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new Screen.CameraScreen((String) null, new Screen.CameraScreen.a.h(new SelfieWorkflow$renderCaptureTransition$1(aVar, this), true, overlay), s10, new SelfieWorkflow$renderCaptureTransition$2(aVar, this), SelfieWorkflowUtilsKt.a(aVar), new SelfieWorkflow$renderCaptureTransition$3(this, aVar, bVar), bVar.t().b());
    }

    private final Screen o(b bVar, SelfieState.CountdownToCapture countdownToCapture, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        String str;
        o.l(aVar, this.f27278d, l.k(SelfieDetectWorker.class), "", new SelfieWorkflow$renderCountdownToCapture$1(this));
        aVar.a("countdown_" + countdownToCapture.j(), new SelfieWorkflow$renderCountdownToCapture$2(aVar, this, (kotlin.coroutines.c<? super SelfieWorkflow$renderCountdownToCapture$2>) null));
        SelfieError k10 = countdownToCapture.k();
        if (k10 == null || (str = y(k10, bVar.r())) == null) {
            str = bVar.r().e();
        }
        StepStyles$SelfieStepStyle s10 = bVar.s();
        return new Screen.CameraScreen(str, new Screen.CameraScreen.a.b(countdownToCapture.j(), bVar.t().b(), bVar.t().a(), Screen.CameraScreen.Overlay.CENTER), s10, new SelfieWorkflow$renderCountdownToCapture$3(aVar, this), SelfieWorkflowUtilsKt.a(aVar), new SelfieWorkflow$renderCountdownToCapture$4(this, aVar, bVar), bVar.t().b());
    }

    private final Screen p(b bVar, SelfieState.CountdownToManualCapture countdownToManualCapture, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        Screen.CameraScreen.Overlay overlay;
        String str;
        Screen.CameraScreen.a.d dVar;
        h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar2 = aVar;
        Selfie.Direction direction = (Selfie.Direction) CollectionsKt___CollectionsKt.N(countdownToManualCapture.f());
        int i10 = d.f27373a[direction.ordinal()];
        if (i10 == 1) {
            overlay = Screen.CameraScreen.Overlay.LOOK_LEFT;
        } else if (i10 == 2) {
            overlay = Screen.CameraScreen.Overlay.LOOK_RIGHT;
        } else if (i10 == 3) {
            overlay = Screen.CameraScreen.Overlay.CENTER;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Screen.CameraScreen.Overlay overlay2 = overlay;
        aVar2.a("countdown_to_manual_capture_" + countdownToManualCapture.j(), new SelfieWorkflow$renderCountdownToManualCapture$1(aVar2, this, (kotlin.coroutines.c<? super SelfieWorkflow$renderCountdownToManualCapture$1>) null));
        SelfieError k10 = countdownToManualCapture.k();
        if (k10 == null || (str = y(k10, bVar.r())) == null) {
            str = bVar.r().e();
        }
        String str2 = str;
        StepStyles$SelfieStepStyle s10 = bVar.s();
        if (countdownToManualCapture.j() == 0) {
            dVar = new Screen.CameraScreen.a.d(new SelfieWorkflow$renderCountdownToManualCapture$2(direction, aVar, this, countdownToManualCapture, bVar), true, overlay2);
        } else {
            dVar = new Screen.CameraScreen.a.b(countdownToManualCapture.j(), bVar.t().b(), bVar.t().a(), overlay2);
        }
        Function1<Throwable, Unit> a10 = SelfieWorkflowUtilsKt.a(aVar);
        boolean b10 = bVar.t().b();
        return new Screen.CameraScreen(str2, dVar, s10, new SelfieWorkflow$renderCountdownToManualCapture$3(aVar2, this), a10, new SelfieWorkflow$renderCountdownToManualCapture$4(this, aVar2, bVar), b10);
    }

    private final Screen.a q(b bVar, SelfieState.ShowInstructions showInstructions, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        boolean a10 = bVar.a();
        return new Screen.a(bVar.r().m(), bVar.r().d(), bVar.r().a(), bVar.r().l(), bVar.s(), new SelfieWorkflow$renderShowInstructions$1(aVar, this), new SelfieWorkflow$renderShowInstructions$2(aVar, this), new SelfieWorkflow$renderShowInstructions$3(aVar, this), a10, bVar.f());
    }

    private final Screen r(b bVar, SelfieState.ShowPoseHint showPoseHint, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        SelfieHintDirection selfieHintDirection;
        String str;
        Screen.CameraScreen.Overlay overlay;
        h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar2 = aVar;
        int i10 = d.f27373a[((Selfie.Direction) CollectionsKt___CollectionsKt.N(showPoseHint.f())).ordinal()];
        if (i10 == 1) {
            selfieHintDirection = SelfieHintDirection.LEFT;
        } else if (i10 == 2) {
            selfieHintDirection = SelfieHintDirection.RIGHT;
        } else if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            throw new IllegalStateException("Pose hint cannot be shown for center pose".toString());
        }
        int[] iArr = d.f27374b;
        int i11 = iArr[selfieHintDirection.ordinal()];
        if (i11 == 1) {
            str = bVar.r().h();
        } else if (i11 == 2) {
            str = bVar.r().i();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String str2 = str;
        StepStyles$SelfieStepStyle s10 = bVar.s();
        int i12 = iArr[selfieHintDirection.ordinal()];
        if (i12 == 1) {
            overlay = Screen.CameraScreen.Overlay.LOOK_LEFT_HINT;
        } else if (i12 == 2) {
            overlay = Screen.CameraScreen.Overlay.LOOK_RIGHT_HINT;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new Screen.CameraScreen(str2, new Screen.CameraScreen.a.f(new SelfieWorkflow$renderShowPoseHint$1(aVar2, this, showPoseHint), overlay), s10, new SelfieWorkflow$renderShowPoseHint$2(aVar2, this), SelfieWorkflowUtilsKt.a(aVar), new SelfieWorkflow$renderShowPoseHint$3(this, aVar2, bVar), bVar.t().b());
    }

    private final Screen s(b bVar, SelfieState.StartCapture startCapture, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        Screen.CameraScreen.Overlay overlay;
        String str;
        Screen.CameraScreen.a aVar2;
        h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar3 = aVar;
        o.l(aVar3, this.f27278d, l.k(SelfieDetectWorker.class), "", new SelfieWorkflow$renderStartCapture$1(this, startCapture));
        Selfie.Direction c10 = startCapture.c();
        boolean e10 = startCapture.e();
        if (!e10) {
            w(aVar3);
        }
        if (startCapture.j()) {
            overlay = Screen.CameraScreen.Overlay.CENTER;
        } else {
            overlay = Screen.CameraScreen.Overlay.CLEAR;
        }
        Screen.CameraScreen.Overlay overlay2 = overlay;
        SelfieError k10 = startCapture.k();
        if (k10 == null || (str = y(k10, bVar.r())) == null) {
            str = bVar.r().k();
        }
        String str2 = str;
        StepStyles$SelfieStepStyle s10 = bVar.s();
        if (!e10) {
            aVar2 = new Screen.CameraScreen.a.C0328a(overlay2);
        } else if (bVar.t().b()) {
            aVar2 = new Screen.CameraScreen.a.e(new SelfieWorkflow$renderStartCapture$2(aVar3, this), overlay2);
        } else {
            aVar2 = new Screen.CameraScreen.a.d(new SelfieWorkflow$renderStartCapture$3(c10, aVar, this, startCapture, bVar), false, overlay2, 2, (DefaultConstructorMarker) null);
        }
        Function1<Throwable, Unit> a10 = SelfieWorkflowUtilsKt.a(aVar);
        boolean b10 = bVar.t().b();
        return new Screen.CameraScreen(str2, aVar2, s10, new SelfieWorkflow$renderStartCapture$4(aVar3, this), a10, new SelfieWorkflow$renderStartCapture$5(this, aVar3, bVar), b10);
    }

    private final Screen t(b bVar, SelfieState.StartCaptureFaceDetected startCaptureFaceDetected, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        o.l(aVar, this.f27278d, l.k(SelfieDetectWorker.class), "", new SelfieWorkflow$renderStartCaptureFaceDetected$1(this, startCaptureFaceDetected));
        o.l(aVar, j.a.b(com.squareup.workflow1.j.f23138a, 1000, (String) null, 2, (Object) null), l.l(com.squareup.workflow1.j.class, KTypeProjection.f32152c.a(l.k(Unit.class))), "", new SelfieWorkflow$renderStartCaptureFaceDetected$2(this, startCaptureFaceDetected));
        String g10 = bVar.r().g();
        StepStyles$SelfieStepStyle s10 = bVar.s();
        return new Screen.CameraScreen(g10, new Screen.CameraScreen.a.C0328a(Screen.CameraScreen.Overlay.CENTER), s10, new SelfieWorkflow$renderStartCaptureFaceDetected$3(aVar, this), SelfieWorkflowUtilsKt.a(aVar), new SelfieWorkflow$renderStartCaptureFaceDetected$4(this, aVar, bVar), bVar.t().b());
    }

    private final Screen u(b bVar, SelfieState.Submit submit, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        o.l(aVar, this.f27276b.a(bVar.p(), bVar.j(), bVar.h(), bVar.i(), bVar.o(), bVar.g(), submit.g()), l.k(SubmitVerificationWorker.class), "", new SelfieWorkflow$renderSubmit$1(this));
        return new Screen.b(bVar.r().c(), bVar.r().b(), bVar.s(), new SelfieWorkflow$renderSubmit$2(aVar, this));
    }

    private final Object v(b bVar, SelfieState.WaitForCameraFeed waitForCameraFeed, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        b bVar2 = bVar;
        SelfieState.WaitForCameraFeed waitForCameraFeed2 = waitForCameraFeed;
        h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar2 = aVar;
        StepStyles$SelfieStepStyle s10 = bVar.s();
        Screen.CameraScreen cameraScreen = new Screen.CameraScreen((String) null, new Screen.CameraScreen.a.g(new SelfieWorkflow$renderWaitForCameraFeed$cameraScreen$1(aVar2, this, bVar2), Screen.CameraScreen.Overlay.CLEAR), s10, new SelfieWorkflow$renderWaitForCameraFeed$cameraScreen$2(aVar2, this), SelfieWorkflowUtilsKt.a(aVar), new SelfieWorkflow$renderWaitForCameraFeed$cameraScreen$3(this, aVar2, bVar2), bVar.t().b());
        String str = "";
        if (!waitForCameraFeed.k()) {
            Permission permission = Permission.Camera;
            String e10 = bVar.e();
            if (e10 != null) {
                str = e10;
            }
            String d10 = bVar.d();
            if (d10 == null) {
                d10 = this.f27275a.getString(l.pi2_selfie_camera_permission_rationale);
                kotlin.jvm.internal.j.f(d10, "applicationContext.getSt…era_permission_rationale)");
            }
            Context context = this.f27275a;
            String string = context.getString(l.pi2_selfie_camera_permission_denied_rationale, new Object[]{ti.a.b(context)});
            kotlin.jvm.internal.j.f(string, "applicationContext.getSt…plicationName()\n        )");
            return com.withpersona.sdk2.inquiry.permissions.b.e(cameraScreen, aVar, true, permission, str, d10, string, bVar.c(), bVar.b(), this.f27279e, bVar.s(), (String) null, new SelfieWorkflow$renderWaitForCameraFeed$1(this, waitForCameraFeed2, bVar2), 1024, (Object) null);
        } else if (waitForCameraFeed.j() || !bVar.t().b()) {
            return cameraScreen;
        } else {
            Permission permission2 = Permission.RecordAudio;
            String m10 = bVar.m();
            if (m10 == null) {
                m10 = this.f27275a.getString(l.pi2_selfie_mic_permission_rationale);
                kotlin.jvm.internal.j.f(m10, "applicationContext.getSt…mic_permission_rationale)");
            }
            Context context2 = this.f27275a;
            String string2 = context2.getString(l.pi2_selfie_mic_permission_denied_rationale, new Object[]{ti.a.b(context2)});
            String l10 = bVar.l();
            String k10 = bVar.k();
            PermissionRequestWorkflow permissionRequestWorkflow = this.f27279e;
            String n10 = bVar.n();
            if (n10 == null) {
                n10 = str;
            }
            StepStyles$SelfieStepStyle s11 = bVar.s();
            kotlin.jvm.internal.j.f(string2, "getString(\n          R.s…plicationName()\n        )");
            return com.withpersona.sdk2.inquiry.permissions.b.d(cameraScreen, aVar, true, permission2, n10, m10, string2, l10, k10, permissionRequestWorkflow, s11, "video_capture_mic_permission_request", new SelfieWorkflow$renderWaitForCameraFeed$2(this, waitForCameraFeed2, bVar2));
        }
    }

    private final void w(h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        aVar.a("check_if_manual_capture_enabled", new SelfieWorkflow$runManualCaptureEnabledChecker$1(ref$BooleanRef, aVar, this, (kotlin.coroutines.c<? super SelfieWorkflow$runManualCaptureEnabledChecker$1>) null));
    }

    private final String y(SelfieError selfieError, b.a aVar) {
        switch (d.f27375c[selfieError.ordinal()]) {
            case 1:
                return aVar.e();
            case 2:
                return aVar.f();
            case 3:
                return aVar.e();
            case 4:
                return aVar.j();
            case 5:
                return aVar.e();
            case 6:
                return aVar.e();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean z(SelfieState selfieState) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (selfieState instanceof SelfieState.Capture) {
            z10 = true;
        } else {
            z10 = selfieState instanceof SelfieState.CaptureTransition;
        }
        if (z10) {
            z11 = true;
        } else {
            z11 = selfieState instanceof SelfieState.CountdownToCapture;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = selfieState instanceof SelfieState.CountdownToManualCapture;
        }
        if (z12) {
            z13 = true;
        } else {
            z13 = selfieState instanceof SelfieState.ShowPoseHint;
        }
        if (z13) {
            z14 = true;
        } else {
            z14 = selfieState instanceof SelfieState.StartCapture;
        }
        if (z14) {
            z15 = true;
        } else {
            z15 = selfieState instanceof SelfieState.StartCaptureFaceDetected;
        }
        if (z15) {
            z16 = true;
        } else {
            z16 = selfieState instanceof SelfieState.WaitForCameraFeed;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = selfieState instanceof SelfieState.FinalizeVideoCapture;
        }
        if (z17) {
            return true;
        }
        if (!(selfieState instanceof SelfieState.ShowInstructions)) {
            z18 = selfieState instanceof SelfieState.Submit;
        }
        if (z18) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: j */
    public SelfieState d(b bVar, Snapshot snapshot) {
        SelfieState selfieState;
        boolean z10;
        Parcelable parcelable;
        kotlin.jvm.internal.j.g(bVar, "props");
        if (snapshot != null) {
            ByteString b10 = snapshot.b();
            if (b10.H() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                b10 = null;
            }
            if (b10 == null) {
                parcelable = null;
            } else {
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
            SelfieState selfieState2 = (SelfieState) parcelable;
            if (selfieState2 != null) {
                return selfieState2;
            }
        }
        if (bVar.q()) {
            selfieState = new SelfieState.WaitForCameraFeed(false, false, 3, (DefaultConstructorMarker) null);
        } else {
            selfieState = new SelfieState.ShowInstructions();
        }
        return selfieState;
    }

    /* renamed from: l */
    public Object f(b bVar, SelfieState selfieState, h<? super b, SelfieState, ? extends c, ? extends Object>.defpackage.a aVar) {
        Object obj;
        kotlin.jvm.internal.j.g(bVar, "renderProps");
        kotlin.jvm.internal.j.g(selfieState, "renderState");
        kotlin.jvm.internal.j.g(aVar, IdentityHttpResponse.CONTEXT);
        if (!z(selfieState)) {
            aVar.a("close_camera", new SelfieWorkflow$render$1(this, (kotlin.coroutines.c<? super SelfieWorkflow$render$1>) null));
        }
        if (selfieState instanceof SelfieState.ShowInstructions) {
            obj = q(bVar, (SelfieState.ShowInstructions) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.WaitForCameraFeed) {
            obj = v(bVar, (SelfieState.WaitForCameraFeed) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.ShowPoseHint) {
            obj = r(bVar, (SelfieState.ShowPoseHint) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.StartCapture) {
            obj = s(bVar, (SelfieState.StartCapture) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.StartCaptureFaceDetected) {
            obj = t(bVar, (SelfieState.StartCaptureFaceDetected) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.CountdownToCapture) {
            obj = o(bVar, (SelfieState.CountdownToCapture) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.CountdownToManualCapture) {
            obj = p(bVar, (SelfieState.CountdownToManualCapture) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.Capture) {
            obj = m(bVar, (SelfieState.Capture) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.CaptureTransition) {
            obj = n(bVar, (SelfieState.CaptureTransition) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.FinalizeVideoCapture) {
            obj = this.f27280f.b(bVar, (SelfieState.FinalizeVideoCapture) selfieState, aVar);
        } else if (selfieState instanceof SelfieState.Submit) {
            obj = u(bVar, (SelfieState.Submit) selfieState, aVar);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (obj instanceof Screen.CameraScreen) {
            return com.withpersona.sdk2.inquiry.permissions.b.c(obj);
        }
        return obj;
    }

    /* renamed from: x */
    public Snapshot g(SelfieState selfieState) {
        kotlin.jvm.internal.j.g(selfieState, "state");
        return SnapshotParcelsKt.a(selfieState);
    }
}
