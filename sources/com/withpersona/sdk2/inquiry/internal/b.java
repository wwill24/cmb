package com.withpersona.sdk2.inquiry.internal;

import android.content.Context;
import android.net.Uri;
import androidx.activity.result.e;
import coil.ImageLoader;
import com.squareup.moshi.h;
import com.squareup.workflow1.ui.r;
import com.squareup.workflow1.ui.s;
import com.withpersona.sdk2.camera.GovernmentIdFeed;
import com.withpersona.sdk2.camera.ParsedIdSideOrNone;
import com.withpersona.sdk2.camera.SelfieDirectionFeed;
import com.withpersona.sdk2.camera.SelfieProcessor;
import com.withpersona.sdk2.camera.h;
import com.withpersona.sdk2.camera.w;
import com.withpersona.sdk2.inquiry.document.DocumentCameraWorker;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdCameraScreenViewFactory;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker;
import com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker;
import com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker;
import com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcRenderer;
import com.withpersona.sdk2.inquiry.governmentid.v;
import com.withpersona.sdk2.inquiry.governmentid.video_capture.VideoCaptureRenderer;
import com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker;
import com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker;
import com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker;
import com.withpersona.sdk2.inquiry.internal.TransitionBackWorker;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.f;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.i;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.j;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.k;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.l;
import com.withpersona.sdk2.inquiry.internal.network.d;
import com.withpersona.sdk2.inquiry.internal.network.m;
import com.withpersona.sdk2.inquiry.internal.network.n;
import com.withpersona.sdk2.inquiry.internal.network.p;
import com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker;
import com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker;
import com.withpersona.sdk2.inquiry.launchers.i;
import com.withpersona.sdk2.inquiry.launchers.o;
import com.withpersona.sdk2.inquiry.network.JsonAdapterBinding;
import com.withpersona.sdk2.inquiry.network.NetworkModule;
import com.withpersona.sdk2.inquiry.network.NetworkModule_InterceptorFactory;
import com.withpersona.sdk2.inquiry.network.NetworkModule_KeyInflectionFactory;
import com.withpersona.sdk2.inquiry.network.NetworkModule_MoshiFactory;
import com.withpersona.sdk2.inquiry.network.NetworkModule_OkhttpClientFactory;
import com.withpersona.sdk2.inquiry.network.NetworkModule_ProvideMoshiJsonAdapterFactoryFactory;
import com.withpersona.sdk2.inquiry.network.NetworkModule_RetrofitFactory;
import com.withpersona.sdk2.inquiry.network.NetworkModule_UseServerStylesFactory;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderConfig;
import com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorker;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import com.withpersona.sdk2.inquiry.sandbox.SandboxFlags;
import com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker;
import com.withpersona.sdk2.inquiry.selfie.SelfieCameraScreenViewFactory;
import com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker;
import com.withpersona.sdk2.inquiry.shared.device.RealDeviceIdProvider;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker;
import com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker;
import fj.g;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import okhttp3.u;
import okhttp3.x;

public final class b {

    /* renamed from: com.withpersona.sdk2.inquiry.internal.b$b  reason: collision with other inner class name */
    public static final class C0318b {

        /* renamed from: a  reason: collision with root package name */
        private NetworkModule f26286a;

        /* renamed from: b  reason: collision with root package name */
        private com.withpersona.sdk2.inquiry.internal.network.c f26287b;

        /* renamed from: c  reason: collision with root package name */
        private i f26288c;

        /* renamed from: d  reason: collision with root package name */
        private h f26289d;

        /* renamed from: e  reason: collision with root package name */
        private o f26290e;

        /* renamed from: f  reason: collision with root package name */
        private d f26291f;

        /* renamed from: g  reason: collision with root package name */
        private com.withpersona.sdk2.inquiry.launchers.a f26292g;

        /* renamed from: h  reason: collision with root package name */
        private com.withpersona.sdk2.inquiry.sandbox.a f26293h;

        /* renamed from: i  reason: collision with root package name */
        private com.withpersona.sdk2.inquiry.nfc.c f26294i;

        /* renamed from: j  reason: collision with root package name */
        private ui.b f26295j;

