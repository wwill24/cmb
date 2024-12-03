package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bf.h;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

class s extends RecyclerView.Adapter<b> {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final MaterialCalendar<?> f19670d;

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19671a;

        a(int i10) {
            this.f19671a = i10;
        }

        public void onClick(View view) {
            s.this.f19670d.U0(s.this.f19670d.L0().g(Month.c(this.f19671a, s.this.f19670d.N0().f19557b)));
            s.this.f19670d.V0(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    public static class b extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        final TextView f19673u;

        b(TextView textView) {
            super(textView);
            this.f19673u = textView;
        }
    }

    s(MaterialCalendar<?> materialCalendar) {
        this.f19670d = materialCalendar;
    }

    @NonNull
    private View.OnClickListener H(int i10) {
        return new a(i10);
    }

    /* access modifiers changed from: package-private */
    public int I(int i10) {
        return i10 - this.f19670d.L0().m().f19558c;
    }

    /* access modifiers changed from: package-private */
    public int J(int i10) {
        return this.f19670d.L0().m().f19558c + i10;
    }

    /* renamed from: K */
    public void v(@NonNull b bVar, int i10) {
        a aVar;
        int J = J(i10);
        bVar.f19673u.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(J)}));
        TextView textView = bVar.f19673u;
        textView.setContentDescription(g.k(textView.getContext(), J));
        b M0 = this.f19670d.M0();
        Calendar j10 = r.j();
        if (j10.get(1) == J) {
            aVar = M0.f19596f;
        } else {
            aVar = M0.f19594d;
        }
        for (Long longValue : this.f19670d.O0().I1()) {
            j10.setTimeInMillis(longValue.longValue());
            if (j10.get(1) == J) {
                aVar = M0.f19595e;
            }
        }
        aVar.d(bVar.f19673u);
        bVar.f19673u.setOnClickListener(H(J));
    }

    @NonNull
    /* renamed from: L */
    public b x(@NonNull ViewGroup viewGroup, int i10) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_year, viewGroup, false));
    }

    public int g() {
        return this.f19670d.L0().n();
    }
}
