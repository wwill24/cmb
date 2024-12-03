package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.governmentid.network.CaptureOptionNativeMobile;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCancelComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import org.apache.commons.beanutils.PropertyUtils;

public final class ChooseCaptureMethodView implements com.squareup.workflow1.ui.a<ChooseCaptureMethodView>, Parcelable {
    public static final Parcelable.Creator<ChooseCaptureMethodView> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<CaptureOptionNativeMobile> f25293a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25294b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25295c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25296d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25297e;

    /* renamed from: f  reason: collision with root package name */
    private final Function0<Unit> f25298f;

    /* renamed from: g  reason: collision with root package name */
    private final Function0<Unit> f25299g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f25300h;

    /* renamed from: j  reason: collision with root package name */
    private final Function0<Unit> f25301j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f25302k;

    /* renamed from: l  reason: collision with root package name */
    private final Function0<Unit> f25303l;

    /* renamed from: m  reason: collision with root package name */
    private final String f25304m;

    /* renamed from: n  reason: collision with root package name */
    private final Function0<Unit> f25305n;

    /* renamed from: p  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepStyle f25306p;

    /* renamed from: q  reason: collision with root package name */
    private final r<ChooseCaptureMethodView> f25307q = new ViewBindingViewFactory(l.b(ChooseCaptureMethodView.class), ChooseCaptureMethodView$viewFactory$1.f25312a, new ChooseCaptureMethodView$special$$inlined$bind$1(this));