        /* renamed from: k  reason: collision with root package name */
        private f f26296k;

        /* renamed from: l  reason: collision with root package name */
        private com.withpersona.sdk2.inquiry.internal.fallbackmode.b f26297l;

        public C0318b a(com.withpersona.sdk2.inquiry.internal.fallbackmode.b bVar) {
            this.f26297l = (com.withpersona.sdk2.inquiry.internal.fallbackmode.b) g.b(bVar);
            return this;
        }

        public g b() {
            g.a(this.f26286a, NetworkModule.class);
            g.a(this.f26287b, com.withpersona.sdk2.inquiry.internal.network.c.class);
            g.a(this.f26288c, i.class);
            if (this.f26289d == null) {
                this.f26289d = new h();
            }
            g.a(this.f26290e, o.class);
            g.a(this.f26291f, d.class);
            g.a(this.f26292g, com.withpersona.sdk2.inquiry.launchers.a.class);
            if (this.f26293h == null) {
                this.f26293h = new com.withpersona.sdk2.inquiry.sandbox.a();
            }
            g.a(this.f26294i, com.withpersona.sdk2.inquiry.nfc.c.class);
            g.a(this.f26295j, ui.b.class);
            if (this.f26296k == null) {
                this.f26296k = new f();
            }
            g.a(this.f26297l, com.withpersona.sdk2.inquiry.internal.fallbackmode.b.class);
            return new c(this.f26286a, this.f26287b, this.f26288c, this.f26289d, this.f26290e, this.f26291f, this.f26292g, this.f26293h, this.f26294i, this.f26295j, this.f26296k, this.f26297l);
        }

        public C0318b c(ui.b bVar) {
            this.f26295j = (ui.b) g.b(bVar);
            return this;
        }

        public C0318b d(com.withpersona.sdk2.inquiry.launchers.a aVar) {
            this.f26292g = (com.withpersona.sdk2.inquiry.launchers.a) g.b(aVar);
            return this;
        }

        public C0318b e(i iVar) {
            this.f26288c = (i) g.b(iVar);
            return this;
        }

        public C0318b f(d dVar) {
            this.f26291f = (d) g.b(dVar);
            return this;
        }

        public C0318b g(com.withpersona.sdk2.inquiry.internal.network.c cVar) {
            this.f26287b = (com.withpersona.sdk2.inquiry.internal.network.c) g.b(cVar);
            return this;
        }

        public C0318b h(NetworkModule networkModule) {
            this.f26286a = (NetworkModule) g.b(networkModule);
            return this;
        }

        public C0318b i(com.withpersona.sdk2.inquiry.nfc.c cVar) {
            this.f26294i = (com.withpersona.sdk2.inquiry.nfc.c) g.b(cVar);
            return this;
        }

        public C0318b j(o oVar) {
            this.f26290e = (o) g.b(oVar);
            return this;
        }

        private C0318b() {
        }
    }

    private static final class c implements g {
        private fk.a<RealFallbackModeManager> A;
        private fk.a<RealDeviceIdProvider> B;
        private fk.a<com.withpersona.sdk2.inquiry.shared.device.b> C;
        private fk.a<ImageLoader> D;
        private fk.a<com.withpersona.sdk2.inquiry.governmentid.network.b> E;
        private fk.a<ji.a> F;
        private fk.a<wi.a> G;
        private fk.a<kotlinx.coroutines.flow.h<Result<ParsedIdSideOrNone>>> H;
        private fk.a<androidx.activity.result.c<String[]>> I;
        private fk.a<androidx.activity.result.c<String>> J;
        private fk.a<androidx.activity.result.c<PassportNfcReaderConfig>> K;
        private fk.a<com.withpersona.sdk2.inquiry.selfie.network.a> L;
        private fk.a<kotlinx.coroutines.flow.h<Result<w>>> M;
        private fk.a<com.withpersona.sdk2.inquiry.ui.network.b> N;
        private fk.a<androidx.activity.result.c<Uri>> O;
        private fk.a<androidx.activity.result.c<String[]>> P;
        private fk.a<androidx.activity.result.c<e>> Q;
        private fk.a<com.withpersona.sdk2.inquiry.document.network.a> R;
        private fk.a<ti.c> S;
        private fk.a<GovernmentIdFeed> T;
        private fk.a<GovernmentIdCameraScreenViewFactory> U;
        private fk.a<Set<r<?>>> V;
        private fk.a<SelfieDirectionFeed> W;
        private fk.a<SelfieCameraScreenViewFactory> X;
        private fk.a<Set<r<?>>> Y;
        private fk.a<Set<r<?>>> Z;

