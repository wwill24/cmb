package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.p0;
import androidx.core.view.n0;
import bf.d;
import bf.h;
import bf.k;
import bf.l;
import com.google.android.material.internal.j;
import com.google.android.material.internal.p;

public class MaterialAutoCompleteTextView extends c {
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final p0 f20215e;

    /* renamed from: f  reason: collision with root package name */
    private final AccessibilityManager f20216f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final Rect f20217g;

    /* renamed from: h  reason: collision with root package name */
    private final int f20218h;

    /* renamed from: j  reason: collision with root package name */
    private final float f20219j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f20220k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f20221l;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            Object obj;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            if (i10 < 0) {
                obj = materialAutoCompleteTextView.f20215e.v();
            } else {
                obj = materialAutoCompleteTextView.getAdapter().getItem(i10);
            }
            MaterialAutoCompleteTextView.this.j(obj);
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = MaterialAutoCompleteTextView.this.f20215e.y();
                    i10 = MaterialAutoCompleteTextView.this.f20215e.x();
                    j10 = MaterialAutoCompleteTextView.this.f20215e.w();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f20215e.p(), view, i10, j10);
            }
            MaterialAutoCompleteTextView.this.f20215e.dismiss();
        }
    }

    private class b<T> extends ArrayAdapter<String> {

        /* renamed from: a  reason: collision with root package name */
        private ColorStateList f20223a;

        /* renamed from: b  reason: collision with root package name */
        private ColorStateList f20224b;

        b(@NonNull Context context, int i10, @NonNull String[] strArr) {
            super(context, i10, strArr);
            f();
        }

        private ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {16843623, -16842919};
            int[] iArr2 = {16842913, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{hf.a.h(MaterialAutoCompleteTextView.this.f20220k, MaterialAutoCompleteTextView.this.f20221l.getColorForState(iArr2, 0)), hf.a.h(MaterialAutoCompleteTextView.this.f20220k, MaterialAutoCompleteTextView.this.f20221l.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.f20220k});
        }

        private Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.f20220k);
            if (this.f20224b == null) {
                return colorDrawable;
            }
            androidx.core.graphics.drawable.a.o(colorDrawable, this.f20223a);
            return new RippleDrawable(this.f20224b, colorDrawable, (Drawable) null);
        }

        private boolean c() {
            return MaterialAutoCompleteTextView.this.f20220k != 0;
        }

        private boolean d() {
            return MaterialAutoCompleteTextView.this.f20221l != null;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {16842919};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.f20221l.getColorForState(iArr, 0), 0});
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f20224b = e();
            this.f20223a = a();
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            Drawable drawable;
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                if (MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText())) {
                    drawable = b();
                } else {
                    drawable = null;
                }
                n0.w0(textView, drawable);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.autoCompleteTextViewStyle);
    }

    private TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean g() {
        AccessibilityManager accessibilityManager = this.f20216f;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    private int h() {
        ListAdapter adapter = getAdapter();
        TextInputLayout f10 = f();
        int i10 = 0;
        if (adapter == null || f10 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f20215e.x()) + 15);
        View view = null;
        int i11 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(max, view, f10);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        Drawable h10 = this.f20215e.h();
        if (h10 != null) {
            h10.getPadding(this.f20217g);
            Rect rect = this.f20217g;
            i11 += rect.left + rect.right;
        }
        return i11 + f10.getEndIconView().getMeasuredWidth();
    }

    private void i() {
        TextInputLayout f10 = f();
        if (f10 != null) {
            f10.o0();
        }
    }

    /* access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void j(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    public void dismissDropDown() {
        if (g()) {
            this.f20215e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public CharSequence getHint() {
        TextInputLayout f10 = f();
        if (f10 == null || !f10.P()) {
            return super.getHint();
        }
        return f10.getHint();
    }

    public float getPopupElevation() {
        return this.f20219j;
    }

    public int getSimpleItemSelectedColor() {
        return this.f20220k;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f20221l;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout f10 = f();
        if (f10 != null && f10.P() && super.getHint() == null && j.c()) {
            setHint("");
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20215e.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), h()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    public void onWindowFocusChanged(boolean z10) {
        if (!g()) {
            super.onWindowFocusChanged(z10);
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f20215e.n(getAdapter());
    }

    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        p0 p0Var = this.f20215e;
        if (p0Var != null) {
            p0Var.c(drawable);
        }
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f20215e.M(getOnItemSelectedListener());
    }

    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        i();
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f20220k = i10;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f20221l = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    public void showDropDown() {
        if (g()) {
            this.f20215e.a();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(wf.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f20217g = new Rect();
        Context context2 = getContext();
        TypedArray i11 = p.i(context2, attributeSet, l.MaterialAutoCompleteTextView, i10, k.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i12 = l.MaterialAutoCompleteTextView_android_inputType;
        if (i11.hasValue(i12) && i11.getInt(i12, 0) == 0) {
            setKeyListener((KeyListener) null);
        }
        this.f20218h = i11.getResourceId(l.MaterialAutoCompleteTextView_simpleItemLayout, h.mtrl_auto_complete_simple_item);
        this.f20219j = (float) i11.getDimensionPixelOffset(l.MaterialAutoCompleteTextView_android_popupElevation, d.mtrl_exposed_dropdown_menu_popup_elevation);
        this.f20220k = i11.getColor(l.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.f20221l = qf.c.a(context2, i11, l.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.f20216f = (AccessibilityManager) context2.getSystemService("accessibility");
        p0 p0Var = new p0(context2);
        this.f20215e = p0Var;
        p0Var.J(true);
        p0Var.D(this);
        p0Var.I(2);
        p0Var.n(getAdapter());
        p0Var.L(new a());
        int i13 = l.MaterialAutoCompleteTextView_simpleItems;
        if (i11.hasValue(i13)) {
            setSimpleItems(i11.getResourceId(i13, 0));
        }
        i11.recycle();
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new b(getContext(), this.f20218h, strArr));
    }
}