    public static final class a implements Parcelable.Creator<ChooseCaptureMethodView> {
        /* renamed from: a */
        public final ChooseCaptureMethodView createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            j.g(parcel2, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(CaptureOptionNativeMobile.valueOf(parcel.readString()));
            }
            return new ChooseCaptureMethodView(arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Function0) parcel.readSerializable(), (Function0) parcel.readSerializable(), parcel.readInt() != 0, (Function0) parcel.readSerializable(), parcel.readInt() != 0, (Function0) parcel.readSerializable(), parcel.readString(), (Function0) parcel.readSerializable(), (StepStyles$GovernmentIdStepStyle) parcel2.readParcelable(ChooseCaptureMethodView.class.getClassLoader()));
        }

        /* renamed from: b */
        public final ChooseCaptureMethodView[] newArray(int i10) {
            return new ChooseCaptureMethodView[i10];
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChooseCaptureMethodView f25310a;

        b(ChooseCaptureMethodView chooseCaptureMethodView) {
            this.f25310a = chooseCaptureMethodView;
        }

        public final void onClick(View view) {
            this.f25310a.k().invoke();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChooseCaptureMethodView f25311a;

        c(ChooseCaptureMethodView chooseCaptureMethodView) {
            this.f25311a = chooseCaptureMethodView;
        }

        public final void onClick(View view) {
            this.f25311a.n().invoke();
        }
    }

    public ChooseCaptureMethodView(List<? extends CaptureOptionNativeMobile> list, String str, String str2, String str3, String str4, Function0<Unit> function0, Function0<Unit> function02, boolean z10, Function0<Unit> function03, boolean z11, Function0<Unit> function04, String str5, Function0<Unit> function05, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle) {
        j.g(list, "captureOptions");
        j.g(str, "title");
        j.g(str2, "body");
        j.g(str3, "cameraText");
        j.g(str4, "uploadButtonText");
        j.g(function0, "onCameraCaptureClick");
        j.g(function02, "onUploadClick");
        j.g(function03, "onBack");
        j.g(function04, "onCancel");
        j.g(function05, "onErrorDismissed");
        this.f25293a = list;
        this.f25294b = str;
        this.f25295c = str2;
        this.f25296d = str3;
        this.f25297e = str4;
        this.f25298f = function0;
        this.f25299g = function02;
        this.f25300h = z10;
        this.f25301j = function03;
        this.f25302k = z11;
        this.f25303l = function04;
        this.f25304m = str5;
        this.f25305n = function05;
        this.f25306p = stepStyles$GovernmentIdStepStyle;
        f.a aVar = f.f23238a;
    }

    /* access modifiers changed from: private */
    public final void d(StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, View view, Pi2NavigationBar pi2NavigationBar, TextView textView, TextView textView2, Button button, Button button2, ThemeableLottieAnimationView themeableLottieAnimationView, ThemeableLottieAnimationView themeableLottieAnimationView2, View view2) {
        View view3 = view;
        String V1 = stepStyles$GovernmentIdStepStyle.V1();
        if (V1 != null) {
            view.setBackgroundColor(Color.parseColor(V1));
            Context context = view.getContext();
            j.f(context, "root.context");
            ti.a.f(context, Color.parseColor(V1));
        }
        Context context2 = view.getContext();
        j.f(context2, "root.context");
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle2 = stepStyles$GovernmentIdStepStyle;
        Drawable r12 = stepStyles$GovernmentIdStepStyle.r1(context2);
        if (r12 != null) {
            view.setBackground(r12);
        }
        String G = stepStyles$GovernmentIdStepStyle.G();
        if (G != null) {
            Pi2NavigationBar pi2NavigationBar2 = pi2NavigationBar;
            pi2NavigationBar.setControlsColor(Color.parseColor(G));
        }
        TextBasedComponentStyle e12 = stepStyles$GovernmentIdStepStyle.e1();
        if (e12 != null) {
            TextView textView3 = textView;
            m.e(textView, e12);
        }
        TextBasedComponentStyle H1 = stepStyles$GovernmentIdStepStyle.H1();
        if (H1 != null) {
            TextView textView4 = textView2;
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
        String A0 = stepStyles$GovernmentIdStepStyle.A0();
        if (A0 != null) {
            view2.setBackground(new ColorDrawable(Color.parseColor(A0)));
        }
        ImageStylingKt.e(themeableLottieAnimationView, stepStyles$GovernmentIdStepStyle.C(), stepStyles$GovernmentIdStepStyle.A0(), stepStyles$GovernmentIdStepStyle.A0(), new String[]{"#000000", "#190051"}, new String[]{"#8751FF"}, new String[]{"#FFFFFF"});
        ImageStylingKt.e(themeableLottieAnimationView2, stepStyles$GovernmentIdStepStyle.C(), stepStyles$GovernmentIdStepStyle.A0(), stepStyles$GovernmentIdStepStyle.A0(), new String[]{"#000000", "#190051"}, new String[]{"#AA84FF"}, new String[]{"#FFFFFF"});
    }

    public r<ChooseCaptureMethodView> a() {
        return this.f25307q;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return this.f25300h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChooseCaptureMethodView)) {
            return false;
        }
        ChooseCaptureMethodView chooseCaptureMethodView = (ChooseCaptureMethodView) obj;
        return j.b(this.f25293a, chooseCaptureMethodView.f25293a) && j.b(this.f25294b, chooseCaptureMethodView.f25294b) && j.b(this.f25295c, chooseCaptureMethodView.f25295c) && j.b(this.f25296d, chooseCaptureMethodView.f25296d) && j.b(this.f25297e, chooseCaptureMethodView.f25297e) && j.b(this.f25298f, chooseCaptureMethodView.f25298f) && j.b(this.f25299g, chooseCaptureMethodView.f25299g) && this.f25300h == chooseCaptureMethodView.f25300h && j.b(this.f25301j, chooseCaptureMethodView.f25301j) && this.f25302k == chooseCaptureMethodView.f25302k && j.b(this.f25303l, chooseCaptureMethodView.f25303l) && j.b(this.f25304m, chooseCaptureMethodView.f25304m) && j.b(this.f25305n, chooseCaptureMethodView.f25305n) && j.b(this.f25306p, chooseCaptureMethodView.f25306p);
    }

    public final String f() {
        return this.f25295c;
    }

    public final String g() {
        return this.f25296d;
    }

    public final String getError() {
        return this.f25304m;
    }

    public final boolean h() {
        return this.f25302k;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.f25293a.hashCode() * 31) + this.f25294b.hashCode()) * 31) + this.f25295c.hashCode()) * 31) + this.f25296d.hashCode()) * 31) + this.f25297e.hashCode()) * 31) + this.f25298f.hashCode()) * 31) + this.f25299g.hashCode()) * 31;
        boolean z10 = this.f25300h;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int hashCode2 = (((hashCode + (z10 ? 1 : 0)) * 31) + this.f25301j.hashCode()) * 31;
        boolean z12 = this.f25302k;
        if (!z12) {
            z11 = z12;
        }
        int hashCode3 = (((hashCode2 + (z11 ? 1 : 0)) * 31) + this.f25303l.hashCode()) * 31;
        String str = this.f25304m;
        int i10 = 0;
        int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.f25305n.hashCode()) * 31;
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle = this.f25306p;
        if (stepStyles$GovernmentIdStepStyle != null) {
            i10 = stepStyles$GovernmentIdStepStyle.hashCode();
        }
        return hashCode4 + i10;
    }

    public final List<CaptureOptionNativeMobile> i() {
        return this.f25293a;
    }

    public final Function0<Unit> j() {
        return this.f25301j;
    }

    public final Function0<Unit> k() {
        return this.f25298f;
    }

    public final Function0<Unit> l() {
        return this.f25303l;
    }

    public final Function0<Unit> m() {
        return this.f25305n;
    }

    public final Function0<Unit> n() {
        return this.f25299g;
    }

    public final StepStyles$GovernmentIdStepStyle o() {
        return this.f25306p;
    }

    public final String p() {
        return this.f25294b;
    }

    public final String q() {
        return this.f25297e;
    }

    public String toString() {
        return "ChooseCaptureMethodView(captureOptions=" + this.f25293a + ", title=" + this.f25294b + ", body=" + this.f25295c + ", cameraText=" + this.f25296d + ", uploadButtonText=" + this.f25297e + ", onCameraCaptureClick=" + this.f25298f + ", onUploadClick=" + this.f25299g + ", backStepEnabled=" + this.f25300h + ", onBack=" + this.f25301j + ", cancelButtonEnabled=" + this.f25302k + ", onCancel=" + this.f25303l + ", error=" + this.f25304m + ", onErrorDismissed=" + this.f25305n + ", styles=" + this.f25306p + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<CaptureOptionNativeMobile> list = this.f25293a;
        parcel.writeInt(list.size());
        for (CaptureOptionNativeMobile name : list) {
            parcel.writeString(name.name());
        }
        parcel.writeString(this.f25294b);
        parcel.writeString(this.f25295c);
        parcel.writeString(this.f25296d);
        parcel.writeString(this.f25297e);
        parcel.writeSerializable((Serializable) this.f25298f);
        parcel.writeSerializable((Serializable) this.f25299g);
        parcel.writeInt(this.f25300h ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25301j);
        parcel.writeInt(this.f25302k ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25303l);
        parcel.writeString(this.f25304m);
        parcel.writeSerializable((Serializable) this.f25305n);
        parcel.writeParcelable(this.f25306p, i10);
    }
}
