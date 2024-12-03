package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import coil.ImageLoader;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCancelComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import org.apache.commons.beanutils.PropertyUtils;

public final class ReviewSelectedImageView implements com.squareup.workflow1.ui.a<ReviewSelectedImageView> {

    /* renamed from: a  reason: collision with root package name */
    private final ImageLoader f25720a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25721b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25722c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25723d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25724e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25725f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25726g;

    /* renamed from: h  reason: collision with root package name */
    private final String f25727h;

    /* renamed from: j  reason: collision with root package name */
    private final Function0<Unit> f25728j;

    /* renamed from: k  reason: collision with root package name */
    private final Function0<Unit> f25729k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f25730l;

    /* renamed from: m  reason: collision with root package name */
    private final Function0<Unit> f25731m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f25732n;

    /* renamed from: p  reason: collision with root package name */
    private final Function0<Unit> f25733p;

    /* renamed from: q  reason: collision with root package name */
    private final String f25734q;

    /* renamed from: t  reason: collision with root package name */
    private final Function0<Unit> f25735t;

    /* renamed from: w  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepStyle f25736w;

    /* renamed from: x  reason: collision with root package name */
    private final r<ReviewSelectedImageView> f25737x = new ViewBindingViewFactory(l.b(ReviewSelectedImageView.class), ReviewSelectedImageView$viewFactory$1.f25742a, new ReviewSelectedImageView$special$$inlined$bind$1(this));

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReviewSelectedImageView f25740a;

        a(ReviewSelectedImageView reviewSelectedImageView) {
            this.f25740a = reviewSelectedImageView;
        }

        public final void onClick(View view) {
            this.f25740a.r().invoke();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReviewSelectedImageView f25741a;

        b(ReviewSelectedImageView reviewSelectedImageView) {
            this.f25741a = reviewSelectedImageView;
        }

        public final void onClick(View view) {
            this.f25741a.p().invoke();
        }
    }

    public ReviewSelectedImageView(ImageLoader imageLoader, String str, String str2, String str3, String str4, String str5, String str6, String str7, Function0<Unit> function0, Function0<Unit> function02, boolean z10, Function0<Unit> function03, boolean z11, Function0<Unit> function04, String str8, Function0<Unit> function05, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle) {
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        Function0<Unit> function06 = function0;
        Function0<Unit> function07 = function02;
        Function0<Unit> function08 = function03;
        Function0<Unit> function09 = function04;
        Function0<Unit> function010 = function05;
        j.g(imageLoader, "imageLoader");
        j.g(str9, "title");
        j.g(str10, "body");
        j.g(str11, "confirmButtonText");
        j.g(str12, "chooseNewPhotoText");
        j.g(str13, "fileToReviewPath");
        j.g(str14, "fileMimeType");
        j.g(function06, "onUsePhotoClick");
        j.g(function07, "onChooseNewPhotoClick");
        j.g(function08, "onBack");
        j.g(function09, "onCancel");
        j.g(function010, "onErrorDismissed");
        this.f25720a = imageLoader;
        this.f25721b = str9;
        this.f25722c = str10;
        this.f25723d = str11;
        this.f25724e = str12;
        this.f25725f = str13;
        this.f25726g = str14;
        this.f25727h = str7;
        this.f25728j = function06;
        this.f25729k = function07;
        this.f25730l = z10;
        this.f25731m = function08;
        this.f25732n = z11;
        this.f25733p = function09;
        this.f25734q = str8;
        this.f25735t = function010;
        this.f25736w = stepStyles$GovernmentIdStepStyle;
        f.a aVar = f.f23238a;
    }

    /* access modifiers changed from: private */
    public final void c(StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, View view, Pi2NavigationBar pi2NavigationBar, TextView textView, TextView textView2, Button button, Button button2) {
        String V1 = stepStyles$GovernmentIdStepStyle.V1();
        if (V1 != null) {
            view.setBackgroundColor(Color.parseColor(V1));
            Context context = view.getContext();
            j.f(context, "root.context");
            ti.a.f(context, Color.parseColor(V1));
        }
        Context context2 = view.getContext();
        j.f(context2, "root.context");
        Drawable r12 = stepStyles$GovernmentIdStepStyle.r1(context2);
        if (r12 != null) {
            view.setBackground(r12);
        }
        String G = stepStyles$GovernmentIdStepStyle.G();
        if (G != null) {
            pi2NavigationBar.setControlsColor(Color.parseColor(G));
        }
        TextBasedComponentStyle e12 = stepStyles$GovernmentIdStepStyle.e1();
        if (e12 != null) {
            m.e(textView, e12);
        }
        TextBasedComponentStyle H1 = stepStyles$GovernmentIdStepStyle.H1();
        if (H1 != null) {
            m.e(textView2, H1);
        }
        ButtonSubmitComponentStyle X1 = stepStyles$GovernmentIdStepStyle.X1();
        if (X1 != null) {
            ButtonStylingKt.c(button, X1, false, false, 6, (Object) null);
        }
        ButtonCancelComponentStyle v02 = stepStyles$GovernmentIdStepStyle.v0();
        if (v02 != null) {
            ButtonStylingKt.c(button2, v02, false, false, 6, (Object) null);
        }
    }

