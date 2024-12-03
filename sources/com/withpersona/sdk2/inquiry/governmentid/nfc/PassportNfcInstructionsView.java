package com.withpersona.sdk2.inquiry.governmentid.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.steps.ui.UiScreen;
import com.withpersona.sdk2.inquiry.steps.ui.m;
import java.io.Serializable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import vi.b;

public final class PassportNfcInstructionsView implements com.squareup.workflow1.ui.a<PassportNfcInstructionsView>, Parcelable {
    public static final Parcelable.Creator<PassportNfcInstructionsView> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final UiScreen f25930a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25931b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25932c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f25933d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25934e;

    /* renamed from: f  reason: collision with root package name */
    private final Function0<Unit> f25935f;

    /* renamed from: g  reason: collision with root package name */
    private final Function0<Unit> f25936g;

    /* renamed from: h  reason: collision with root package name */
    private final r<PassportNfcInstructionsView> f25937h;

    public static final class a implements Parcelable.Creator<PassportNfcInstructionsView> {
        /* renamed from: a */
        public final PassportNfcInstructionsView createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcInstructionsView((UiScreen) parcel.readParcelable(PassportNfcInstructionsView.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0, (Function0) parcel.readSerializable(), parcel.readInt() != 0, (Function0) parcel.readSerializable(), (Function0) parcel.readSerializable());
        }

        /* renamed from: b */
        public final PassportNfcInstructionsView[] newArray(int i10) {
            return new PassportNfcInstructionsView[i10];
        }
    }

    public PassportNfcInstructionsView(UiScreen uiScreen, String str, boolean z10, Function0<Unit> function0, boolean z11, Function0<Unit> function02, Function0<Unit> function03) {
        j.g(uiScreen, "uiScreen");
        j.g(function0, "onBack");
        j.g(function02, "onCancel");
        j.g(function03, "onNext");
        this.f25930a = uiScreen;
        this.f25931b = str;
        this.f25932c = z10;
        this.f25933d = function0;
        this.f25934e = z11;
        this.f25935f = function02;
        this.f25936g = function03;
        m mVar = m.f27597a;
        PassportNfcInstructionsView$viewFactory$1 passportNfcInstructionsView$viewFactory$1 = new PassportNfcInstructionsView$viewFactory$1(this);
        f.a aVar = f.f23238a;
        this.f25937h = new ViewBindingViewFactory(l.b(PassportNfcInstructionsView.class), PassportNfcInstructionsView$special$$inlined$getViewFactoryForScreen$default$1.f25938a, new PassportNfcInstructionsView$special$$inlined$getViewFactoryForScreen$default$2(uiScreen, (Function2) null, passportNfcInstructionsView$viewFactory$1));
    }

    /* access modifiers changed from: private */
    public final void g(b bVar, PassportNfcInstructionsView passportNfcInstructionsView, p pVar, Map<String, com.withpersona.sdk2.inquiry.steps.ui.a> map) {
        View d10;
        com.withpersona.sdk2.inquiry.steps.ui.a aVar = map.get(this.f25931b);
        if (!(aVar == null || (d10 = aVar.d()) == null)) {
            d10.setOnClickListener(new c(this));
        }
        bVar.f33904e.setState(new NavigationUiState(passportNfcInstructionsView.f25932c, new PassportNfcInstructionsView$showRendering$1$2(passportNfcInstructionsView), passportNfcInstructionsView.f25934e, new PassportNfcInstructionsView$showRendering$1$3(passportNfcInstructionsView)));
    }

    /* access modifiers changed from: private */
    public static final void h(PassportNfcInstructionsView passportNfcInstructionsView, View view) {
        j.g(passportNfcInstructionsView, "this$0");
        passportNfcInstructionsView.f25936g.invoke();
    }

    public r<PassportNfcInstructionsView> a() {
        return this.f25937h;
    }

    public int describeContents() {
        return 0;
    }

    public final Function0<Unit> e() {
        return this.f25933d;
    }

    public final Function0<Unit> f() {
        return this.f25935f;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeParcelable(this.f25930a, i10);
        parcel.writeString(this.f25931b);
        parcel.writeInt(this.f25932c ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25933d);
        parcel.writeInt(this.f25934e ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25935f);
        parcel.writeSerializable((Serializable) this.f25936g);
    }
}
