package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

public abstract class a extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int[] f4195a = new int[32];

    /* renamed from: b  reason: collision with root package name */
    protected int f4196b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f4197c;

    /* renamed from: d  reason: collision with root package name */
    protected p0.a f4198d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f4199e = false;

    /* renamed from: f  reason: collision with root package name */
    protected String f4200f;

    /* renamed from: g  reason: collision with root package name */
    protected String f4201g;

    /* renamed from: h  reason: collision with root package name */
    private View[] f4202h = null;

    /* renamed from: j  reason: collision with root package name */
    protected HashMap<Integer, String> f4203j = new HashMap<>();

    public a(Context context) {
        super(context);
        this.f4197c = context;
        m((AttributeSet) null);
    }

    private void d(String str) {
        if (str != null && str.length() != 0 && this.f4197c != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int k10 = k(trim);
            if (k10 != 0) {
                this.f4203j.put(Integer.valueOf(k10), trim);
                e(k10);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find id of \"");
            sb2.append(trim);
            sb2.append("\"");
        }
    }

    private void e(int i10) {
        if (i10 != getId()) {
            int i11 = this.f4196b + 1;
            int[] iArr = this.f4195a;
            if (i11 > iArr.length) {
                this.f4195a = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f4195a;
            int i12 = this.f4196b;
            iArr2[i12] = i10;
            this.f4196b = i12 + 1;
        }
    }

    private void f(String str) {
        if (str != null && str.length() != 0 && this.f4197c != null) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            if (constraintLayout != null) {
                int childCount = constraintLayout.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = constraintLayout.getChildAt(i10);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if ((layoutParams instanceof ConstraintLayout.b) && trim.equals(((ConstraintLayout.b) layoutParams).f4141c0)) {
                        if (childAt.getId() == -1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("to use ConstraintTag view ");
                            sb2.append(childAt.getClass().getSimpleName());
                            sb2.append(" must have an ID");
                        } else {
                            e(childAt.getId());
                        }
                    }
                }
            }
        }
    }

    private int j(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f4197c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int k(String str) {
        ConstraintLayout constraintLayout;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        int i10 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object g10 = constraintLayout.g(0, str);
            if (g10 instanceof Integer) {
                i10 = ((Integer) g10).intValue();
            }
        }
        if (i10 == 0 && constraintLayout != null) {
            i10 = j(constraintLayout, str);
        }
        if (i10 == 0) {
            try {
                i10 = g.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        if (i10 == 0) {
            return this.f4197c.getResources().getIdentifier(str, "id", this.f4197c.getPackageName());
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public void g() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            h((ConstraintLayout) parent);
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f4195a, this.f4196b);
    }

    /* access modifiers changed from: protected */
    public void h(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i10 = 0; i10 < this.f4196b; i10++) {
            View l10 = constraintLayout.l(this.f4195a[i10]);
            if (l10 != null) {
                l10.setVisibility(visibility);
                if (elevation > 0.0f) {
                    l10.setTranslationZ(l10.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void i(ConstraintLayout constraintLayout) {
    }

    /* access modifiers changed from: protected */
    public View[] l(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f4202h;
        if (viewArr == null || viewArr.length != this.f4196b) {
            this.f4202h = new View[this.f4196b];
        }
        for (int i10 = 0; i10 < this.f4196b; i10++) {
            this.f4202h[i10] = constraintLayout.l(this.f4195a[i10]);
        }
        return this.f4202h;
    }

    /* access modifiers changed from: protected */
    public void m(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f4200f = string;
                    setIds(string);
                } else if (index == h.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f4201g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void n(ConstraintWidget constraintWidget, boolean z10) {
    }

    public void o(ConstraintLayout constraintLayout) {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f4200f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f4201g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f4199e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintLayout constraintLayout) {
    }

    public void q(ConstraintLayout constraintLayout) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = r5.f4203j.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.f4200f
            r5.setIds(r0)
        L_0x000b:
            p0.a r0 = r5.f4198d
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.b()
            r0 = 0
        L_0x0014:
            int r1 = r5.f4196b
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.f4195a
            r1 = r1[r0]
            android.view.View r2 = r6.l(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<java.lang.Integer, java.lang.String> r3 = r5.f4203j
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.j(r6, r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.f4195a
            r2[r0] = r3
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.f4203j
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.l(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            p0.a r1 = r5.f4198d
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r6.p(r2)
            r1.a(r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            p0.a r0 = r5.f4198d
            androidx.constraintlayout.core.widgets.d r6 = r6.f4117c
            r0.c(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.a.r(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    public void s() {
        if (this.f4198d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ConstraintLayout.b) layoutParams).f4179v0 = (ConstraintWidget) this.f4198d;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setIds(String str) {
        this.f4200f = str;
        if (str != null) {
            int i10 = 0;
            this.f4196b = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    d(str.substring(i10));
                    return;
                } else {
                    d(str.substring(i10, indexOf));
                    i10 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setReferenceTags(String str) {
        this.f4201g = str;
        if (str != null) {
            int i10 = 0;
            this.f4196b = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    f(str.substring(i10));
                    return;
                } else {
                    f(str.substring(i10, indexOf));
                    i10 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f4200f = null;
        this.f4196b = 0;
        for (int e10 : iArr) {
            e(e10);
        }
    }

    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f4200f == null) {
            e(i10);
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4197c = context;
        m(attributeSet);
    }
}
