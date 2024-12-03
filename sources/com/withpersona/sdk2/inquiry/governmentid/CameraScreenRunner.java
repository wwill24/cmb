package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import com.airbnb.lottie.LottieAnimationView;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.camera.GovernmentIdFeed;
import com.withpersona.sdk2.camera.g;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.capture_tips.CaptureTipsBottomSheetController;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepTextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepTextBasedComponentStyleContainer;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import java.util.concurrent.CancellationException;
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
import net.bytebuddy.jar.asm.Opcodes;
import ti.n;

public final class CameraScreenRunner implements f<GovernmentIdWorkflow.Screen.CameraScreen> {

    /* renamed from: n  reason: collision with root package name */
    public static final a f25275n = new a((DefaultConstructorMarker) null);

    /* renamed from: o  reason: collision with root package name */
    private static final int f25276o = (Build.VERSION.SDK_INT >= 30 ? 16 : 3);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ki.a f25277b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g f25278c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final GovernmentIdFeed f25279d;

    /* renamed from: e  reason: collision with root package name */
    private int f25280e;

    /* renamed from: f  reason: collision with root package name */
    private s1 f25281f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f25282g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public s1 f25283h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Function1<? super Throwable, Unit> f25284i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Function0<Unit> f25285j;

    /* renamed from: k  reason: collision with root package name */
    private s1 f25286k;

    /* renamed from: l  reason: collision with root package name */
    private Integer f25287l;

