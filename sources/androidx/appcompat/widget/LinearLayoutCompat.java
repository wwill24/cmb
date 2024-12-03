package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import d.j;

public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1053a;

    /* renamed from: b  reason: collision with root package name */
    private int f1054b;

    /* renamed from: c  reason: collision with root package name */
    private int f1055c;

    /* renamed from: d  reason: collision with root package name */
    private int f1056d;

    /* renamed from: e  reason: collision with root package name */
    private int f1057e;

    /* renamed from: f  reason: collision with root package name */
    private int f1058f;

    /* renamed from: g  reason: collision with root package name */
    private float f1059g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1060h;

    /* renamed from: j  reason: collision with root package name */
    private int[] f1061j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f1062k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f1063l;

    /* renamed from: m  reason: collision with root package name */
    private int f1064m;

    /* renamed from: n  reason: collision with root package name */
    private int f1065n;

    /* renamed from: p  reason: collision with root package name */
    private int f1066p;

    /* renamed from: q  reason: collision with root package name */
    private int f1067q;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i10, int i11) {
            super(i10, i11);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void i(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View q10 = q(i12);
            if (q10.getVisibility() != 8) {
                a aVar = (a) q10.getLayoutParams();
                if (aVar.height == -1) {
                    int i13 = aVar.width;
                    aVar.width = q10.getMeasuredWidth();
                    measureChildWithMargins(q10, i11, 0, makeMeasureSpec, 0);
                    aVar.width = i13;
                }
            }
        }
    }

    private void j(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View q10 = q(i12);
            if (q10.getVisibility() != 8) {
                a aVar = (a) q10.getLayoutParams();
                if (aVar.width == -1) {
                    int i13 = aVar.height;
                    aVar.height = q10.getMeasuredHeight();
                    measureChildWithMargins(q10, makeMeasureSpec, 0, i11, 0);
                    aVar.height = i13;
                }
            }
        }
    }

    private void y(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* access modifiers changed from: package-private */
    public void e(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int i13;
        int virtualChildCount = getVirtualChildCount();
        boolean b10 = t1.b(this);
        for (int i14 = 0; i14 < virtualChildCount; i14++) {
            View q10 = q(i14);
            if (!(q10 == null || q10.getVisibility() == 8 || !r(i14))) {
                a aVar = (a) q10.getLayoutParams();
                if (b10) {
                    i13 = q10.getRight() + aVar.rightMargin;
                } else {
                    i13 = (q10.getLeft() - aVar.leftMargin) - this.f1064m;
                }
                h(canvas, i13);
            }
        }
        if (r(virtualChildCount)) {
            View q11 = q(virtualChildCount - 1);
            if (q11 != null) {
                a aVar2 = (a) q11.getLayoutParams();
                if (b10) {
                    i12 = q11.getLeft() - aVar2.leftMargin;
                    i11 = this.f1064m;
                } else {
                    i10 = q11.getRight() + aVar2.rightMargin;
                    h(canvas, i10);
                }
            } else if (b10) {
                i10 = getPaddingLeft();
                h(canvas, i10);
            } else {
                i12 = getWidth() - getPaddingRight();
                i11 = this.f1064m;
            }
            i10 = i12 - i11;
            h(canvas, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Canvas canvas) {
        int i10;
        int virtualChildCount = getVirtualChildCount();
        for (int i11 = 0; i11 < virtualChildCount; i11++) {
            View q10 = q(i11);
            if (!(q10 == null || q10.getVisibility() == 8 || !r(i11))) {
                g(canvas, (q10.getTop() - ((a) q10.getLayoutParams()).topMargin) - this.f1065n);
            }
        }
        if (r(virtualChildCount)) {
            View q11 = q(virtualChildCount - 1);
            if (q11 == null) {
                i10 = (getHeight() - getPaddingBottom()) - this.f1065n;
            } else {
                i10 = q11.getBottom() + ((a) q11.getLayoutParams()).bottomMargin;
            }
            g(canvas, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas, int i10) {
        this.f1063l.setBounds(getPaddingLeft() + this.f1067q, i10, (getWidth() - getPaddingRight()) - this.f1067q, this.f1065n + i10);
        this.f1063l.draw(canvas);
    }

    public int getBaseline() {
        int i10;
        if (this.f1054b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f1054b;
        if (childCount > i11) {
            View childAt = getChildAt(i11);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i12 = this.f1055c;
                if (this.f1056d == 1 && (i10 = this.f1057e & 112) != 48) {
                    if (i10 == 16) {
                        i12 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1058f) / 2;
                    } else if (i10 == 80) {
                        i12 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1058f;
                    }
                }
                return i12 + ((a) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.f1054b == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1054b;
    }

    public Drawable getDividerDrawable() {
        return this.f1063l;
    }

    public int getDividerPadding() {
        return this.f1067q;
    }

    public int getDividerWidth() {
        return this.f1064m;
    }

    public int getGravity() {
        return this.f1057e;
    }

    public int getOrientation() {
        return this.f1056d;
    }

    public int getShowDividers() {
        return this.f1066p;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1059g;
    }

    /* access modifiers changed from: package-private */
    public void h(Canvas canvas, int i10) {
        this.f1063l.setBounds(i10, getPaddingTop() + this.f1067q, this.f1064m + i10, (getHeight() - getPaddingBottom()) - this.f1067q);
        this.f1063l.draw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public a generateDefaultLayoutParams() {
        int i10 = this.f1056d;
        if (i10 == 0) {
            return new a(-2, -2);
        }
        if (i10 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* renamed from: l */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int n(View view, int i10) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int o(View view) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f1063l != null) {
            if (this.f1056d == 1) {
                f(canvas);
            } else {
                e(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f1056d == 1) {
            t(i10, i11, i12, i13);
        } else {
            s(i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f1056d == 1) {
            x(i10, i11);
        } else {
            v(i10, i11);
        }
    }

    /* access modifiers changed from: package-private */
    public int p(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View q(int i10) {
        return getChildAt(i10);
    }

    /* access modifiers changed from: protected */
    public boolean r(int i10) {
        if (i10 == 0) {
            if ((this.f1066p & 1) != 0) {
                return true;
            }
            return false;
        } else if (i10 == getChildCount()) {
            if ((this.f1066p & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.f1066p & 2) == 0) {
            return false;
        } else {
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                if (getChildAt(i11).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(int r25, int r26, int r27, int r28) {
        /*
            r24 = this;
            r6 = r24
            boolean r0 = androidx.appcompat.widget.t1.b(r24)
            int r7 = r24.getPaddingTop()
            int r1 = r28 - r26
            int r2 = r24.getPaddingBottom()
            int r8 = r1 - r2
            int r1 = r1 - r7
            int r2 = r24.getPaddingBottom()
            int r9 = r1 - r2
            int r10 = r24.getVirtualChildCount()
            int r1 = r6.f1057e
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r1
            r11 = r1 & 112(0x70, float:1.57E-43)
            boolean r12 = r6.f1053a
            int[] r13 = r6.f1061j
            int[] r14 = r6.f1062k
            int r1 = androidx.core.view.n0.B(r24)
            int r1 = androidx.core.view.e.b(r2, r1)
            r15 = 2
            r5 = 1
            if (r1 == r5) goto L_0x004b
            r2 = 5
            if (r1 == r2) goto L_0x003f
            int r1 = r24.getPaddingLeft()
            goto L_0x0056
        L_0x003f:
            int r1 = r24.getPaddingLeft()
            int r1 = r1 + r27
            int r1 = r1 - r25
            int r2 = r6.f1058f
            int r1 = r1 - r2
            goto L_0x0056
        L_0x004b:
            int r1 = r24.getPaddingLeft()
            int r2 = r27 - r25
            int r3 = r6.f1058f
            int r2 = r2 - r3
            int r2 = r2 / r15
            int r1 = r1 + r2
        L_0x0056:
            r2 = 0
            if (r0 == 0) goto L_0x0060
            int r0 = r10 + -1
            r16 = r0
            r17 = -1
            goto L_0x0064
        L_0x0060:
            r16 = r2
            r17 = r5
        L_0x0064:
            r3 = r2
        L_0x0065:
            if (r3 >= r10) goto L_0x0149
            int r0 = r17 * r3
            int r2 = r16 + r0
            android.view.View r0 = r6.q(r2)
            if (r0 != 0) goto L_0x0080
            int r0 = r6.w(r2)
            int r1 = r1 + r0
            r21 = r5
            r22 = r7
            r19 = r10
            r20 = r11
            goto L_0x013a
        L_0x0080:
            int r5 = r0.getVisibility()
            r15 = 8
            if (r5 == r15) goto L_0x0130
            int r15 = r0.getMeasuredWidth()
            int r5 = r0.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r18 = r0.getLayoutParams()
            r4 = r18
            androidx.appcompat.widget.LinearLayoutCompat$a r4 = (androidx.appcompat.widget.LinearLayoutCompat.a) r4
            r18 = r3
            if (r12 == 0) goto L_0x00a8
            int r3 = r4.height
            r19 = r10
            r10 = -1
            if (r3 == r10) goto L_0x00aa
            int r10 = r0.getBaseline()
            goto L_0x00ab
        L_0x00a8:
            r19 = r10
        L_0x00aa:
            r10 = -1
        L_0x00ab:
            int r3 = r4.gravity
            if (r3 >= 0) goto L_0x00b0
            r3 = r11
        L_0x00b0:
            r3 = r3 & 112(0x70, float:1.57E-43)
            r20 = r11
            r11 = 16
            if (r3 == r11) goto L_0x00eb
            r11 = 48
            if (r3 == r11) goto L_0x00d9
            r11 = 80
            if (r3 == r11) goto L_0x00c3
            r3 = r7
            r11 = -1
            goto L_0x00e8
        L_0x00c3:
            int r3 = r8 - r5
            int r11 = r4.bottomMargin
            int r3 = r3 - r11
            r11 = -1
            if (r10 == r11) goto L_0x00e8
            int r21 = r0.getMeasuredHeight()
            int r21 = r21 - r10
            r10 = 2
            r22 = r14[r10]
            int r22 = r22 - r21
            int r3 = r3 - r22
            goto L_0x00e8
        L_0x00d9:
            r11 = -1
            int r3 = r4.topMargin
            int r3 = r3 + r7
            if (r10 == r11) goto L_0x00e8
            r21 = 1
            r22 = r13[r21]
            int r22 = r22 - r10
            int r3 = r3 + r22
            goto L_0x00f9
        L_0x00e8:
            r21 = 1
            goto L_0x00f9
        L_0x00eb:
            r11 = -1
            r21 = 1
            int r3 = r9 - r5
            r10 = 2
            int r3 = r3 / r10
            int r3 = r3 + r7
            int r10 = r4.topMargin
            int r3 = r3 + r10
            int r10 = r4.bottomMargin
            int r3 = r3 - r10
        L_0x00f9:
            boolean r10 = r6.r(r2)
            if (r10 == 0) goto L_0x0102
            int r10 = r6.f1064m
            int r1 = r1 + r10
        L_0x0102:
            int r10 = r4.leftMargin
            int r10 = r10 + r1
            int r1 = r6.o(r0)
            int r22 = r10 + r1
            r25 = r0
            r0 = r24
            r1 = r25
            r11 = r2
            r2 = r22
            r22 = r7
            r23 = -1
            r7 = r4
            r4 = r15
            r0.y(r1, r2, r3, r4, r5)
            int r0 = r7.rightMargin
            int r15 = r15 + r0
            r0 = r25
            int r1 = r6.p(r0)
            int r15 = r15 + r1
            int r10 = r10 + r15
            int r0 = r6.n(r0, r11)
            int r3 = r18 + r0
            r1 = r10
            goto L_0x013c
        L_0x0130:
            r18 = r3
            r22 = r7
            r19 = r10
            r20 = r11
            r21 = 1
        L_0x013a:
            r23 = -1
        L_0x013c:
            int r3 = r3 + 1
            r10 = r19
            r11 = r20
            r5 = r21
            r7 = r22
            r15 = 2
            goto L_0x0065
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.s(int, int, int, int):void");
    }

    public void setBaselineAligned(boolean z10) {
        this.f1053a = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 < 0 || i10 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1054b = i10;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f1063l) {
            this.f1063l = drawable;
            boolean z10 = false;
            if (drawable != null) {
                this.f1064m = drawable.getIntrinsicWidth();
                this.f1065n = drawable.getIntrinsicHeight();
            } else {
                this.f1064m = 0;
                this.f1065n = 0;
            }
            if (drawable == null) {
                z10 = true;
            }
            setWillNotDraw(z10);
            requestLayout();
        }
    }

    public void setDividerPadding(int i10) {
        this.f1067q = i10;
    }

    public void setGravity(int i10) {
        if (this.f1057e != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f1057e = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.f1057e;
        if ((8388615 & i12) != i11) {
            this.f1057e = i11 | (-8388616 & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f1060h = z10;
    }

    public void setOrientation(int i10) {
        if (this.f1056d != i10) {
            this.f1056d = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.f1066p) {
            requestLayout();
        }
        this.f1066p = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f1057e;
        if ((i12 & 112) != i11) {
            this.f1057e = i11 | (i12 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f1059g = Math.max(0.0f, f10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f1057e
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L_0x003b
            r0 = 80
            if (r1 == r0) goto L_0x002f
            int r0 = r17.getPaddingTop()
            goto L_0x0047
        L_0x002f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f1058f
            int r0 = r0 - r1
            goto L_0x0047
        L_0x003b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f1058f
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L_0x0047:
            r1 = 0
            r12 = r1
        L_0x0049:
            if (r12 >= r10) goto L_0x00cb
            android.view.View r13 = r6.q(r12)
            r14 = 1
            if (r13 != 0) goto L_0x0059
            int r1 = r6.w(r12)
            int r0 = r0 + r1
            goto L_0x00c7
        L_0x0059:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L_0x00c7
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$a r5 = (androidx.appcompat.widget.LinearLayoutCompat.a) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L_0x0075
            r1 = r11
        L_0x0075:
            int r2 = androidx.core.view.n0.B(r17)
            int r1 = androidx.core.view.e.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L_0x008d
            r2 = 5
            if (r1 == r2) goto L_0x0088
            int r1 = r5.leftMargin
            int r1 = r1 + r7
            goto L_0x0098
        L_0x0088:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
            goto L_0x0097
        L_0x008d:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
        L_0x0097:
            int r1 = r1 - r2
        L_0x0098:
            r2 = r1
            boolean r1 = r6.r(r12)
            if (r1 == 0) goto L_0x00a2
            int r1 = r6.f1065n
            int r0 = r0 + r1
        L_0x00a2:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.o(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.y(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.p(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.n(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            r1 = 1
            goto L_0x00c8
        L_0x00c7:
            r1 = r14
        L_0x00c8:
            int r12 = r12 + r1
            goto L_0x0049
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.t(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void u(View view, int i10, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0452  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v(int r39, int r40) {
        /*
            r38 = this;
            r7 = r38
            r8 = r39
            r9 = r40
            r10 = 0
            r7.f1058f = r10
            int r11 = r38.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r39)
            int r13 = android.view.View.MeasureSpec.getMode(r40)
            int[] r0 = r7.f1061j
            r14 = 4
            if (r0 == 0) goto L_0x001e
            int[] r0 = r7.f1062k
            if (r0 != 0) goto L_0x0026
        L_0x001e:
            int[] r0 = new int[r14]
            r7.f1061j = r0
            int[] r0 = new int[r14]
            r7.f1062k = r0
        L_0x0026:
            int[] r15 = r7.f1061j
            int[] r6 = r7.f1062k
            r16 = 3
            r5 = -1
            r15[r16] = r5
            r17 = 2
            r15[r17] = r5
            r18 = 1
            r15[r18] = r5
            r15[r10] = r5
            r6[r16] = r5
            r6[r17] = r5
            r6[r18] = r5
            r6[r10] = r5
            boolean r4 = r7.f1053a
            boolean r3 = r7.f1060h
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 != r2) goto L_0x004c
            r19 = r18
            goto L_0x004e
        L_0x004c:
            r19 = r10
        L_0x004e:
            r20 = 0
            r1 = r10
            r14 = r1
            r21 = r14
            r22 = r21
            r23 = r22
            r24 = r23
            r25 = r24
            r27 = r25
            r26 = r18
            r0 = r20
        L_0x0062:
            r28 = r6
            r5 = 8
            if (r1 >= r11) goto L_0x0203
            android.view.View r6 = r7.q(r1)
            if (r6 != 0) goto L_0x0082
            int r5 = r7.f1058f
            int r6 = r7.w(r1)
            int r5 = r5 + r6
            r7.f1058f = r5
        L_0x0077:
            r32 = r3
            r36 = r4
            r37 = r2
            r2 = r1
            r1 = r37
            goto L_0x01f0
        L_0x0082:
            int r10 = r6.getVisibility()
            if (r10 != r5) goto L_0x008e
            int r5 = r7.n(r6, r1)
            int r1 = r1 + r5
            goto L_0x0077
        L_0x008e:
            boolean r5 = r7.r(r1)
            if (r5 == 0) goto L_0x009b
            int r5 = r7.f1058f
            int r10 = r7.f1064m
            int r5 = r5 + r10
            r7.f1058f = r5
        L_0x009b:
            android.view.ViewGroup$LayoutParams r5 = r6.getLayoutParams()
            r10 = r5
            androidx.appcompat.widget.LinearLayoutCompat$a r10 = (androidx.appcompat.widget.LinearLayoutCompat.a) r10
            float r5 = r10.weight
            float r31 = r0 + r5
            if (r12 != r2) goto L_0x00ef
            int r0 = r10.width
            if (r0 != 0) goto L_0x00ef
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ef
            if (r19 == 0) goto L_0x00bd
            int r0 = r7.f1058f
            int r5 = r10.leftMargin
            int r2 = r10.rightMargin
            int r5 = r5 + r2
            int r0 = r0 + r5
            r7.f1058f = r0
            goto L_0x00cb
        L_0x00bd:
            int r0 = r7.f1058f
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r5 = r10.rightMargin
            int r2 = r2 + r5
            int r0 = java.lang.Math.max(r0, r2)
            r7.f1058f = r0
        L_0x00cb:
            if (r4 == 0) goto L_0x00e0
            r0 = 0
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r6.measure(r2, r2)
            r34 = r1
            r32 = r3
            r36 = r4
            r3 = r6
            r30 = -2
            goto L_0x0169
        L_0x00e0:
            r34 = r1
            r32 = r3
            r36 = r4
            r3 = r6
            r24 = r18
            r1 = 1073741824(0x40000000, float:2.0)
            r30 = -2
            goto L_0x016b
        L_0x00ef:
            int r0 = r10.width
            if (r0 != 0) goto L_0x00fc
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00fc
            r5 = -2
            r10.width = r5
            r2 = 0
            goto L_0x00ff
        L_0x00fc:
            r5 = -2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00ff:
            int r0 = (r31 > r20 ? 1 : (r31 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x0108
            int r0 = r7.f1058f
            r29 = r0
            goto L_0x010a
        L_0x0108:
            r29 = 0
        L_0x010a:
            r33 = 0
            r0 = r38
            r34 = r1
            r1 = r6
            r35 = r2
            r2 = r34
            r32 = r3
            r3 = r39
            r36 = r4
            r4 = r29
            r29 = r5
            r9 = -1
            r5 = r40
            r30 = r29
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r29 = r6
            r6 = r33
            r0.u(r1, r2, r3, r4, r5, r6)
            r0 = r35
            if (r0 == r9) goto L_0x0133
            r10.width = r0
        L_0x0133:
            int r0 = r29.getMeasuredWidth()
            if (r19 == 0) goto L_0x014c
            int r1 = r7.f1058f
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r3 = r10.rightMargin
            int r2 = r2 + r3
            r3 = r29
            int r4 = r7.p(r3)
            int r2 = r2 + r4
            int r1 = r1 + r2
            r7.f1058f = r1
            goto L_0x0163
        L_0x014c:
            r3 = r29
            int r1 = r7.f1058f
            int r2 = r1 + r0
            int r4 = r10.leftMargin
            int r2 = r2 + r4
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r7.p(r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
            r7.f1058f = r1
        L_0x0163:
            if (r32 == 0) goto L_0x0169
            int r14 = java.lang.Math.max(r0, r14)
        L_0x0169:
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x016b:
            if (r13 == r1) goto L_0x0177
            int r0 = r10.height
            r2 = -1
            if (r0 != r2) goto L_0x0177
            r0 = r18
            r27 = r0
            goto L_0x0178
        L_0x0177:
            r0 = 0
        L_0x0178:
            int r2 = r10.topMargin
            int r4 = r10.bottomMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredHeight()
            int r4 = r4 + r2
            int r5 = r3.getMeasuredState()
            r6 = r25
            int r25 = android.view.View.combineMeasuredStates(r6, r5)
            if (r36 == 0) goto L_0x01b5
            int r5 = r3.getBaseline()
            r6 = -1
            if (r5 == r6) goto L_0x01b5
            int r6 = r10.gravity
            if (r6 >= 0) goto L_0x019b
            int r6 = r7.f1057e
        L_0x019b:
            r6 = r6 & 112(0x70, float:1.57E-43)
            r9 = 4
            int r6 = r6 >> r9
            r6 = r6 & -2
            int r6 = r6 >> 1
            r9 = r15[r6]
            int r9 = java.lang.Math.max(r9, r5)
            r15[r6] = r9
            r9 = r28[r6]
            int r5 = r4 - r5
            int r5 = java.lang.Math.max(r9, r5)
            r28[r6] = r5
        L_0x01b5:
            r5 = r21
            int r21 = java.lang.Math.max(r5, r4)
            if (r26 == 0) goto L_0x01c5
            int r5 = r10.height
            r6 = -1
            if (r5 != r6) goto L_0x01c5
            r26 = r18
            goto L_0x01c7
        L_0x01c5:
            r26 = 0
        L_0x01c7:
            float r5 = r10.weight
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x01d8
            if (r0 == 0) goto L_0x01d0
            goto L_0x01d1
        L_0x01d0:
            r2 = r4
        L_0x01d1:
            r10 = r23
            int r23 = java.lang.Math.max(r10, r2)
            goto L_0x01e6
        L_0x01d8:
            r10 = r23
            if (r0 == 0) goto L_0x01dd
            goto L_0x01de
        L_0x01dd:
            r2 = r4
        L_0x01de:
            r4 = r22
            int r22 = java.lang.Math.max(r4, r2)
            r23 = r10
        L_0x01e6:
            r10 = r34
            int r0 = r7.n(r3, r10)
            int r0 = r0 + r10
            r2 = r0
            r0 = r31
        L_0x01f0:
            int r2 = r2 + 1
            r9 = r40
            r6 = r28
            r3 = r32
            r4 = r36
            r5 = -1
            r10 = 0
            r37 = r2
            r2 = r1
            r1 = r37
            goto L_0x0062
        L_0x0203:
            r1 = r2
            r32 = r3
            r36 = r4
            r2 = r21
            r4 = r22
            r10 = r23
            r6 = r25
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r30 = -2
            int r3 = r7.f1058f
            if (r3 <= 0) goto L_0x0225
            boolean r3 = r7.r(r11)
            if (r3 == 0) goto L_0x0225
            int r3 = r7.f1058f
            int r1 = r7.f1064m
            int r3 = r3 + r1
            r7.f1058f = r3
        L_0x0225:
            r1 = r15[r18]
            r3 = -1
            if (r1 != r3) goto L_0x023d
            r21 = 0
            r5 = r15[r21]
            if (r5 != r3) goto L_0x023d
            r5 = r15[r17]
            if (r5 != r3) goto L_0x023d
            r5 = r15[r16]
            if (r5 == r3) goto L_0x0239
            goto L_0x023d
        L_0x0239:
            r1 = r2
            r23 = r6
            goto L_0x026c
        L_0x023d:
            r3 = r15[r16]
            r5 = 0
            r9 = r15[r5]
            r5 = r15[r17]
            int r1 = java.lang.Math.max(r1, r5)
            int r1 = java.lang.Math.max(r9, r1)
            int r1 = java.lang.Math.max(r3, r1)
            r3 = r28[r16]
            r5 = 0
            r9 = r28[r5]
            r5 = r28[r18]
            r23 = r6
            r6 = r28[r17]
            int r5 = java.lang.Math.max(r5, r6)
            int r5 = java.lang.Math.max(r9, r5)
            int r3 = java.lang.Math.max(r3, r5)
            int r1 = r1 + r3
            int r1 = java.lang.Math.max(r2, r1)
        L_0x026c:
            if (r32 == 0) goto L_0x02cf
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r2) goto L_0x0274
            if (r12 != 0) goto L_0x02cf
        L_0x0274:
            r2 = 0
            r7.f1058f = r2
            r2 = 0
        L_0x0278:
            if (r2 >= r11) goto L_0x02cf
            android.view.View r3 = r7.q(r2)
            if (r3 != 0) goto L_0x028a
            int r3 = r7.f1058f
            int r5 = r7.w(r2)
            int r3 = r3 + r5
            r7.f1058f = r3
            goto L_0x0297
        L_0x028a:
            int r5 = r3.getVisibility()
            r6 = 8
            if (r5 != r6) goto L_0x029a
            int r3 = r7.n(r3, r2)
            int r2 = r2 + r3
        L_0x0297:
            r21 = r1
            goto L_0x02ca
        L_0x029a:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r5 = (androidx.appcompat.widget.LinearLayoutCompat.a) r5
            if (r19 == 0) goto L_0x02b3
            int r6 = r7.f1058f
            int r9 = r5.leftMargin
            int r9 = r9 + r14
            int r5 = r5.rightMargin
            int r9 = r9 + r5
            int r3 = r7.p(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            r7.f1058f = r6
            goto L_0x0297
        L_0x02b3:
            int r6 = r7.f1058f
            int r9 = r6 + r14
            r21 = r1
            int r1 = r5.leftMargin
            int r9 = r9 + r1
            int r1 = r5.rightMargin
            int r9 = r9 + r1
            int r1 = r7.p(r3)
            int r9 = r9 + r1
            int r1 = java.lang.Math.max(r6, r9)
            r7.f1058f = r1
        L_0x02ca:
            int r2 = r2 + 1
            r1 = r21
            goto L_0x0278
        L_0x02cf:
            r21 = r1
            int r1 = r7.f1058f
            int r2 = r38.getPaddingLeft()
            int r3 = r38.getPaddingRight()
            int r2 = r2 + r3
            int r1 = r1 + r2
            r7.f1058f = r1
            int r2 = r38.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r2)
            r2 = 0
            int r1 = android.view.View.resolveSizeAndState(r1, r8, r2)
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r3 = r7.f1058f
            int r2 = r2 - r3
            if (r24 != 0) goto L_0x0340
            if (r2 == 0) goto L_0x02fc
            int r5 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x02fc
            goto L_0x0340
        L_0x02fc:
            int r0 = java.lang.Math.max(r4, r10)
            if (r32 == 0) goto L_0x0338
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x0338
            r10 = 0
        L_0x0307:
            if (r10 >= r11) goto L_0x0338
            android.view.View r2 = r7.q(r10)
            if (r2 == 0) goto L_0x0335
            int r4 = r2.getVisibility()
            r5 = 8
            if (r4 != r5) goto L_0x0318
            goto L_0x0335
        L_0x0318:
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r4 = (androidx.appcompat.widget.LinearLayoutCompat.a) r4
            float r4 = r4.weight
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x0335
            r4 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r4)
            int r6 = r2.getMeasuredHeight()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r2.measure(r5, r6)
        L_0x0335:
            int r10 = r10 + 1
            goto L_0x0307
        L_0x0338:
            r2 = r40
            r25 = r11
            r3 = r21
            goto L_0x04d9
        L_0x0340:
            float r5 = r7.f1059g
            int r6 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r6 <= 0) goto L_0x0347
            r0 = r5
        L_0x0347:
            r5 = -1
            r15[r16] = r5
            r15[r17] = r5
            r15[r18] = r5
            r6 = 0
            r15[r6] = r5
            r28[r16] = r5
            r28[r17] = r5
            r28[r18] = r5
            r28[r6] = r5
            r7.f1058f = r6
            r6 = r4
            r4 = r5
            r9 = r23
            r10 = 0
        L_0x0360:
            if (r10 >= r11) goto L_0x0482
            android.view.View r14 = r7.q(r10)
            if (r14 == 0) goto L_0x0473
            int r5 = r14.getVisibility()
            r3 = 8
            if (r5 != r3) goto L_0x0372
            goto L_0x0473
        L_0x0372:
            android.view.ViewGroup$LayoutParams r5 = r14.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r5 = (androidx.appcompat.widget.LinearLayoutCompat.a) r5
            float r3 = r5.weight
            int r23 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r23 <= 0) goto L_0x03da
            float r8 = (float) r2
            float r8 = r8 * r3
            float r8 = r8 / r0
            int r8 = (int) r8
            float r0 = r0 - r3
            int r2 = r2 - r8
            int r3 = r38.getPaddingTop()
            int r23 = r38.getPaddingBottom()
            int r3 = r3 + r23
            r23 = r0
            int r0 = r5.topMargin
            int r3 = r3 + r0
            int r0 = r5.bottomMargin
            int r3 = r3 + r0
            int r0 = r5.height
            r24 = r2
            r25 = r11
            r11 = -1
            r2 = r40
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r0)
            int r3 = r5.width
            if (r3 != 0) goto L_0x03b8
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x03ac
            goto L_0x03ba
        L_0x03ac:
            if (r8 <= 0) goto L_0x03af
            goto L_0x03b0
        L_0x03af:
            r8 = 0
        L_0x03b0:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r3)
            r14.measure(r8, r0)
            goto L_0x03ca
        L_0x03b8:
            r3 = 1073741824(0x40000000, float:2.0)
        L_0x03ba:
            int r29 = r14.getMeasuredWidth()
            int r8 = r29 + r8
            if (r8 >= 0) goto L_0x03c3
            r8 = 0
        L_0x03c3:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r3)
            r14.measure(r8, r0)
        L_0x03ca:
            int r0 = r14.getMeasuredState()
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r3
            int r9 = android.view.View.combineMeasuredStates(r9, r0)
            r0 = r23
            r3 = r24
            goto L_0x03e0
        L_0x03da:
            r3 = r2
            r25 = r11
            r11 = -1
            r2 = r40
        L_0x03e0:
            if (r19 == 0) goto L_0x03fd
            int r8 = r7.f1058f
            int r23 = r14.getMeasuredWidth()
            int r11 = r5.leftMargin
            int r23 = r23 + r11
            int r11 = r5.rightMargin
            int r23 = r23 + r11
            int r11 = r7.p(r14)
            int r23 = r23 + r11
            int r8 = r8 + r23
            r7.f1058f = r8
            r23 = r0
            goto L_0x0417
        L_0x03fd:
            int r8 = r7.f1058f
            int r11 = r14.getMeasuredWidth()
            int r11 = r11 + r8
            r23 = r0
            int r0 = r5.leftMargin
            int r11 = r11 + r0
            int r0 = r5.rightMargin
            int r11 = r11 + r0
            int r0 = r7.p(r14)
            int r11 = r11 + r0
            int r0 = java.lang.Math.max(r8, r11)
            r7.f1058f = r0
        L_0x0417:
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 == r0) goto L_0x0423
            int r0 = r5.height
            r8 = -1
            if (r0 != r8) goto L_0x0423
            r0 = r18
            goto L_0x0424
        L_0x0423:
            r0 = 0
        L_0x0424:
            int r8 = r5.topMargin
            int r11 = r5.bottomMargin
            int r8 = r8 + r11
            int r11 = r14.getMeasuredHeight()
            int r11 = r11 + r8
            int r4 = java.lang.Math.max(r4, r11)
            if (r0 == 0) goto L_0x0435
            goto L_0x0436
        L_0x0435:
            r8 = r11
        L_0x0436:
            int r0 = java.lang.Math.max(r6, r8)
            if (r26 == 0) goto L_0x0444
            int r6 = r5.height
            r8 = -1
            if (r6 != r8) goto L_0x0445
            r6 = r18
            goto L_0x0446
        L_0x0444:
            r8 = -1
        L_0x0445:
            r6 = 0
        L_0x0446:
            if (r36 == 0) goto L_0x046d
            int r14 = r14.getBaseline()
            if (r14 == r8) goto L_0x046d
            int r5 = r5.gravity
            if (r5 >= 0) goto L_0x0454
            int r5 = r7.f1057e
        L_0x0454:
            r5 = r5 & 112(0x70, float:1.57E-43)
            r8 = 4
            int r5 = r5 >> r8
            r5 = r5 & -2
            int r5 = r5 >> 1
            r8 = r15[r5]
            int r8 = java.lang.Math.max(r8, r14)
            r15[r5] = r8
            r8 = r28[r5]
            int r11 = r11 - r14
            int r8 = java.lang.Math.max(r8, r11)
            r28[r5] = r8
        L_0x046d:
            r26 = r6
            r6 = r0
            r0 = r23
            goto L_0x0478
        L_0x0473:
            r3 = r2
            r25 = r11
            r2 = r40
        L_0x0478:
            int r10 = r10 + 1
            r8 = r39
            r2 = r3
            r11 = r25
            r5 = -1
            goto L_0x0360
        L_0x0482:
            r2 = r40
            r25 = r11
            int r0 = r7.f1058f
            int r3 = r38.getPaddingLeft()
            int r5 = r38.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            r7.f1058f = r0
            r0 = r15[r18]
            r3 = -1
            if (r0 != r3) goto L_0x04a9
            r5 = 0
            r8 = r15[r5]
            if (r8 != r3) goto L_0x04a9
            r5 = r15[r17]
            if (r5 != r3) goto L_0x04a9
            r5 = r15[r16]
            if (r5 == r3) goto L_0x04a7
            goto L_0x04a9
        L_0x04a7:
            r0 = r4
            goto L_0x04d5
        L_0x04a9:
            r3 = r15[r16]
            r5 = 0
            r8 = r15[r5]
            r10 = r15[r17]
            int r0 = java.lang.Math.max(r0, r10)
            int r0 = java.lang.Math.max(r8, r0)
            int r0 = java.lang.Math.max(r3, r0)
            r3 = r28[r16]
            r5 = r28[r5]
            r8 = r28[r18]
            r10 = r28[r17]
            int r8 = java.lang.Math.max(r8, r10)
            int r5 = java.lang.Math.max(r5, r8)
            int r3 = java.lang.Math.max(r3, r5)
            int r0 = r0 + r3
            int r0 = java.lang.Math.max(r4, r0)
        L_0x04d5:
            r3 = r0
            r0 = r6
            r23 = r9
        L_0x04d9:
            if (r26 != 0) goto L_0x04e0
            r4 = 1073741824(0x40000000, float:2.0)
            if (r13 == r4) goto L_0x04e0
            goto L_0x04e1
        L_0x04e0:
            r0 = r3
        L_0x04e1:
            int r3 = r38.getPaddingTop()
            int r4 = r38.getPaddingBottom()
            int r3 = r3 + r4
            int r0 = r0 + r3
            int r3 = r38.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r3)
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = r23 & r3
            r1 = r1 | r3
            int r3 = r23 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r2, r3)
            r7.setMeasuredDimension(r1, r0)
            if (r27 == 0) goto L_0x050a
            r0 = r39
            r1 = r25
            r7.i(r1, r0)
        L_0x050a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.v(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int w(int i10) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0333  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x(int r34, int r35) {
        /*
            r33 = this;
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = 0
            r7.f1058f = r10
            int r11 = r33.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r34)
            int r13 = android.view.View.MeasureSpec.getMode(r35)
            int r14 = r7.f1054b
            boolean r15 = r7.f1060h
            r16 = 0
            r17 = 1
            r1 = r10
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r18 = r6
            r20 = r18
            r0 = r16
            r19 = r17
        L_0x002b:
            r10 = 8
            r22 = r4
            if (r6 >= r11) goto L_0x0199
            android.view.View r4 = r7.q(r6)
            if (r4 != 0) goto L_0x0048
            int r4 = r7.f1058f
            int r10 = r7.w(r6)
            int r4 = r4 + r10
            r7.f1058f = r4
            r26 = r11
            r24 = r13
            r4 = r22
            goto L_0x018d
        L_0x0048:
            r24 = r1
            int r1 = r4.getVisibility()
            if (r1 != r10) goto L_0x005f
            int r1 = r7.n(r4, r6)
            int r6 = r6 + r1
            r26 = r11
            r4 = r22
            r1 = r24
            r24 = r13
            goto L_0x018d
        L_0x005f:
            boolean r1 = r7.r(r6)
            if (r1 == 0) goto L_0x006c
            int r1 = r7.f1058f
            int r10 = r7.f1065n
            int r1 = r1 + r10
            r7.f1058f = r1
        L_0x006c:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            r10 = r1
            androidx.appcompat.widget.LinearLayoutCompat$a r10 = (androidx.appcompat.widget.LinearLayoutCompat.a) r10
            float r1 = r10.weight
            float r25 = r0 + r1
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 != r0) goto L_0x00a6
            int r0 = r10.height
            if (r0 != 0) goto L_0x00a6
            int r0 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a6
            int r0 = r7.f1058f
            int r1 = r10.topMargin
            int r1 = r1 + r0
            r26 = r2
            int r2 = r10.bottomMargin
            int r1 = r1 + r2
            int r0 = java.lang.Math.max(r0, r1)
            r7.f1058f = r0
            r0 = r3
            r3 = r4
            r31 = r5
            r18 = r17
            r8 = r24
            r29 = r26
            r26 = r11
            r24 = r13
            r13 = r22
            r11 = r6
            goto L_0x0114
        L_0x00a6:
            r26 = r2
            int r0 = r10.height
            if (r0 != 0) goto L_0x00b5
            int r0 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b5
            r0 = -2
            r10.height = r0
            r2 = 0
            goto L_0x00b7
        L_0x00b5:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00b7:
            r27 = 0
            int r0 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x00c2
            int r0 = r7.f1058f
            r23 = r0
            goto L_0x00c4
        L_0x00c2:
            r23 = 0
        L_0x00c4:
            r28 = 1073741824(0x40000000, float:2.0)
            r0 = r33
            r8 = r24
            r1 = r4
            r30 = r2
            r29 = r26
            r2 = r6
            r9 = r3
            r3 = r34
            r26 = r11
            r24 = r13
            r13 = r22
            r11 = r28
            r22 = r4
            r4 = r27
            r31 = r5
            r5 = r35
            r11 = r6
            r6 = r23
            r0.u(r1, r2, r3, r4, r5, r6)
            r0 = r30
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x00f1
            r10.height = r0
        L_0x00f1:
            int r0 = r22.getMeasuredHeight()
            int r1 = r7.f1058f
            int r2 = r1 + r0
            int r3 = r10.topMargin
            int r2 = r2 + r3
            int r3 = r10.bottomMargin
            int r2 = r2 + r3
            r3 = r22
            int r4 = r7.p(r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
            r7.f1058f = r1
            if (r15 == 0) goto L_0x0113
            int r0 = java.lang.Math.max(r0, r9)
            goto L_0x0114
        L_0x0113:
            r0 = r9
        L_0x0114:
            if (r14 < 0) goto L_0x011e
            int r6 = r11 + 1
            if (r14 != r6) goto L_0x011e
            int r1 = r7.f1058f
            r7.f1055c = r1
        L_0x011e:
            if (r11 >= r14) goto L_0x012f
            float r1 = r10.weight
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 > 0) goto L_0x0127
            goto L_0x012f
        L_0x0127:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x012f:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r12 == r1) goto L_0x013d
            int r1 = r10.width
            r2 = -1
            if (r1 != r2) goto L_0x013d
            r1 = r17
            r20 = r1
            goto L_0x013e
        L_0x013d:
            r1 = 0
        L_0x013e:
            int r2 = r10.leftMargin
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredWidth()
            int r4 = r4 + r2
            r5 = r29
            int r5 = java.lang.Math.max(r5, r4)
            int r6 = r3.getMeasuredState()
            int r6 = android.view.View.combineMeasuredStates(r8, r6)
            if (r19 == 0) goto L_0x0160
            int r8 = r10.width
            r9 = -1
            if (r8 != r9) goto L_0x0160
            r19 = r17
            goto L_0x0162
        L_0x0160:
            r19 = 0
        L_0x0162:
            float r8 = r10.weight
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0173
            if (r1 == 0) goto L_0x016b
            goto L_0x016c
        L_0x016b:
            r2 = r4
        L_0x016c:
            int r4 = java.lang.Math.max(r13, r2)
            r1 = r31
            goto L_0x017e
        L_0x0173:
            if (r1 == 0) goto L_0x0176
            goto L_0x0177
        L_0x0176:
            r2 = r4
        L_0x0177:
            r1 = r31
            int r1 = java.lang.Math.max(r1, r2)
            r4 = r13
        L_0x017e:
            int r2 = r7.n(r3, r11)
            int r2 = r2 + r11
            r3 = r0
            r0 = r25
            r32 = r5
            r5 = r1
            r1 = r6
            r6 = r2
            r2 = r32
        L_0x018d:
            int r6 = r6 + 1
            r8 = r34
            r9 = r35
            r13 = r24
            r11 = r26
            goto L_0x002b
        L_0x0199:
            r8 = r1
            r9 = r3
            r1 = r5
            r26 = r11
            r24 = r13
            r13 = r22
            r5 = r2
            int r2 = r7.f1058f
            if (r2 <= 0) goto L_0x01b7
            r2 = r26
            boolean r3 = r7.r(r2)
            if (r3 == 0) goto L_0x01b9
            int r3 = r7.f1058f
            int r4 = r7.f1065n
            int r3 = r3 + r4
            r7.f1058f = r3
            goto L_0x01b9
        L_0x01b7:
            r2 = r26
        L_0x01b9:
            r3 = r24
            if (r15 == 0) goto L_0x0208
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x01c3
            if (r3 != 0) goto L_0x0208
        L_0x01c3:
            r4 = 0
            r7.f1058f = r4
            r4 = 0
        L_0x01c7:
            if (r4 >= r2) goto L_0x0208
            android.view.View r6 = r7.q(r4)
            if (r6 != 0) goto L_0x01d9
            int r6 = r7.f1058f
            int r11 = r7.w(r4)
            int r6 = r6 + r11
            r7.f1058f = r6
            goto L_0x0203
        L_0x01d9:
            int r11 = r6.getVisibility()
            if (r11 != r10) goto L_0x01e5
            int r6 = r7.n(r6, r4)
            int r4 = r4 + r6
            goto L_0x0203
        L_0x01e5:
            android.view.ViewGroup$LayoutParams r11 = r6.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r11 = (androidx.appcompat.widget.LinearLayoutCompat.a) r11
            int r14 = r7.f1058f
            int r21 = r14 + r9
            int r10 = r11.topMargin
            int r21 = r21 + r10
            int r10 = r11.bottomMargin
            int r21 = r21 + r10
            int r6 = r7.p(r6)
            int r6 = r21 + r6
            int r6 = java.lang.Math.max(r14, r6)
            r7.f1058f = r6
        L_0x0203:
            int r4 = r4 + 1
            r10 = 8
            goto L_0x01c7
        L_0x0208:
            int r4 = r7.f1058f
            int r6 = r33.getPaddingTop()
            int r10 = r33.getPaddingBottom()
            int r6 = r6 + r10
            int r4 = r4 + r6
            r7.f1058f = r4
            int r6 = r33.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r6)
            r6 = r35
            r10 = r9
            r9 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r6, r9)
            r9 = 16777215(0xffffff, float:2.3509886E-38)
            r9 = r9 & r4
            int r11 = r7.f1058f
            int r9 = r9 - r11
            if (r18 != 0) goto L_0x0277
            if (r9 == 0) goto L_0x0236
            int r11 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r11 <= 0) goto L_0x0236
            goto L_0x0277
        L_0x0236:
            int r0 = java.lang.Math.max(r1, r13)
            if (r15 == 0) goto L_0x0272
            r1 = 1073741824(0x40000000, float:2.0)
            if (r3 == r1) goto L_0x0272
            r1 = 0
        L_0x0241:
            if (r1 >= r2) goto L_0x0272
            android.view.View r3 = r7.q(r1)
            if (r3 == 0) goto L_0x026f
            int r9 = r3.getVisibility()
            r11 = 8
            if (r9 != r11) goto L_0x0252
            goto L_0x026f
        L_0x0252:
            android.view.ViewGroup$LayoutParams r9 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r9 = (androidx.appcompat.widget.LinearLayoutCompat.a) r9
            float r9 = r9.weight
            int r9 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r9 <= 0) goto L_0x026f
            int r9 = r3.getMeasuredWidth()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r11)
            r3.measure(r9, r13)
        L_0x026f:
            int r1 = r1 + 1
            goto L_0x0241
        L_0x0272:
            r11 = r34
            r1 = r8
            goto L_0x036b
        L_0x0277:
            float r10 = r7.f1059g
            int r11 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r11 <= 0) goto L_0x027e
            r0 = r10
        L_0x027e:
            r10 = 0
            r7.f1058f = r10
            r11 = r9
            r9 = r1
            r1 = r8
            r8 = r10
        L_0x0285:
            if (r8 >= r2) goto L_0x035a
            android.view.View r13 = r7.q(r8)
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x0299
            r21 = r11
            r11 = r34
            goto L_0x0353
        L_0x0299:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r14 = (androidx.appcompat.widget.LinearLayoutCompat.a) r14
            float r10 = r14.weight
            int r18 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x02fb
            float r15 = (float) r11
            float r15 = r15 * r10
            float r15 = r15 / r0
            int r15 = (int) r15
            float r0 = r0 - r10
            int r11 = r11 - r15
            int r10 = r33.getPaddingLeft()
            int r18 = r33.getPaddingRight()
            int r10 = r10 + r18
            r18 = r0
            int r0 = r14.leftMargin
            int r10 = r10 + r0
            int r0 = r14.rightMargin
            int r10 = r10 + r0
            int r0 = r14.width
            r21 = r11
            r11 = r34
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r11, r10, r0)
            int r10 = r14.height
            if (r10 != 0) goto L_0x02dc
            r10 = 1073741824(0x40000000, float:2.0)
            if (r3 == r10) goto L_0x02d0
            goto L_0x02de
        L_0x02d0:
            if (r15 <= 0) goto L_0x02d3
            goto L_0x02d4
        L_0x02d3:
            r15 = 0
        L_0x02d4:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
            r13.measure(r0, r15)
            goto L_0x02ee
        L_0x02dc:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x02de:
            int r23 = r13.getMeasuredHeight()
            int r15 = r23 + r15
            if (r15 >= 0) goto L_0x02e7
            r15 = 0
        L_0x02e7:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
            r13.measure(r0, r15)
        L_0x02ee:
            int r0 = r13.getMeasuredState()
            r0 = r0 & -256(0xffffffffffffff00, float:NaN)
            int r1 = android.view.View.combineMeasuredStates(r1, r0)
            r0 = r18
            goto L_0x0300
        L_0x02fb:
            r10 = r11
            r11 = r34
            r21 = r10
        L_0x0300:
            int r10 = r14.leftMargin
            int r15 = r14.rightMargin
            int r10 = r10 + r15
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r10
            int r5 = java.lang.Math.max(r5, r15)
            r18 = r0
            r0 = 1073741824(0x40000000, float:2.0)
            if (r12 == r0) goto L_0x031e
            int r0 = r14.width
            r23 = r1
            r1 = -1
            if (r0 != r1) goto L_0x0321
            r0 = r17
            goto L_0x0322
        L_0x031e:
            r23 = r1
            r1 = -1
        L_0x0321:
            r0 = 0
        L_0x0322:
            if (r0 == 0) goto L_0x0325
            goto L_0x0326
        L_0x0325:
            r10 = r15
        L_0x0326:
            int r0 = java.lang.Math.max(r9, r10)
            if (r19 == 0) goto L_0x0333
            int r9 = r14.width
            if (r9 != r1) goto L_0x0333
            r9 = r17
            goto L_0x0334
        L_0x0333:
            r9 = 0
        L_0x0334:
            int r10 = r7.f1058f
            int r15 = r13.getMeasuredHeight()
            int r15 = r15 + r10
            int r1 = r14.topMargin
            int r15 = r15 + r1
            int r1 = r14.bottomMargin
            int r15 = r15 + r1
            int r1 = r7.p(r13)
            int r15 = r15 + r1
            int r1 = java.lang.Math.max(r10, r15)
            r7.f1058f = r1
            r19 = r9
            r1 = r23
            r9 = r0
            r0 = r18
        L_0x0353:
            int r8 = r8 + 1
            r11 = r21
            r10 = 0
            goto L_0x0285
        L_0x035a:
            r11 = r34
            int r0 = r7.f1058f
            int r3 = r33.getPaddingTop()
            int r8 = r33.getPaddingBottom()
            int r3 = r3 + r8
            int r0 = r0 + r3
            r7.f1058f = r0
            r0 = r9
        L_0x036b:
            if (r19 != 0) goto L_0x0372
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x0372
            goto L_0x0373
        L_0x0372:
            r0 = r5
        L_0x0373:
            int r3 = r33.getPaddingLeft()
            int r5 = r33.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            int r3 = r33.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r0, r3)
            int r0 = android.view.View.resolveSizeAndState(r0, r11, r1)
            r7.setMeasuredDimension(r0, r4)
            if (r20 == 0) goto L_0x0391
            r7.j(r2, r6)
        L_0x0391:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.x(int, int):void");
    }

    public LinearLayoutCompat(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1053a = true;
        this.f1054b = -1;
        this.f1055c = 0;
        this.f1057e = 8388659;
        int[] iArr = j.LinearLayoutCompat;
        h1 v10 = h1.v(context, attributeSet, iArr, i10, 0);
        n0.q0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        int k10 = v10.k(j.LinearLayoutCompat_android_orientation, -1);
        if (k10 >= 0) {
            setOrientation(k10);
        }
        int k11 = v10.k(j.LinearLayoutCompat_android_gravity, -1);
        if (k11 >= 0) {
            setGravity(k11);
        }
        boolean a10 = v10.a(j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a10) {
            setBaselineAligned(a10);
        }
        this.f1059g = v10.i(j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1054b = v10.k(j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1060h = v10.a(j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(v10.g(j.LinearLayoutCompat_divider));
        this.f1066p = v10.k(j.LinearLayoutCompat_showDividers, 0);
        this.f1067q = v10.f(j.LinearLayoutCompat_dividerPadding, 0);
        v10.w();
    }
}
