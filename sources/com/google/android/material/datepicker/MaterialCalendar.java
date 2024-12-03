package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

public final class MaterialCalendar<S> extends o<S> {

    /* renamed from: q  reason: collision with root package name */
    static final Object f19516q = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: t  reason: collision with root package name */
    static final Object f19517t = "NAVIGATION_PREV_TAG";

    /* renamed from: w  reason: collision with root package name */
    static final Object f19518w = "NAVIGATION_NEXT_TAG";

    /* renamed from: x  reason: collision with root package name */
    static final Object f19519x = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b  reason: collision with root package name */
    private int f19520b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public DateSelector<S> f19521c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CalendarConstraints f19522d;

    /* renamed from: e  reason: collision with root package name */
    private DayViewDecorator f19523e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Month f19524f;

    /* renamed from: g  reason: collision with root package name */
    private CalendarSelector f19525g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public b f19526h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public RecyclerView f19527j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public RecyclerView f19528k;

    /* renamed from: l  reason: collision with root package name */
    private View f19529l;

    /* renamed from: m  reason: collision with root package name */
    private View f19530m;

    /* renamed from: n  reason: collision with root package name */
    private View f19531n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public View f19532p;

    enum CalendarSelector {
        DAY,
        YEAR
    }

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f19536a;

        a(m mVar) {
            this.f19536a = mVar;
        }

        public void onClick(View view) {
            int c22 = MaterialCalendar.this.R0().c2() - 1;
            if (c22 >= 0) {
                MaterialCalendar.this.U0(this.f19536a.H(c22));
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19538a;

        b(int i10) {
            this.f19538a = i10;
        }

        public void run() {
            MaterialCalendar.this.f19528k.B1(this.f19538a);
        }
    }

    class c extends androidx.core.view.a {
        c() {
        }

        public void g(View view, @NonNull androidx.core.view.accessibility.k kVar) {
            super.g(view, kVar);
            kVar.c0((Object) null);
        }
    }

    class d extends p {
        final /* synthetic */ int I;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.I = i11;
        }

        /* access modifiers changed from: protected */
        public void N1(@NonNull RecyclerView.z zVar, @NonNull int[] iArr) {
            if (this.I == 0) {
                iArr[0] = MaterialCalendar.this.f19528k.getWidth();
                iArr[1] = MaterialCalendar.this.f19528k.getWidth();
                return;
            }
            iArr[0] = MaterialCalendar.this.f19528k.getHeight();
            iArr[1] = MaterialCalendar.this.f19528k.getHeight();
        }
    }

    class e implements l {
        e() {
        }

        public void a(long j10) {
            if (MaterialCalendar.this.f19522d.h().u0(j10)) {
                MaterialCalendar.this.f19521c.W1(j10);
                Iterator<n<S>> it = MaterialCalendar.this.f19664a.iterator();
                while (it.hasNext()) {
                    it.next().b(MaterialCalendar.this.f19521c.L1());
                }
                MaterialCalendar.this.f19528k.getAdapter().l();
                if (MaterialCalendar.this.f19527j != null) {
                    MaterialCalendar.this.f19527j.getAdapter().l();
                }
            }
        }
    }

    class f extends androidx.core.view.a {
        f() {
        }

        public void g(View view, @NonNull androidx.core.view.accessibility.k kVar) {
            super.g(view, kVar);
            kVar.u0(false);
        }
    }

    class g extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        private final Calendar f19543a = r.l();

        /* renamed from: b  reason: collision with root package name */
        private final Calendar f19544b = r.l();

        g() {
        }

