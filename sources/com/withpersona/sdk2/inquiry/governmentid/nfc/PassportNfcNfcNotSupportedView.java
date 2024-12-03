package com.withpersona.sdk2.inquiry.governmentid.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcConfirmDetailsPage;
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

public final class PassportNfcNfcNotSupportedView implements com.squareup.workflow1.ui.a<PassportNfcNfcNotSupportedView>, Parcelable {
    public static final Parcelable.Creator<PassportNfcNfcNotSupportedView> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final UiScreen f25942a;

    /* renamed from: b  reason: collision with root package name */
    private final PassportNfcConfirmDetailsPage f25943b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25944c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f25945d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25946e;

    /* renamed from: f  reason: collision with root package name */
    private final Function0<Unit> f25947f;

    /* renamed from: g  reason: collision with root package name */
    private final Function0<Unit> f25948g;

    /* renamed from: h  reason: collision with root package name */
    private final String f25949h;

    /* renamed from: j  reason: collision with root package name */
    private final r<PassportNfcNfcNotSupportedView> f25950j;

    public static final class a implements Parcelable.Creator<PassportNfcNfcNotSupportedView> {
        /* renamed from: a */
        public final PassportNfcNfcNotSupportedView createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcNfcNotSupportedView((UiScreen) parcel.readParcelable(PassportNfcNfcNotSupportedView.class.getClassLoader()), PassportNfcConfirmDetailsPage.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, (Function0) parcel.readSerializable(), parcel.readInt() != 0, (Function0) parcel.readSerializable(), (Function0) parcel.readSerializable(), parcel.readString());
        }

        /* renamed from: b */
        public final PassportNfcNfcNotSupportedView[] newArray(int i10) {
            return new PassportNfcNfcNotSupportedView[i10];
        }
    }

    public PassportNfcNfcNotSupportedView(UiScreen uiScreen, PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage, boolean z10, Function0<Unit> function0, boolean z11, Function0<Unit> function02, Function0<Unit> function03, String str) {
        j.g(uiScreen, "uiScreen");
        j.g(passportNfcConfirmDetailsPage, "passportNfcConfirmDetailsPage");
        j.g(function0, "onBack");
        j.g(function02, "onCancel");
        j.g(function03, "onNext");
        this.f25942a = uiScreen;
        this.f25943b = passportNfcConfirmDetailsPage;
        this.f25944c = z10;
        this.f25945d = function0;
        this.f25946e = z11;
        this.f25947f = function02;
        this.f25948g = function03;
        this.f25949h = str;
        m mVar = m.f27597a;
        PassportNfcNfcNotSupportedView$viewFactory$1 passportNfcNfcNotSupportedView$viewFactory$1 = new PassportNfcNfcNotSupportedView$viewFactory$1(this);
        f.a aVar = f.f23238a;
        this.f25950j = new ViewBindingViewFactory(l.b(PassportNfcNfcNotSupportedView.class), PassportNfcNfcNotSupportedView$special$$inlined$getViewFactoryForScreen$default$1.f25951a, new PassportNfcNfcNotSupportedView$special$$inlined$getViewFactoryForScreen$default$2(uiScreen, (Function2) null, passportNfcNfcNotSupportedView$viewFactory$1));
    }

    /* access modifiers changed from: private */
    public final void g(b bVar, PassportNfcNfcNotSupportedView passportNfcNfcNotSupportedView, p pVar, Map<String, com.withpersona.sdk2.inquiry.steps.ui.a> map) {
        View d10;
        com.withpersona.sdk2.inquiry.steps.ui.a aVar = map.get(this.f25949h);
        if (!(aVar == null || (d10 = aVar.d()) == null)) {
            d10.setOnClickListener(new d(this));
        }
        bVar.f33904e.setState(new NavigationUiState(passportNfcNfcNotSupportedView.f25944c, new PassportNfcNfcNotSupportedView$showRendering$1$2(passportNfcNfcNotSupportedView), passportNfcNfcNotSupportedView.f25946e, new PassportNfcNfcNotSupportedView$showRendering$1$3(passportNfcNfcNotSupportedView)));
    }

    /* access modifiers changed from: private */
    public static final void h(PassportNfcNfcNotSupportedView passportNfcNfcNotSupportedView, View view) {
        j.g(passportNfcNfcNotSupportedView, "this$0");
        passportNfcNfcNotSupportedView.f25948g.invoke();
    }

    public r<PassportNfcNfcNotSupportedView> a() {
        return this.f25950j;
    }

    public int describeContents() {
        return 0;
    }

    public final Function0<Unit> e() {
        return this.f25945d;
    }

    public final Function0<Unit> f() {
        return this.f25947f;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeParcelable(this.f25942a, i10);
        this.f25943b.writeToParcel(parcel, i10);
        parcel.writeInt(this.f25944c ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25945d);
        parcel.writeInt(this.f25946e ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25947f);
        parcel.writeSerializable((Serializable) this.f25948g);
        parcel.writeString(this.f25949h);
    }
}
