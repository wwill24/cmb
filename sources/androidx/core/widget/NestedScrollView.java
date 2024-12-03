package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.ScrollingView;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.m;
import androidx.core.view.c0;
import androidx.core.view.d0;
import androidx.core.view.f0;
import androidx.core.view.g0;
import androidx.core.view.n0;
import com.google.android.gms.common.api.a;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.util.ArrayList;
import net.bytebuddy.jar.asm.Opcodes;

public class NestedScrollView extends FrameLayout implements f0, c0, ScrollingView {
    private static final float I = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final a J = new a();
    private static final int[] K = {16843130};
    private int B;
    private int C;
    private SavedState D;
    private final g0 E;
    private final d0 F;
    private float G;
    private c H;

    /* renamed from: a  reason: collision with root package name */
    private final float f4904a;

    /* renamed from: b  reason: collision with root package name */
    private long f4905b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f4906c;

    /* renamed from: d  reason: collision with root package name */
    private OverScroller f4907d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public EdgeEffect f4908e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public EdgeEffect f4909f;

    /* renamed from: g  reason: collision with root package name */
    private int f4910g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4911h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4912j;

    /* renamed from: k  reason: collision with root package name */
    private View f4913k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4914l;

    /* renamed from: m  reason: collision with root package name */
    private VelocityTracker f4915m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f4916n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4917p;

    /* renamed from: q  reason: collision with root package name */
    private int f4918q;

    /* renamed from: t  reason: collision with root package name */
    private int f4919t;

    /* renamed from: w  reason: collision with root package name */
    private int f4920w;

    /* renamed from: x  reason: collision with root package name */
    private int f4921x;

    /* renamed from: y  reason: collision with root package name */
    private final int[] f4922y;

