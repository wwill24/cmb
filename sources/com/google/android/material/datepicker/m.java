package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.recyclerview.widget.RecyclerView;
import bf.f;
import bf.h;
import com.google.android.material.datepicker.MaterialCalendar;

class m extends RecyclerView.Adapter<b> {
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final CalendarConstraints f19655d;

    /* renamed from: e  reason: collision with root package name */
    private final DateSelector<?> f19656e;

    /* renamed from: f  reason: collision with root package name */
    private final DayViewDecorator f19657f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final MaterialCalendar.l f19658g;

    /* renamed from: h  reason: collision with root package name */
    private final int f19659h;

    class a implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f19660a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f19660a = materialCalendarGridView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (this.f19660a.getAdapter().r(i10)) {
                m.this.f19658g.a(this.f19660a.getAdapter().getItem(i10).longValue());
            }
        }
    }

    public static class b extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        final TextView f19662u;

        /* renamed from: v  reason: collision with root package name */
        final MaterialCalendarGridView f19663v;

        b(@NonNull LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(f.month_title);
            this.f19662u = textView;
            n0.t0(textView, true);
            this.f19663v = (MaterialCalendarGridView) linearLayout.findViewById(f.month_grid);
            if (!z10) {
                textView.setVisibility(8);
            }
        }
    }

    m(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.l lVar) {
        int i10;
        Month m10 = calendarConstraints.m();
        Month i11 = calendarConstraints.i();
        Month l10 = calendarConstraints.l();
        if (m10.compareTo(l10) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (l10.compareTo(i11) <= 0) {
            int P0 = l.f19647g * MaterialCalendar.P0(context);
            if (i.R0(context)) {
                i10 = MaterialCalendar.P0(context);
            } else {
                i10 = 0;
            }
            this.f19659h = P0 + i10;
            this.f19655d = calendarConstraints;
            this.f19656e = dateSelector;
            this.f19657f = dayViewDecorator;
            this.f19658g = lVar;
            E(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month H(int i10) {
        return this.f19655d.m().o(i10);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CharSequence I(int i10) {
        return H(i10).k();
    }

    /* access modifiers changed from: package-private */
    public int J(@NonNull Month month) {
        return this.f19655d.m().p(month);
    }

    /* renamed from: K */
    public void v(@NonNull b bVar, int i10) {
        Month o10 = this.f19655d.m().o(i10);
        bVar.f19662u.setText(o10.k());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f19663v.findViewById(f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !o10.equals(materialCalendarGridView.getAdapter().f19649a)) {
            l lVar = new l(o10, this.f19656e, this.f19655d, this.f19657f);
            materialCalendarGridView.setNumColumns(o10.f19559d);
            materialCalendarGridView.setAdapter((ListAdapter) lVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @NonNull
    /* renamed from: L */
    public b x(@NonNull ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!i.R0(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f19659h));
        return new b(linearLayout, true);
    }

    public int g() {
        return this.f19655d.k();
    }

    public long h(int i10) {
        return this.f19655d.m().o(i10).l();
    }
}
