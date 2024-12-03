package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.k;
import androidx.core.view.h0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import androidx.fragment.app.b0;
import bf.h;
import bf.j;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.r;
import java.util.Iterator;
import java.util.LinkedHashSet;
import tf.g;

public final class i<S> extends androidx.fragment.app.c {
    static final Object H = "CONFIRM_BUTTON_TAG";
    static final Object I = "CANCEL_BUTTON_TAG";
    static final Object J = "TOGGLE_BUTTON_TAG";
    /* access modifiers changed from: private */
    public CheckableImageButton B;
    private g C;
    /* access modifiers changed from: private */
    public Button D;
    private boolean E;
    private CharSequence F;
    private CharSequence G;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet<j<? super S>> f19614a = new LinkedHashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f19615b = new LinkedHashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f19616c = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f19617d = new LinkedHashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private int f19618e;

    /* renamed from: f  reason: collision with root package name */
    private DateSelector<S> f19619f;

    /* renamed from: g  reason: collision with root package name */
    private o<S> f19620g;

    /* renamed from: h  reason: collision with root package name */
    private CalendarConstraints f19621h;

    /* renamed from: j  reason: collision with root package name */
    private DayViewDecorator f19622j;

    /* renamed from: k  reason: collision with root package name */
    private MaterialCalendar<S> f19623k;

    /* renamed from: l  reason: collision with root package name */
    private int f19624l;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f19625m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19626n;

    /* renamed from: p  reason: collision with root package name */
    private int f19627p;

    /* renamed from: q  reason: collision with root package name */
    private int f19628q;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f19629t;