        public void i(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.z zVar) {
            int i10;
            int i11;
            if ((recyclerView.getAdapter() instanceof s) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                s sVar = (s) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (androidx.core.util.d next : MaterialCalendar.this.f19521c.S0()) {
                    F f10 = next.f4735a;
                    if (!(f10 == null || next.f4736b == null)) {
                        this.f19543a.setTimeInMillis(((Long) f10).longValue());
                        this.f19544b.setTimeInMillis(((Long) next.f4736b).longValue());
                        int I = sVar.I(this.f19543a.get(1));
                        int I2 = sVar.I(this.f19544b.get(1));
                        View D = gridLayoutManager.D(I);
                        View D2 = gridLayoutManager.D(I2);
                        int W2 = I / gridLayoutManager.W2();
                        int W22 = I2 / gridLayoutManager.W2();
                        for (int i12 = W2; i12 <= W22; i12++) {
                            View D3 = gridLayoutManager.D(gridLayoutManager.W2() * i12);
                            if (D3 != null) {
                                int top = D3.getTop() + MaterialCalendar.this.f19526h.f19594d.c();
                                int bottom = D3.getBottom() - MaterialCalendar.this.f19526h.f19594d.b();
                                if (i12 == W2) {
                                    i10 = D.getLeft() + (D.getWidth() / 2);
                                } else {
                                    i10 = 0;
                                }
                                if (i12 == W22) {
                                    i11 = D2.getLeft() + (D2.getWidth() / 2);
                                } else {
                                    i11 = recyclerView.getWidth();
                                }
                                canvas.drawRect((float) i10, (float) top, (float) i11, (float) bottom, MaterialCalendar.this.f19526h.f19598h);
                            }
                        }
                    }
                }
            }
        }
    }

    class h extends androidx.core.view.a {
        h() {
        }

        public void g(View view, @NonNull androidx.core.view.accessibility.k kVar) {
            String str;
            super.g(view, kVar);
            if (MaterialCalendar.this.f19532p.getVisibility() == 0) {
                str = MaterialCalendar.this.getString(bf.j.mtrl_picker_toggle_to_year_selection);
            } else {
                str = MaterialCalendar.this.getString(bf.j.mtrl_picker_toggle_to_day_selection);
            }
            kVar.l0(str);
        }
    }

    class i extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f19547a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialButton f19548b;

        i(m mVar, MaterialButton materialButton) {
            this.f19547a = mVar;
            this.f19548b = materialButton;
        }

        public void a(@NonNull RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                recyclerView.announceForAccessibility(this.f19548b.getText());
            }
        }

        public void b(@NonNull RecyclerView recyclerView, int i10, int i11) {
            int i12;
            if (i10 < 0) {
                i12 = MaterialCalendar.this.R0().a2();
            } else {
                i12 = MaterialCalendar.this.R0().c2();
            }
            Month unused = MaterialCalendar.this.f19524f = this.f19547a.H(i12);
            this.f19548b.setText(this.f19547a.I(i12));
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View view) {
            MaterialCalendar.this.X0();
        }
    }

    class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f19551a;

        k(m mVar) {
            this.f19551a = mVar;
        }

        public void onClick(View view) {
            int a22 = MaterialCalendar.this.R0().a2() + 1;
            if (a22 < MaterialCalendar.this.f19528k.getAdapter().g()) {
                MaterialCalendar.this.U0(this.f19551a.H(a22));
            }
        }
    }

    interface l {
        void a(long j10);
    }

    private void I0(@NonNull View view, @NonNull m mVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(bf.f.month_navigation_fragment_toggle);
        materialButton.setTag(f19519x);
        n0.s0(materialButton, new h());
        View findViewById = view.findViewById(bf.f.month_navigation_previous);
        this.f19529l = findViewById;
        findViewById.setTag(f19517t);
        View findViewById2 = view.findViewById(bf.f.month_navigation_next);
        this.f19530m = findViewById2;
        findViewById2.setTag(f19518w);
        this.f19531n = view.findViewById(bf.f.mtrl_calendar_year_selector_frame);
        this.f19532p = view.findViewById(bf.f.mtrl_calendar_day_selector_frame);
        V0(CalendarSelector.DAY);
        materialButton.setText(this.f19524f.k());
        this.f19528k.l(new i(mVar, materialButton));
        materialButton.setOnClickListener(new j());
        this.f19530m.setOnClickListener(new k(mVar));
        this.f19529l.setOnClickListener(new a(mVar));
    }

    @NonNull
    private RecyclerView.n J0() {
        return new g();
    }

    static int P0(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(bf.d.mtrl_calendar_day_height);
    }

    private static int Q0(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(bf.d.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(bf.d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(bf.d.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(bf.d.mtrl_calendar_days_of_week_height);
        int i10 = l.f19647g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(bf.d.mtrl_calendar_day_height) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(bf.d.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(bf.d.mtrl_calendar_bottom_padding);
    }

    @NonNull
    public static <T> MaterialCalendar<T> S0(@NonNull DateSelector<T> dateSelector, int i10, @NonNull CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.l());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void T0(int i10) {
        this.f19528k.post(new b(i10));
    }

    private void W0() {
        n0.s0(this.f19528k, new f());
    }

    /* access modifiers changed from: package-private */
    public CalendarConstraints L0() {
        return this.f19522d;
    }

    /* access modifiers changed from: package-private */
    public b M0() {
        return this.f19526h;
    }

    /* access modifiers changed from: package-private */
    public Month N0() {
        return this.f19524f;
    }

    public DateSelector<S> O0() {
        return this.f19521c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LinearLayoutManager R0() {
        return (LinearLayoutManager) this.f19528k.getLayoutManager();
    }

    /* access modifiers changed from: package-private */
    public void U0(Month month) {
        boolean z10;
        m mVar = (m) this.f19528k.getAdapter();
        int J = mVar.J(month);
        int J2 = J - mVar.J(this.f19524f);
        boolean z11 = true;
        if (Math.abs(J2) > 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (J2 <= 0) {
            z11 = false;
        }
        this.f19524f = month;
        if (z10 && z11) {
            this.f19528k.s1(J - 3);
            T0(J);
        } else if (z10) {
            this.f19528k.s1(J + 3);
            T0(J);
        } else {
            T0(J);
        }
    }

    /* access modifiers changed from: package-private */
    public void V0(CalendarSelector calendarSelector) {
        this.f19525g = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f19527j.getLayoutManager().y1(((s) this.f19527j.getAdapter()).I(this.f19524f.f19558c));
            this.f19531n.setVisibility(0);
            this.f19532p.setVisibility(8);
            this.f19529l.setVisibility(8);
            this.f19530m.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.f19531n.setVisibility(8);
            this.f19532p.setVisibility(0);
            this.f19529l.setVisibility(0);
            this.f19530m.setVisibility(0);
            U0(this.f19524f);
        }
    }

    /* access modifiers changed from: package-private */
    public void X0() {
        CalendarSelector calendarSelector = this.f19525g;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            V0(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            V0(calendarSelector2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f19520b = bundle.getInt("THEME_RES_ID_KEY");
        this.f19521c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f19522d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f19523e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f19524f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        int i11;
        h hVar;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f19520b);
        this.f19526h = new b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month m10 = this.f19522d.m();
        if (i.R0(contextThemeWrapper)) {
            i11 = bf.h.mtrl_calendar_vertical;
            i10 = 1;
        } else {
            i11 = bf.h.mtrl_calendar_horizontal;
            i10 = 0;
        }
        View inflate = cloneInContext.inflate(i11, viewGroup, false);
        inflate.setMinimumHeight(Q0(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(bf.f.mtrl_calendar_days_of_week);
        n0.s0(gridView, new c());
        int j10 = this.f19522d.j();
        if (j10 <= 0) {
            hVar = new h();
        }
        gridView.setAdapter(hVar);
        gridView.setNumColumns(m10.f19559d);
        gridView.setEnabled(false);
        this.f19528k = (RecyclerView) inflate.findViewById(bf.f.mtrl_calendar_months);
        this.f19528k.setLayoutManager(new d(getContext(), i10, false, i10));
        this.f19528k.setTag(f19516q);
        m mVar = new m(contextThemeWrapper, this.f19521c, this.f19522d, this.f19523e, new e());
        this.f19528k.setAdapter(mVar);
        int integer = contextThemeWrapper.getResources().getInteger(bf.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(bf.f.mtrl_calendar_year_selector_frame);
        this.f19527j = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f19527j.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f19527j.setAdapter(new s(this));
            this.f19527j.h(J0());
        }
        if (inflate.findViewById(bf.f.month_navigation_fragment_toggle) != null) {
            I0(inflate, mVar);
        }
        if (!i.R0(contextThemeWrapper)) {
            new u().b(this.f19528k);
        }
        this.f19528k.s1(mVar.J(this.f19524f));
        W0();
        return inflate;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f19520b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f19521c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f19522d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f19523e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f19524f);
    }

    public boolean z0(@NonNull n<S> nVar) {
        return super.z0(nVar);
    }
}
