package com.withpersona.sdk2.inquiry.governmentid.nfc;

import aj.e;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcVerifyDetailsPage;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.steps.ui.UiScreen;
import com.withpersona.sdk2.inquiry.steps.ui.m;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import vi.b;

public final class PassportNfcVerifyDetailsView implements com.squareup.workflow1.ui.a<PassportNfcVerifyDetailsView>, Parcelable {
    public static final Parcelable.Creator<PassportNfcVerifyDetailsView> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final UiScreen f25976a;

    /* renamed from: b  reason: collision with root package name */
    private final PassportNfcVerifyDetailsPage f25977b;

    /* renamed from: c  reason: collision with root package name */
    private final PassportNfcKeys f25978c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25979d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25980e;

    /* renamed from: f  reason: collision with root package name */
    private final Function0<Unit> f25981f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f25982g;

    /* renamed from: h  reason: collision with root package name */
    private final Function0<Unit> f25983h;

    /* renamed from: j  reason: collision with root package name */
    private final Function1<PassportNfcKeys, Unit> f25984j;

    /* renamed from: k  reason: collision with root package name */
    private final List<String> f25985k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f25986l = true;

    /* renamed from: m  reason: collision with root package name */
    private final r<PassportNfcVerifyDetailsView> f25987m;

    public static final class a implements Parcelable.Creator<PassportNfcVerifyDetailsView> {
        /* renamed from: a */
        public final PassportNfcVerifyDetailsView createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcVerifyDetailsView((UiScreen) parcel.readParcelable(PassportNfcVerifyDetailsView.class.getClassLoader()), PassportNfcVerifyDetailsPage.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : PassportNfcKeys.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readInt() != 0, (Function0) parcel.readSerializable(), parcel.readInt() != 0, (Function0) parcel.readSerializable(), (Function1) parcel.readSerializable(), parcel.createStringArrayList());
        }