    /* renamed from: m  reason: collision with root package name */
    private final CaptureTipsBottomSheetController f25288m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25290a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f25291b;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|(2:21|22)|23|25) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004d */
        static {
            /*
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side[] r0 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r2 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Front     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r3 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.FrontOrBack     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r4 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.PassportSignature     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r4 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Back     // Catch:{ NoSuchFieldError -> 0x002b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r5 = 4
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r4 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.BarcodePdf417     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r5 = 5
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f25290a = r0
                com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture[] r0 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture r4 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Disabled     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Enabled     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Hidden     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                f25291b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner.b.<clinit>():void");
        }
    }

    public CameraScreenRunner(ki.a aVar, g gVar, GovernmentIdFeed governmentIdFeed) {
        j.g(aVar, "binding");
        j.g(gVar, "cameraController");
        j.g(governmentIdFeed, "governmentIdFeed");
        this.f25277b = aVar;
        this.f25278c = gVar;
        this.f25279d = governmentIdFeed;
        ConstraintLayout b10 = aVar.getRoot();
        j.f(b10, "binding.root");
        this.f25288m = new CaptureTipsBottomSheetController(b10);
        ThemeableLottieAnimationView themeableLottieAnimationView = aVar.f31935q;
        int parseColor = Color.parseColor("#43957D");
        Context context = aVar.getRoot().getContext();
        j.f(context, "binding.root.context");
        themeableLottieAnimationView.I(parseColor, n.d(context, h0.colorPrimary, (TypedValue) null, false, 6, (Object) null));
        Context context2 = aVar.getRoot().getContext();
        j.e(context2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        ((l) context2).getLifecycle().a(new DefaultLifecycleObserver(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CameraScreenRunner f25289a;

            {
                this.f25289a = r1;
            }

            /* access modifiers changed from: private */
            public static final void b(CameraScreenRunner cameraScreenRunner) {
                j.g(cameraScreenRunner, "this$0");
                Function0 r10 = cameraScreenRunner.f25285j;
                if (r10 != null) {
                    r10.invoke();
                }
                cameraScreenRunner.I();
            }

            public void onResume(l lVar) {
                j.g(lVar, "owner");
                this.f25289a.f25277b.getRoot().post(new m(this.f25289a));
            }
        });
        I();
    }

    private final void A(GovernmentIdWorkflow.Screen.CameraScreen cameraScreen) {
        ki.a aVar = this.f25277b;
        if (cameraScreen.D()) {
            View view = aVar.f31938x;
            j.f(view, "previewDim");
            w(view, 0.66f);
            LottieAnimationView lottieAnimationView = aVar.C;
            j.f(lottieAnimationView, "scanningAnimation");
            w(lottieAnimationView, 0.0f);
            ImageView imageView = aVar.f31933n;
            j.f(imageView, "overlayGuide");
            w(imageView, 0.0f);
            ConstraintLayout constraintLayout = aVar.f31934p;
            j.f(constraintLayout, "overlayHint");
            w(constraintLayout, 0.0f);
            ProgressBar progressBar = aVar.B;
            j.f(progressBar, "progressBar");
            w(progressBar, 1.0f);
            return;
        }
        View view2 = aVar.f31938x;
        j.f(view2, "previewDim");
        w(view2, 0.0f);
        LottieAnimationView lottieAnimationView2 = aVar.C;
        j.f(lottieAnimationView2, "scanningAnimation");
        w(lottieAnimationView2, 1.0f);
        ImageView imageView2 = aVar.f31933n;
        j.f(imageView2, "overlayGuide");
        w(imageView2, 1.0f);
        ImageView imageView3 = aVar.f31933n;
        j.f(imageView3, "overlayGuide");
        w(imageView3, 1.0f);
        ProgressBar progressBar2 = aVar.B;
        j.f(progressBar2, "progressBar");
        w(progressBar2, 0.0f);
    }

    /* access modifiers changed from: private */
    public final void B(Function0<Unit> function0) {
        ki.a aVar = this.f25277b;
        aVar.getRoot().setHapticFeedbackEnabled(true);
        aVar.getRoot().performHapticFeedback(f25276o, 2);
        D();
        aVar.getRoot().postDelayed(new h(function0), 100);
    }

    /* access modifiers changed from: private */
    public static final void C(Function0 function0) {
        j.g(function0, "$tmp0");
        function0.invoke();
    }

    private final void D() {
        ki.a aVar = this.f25277b;
        View view = aVar.F;
        view.setTranslationY(-((float) view.getHeight()));
        aVar.F.setVisibility(0);
        aVar.F.animate().setDuration(100).translationY(0.0f).withEndAction(new i(aVar));
        View view2 = aVar.E;
        view2.setTranslationY((float) view2.getHeight());
        aVar.E.setVisibility(0);
        aVar.E.animate().setDuration(100).translationY(0.0f).withEndAction(new j(aVar));
    }

    /* access modifiers changed from: private */
    public static final void E(ki.a aVar) {
        j.g(aVar, "$this_with");
        aVar.F.animate().setDuration(40).translationY(-((float) aVar.F.getHeight())).withEndAction(new l(aVar));
    }

    /* access modifiers changed from: private */
    public static final void F(ki.a aVar) {
        j.g(aVar, "$this_with");
        aVar.F.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public static final void G(ki.a aVar) {
        j.g(aVar, "$this_with");
        aVar.E.animate().setDuration(40).translationY((float) aVar.E.getHeight()).withEndAction(new k(aVar));
    }

    /* access modifiers changed from: private */
    public static final void H(ki.a aVar) {
        j.g(aVar, "$this_with");
        aVar.E.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public final void I() {
        s1 s1Var = this.f25286k;
        if (s1Var != null) {
            s1.a.a(s1Var, (CancellationException) null, 1, (Object) null);
        }
        Context context = this.f25277b.getRoot().getContext();
        j.e(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        this.f25286k = j.d(m.a((l) context), (CoroutineContext) null, (CoroutineStart) null, new CameraScreenRunner$registerCameraStateListener$1(this, (c<? super CameraScreenRunner$registerCameraStateListener$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void K(CameraScreenRunner cameraScreenRunner, CompoundButton compoundButton, boolean z10) {
        j.g(cameraScreenRunner, "this$0");
        cameraScreenRunner.f25278c.a(z10);
    }

    /* access modifiers changed from: private */
    public static final void L(CameraScreenRunner cameraScreenRunner, GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, androidx.lifecycle.g gVar, View view) {
        j.g(cameraScreenRunner, "this$0");
        j.g(cameraScreen, "$rendering");
        j.g(gVar, "$lifecycleScope");
        if (!cameraScreenRunner.z()) {
            cameraScreenRunner.O(cameraScreen, cameraScreen.t());
            cameraScreen.r().invoke();
            cameraScreenRunner.f25281f = j.d(gVar, x0.c(), (CoroutineStart) null, new CameraScreenRunner$showRendering$1$7$1(cameraScreen, cameraScreenRunner, (c<? super CameraScreenRunner$showRendering$1$7$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void M(CameraScreenRunner cameraScreenRunner, View view) {
        j.g(cameraScreenRunner, "this$0");
        cameraScreenRunner.f25278c.e();
    }

    /* access modifiers changed from: private */
    public static final void N(CameraScreenRunner cameraScreenRunner, GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, View view) {
        j.g(cameraScreenRunner, "this$0");
        j.g(cameraScreen, "$rendering");
        cameraScreenRunner.f25288m.k(cameraScreen.E(), cameraScreen.k());
    }

    private final void O(GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, long j10) {
        if (cameraScreen.F()) {
            Context context = this.f25277b.getRoot().getContext();
            j.e(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            androidx.lifecycle.g a10 = m.a((l) context);
            s1 unused = j.d(a10, x0.c(), (CoroutineStart) null, new CameraScreenRunner$startRecordingIfNeeded$1(this, a10, j10, (c<? super CameraScreenRunner$startRecordingIfNeeded$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void P(GovernmentIdFeed governmentIdFeed) {
        int[] iArr = new int[2];
        this.f25277b.f31932m.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        Rect rect = new Rect(i10, iArr[1], this.f25277b.f31932m.getWidth() + i10, iArr[1] + this.f25277b.f31932m.getHeight());
        View d10 = this.f25278c.d();
        d10.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        governmentIdFeed.q(rect, new Rect(i11, iArr[1], d10.getWidth() + i11, iArr[1] + d10.getHeight()));
    }

    private final void w(View view, float f10) {
        boolean z10;
        if (view.getAlpha() == f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (view.getVisibility() != 0) {
                if (f10 > 0.0f) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                } else {
                    return;
                }
            }
            view.animate().alpha(f10).withEndAction(new g(f10, view));
        } else if (f10 <= 0.0f) {
            view.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public static final void x(float f10, View view) {
        j.g(view, "$this_animateAlphaIfNeeded");
        if (f10 == 0.0f) {
            view.setVisibility(4);
        }
    }

    private final void y(StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle) {
        int i10;
        float f10;
        int i11;
        StepStyles$StepTextBasedComponentStyleContainer a10;
        TextBasedComponentStyle a11;
        String c10;
        ki.a aVar = this.f25277b;
        String p10 = stepStyles$GovernmentIdStepStyle.p();
        if (p10 != null) {
            i10 = Color.parseColor(p10);
        } else {
            i10 = -1;
        }
        Double q10 = stepStyles$GovernmentIdStepStyle.q();
        if (q10 != null) {
            f10 = (float) ti.b.a(q10.doubleValue());
        } else {
            f10 = 0.0f;
        }
        Double r10 = stepStyles$GovernmentIdStepStyle.r();
        if (r10 != null) {
            i11 = (int) Math.ceil(ti.b.a(r10.doubleValue()));
        } else {
            i11 = 0;
        }
        float f11 = (float) i11;
        aVar.G.setRadius(f10 + f11);
        TextBasedComponentStyle s10 = stepStyles$GovernmentIdStepStyle.s();
        if (s10 != null) {
            TextView textView = this.f25277b.f31936t;
            j.f(textView, "binding.overlayText");
            com.withpersona.sdk2.inquiry.steps.ui.styling.m.e(textView, s10);
        }
        StepStyles$GovernmentIdStepTextBasedComponentStyle O = stepStyles$GovernmentIdStepStyle.O();
        if (!(O == null || (a10 = O.a()) == null || (a11 = a10.a()) == null || (c10 = a11.c()) == null)) {
            TextView textView2 = this.f25277b.f31926f;
            j.f(textView2, "binding.disclaimer");
            com.withpersona.sdk2.inquiry.steps.ui.styling.m.d(textView2, c10);
        }
        View view = aVar.f31932m;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f10);
        gradientDrawable.setStroke(i11, i10);
        view.setBackground(gradientDrawable);
        ConstraintLayout constraintLayout = aVar.f31934p;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        int a12 = i11 + ((int) ti.b.a(12.0d));
        gradientDrawable2.setStroke(a12, 0);
        gradientDrawable2.setColor(-1);
        float f12 = f10 - ((float) (a12 / 2));
        gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f12, f12, f12, f12});
        constraintLayout.setBackground(gradientDrawable2);
        String k10 = stepStyles$GovernmentIdStepStyle.k();
        if (k10 != null) {
            this.f25277b.f31935q.I(Color.parseColor("#000000"), Color.parseColor(k10));
        }
        String j10 = stepStyles$GovernmentIdStepStyle.j();
        if (j10 != null) {
            this.f25277b.f31935q.I(Color.parseColor("#43957D"), Color.parseColor(j10));
        }
        aVar.D.setStrokeWidth(f11);
        aVar.D.setCornerRadius(f10);
        aVar.D.setHighlightColor(Color.parseColor(stepStyles$GovernmentIdStepStyle.C()));
    }

    private final boolean z() {
        s1 s1Var = this.f25281f;
        if (s1Var == null || !s1Var.a()) {
            return false;
        }
        return true;
    }

    /* renamed from: J */
    public void a(GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, p pVar) {
        int i10;
        boolean z10;
        j.g(cameraScreen, "rendering");
        j.g(pVar, "viewEnvironment");
        ki.a aVar = this.f25277b;
        Context context = aVar.getRoot().getContext();
        j.e(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        androidx.lifecycle.g a10 = m.a((l) context);
        this.f25278c.prepare();
        this.f25278c.d().setVisibility(0);
        this.f25278c.f(cameraScreen.o());
        Integer num = this.f25287l;
        int d10 = cameraScreen.d();
        if (num == null || num.intValue() != d10) {
            this.f25279d.m(n.b(cameraScreen.e()), cameraScreen.c(), p.e(new com.withpersona.sdk2.camera.analyzers.c()));
            this.f25287l = Integer.valueOf(cameraScreen.d());
        }
        this.f25284i = cameraScreen.w();
        this.f25285j = cameraScreen.l();
        aVar.f31936t.setText(cameraScreen.u());
        aVar.f31926f.setText(cameraScreen.n());
        ImageView imageView = aVar.f31927g;
        if (r.w(cameraScreen.n())) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        imageView.setVisibility(i10);
        String n10 = cameraScreen.n();
        if (n10 == null || r.w(n10)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || aVar.f31927g.getVisibility() != 8) {
            aVar.f31928h.setVisibility(0);
        } else {
            aVar.f31928h.setVisibility(8);
        }
        if (cameraScreen.q() == null) {
            aVar.f31930k.setVisibility(8);
        } else {
            aVar.f31930k.setVisibility(0);
            aVar.f31930k.setText(cameraScreen.q());
        }
        Context context2 = aVar.f31936t.getContext();
        j.f(context2, "overlayText.context");
        if (ti.a.d(context2) && aVar.f31936t.getParent() != null) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(Opcodes.ACC_ENUM);
            if (cameraScreen.q() != null) {
                obtain.getText().add(cameraScreen.q());
            } else {
                int i11 = b.f25290a[cameraScreen.e().ordinal()];
                if (i11 == 1 || i11 == 2 || i11 == 3) {
                    obtain.getText().add(aVar.f31936t.getContext().getString(o0.pi2_governmentid_talkback_front_hint));
                } else if (i11 == 4) {
                    obtain.getText().add(aVar.f31936t.getContext().getString(o0.pi2_governmentid_talkback_dl_back_hint));
                } else if (i11 == 5) {
                    obtain.getText().add(aVar.f31936t.getContext().getString(o0.pi2_governmentid_talkback_dl_barcode_hint));
                }
                obtain.getText().add(aVar.f31932m.getContext().getString(o0.pi2_governmentid_talkback_hold_hint));
            }
            aVar.f31936t.getParent().requestSendAccessibilityEvent(aVar.f31936t, obtain);
        }
        int i12 = b.f25291b[cameraScreen.j().ordinal()];
        if (i12 == 1) {
            aVar.f31922b.setEnabled(false);
        } else if (i12 == 2) {
            aVar.f31922b.setVisibility(0);
            aVar.f31922b.setEnabled(true);
        } else if (i12 == 3) {
            aVar.f31922b.setVisibility(4);
        }
        if (n.b(context, h0.personaIdFrameCenterText, (TypedValue) null, false, 6, (Object) null)) {
            aVar.f31936t.setGravity(17);
            TextView textView = aVar.f31936t;
            j.f(textView, "overlayText");
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMarginStart(0);
                textView.setLayoutParams(marginLayoutParams);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        Integer f10 = n.f(context, h0.personaLockImage, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            aVar.f31927g.setImageResource(f10.intValue());
        }
        f0 b10 = e0.b(context, cameraScreen.A());
        if (this.f25280e != b10.b()) {
            this.f25280e = b10.b();
            aVar.f31935q.setAnimation(b10.b());
        }
        aVar.f31933n.setImageResource(b10.a());
        aVar.f31932m.setBackground(e0.a(context, h0.personaIdFrameCaptureStyle));
        Integer f11 = n.f(context, h0.personaIdFrameScanningSweepLottieRaw, (TypedValue) null, false, 6, (Object) null);
        if (f11 != null) {
            aVar.C.setAnimation(f11.intValue());
            aVar.f31932m.setVisibility(0);
            aVar.D.setVisibility(8);
        } else {
            aVar.C.setVisibility(4);
            aVar.f31932m.setVisibility(4);
            aVar.D.setVisibility(0);
        }
        if ((cameraScreen.A() instanceof GovernmentIdWorkflow.Screen.Overlay.Custom) && this.f25282g == null) {
            this.f25282g = ImagesKt.k(context, ((GovernmentIdWorkflow.Screen.Overlay.Custom) cameraScreen.A()).a());
            aVar.getRoot().addView(this.f25282g);
            aVar.C.setVisibility(4);
            aVar.f31933n.setVisibility(4);
            View view = this.f25282g;
            if (view != null) {
                k.b(view, new CameraScreenRunner$showRendering$1$2(this, aVar));
            }
        }
        StepStyles$GovernmentIdStepStyle E = cameraScreen.E();
        if (E != null) {
            y(E);
            int color = androidx.core.content.a.getColor(this.f25277b.getRoot().getContext(), i0.blackScreenStatusBarColor);
            Context context3 = this.f25277b.getRoot().getContext();
            j.f(context3, "binding.root.context");
            ti.a.f(context3, color);
        }
        this.f25277b.f31931l.setState(new NavigationUiState(cameraScreen.h(), new CameraScreenRunner$showRendering$1$4(cameraScreen), cameraScreen.i(), new CameraScreenRunner$showRendering$1$5(cameraScreen)));
        aVar.f31929j.setOnCheckedChangeListener(new c(this));
        aVar.f31922b.setOnClickListener(new d(this, cameraScreen, a10));
        this.f25278c.d().setOnClickListener(new e(this));
        if (cameraScreen.f() && !z()) {
            O(cameraScreen, cameraScreen.t());
            this.f25281f = j.d(a10, x0.c(), (CoroutineStart) null, new CameraScreenRunner$showRendering$1$9(cameraScreen, this, (c<? super CameraScreenRunner$showRendering$1$9>) null), 2, (Object) null);
        }
        k.b(this.f25278c.d(), new CameraScreenRunner$showRendering$1$10(this));
        A(cameraScreen);
        if (cameraScreen.k() == null) {
            aVar.f31925e.setVisibility(4);
        } else {
            aVar.f31925e.setVisibility(0);
            aVar.f31925e.setText(cameraScreen.k().b());
            aVar.f31925e.setOnClickListener(new f(this, cameraScreen));
        }
        if (cameraScreen.p()) {
            s1 s1Var = this.f25283h;
            if (s1Var != null) {
                s1.a.a(s1Var, (CancellationException) null, 1, (Object) null);
            }
            s1 unused = j.d(a10, x0.c(), (CoroutineStart) null, new CameraScreenRunner$showRendering$1$12(this, cameraScreen, (c<? super CameraScreenRunner$showRendering$1$12>) null), 2, (Object) null);
        }
    }
}
