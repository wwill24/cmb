package com.withpersona.sdk2.inquiry.governmentid;

import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import coil.ImageLoader;
import coil.request.g;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.governmentid.ReviewSelectedImageView;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import java.io.File;
import ki.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import ti.o;

public final class ReviewSelectedImageView$special$$inlined$bind$1 extends Lambda implements Function1<f, com.squareup.workflow1.ui.f<ReviewSelectedImageView>> {
    final /* synthetic */ ReviewSelectedImageView this$0;

    public static final class a<RenderingT> implements com.squareup.workflow1.ui.f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z1.a f25738b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReviewSelectedImageView f25739c;

        public a(z1.a aVar, ReviewSelectedImageView reviewSelectedImageView) {
            this.f25738b = aVar;
            this.f25739c = reviewSelectedImageView;
        }

        public final void a(RenderingT renderingt, p pVar) {
            RenderingT renderingt2 = renderingt;
            j.g(renderingt2, "rendering");
            j.g(pVar, "viewEnvironment");
            ReviewSelectedImageView reviewSelectedImageView = (ReviewSelectedImageView) renderingt2;
            f fVar = (f) this.f25738b;
            fVar.f31995j.setText(reviewSelectedImageView.t());
            fVar.f31988b.setText(reviewSelectedImageView.e());
            fVar.f31996k.setText(this.f25739c.h());
            fVar.f31996k.setOnClickListener(new ReviewSelectedImageView.a(this.f25739c));
            fVar.f31989c.setText(this.f25739c.g());
            fVar.f31989c.setOnClickListener(new ReviewSelectedImageView.b(this.f25739c));
            File file = new File(this.f25739c.l());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.f25739c.l(), options);
            if (r.J(this.f25739c.j(), "image/", false, 2, (Object) null)) {
                ImageView imageView = fVar.f31992f;
                j.f(imageView, "imageView");
                ImageLoader m10 = this.f25739c.m();
                g.a p10 = new g.a(imageView.getContext()).d(file).p(imageView);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setSize(options.outWidth, options.outHeight);
                gradientDrawable.setColor(0);
                p10.g(gradientDrawable);
                m10.a(p10.a());
            } else {
                fVar.f31992f.setVisibility(8);
                fVar.f31990d.setVisibility(0);
                fVar.f31991e.setVisibility(0);
                fVar.f31991e.setText(this.f25739c.k());
            }
            fVar.f31994h.setState(new NavigationUiState(reviewSelectedImageView.d(), new ReviewSelectedImageView$viewFactory$2$4(reviewSelectedImageView), reviewSelectedImageView.f(), new ReviewSelectedImageView$viewFactory$2$5(reviewSelectedImageView)));
            ScrollView b10 = fVar.getRoot();
            j.f(b10, "root");
            o.b(b10, reviewSelectedImageView.i(), reviewSelectedImageView.q(), (View) null, 0, 0, 56, (Object) null);
            StepStyles$GovernmentIdStepStyle s10 = this.f25739c.s();
            if (s10 != null) {
                ReviewSelectedImageView reviewSelectedImageView2 = this.f25739c;
                ScrollView b11 = fVar.getRoot();
                j.f(b11, "root");
                Pi2NavigationBar pi2NavigationBar = fVar.f31994h;
                j.f(pi2NavigationBar, "navigationBar");
                TextView textView = fVar.f31995j;
                j.f(textView, "title");
                TextView textView2 = fVar.f31988b;
                j.f(textView2, "body");
                Button button = fVar.f31996k;
                j.f(button, "usePhotoButton");
                Button button2 = fVar.f31989c;
                j.f(button2, "chooseNewPhotoButton");
                reviewSelectedImageView2.c(s10, b11, pi2NavigationBar, textView, textView2, button, button2);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReviewSelectedImageView$special$$inlined$bind$1(ReviewSelectedImageView reviewSelectedImageView) {
        super(1);
        this.this$0 = reviewSelectedImageView;
    }

    /* renamed from: a */
    public final com.squareup.workflow1.ui.f<ReviewSelectedImageView> invoke(f fVar) {
        j.g(fVar, "binding");
        return new a(fVar, this.this$0);
    }
}