        /* renamed from: a  reason: collision with root package name */
        private final d f26298a;

        /* renamed from: a0  reason: collision with root package name */
        private fk.a<s> f26299a0;

        /* renamed from: b  reason: collision with root package name */
        private final ui.b f26300b;

        /* renamed from: b0  reason: collision with root package name */
        private fk.a<ErrorReportingManager> f26301b0;

        /* renamed from: c  reason: collision with root package name */
        private final c f26302c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<String> f26303d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<Set<Object>> f26304e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<Set<JsonAdapterBinding<?>>> f26305f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<Set<h.e>> f26306g;

        /* renamed from: h  reason: collision with root package name */
        private fk.a<com.squareup.moshi.s> f26307h;

        /* renamed from: i  reason: collision with root package name */
        private fk.a<u> f26308i;

        /* renamed from: j  reason: collision with root package name */
        private fk.a<SandboxFlags> f26309j;

        /* renamed from: k  reason: collision with root package name */
        private fk.a<u> f26310k;

        /* renamed from: l  reason: collision with root package name */
        private fk.a<Set<u>> f26311l;

        /* renamed from: m  reason: collision with root package name */
        private fk.a<String> f26312m;

        /* renamed from: n  reason: collision with root package name */
        private fk.a<String> f26313n;

        /* renamed from: o  reason: collision with root package name */
        private fk.a<Map<String, String>> f26314o;

        /* renamed from: p  reason: collision with root package name */
        private fk.a<Context> f26315p;

        /* renamed from: q  reason: collision with root package name */
        private fk.a<com.withpersona.sdk2.inquiry.shared.device.a> f26316q;

        /* renamed from: r  reason: collision with root package name */
        private fk.a<com.withpersona.sdk2.inquiry.shared.device.c> f26317r;

        /* renamed from: s  reason: collision with root package name */
        private fk.a<x> f26318s;

        /* renamed from: t  reason: collision with root package name */
        private fk.a<retrofit2.s> f26319t;

        /* renamed from: u  reason: collision with root package name */
        private fk.a<p> f26320u;

        /* renamed from: v  reason: collision with root package name */
        private fk.a<FallbackModeService> f26321v;

        /* renamed from: w  reason: collision with root package name */
        private fk.a<FallbackModeApiController> f26322w;

        /* renamed from: x  reason: collision with root package name */
        private j f26323x;

        /* renamed from: y  reason: collision with root package name */
        private fk.a<i.a> f26324y;

        /* renamed from: z  reason: collision with root package name */
        private fk.a<com.withpersona.sdk2.inquiry.internal.fallbackmode.a> f26325z;

        private PermissionRequestWorkflow A() {
            return new PermissionRequestWorkflow(e.a(this.f26298a), z());
        }

        private ScanNfcWorker.a B() {
            return new ScanNfcWorker.a(this.K.get(), e.a(this.f26298a));
        }

        private SelfieAnalyzeWorker.b C() {
            return new SelfieAnalyzeWorker.b(e.a(this.f26298a), E());
        }

        private SelfieDetectWorker D() {
            return new SelfieDetectWorker(E());
        }

        private SelfieDirectionFeed E() {
            return new SelfieDirectionFeed(new SelfieProcessor(), this.M.get());
        }

        private SelfieWorkflow F() {
            return new SelfieWorkflow(e.a(this.f26298a), H(), C(), D(), A(), O());
        }

        private SubmitVerificationWorker.a G() {
            return new SubmitVerificationWorker.a(this.E.get(), ui.c.a(this.f26300b), this.F.get(), this.G.get());
        }

        private SubmitVerificationWorker.a H() {
            return new SubmitVerificationWorker.a(this.L.get(), ui.c.a(this.f26300b), this.F.get(), this.G.get());
        }

