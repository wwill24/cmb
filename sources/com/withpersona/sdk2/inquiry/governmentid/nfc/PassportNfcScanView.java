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

public final class PassportNfcScanView implements com.squareup.workflow1.ui.a<PassportNfcScanView>, Parcelable {
    public static final Parcelable.Creator<PassportNfcScanView> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final UiScreen f25964a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25965b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25966c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f25967d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25968e;

    /* renamed from: f  reason: collision with root package name */
    private final Function0<Unit> f25969f;

    /* renamed from: g  reason: collision with root package name */
    private final Function0<Unit> f25970g;

    /* renamed from: h  reason: collision with root package name */
    private final r<PassportNfcScanView> f25971h;

    public static final class a implements Parcelable.Creator<PassportNfcScanView> {
        /* renamed from: a */
        public final PassportNfcScanView createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcScanView((UiScreen) parcel.readParcelable(PassportNfcScanView.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0, (Function0) parcel.readSerializable(), parcel.readInt() != 0, (Function0) parcel.readSerializable(), (Function0) parcel.readSerializable());
        }

        /* renamed from: b */
        public final PassportNfcScanView[] newArray(int i10) {
            return new PassportNfcScanView[i10];
        }
    }

    public PassportNfcScanView(UiScreen uiScreen, String str, boolean z10, Function0<Unit> function0, boolean z11, Function0<Unit> function02, Function0<Unit> function03) {
        j.g(uiScreen, "uiScreen");
        j.g(function0, "onBack");
        j.g(function02, "onCancel");
        j.g(function03, "onNext");
        this.f25964a = uiScreen;
        this.f25965b = str;
        this.f25966c = z10;
        this.f25967d = function0;
        this.f25968e = z11;
        this.f25969f = function02;
        this.f25970g = function03;
        m mVar = m.f27597a;
        PassportNfcScanView$viewFactory$1 passportNfcScanView$viewFactory$1 = new PassportNfcScanView$viewFactory$1(this);
        f.a aVar = f.f23238a;
        this.f25971h = new ViewBindingViewFactory(l.b(PassportNfcScanView.class), PassportNfcScanView$special$$inlined$getViewFactoryForScreen$default$1.f25972a, new PassportNfcScanView$special$$inlined$getViewFactoryForScreen$default$2(uiScreen, (Function2) null, passportNfcScanView$viewFactory$1));
    }

    /* access modifiers changed from: private */
    public final void g(b bVar, PassportNfcScanView passportNfcScanView, p pVar, Map<String, com.withpersona.sdk2.inquiry.steps.ui.a> map) {
        View d10;
        com.withpersona.sdk2.inquiry.steps.ui.a aVar = map.get(this.f25965b);
        if (!(aVar == null || (d10 = aVar.d()) == null)) {
            d10.setOnClickListener(new e(this));
        }
        bVar.f33904e.setState(new NavigationUiState(passportNfcScanView.f25966c, new PassportNfcScanView$showRendering$1$2(passportNfcScanView), passportNfcScanView.f25968e, new PassportNfcScanView$showRendering$1$3(passportNfcScanView)));
    }

    /* access modifiers changed from: private */
    public static final void h(PassportNfcScanView passportNfcScanView, View view) {
        j.g(passportNfcScanView, "this$0");
        passportNfcScanView.f25970g.invoke();
    }

    public r<PassportNfcScanView> a() {
        return this.f25971h;
    }

    public int describeContents() {
        return 0;
    }

    public final Function0<Unit> e() {
        return this.f25967d;
    }

    public final Function0<Unit> f() {
        return this.f25969f;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeParcelable(this.f25964a, i10);
        parcel.writeString(this.f25965b);
        parcel.writeInt(this.f25966c ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25967d);
        parcel.writeInt(this.f25968e ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25969f);
        parcel.writeSerializable((Serializable) this.f25970g);
    }
}
