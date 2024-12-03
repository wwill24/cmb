package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.button.MaterialButton;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.governmentid.ChooseCaptureMethodView;
import com.withpersona.sdk2.inquiry.governmentid.network.CaptureOptionNativeMobile;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import ki.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import ti.o;

public final class ChooseCaptureMethodView$special$$inlined$bind$1 extends Lambda implements Function1<c, f<ChooseCaptureMethodView>> {
    final /* synthetic */ ChooseCaptureMethodView this$0;

    public static final class a<RenderingT> implements f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z1.a f25308b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ChooseCaptureMethodView f25309c;

        public a(z1.a aVar, ChooseCaptureMethodView chooseCaptureMethodView) {
            this.f25308b = aVar;
            this.f25309c = chooseCaptureMethodView;
        }

        public final void a(RenderingT renderingt, p pVar) {
            RenderingT renderingt2 = renderingt;
            j.g(renderingt2, "rendering");
            j.g(pVar, "viewEnvironment");
            ChooseCaptureMethodView chooseCaptureMethodView = (ChooseCaptureMethodView) renderingt2;
            c cVar = (c) this.f25308b;
            Context context = cVar.getRoot().getContext();
            cVar.f31958j.setText(chooseCaptureMethodView.p());
            cVar.f31951b.setText(chooseCaptureMethodView.f());
            if (this.f25309c.i().contains(CaptureOptionNativeMobile.MOBILE_CAMERA)) {
                if (!r.w(this.f25309c.g())) {
                    cVar.f31952c.setText(this.f25309c.g());
                    cVar.f31952c.setIcon((Drawable) null);
                } else {
                    cVar.f31952c.setText((CharSequence) null);
                    cVar.f31952c.setIcon(e.a.b(context, k0.pi2_governmentid_cameraicon));
                }
                cVar.f31952c.setOnClickListener(new ChooseCaptureMethodView.b(chooseCaptureMethodView));
            }
            if (this.f25309c.i().contains(CaptureOptionNativeMobile.UPLOAD)) {
                cVar.f31959k.setText(chooseCaptureMethodView.q());
                cVar.f31959k.setOnClickListener(new ChooseCaptureMethodView.c(chooseCaptureMethodView));
            }
            cVar.f31957h.setState(new NavigationUiState(chooseCaptureMethodView.e(), new ChooseCaptureMethodView$viewFactory$2$3(chooseCaptureMethodView), chooseCaptureMethodView.h(), new ChooseCaptureMethodView$viewFactory$2$4(chooseCaptureMethodView)));
            CoordinatorLayout b10 = cVar.getRoot();
            j.f(b10, "root");
            o.b(b10, chooseCaptureMethodView.getError(), chooseCaptureMethodView.m(), (View) null, 0, 0, 56, (Object) null);
            cVar.f31954e.setAnimation(n0.pi2_upload_gov_id_front_lottie);
            cVar.f31953d.setAnimation(n0.pi2_upload_gov_id_back_lottie);
            StepStyles$GovernmentIdStepStyle o10 = this.f25309c.o();
            if (o10 != null) {
                ChooseCaptureMethodView chooseCaptureMethodView2 = this.f25309c;
                CoordinatorLayout b11 = cVar.getRoot();
                j.f(b11, "root");
                Pi2NavigationBar pi2NavigationBar = cVar.f31957h;
                j.f(pi2NavigationBar, "navigationBar");
                TextView textView = cVar.f31958j;
                j.f(textView, "title");
                TextView textView2 = cVar.f31951b;
                j.f(textView2, "body");
                MaterialButton materialButton = cVar.f31952c;
                j.f(materialButton, "cameraButton");
                Button button = cVar.f31959k;
                j.f(button, "uploadButton");
                ThemeableLottieAnimationView themeableLottieAnimationView = cVar.f31954e;
                j.f(themeableLottieAnimationView, "idFront");
                ThemeableLottieAnimationView themeableLottieAnimationView2 = cVar.f31953d;
                j.f(themeableLottieAnimationView2, "idBack");
                View view = cVar.f31955f;
                j.f(view, "idImageContainer");
                chooseCaptureMethodView2.d(o10, b11, pi2NavigationBar, textView, textView2, materialButton, button, themeableLottieAnimationView, themeableLottieAnimationView2, view);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseCaptureMethodView$special$$inlined$bind$1(ChooseCaptureMethodView chooseCaptureMethodView) {
        super(1);
        this.this$0 = chooseCaptureMethodView;
    }

    /* renamed from: a */
    public final f<ChooseCaptureMethodView> invoke(c cVar) {
        j.g(cVar, "binding");
        return new a(cVar, this.this$0);
    }
}
