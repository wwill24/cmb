package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.k0;
import androidx.core.view.n0;
import androidx.core.widget.l;
import androidx.customview.view.AbsSavedState;
import bf.j;
import bf.k;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.r;
import java.util.Iterator;
import java.util.LinkedHashSet;
import net.bytebuddy.jar.asm.Opcodes;
import x1.p;

public class TextInputLayout extends LinearLayout {
    private static final int F0 = k.Widget_Design_TextInputLayout;
    private static final int[][] G0 = {new int[]{16842919}, new int[0]};
    private boolean A0;
    private ColorStateList B;
    private boolean B0;
    private int C;
    private ValueAnimator C0;
    private x1.d D;
    private boolean D0;
    private x1.d E;
    /* access modifiers changed from: private */
    public boolean E0;
    private ColorStateList F;
    private ColorStateList G;
    private boolean H;
    private CharSequence I;
    private boolean J;
    private tf.g K;
    private tf.g L;
    private StateListDrawable M;
    private boolean N;
    private tf.g O;
    private tf.g P;
    @NonNull
    private tf.k Q;
    private boolean R;
    private final int S;
    private int T;
    private int U;
    private int V;
    private int W;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f20228a;

    /* renamed from: a0  reason: collision with root package name */
    private int f20229a0;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final z f20230b;

    /* renamed from: b0  reason: collision with root package name */
    private int f20231b0;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final s f20232c;

    /* renamed from: c0  reason: collision with root package name */
    private int f20233c0;

    /* renamed from: d  reason: collision with root package name */
    EditText f20234d;

    /* renamed from: d0  reason: collision with root package name */
    private final Rect f20235d0;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f20236e;

    /* renamed from: e0  reason: collision with root package name */
    private final Rect f20237e0;

    /* renamed from: f  reason: collision with root package name */
    private int f20238f;

    /* renamed from: f0  reason: collision with root package name */
    private final RectF f20239f0;

    /* renamed from: g  reason: collision with root package name */
    private int f20240g;

    /* renamed from: g0  reason: collision with root package name */
    private Typeface f20241g0;

    /* renamed from: h  reason: collision with root package name */
    private int f20242h;

    /* renamed from: h0  reason: collision with root package name */
    private Drawable f20243h0;

    /* renamed from: i0  reason: collision with root package name */
    private int f20244i0;

    /* renamed from: j  reason: collision with root package name */
    private int f20245j;

    /* renamed from: j0  reason: collision with root package name */
    private final LinkedHashSet<g> f20246j0;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final v f20247k;

    /* renamed from: k0  reason: collision with root package name */
    private Drawable f20248k0;

    /* renamed from: l  reason: collision with root package name */
    boolean f20249l;

    /* renamed from: l0  reason: collision with root package name */
    private int f20250l0;

    /* renamed from: m  reason: collision with root package name */
    private int f20251m;

    /* renamed from: m0  reason: collision with root package name */
    private Drawable f20252m0;

    /* renamed from: n  reason: collision with root package name */
    private boolean f20253n;

    /* renamed from: n0  reason: collision with root package name */
    private ColorStateList f20254n0;

    /* renamed from: o0  reason: collision with root package name */
    private ColorStateList f20255o0;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    private f f20256p;

    /* renamed from: p0  reason: collision with root package name */
    private int f20257p0;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20258q;

    /* renamed from: q0  reason: collision with root package name */
    private int f20259q0;

    /* renamed from: r0  reason: collision with root package name */
    private int f20260r0;

    /* renamed from: s0  reason: collision with root package name */
    private ColorStateList f20261s0;

    /* renamed from: t  reason: collision with root package name */
    private int f20262t;

    /* renamed from: t0  reason: collision with root package name */
    private int f20263t0;

    /* renamed from: u0  reason: collision with root package name */
    private int f20264u0;

    /* renamed from: v0  reason: collision with root package name */
    private int f20265v0;

    /* renamed from: w  reason: collision with root package name */
    private int f20266w;

    /* renamed from: w0  reason: collision with root package name */
    private int f20267w0;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f20268x;

    /* renamed from: x0  reason: collision with root package name */
    private int f20269x0;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public boolean f20270y;

    /* renamed from: y0  reason: collision with root package name */
    private boolean f20271y0;

    /* renamed from: z  reason: collision with root package name */
    private TextView f20272z;

    /* renamed from: z0  reason: collision with root package name */
    final com.google.android.material.internal.b f20273z0;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        CharSequence f20274c;

