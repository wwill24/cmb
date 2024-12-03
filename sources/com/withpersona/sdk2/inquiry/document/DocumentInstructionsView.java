package com.withpersona.sdk2.inquiry.document;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import vi.b;

public final class DocumentInstructionsView implements com.squareup.workflow1.ui.a<DocumentInstructionsView>, Parcelable {
    public static final Parcelable.Creator<DocumentInstructionsView> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final UiScreen f24976a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Pair<String, Function0<Unit>>> f24977b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24978c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f24979d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f24980e;

    /* renamed from: f  reason: collision with root package name */
    private final Function0<Unit> f24981f;

    /* renamed from: g  reason: collision with root package name */
    private final r<DocumentInstructionsView> f24982g;

    public static final class a implements Parcelable.Creator<DocumentInstructionsView> {
        /* renamed from: a */
        public final DocumentInstructionsView createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            UiScreen uiScreen = (UiScreen) parcel.readParcelable(DocumentInstructionsView.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(parcel.readSerializable());
            }
            return new DocumentInstructionsView(uiScreen, arrayList, parcel.readInt() != 0, (Function0) parcel.readSerializable(), parcel.readInt() != 0, (Function0) parcel.readSerializable());
        }

        /* renamed from: b */
        public final DocumentInstructionsView[] newArray(int i10) {
            return new DocumentInstructionsView[i10];
        }
    }

    public DocumentInstructionsView(UiScreen uiScreen, List<? extends Pair<String, ? extends Function0<Unit>>> list, boolean z10, Function0<Unit> function0, boolean z11, Function0<Unit> function02) {
        j.g(uiScreen, "uiScreen");
        j.g(list, "componentNamesToActions");
        j.g(function0, "onBack");
        j.g(function02, "onCancel");
        this.f24976a = uiScreen;
        this.f24977b = list;
        this.f24978c = z10;
        this.f24979d = function0;
        this.f24980e = z11;
        this.f24981f = function02;
        m mVar = m.f27597a;
        DocumentInstructionsView$viewFactory$1 documentInstructionsView$viewFactory$1 = new DocumentInstructionsView$viewFactory$1(this);
        f.a aVar = f.f23238a;
        this.f24982g = new ViewBindingViewFactory(l.b(DocumentInstructionsView.class), DocumentInstructionsView$special$$inlined$getViewFactoryForScreen$default$1.f24983a, new DocumentInstructionsView$special$$inlined$getViewFactoryForScreen$default$2(uiScreen, (Function2) null, documentInstructionsView$viewFactory$1));
    }

    /* access modifiers changed from: private */
    public final void g(b bVar, DocumentInstructionsView documentInstructionsView, p pVar, Map<String, com.withpersona.sdk2.inquiry.steps.ui.a> map) {
        View d10;
        for (Pair next : this.f24977b) {
            Function0 function0 = (Function0) next.d();
            com.withpersona.sdk2.inquiry.steps.ui.a aVar = map.get((String) next.c());
            if (!(aVar == null || (d10 = aVar.d()) == null)) {
                d10.setOnClickListener(new a(function0));
            }
        }
        bVar.f33904e.setState(new NavigationUiState(documentInstructionsView.f24978c, new DocumentInstructionsView$showRendering$1$2(documentInstructionsView), documentInstructionsView.f24980e, new DocumentInstructionsView$showRendering$1$3(documentInstructionsView)));
    }

    /* access modifiers changed from: private */
    public static final void h(Function0 function0, View view) {
        j.g(function0, "$action");
        function0.invoke();
    }

    public r<DocumentInstructionsView> a() {
        return this.f24982g;
    }

    public int describeContents() {
        return 0;
    }

    public final Function0<Unit> e() {
        return this.f24979d;
    }

    public final Function0<Unit> f() {
        return this.f24981f;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeParcelable(this.f24976a, i10);
        List<Pair<String, Function0<Unit>>> list = this.f24977b;
        parcel.writeInt(list.size());
        for (Pair<String, Function0<Unit>> writeSerializable : list) {
            parcel.writeSerializable(writeSerializable);
        }
        parcel.writeInt(this.f24978c ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f24979d);
        parcel.writeInt(this.f24980e ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f24981f);
    }
}
