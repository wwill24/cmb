package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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

public class RangeDateSelector implements DateSelector<d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f19563a;

    /* renamed from: b  reason: collision with root package name */
    private String f19564b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19565c = " ";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Long f19566d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Long f19567e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Long f19568f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Long f19569g = null;

    /* renamed from: h  reason: collision with root package name */
    private SimpleDateFormat f19570h;

    class a extends e {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f19571g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f19572h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ n f19573j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, n nVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f19571g = textInputLayout2;
            this.f19572h = textInputLayout3;
            this.f19573j = nVar;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            Long unused = RangeDateSelector.this.f19568f = null;
            RangeDateSelector.this.l(this.f19571g, this.f19572h, this.f19573j);
        }

        /* access modifiers changed from: package-private */
        public void g(Long l10) {
            Long unused = RangeDateSelector.this.f19568f = l10;
            RangeDateSelector.this.l(this.f19571g, this.f19572h, this.f19573j);
        }
    }

    class b extends e {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f19575g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f19576h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ n f19577j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, n nVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f19575g = textInputLayout2;
            this.f19576h = textInputLayout3;
            this.f19577j = nVar;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            Long unused = RangeDateSelector.this.f19569g = null;
            RangeDateSelector.this.l(this.f19575g, this.f19576h, this.f19577j);
        }

        /* access modifiers changed from: package-private */
        public void g(Long l10) {
            Long unused = RangeDateSelector.this.f19569g = l10;
            RangeDateSelector.this.l(this.f19575g, this.f19576h, this.f19577j);
        }
    }

    class c implements Parcelable.Creator<RangeDateSelector> {
        c() {
        }

        @NonNull
        /* renamed from: a */
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            Class<Long> cls = Long.class;
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            Long unused = rangeDateSelector.f19566d = (Long) parcel.readValue(cls.getClassLoader());
            Long unused2 = rangeDateSelector.f19567e = (Long) parcel.readValue(cls.getClassLoader());
            return rangeDateSelector;
        }

        @NonNull
        /* renamed from: b */
        public RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    private void g(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f19564b.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError((CharSequence) null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError((CharSequence) null);
        }
    }

    private boolean i(long j10, long j11) {
        return j10 <= j11;
    }

    private void j(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f19564b);
        textInputLayout2.setError(" ");
    }

    private void k(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.f19563a = textInputLayout.getError();
        } else if (!TextUtils.isEmpty(textInputLayout2.getError())) {
            this.f19563a = textInputLayout2.getError();
        } else {
            this.f19563a = null;
        }
    }

    /* access modifiers changed from: private */
    public void l(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull n<d<Long, Long>> nVar) {
        Long l10 = this.f19568f;
        if (l10 == null || this.f19569g == null) {
            g(textInputLayout, textInputLayout2);
            nVar.a();
        } else if (i(l10.longValue(), this.f19569g.longValue())) {
            this.f19566d = this.f19568f;
            this.f19567e = this.f19569g;
            nVar.b(L1());
        } else {
            j(textInputLayout, textInputLayout2);
            nVar.a();
        }
        k(textInputLayout, textInputLayout2);
    }

    public boolean C1() {
        Long l10 = this.f19566d;
        if (l10 == null || this.f19567e == null || !i(l10.longValue(), this.f19567e.longValue())) {
            return false;
        }
        return true;
    }

    @NonNull
    public Collection<Long> I1() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f19566d;
        if (l10 != null) {
            arrayList.add(l10);
        }
        Long l11 = this.f19567e;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    @NonNull
    public String Q0(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f19566d;
        if (l10 == null && this.f19567e == null) {
            return resources.getString(j.mtrl_picker_range_header_unselected);
        }
        Long l11 = this.f19567e;
        if (l11 == null) {
            return resources.getString(j.mtrl_picker_range_header_only_start_selected, new Object[]{g.c(l10.longValue())});
        } else if (l10 == null) {
            return resources.getString(j.mtrl_picker_range_header_only_end_selected, new Object[]{g.c(l11.longValue())});
        } else {
            d<String, String> a10 = g.a(l10, l11);
            return resources.getString(j.mtrl_picker_range_header_selected, new Object[]{a10.f4735a, a10.f4736b});
        }
    }

    @NonNull
    public Collection<d<Long, Long>> S0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(this.f19566d, this.f19567e));
        return arrayList;
    }

    public void W1(long j10) {
        Long l10 = this.f19566d;
        if (l10 == null) {
            this.f19566d = Long.valueOf(j10);
        } else if (this.f19567e != null || !i(l10.longValue(), j10)) {
            this.f19567e = null;
            this.f19566d = Long.valueOf(j10);
        } else {
            this.f19567e = Long.valueOf(j10);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getError() {
        if (TextUtils.isEmpty(this.f19563a)) {
            return null;
        }
        return this.f19563a.toString();
    }

    @NonNull
    /* renamed from: h */
    public d<Long, Long> L1() {
        return new d<>(this.f19566d, this.f19567e);
    }

    public View p1(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, @NonNull n<d<Long, Long>> nVar) {
        boolean z10;
        String str;
        View inflate = layoutInflater.inflate(h.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(f.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(f.mtrl_picker_text_input_range_end);
        textInputLayout.setErrorAccessibilityLiveRegion(0);
        textInputLayout2.setErrorAccessibilityLiveRegion(0);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.j.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f19564b = inflate.getResources().getString(j.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormat = this.f19570h;
        if (simpleDateFormat != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            simpleDateFormat = r.f();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        Long l10 = this.f19566d;
        if (l10 != null) {
            editText.setText(simpleDateFormat2.format(l10));
            this.f19568f = this.f19566d;
        }
        Long l11 = this.f19567e;
        if (l11 != null) {
            editText2.setText(simpleDateFormat2.format(l11));
            this.f19569g = this.f19567e;
        }
        if (z10) {
            str = simpleDateFormat2.toPattern();
        } else {
            str = r.g(inflate.getResources(), simpleDateFormat2);
        }
        String str2 = str;
        textInputLayout.setPlaceholderText(str2);
        textInputLayout2.setPlaceholderText(str2);
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        a aVar = r0;
        TextInputLayout textInputLayout3 = textInputLayout;
        String str3 = str2;
        TextInputLayout textInputLayout4 = textInputLayout2;
        SimpleDateFormat simpleDateFormat3 = simpleDateFormat2;
        n<d<Long, Long>> nVar2 = nVar;
        a aVar2 = new a(str2, simpleDateFormat2, textInputLayout, calendarConstraints2, textInputLayout3, textInputLayout4, nVar2);
        editText.addTextChangedListener(aVar);
        editText2.addTextChangedListener(new b(str3, simpleDateFormat3, textInputLayout2, calendarConstraints2, textInputLayout3, textInputLayout4, nVar2));
        DateSelector.o1(editText, editText2);
        return inflate;
    }

    @NonNull
    public String r0(@NonNull Context context) {
        String str;
        String str2;
        Resources resources = context.getResources();
        d<String, String> a10 = g.a(this.f19566d, this.f19567e);
        F f10 = a10.f4735a;
        if (f10 == null) {
            str = resources.getString(j.mtrl_picker_announce_current_selection_none);
        } else {
            str = (String) f10;
        }
        S s10 = a10.f4736b;
        if (s10 == null) {
            str2 = resources.getString(j.mtrl_picker_announce_current_selection_none);
        } else {
            str2 = (String) s10;
        }
        return resources.getString(j.mtrl_picker_announce_current_range_selection, new Object[]{str, str2});
    }

    public int s0(@NonNull Context context) {
        int i10;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(bf.d.mtrl_calendar_maximum_default_fullscreen_minor_axis)) {
            i10 = bf.b.materialCalendarTheme;
        } else {
            i10 = bf.b.materialCalendarFullscreenTheme;
        }
        return qf.b.d(context, i10, i.class.getCanonicalName());
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeValue(this.f19566d);
        parcel.writeValue(this.f19567e);
    }
}
