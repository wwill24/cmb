package com.withpersona.sdk2.inquiry.selfie;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.l;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.camera.g;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class CameraScreenRunner implements f<SelfieWorkflow.Screen.CameraScreen> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final si.a f27165b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g f27166c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public s1 f27167d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Function1<? super Throwable, Unit> f27168e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Function0<Unit> f27169f;

    /* renamed from: g  reason: collision with root package name */
    private s1 f27170g;

    /* renamed from: h  reason: collision with root package name */
    private final int f27171h;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27173a;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay[] r0 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.CLEAR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.LOOK_LEFT_HINT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.LOOK_RIGHT_HINT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.CENTER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.LOOK_LEFT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.LOOK_RIGHT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.COMPLETE_WITH_CAPTURE     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.CENTER_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.LOOK_LEFT_COMPLETE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.LOOK_RIGHT_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.FINALIZING     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$Overlay r1 = com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.Overlay.COMPLETE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                f27173a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner.a.<clinit>():void");
        }
    }

    public CameraScreenRunner(si.a aVar, g gVar) {
        int i10;
        j.g(aVar, "binding");
        j.g(gVar, "cameraController");
        this.f27165b = aVar;
        this.f27166c = gVar;
        aVar.f33815j.setPreviewView(gVar.d());
        Context context = aVar.getRoot().getContext();
        j.e(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        ((l) context).getLifecycle().a(new DefaultLifecycleObserver(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CameraScreenRunner f27172a;

            {
                this.f27172a = r1;
            }

            /* access modifiers changed from: private */
            public static final void b(CameraScreenRunner cameraScreenRunner) {
                j.g(cameraScreenRunner, "this$0");
                Function0 i10 = cameraScreenRunner.f27169f;
                if (i10 != null) {
                    i10.invoke();
                }
                cameraScreenRunner.p();
            }

            public void onResume(l lVar) {
                j.g(lVar, "owner");
                this.f27172a.f27165b.getRoot().post(new d(this.f27172a));
            }
        });
        p();
        if (Build.VERSION.SDK_INT >= 30) {
            i10 = 16;
        } else {
            i10 = 3;
        }
        this.f27171h = i10;
    }

    private final void m(TextView textView, float f10) {
        textView.setVisibility(0);
        textView.animate().setDuration(500).scaleX(f10).scaleY(f10).alpha(0.0f).withEndAction(new c(textView));
    }

    /* access modifiers changed from: private */
    public static final void n(TextView textView) {
        j.g(textView, "$this_animateIn");
        textView.setAlpha(1.0f);
        textView.setVisibility(8);
    }

    private final void o(StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle) {
        TextBasedComponentStyle r10 = stepStyles$SelfieStepStyle.r();
        if (r10 != null) {
            TextView textView = this.f27165b.f33811e;
            j.f(textView, "binding.hintMessage");
            m.e(textView, r10);
            this.f27165b.f33811e.setTextColor(-1);
        }
    }

    /* access modifiers changed from: private */
    public final void p() {
        s1 s1Var = this.f27170g;
        if (s1Var != null) {
            s1.a.a(s1Var, (CancellationException) null, 1, (Object) null);
        }
        Context context = this.f27165b.getRoot().getContext();
        j.e(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        this.f27170g = j.d(androidx.lifecycle.m.a((l) context), (CoroutineContext) null, (CoroutineStart) null, new CameraScreenRunner$registerCameraStateListener$1(this, (c<? super CameraScreenRunner$registerCameraStateListener$1>) null), 3, (Object) null);
    }

    private static final void r(si.a aVar, androidx.lifecycle.g gVar, CameraScreenRunner cameraScreenRunner, SelfieWorkflow.Screen.CameraScreen.a aVar2) {
        aVar.f33808b.setEnabled(false);
        if (!aVar.f33815j.Q()) {
            aVar.f33815j.P(new CameraScreenRunner$showRendering$1$captureImage$1(gVar, cameraScreenRunner, aVar2));
        } else {
            u(gVar, cameraScreenRunner, aVar2);
        }
    }

    /* access modifiers changed from: private */
    public static final void s(si.a aVar, androidx.lifecycle.g gVar, CameraScreenRunner cameraScreenRunner, SelfieWorkflow.Screen.CameraScreen.a aVar2, View view) {
        j.g(aVar, "$this_apply");
        j.g(gVar, "$lifecycleScope");
        j.g(cameraScreenRunner, "this$0");
        j.g(aVar2, "$mode");
        r(aVar, gVar, cameraScreenRunner, aVar2);
    }

    /* access modifiers changed from: private */
    public static final void t(si.a aVar, SelfieWorkflow.Screen.CameraScreen.a aVar2, View view) {
        j.g(aVar, "$this_apply");
        j.g(aVar2, "$mode");
        if (!aVar.f33815j.Q()) {
            aVar.f33815j.P(new CameraScreenRunner$showRendering$1$5$1(aVar2));
        } else {
            ((SelfieWorkflow.Screen.CameraScreen.a.e) aVar2).b().invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void u(androidx.lifecycle.g gVar, CameraScreenRunner cameraScreenRunner, SelfieWorkflow.Screen.CameraScreen.a aVar) {
        s1 unused = j.d(gVar, x0.c(), (CoroutineStart) null, new CameraScreenRunner$showRendering$1$takePhoto$1(cameraScreenRunner, aVar, (c<? super CameraScreenRunner$showRendering$1$takePhoto$1>) null), 2, (Object) null);
    }

    private final SelfieOverlayView.ViewState v(SelfieWorkflow.Screen.CameraScreen.Overlay overlay) {
        switch (a.f27173a[overlay.ordinal()]) {
            case 1:
                return SelfieOverlayView.ViewState.CLEAR;
            case 2:
                return SelfieOverlayView.ViewState.LOOK_LEFT_HINT;
            case 3:
                return SelfieOverlayView.ViewState.LOOK_RIGHT_HINT;
            case 4:
                return SelfieOverlayView.ViewState.CENTER;
            case 5:
                return SelfieOverlayView.ViewState.LOOK_LEFT;
            case 6:
                return SelfieOverlayView.ViewState.LOOK_RIGHT;
            case 7:
                return SelfieOverlayView.ViewState.COMPLETE_WITH_CAPTURE;
            case 8:
                return SelfieOverlayView.ViewState.CENTER_COMPLETE;
            case 9:
                return SelfieOverlayView.ViewState.LOOK_LEFT_COMPLETE;
            case 10:
                return SelfieOverlayView.ViewState.LOOK_RIGHT_COMPLETE;
            case 11:
                return SelfieOverlayView.ViewState.FINALIZING;
            case 12:
                return SelfieOverlayView.ViewState.COMPLETE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: q */
    public void a(SelfieWorkflow.Screen.CameraScreen cameraScreen, p pVar) {
        j.g(cameraScreen, "rendering");
        j.g(pVar, "viewEnvironment");
        this.f27168e = cameraScreen.d();
        this.f27169f = cameraScreen.e();
        this.f27166c.prepare();
        this.f27166c.d().setVisibility(0);
        si.a aVar = this.f27165b;
        Context context = aVar.getRoot().getContext();
        j.e(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        androidx.lifecycle.g a10 = androidx.lifecycle.m.a((l) context);
        String b10 = cameraScreen.b();
        if (b10 == null) {
            b10 = "";
        }
        if (!j.b(b10, aVar.f33811e.getText())) {
            aVar.f33811e.setText(b10);
        }
        int i10 = a.f27173a[cameraScreen.c().a().ordinal()];
        if (i10 == 1) {
            TextView textView = aVar.f33811e;
            textView.announceForAccessibility(textView.getContext().getString(l.pi2_selfie_talkback_center_pose_hint));
        } else if (i10 == 2) {
            TextView textView2 = aVar.f33811e;
            textView2.announceForAccessibility(textView2.getContext().getString(l.pi2_selfie_talkback_left_pose_hint));
        } else if (i10 == 3) {
            TextView textView3 = aVar.f33811e;
            textView3.announceForAccessibility(textView3.getContext().getString(l.pi2_selfie_talkback_right_pose_hint));
        } else if (cameraScreen.c() instanceof SelfieWorkflow.Screen.CameraScreen.a.d) {
            TextView textView4 = aVar.f33811e;
            textView4.announceForAccessibility(textView4.getContext().getString(l.pi2_selfie_talkback_hold_still_hint));
        }
        aVar.f33808b.setEnabled(true);
        aVar.f33810d.setVisibility(8);
        SelfieWorkflow.Screen.CameraScreen.a c10 = cameraScreen.c();
        if (c10 instanceof SelfieWorkflow.Screen.CameraScreen.a.g) {
            aVar.f33808b.setVisibility(8);
            s1 unused = j.d(a10, x0.a(), (CoroutineStart) null, new CameraScreenRunner$showRendering$1$1(this, c10, (c<? super CameraScreenRunner$showRendering$1$1>) null), 2, (Object) null);
            SelfieOverlayView selfieOverlayView = aVar.f33815j;
            j.f(selfieOverlayView, "selfieWindow");
            SelfieOverlayView.W(selfieOverlayView, v(c10.a()), (Function0) null, 2, (Object) null);
        } else if (c10 instanceof SelfieWorkflow.Screen.CameraScreen.a.f) {
            aVar.f33808b.setVisibility(8);
            aVar.f33815j.V(v(c10.a()), new CameraScreenRunner$showRendering$1$2(c10));
        } else if (c10 instanceof SelfieWorkflow.Screen.CameraScreen.a.b) {
            SelfieWorkflow.Screen.CameraScreen.a.b bVar = (SelfieWorkflow.Screen.CameraScreen.a.b) c10;
            if (bVar.d()) {
                s1 unused2 = j.d(a10, x0.c(), (CoroutineStart) null, new CameraScreenRunner$showRendering$1$3(this, a10, c10, (c<? super CameraScreenRunner$showRendering$1$3>) null), 2, (Object) null);
            }
            aVar.f33808b.setVisibility(4);
            if (!j.b(aVar.f33810d.getTag(), Integer.valueOf(bVar.b()))) {
                TextView textView5 = aVar.f33810d;
                j.f(textView5, "countdown");
                m(textView5, ((float) j.c(4 - bVar.b(), 1)) * 1.5f);
                aVar.f33810d.setText(String.valueOf(bVar.b()));
                aVar.f33810d.setTag(Integer.valueOf(bVar.b()));
            }
            SelfieOverlayView selfieOverlayView2 = aVar.f33815j;
            j.f(selfieOverlayView2, "selfieWindow");
            SelfieOverlayView.W(selfieOverlayView2, v(c10.a()), (Function0) null, 2, (Object) null);
        } else if (c10 instanceof SelfieWorkflow.Screen.CameraScreen.a.h) {
            aVar.f33808b.setEnabled(false);
            SelfieWorkflow.Screen.CameraScreen.a.h hVar = (SelfieWorkflow.Screen.CameraScreen.a.h) c10;
            aVar.f33815j.V(v(c10.a()), hVar.c());
            if (hVar.b()) {
                aVar.getRoot().setHapticFeedbackEnabled(true);
                aVar.getRoot().performHapticFeedback(this.f27171h, 2);
            }
        } else if (c10 instanceof SelfieWorkflow.Screen.CameraScreen.a.d) {
            aVar.f33808b.setVisibility(0);
            aVar.f33808b.setOnClickListener(new a(aVar, a10, this, c10));
            if (((SelfieWorkflow.Screen.CameraScreen.a.d) c10).b()) {
                aVar.f33808b.setVisibility(8);
                r(aVar, a10, this, c10);
            }
            SelfieOverlayView selfieOverlayView3 = aVar.f33815j;
            j.f(selfieOverlayView3, "selfieWindow");
            SelfieOverlayView.W(selfieOverlayView3, v(c10.a()), (Function0) null, 2, (Object) null);
        } else if (c10 instanceof SelfieWorkflow.Screen.CameraScreen.a.e) {
            aVar.f33808b.setVisibility(0);
            aVar.f33808b.setOnClickListener(new b(aVar, c10));
            SelfieOverlayView selfieOverlayView4 = aVar.f33815j;
            j.f(selfieOverlayView4, "selfieWindow");
            SelfieOverlayView.W(selfieOverlayView4, v(c10.a()), (Function0) null, 2, (Object) null);
        } else if (c10 instanceof SelfieWorkflow.Screen.CameraScreen.a.C0328a) {
            aVar.f33808b.setVisibility(4);
            SelfieOverlayView selfieOverlayView5 = aVar.f33815j;
            j.f(selfieOverlayView5, "selfieWindow");
            SelfieOverlayView.W(selfieOverlayView5, v(c10.a()), (Function0) null, 2, (Object) null);
        } else if (c10 instanceof SelfieWorkflow.Screen.CameraScreen.a.c) {
            aVar.f33808b.setVisibility(4);
            if (((SelfieWorkflow.Screen.CameraScreen.a.c) c10).d()) {
                s1 s1Var = this.f27167d;
                if (s1Var != null) {
                    s1.a.a(s1Var, (CancellationException) null, 1, (Object) null);
                }
                s1 unused3 = j.d(a10, x0.c(), (CoroutineStart) null, new CameraScreenRunner$showRendering$1$6(this, c10, cameraScreen, (c<? super CameraScreenRunner$showRendering$1$6>) null), 2, (Object) null);
            }
            aVar.f33815j.V(v(c10.a()), new CameraScreenRunner$showRendering$1$7(c10));
        }
        aVar.f33812f.setState(new NavigationUiState(false, (Function0) null, true, new CameraScreenRunner$showRendering$1$8(cameraScreen), 2, (DefaultConstructorMarker) null));
        StepStyles$SelfieStepStyle f10 = cameraScreen.f();
        if (f10 != null) {
            o(f10);
            int color = androidx.core.content.a.getColor(this.f27165b.getRoot().getContext(), g.blackScreenStatusBarColor);
            Context context2 = this.f27165b.getRoot().getContext();
            j.f(context2, "binding.root.context");
            ti.a.f(context2, color);
            this.f27165b.f33815j.O(f10);
        }
    }
}
