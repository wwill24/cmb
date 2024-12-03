package com.coffeemeetsbagel.phone_login.country_code_picker;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.c;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.country.CmbCountry;
import java.util.List;

public class b extends RecyclerView.Adapter {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final List<CmbCountry> f35704d;

    /* renamed from: e  reason: collision with root package name */
    private final C0439b f35705e;

    public class a extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final CmbTextView f35706u;

        /* renamed from: v  reason: collision with root package name */
        private final CmbTextView f35707v;

        /* renamed from: w  reason: collision with root package name */
        private final CmbTextView f35708w;

        public a(View view, C0439b bVar) {
            super(view);
            this.f35706u = (CmbTextView) view.findViewById(R.id.country_picker_flag);
            this.f35707v = (CmbTextView) view.findViewById(R.id.country_picker_code);
            this.f35708w = (CmbTextView) view.findViewById(R.id.country_picker_country);
            ((ConstraintLayout) view.findViewById(R.id.country_picker_container)).setOnClickListener(new a(this, bVar));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void X(C0439b bVar, View view) {
            bVar.a((CmbCountry) b.this.f35704d.get(o()));
        }

        public void W(CmbCountry cmbCountry) {
            if (c.a(new Paint(), cmbCountry.f())) {
                this.f35706u.setText(cmbCountry.f());
            }
            this.f35707v.setText(cmbCountry.d());
            this.f35708w.setText(cmbCountry.e());
        }
    }

    /* renamed from: com.coffeemeetsbagel.phone_login.country_code_picker.b$b  reason: collision with other inner class name */
    public interface C0439b {
        void a(CmbCountry cmbCountry);
    }

    public b(List<CmbCountry> list, C0439b bVar) {
        this.f35704d = list;
        this.f35705e = bVar;
    }

    public int g() {
        return this.f35704d.size();
    }

    public void v(RecyclerView.d0 d0Var, int i10) {
        if (d0Var instanceof a) {
            ((a) d0Var).W(this.f35704d.get(i10));
        }
    }

    public RecyclerView.d0 x(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_code_picker_item, viewGroup, false), this.f35705e);
    }
}