    /* renamed from: w  reason: collision with root package name */
    private int f19630w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f19631x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f19632y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f19633z;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            Iterator it = i.this.f19614a.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(i.this.O0());
            }
            i.this.dismiss();
        }
    }

    class b extends androidx.core.view.a {
        b() {
        }

        public void g(@NonNull View view, @NonNull k kVar) {
            super.g(view, kVar);
            kVar.e0(i.this.I0().getError() + ", " + kVar.v());
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Iterator it = i.this.f19615b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            i.this.dismiss();
        }
    }

    class d implements h0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19637a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f19638b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19639c;

        d(int i10, View view, int i11) {
            this.f19637a = i10;
            this.f19638b = view;
            this.f19639c = i11;
        }

        public k2 a(View view, k2 k2Var) {
            int i10 = k2Var.f(k2.m.d()).f4589b;
            if (this.f19637a >= 0) {
                this.f19638b.getLayoutParams().height = this.f19637a + i10;
                View view2 = this.f19638b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f19638b;
            view3.setPadding(view3.getPaddingLeft(), this.f19639c + i10, this.f19638b.getPaddingRight(), this.f19638b.getPaddingBottom());
            return k2Var;
        }
    }

    class e extends n<S> {
        e() {
        }

        public void a() {
            i.this.D.setEnabled(false);
        }

        public void b(S s10) {
            i iVar = i.this;
            iVar.W0(iVar.M0());
            i.this.D.setEnabled(i.this.I0().C1());
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            i.this.D.setEnabled(i.this.I0().C1());
            i.this.B.toggle();
            i iVar = i.this;
            iVar.Y0(iVar.B);
            i.this.V0();
        }
    }

    @NonNull
    private static Drawable G0(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, e.a.b(context, bf.e.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], e.a.b(context, bf.e.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void H0(Window window) {
        if (!this.E) {
            View findViewById = requireView().findViewById(bf.f.fullscreen_header);
            com.google.android.material.internal.e.a(window, true, r.d(findViewById), (Integer) null);
            n0.H0(findViewById, new d(findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop()));
            this.E = true;
        }
    }

    /* access modifiers changed from: private */
    public DateSelector<S> I0() {
        if (this.f19619f == null) {
            this.f19619f = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f19619f;
    }

    private static CharSequence J0(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] split = TextUtils.split(String.valueOf(charSequence), "\n");
        if (split.length > 1) {
            return split[0];
        }
        return charSequence;
    }

    private String L0() {
        return I0().r0(requireContext());
    }

    private static int N0(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(bf.d.mtrl_calendar_content_padding);
        int i10 = Month.e().f19559d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(bf.d.mtrl_calendar_day_width) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(bf.d.mtrl_calendar_month_horizontal_padding));
    }

    private int P0(Context context) {
        int i10 = this.f19618e;
        if (i10 != 0) {
            return i10;
        }
        return I0().s0(context);
    }

    private void Q0(Context context) {
        boolean z10;
        this.B.setTag(J);
        this.B.setImageDrawable(G0(context));
        CheckableImageButton checkableImageButton = this.B;
        if (this.f19627p != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        checkableImageButton.setChecked(z10);
        n0.s0(this.B, (androidx.core.view.a) null);
        Y0(this.B);
        this.B.setOnClickListener(new f());
    }

    static boolean R0(@NonNull Context context) {
        return U0(context, 16843277);
    }

    private boolean S0() {
        return getResources().getConfiguration().orientation == 2;
    }

    static boolean T0(@NonNull Context context) {
        return U0(context, bf.b.nestedScrollable);
    }

    static boolean U0(@NonNull Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(qf.b.d(context, bf.b.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i10});
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    /* access modifiers changed from: private */
    public void V0() {
        o<S> oVar;
        int P0 = P0(requireContext());
        this.f19623k = MaterialCalendar.S0(I0(), P0, this.f19621h, this.f19622j);
        boolean isChecked = this.B.isChecked();
        if (isChecked) {
            oVar = k.B0(I0(), P0, this.f19621h);
        } else {
            oVar = this.f19623k;
        }
        this.f19620g = oVar;
        X0(isChecked);
        W0(M0());
        b0 p10 = getChildFragmentManager().p();
        p10.s(bf.f.mtrl_calendar_frame, this.f19620g);
        p10.k();
        this.f19620g.z0(new e());
    }

    private void X0(boolean z10) {
        CharSequence charSequence;
        TextView textView = this.f19632y;
        if (!z10 || !S0()) {
            charSequence = this.F;
        } else {
            charSequence = this.G;
        }
        textView.setText(charSequence);
    }

    /* access modifiers changed from: private */
    public void Y0(@NonNull CheckableImageButton checkableImageButton) {
        String str;
        if (this.B.isChecked()) {
            str = checkableImageButton.getContext().getString(j.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton.getContext().getString(j.mtrl_picker_toggle_to_text_input_mode);
        }
        this.B.setContentDescription(str);
    }

    public String M0() {
        return I0().Q0(getContext());
    }

    public final S O0() {
        return I0().L1();
    }

    /* access modifiers changed from: package-private */
    public void W0(String str) {
        this.f19633z.setContentDescription(L0());
        this.f19633z.setText(str);
    }

    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f19616c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f19618e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f19619f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f19621h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f19622j = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f19624l = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f19625m = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f19627p = bundle.getInt("INPUT_MODE_KEY");
        this.f19628q = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f19629t = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f19630w = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f19631x = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        CharSequence charSequence = this.f19625m;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.f19624l);
        }
        this.F = charSequence;
        this.G = J0(charSequence);
    }

    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), P0(requireContext()));
        Context context = dialog.getContext();
        this.f19626n = R0(context);
        int d10 = qf.b.d(context, bf.b.colorSurface, i.class.getCanonicalName());
        g gVar = new g(context, (AttributeSet) null, bf.b.materialCalendarStyle, bf.k.Widget_MaterialComponents_MaterialCalendar);
        this.C = gVar;
        gVar.Q(context);
        this.C.b0(ColorStateList.valueOf(d10));
        this.C.a0(n0.w(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        if (this.f19626n) {
            i10 = h.mtrl_picker_fullscreen;
        } else {
            i10 = h.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i10, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator = this.f19622j;
        if (dayViewDecorator != null) {
            dayViewDecorator.h(context);
        }
        if (this.f19626n) {
            inflate.findViewById(bf.f.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(N0(context), -2));
        } else {
            inflate.findViewById(bf.f.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(N0(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(bf.f.mtrl_picker_header_selection_text);
        this.f19633z = textView;
        n0.u0(textView, 1);
        this.B = (CheckableImageButton) inflate.findViewById(bf.f.mtrl_picker_header_toggle);
        this.f19632y = (TextView) inflate.findViewById(bf.f.mtrl_picker_title_text);
        Q0(context);
        this.D = (Button) inflate.findViewById(bf.f.confirm_button);
        if (I0().C1()) {
            this.D.setEnabled(true);
        } else {
            this.D.setEnabled(false);
        }
        this.D.setTag(H);
        CharSequence charSequence = this.f19629t;
        if (charSequence != null) {
            this.D.setText(charSequence);
        } else {
            int i11 = this.f19628q;
            if (i11 != 0) {
                this.D.setText(i11);
            }
        }
        this.D.setOnClickListener(new a());
        n0.s0(this.D, new b());
        Button button = (Button) inflate.findViewById(bf.f.cancel_button);
        button.setTag(I);
        CharSequence charSequence2 = this.f19631x;
        if (charSequence2 != null) {
            button.setText(charSequence2);
        } else {
            int i12 = this.f19630w;
            if (i12 != 0) {
                button.setText(i12);
            }
        }
        button.setOnClickListener(new c());
        return inflate;
    }

    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f19617d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f19618e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f19619f);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f19621h);
        if (this.f19623k.N0() != null) {
            bVar.b(this.f19623k.N0().f19561f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f19622j);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f19624l);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f19625m);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f19628q);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f19629t);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f19630w);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f19631x);
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f19626n) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.C);
            H0(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(bf.d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable(this.C, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new p000if.a(requireDialog(), rect));
        }
        V0();
    }

    public void onStop() {
        this.f19620g.A0();
        super.onStop();
    }
}