        private TransitionBackWorker.a I() {
            return new TransitionBackWorker.a(this.f26320u.get());
        }

        private UiAddressAutocompleteWorker.a J() {
            return new UiAddressAutocompleteWorker.a(this.N.get());
        }

        private UiAddressDetailsWorker.a K() {
            return new UiAddressDetailsWorker.a(this.N.get());
        }

        private UiTransitionWorker.a L() {
            return new UiTransitionWorker.a(this.N.get(), this.f26307h.get(), ui.c.a(this.f26300b), this.F.get());
        }

        private UiWorkflow M() {
            return new UiWorkflow(e.a(this.f26298a), L(), J(), K());
        }

        private VideoCaptureRenderer N() {
            return new VideoCaptureRenderer(e.a(this.f26298a));
        }

        private com.withpersona.sdk2.inquiry.selfie.video_capture.VideoCaptureRenderer O() {
            return new com.withpersona.sdk2.inquiry.selfie.video_capture.VideoCaptureRenderer(e.a(this.f26298a));
        }

        private AnalyzeMrzWorker.a g() {
            return new AnalyzeMrzWorker.a(u());
        }

        private CheckInquiryWorker.b h() {
            return new CheckInquiryWorker.b(this.f26320u.get(), this.C.get(), this.f26309j.get(), this.A.get());
        }

        private CreateInquirySessionWorker.a i() {
            return new CreateInquirySessionWorker.a(this.f26320u.get(), this.C.get(), this.A.get());
        }

        private CreateInquiryWorker.a j() {
            return new CreateInquiryWorker.a(this.f26320u.get(), this.A.get());
        }

        private DocumentCameraWorker k() {
            return new DocumentCameraWorker(this.O.get(), e.a(this.f26298a));
        }

        private DocumentCreateWorker.a l() {
            return new DocumentCreateWorker.a(this.R.get());
        }

        private DocumentFileDeleteWorker.a m() {
            return new DocumentFileDeleteWorker.a(this.R.get());
        }

        private DocumentFileUploadWorker.a n() {
            return new DocumentFileUploadWorker.a(this.R.get(), this.S.get());
        }

        private DocumentLoadWorker.a o() {
            return new DocumentLoadWorker.a(this.R.get());
        }

        private DocumentSelectWorker p() {
            return new DocumentSelectWorker(this.I.get(), e.a(this.f26298a));
        }

        private DocumentSubmitWorker.a q() {
            return new DocumentSubmitWorker.a(this.R.get(), this.F.get(), ui.c.a(this.f26300b));
        }

        private DocumentWorkflow r() {
            return new DocumentWorkflow(this.D.get(), e.a(this.f26298a), A(), k(), s(), l(), o(), n(), m(), q());
        }

        private DocumentsSelectWorker.Factory s() {
            return new DocumentsSelectWorker.Factory(this.P.get(), this.Q.get(), e.a(this.f26298a));
        }

        private GovernmentIdAnalyzeWorker.a t() {
            return new GovernmentIdAnalyzeWorker.a(e.a(this.f26298a), u());
        }

        private GovernmentIdFeed u() {
            return new GovernmentIdFeed(this.H.get());
        }

        private GovernmentIdHintWorker.b v() {
            return new GovernmentIdHintWorker.b(e.a(this.f26298a), u());
        }

        private GovernmentIdWorkflow w() {
            return new GovernmentIdWorkflow(e.a(this.f26298a), this.D.get(), G(), t(), p(), v(), A(), N(), y());
        }