        /* renamed from: b */
        public final PassportNfcVerifyDetailsView[] newArray(int i10) {
            return new PassportNfcVerifyDetailsView[i10];
        }
    }

    public PassportNfcVerifyDetailsView(UiScreen uiScreen, PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage, PassportNfcKeys passportNfcKeys, boolean z10, boolean z11, Function0<Unit> function0, boolean z12, Function0<Unit> function02, Function1<? super PassportNfcKeys, Unit> function1, List<String> list) {
        j.g(uiScreen, "uiScreen");
        j.g(passportNfcVerifyDetailsPage, "passportNfcVerifyDetailsPage");
        j.g(function0, "onBack");
        j.g(function02, "onCancel");
        j.g(function1, "onNext");
        j.g(list, "componentsWithErrors");
        this.f25976a = uiScreen;
        this.f25977b = passportNfcVerifyDetailsPage;
        this.f25978c = passportNfcKeys;
        this.f25979d = z10;
        this.f25980e = z11;
        this.f25981f = function0;
        this.f25982g = z12;
        this.f25983h = function02;
        this.f25984j = function1;
        this.f25985k = list;
        m mVar = m.f27597a;
        PassportNfcVerifyDetailsView$viewFactory$1 passportNfcVerifyDetailsView$viewFactory$1 = new PassportNfcVerifyDetailsView$viewFactory$1(this);
        f.a aVar = f.f23238a;
        this.f25987m = new ViewBindingViewFactory(l.b(PassportNfcVerifyDetailsView.class), PassportNfcVerifyDetailsView$special$$inlined$getViewFactoryForScreen$default$1.f25988a, new PassportNfcVerifyDetailsView$special$$inlined$getViewFactoryForScreen$default$2(uiScreen, (Function2) null, passportNfcVerifyDetailsView$viewFactory$1));
    }

    private final void e(e eVar) {
        eVar.f24849c.setErrorEnabled(false);
        eVar.f24851e.setErrorEnabled(false);
        eVar.f24852f.setErrorEnabled(false);
    }

    private final Date f(e eVar) {
        Editable text;
        String obj;
        Integer j10;
        Editable text2;
        String obj2;
        Integer j11;
        EditText editText = eVar.f24849c.getEditText();
        if (!(editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null || (j10 = q.j(obj)) == null)) {
            int intValue = j10.intValue();
            TextInputLayout textInputLayout = eVar.f24851e;
            j.f(textInputLayout, "month");
            Integer g10 = g(textInputLayout);
            if (g10 != null) {
                int intValue2 = g10.intValue();
                EditText editText2 = eVar.f24852f.getEditText();
                if (!(editText2 == null || (text2 = editText2.getText()) == null || (obj2 = text2.toString()) == null || (j11 = q.j(obj2)) == null)) {
                    int intValue3 = j11.intValue();
                    Calendar instance = Calendar.getInstance();
                    instance.set(intValue3, intValue2, intValue);
                    return instance.getTime();
                }
            }
        }
        return null;
    }

    private final Integer g(TextInputLayout textInputLayout) {
        AutoCompleteTextView autoCompleteTextView;
        ListAdapter listAdapter;
        Editable editable;
        EditText editText = textInputLayout.getEditText();
        if (editText instanceof AutoCompleteTextView) {
            autoCompleteTextView = (AutoCompleteTextView) editText;
        } else {
            autoCompleteTextView = null;
        }
        if (autoCompleteTextView != null) {
            listAdapter = autoCompleteTextView.getAdapter();
        } else {
            listAdapter = null;
        }
        EditText editText2 = textInputLayout.getEditText();
        if (editText2 != null) {
            editable = editText2.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        if (listAdapter != null) {
            int count = listAdapter.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                if (j.b(listAdapter.getItem(i10), valueOf)) {
                    return Integer.valueOf(i10);
                }
            }
        }
        return null;
    }

    private final void j(e eVar) {
        Integer num;
        Editable text;
        String obj;
        Editable text2;
        String obj2;
        EditText editText = eVar.f24849c.getEditText();
        Integer num2 = null;
        if (editText == null || (text2 = editText.getText()) == null || (obj2 = text2.toString()) == null) {
            num = null;
        } else {
            num = q.j(obj2);
        }
        TextInputLayout textInputLayout = eVar.f24851e;
        j.f(textInputLayout, "month");
        Integer g10 = g(textInputLayout);
        EditText editText2 = eVar.f24852f.getEditText();
        if (!(editText2 == null || (text = editText2.getText()) == null || (obj = text.toString()) == null)) {
            num2 = q.j(obj);
        }
        if (num == null) {
            eVar.f24849c.setError(" ");
        } else {
            eVar.f24849c.setErrorEnabled(false);
        }
        if (g10 == null) {
            eVar.f24851e.setError(" ");
        } else {
            eVar.f24851e.setErrorEnabled(false);
        }
        if (num2 == null) {
            eVar.f24852f.setError(" ");
        } else {
            eVar.f24852f.setErrorEnabled(false);
        }
    }

    private final void k(e eVar, Date date) {
        AutoCompleteTextView autoCompleteTextView;
        ListAdapter adapter;
        Object item;
        Calendar instance = Calendar.getInstance();
        if (date != null) {
            instance.setTime(date);
            EditText editText = eVar.f24851e.getEditText();
            String str = null;
            if (editText instanceof AutoCompleteTextView) {
                autoCompleteTextView = (AutoCompleteTextView) editText;
            } else {
                autoCompleteTextView = null;
            }
            EditText editText2 = eVar.f24849c.getEditText();
            if (editText2 != null) {
                editText2.setText(String.valueOf(instance.get(5)));
            }
            if (!(autoCompleteTextView == null || (adapter = autoCompleteTextView.getAdapter()) == null || (item = adapter.getItem(instance.get(2))) == null)) {
                str = item.toString();
            }
            if (str != null) {
                autoCompleteTextView.setText(str, false);
            }
            EditText editText3 = eVar.f24852f.getEditText();
            if (editText3 != null) {
                editText3.setText(String.valueOf(instance.get(1)));
            }
        }
    }

    private final void l(e eVar, boolean z10) {
        eVar.f24849c.setEnabled(z10);
        eVar.f24851e.setEnabled(z10);
        eVar.f24852f.setEnabled(z10);
    }

    /* access modifiers changed from: private */
    public final void m(b bVar, PassportNfcVerifyDetailsView passportNfcVerifyDetailsView, p pVar, Map<String, com.withpersona.sdk2.inquiry.steps.ui.a> map) {
        View view;
        TextInputLayout textInputLayout;
        Object obj;
        e eVar;
        Object obj2;
        e eVar2;
        KeyEvent.Callback callback;
        EditText editText;
        View d10;
        View d11;
        PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage = passportNfcVerifyDetailsView.f25977b;
        com.withpersona.sdk2.inquiry.steps.ui.a aVar = map.get(passportNfcVerifyDetailsPage.c());
        cj.b bVar2 = null;
        if (aVar != null) {
            view = aVar.d();
        } else {
            view = null;
        }
        if (view instanceof TextInputLayout) {
            textInputLayout = (TextInputLayout) view;
        } else {
            textInputLayout = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar2 = map.get(passportNfcVerifyDetailsPage.a());
        if (aVar2 == null || (d11 = aVar2.d()) == null) {
            obj = null;
        } else {
            obj = d11.getTag();
        }
        if (obj instanceof e) {
            eVar = (e) obj;
        } else {
            eVar = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar3 = map.get(passportNfcVerifyDetailsPage.d());
        if (aVar3 == null || (d10 = aVar3.d()) == null) {
            obj2 = null;
        } else {
            obj2 = d10.getTag();
        }
        if (obj2 instanceof e) {
            eVar2 = (e) obj2;
        } else {
            eVar2 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar4 = map.get(passportNfcVerifyDetailsPage.J());
        if (aVar4 != null) {
            callback = aVar4.d();
        } else {
            callback = null;
        }
        if (callback instanceof cj.b) {
            bVar2 = (cj.b) callback;
        }
        if (textInputLayout != null) {
            textInputLayout.setEnabled(!passportNfcVerifyDetailsView.f25979d);
        }
        if (eVar != null) {
            l(eVar, !passportNfcVerifyDetailsView.f25979d);
        }
        if (eVar2 != null) {
            l(eVar2, !passportNfcVerifyDetailsView.f25979d);
        }
        if (bVar2 != null) {
            bVar2.setIsLoading(passportNfcVerifyDetailsView.f25979d);
        }
        if (passportNfcVerifyDetailsView.f25978c != null && this.f25986l) {
            this.f25986l = false;
            if (!(textInputLayout == null || (editText = textInputLayout.getEditText()) == null)) {
                editText.setText(passportNfcVerifyDetailsView.f25978c.d());
            }
            if (eVar != null) {
                k(eVar, passportNfcVerifyDetailsView.f25978c.a());
            }
            if (eVar2 != null) {
                k(eVar2, passportNfcVerifyDetailsView.f25978c.c());
            }
        }
        if (passportNfcVerifyDetailsView.f25985k.contains(passportNfcVerifyDetailsPage.c())) {
            if (textInputLayout != null) {
                textInputLayout.setError(" ");
            }
        } else if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(false);
        }
        if (passportNfcVerifyDetailsView.f25985k.contains(passportNfcVerifyDetailsPage.a())) {
            if (eVar != null) {
                j(eVar);
            }
        } else if (eVar != null) {
            e(eVar);
        }
        if (passportNfcVerifyDetailsView.f25985k.contains(passportNfcVerifyDetailsPage.d())) {
            if (eVar2 != null) {
                j(eVar2);
            }
        } else if (eVar2 != null) {
            e(eVar2);
        }
        if (bVar2 != null) {
            bVar2.setOnClickListener(new g(passportNfcVerifyDetailsView, textInputLayout, eVar2, this, eVar));
        }
        bVar.f33904e.setState(new NavigationUiState(passportNfcVerifyDetailsView.f25980e, new PassportNfcVerifyDetailsView$showRendering$1$2(passportNfcVerifyDetailsView), passportNfcVerifyDetailsView.f25982g, new PassportNfcVerifyDetailsView$showRendering$1$3(passportNfcVerifyDetailsView)));
    }

    /* access modifiers changed from: private */
    public static final void n(PassportNfcVerifyDetailsView passportNfcVerifyDetailsView, TextInputLayout textInputLayout, e eVar, PassportNfcVerifyDetailsView passportNfcVerifyDetailsView2, e eVar2, View view) {
        String str;
        Date date;
        EditText editText;
        Editable text;
        j.g(passportNfcVerifyDetailsView, "$rendering");
        j.g(passportNfcVerifyDetailsView2, "this$0");
        Function1<PassportNfcKeys, Unit> function1 = passportNfcVerifyDetailsView.f25984j;
        if (textInputLayout == null || (editText = textInputLayout.getEditText()) == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
            str = "";
        }
        Date date2 = null;
        if (eVar != null) {
            date = passportNfcVerifyDetailsView2.f(eVar);
        } else {
            date = null;
        }
        if (eVar2 != null) {
            date2 = passportNfcVerifyDetailsView2.f(eVar2);
        }
        function1.invoke(new PassportNfcKeys(str, date, date2));
    }

    public r<PassportNfcVerifyDetailsView> a() {
        return this.f25987m;
    }

    public int describeContents() {
        return 0;
    }

    public final Function0<Unit> h() {
        return this.f25981f;
    }

    public final Function0<Unit> i() {
        return this.f25983h;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeParcelable(this.f25976a, i10);
        this.f25977b.writeToParcel(parcel, i10);
        PassportNfcKeys passportNfcKeys = this.f25978c;
        if (passportNfcKeys == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            passportNfcKeys.writeToParcel(parcel, i10);
        }
        parcel.writeInt(this.f25979d ? 1 : 0);
        parcel.writeInt(this.f25980e ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25981f);
        parcel.writeInt(this.f25982g ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f25983h);
        parcel.writeSerializable((Serializable) this.f25984j);
        parcel.writeStringList(this.f25985k);
    }
}
