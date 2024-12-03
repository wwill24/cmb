package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.util.d;
import bf.f;
import bf.h;
import bf.j;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f19579a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Long f19580b;

    /* renamed from: c  reason: collision with root package name */
    private SimpleDateFormat f19581c;

    class a extends e {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ n f19582g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f19583h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, n nVar, TextInputLayout textInputLayout2) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f19582g = nVar;
            this.f19583h = textInputLayout2;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            CharSequence unused = SingleDateSelector.this.f19579a = this.f19583h.getError();
            this.f19582g.a();
        }

        /* access modifiers changed from: package-private */
        public void g(Long l10) {
            if (l10 == null) {
                SingleDateSelector.this.e();
            } else {
                SingleDateSelector.this.W1(l10.longValue());
            }
            CharSequence unused = SingleDateSelector.this.f19579a = null;
            this.f19582g.b(SingleDateSelector.this.L1());
        }
    }

    class b implements Parcelable.Creator<SingleDateSelector> {
        b() {
        }

        @NonNull
        /* renamed from: a */
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            Long unused = singleDateSelector.f19580b = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @NonNull
        /* renamed from: b */
        public SingleDateSelector[] newArray(int i10) {
            return new SingleDateSelector[i10];
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f19580b = null;
    }

    public boolean C1() {
        return this.f19580b != null;
    }

    @NonNull
    public Collection<Long> I1() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f19580b;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    @NonNull
    public String Q0(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f19580b;
        if (l10 == null) {
            return resources.getString(j.mtrl_picker_date_header_unselected);
        }
        String m10 = g.m(l10.longValue());
        return resources.getString(j.mtrl_picker_date_header_selected, new Object[]{m10});
    }

    @NonNull
    public Collection<d<Long, Long>> S0() {
        return new ArrayList();
    }

    public void W1(long j10) {
        this.f19580b = Long.valueOf(j10);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public Long L1() {
        return this.f19580b;
    }

    public String getError() {
        if (TextUtils.isEmpty(this.f19579a)) {
            return null;
        }
        return this.f19579a.toString();
    }

    public View p1(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, @NonNull n<Long> nVar) {
        boolean z10;
        String str;
        View inflate = layoutInflater.inflate(h.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(f.mtrl_picker_text_input_date);
        textInputLayout.setErrorAccessibilityLiveRegion(0);
        EditText editText = textInputLayout.getEditText();
        if (com.google.android.material.internal.j.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormat = this.f19581c;
        if (simpleDateFormat != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            simpleDateFormat = r.f();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        if (z10) {
            str = simpleDateFormat2.toPattern();
        } else {
            str = r.g(inflate.getResources(), simpleDateFormat2);
        }
        String str2 = str;
        textInputLayout.setPlaceholderText(str2);
        Long l10 = this.f19580b;
        if (l10 != null) {
            editText.setText(simpleDateFormat2.format(l10));
        }
        editText.addTextChangedListener(new a(str2, simpleDateFormat2, textInputLayout, calendarConstraints, nVar, textInputLayout));
        DateSelector.o1(editText);
        return inflate;
    }

    @NonNull
    public String r0(@NonNull Context context) {
        String str;
        Resources resources = context.getResources();
        Long l10 = this.f19580b;
        if (l10 == null) {
            str = resources.getString(j.mtrl_picker_announce_current_selection_none);
        } else {
            str = g.m(l10.longValue());
        }
        return resources.getString(j.mtrl_picker_announce_current_selection, new Object[]{str});
    }

    public int s0(Context context) {
        return qf.b.d(context, bf.b.materialCalendarTheme, i.class.getCanonicalName());
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeValue(this.f19580b);
    }
}
