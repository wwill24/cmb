package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Iterator;

public final class k<S> extends o<S> {

    /* renamed from: b  reason: collision with root package name */
    private int f19643b;

    /* renamed from: c  reason: collision with root package name */
    private DateSelector<S> f19644c;

    /* renamed from: d  reason: collision with root package name */
    private CalendarConstraints f19645d;

    class a extends n<S> {
        a() {
        }

        public void a() {
            Iterator<n<S>> it = k.this.f19664a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        public void b(S s10) {
            Iterator<n<S>> it = k.this.f19664a.iterator();
            while (it.hasNext()) {
                it.next().b(s10);
            }
        }
    }

    @NonNull
    static <T> k<T> B0(DateSelector<T> dateSelector, int i10, @NonNull CalendarConstraints calendarConstraints) {
        k<T> kVar = new k<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        kVar.setArguments(bundle);
        return kVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f19643b = bundle.getInt("THEME_RES_ID_KEY");
        this.f19644c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f19645d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f19644c.p1(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f19643b)), viewGroup, bundle, this.f19645d, new a());
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f19643b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f19644c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f19645d);
    }
}