    public r<ReviewSelectedImageView> a() {
        return this.f25737x;
    }

    public final boolean d() {
        return this.f25730l;
    }

    public final String e() {
        return this.f25722c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReviewSelectedImageView)) {
            return false;
        }
        ReviewSelectedImageView reviewSelectedImageView = (ReviewSelectedImageView) obj;
        return j.b(this.f25720a, reviewSelectedImageView.f25720a) && j.b(this.f25721b, reviewSelectedImageView.f25721b) && j.b(this.f25722c, reviewSelectedImageView.f25722c) && j.b(this.f25723d, reviewSelectedImageView.f25723d) && j.b(this.f25724e, reviewSelectedImageView.f25724e) && j.b(this.f25725f, reviewSelectedImageView.f25725f) && j.b(this.f25726g, reviewSelectedImageView.f25726g) && j.b(this.f25727h, reviewSelectedImageView.f25727h) && j.b(this.f25728j, reviewSelectedImageView.f25728j) && j.b(this.f25729k, reviewSelectedImageView.f25729k) && this.f25730l == reviewSelectedImageView.f25730l && j.b(this.f25731m, reviewSelectedImageView.f25731m) && this.f25732n == reviewSelectedImageView.f25732n && j.b(this.f25733p, reviewSelectedImageView.f25733p) && j.b(this.f25734q, reviewSelectedImageView.f25734q) && j.b(this.f25735t, reviewSelectedImageView.f25735t) && j.b(this.f25736w, reviewSelectedImageView.f25736w);
    }

    public final boolean f() {
        return this.f25732n;
    }

    public final String g() {
        return this.f25724e;
    }

    public final String h() {
        return this.f25723d;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.f25720a.hashCode() * 31) + this.f25721b.hashCode()) * 31) + this.f25722c.hashCode()) * 31) + this.f25723d.hashCode()) * 31) + this.f25724e.hashCode()) * 31) + this.f25725f.hashCode()) * 31) + this.f25726g.hashCode()) * 31;
        String str = this.f25727h;
        int i10 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f25728j.hashCode()) * 31) + this.f25729k.hashCode()) * 31;
        boolean z10 = this.f25730l;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int hashCode3 = (((hashCode2 + (z10 ? 1 : 0)) * 31) + this.f25731m.hashCode()) * 31;
        boolean z12 = this.f25732n;
        if (!z12) {
            z11 = z12;
        }
        int hashCode4 = (((hashCode3 + (z11 ? 1 : 0)) * 31) + this.f25733p.hashCode()) * 31;
        String str2 = this.f25734q;
        int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f25735t.hashCode()) * 31;
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle = this.f25736w;
        if (stepStyles$GovernmentIdStepStyle != null) {
            i10 = stepStyles$GovernmentIdStepStyle.hashCode();
        }
        return hashCode5 + i10;
    }

    public final String i() {
        return this.f25734q;
    }

    public final String j() {
        return this.f25726g;
    }

    public final String k() {
        return this.f25727h;
    }

    public final String l() {
        return this.f25725f;
    }

    public final ImageLoader m() {
        return this.f25720a;
    }

    public final Function0<Unit> n() {
        return this.f25731m;
    }

    public final Function0<Unit> o() {
        return this.f25733p;
    }

    public final Function0<Unit> p() {
        return this.f25729k;
    }

    public final Function0<Unit> q() {
        return this.f25735t;
    }

    public final Function0<Unit> r() {
        return this.f25728j;
    }

    public final StepStyles$GovernmentIdStepStyle s() {
        return this.f25736w;
    }

    public final String t() {
        return this.f25721b;
    }

    public String toString() {
        return "ReviewSelectedImageView(imageLoader=" + this.f25720a + ", title=" + this.f25721b + ", body=" + this.f25722c + ", confirmButtonText=" + this.f25723d + ", chooseNewPhotoText=" + this.f25724e + ", fileToReviewPath=" + this.f25725f + ", fileMimeType=" + this.f25726g + ", fileName=" + this.f25727h + ", onUsePhotoClick=" + this.f25728j + ", onChooseNewPhotoClick=" + this.f25729k + ", backStepEnabled=" + this.f25730l + ", onBack=" + this.f25731m + ", cancelButtonEnabled=" + this.f25732n + ", onCancel=" + this.f25733p + ", error=" + this.f25734q + ", onErrorDismissed=" + this.f25735t + ", styles=" + this.f25736w + PropertyUtils.MAPPED_DELIM2;
    }
}
