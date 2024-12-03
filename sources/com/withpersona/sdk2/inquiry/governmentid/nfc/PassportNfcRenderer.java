package com.withpersona.sdk2.inquiry.governmentid.nfc;

import android.content.Context;
import coil.ImageLoader;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.h;
import com.squareup.workflow1.j;
import com.squareup.workflow1.o;
import com.withpersona.sdk2.camera.AutoCaptureRule;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcVerifyDetailsPage;
import com.withpersona.sdk2.inquiry.governmentid.capture_tips.d;
import com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker;
import com.withpersona.sdk2.inquiry.modal.b;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcScanCompletePage;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcScanReadyPage;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcStrings;
import com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import kotlin.reflect.KTypeProjection;

public final class PassportNfcRenderer {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25955a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageLoader f25956b;

    /* renamed from: c  reason: collision with root package name */
    private final AnalyzeMrzWorker.a f25957c;

    /* renamed from: d  reason: collision with root package name */
    private final ScanNfcWorker.a f25958d;

    /* renamed from: e  reason: collision with root package name */
    private final PermissionRequestWorkflow f25959e;

    public PassportNfcRenderer(Context context, ImageLoader imageLoader, AnalyzeMrzWorker.a aVar, ScanNfcWorker.a aVar2, PermissionRequestWorkflow permissionRequestWorkflow) {
        j.g(context, "applicationContext");
        j.g(imageLoader, "imageLoader");
        j.g(aVar, "analyzeMrzWorkerFactory");
        j.g(aVar2, "scanNfcWorkerFactory");
        j.g(permissionRequestWorkflow, "permissionRequestWorkflow");
        this.f25955a = context;
        this.f25956b = imageLoader;
        this.f25957c = aVar;
        this.f25958d = aVar2;
        this.f25959e = permissionRequestWorkflow;
    }