        private void x(NetworkModule networkModule, com.withpersona.sdk2.inquiry.internal.network.c cVar, com.withpersona.sdk2.inquiry.launchers.i iVar, com.withpersona.sdk2.camera.h hVar, o oVar, d dVar, com.withpersona.sdk2.inquiry.launchers.a aVar, com.withpersona.sdk2.inquiry.sandbox.a aVar2, com.withpersona.sdk2.inquiry.nfc.c cVar2, ui.b bVar, f fVar, com.withpersona.sdk2.inquiry.internal.fallbackmode.b bVar2) {
            NetworkModule networkModule2 = networkModule;
            com.withpersona.sdk2.inquiry.internal.network.c cVar3 = cVar;
            f fVar2 = fVar;
            this.f26303d = m.a(cVar);
            this.f26304e = fj.h.a(0, 1).a(com.withpersona.sdk2.inquiry.internal.network.i.a()).c();
            this.f26305f = fj.h.a(0, 1).a(com.withpersona.sdk2.inquiry.internal.network.h.a()).c();
            fj.h c10 = fj.h.a(0, 2).a(NetworkModule_ProvideMoshiJsonAdapterFactoryFactory.create()).a(com.withpersona.sdk2.inquiry.internal.network.j.a()).c();
            this.f26306g = c10;
            fk.a<com.squareup.moshi.s> a10 = fj.c.a(NetworkModule_MoshiFactory.create(networkModule, this.f26304e, this.f26305f, c10));
            this.f26307h = a10;
            this.f26308i = NetworkModule_InterceptorFactory.create(networkModule, a10);
            fk.a<SandboxFlags> a11 = fj.c.a(qi.c.a());
            this.f26309j = a11;
            this.f26310k = qi.e.a(aVar2, a11);
            this.f26311l = fj.h.a(2, 0).b(this.f26308i).b(this.f26310k).c();
            this.f26312m = NetworkModule_KeyInflectionFactory.create(networkModule);
            this.f26313n = NetworkModule_UseServerStylesFactory.create(networkModule);
            this.f26314o = fj.f.b(3).c("Key-Inflection", this.f26312m).c("Persona-Use-Mobile-Server-Styles", this.f26313n).c("User-Agent", d.a()).b();
            this.f26315p = e.b(dVar);
            this.f26316q = fj.c.a(com.withpersona.sdk2.inquiry.shared.device.e.a());
            fk.a<com.withpersona.sdk2.inquiry.shared.device.c> a12 = fj.c.a(com.withpersona.sdk2.inquiry.shared.device.h.a());
            this.f26317r = a12;
            NetworkModule_OkhttpClientFactory create = NetworkModule_OkhttpClientFactory.create(networkModule, this.f26311l, this.f26314o, this.f26315p, this.f26316q, a12);
            this.f26318s = create;
            fk.a<retrofit2.s> a13 = fj.c.a(NetworkModule_RetrofitFactory.create(networkModule, this.f26303d, create, this.f26307h));
            this.f26319t = a13;
            this.f26320u = fj.c.a(com.withpersona.sdk2.inquiry.internal.network.g.a(cVar, a13));
            fk.a<FallbackModeService> a14 = fj.c.a(com.withpersona.sdk2.inquiry.internal.fallbackmode.h.a(fVar2, this.f26319t));
            this.f26321v = a14;
            this.f26322w = com.withpersona.sdk2.inquiry.internal.fallbackmode.e.a(a14, this.f26307h);
            j a15 = j.a(this.f26307h, this.f26315p);
            this.f26323x = a15;
            fk.a<i.a> b10 = k.b(a15);
            this.f26324y = b10;
            com.withpersona.sdk2.inquiry.internal.fallbackmode.c b11 = com.withpersona.sdk2.inquiry.internal.fallbackmode.c.b(bVar2, this.f26322w, b10);
            this.f26325z = b11;
            this.A = fj.c.a(l.a(b11, this.f26307h));
            com.withpersona.sdk2.inquiry.shared.device.f a16 = com.withpersona.sdk2.inquiry.shared.device.f.a(this.f26315p);
            this.B = a16;
            this.C = fj.c.a(a16);
            this.D = fj.c.a(f.a(dVar, this.f26315p));
            this.E = fj.c.a(com.withpersona.sdk2.inquiry.internal.network.f.a(cVar, this.f26319t));
            this.F = fj.c.a(com.withpersona.sdk2.inquiry.internal.fallbackmode.g.a(fVar2, this.A));
            this.G = fj.c.a(wi.c.a());
            this.H = fj.c.a(com.withpersona.sdk2.camera.i.a(hVar));
            this.I = fj.c.a(com.withpersona.sdk2.inquiry.launchers.l.a(iVar));
            this.J = fj.c.a(com.withpersona.sdk2.inquiry.launchers.r.a(oVar));
            this.K = fj.c.a(com.withpersona.sdk2.inquiry.nfc.f.a(cVar2));
            this.L = fj.c.a(com.withpersona.sdk2.inquiry.internal.network.l.a(cVar, this.f26319t));
            this.M = fj.c.a(com.withpersona.sdk2.camera.j.a(hVar));
            this.N = fj.c.a(n.a(cVar, this.f26319t));
            this.O = fj.c.a(com.withpersona.sdk2.inquiry.launchers.h.a(aVar));
            this.P = fj.c.a(com.withpersona.sdk2.inquiry.launchers.f.a(aVar));
            this.Q = fj.c.a(com.withpersona.sdk2.inquiry.launchers.g.a(aVar));
            this.R = fj.c.a(com.withpersona.sdk2.inquiry.internal.network.e.a(cVar, this.f26319t));
            this.S = fj.c.a(ti.m.a());
            com.withpersona.sdk2.camera.r a17 = com.withpersona.sdk2.camera.r.a(this.H);
            this.T = a17;
            com.withpersona.sdk2.inquiry.governmentid.p a18 = com.withpersona.sdk2.inquiry.governmentid.p.a(a17, com.withpersona.sdk2.camera.m.a());
            this.U = a18;
            this.V = v.a(a18);
            this.W = com.withpersona.sdk2.camera.v.a(com.withpersona.sdk2.camera.x.a(), this.M);
            com.withpersona.sdk2.inquiry.selfie.n a19 = com.withpersona.sdk2.inquiry.selfie.n.a(com.withpersona.sdk2.camera.m.a(), this.W);
            this.X = a19;
            this.Y = com.withpersona.sdk2.inquiry.selfie.s.a(a19);
            fj.h<Set<r<?>>> c11 = fj.h.a(0, 7).a(com.withpersona.sdk2.inquiry.internal.network.k.a()).a(this.V).a(com.withpersona.sdk2.inquiry.ui.p.a()).a(this.Y).a(com.withpersona.sdk2.inquiry.document.c.a()).a(qi.f.a()).a(com.withpersona.sdk2.inquiry.modal.e.a()).c();
            this.Z = c11;
            this.f26299a0 = fj.c.a(com.withpersona.sdk2.inquiry.internal.network.o.a(c11));
            this.f26301b0 = fj.c.a(c.a(this.f26320u, this.f26307h));
        }