    /* renamed from: z  reason: collision with root package name */
    private final int[] f4923z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f4924a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f4924a + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f4924a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f4924a = parcel.readInt();
        }
    }

    static class a extends androidx.core.view.a {
        a() {
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            boolean z10;
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            m.a(accessibilityEvent, nestedScrollView.getScrollX());
            m.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void g(View view, k kVar) {
            int scrollRange;
            super.g(view, kVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            kVar.a0(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                kVar.u0(true);
                if (nestedScrollView.getScrollY() > 0) {
                    kVar.b(k.a.f4772r);
                    kVar.b(k.a.C);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    kVar.b(k.a.f4771q);
                    kVar.b(k.a.E);
                }
            }
        }

        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i10 != 4096) {
                if (i10 == 8192 || i10 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.T(0, max, true);
                    return true;
                } else if (i10 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.T(0, min, true);
            return true;
        }
    }

    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public interface c {
        void a(@NonNull NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13);
    }

    public NestedScrollView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.a.nestedScrollViewStyle);
    }

    private void A() {
        this.f4907d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(Opcodes.ASM4);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f4918q = viewConfiguration.getScaledTouchSlop();
        this.f4919t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4920w = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void B() {
        if (this.f4915m == null) {
            this.f4915m = VelocityTracker.obtain();
        }
    }

    private boolean C(View view) {
        return !E(view, 0, getHeight());
    }

    private static boolean D(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !D((View) parent, view2)) {
            return false;
        }
        return true;
    }

    private boolean E(View view, int i10, int i11) {
        view.getDrawingRect(this.f4906c);
        offsetDescendantRectToMyCoords(view, this.f4906c);
        if (this.f4906c.bottom + i10 < getScrollY() || this.f4906c.top - i10 > getScrollY() + i11) {
            return false;
        }
        return true;
    }

    private void F(int i10, int i11, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.F.e(0, scrollY2, 0, i10 - scrollY2, (int[]) null, i11, iArr);
    }

    private void G(MotionEvent motionEvent) {
        int i10;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4921x) {
            if (actionIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.f4910g = (int) motionEvent.getY(i10);
            this.f4921x = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f4915m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void J() {
        VelocityTracker velocityTracker = this.f4915m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4915m = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int K(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f4908e
            float r0 = androidx.core.widget.e.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            android.widget.EdgeEffect r0 = r3.f4908e
            float r4 = -r4
            float r4 = androidx.core.widget.e.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f4908e
            float r5 = androidx.core.widget.e.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.f4908e
            r5.onRelease()
        L_0x002f:
            r1 = r4
            goto L_0x0054
        L_0x0031:
            android.widget.EdgeEffect r0 = r3.f4909f
            float r0 = androidx.core.widget.e.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0054
            android.widget.EdgeEffect r0 = r3.f4909f
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.e.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f4909f
            float r5 = androidx.core.widget.e.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.f4909f
            r5.onRelease()
            goto L_0x002f
        L_0x0054:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L_0x0063
            r3.invalidate()
        L_0x0063:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.K(int, float):int");
    }

    private void L(boolean z10) {
        if (z10) {
            U(2, 1);
        } else {
            W(1);
        }
        this.C = getScrollY();
        n0.j0(this);
    }

    private boolean M(int i10, int i11, int i12) {
        boolean z10;
        int i13;
        int height = getHeight();
        int scrollY = getScrollY();
        int i14 = height + scrollY;
        boolean z11 = false;
        if (i10 == 33) {
            z10 = true;
        } else {
            z10 = false;
        }
        View t10 = t(z10, i11, i12);
        if (t10 == null) {
            t10 = this;
        }
        if (i11 < scrollY || i12 > i14) {
            if (z10) {
                i13 = i11 - scrollY;
            } else {
                i13 = i12 - i14;
            }
            p(i13);
            z11 = true;
        }
        if (t10 != findFocus()) {
            t10.requestFocus(i10);
        }
        return z11;
    }

    private void N(View view) {
        view.getDrawingRect(this.f4906c);
        offsetDescendantRectToMyCoords(view, this.f4906c);
        int f10 = f(this.f4906c);
        if (f10 != 0) {
            scrollBy(0, f10);
        }
    }

    private boolean O(Rect rect, boolean z10) {
        boolean z11;
        int f10 = f(rect);
        if (f10 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (z10) {
                scrollBy(0, f10);
            } else {
                Q(0, f10);
            }
        }
        return z11;
    }

    private boolean P(@NonNull EdgeEffect edgeEffect, int i10) {
        if (i10 > 0) {
            return true;
        }
        if (w(-i10) < e.b(edgeEffect) * ((float) getHeight())) {
            return true;
        }
        return false;
    }

    private void R(int i10, int i11, int i12, boolean z10) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f4905b > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f4907d;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i12);
                L(z10);
            } else {
                if (!this.f4907d.isFinished()) {
                    a();
                }
                scrollBy(i10, i11);
            }
            this.f4905b = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private boolean V(MotionEvent motionEvent) {
        boolean z10;
        if (e.b(this.f4908e) != 0.0f) {
            e.d(this.f4908e, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z10 = true;
        } else {
            z10 = false;
        }
        if (e.b(this.f4909f) == 0.0f) {
            return z10;
        }
        e.d(this.f4909f, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void a() {
        this.f4907d.abortAnimation();
        W(1);
    }

    private boolean c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0) {
            return true;
        }
        if (overScrollMode != 1 || getScrollRange() <= 0) {
            return false;
        }
        return true;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return true;
        }
        return false;
    }

    private static int e(int i10, int i11, int i12) {
        if (i11 >= i12 || i10 < 0) {
            return 0;
        }
        return i11 + i10 > i12 ? i12 - i11 : i10;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.G == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.G = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.G;
    }

    private void p(int i10) {
        if (i10 == 0) {
            return;
        }
        if (this.f4917p) {
            Q(0, i10);
        } else {
            scrollBy(0, i10);
        }
    }

    private boolean q(int i10) {
        if (e.b(this.f4908e) != 0.0f) {
            if (P(this.f4908e, i10)) {
                this.f4908e.onAbsorb(i10);
            } else {
                u(-i10);
            }
        } else if (e.b(this.f4909f) == 0.0f) {
            return false;
        } else {
            int i11 = -i10;
            if (P(this.f4909f, i11)) {
                this.f4909f.onAbsorb(i11);
            } else {
                u(i11);
            }
        }
        return true;
    }

    private void r() {
        this.f4914l = false;
        J();
        W(0);
        this.f4908e.onRelease();
        this.f4909f.onRelease();
    }

    private View t(boolean z10, int i10, int i11) {
        boolean z11;
        boolean z12;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z13 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view2 = focusables.get(i12);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                if (i10 >= top || bottom >= i11) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (view == null) {
                    view = view2;
                    z13 = z11;
                } else {
                    if ((!z10 || top >= view.getTop()) && (z10 || bottom <= view.getBottom())) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z13) {
                        if (z11) {
                            if (!z12) {
                            }
                        }
                    } else if (z11) {
                        view = view2;
                        z13 = true;
                    } else if (!z12) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private float w(int i10) {
        double log = Math.log((double) ((((float) Math.abs(i10)) * 0.35f) / (this.f4904a * 0.015f)));
        float f10 = I;
        return (float) (((double) (this.f4904a * 0.015f)) * Math.exp((((double) f10) / (((double) f10) - 1.0d)) * log));
    }

    private boolean y(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i11 < childAt.getTop() - scrollY || i11 >= childAt.getBottom() - scrollY || i10 < childAt.getLeft() || i10 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void z() {
        VelocityTracker velocityTracker = this.f4915m;
        if (velocityTracker == null) {
            this.f4915m = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean H(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i18;
        int i19;
        boolean z15;
        boolean z16;
        int overScrollMode = getOverScrollMode();
        if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (overScrollMode == 0 || (overScrollMode == 1 && z11)) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (overScrollMode == 0 || (overScrollMode == 1 && z12)) {
            z14 = true;
        } else {
            z14 = false;
        }
        int i20 = i12 + i10;
        if (!z13) {
            i18 = 0;
        } else {
            i18 = i16;
        }
        int i21 = i13 + i11;
        if (!z14) {
            i19 = 0;
        } else {
            i19 = i17;
        }
        int i22 = -i18;
        int i23 = i18 + i14;
        int i24 = -i19;
        int i25 = i19 + i15;
        if (i20 > i23) {
            i20 = i23;
            z15 = true;
        } else if (i20 < i22) {
            z15 = true;
            i20 = i22;
        } else {
            z15 = false;
        }
        if (i21 > i25) {
            i21 = i25;
            z16 = true;
        } else if (i21 < i24) {
            z16 = true;
            i21 = i24;
        } else {
            z16 = false;
        }
        if (z16 && !x(1)) {
            this.f4907d.springBack(i20, i21, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i20, i21, z15, z16);
        if (z15 || z16) {
            return true;
        }
        return false;
    }

    public boolean I(int i10) {
        boolean z10;
        if (i10 == 130) {
            z10 = true;
        } else {
            z10 = false;
        }
        int height = getHeight();
        if (z10) {
            this.f4906c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f4906c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f4906c.top = getScrollY() - height;
            Rect rect2 = this.f4906c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f4906c;
        int i11 = rect3.top;
        int i12 = height + i11;
        rect3.bottom = i12;
        return M(i10, i11, i12);
    }

    public final void Q(int i10, int i11) {
        R(i10, i11, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT, false);
    }

    /* access modifiers changed from: package-private */
    public void S(int i10, int i11, int i12, boolean z10) {
        R(i10 - getScrollX(), i11 - getScrollY(), i12, z10);
    }

    /* access modifiers changed from: package-private */
    public void T(int i10, int i11, boolean z10) {
        S(i10, i11, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT, z10);
    }

    public boolean U(int i10, int i11) {
        return this.F.p(i10, i11);
    }

    public void W(int i10) {
        this.F.r(i10);
    }

    public void addView(@NonNull View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i10) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !E(findNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            p(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f4906c);
            offsetDescendantRectToMyCoords(findNextFocus, this.f4906c);
            p(f(this.f4906c));
            findNextFocus.requestFocus(i10);
        }
        if (findFocus == null || !findFocus.isFocused() || !C(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(Opcodes.ACC_DEPRECATED);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (!this.f4907d.isFinished()) {
            this.f4907d.computeScrollOffset();
            int currY = this.f4907d.getCurrY();
            int g10 = g(currY - this.C);
            this.C = currY;
            int[] iArr = this.f4923z;
            boolean z10 = false;
            iArr[1] = 0;
            h(0, g10, iArr, (int[]) null, 1);
            int i10 = g10 - this.f4923z[1];
            int scrollRange = getScrollRange();
            if (i10 != 0) {
                int scrollY = getScrollY();
                H(0, i10, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i11 = i10 - scrollY2;
                int[] iArr2 = this.f4923z;
                iArr2[1] = 0;
                l(0, scrollY2, 0, i11, this.f4922y, 1, iArr2);
                i10 = i11 - this.f4923z[1];
            }
            if (i10 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z10 = true;
                }
                if (z10) {
                    if (i10 < 0) {
                        if (this.f4908e.isFinished()) {
                            this.f4908e.onAbsorb((int) this.f4907d.getCurrVelocity());
                        }
                    } else if (this.f4909f.isFinished()) {
                        this.f4909f.onAbsorb((int) this.f4907d.getCurrVelocity());
                    }
                }
                a();
            }
            if (!this.f4907d.isFinished()) {
                n0.j0(this);
            } else {
                W(1);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || s(keyEvent);
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.F.a(f10, f11, z10);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.F.b(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return h(i10, i11, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.F.f(i10, i11, i12, i13, iArr);
    }

    public void draw(@NonNull Canvas canvas) {
        int i10;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i11 = 0;
        if (!this.f4908e.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i10 = getPaddingLeft() + 0;
            } else {
                i10 = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate((float) i10, (float) min);
            this.f4908e.setSize(width, height);
            if (this.f4908e.draw(canvas)) {
                n0.j0(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.f4909f.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (b.a(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i11 = 0 + getPaddingLeft();
            }
            if (b.a(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i11 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, 0.0f);
            this.f4909f.setSize(width2, height2);
            if (this.f4909f.draw(canvas)) {
                n0.j0(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    /* access modifiers changed from: protected */
    public int f(Rect rect) {
        int i10;
        int i11;
        int i12;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i13 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i10 = i13 - verticalFadingEdgeLength;
        } else {
            i10 = i13;
        }
        int i14 = rect.bottom;
        if (i14 > i10 && rect.top > scrollY) {
            if (rect.height() > height) {
                i12 = rect.top - scrollY;
            } else {
                i12 = rect.bottom - i10;
            }
            return Math.min(i12 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i13);
        } else if (rect.top >= scrollY || i14 >= i10) {
            return 0;
        } else {
            if (rect.height() > height) {
                i11 = 0 - (i10 - rect.bottom);
            } else {
                i11 = 0 - (scrollY - rect.top);
            }
            return Math.max(i11, -getScrollY());
        }
    }

    /* access modifiers changed from: package-private */
    public int g(int i10) {
        int height = getHeight();
        if (i10 > 0 && e.b(this.f4908e) != 0.0f) {
            int round = Math.round((((float) (-height)) / 4.0f) * e.d(this.f4908e, (((float) (-i10)) * 4.0f) / ((float) height), 0.5f));
            if (round != i10) {
                this.f4908e.finish();
            }
            return i10 - round;
        } else if (i10 >= 0 || e.b(this.f4909f) == 0.0f) {
            return i10;
        } else {
            float f10 = (float) height;
            int round2 = Math.round((f10 / 4.0f) * e.d(this.f4909f, (((float) i10) * 4.0f) / f10, 0.5f));
            if (round2 != i10) {
                this.f4909f.finish();
            }
            return i10 - round2;
        }
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.E.a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean h(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.F.d(i10, i11, iArr, iArr2, i12);
    }

    public boolean hasNestedScrollingParent() {
        return x(0);
    }

    public void i(@NonNull View view, @NonNull View view2, int i10, int i11) {
        this.E.c(view, view2, i10, i11);
        U(2, i11);
    }

    public boolean isNestedScrollingEnabled() {
        return this.F.l();
    }

    public void j(@NonNull View view, int i10) {
        this.E.d(view, i10);
        W(i10);
    }

    public void k(@NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
        h(i10, i11, iArr, (int[]) null, i12);
    }

    public void l(int i10, int i11, int i12, int i13, int[] iArr, int i14, @NonNull int[] iArr2) {
        this.F.e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public void m(@NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        F(i13, i14, iArr);
    }

    /* access modifiers changed from: protected */
    public void measureChild(@NonNull View view, int i10, int i11) {
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(@NonNull View view, int i10, int i11, int i12, int i13, int i14) {
        F(i13, i14, (int[]) null);
    }

    public boolean o(@NonNull View view, @NonNull View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4912j = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onGenericMotionEvent(@androidx.annotation.NonNull android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            r1 = 0
            r2 = 8
            if (r0 != r2) goto L_0x00aa
            boolean r0 = r8.f4914l
            if (r0 != 0) goto L_0x00aa
            r0 = 2
            boolean r0 = androidx.core.view.b0.b(r9, r0)
            r2 = 0
            if (r0 == 0) goto L_0x001c
            r0 = 9
            float r0 = r9.getAxisValue(r0)
            goto L_0x002c
        L_0x001c:
            r0 = 4194304(0x400000, float:5.877472E-39)
            boolean r0 = androidx.core.view.b0.b(r9, r0)
            if (r0 == 0) goto L_0x002b
            r0 = 26
            float r0 = r9.getAxisValue(r0)
            goto L_0x002c
        L_0x002b:
            r0 = r2
        L_0x002c:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00aa
            float r2 = r8.getVerticalScrollFactorCompat()
            float r0 = r0 * r2
            int r0 = (int) r0
            int r2 = r8.getScrollRange()
            int r3 = r8.getScrollY()
            int r0 = r3 - r0
            r4 = 1056964608(0x3f000000, float:0.5)
            r5 = 8194(0x2002, float:1.1482E-41)
            r6 = 1
            if (r0 >= 0) goto L_0x0071
            boolean r2 = r8.c()
            if (r2 == 0) goto L_0x0055
            boolean r9 = androidx.core.view.b0.b(r9, r5)
            if (r9 != 0) goto L_0x0055
            r9 = r6
            goto L_0x0056
        L_0x0055:
            r9 = r1
        L_0x0056:
            if (r9 == 0) goto L_0x006f
            android.widget.EdgeEffect r9 = r8.f4908e
            float r0 = (float) r0
            float r0 = -r0
            int r2 = r8.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            androidx.core.widget.e.d(r9, r0, r4)
            android.widget.EdgeEffect r9 = r8.f4908e
            r9.onRelease()
            r8.invalidate()
            r9 = r6
            goto L_0x009f
        L_0x006f:
            r9 = r1
            goto L_0x009f
        L_0x0071:
            if (r0 <= r2) goto L_0x009d
            boolean r7 = r8.c()
            if (r7 == 0) goto L_0x0081
            boolean r9 = androidx.core.view.b0.b(r9, r5)
            if (r9 != 0) goto L_0x0081
            r9 = r6
            goto L_0x0082
        L_0x0081:
            r9 = r1
        L_0x0082:
            if (r9 == 0) goto L_0x009a
            android.widget.EdgeEffect r9 = r8.f4909f
            int r0 = r0 - r2
            float r0 = (float) r0
            int r1 = r8.getHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            androidx.core.widget.e.d(r9, r0, r4)
            android.widget.EdgeEffect r9 = r8.f4909f
            r9.onRelease()
            r8.invalidate()
            r1 = r6
        L_0x009a:
            r9 = r1
            r1 = r2
            goto L_0x009f
        L_0x009d:
            r9 = r1
            r1 = r0
        L_0x009f:
            if (r1 == r3) goto L_0x00a9
            int r9 = r8.getScrollX()
            super.scrollTo(r9, r1)
            return r6
        L_0x00a9:
            return r9
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action == 2 && this.f4914l) {
            return true;
        }
        int i10 = action & 255;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    int i11 = this.f4921x;
                    if (i11 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i11);
                        if (findPointerIndex == -1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Invalid pointerId=");
                            sb2.append(i11);
                            sb2.append(" in onInterceptTouchEvent");
                        } else {
                            int y10 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y10 - this.f4910g) > this.f4918q && (2 & getNestedScrollAxes()) == 0) {
                                this.f4914l = true;
                                this.f4910g = y10;
                                B();
                                this.f4915m.addMovement(motionEvent);
                                this.B = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i10 != 3) {
                    if (i10 == 6) {
                        G(motionEvent);
                    }
                }
            }
            this.f4914l = false;
            this.f4921x = -1;
            J();
            if (this.f4907d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                n0.j0(this);
            }
            W(0);
        } else {
            int y11 = (int) motionEvent.getY();
            if (!y((int) motionEvent.getX(), y11)) {
                if (!V(motionEvent) && this.f4907d.isFinished()) {
                    z10 = false;
                }
                this.f4914l = z10;
                J();
            } else {
                this.f4910g = y11;
                this.f4921x = motionEvent.getPointerId(0);
                z();
                this.f4915m.addMovement(motionEvent);
                this.f4907d.computeScrollOffset();
                if (!V(motionEvent) && this.f4907d.isFinished()) {
                    z10 = false;
                }
                this.f4914l = z10;
                U(2, 0);
            }
        }
        return this.f4914l;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int i14 = 0;
        this.f4911h = false;
        View view = this.f4913k;
        if (view != null && D(view, this)) {
            N(this.f4913k);
        }
        this.f4913k = null;
        if (!this.f4912j) {
            if (this.D != null) {
                scrollTo(getScrollX(), this.D.f4924a);
                this.D = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i14 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int e10 = e(scrollY, paddingTop, i14);
            if (e10 != scrollY) {
                scrollTo(getScrollX(), e10);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f4912j = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f4916n && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(@NonNull View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        u((int) f11);
        return true;
    }

    public boolean onNestedPreFling(@NonNull View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    public void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr) {
        k(view, i10, i11, iArr, 0);
    }

    public void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13) {
        F(i13, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10) {
        i(view, view2, i10, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        View view;
        if (i10 == 2) {
            i10 = Opcodes.IXOR;
        } else if (i10 == 1) {
            i10 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i10);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i10);
        }
        if (view != null && !C(view)) {
            return view.requestFocus(i10, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.D = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4924a = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        c cVar = this.H;
        if (cVar != null) {
            cVar.a(this, i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && E(findFocus, 0, i13)) {
            findFocus.getDrawingRect(this.f4906c);
            offsetDescendantRectToMyCoords(findFocus, this.f4906c);
            p(f(this.f4906c));
        }
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10) {
        return o(view, view2, i10, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        j(view, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x01cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r24) {
        /*
            r23 = this;
            r10 = r23
            r11 = r24
            r23.B()
            int r0 = r24.getActionMasked()
            r12 = 0
            if (r0 != 0) goto L_0x0010
            r10.B = r12
        L_0x0010:
            android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r24)
            int r1 = r10.B
            float r1 = (float) r1
            r2 = 0
            r13.offsetLocation(r2, r1)
            r1 = 2
            r14 = 1
            if (r0 == 0) goto L_0x0225
            r3 = -1
            if (r0 == r14) goto L_0x01d4
            if (r0 == r1) goto L_0x0082
            r1 = 3
            if (r0 == r1) goto L_0x0054
            r1 = 5
            if (r0 == r1) goto L_0x0041
            r1 = 6
            if (r0 == r1) goto L_0x002f
            goto L_0x0254
        L_0x002f:
            r23.G(r24)
            int r0 = r10.f4921x
            int r0 = r11.findPointerIndex(r0)
            float r0 = r11.getY(r0)
            int r0 = (int) r0
            r10.f4910g = r0
            goto L_0x0254
        L_0x0041:
            int r0 = r24.getActionIndex()
            float r1 = r11.getY(r0)
            int r1 = (int) r1
            r10.f4910g = r1
            int r0 = r11.getPointerId(r0)
            r10.f4921x = r0
            goto L_0x0254
        L_0x0054:
            boolean r0 = r10.f4914l
            if (r0 == 0) goto L_0x007b
            int r0 = r23.getChildCount()
            if (r0 <= 0) goto L_0x007b
            android.widget.OverScroller r15 = r10.f4907d
            int r16 = r23.getScrollX()
            int r17 = r23.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r23.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x007b
            androidx.core.view.n0.j0(r23)
        L_0x007b:
            r10.f4921x = r3
            r23.r()
            goto L_0x0254
        L_0x0082:
            int r0 = r10.f4921x
            int r15 = r11.findPointerIndex(r0)
            if (r15 != r3) goto L_0x00a0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid pointerId="
            r0.append(r1)
            int r1 = r10.f4921x
            r0.append(r1)
            java.lang.String r1 = " in onTouchEvent"
            r0.append(r1)
            goto L_0x0254
        L_0x00a0:
            float r0 = r11.getY(r15)
            int r6 = (int) r0
            int r0 = r10.f4910g
            int r0 = r0 - r6
            float r1 = r11.getX(r15)
            int r1 = r10.K(r0, r1)
            int r0 = r0 - r1
            boolean r1 = r10.f4914l
            if (r1 != 0) goto L_0x00d1
            int r1 = java.lang.Math.abs(r0)
            int r2 = r10.f4918q
            if (r1 <= r2) goto L_0x00d1
            android.view.ViewParent r1 = r23.getParent()
            if (r1 == 0) goto L_0x00c6
            r1.requestDisallowInterceptTouchEvent(r14)
        L_0x00c6:
            r10.f4914l = r14
            if (r0 <= 0) goto L_0x00ce
            int r1 = r10.f4918q
            int r0 = r0 - r1
            goto L_0x00d1
        L_0x00ce:
            int r1 = r10.f4918q
            int r0 = r0 + r1
        L_0x00d1:
            r7 = r0
            boolean r0 = r10.f4914l
            if (r0 == 0) goto L_0x0254
            r1 = 0
            int[] r3 = r10.f4923z
            int[] r4 = r10.f4922y
            r5 = 0
            r0 = r23
            r2 = r7
            boolean r0 = r0.h(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00f3
            int[] r0 = r10.f4923z
            r0 = r0[r14]
            int r7 = r7 - r0
            int r0 = r10.B
            int[] r1 = r10.f4922y
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.B = r0
        L_0x00f3:
            r16 = r7
            int[] r0 = r10.f4922y
            r0 = r0[r14]
            int r6 = r6 - r0
            r10.f4910g = r6
            int r17 = r23.getScrollY()
            int r9 = r23.getScrollRange()
            int r0 = r23.getOverScrollMode()
            if (r0 == 0) goto L_0x0112
            if (r0 != r14) goto L_0x010f
            if (r9 <= 0) goto L_0x010f
            goto L_0x0112
        L_0x010f:
            r18 = r12
            goto L_0x0114
        L_0x0112:
            r18 = r14
        L_0x0114:
            r1 = 0
            r3 = 0
            int r4 = r23.getScrollY()
            r5 = 0
            r7 = 0
            r8 = 0
            r19 = 1
            r0 = r23
            r2 = r16
            r6 = r9
            r22 = r9
            r9 = r19
            boolean r0 = r0.H(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0136
            boolean r0 = r10.x(r12)
            if (r0 != 0) goto L_0x0136
            r8 = r14
            goto L_0x0137
        L_0x0136:
            r8 = r12
        L_0x0137:
            int r0 = r23.getScrollY()
            int r2 = r0 - r17
            int r4 = r16 - r2
            int[] r7 = r10.f4923z
            r7[r14] = r12
            r1 = 0
            r3 = 0
            int[] r5 = r10.f4922y
            r6 = 0
            r0 = r23
            r0.l(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r10.f4910g
            int[] r1 = r10.f4922y
            r1 = r1[r14]
            int r0 = r0 - r1
            r10.f4910g = r0
            int r0 = r10.B
            int r0 = r0 + r1
            r10.B = r0
            if (r18 == 0) goto L_0x01ca
            int[] r0 = r10.f4923z
            r0 = r0[r14]
            int r0 = r16 - r0
            int r1 = r17 + r0
            if (r1 >= 0) goto L_0x018c
            android.widget.EdgeEffect r1 = r10.f4908e
            int r0 = -r0
            float r0 = (float) r0
            int r2 = r23.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            float r2 = r11.getX(r15)
            int r3 = r23.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            androidx.core.widget.e.d(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.f4909f
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01b6
            android.widget.EdgeEffect r0 = r10.f4909f
            r0.onRelease()
            goto L_0x01b6
        L_0x018c:
            r2 = r22
            if (r1 <= r2) goto L_0x01b6
            android.widget.EdgeEffect r1 = r10.f4909f
            float r0 = (float) r0
            int r2 = r23.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = r11.getX(r15)
            int r4 = r23.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            float r2 = r2 - r3
            androidx.core.widget.e.d(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.f4908e
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01b6
            android.widget.EdgeEffect r0 = r10.f4908e
            r0.onRelease()
        L_0x01b6:
            android.widget.EdgeEffect r0 = r10.f4908e
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x01c6
            android.widget.EdgeEffect r0 = r10.f4909f
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01ca
        L_0x01c6:
            androidx.core.view.n0.j0(r23)
            goto L_0x01cb
        L_0x01ca:
            r12 = r8
        L_0x01cb:
            if (r12 == 0) goto L_0x0254
            android.view.VelocityTracker r0 = r10.f4915m
            r0.clear()
            goto L_0x0254
        L_0x01d4:
            android.view.VelocityTracker r0 = r10.f4915m
            r1 = 1000(0x3e8, float:1.401E-42)
            int r4 = r10.f4920w
            float r4 = (float) r4
            r0.computeCurrentVelocity(r1, r4)
            int r1 = r10.f4921x
            float r0 = r0.getYVelocity(r1)
            int r0 = (int) r0
            int r1 = java.lang.Math.abs(r0)
            int r4 = r10.f4919t
            if (r1 < r4) goto L_0x0202
            boolean r1 = r10.q(r0)
            if (r1 != 0) goto L_0x021f
            int r0 = -r0
            float r1 = (float) r0
            boolean r4 = r10.dispatchNestedPreFling(r2, r1)
            if (r4 != 0) goto L_0x021f
            r10.dispatchNestedFling(r2, r1, r14)
            r10.u(r0)
            goto L_0x021f
        L_0x0202:
            android.widget.OverScroller r15 = r10.f4907d
            int r16 = r23.getScrollX()
            int r17 = r23.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r23.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x021f
            androidx.core.view.n0.j0(r23)
        L_0x021f:
            r10.f4921x = r3
            r23.r()
            goto L_0x0254
        L_0x0225:
            int r0 = r23.getChildCount()
            if (r0 != 0) goto L_0x022c
            return r12
        L_0x022c:
            boolean r0 = r10.f4914l
            if (r0 == 0) goto L_0x0239
            android.view.ViewParent r0 = r23.getParent()
            if (r0 == 0) goto L_0x0239
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x0239:
            android.widget.OverScroller r0 = r10.f4907d
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x0244
            r23.a()
        L_0x0244:
            float r0 = r24.getY()
            int r0 = (int) r0
            r10.f4910g = r0
            int r0 = r11.getPointerId(r12)
            r10.f4921x = r0
            r10.U(r1, r12)
        L_0x0254:
            android.view.VelocityTracker r0 = r10.f4915m
            if (r0 == 0) goto L_0x025b
            r0.addMovement(r13)
        L_0x025b:
            r13.recycle()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f4911h) {
            N(view2);
        } else {
            this.f4913k = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return O(rect, z10);
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            J();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public void requestLayout() {
        this.f4911h = true;
        super.requestLayout();
    }

    public boolean s(@NonNull KeyEvent keyEvent) {
        this.f4906c.setEmpty();
        boolean d10 = d();
        int i10 = Opcodes.IXOR;
        if (!d10) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, Opcodes.IXOR);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(Opcodes.IXOR)) {
                return false;
            }
            return true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        return false;
                    }
                    if (keyEvent.isShiftPressed()) {
                        i10 = 33;
                    }
                    I(i10);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return b(Opcodes.IXOR);
                } else {
                    return v(Opcodes.IXOR);
                }
            } else if (!keyEvent.isAltPressed()) {
                return b(33);
            } else {
                return v(33);
            }
        }
    }

    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int e10 = e(i10, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int e11 = e(i11, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (e10 != getScrollX() || e11 != getScrollY()) {
                super.scrollTo(e10, e11);
            }
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f4916n) {
            this.f4916n = z10;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z10) {
        this.F.m(z10);
    }

    public void setOnScrollChangeListener(c cVar) {
        this.H = cVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f4917p = z10;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i10) {
        return U(i10, 0);
    }

    public void stopNestedScroll() {
        W(0);
    }

    public void u(int i10) {
        if (getChildCount() > 0) {
            this.f4907d.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER, 0, 0);
            L(true);
        }
    }

    public boolean v(int i10) {
        boolean z10;
        int childCount;
        if (i10 == 130) {
            z10 = true;
        } else {
            z10 = false;
        }
        int height = getHeight();
        Rect rect = this.f4906c;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f4906c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f4906c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f4906c;
        return M(i10, rect3.top, rect3.bottom);
    }

    public boolean x(int i10) {
        return this.F.k(i10);
    }

    public NestedScrollView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4906c = new Rect();
        this.f4911h = true;
        this.f4912j = false;
        this.f4913k = null;
        this.f4914l = false;
        this.f4917p = true;
        this.f4921x = -1;
        this.f4922y = new int[2];
        this.f4923z = new int[2];
        this.f4908e = e.a(context, attributeSet);
        this.f4909f = e.a(context, attributeSet);
        this.f4904a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        A();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K, i10, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.E = new g0(this);
        this.F = new d0(this);
        setNestedScrollingEnabled(true);
        n0.s0(this, J);
    }

    public void addView(View view, int i10) {
        if (getChildCount() <= 0) {
            super.addView(view, i10);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
