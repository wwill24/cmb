package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.mparticle.identity.IdentityHttpResponse;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import q5.d;
import q5.p;
import qj.q;

public class CmbRadioGroup<T> extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<T> f11484a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishSubject<T> f11485b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11486c;

    /* renamed from: d  reason: collision with root package name */
    private int f11487d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11488e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11489f;

    /* renamed from: g  reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f11490g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CmbRadioGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CmbRadioGroup(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void c() {
        int childCount = getChildCount();
        if (childCount >= 0) {
            int i10 = 0;
            while (true) {
                View childAt = getChildAt(i10);
                if (childAt instanceof CompoundButton) {
                    CompoundButton compoundButton = (CompoundButton) childAt;
                    if (!compoundButton.isChecked()) {
                        compoundButton.setEnabled(false);
                    }
                }
                if (i10 != childCount) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    private final void d() {
        int childCount = getChildCount();
        if (childCount >= 0) {
            int i10 = 0;
            while (true) {
                View childAt = getChildAt(i10);
                if (childAt instanceof CompoundButton) {
                    ((CompoundButton) childAt).setEnabled(true);
                }
                if (i10 != childCount) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void e(CmbRadioGroup cmbRadioGroup, CompoundButton compoundButton, boolean z10) {
        j.g(cmbRadioGroup, "this$0");
        if (!cmbRadioGroup.f11489f) {
            if (!cmbRadioGroup.f11488e || z10 || !cmbRadioGroup.getCheckedTags().isEmpty()) {
                cmbRadioGroup.f11489f = true;
                int i10 = cmbRadioGroup.f11487d;
                if (i10 < 0) {
                    cmbRadioGroup.f(z10, compoundButton.getTag());
                } else if (i10 == 1) {
                    j.f(compoundButton, "checkBox");
                    cmbRadioGroup.j(compoundButton);
                    cmbRadioGroup.f(z10, compoundButton.getTag());
                } else {
                    int size = cmbRadioGroup.getCheckedTags().size();
                    int i11 = cmbRadioGroup.f11487d;
                    if (size < i11) {
                        cmbRadioGroup.d();
                        cmbRadioGroup.f(z10, compoundButton.getTag());
                    } else if (size == i11) {
                        cmbRadioGroup.c();
                        cmbRadioGroup.f(z10, compoundButton.getTag());
                    } else if (size > i11) {
                        compoundButton.setChecked(false);
                    }
                }
                cmbRadioGroup.f11489f = false;
                return;
            }
            cmbRadioGroup.f11489f = true;
            compoundButton.setChecked(true);
            cmbRadioGroup.f11489f = false;
        }
    }

    private final void f(boolean z10, T t10) {
        this.f11486c = true;
        if (z10) {
            this.f11484a.d(t10);
        } else {
            this.f11485b.d(t10);
        }
    }

    private final void j(CompoundButton compoundButton) {
        int childCount = getChildCount();
        if (childCount >= 0) {
            int i10 = 0;
            while (true) {
                View childAt = getChildAt(i10);
                if (childAt instanceof CompoundButton) {
                    CompoundButton compoundButton2 = (CompoundButton) childAt;
                    if (!j.b(compoundButton.getTag(), compoundButton2.getTag())) {
                        compoundButton2.setChecked(false);
                    }
                }
                if (i10 != childCount) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    private final void setChangedListenerOnValidCheckBox(View view) {
        if (view instanceof CheckBox) {
            ((CheckBox) view).setOnCheckedChangeListener(this.f11490g);
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        setChangedListenerOnValidCheckBox(view);
    }

    public final void b(CheckBox checkBox, T t10) {
        j.g(checkBox, "box");
        checkBox.setTag(t10);
        addView(checkBox);
    }

    public final q<T> g() {
        q<T> Y = q.Y(this.f11484a, this.f11485b);
        j.f(Y, "merge(checkedSubject, uncheckedSubject)");
        return Y;
    }

    public final List<T> getCheckedTags() {
        ArrayList arrayList = new ArrayList(getChildCount());
        int childCount = getChildCount();
        if (childCount >= 0) {
            int i10 = 0;
            while (true) {
                View childAt = getChildAt(i10);
                if (childAt instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) childAt;
                    if (checkBox.isChecked() && checkBox.getTag() != null) {
                        arrayList.add(checkBox.getTag());
                    }
                }
                if (i10 == childCount) {
                    break;
                }
                i10++;
            }
        }
        return arrayList;
    }

    public final int getMaxOptions() {
        return this.f11487d;
    }

    public final boolean getMustSelectOne() {
        return this.f11488e;
    }

    public final boolean getWasChanged() {
        return this.f11486c;
    }

    public final q<T> h() {
        q<T> P = this.f11484a.P();
        j.f(P, "checkedSubject.hide()");
        return P;
    }

    public final q<T> i() {
        q<T> P = this.f11484a.P();
        j.f(P, "checkedSubject.hide()");
        return P;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount >= 0) {
            int i10 = 0;
            while (true) {
                setChangedListenerOnValidCheckBox(getChildAt(i10));
                if (i10 != childCount) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public final void setMaxOptions(int i10) {
        this.f11487d = i10;
    }

    public final void setMustSelectOne(boolean z10) {
        this.f11488e = z10;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CmbRadioGroup(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        PublishSubject<T> C0 = PublishSubject.C0();
        j.f(C0, "create<T>()");
        this.f11484a = C0;
        PublishSubject<T> C02 = PublishSubject.C0();
        j.f(C02, "create<T>()");
        this.f11485b = C02;
        this.f11487d = Integer.MIN_VALUE;
        this.f11490g = new d(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.CmbRadioGroup, 0, 0);
        j.f(obtainStyledAttributes, "context.obtainStyledAttr…able.CmbRadioGroup, 0, 0)");
        try {
            this.f11487d = obtainStyledAttributes.getInt(p.CmbRadioGroup_maxOptions, this.f11487d);
            this.f11488e = obtainStyledAttributes.getBoolean(p.CmbRadioGroup_mustSelectOne, this.f11488e);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