        private PassportNfcRenderer y() {
            return new PassportNfcRenderer(e.a(this.f26298a), this.D.get(), g(), B(), A());
        }

        private PermissionRequestWorker.a z() {
            return new PermissionRequestWorker.a(e.a(this.f26298a), this.J.get());
        }

        public ji.a a() {
            return this.F.get();
        }

        public com.withpersona.sdk2.inquiry.shared.device.a b() {
            return this.f26316q.get();
        }

        public s c() {
            return this.f26299a0.get();
        }

        public InquiryWorkflow d() {
            return new InquiryWorkflow(j(), i(), h(), I(), w(), F(), M(), r(), this.f26309j.get());
        }

        public ErrorReportingManager e() {
            return this.f26301b0.get();
        }

        public ImageLoader f() {
            return this.D.get();
        }

        private c(NetworkModule networkModule, com.withpersona.sdk2.inquiry.internal.network.c cVar, com.withpersona.sdk2.inquiry.launchers.i iVar, com.withpersona.sdk2.camera.h hVar, o oVar, d dVar, com.withpersona.sdk2.inquiry.launchers.a aVar, com.withpersona.sdk2.inquiry.sandbox.a aVar2, com.withpersona.sdk2.inquiry.nfc.c cVar2, ui.b bVar, f fVar, com.withpersona.sdk2.inquiry.internal.fallbackmode.b bVar2) {
            this.f26302c = this;
            this.f26298a = dVar;
            this.f26300b = bVar;
            x(networkModule, cVar, iVar, hVar, oVar, dVar, aVar, aVar2, cVar2, bVar, fVar, bVar2);
        }
    }

    public static C0318b a() {
        return new C0318b();
    }
}