    /* access modifiers changed from: private */
    public static final GovernmentIdState.VerifyPassportDetails c(GovernmentIdState.MrzScan mrzScan, GovernmentIdWorkflow.a aVar, PassportNfcKeys passportNfcKeys) {
        PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage;
        IdPart.PassportNfcPart o10 = mrzScan.o();
        List<GovernmentId> j10 = mrzScan.j();
        IdConfig q10 = mrzScan.q();
        GovernmentIdPages n10 = aVar.n();
        if (n10 != null) {
            passportNfcVerifyDetailsPage = n10.j();
        } else {
            passportNfcVerifyDetailsPage = null;
        }
        PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage2 = passportNfcVerifyDetailsPage;
        if (passportNfcVerifyDetailsPage2 != null) {
            return new GovernmentIdState.VerifyPassportDetails(o10, j10, mrzScan.i(), mrzScan.h(), mrzScan, passportNfcVerifyDetailsPage2, q10, passportNfcKeys, (List) null, 256, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    static /* synthetic */ GovernmentIdState.VerifyPassportDetails d(GovernmentIdState.MrzScan mrzScan, GovernmentIdWorkflow.a aVar, PassportNfcKeys passportNfcKeys, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            passportNfcKeys = null;
        }
        return c(mrzScan, aVar, passportNfcKeys);
    }

    public final b<Object, Object> b(GovernmentIdWorkflow.a aVar, GovernmentIdState.MrzScan mrzScan, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2) {
        GovernmentIdWorkflow.a aVar3 = aVar;
        GovernmentIdState.MrzScan mrzScan2 = mrzScan;
        h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar4 = aVar2;
        j.g(aVar3, "renderProps");
        j.g(mrzScan2, "renderState");
        j.g(aVar4, IdentityHttpResponse.CONTEXT);
        o.l(aVar4, this.f25957c.a(), l.k(AnalyzeMrzWorker.class), "", new PassportNfcRenderer$renderMrzScan$1(mrzScan2, aVar3));
        o.l(aVar4, j.a.b(com.squareup.workflow1.j.f23138a, j.d(aVar.m(), 0), (String) null, 2, (Object) null), l.l(com.squareup.workflow1.j.class, KTypeProjection.f32152c.a(l.k(Unit.class))), "", new PassportNfcRenderer$renderMrzScan$2(mrzScan2));
        String a02 = aVar.r().a0();
        String m10 = aVar.r().m();
        IdConfig.Side side = IdConfig.Side.Front;
        GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture p10 = mrzScan.p();
        GovernmentIdWorkflow.Screen.Overlay.Passport passport = GovernmentIdWorkflow.Screen.Overlay.Passport.f25560a;
        boolean a10 = aVar.a();
        boolean b10 = aVar.b();
        List e10 = p.e(new AutoCaptureRule.MrzRule(false, 1, (DefaultConstructorMarker) null));
        int h10 = mrzScan.h();
        StepStyles$GovernmentIdStepStyle s10 = aVar.s();
        Function1<Throwable, Unit> d10 = GovernmentIdWorkflowUtilsKt.d(aVar2);
        boolean b11 = aVar.u().b();
        long a11 = aVar.u().a();
        PassportNfcRenderer$renderMrzScan$3 passportNfcRenderer$renderMrzScan$3 = r14;
        PassportNfcRenderer$renderMrzScan$3 passportNfcRenderer$renderMrzScan$32 = new PassportNfcRenderer$renderMrzScan$3(aVar4, mrzScan2, aVar3);
        PassportNfcRenderer$renderMrzScan$4 passportNfcRenderer$renderMrzScan$4 = r15;
        PassportNfcRenderer$renderMrzScan$4 passportNfcRenderer$renderMrzScan$42 = new PassportNfcRenderer$renderMrzScan$4(aVar4);
        GovernmentIdWorkflow.Screen.CameraScreen cameraScreen = r5;
        PassportNfcRenderer$renderMrzScan$5 passportNfcRenderer$renderMrzScan$5 = new PassportNfcRenderer$renderMrzScan$5(aVar4);
        PassportNfcRenderer$renderMrzScan$6 passportNfcRenderer$renderMrzScan$6 = r2;
        PassportNfcRenderer$renderMrzScan$6 passportNfcRenderer$renderMrzScan$62 = new PassportNfcRenderer$renderMrzScan$6(aVar4, mrzScan2, aVar3);
        PassportNfcRenderer$renderMrzScan$7 passportNfcRenderer$renderMrzScan$7 = r2;
        PassportNfcRenderer$renderMrzScan$7 passportNfcRenderer$renderMrzScan$72 = new PassportNfcRenderer$renderMrzScan$7(aVar4, mrzScan2);
        PassportNfcRenderer$renderMrzScan$8 passportNfcRenderer$renderMrzScan$8 = r2;
        PassportNfcRenderer$renderMrzScan$8 passportNfcRenderer$renderMrzScan$82 = new PassportNfcRenderer$renderMrzScan$8(aVar4);
        GovernmentIdWorkflow.Screen.CameraScreen cameraScreen2 = new GovernmentIdWorkflow.Screen.CameraScreen(a02, m10, side, p10, passport, passportNfcRenderer$renderMrzScan$3, a10, b10, passportNfcRenderer$renderMrzScan$4, passportNfcRenderer$renderMrzScan$5, false, e10, h10, s10, (Function1) null, passportNfcRenderer$renderMrzScan$6, d10, 0, passportNfcRenderer$renderMrzScan$7, passportNfcRenderer$renderMrzScan$8, b11, false, (Function1) null, false, a11, false, (String) null, (d) null, 249577472, (DefaultConstructorMarker) null);
        return GovernmentIdWorkflowUtilsKt.k(cameraScreen, this.f25955a, aVar4, aVar3, mrzScan.n(), this.f25959e);
    }

    public final PassportNfcConfirmDetailsView e(GovernmentIdWorkflow.a aVar, GovernmentIdState.PassportNfcConfirmDetails passportNfcConfirmDetails, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2) {
        kotlin.jvm.internal.j.g(aVar, "renderProps");
        kotlin.jvm.internal.j.g(passportNfcConfirmDetails, "renderState");
        kotlin.jvm.internal.j.g(aVar2, IdentityHttpResponse.CONTEXT);
        return new PassportNfcConfirmDetailsView(com.withpersona.sdk2.inquiry.steps.ui.b.a(passportNfcConfirmDetails.n()), passportNfcConfirmDetails.n(), aVar.a(), new PassportNfcRenderer$renderPassportNfcConfirmDetails$1(aVar2), aVar.b(), new PassportNfcRenderer$renderPassportNfcConfirmDetails$2(aVar2), new PassportNfcRenderer$renderPassportNfcConfirmDetails$3(aVar2, aVar), new PassportNfcRenderer$renderPassportNfcConfirmDetails$4(aVar2), passportNfcConfirmDetails.m(), this.f25956b);
    }

    public final PassportNfcInstructionsView f(GovernmentIdWorkflow.a aVar, GovernmentIdState.PassportNfcError passportNfcError, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2) {
        kotlin.jvm.internal.j.g(aVar, "renderProps");
        kotlin.jvm.internal.j.g(passportNfcError, "renderState");
        kotlin.jvm.internal.j.g(aVar2, IdentityHttpResponse.CONTEXT);
        return new PassportNfcInstructionsView(com.withpersona.sdk2.inquiry.steps.ui.b.a(passportNfcError.m()), passportNfcError.m().J(), aVar.a(), new PassportNfcRenderer$renderPassportNfcError$1(aVar2), aVar.b(), new PassportNfcRenderer$renderPassportNfcError$2(aVar2), new PassportNfcRenderer$renderPassportNfcError$3(aVar2));
    }

    public final PassportNfcInstructionsView g(GovernmentIdWorkflow.a aVar, GovernmentIdState.PassportNfcInstructions passportNfcInstructions, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2) {
        kotlin.jvm.internal.j.g(aVar, "renderProps");
        kotlin.jvm.internal.j.g(passportNfcInstructions, "renderState");
        kotlin.jvm.internal.j.g(aVar2, IdentityHttpResponse.CONTEXT);
        return new PassportNfcInstructionsView(com.withpersona.sdk2.inquiry.steps.ui.b.a(passportNfcInstructions.m()), passportNfcInstructions.m().J(), aVar.a(), new PassportNfcRenderer$renderPassportNfcInstructions$1(aVar2), aVar.b(), new PassportNfcRenderer$renderPassportNfcInstructions$2(aVar2), new PassportNfcRenderer$renderPassportNfcInstructions$3(aVar2, aVar, passportNfcInstructions));
    }

    public final PassportNfcScanView h(GovernmentIdWorkflow.a aVar, GovernmentIdState.PassportNfcScan passportNfcScan, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2) {
        PassportNfcScanReadyPage passportNfcScanReadyPage;
        kotlin.jvm.internal.j.g(aVar, "renderProps");
        kotlin.jvm.internal.j.g(passportNfcScan, "renderState");
        kotlin.jvm.internal.j.g(aVar2, IdentityHttpResponse.CONTEXT);
        if (passportNfcScan.r()) {
            ScanNfcWorker.a aVar3 = this.f25958d;
            String d10 = passportNfcScan.o().d();
            Date a10 = passportNfcScan.o().a();
            Date c10 = passportNfcScan.o().c();
            GovernmentIdPages n10 = aVar.n();
            PassportNfcScanCompletePage passportNfcScanCompletePage = null;
            if (n10 != null) {
                passportNfcScanReadyPage = n10.h();
            } else {
                passportNfcScanReadyPage = null;
            }
            if (passportNfcScanReadyPage != null) {
                GovernmentIdPages n11 = aVar.n();
                if (n11 != null) {
                    passportNfcScanCompletePage = n11.f();
                }
                PassportNfcScanCompletePage passportNfcScanCompletePage2 = passportNfcScanCompletePage;
                if (passportNfcScanCompletePage2 != null) {
                    PassportNfcStrings b10 = f.b(aVar.r());
                    if (b10 != null) {
                        o.l(aVar2, aVar3.a(d10, a10, c10, passportNfcScanReadyPage, passportNfcScanCompletePage2, b10, aVar.t()), l.k(ScanNfcWorker.class), "", new PassportNfcRenderer$renderPassportNfcScan$1(passportNfcScan, aVar));
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        return new PassportNfcScanView(com.withpersona.sdk2.inquiry.steps.ui.b.a(passportNfcScan.p()), passportNfcScan.p().J(), aVar.a(), new PassportNfcRenderer$renderPassportNfcScan$2(aVar2), aVar.b(), new PassportNfcRenderer$renderPassportNfcScan$3(aVar2), new PassportNfcRenderer$renderPassportNfcScan$4(aVar2, passportNfcScan));
    }

    public final PassportNfcVerifyDetailsView i(GovernmentIdWorkflow.a aVar, GovernmentIdState.VerifyPassportDetails verifyPassportDetails, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2) {
        kotlin.jvm.internal.j.g(aVar, "renderProps");
        kotlin.jvm.internal.j.g(verifyPassportDetails, "renderState");
        kotlin.jvm.internal.j.g(aVar2, IdentityHttpResponse.CONTEXT);
        PassportNfcVerifyDetailsPage q10 = verifyPassportDetails.q();
        return new PassportNfcVerifyDetailsView(com.withpersona.sdk2.inquiry.steps.ui.b.a(q10), q10, verifyPassportDetails.p(), false, aVar.a(), new PassportNfcRenderer$renderVerifyPassportDetails$1(aVar2), aVar.b(), new PassportNfcRenderer$renderVerifyPassportDetails$2(aVar2), new PassportNfcRenderer$renderVerifyPassportDetails$3(q10, aVar2, verifyPassportDetails, aVar), verifyPassportDetails.n());
    }
}