        /* renamed from: d  reason: collision with root package name */
        boolean f20275d;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f20274c + "}";
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f20274c, parcel, i10);
            parcel.writeInt(this.f20275d ? 1 : 0);
        }

        SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f20274c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f20275d = parcel.readInt() != 1 ? false : true;
        }
    }

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.r0(!textInputLayout.E0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f20249l) {
                textInputLayout2.i0(editable);
            }
            if (TextInputLayout.this.f20270y) {
                TextInputLayout.this.v0(editable);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            TextInputLayout.this.f20232c.h();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            TextInputLayout.this.f20234d.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.f20273z0.y0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        private final TextInputLayout f20280d;

        public e(@NonNull TextInputLayout textInputLayout) {
            this.f20280d = textInputLayout;
        }

        public void g(@NonNull View view, @NonNull androidx.core.view.accessibility.k kVar) {
            Editable editable;
            boolean z10;
            String str;
            super.g(view, kVar);
            EditText editText = this.f20280d.getEditText();
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            CharSequence hint = this.f20280d.getHint();
            CharSequence error = this.f20280d.getError();
            CharSequence placeholderText = this.f20280d.getPlaceholderText();
            int counterMaxLength = this.f20280d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f20280d.getCounterOverflowDescription();
            boolean z11 = !TextUtils.isEmpty(editable);
            boolean z12 = !TextUtils.isEmpty(hint);
            boolean z13 = !this.f20280d.O();
            boolean z14 = !TextUtils.isEmpty(error);
            if (z14 || !TextUtils.isEmpty(counterOverflowDescription)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z12) {
                str = hint.toString();
            } else {
                str = "";
            }
            this.f20280d.f20230b.z(kVar);
            if (z11) {
                kVar.y0(editable);
            } else if (!TextUtils.isEmpty(str)) {
                kVar.y0(str);
                if (z13 && placeholderText != null) {
                    kVar.y0(str + ", " + placeholderText);
                }
            } else if (placeholderText != null) {
                kVar.y0(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    kVar.l0(str);
                } else {
                    if (z11) {
                        str = editable + ", " + str;
                    }
                    kVar.y0(str);
                }
                kVar.v0(!z11);
            }
            if (editable == null || editable.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            kVar.n0(counterMaxLength);
            if (z10) {
                if (!z14) {
                    error = counterOverflowDescription;
                }
                kVar.h0(error);
            }
            View t10 = this.f20280d.f20247k.t();
            if (t10 != null) {
                kVar.m0(t10);
            }
            this.f20280d.f20232c.m().o(view, kVar);
        }

        public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            this.f20280d.f20232c.m().p(view, accessibilityEvent);
        }
    }

    public interface f {
        int a(Editable editable);
    }

    public interface g {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    public interface h {
        void a(@NonNull TextInputLayout textInputLayout, int i10);
    }

    public TextInputLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.textInputStyle);
    }

    private boolean A() {
        return this.H && !TextUtils.isEmpty(this.I) && (this.K instanceof h);
    }

    private void B() {
        Iterator<g> it = this.f20246j0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void C(Canvas canvas) {
        tf.g gVar;
        if (this.P != null && (gVar = this.O) != null) {
            gVar.draw(canvas);
            if (this.f20234d.isFocused()) {
                Rect bounds = this.P.getBounds();
                Rect bounds2 = this.O.getBounds();
                float F2 = this.f20273z0.F();
                int centerX = bounds2.centerX();
                bounds.left = cf.a.c(centerX, bounds2.left, F2);
                bounds.right = cf.a.c(centerX, bounds2.right, F2);
                this.P.draw(canvas);
            }
        }
    }

    private void D(@NonNull Canvas canvas) {
        if (this.H) {
            this.f20273z0.l(canvas);
        }
    }

    private void E(boolean z10) {
        ValueAnimator valueAnimator = this.C0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.C0.cancel();
        }
        if (!z10 || !this.B0) {
            this.f20273z0.y0(0.0f);
        } else {
            k(0.0f);
        }
        if (A() && ((h) this.K).p0()) {
            x();
        }
        this.f20271y0 = true;
        K();
        this.f20230b.k(true);
        this.f20232c.G(true);
    }

    private tf.g F(boolean z10) {
        float f10;
        float f11;
        float dimensionPixelOffset = (float) getResources().getDimensionPixelOffset(bf.d.mtrl_shape_corner_size_small_component);
        if (z10) {
            f10 = dimensionPixelOffset;
        } else {
            f10 = 0.0f;
        }
        EditText editText = this.f20234d;
        if (editText instanceof MaterialAutoCompleteTextView) {
            f11 = ((MaterialAutoCompleteTextView) editText).getPopupElevation();
        } else {
            f11 = (float) getResources().getDimensionPixelOffset(bf.d.m3_comp_outlined_autocomplete_menu_container_elevation);
        }
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(bf.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        tf.k m10 = tf.k.a().A(f10).E(f10).s(dimensionPixelOffset).w(dimensionPixelOffset).m();
        tf.g m11 = tf.g.m(getContext(), f11);
        m11.setShapeAppearanceModel(m10);
        m11.d0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return m11;
    }

    private static Drawable G(tf.g gVar, int i10, int i11, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{hf.a.i(i11, i10, 0.1f), i10}), gVar, gVar);
    }

    private int H(int i10, boolean z10) {
        int compoundPaddingLeft = i10 + this.f20234d.getCompoundPaddingLeft();
        if (getPrefixText() == null || z10) {
            return compoundPaddingLeft;
        }
        return (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    private int I(int i10, boolean z10) {
        int compoundPaddingRight = i10 - this.f20234d.getCompoundPaddingRight();
        if (getPrefixText() == null || !z10) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    private static Drawable J(Context context, tf.g gVar, int i10, int[][] iArr) {
        int c10 = hf.a.c(context, bf.b.colorSurface, "TextInputLayout");
        tf.g gVar2 = new tf.g(gVar.E());
        int i11 = hf.a.i(i10, c10, 0.1f);
        gVar2.b0(new ColorStateList(iArr, new int[]{i11, 0}));
        gVar2.setTint(c10);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{i11, c10});
        tf.g gVar3 = new tf.g(gVar.E());
        gVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
    }

    private void K() {
        TextView textView = this.f20272z;
        if (textView != null && this.f20270y) {
            textView.setText((CharSequence) null);
            p.a(this.f20228a, this.E);
            this.f20272z.setVisibility(4);
        }
    }

    private boolean Q() {
        if (this.T != 1 || this.f20234d.getMinLines() > 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int R(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    private void S() {
        o();
        o0();
        x0();
        f0();
        j();
        if (this.T != 0) {
            q0();
        }
        Z();
    }

    private void T() {
        if (A()) {
            RectF rectF = this.f20239f0;
            this.f20273z0.o(rectF, this.f20234d.getWidth(), this.f20234d.getGravity());
            if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                n(rectF);
                rectF.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (rectF.height() / 2.0f)) + ((float) this.V));
                ((h) this.K).s0(rectF);
            }
        }
    }

    private void U() {
        if (A() && !this.f20271y0) {
            x();
            T();
        }
    }

    private static void V(@NonNull ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                V((ViewGroup) childAt, z10);
            }
        }
    }

    private void X() {
        TextView textView = this.f20272z;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void Z() {
        EditText editText = this.f20234d;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i10 = this.T;
                if (i10 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i10 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    private boolean c0() {
        if ((this.f20232c.F() || ((this.f20232c.z() && L()) || this.f20232c.w() != null)) && this.f20232c.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean d0() {
        if ((getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f20230b.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private void e0() {
        if (this.f20272z != null && this.f20270y && !TextUtils.isEmpty(this.f20268x)) {
            this.f20272z.setText(this.f20268x);
            p.a(this.f20228a, this.D);
            this.f20272z.setVisibility(0);
            this.f20272z.bringToFront();
            announceForAccessibility(this.f20268x);
        }
    }

    private void f0() {
        if (this.T != 1) {
            return;
        }
        if (qf.c.h(getContext())) {
            this.U = getResources().getDimensionPixelSize(bf.d.material_font_2_0_box_collapsed_padding_top);
        } else if (qf.c.g(getContext())) {
            this.U = getResources().getDimensionPixelSize(bf.d.material_font_1_3_box_collapsed_padding_top);
        }
    }

    private void g0(@NonNull Rect rect) {
        tf.g gVar = this.O;
        if (gVar != null) {
            int i10 = rect.bottom;
            gVar.setBounds(rect.left, i10 - this.W, rect.right, i10);
        }
        tf.g gVar2 = this.P;
        if (gVar2 != null) {
            int i11 = rect.bottom;
            gVar2.setBounds(rect.left, i11 - this.f20229a0, rect.right, i11);
        }
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f20234d;
        if (!(editText instanceof AutoCompleteTextView) || r.a(editText)) {
            return this.K;
        }
        int d10 = hf.a.d(this.f20234d, bf.b.colorControlHighlight);
        int i10 = this.T;
        if (i10 == 2) {
            return J(getContext(), this.K, d10, G0);
        }
        if (i10 == 1) {
            return G(this.K, this.f20233c0, d10, G0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.M == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.M = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.M.addState(new int[0], F(false));
        }
        return this.M;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.L == null) {
            this.L = F(true);
        }
        return this.L;
    }

    private void h0() {
        Editable editable;
        if (this.f20258q != null) {
            EditText editText = this.f20234d;
            if (editText == null) {
                editable = null;
            } else {
                editable = editText.getText();
            }
            i0(editable);
        }
    }

    private void i() {
        TextView textView = this.f20272z;
        if (textView != null) {
            this.f20228a.addView(textView);
            this.f20272z.setVisibility(0);
        }
    }

    private void j() {
        if (this.f20234d != null && this.T == 1) {
            if (qf.c.h(getContext())) {
                EditText editText = this.f20234d;
                n0.I0(editText, n0.G(editText), getResources().getDimensionPixelSize(bf.d.material_filled_edittext_font_2_0_padding_top), n0.F(this.f20234d), getResources().getDimensionPixelSize(bf.d.material_filled_edittext_font_2_0_padding_bottom));
            } else if (qf.c.g(getContext())) {
                EditText editText2 = this.f20234d;
                n0.I0(editText2, n0.G(editText2), getResources().getDimensionPixelSize(bf.d.material_filled_edittext_font_1_3_padding_top), n0.F(this.f20234d), getResources().getDimensionPixelSize(bf.d.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    private static void j0(@NonNull Context context, @NonNull TextView textView, int i10, int i11, boolean z10) {
        int i12;
        if (z10) {
            i12 = j.character_counter_overflowed_content_description;
        } else {
            i12 = j.character_counter_content_description;
        }
        textView.setContentDescription(context.getString(i12, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    private void k0() {
        int i10;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f20258q;
        if (textView != null) {
            if (this.f20253n) {
                i10 = this.f20262t;
            } else {
                i10 = this.f20266w;
            }
            a0(textView, i10);
            if (!this.f20253n && (colorStateList2 = this.F) != null) {
                this.f20258q.setTextColor(colorStateList2);
            }
            if (this.f20253n && (colorStateList = this.G) != null) {
                this.f20258q.setTextColor(colorStateList);
            }
        }
    }

    private void l() {
        tf.g gVar = this.K;
        if (gVar != null) {
            tf.k E2 = gVar.E();
            tf.k kVar = this.Q;
            if (E2 != kVar) {
                this.K.setShapeAppearanceModel(kVar);
            }
            if (v()) {
                this.K.h0((float) this.V, this.f20231b0);
            }
            int p10 = p();
            this.f20233c0 = p10;
            this.K.b0(ColorStateList.valueOf(p10));
            m();
            o0();
        }
    }

    @TargetApi(29)
    private void l0(boolean z10) {
        ColorStateList f10 = hf.a.f(getContext(), bf.b.colorControlActivated);
        EditText editText = this.f20234d;
        if (editText != null && editText.getTextCursorDrawable() != null && f10 != null) {
            Drawable a10 = this.f20234d.getTextCursorDrawable();
            if (z10) {
                ColorStateList colorStateList = this.f20261s0;
                if (colorStateList == null) {
                    colorStateList = ColorStateList.valueOf(this.f20231b0);
                }
                f10 = colorStateList;
            }
            androidx.core.graphics.drawable.a.o(a10, f10);
        }
    }

    private void m() {
        ColorStateList colorStateList;
        if (this.O != null && this.P != null) {
            if (w()) {
                tf.g gVar = this.O;
                if (this.f20234d.isFocused()) {
                    colorStateList = ColorStateList.valueOf(this.f20257p0);
                } else {
                    colorStateList = ColorStateList.valueOf(this.f20231b0);
                }
                gVar.b0(colorStateList);
                this.P.b0(ColorStateList.valueOf(this.f20231b0));
            }
            invalidate();
        }
    }

    private void n(@NonNull RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.S;
        rectF.left = f10 - ((float) i10);
        rectF.right += (float) i10;
    }

    private void o() {
        int i10 = this.T;
        if (i10 == 0) {
            this.K = null;
            this.O = null;
            this.P = null;
        } else if (i10 == 1) {
            this.K = new tf.g(this.Q);
            this.O = new tf.g();
            this.P = new tf.g();
        } else if (i10 == 2) {
            if (!this.H || (this.K instanceof h)) {
                this.K = new tf.g(this.Q);
            } else {
                this.K = h.o0(this.Q);
            }
            this.O = null;
            this.P = null;
        } else {
            throw new IllegalArgumentException(this.T + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private int p() {
        int i10 = this.f20233c0;
        if (this.T == 1) {
            return hf.a.h(hf.a.e(this, bf.b.colorSurface, 0), this.f20233c0);
        }
        return i10;
    }

    private boolean p0() {
        int max;
        if (this.f20234d == null || this.f20234d.getMeasuredHeight() >= (max = Math.max(this.f20232c.getMeasuredHeight(), this.f20230b.getMeasuredHeight()))) {
            return false;
        }
        this.f20234d.setMinimumHeight(max);
        return true;
    }

    @NonNull
    private Rect q(@NonNull Rect rect) {
        if (this.f20234d != null) {
            Rect rect2 = this.f20237e0;
            boolean i10 = r.i(this);
            rect2.bottom = rect.bottom;
            int i11 = this.T;
            if (i11 == 1) {
                rect2.left = H(rect.left, i10);
                rect2.top = rect.top + this.U;
                rect2.right = I(rect.right, i10);
                return rect2;
            } else if (i11 != 2) {
                rect2.left = H(rect.left, i10);
                rect2.top = getPaddingTop();
                rect2.right = I(rect.right, i10);
                return rect2;
            } else {
                rect2.left = rect.left + this.f20234d.getPaddingLeft();
                rect2.top = rect.top - u();
                rect2.right = rect.right - this.f20234d.getPaddingRight();
                return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private void q0() {
        if (this.T != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20228a.getLayoutParams();
            int u10 = u();
            if (u10 != layoutParams.topMargin) {
                layoutParams.topMargin = u10;
                this.f20228a.requestLayout();
            }
        }
    }

    private int r(@NonNull Rect rect, @NonNull Rect rect2, float f10) {
        if (Q()) {
            return (int) (((float) rect2.top) + f10);
        }
        return rect.bottom - this.f20234d.getCompoundPaddingBottom();
    }

    private int s(@NonNull Rect rect, float f10) {
        if (Q()) {
            return (int) (((float) rect.centerY()) - (f10 / 2.0f));
        }
        return rect.top + this.f20234d.getCompoundPaddingTop();
    }

    private void s0(boolean z10, boolean z11) {
        boolean z12;
        boolean z13;
        ColorStateList colorStateList;
        TextView textView;
        int i10;
        boolean isEnabled = isEnabled();
        EditText editText = this.f20234d;
        if (editText == null || TextUtils.isEmpty(editText.getText())) {
            z12 = false;
        } else {
            z12 = true;
        }
        EditText editText2 = this.f20234d;
        if (editText2 == null || !editText2.hasFocus()) {
            z13 = false;
        } else {
            z13 = true;
        }
        ColorStateList colorStateList2 = this.f20254n0;
        if (colorStateList2 != null) {
            this.f20273z0.d0(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f20254n0;
            if (colorStateList3 != null) {
                i10 = colorStateList3.getColorForState(new int[]{-16842910}, this.f20269x0);
            } else {
                i10 = this.f20269x0;
            }
            this.f20273z0.d0(ColorStateList.valueOf(i10));
        } else if (b0()) {
            this.f20273z0.d0(this.f20247k.r());
        } else if (this.f20253n && (textView = this.f20258q) != null) {
            this.f20273z0.d0(textView.getTextColors());
        } else if (z13 && (colorStateList = this.f20255o0) != null) {
            this.f20273z0.i0(colorStateList);
        }
        if (z12 || !this.A0 || (isEnabled() && z13)) {
            if (z11 || this.f20271y0) {
                y(z10);
            }
        } else if (z11 || !this.f20271y0) {
            E(z10);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f20234d == null) {
            if (getEndIconMode() != 3) {
                boolean z10 = editText instanceof TextInputEditText;
            }
            this.f20234d = editText;
            int i10 = this.f20238f;
            if (i10 != -1) {
                setMinEms(i10);
            } else {
                setMinWidth(this.f20242h);
            }
            int i11 = this.f20240g;
            if (i11 != -1) {
                setMaxEms(i11);
            } else {
                setMaxWidth(this.f20245j);
            }
            this.N = false;
            S();
            setTextInputAccessibilityDelegate(new e(this));
            this.f20273z0.N0(this.f20234d.getTypeface());
            this.f20273z0.v0(this.f20234d.getTextSize());
            this.f20273z0.q0(this.f20234d.getLetterSpacing());
            int gravity = this.f20234d.getGravity();
            this.f20273z0.j0((gravity & -113) | 48);
            this.f20273z0.u0(gravity);
            this.f20234d.addTextChangedListener(new a());
            if (this.f20254n0 == null) {
                this.f20254n0 = this.f20234d.getHintTextColors();
            }
            if (this.H) {
                if (TextUtils.isEmpty(this.I)) {
                    CharSequence hint = this.f20234d.getHint();
                    this.f20236e = hint;
                    setHint(hint);
                    this.f20234d.setHint((CharSequence) null);
                }
                this.J = true;
            }
            if (this.f20258q != null) {
                i0(this.f20234d.getText());
            }
            n0();
            this.f20247k.f();
            this.f20230b.bringToFront();
            this.f20232c.bringToFront();
            B();
            this.f20232c.w0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            s0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.I)) {
            this.I = charSequence;
            this.f20273z0.K0(charSequence);
            if (!this.f20271y0) {
                T();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f20270y != z10) {
            if (z10) {
                i();
            } else {
                X();
                this.f20272z = null;
            }
            this.f20270y = z10;
        }
    }

    @NonNull
    private Rect t(@NonNull Rect rect) {
        if (this.f20234d != null) {
            Rect rect2 = this.f20237e0;
            float C2 = this.f20273z0.C();
            rect2.left = rect.left + this.f20234d.getCompoundPaddingLeft();
            rect2.top = s(rect, C2);
            rect2.right = rect.right - this.f20234d.getCompoundPaddingRight();
            rect2.bottom = r(rect, rect2, C2);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void t0() {
        EditText editText;
        if (this.f20272z != null && (editText = this.f20234d) != null) {
            this.f20272z.setGravity(editText.getGravity());
            this.f20272z.setPadding(this.f20234d.getCompoundPaddingLeft(), this.f20234d.getCompoundPaddingTop(), this.f20234d.getCompoundPaddingRight(), this.f20234d.getCompoundPaddingBottom());
        }
    }

    private int u() {
        float r10;
        if (!this.H) {
            return 0;
        }
        int i10 = this.T;
        if (i10 == 0) {
            r10 = this.f20273z0.r();
        } else if (i10 != 2) {
            return 0;
        } else {
            r10 = this.f20273z0.r() / 2.0f;
        }
        return (int) r10;
    }

    private void u0() {
        EditText editText = this.f20234d;
        v0(editText == null ? null : editText.getText());
    }

    private boolean v() {
        return this.T == 2 && w();
    }

    /* access modifiers changed from: private */
    public void v0(Editable editable) {
        if (this.f20256p.a(editable) != 0 || this.f20271y0) {
            K();
        } else {
            e0();
        }
    }

    private boolean w() {
        return this.V > -1 && this.f20231b0 != 0;
    }

    private void w0(boolean z10, boolean z11) {
        int defaultColor = this.f20261s0.getDefaultColor();
        int colorForState = this.f20261s0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f20261s0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z10) {
            this.f20231b0 = colorForState2;
        } else if (z11) {
            this.f20231b0 = colorForState;
        } else {
            this.f20231b0 = defaultColor;
        }
    }

    private void x() {
        if (A()) {
            ((h) this.K).q0();
        }
    }

    private void y(boolean z10) {
        ValueAnimator valueAnimator = this.C0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.C0.cancel();
        }
        if (!z10 || !this.B0) {
            this.f20273z0.y0(1.0f);
        } else {
            k(1.0f);
        }
        this.f20271y0 = false;
        if (A()) {
            T();
        }
        u0();
        this.f20230b.k(false);
        this.f20232c.G(false);
    }

    private x1.d z() {
        x1.d dVar = new x1.d();
        dVar.c0((long) of.a.f(getContext(), bf.b.motionDurationShort2, 87));
        dVar.f0(of.a.g(getContext(), bf.b.motionEasingLinearInterpolator, cf.a.f18977a));
        return dVar;
    }

    public boolean L() {
        return this.f20232c.E();
    }

    public boolean M() {
        return this.f20247k.A();
    }

    public boolean N() {
        return this.f20247k.B();
    }

    /* access modifiers changed from: package-private */
    public final boolean O() {
        return this.f20271y0;
    }

    public boolean P() {
        return this.J;
    }

    public void W() {
        this.f20230b.l();
    }

    public void Y(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        boolean i10 = r.i(this);
        this.R = i10;
        if (i10) {
            f14 = f11;
        } else {
            f14 = f10;
        }
        if (!i10) {
            f10 = f11;
        }
        if (i10) {
            f15 = f13;
        } else {
            f15 = f12;
        }
        if (!i10) {
            f12 = f13;
        }
        tf.g gVar = this.K;
        if (gVar == null || gVar.J() != f14 || this.K.K() != f10 || this.K.s() != f15 || this.K.t() != f12) {
            this.Q = this.Q.v().A(f14).E(f10).s(f15).w(f12).m();
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(@NonNull TextView textView, int i10) {
        boolean z10 = true;
        try {
            l.s(textView, i10);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z10 = false;
            }
        } catch (Exception unused) {
        }
        if (z10) {
            l.s(textView, k.TextAppearance_AppCompat_Caption);
            textView.setTextColor(androidx.core.content.a.getColor(getContext(), bf.c.design_error));
        }
    }

    public void addView(@NonNull View view, int i10, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f20228a.addView(view, layoutParams2);
            this.f20228a.setLayoutParams(layoutParams);
            q0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i10, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean b0() {
        return this.f20247k.l();
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i10) {
        EditText editText = this.f20234d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f20236e != null) {
            boolean z10 = this.J;
            this.J = false;
            CharSequence hint = editText.getHint();
            this.f20234d.setHint(this.f20236e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
            } finally {
                this.f20234d.setHint(hint);
                this.J = z10;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i10);
            onProvideAutofillVirtualStructure(viewStructure, i10);
            viewStructure.setChildCount(this.f20228a.getChildCount());
            for (int i11 = 0; i11 < this.f20228a.getChildCount(); i11++) {
                View childAt = this.f20228a.getChildAt(i11);
                ViewStructure newChild = viewStructure.newChild(i11);
                childAt.dispatchProvideAutofillStructure(newChild, i10);
                if (childAt == this.f20234d) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.E0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.E0 = false;
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        D(canvas);
        C(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z10;
        if (!this.D0) {
            boolean z11 = true;
            this.D0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            com.google.android.material.internal.b bVar = this.f20273z0;
            if (bVar != null) {
                z10 = bVar.I0(drawableState) | false;
            } else {
                z10 = false;
            }
            if (this.f20234d != null) {
                if (!n0.W(this) || !isEnabled()) {
                    z11 = false;
                }
                r0(z11);
            }
            n0();
            x0();
            if (z10) {
                invalidate();
            }
            this.D0 = false;
        }
    }

    public int getBaseline() {
        EditText editText = this.f20234d;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + u();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public tf.g getBoxBackground() {
        int i10 = this.T;
        if (i10 == 1 || i10 == 2) {
            return this.K;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f20233c0;
    }

    public int getBoxBackgroundMode() {
        return this.T;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.U;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (r.i(this)) {
            return this.Q.j().a(this.f20239f0);
        }
        return this.Q.l().a(this.f20239f0);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (r.i(this)) {
            return this.Q.l().a(this.f20239f0);
        }
        return this.Q.j().a(this.f20239f0);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (r.i(this)) {
            return this.Q.r().a(this.f20239f0);
        }
        return this.Q.t().a(this.f20239f0);
    }

    public float getBoxCornerRadiusTopStart() {
        if (r.i(this)) {
            return this.Q.t().a(this.f20239f0);
        }
        return this.Q.r().a(this.f20239f0);
    }

    public int getBoxStrokeColor() {
        return this.f20260r0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f20261s0;
    }

    public int getBoxStrokeWidth() {
        return this.W;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f20229a0;
    }

    public int getCounterMaxLength() {
        return this.f20251m;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f20249l || !this.f20253n || (textView = this.f20258q) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.G;
    }

    public ColorStateList getCounterTextColor() {
        return this.F;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f20254n0;
    }

    public EditText getEditText() {
        return this.f20234d;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f20232c.l();
    }

    public Drawable getEndIconDrawable() {
        return this.f20232c.n();
    }

    public int getEndIconMinSize() {
        return this.f20232c.o();
    }

    public int getEndIconMode() {
        return this.f20232c.p();
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f20232c.q();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f20232c.r();
    }

    public CharSequence getError() {
        if (this.f20247k.A()) {
            return this.f20247k.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f20247k.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.f20247k.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f20247k.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.f20232c.s();
    }

    public CharSequence getHelperText() {
        if (this.f20247k.B()) {
            return this.f20247k.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f20247k.u();
    }

    public CharSequence getHint() {
        if (this.H) {
            return this.I;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.f20273z0.r();
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.f20273z0.w();
    }

    public ColorStateList getHintTextColor() {
        return this.f20255o0;
    }

    @NonNull
    public f getLengthCounter() {
        return this.f20256p;
    }

    public int getMaxEms() {
        return this.f20240g;
    }

    public int getMaxWidth() {
        return this.f20245j;
    }

    public int getMinEms() {
        return this.f20238f;
    }

    public int getMinWidth() {
        return this.f20242h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f20232c.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f20232c.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.f20270y) {
            return this.f20268x;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.C;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.B;
    }

    public CharSequence getPrefixText() {
        return this.f20230b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f20230b.b();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f20230b.c();
    }

    @NonNull
    public tf.k getShapeAppearanceModel() {
        return this.Q;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f20230b.d();
    }

    public Drawable getStartIconDrawable() {
        return this.f20230b.e();
    }

    public int getStartIconMinSize() {
        return this.f20230b.f();
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f20230b.g();
    }

    public CharSequence getSuffixText() {
        return this.f20232c.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f20232c.x();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f20232c.y();
    }

    public Typeface getTypeface() {
        return this.f20241g0;
    }

    public void h(@NonNull g gVar) {
        this.f20246j0.add(gVar);
        if (this.f20234d != null) {
            gVar.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void i0(Editable editable) {
        boolean z10;
        int a10 = this.f20256p.a(editable);
        boolean z11 = this.f20253n;
        int i10 = this.f20251m;
        if (i10 == -1) {
            this.f20258q.setText(String.valueOf(a10));
            this.f20258q.setContentDescription((CharSequence) null);
            this.f20253n = false;
        } else {
            if (a10 > i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f20253n = z10;
            j0(getContext(), this.f20258q, a10, this.f20251m, this.f20253n);
            if (z11 != this.f20253n) {
                k0();
            }
            this.f20258q.setText(androidx.core.text.a.c().j(getContext().getString(j.character_counter_pattern, new Object[]{Integer.valueOf(a10), Integer.valueOf(this.f20251m)})));
        }
        if (this.f20234d != null && z11 != this.f20253n) {
            r0(false);
            x0();
            n0();
        }
    }

    /* access modifiers changed from: package-private */
    public void k(float f10) {
        if (this.f20273z0.F() != f10) {
            if (this.C0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.C0 = valueAnimator;
                valueAnimator.setInterpolator(of.a.g(getContext(), bf.b.motionEasingEmphasizedInterpolator, cf.a.f18978b));
                this.C0.setDuration((long) of.a.f(getContext(), bf.b.motionDurationMedium4, Opcodes.GOTO));
                this.C0.addUpdateListener(new d());
            }
            this.C0.setFloatValues(new float[]{this.f20273z0.F(), f10});
            this.C0.start();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m0() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.f20234d
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.d0()
            r2 = 0
            r3 = 2
            r4 = 3
            r5 = 1
            if (r0 == 0) goto L_0x0049
            com.google.android.material.textfield.z r0 = r10.f20230b
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.f20234d
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.f20243h0
            if (r6 == 0) goto L_0x0025
            int r6 = r10.f20244i0
            if (r6 == r0) goto L_0x0031
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.f20243h0 = r6
            r10.f20244i0 = r0
            r6.setBounds(r1, r1, r0, r5)
        L_0x0031:
            android.widget.EditText r0 = r10.f20234d
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.l.d(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.f20243h0
            if (r6 == r7) goto L_0x0062
            android.widget.EditText r6 = r10.f20234d
            r8 = r0[r5]
            r9 = r0[r3]
            r0 = r0[r4]
            androidx.core.widget.l.n(r6, r7, r8, r9, r0)
            goto L_0x0060
        L_0x0049:
            android.graphics.drawable.Drawable r0 = r10.f20243h0
            if (r0 == 0) goto L_0x0062
            android.widget.EditText r0 = r10.f20234d
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.l.d(r0)
            android.widget.EditText r6 = r10.f20234d
            r7 = r0[r5]
            r8 = r0[r3]
            r0 = r0[r4]
            androidx.core.widget.l.n(r6, r2, r7, r8, r0)
            r10.f20243h0 = r2
        L_0x0060:
            r0 = r5
            goto L_0x0063
        L_0x0062:
            r0 = r1
        L_0x0063:
            boolean r6 = r10.c0()
            if (r6 == 0) goto L_0x00d7
            com.google.android.material.textfield.s r2 = r10.f20232c
            android.widget.TextView r2 = r2.y()
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.f20234d
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            com.google.android.material.textfield.s r6 = r10.f20232c
            com.google.android.material.internal.CheckableImageButton r6 = r6.k()
            if (r6 == 0) goto L_0x0092
            int r7 = r6.getMeasuredWidth()
            int r2 = r2 + r7
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = androidx.core.view.h.b(r6)
            int r2 = r2 + r6
        L_0x0092:
            android.widget.EditText r6 = r10.f20234d
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.l.d(r6)
            android.graphics.drawable.Drawable r7 = r10.f20248k0
            if (r7 == 0) goto L_0x00b3
            int r8 = r10.f20250l0
            if (r8 == r2) goto L_0x00b3
            r10.f20250l0 = r2
            r7.setBounds(r1, r1, r2, r5)
            android.widget.EditText r0 = r10.f20234d
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r3 = r10.f20248k0
            r4 = r6[r4]
            androidx.core.widget.l.n(r0, r1, r2, r3, r4)
            goto L_0x00f8
        L_0x00b3:
            if (r7 != 0) goto L_0x00c1
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.f20248k0 = r7
            r10.f20250l0 = r2
            r7.setBounds(r1, r1, r2, r5)
        L_0x00c1:
            r2 = r6[r3]
            android.graphics.drawable.Drawable r3 = r10.f20248k0
            if (r2 == r3) goto L_0x00d5
            r10.f20252m0 = r2
            android.widget.EditText r0 = r10.f20234d
            r1 = r6[r1]
            r2 = r6[r5]
            r4 = r6[r4]
            androidx.core.widget.l.n(r0, r1, r2, r3, r4)
            goto L_0x00f8
        L_0x00d5:
            r5 = r0
            goto L_0x00f8
        L_0x00d7:
            android.graphics.drawable.Drawable r6 = r10.f20248k0
            if (r6 == 0) goto L_0x00f9
            android.widget.EditText r6 = r10.f20234d
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.l.d(r6)
            r3 = r6[r3]
            android.graphics.drawable.Drawable r7 = r10.f20248k0
            if (r3 != r7) goto L_0x00f5
            android.widget.EditText r0 = r10.f20234d
            r1 = r6[r1]
            r3 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.f20252m0
            r4 = r6[r4]
            androidx.core.widget.l.n(r0, r1, r3, r7, r4)
            goto L_0x00f6
        L_0x00f5:
            r5 = r0
        L_0x00f6:
            r10.f20248k0 = r2
        L_0x00f8:
            r0 = r5
        L_0x00f9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.m0():boolean");
    }

    /* access modifiers changed from: package-private */
    public void n0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f20234d;
        if (editText != null && this.T == 0 && (background = editText.getBackground()) != null) {
            if (k0.a(background)) {
                background = background.mutate();
            }
            if (b0()) {
                background.setColorFilter(androidx.appcompat.widget.h.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
            } else if (!this.f20253n || (textView = this.f20258q) == null) {
                androidx.core.graphics.drawable.a.c(background);
                this.f20234d.refreshDrawableState();
            } else {
                background.setColorFilter(androidx.appcompat.widget.h.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o0() {
        EditText editText = this.f20234d;
        if (editText != null && this.K != null) {
            if ((this.N || editText.getBackground() == null) && this.T != 0) {
                n0.w0(this.f20234d, getEditTextBoxBackground());
                this.N = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f20273z0.Y(configuration);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f20234d;
        if (editText != null) {
            Rect rect = this.f20235d0;
            com.google.android.material.internal.d.a(this, editText, rect);
            g0(rect);
            if (this.H) {
                this.f20273z0.v0(this.f20234d.getTextSize());
                int gravity = this.f20234d.getGravity();
                this.f20273z0.j0((gravity & -113) | 48);
                this.f20273z0.u0(gravity);
                this.f20273z0.f0(q(rect));
                this.f20273z0.p0(t(rect));
                this.f20273z0.a0();
                if (A() && !this.f20271y0) {
                    T();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        boolean p02 = p0();
        boolean m02 = m0();
        if (p02 || m02) {
            this.f20234d.post(new c());
        }
        t0();
        this.f20232c.w0();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f20274c);
        if (savedState.f20275d) {
            post(new b());
        }
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        if (z10 != this.R) {
            float a10 = this.Q.r().a(this.f20239f0);
            float a11 = this.Q.t().a(this.f20239f0);
            float a12 = this.Q.j().a(this.f20239f0);
            float a13 = this.Q.l().a(this.f20239f0);
            tf.d q10 = this.Q.q();
            tf.d s10 = this.Q.s();
            tf.k m10 = tf.k.a().z(s10).D(q10).r(this.Q.k()).v(this.Q.i()).A(a11).E(a10).s(a13).w(a12).m();
            this.R = z10;
            setShapeAppearanceModel(m10);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (b0()) {
            savedState.f20274c = getError();
        }
        savedState.f20275d = this.f20232c.D();
        return savedState;
    }

    /* access modifiers changed from: package-private */
    public void r0(boolean z10) {
        s0(z10, false);
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.f20233c0 != i10) {
            this.f20233c0 = i10;
            this.f20263t0 = i10;
            this.f20265v0 = i10;
            this.f20267w0 = i10;
            l();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(androidx.core.content.a.getColor(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f20263t0 = defaultColor;
        this.f20233c0 = defaultColor;
        this.f20264u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f20265v0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f20267w0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 != this.T) {
            this.T = i10;
            if (this.f20234d != null) {
                S();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.U = i10;
    }

    public void setBoxCornerFamily(int i10) {
        this.Q = this.Q.v().y(i10, this.Q.r()).C(i10, this.Q.t()).q(i10, this.Q.j()).u(i10, this.Q.l()).m();
        l();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.f20260r0 != i10) {
            this.f20260r0 = i10;
            x0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f20257p0 = colorStateList.getDefaultColor();
            this.f20269x0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f20259q0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.f20260r0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.f20260r0 != colorStateList.getDefaultColor()) {
            this.f20260r0 = colorStateList.getDefaultColor();
        }
        x0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f20261s0 != colorStateList) {
            this.f20261s0 = colorStateList;
            x0();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.W = i10;
        x0();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.f20229a0 = i10;
        x0();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f20249l != z10) {
            if (z10) {
                d0 d0Var = new d0(getContext());
                this.f20258q = d0Var;
                d0Var.setId(bf.f.textinput_counter);
                Typeface typeface = this.f20241g0;
                if (typeface != null) {
                    this.f20258q.setTypeface(typeface);
                }
                this.f20258q.setMaxLines(1);
                this.f20247k.e(this.f20258q, 2);
                androidx.core.view.h.d((ViewGroup.MarginLayoutParams) this.f20258q.getLayoutParams(), getResources().getDimensionPixelOffset(bf.d.mtrl_textinput_counter_margin_start));
                k0();
                h0();
            } else {
                this.f20247k.C(this.f20258q, 2);
                this.f20258q = null;
            }
            this.f20249l = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f20251m != i10) {
            if (i10 > 0) {
                this.f20251m = i10;
            } else {
                this.f20251m = -1;
            }
            if (this.f20249l) {
                h0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f20262t != i10) {
            this.f20262t = i10;
            k0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            k0();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f20266w != i10) {
            this.f20266w = i10;
            k0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            k0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f20254n0 = colorStateList;
        this.f20255o0 = colorStateList;
        if (this.f20234d != null) {
            r0(false);
        }
    }

    public void setEnabled(boolean z10) {
        V(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f20232c.M(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f20232c.N(z10);
    }

    public void setEndIconContentDescription(int i10) {
        this.f20232c.O(i10);
    }

    public void setEndIconDrawable(int i10) {
        this.f20232c.Q(i10);
    }

    public void setEndIconMinSize(int i10) {
        this.f20232c.S(i10);
    }

    public void setEndIconMode(int i10) {
        this.f20232c.T(i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f20232c.U(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f20232c.V(onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f20232c.W(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f20232c.X(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f20232c.Y(mode);
    }

    public void setEndIconVisible(boolean z10) {
        this.f20232c.Z(z10);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f20247k.A()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f20247k.Q(charSequence);
        } else {
            this.f20247k.w();
        }
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        this.f20247k.E(i10);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f20247k.F(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f20247k.G(z10);
    }

    public void setErrorIconDrawable(int i10) {
        this.f20232c.a0(i10);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f20232c.c0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f20232c.d0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f20232c.e0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f20232c.f0(mode);
    }

    public void setErrorTextAppearance(int i10) {
        this.f20247k.H(i10);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f20247k.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.A0 != z10) {
            this.A0 = z10;
            r0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!N()) {
                setHelperTextEnabled(true);
            }
            this.f20247k.R(charSequence);
        } else if (N()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f20247k.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f20247k.K(z10);
    }

    public void setHelperTextTextAppearance(int i10) {
        this.f20247k.J(i10);
    }

    public void setHint(CharSequence charSequence) {
        if (this.H) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.B0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.H) {
            this.H = z10;
            if (!z10) {
                this.J = false;
                if (!TextUtils.isEmpty(this.I) && TextUtils.isEmpty(this.f20234d.getHint())) {
                    this.f20234d.setHint(this.I);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint = this.f20234d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.I)) {
                        setHint(hint);
                    }
                    this.f20234d.setHint((CharSequence) null);
                }
                this.J = true;
            }
            if (this.f20234d != null) {
                q0();
            }
        }
    }

    public void setHintTextAppearance(int i10) {
        this.f20273z0.g0(i10);
        this.f20255o0 = this.f20273z0.p();
        if (this.f20234d != null) {
            r0(false);
            q0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f20255o0 != colorStateList) {
            if (this.f20254n0 == null) {
                this.f20273z0.i0(colorStateList);
            }
            this.f20255o0 = colorStateList;
            if (this.f20234d != null) {
                r0(false);
            }
        }
    }

    public void setLengthCounter(@NonNull f fVar) {
        this.f20256p = fVar;
    }

    public void setMaxEms(int i10) {
        this.f20240g = i10;
        EditText editText = this.f20234d;
        if (editText != null && i10 != -1) {
            editText.setMaxEms(i10);
        }
    }

    public void setMaxWidth(int i10) {
        this.f20245j = i10;
        EditText editText = this.f20234d;
        if (editText != null && i10 != -1) {
            editText.setMaxWidth(i10);
        }
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f20238f = i10;
        EditText editText = this.f20234d;
        if (editText != null && i10 != -1) {
            editText.setMinEms(i10);
        }
    }

    public void setMinWidth(int i10) {
        this.f20242h = i10;
        EditText editText = this.f20234d;
        if (editText != null && i10 != -1) {
            editText.setMinWidth(i10);
        }
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        this.f20232c.h0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        this.f20232c.j0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        this.f20232c.l0(z10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f20232c.m0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f20232c.n0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f20272z == null) {
            d0 d0Var = new d0(getContext());
            this.f20272z = d0Var;
            d0Var.setId(bf.f.textinput_placeholder);
            n0.D0(this.f20272z, 2);
            x1.d z10 = z();
            this.D = z10;
            z10.i0(67);
            this.E = z();
            setPlaceholderTextAppearance(this.C);
            setPlaceholderTextColor(this.B);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f20270y) {
                setPlaceholderTextEnabled(true);
            }
            this.f20268x = charSequence;
        }
        u0();
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.C = i10;
        TextView textView = this.f20272z;
        if (textView != null) {
            l.s(textView, i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            TextView textView = this.f20272z;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f20230b.m(charSequence);
    }

    public void setPrefixTextAppearance(int i10) {
        this.f20230b.n(i10);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f20230b.o(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull tf.k kVar) {
        tf.g gVar = this.K;
        if (gVar != null && gVar.E() != kVar) {
            this.Q = kVar;
            l();
        }
    }

    public void setStartIconCheckable(boolean z10) {
        this.f20230b.p(z10);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    public void setStartIconMinSize(int i10) {
        this.f20230b.s(i10);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f20230b.t(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f20230b.u(onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f20230b.v(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f20230b.w(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f20230b.x(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.f20230b.y(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f20232c.o0(charSequence);
    }

    public void setSuffixTextAppearance(int i10) {
        this.f20232c.p0(i10);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f20232c.q0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f20234d;
        if (editText != null) {
            n0.s0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f20241g0) {
            this.f20241g0 = typeface;
            this.f20273z0.N0(typeface);
            this.f20247k.N(typeface);
            TextView textView = this.f20258q;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void x0() {
        boolean z10;
        boolean z11;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.K != null && this.T != 0) {
            boolean z12 = false;
            if (isFocused() || ((editText2 = this.f20234d) != null && editText2.hasFocus())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (isHovered() || ((editText = this.f20234d) != null && editText.isHovered())) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (b0() || (this.f20258q != null && this.f20253n)) {
                z12 = true;
            }
            if (!isEnabled()) {
                this.f20231b0 = this.f20269x0;
            } else if (b0()) {
                if (this.f20261s0 != null) {
                    w0(z10, z11);
                } else {
                    this.f20231b0 = getErrorCurrentTextColors();
                }
            } else if (!this.f20253n || (textView = this.f20258q) == null) {
                if (z10) {
                    this.f20231b0 = this.f20260r0;
                } else if (z11) {
                    this.f20231b0 = this.f20259q0;
                } else {
                    this.f20231b0 = this.f20257p0;
                }
            } else if (this.f20261s0 != null) {
                w0(z10, z11);
            } else {
                this.f20231b0 = textView.getCurrentTextColor();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                l0(z12);
            }
            this.f20232c.H();
            W();
            if (this.T == 2) {
                int i10 = this.V;
                if (!z10 || !isEnabled()) {
                    this.V = this.W;
                } else {
                    this.V = this.f20229a0;
                }
                if (this.V != i10) {
                    U();
                }
            }
            if (this.T == 1) {
                if (!isEnabled()) {
                    this.f20233c0 = this.f20264u0;
                } else if (z11 && !z10) {
                    this.f20233c0 = this.f20267w0;
                } else if (z10) {
                    this.f20233c0 = this.f20265v0;
                } else {
                    this.f20233c0 = this.f20263t0;
                }
            }
            l();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r21, android.util.AttributeSet r22, int r23) {
        /*
            r20 = this;
            r0 = r20
            r7 = r22
            r8 = r23
            int r9 = F0
            r1 = r21
            android.content.Context r1 = wf.a.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = -1
            r0.f20238f = r10
            r0.f20240g = r10
            r0.f20242h = r10
            r0.f20245j = r10
            com.google.android.material.textfield.v r1 = new com.google.android.material.textfield.v
            r1.<init>(r0)
            r0.f20247k = r1
            com.google.android.material.textfield.d0 r1 = new com.google.android.material.textfield.d0
            r1.<init>()
            r0.f20256p = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.f20235d0 = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.f20237e0 = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.f20239f0 = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.f20246j0 = r1
            com.google.android.material.internal.b r1 = new com.google.android.material.internal.b
            r1.<init>(r0)
            r0.f20273z0 = r1
            android.content.Context r11 = r20.getContext()
            r12 = 1
            r0.setOrientation(r12)
            r13 = 0
            r0.setWillNotDraw(r13)
            r0.setAddStatesFromChildren(r12)
            android.widget.FrameLayout r14 = new android.widget.FrameLayout
            r14.<init>(r11)
            r0.f20228a = r14
            r14.setAddStatesFromChildren(r12)
            android.animation.TimeInterpolator r2 = cf.a.f18977a
            r1.L0(r2)
            r1.G0(r2)
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.j0(r2)
            int[] r3 = bf.l.TextInputLayout
            r1 = 5
            int[] r6 = new int[r1]
            int r15 = bf.l.TextInputLayout_counterTextAppearance
            r6[r13] = r15
            int r5 = bf.l.TextInputLayout_counterOverflowTextAppearance
            r6[r12] = r5
            int r4 = bf.l.TextInputLayout_errorTextAppearance
            r2 = 2
            r6[r2] = r4
            int r1 = bf.l.TextInputLayout_helperTextTextAppearance
            r16 = 3
            r6[r16] = r1
            int r13 = bf.l.TextInputLayout_hintTextAppearance
            r16 = 4
            r6[r16] = r13
            r17 = r1
            r1 = r11
            r2 = r22
            r18 = r4
            r4 = r23
            r19 = r5
            r5 = r9
            androidx.appcompat.widget.h1 r1 = com.google.android.material.internal.p.j(r1, r2, r3, r4, r5, r6)
            com.google.android.material.textfield.z r2 = new com.google.android.material.textfield.z
            r2.<init>(r0, r1)
            r0.f20230b = r2
            int r3 = bf.l.TextInputLayout_hintEnabled
            boolean r3 = r1.a(r3, r12)
            r0.H = r3
            int r3 = bf.l.TextInputLayout_android_hint
            java.lang.CharSequence r3 = r1.p(r3)
            r0.setHint((java.lang.CharSequence) r3)
            int r3 = bf.l.TextInputLayout_hintAnimationEnabled
            boolean r3 = r1.a(r3, r12)
            r0.B0 = r3
            int r3 = bf.l.TextInputLayout_expandedHintEnabled
            boolean r3 = r1.a(r3, r12)
            r0.A0 = r3
            int r3 = bf.l.TextInputLayout_android_minEms
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x00d8
            int r3 = r1.k(r3, r10)
            r0.setMinEms(r3)
            goto L_0x00e7
        L_0x00d8:
            int r3 = bf.l.TextInputLayout_android_minWidth
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x00e7
            int r3 = r1.f(r3, r10)
            r0.setMinWidth(r3)
        L_0x00e7:
            int r3 = bf.l.TextInputLayout_android_maxEms
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x00f7
            int r3 = r1.k(r3, r10)
            r0.setMaxEms(r3)
            goto L_0x0106
        L_0x00f7:
            int r3 = bf.l.TextInputLayout_android_maxWidth
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x0106
            int r3 = r1.f(r3, r10)
            r0.setMaxWidth(r3)
        L_0x0106:
            tf.k$b r3 = tf.k.e(r11, r7, r8, r9)
            tf.k r3 = r3.m()
            r0.Q = r3
            android.content.res.Resources r3 = r11.getResources()
            int r4 = bf.d.mtrl_textinput_box_label_cutout_padding
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.S = r3
            int r3 = bf.l.TextInputLayout_boxCollapsedPaddingTop
            r4 = 0
            int r3 = r1.e(r3, r4)
            r0.U = r3
            int r3 = bf.l.TextInputLayout_boxStrokeWidth
            android.content.res.Resources r4 = r11.getResources()
            int r5 = bf.d.mtrl_textinput_box_stroke_width_default
            int r4 = r4.getDimensionPixelSize(r5)
            int r3 = r1.f(r3, r4)
            r0.W = r3
            int r3 = bf.l.TextInputLayout_boxStrokeWidthFocused
            android.content.res.Resources r4 = r11.getResources()
            int r5 = bf.d.mtrl_textinput_box_stroke_width_focused
            int r4 = r4.getDimensionPixelSize(r5)
            int r3 = r1.f(r3, r4)
            r0.f20229a0 = r3
            int r3 = r0.W
            r0.V = r3
            int r3 = bf.l.TextInputLayout_boxCornerRadiusTopStart
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r3 = r1.d(r3, r4)
            int r5 = bf.l.TextInputLayout_boxCornerRadiusTopEnd
            float r5 = r1.d(r5, r4)
            int r6 = bf.l.TextInputLayout_boxCornerRadiusBottomEnd
            float r6 = r1.d(r6, r4)
            int r7 = bf.l.TextInputLayout_boxCornerRadiusBottomStart
            float r4 = r1.d(r7, r4)
            tf.k r7 = r0.Q
            tf.k$b r7 = r7.v()
            r8 = 0
            int r9 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x0175
            r7.A(r3)
        L_0x0175:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x017c
            r7.E(r5)
        L_0x017c:
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0183
            r7.w(r6)
        L_0x0183:
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x018a
            r7.s(r4)
        L_0x018a:
            tf.k r3 = r7.m()
            r0.Q = r3
            int r3 = bf.l.TextInputLayout_boxBackgroundColor
            android.content.res.ColorStateList r3 = qf.c.b(r11, r1, r3)
            if (r3 == 0) goto L_0x01f0
            int r4 = r3.getDefaultColor()
            r0.f20263t0 = r4
            r0.f20233c0 = r4
            boolean r4 = r3.isStateful()
            r5 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r4 == 0) goto L_0x01cc
            int[] r4 = new int[r12]
            r6 = 0
            r4[r6] = r5
            int r4 = r3.getColorForState(r4, r10)
            r0.f20264u0 = r4
            r4 = 2
            int[] r5 = new int[r4]
            r5 = {16842908, 16842910} // fill-array
            int r5 = r3.getColorForState(r5, r10)
            r0.f20265v0 = r5
            int[] r5 = new int[r4]
            r5 = {16843623, 16842910} // fill-array
            int r3 = r3.getColorForState(r5, r10)
            r0.f20267w0 = r3
            goto L_0x01fc
        L_0x01cc:
            r4 = 2
            int r3 = r0.f20263t0
            r0.f20265v0 = r3
            int r3 = bf.c.mtrl_filled_background_color
            android.content.res.ColorStateList r3 = e.a.a(r11, r3)
            int[] r6 = new int[r12]
            r7 = 0
            r6[r7] = r5
            int r5 = r3.getColorForState(r6, r10)
            r0.f20264u0 = r5
            int[] r5 = new int[r12]
            r6 = 16843623(0x1010367, float:2.3696E-38)
            r5[r7] = r6
            int r3 = r3.getColorForState(r5, r10)
            r0.f20267w0 = r3
            goto L_0x01fc
        L_0x01f0:
            r4 = 2
            r7 = 0
            r0.f20233c0 = r7
            r0.f20263t0 = r7
            r0.f20264u0 = r7
            r0.f20265v0 = r7
            r0.f20267w0 = r7
        L_0x01fc:
            int r3 = bf.l.TextInputLayout_android_textColorHint
            boolean r5 = r1.s(r3)
            if (r5 == 0) goto L_0x020c
            android.content.res.ColorStateList r3 = r1.c(r3)
            r0.f20255o0 = r3
            r0.f20254n0 = r3
        L_0x020c:
            int r3 = bf.l.TextInputLayout_boxStrokeColor
            android.content.res.ColorStateList r5 = qf.c.b(r11, r1, r3)
            r6 = 0
            int r3 = r1.b(r3, r6)
            r0.f20260r0 = r3
            int r3 = bf.c.mtrl_textinput_default_box_stroke_color
            int r3 = androidx.core.content.a.getColor(r11, r3)
            r0.f20257p0 = r3
            int r3 = bf.c.mtrl_textinput_disabled_color
            int r3 = androidx.core.content.a.getColor(r11, r3)
            r0.f20269x0 = r3
            int r3 = bf.c.mtrl_textinput_hovered_box_stroke_color
            int r3 = androidx.core.content.a.getColor(r11, r3)
            r0.f20259q0 = r3
            if (r5 == 0) goto L_0x0236
            r0.setBoxStrokeColorStateList(r5)
        L_0x0236:
            int r3 = bf.l.TextInputLayout_boxStrokeErrorColor
            boolean r5 = r1.s(r3)
            if (r5 == 0) goto L_0x0245
            android.content.res.ColorStateList r3 = qf.c.b(r11, r1, r3)
            r0.setBoxStrokeErrorColor(r3)
        L_0x0245:
            int r3 = r1.n(r13, r10)
            if (r3 == r10) goto L_0x0254
            r3 = 0
            int r5 = r1.n(r13, r3)
            r0.setHintTextAppearance(r5)
            goto L_0x0255
        L_0x0254:
            r3 = 0
        L_0x0255:
            r5 = r18
            int r5 = r1.n(r5, r3)
            int r6 = bf.l.TextInputLayout_errorContentDescription
            java.lang.CharSequence r6 = r1.p(r6)
            int r7 = bf.l.TextInputLayout_errorAccessibilityLiveRegion
            int r7 = r1.k(r7, r12)
            int r8 = bf.l.TextInputLayout_errorEnabled
            boolean r8 = r1.a(r8, r3)
            r9 = r17
            int r9 = r1.n(r9, r3)
            int r11 = bf.l.TextInputLayout_helperTextEnabled
            boolean r11 = r1.a(r11, r3)
            int r13 = bf.l.TextInputLayout_helperText
            java.lang.CharSequence r13 = r1.p(r13)
            int r4 = bf.l.TextInputLayout_placeholderTextAppearance
            int r4 = r1.n(r4, r3)
            int r12 = bf.l.TextInputLayout_placeholderText
            java.lang.CharSequence r12 = r1.p(r12)
            int r10 = bf.l.TextInputLayout_counterEnabled
            boolean r10 = r1.a(r10, r3)
            int r3 = bf.l.TextInputLayout_counterMaxLength
            r22 = r13
            r13 = -1
            int r3 = r1.k(r3, r13)
            r0.setCounterMaxLength(r3)
            r3 = 0
            int r13 = r1.n(r15, r3)
            r0.f20266w = r13
            r13 = r19
            int r13 = r1.n(r13, r3)
            r0.f20262t = r13
            int r13 = bf.l.TextInputLayout_boxBackgroundMode
            int r3 = r1.k(r13, r3)
            r0.setBoxBackgroundMode(r3)
            r0.setErrorContentDescription(r6)
            r0.setErrorAccessibilityLiveRegion(r7)
            int r3 = r0.f20262t
            r0.setCounterOverflowTextAppearance(r3)
            r0.setHelperTextTextAppearance(r9)
            r0.setErrorTextAppearance(r5)
            int r3 = r0.f20266w
            r0.setCounterTextAppearance(r3)
            r0.setPlaceholderText(r12)
            r0.setPlaceholderTextAppearance(r4)
            int r3 = bf.l.TextInputLayout_errorTextColor
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x02e0
            android.content.res.ColorStateList r3 = r1.c(r3)
            r0.setErrorTextColor(r3)
        L_0x02e0:
            int r3 = bf.l.TextInputLayout_helperTextTextColor
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x02ef
            android.content.res.ColorStateList r3 = r1.c(r3)
            r0.setHelperTextColor(r3)
        L_0x02ef:
            int r3 = bf.l.TextInputLayout_hintTextColor
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x02fe
            android.content.res.ColorStateList r3 = r1.c(r3)
            r0.setHintTextColor(r3)
        L_0x02fe:
            int r3 = bf.l.TextInputLayout_counterTextColor
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x030d
            android.content.res.ColorStateList r3 = r1.c(r3)
            r0.setCounterTextColor(r3)
        L_0x030d:
            int r3 = bf.l.TextInputLayout_counterOverflowTextColor
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x031c
            android.content.res.ColorStateList r3 = r1.c(r3)
            r0.setCounterOverflowTextColor(r3)
        L_0x031c:
            int r3 = bf.l.TextInputLayout_placeholderTextColor
            boolean r4 = r1.s(r3)
            if (r4 == 0) goto L_0x032b
            android.content.res.ColorStateList r3 = r1.c(r3)
            r0.setPlaceholderTextColor(r3)
        L_0x032b:
            com.google.android.material.textfield.s r3 = new com.google.android.material.textfield.s
            r3.<init>(r0, r1)
            r0.f20232c = r3
            int r4 = bf.l.TextInputLayout_android_enabled
            r5 = 1
            boolean r4 = r1.a(r4, r5)
            r1.w()
            r1 = 2
            androidx.core.view.n0.D0(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r6 = 26
            if (r1 < r6) goto L_0x0349
            androidx.core.view.n0.E0(r0, r5)
        L_0x0349:
            r14.addView(r2)
            r14.addView(r3)
            r0.addView(r14)
            r0.setEnabled(r4)
            r0.setHelperTextEnabled(r11)
            r0.setErrorEnabled(r8)
            r0.setCounterEnabled(r10)
            r1 = r22
            r0.setHelperText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.f20232c.P(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f20232c.R(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f20232c.b0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f20232c.i0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f20232c.k0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f20230b.q(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f20230b.r(drawable);
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }
}
