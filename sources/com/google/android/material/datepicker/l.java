package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.d;
import java.util.Collection;

class l extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    static final int f19647g = r.l().getMaximum(4);

    /* renamed from: h  reason: collision with root package name */
    private static final int f19648h = ((r.l().getMaximum(5) + r.l().getMaximum(7)) - 1);

    /* renamed from: a  reason: collision with root package name */
    final Month f19649a;

    /* renamed from: b  reason: collision with root package name */
    final DateSelector<?> f19650b;

    /* renamed from: c  reason: collision with root package name */
    private Collection<Long> f19651c;

    /* renamed from: d  reason: collision with root package name */
    b f19652d;

    /* renamed from: e  reason: collision with root package name */
    final CalendarConstraints f19653e;

    /* renamed from: f  reason: collision with root package name */
    final DayViewDecorator f19654f;

    l(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f19649a = month;
        this.f19650b = dateSelector;
        this.f19653e = calendarConstraints;
        this.f19654f = dayViewDecorator;
        this.f19651c = dateSelector.I1();
    }

    private String c(Context context, long j10) {
        return g.e(context, j10, l(j10), k(j10), g(j10));
    }

    private void f(Context context) {
        if (this.f19652d == null) {
            this.f19652d = new b(context);
        }
    }

    private boolean j(long j10) {
        for (Long longValue : this.f19650b.I1()) {
            if (r.a(j10) == r.a(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j10) {
        return r.j().getTimeInMillis() == j10;
    }

    private void o(TextView textView, long j10, int i10) {
        a aVar;
        TextView textView2 = textView;
        long j11 = j10;
        if (textView2 != null) {
            Context context = textView.getContext();
            String c10 = c(context, j11);
            textView2.setContentDescription(c10);
            boolean u02 = this.f19653e.h().u0(j11);
            boolean z10 = false;
            if (u02) {
                textView2.setEnabled(true);
                z10 = j(j11);
                textView2.setSelected(z10);
                if (z10) {
                    aVar = this.f19652d.f19592b;
                } else if (l(j11)) {
                    aVar = this.f19652d.f19593c;
                } else {
                    aVar = this.f19652d.f19591a;
                }
            } else {
                textView2.setEnabled(false);
                aVar = this.f19652d.f19597g;
            }
            a aVar2 = aVar;
            boolean z11 = z10;
            DayViewDecorator dayViewDecorator = this.f19654f;
            if (dayViewDecorator == null || i10 == -1) {
                aVar2.d(textView2);
                return;
            }
            Month month = this.f19649a;
            int i11 = month.f19558c;
            int i12 = month.f19557b;
            Context context2 = context;
            int i13 = i11;
            int i14 = i12;
            int i15 = i10;
            boolean z12 = u02;
            int i16 = i12;
            boolean z13 = z11;
            aVar2.e(textView2, dayViewDecorator.a(context2, i13, i14, i15, z12, z13));
            int i17 = i16;
            Drawable d10 = this.f19654f.d(context2, i13, i17, i15, z12, z13);
            Drawable f10 = this.f19654f.f(context2, i13, i17, i15, z12, z13);
            String str = c10;
            Drawable e10 = this.f19654f.e(context2, i13, i17, i15, z12, z11);
            boolean z14 = z11;
            textView2.setCompoundDrawables(d10, f10, e10, this.f19654f.c(context2, i13, i17, i15, z12, z14));
            textView2.setContentDescription(this.f19654f.g(context2, i13, i17, i15, z12, z14, str));
        }
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (Month.d(j10).equals(this.f19649a)) {
            int j11 = this.f19649a.j(j10);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(j11) - materialCalendarGridView.getFirstVisiblePosition()), j10, j11);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i10) {
        return b() + (i10 - 1);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f19649a.h(this.f19653e.j());
    }

    /* renamed from: d */
    public Long getItem(int i10) {
        if (i10 < b() || i10 > m()) {
            return null;
        }
        return Long.valueOf(this.f19649a.i(n(i10)));
    }

    /* JADX WARNING: type inference failed for: r7v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    @androidx.annotation.NonNull
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.f(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x001e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = bf.h.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x001e:
            int r7 = r5.b()
            int r7 = r6 - r7
            r8 = -1
            if (r7 < 0) goto L_0x0056
            com.google.android.material.datepicker.Month r2 = r5.f19649a
            int r3 = r2.f19560e
            if (r7 < r3) goto L_0x002e
            goto L_0x0056
        L_0x002e:
            r8 = 1
            int r7 = r7 + r8
            r0.setTag(r2)
            android.content.res.Resources r2 = r0.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            java.util.Locale r2 = r2.locale
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            r0.setText(r2)
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            r8 = r7
            goto L_0x005e
        L_0x0056:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L_0x005e:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L_0x0065
            return r0
        L_0x0065:
            long r6 = r6.longValue()
            r5.o(r0, r6, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.l.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* access modifiers changed from: package-private */
    public boolean g(long j10) {
        for (d<Long, Long> dVar : this.f19650b.S0()) {
            S s10 = dVar.f4736b;
            if (s10 != null && ((Long) s10).longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return f19648h;
    }

    public long getItemId(int i10) {
        return (long) (i10 / this.f19649a.f19559d);
    }

    /* access modifiers changed from: package-private */
    public boolean h(int i10) {
        return i10 % this.f19649a.f19559d == 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i10) {
        return (i10 + 1) % this.f19649a.f19559d == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean k(long j10) {
        for (d<Long, Long> dVar : this.f19650b.S0()) {
            F f10 = dVar.f4735a;
            if (f10 != null && ((Long) f10).longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return (b() + this.f19649a.f19560e) - 1;
    }

    /* access modifiers changed from: package-private */
    public int n(int i10) {
        return (i10 - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        for (Long longValue : this.f19651c) {
            p(materialCalendarGridView, longValue.longValue());
        }
        DateSelector<?> dateSelector = this.f19650b;
        if (dateSelector != null) {
            for (Long longValue2 : dateSelector.I1()) {
                p(materialCalendarGridView, longValue2.longValue());
            }
            this.f19651c = this.f19650b.I1();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r(int i10) {
        return i10 >= b() && i10 <= m();
    }
}
