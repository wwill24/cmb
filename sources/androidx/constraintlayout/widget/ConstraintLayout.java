package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.g;
import androidx.constraintlayout.core.widgets.h;
import com.google.android.gms.common.api.a;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.bytebuddy.jar.asm.Opcodes;
import org.jivesoftware.smack.packet.Message;

public class ConstraintLayout extends ViewGroup {
    private static i E;
    c B = new c(this);
    private int C = 0;
    private int D = 0;

    /* renamed from: a  reason: collision with root package name */
    SparseArray<View> f4115a = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f4116b = new ArrayList<>(4);

    /* renamed from: c  reason: collision with root package name */
    protected d f4117c = new d();

    /* renamed from: d  reason: collision with root package name */
    private int f4118d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f4119e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f4120f = a.e.API_PRIORITY_OTHER;

    /* renamed from: g  reason: collision with root package name */
    private int f4121g = a.e.API_PRIORITY_OTHER;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f4122h = true;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f4123j = 257;

    /* renamed from: k  reason: collision with root package name */
    private c f4124k = null;

    /* renamed from: l  reason: collision with root package name */
    protected b f4125l = null;

    /* renamed from: m  reason: collision with root package name */
    private int f4126m = -1;

    /* renamed from: n  reason: collision with root package name */
    private HashMap<String, Integer> f4127n = new HashMap<>();

    /* renamed from: p  reason: collision with root package name */
    private int f4128p = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f4129q = -1;

    /* renamed from: t  reason: collision with root package name */
    int f4130t = -1;

    /* renamed from: w  reason: collision with root package name */
    int f4131w = -1;

    /* renamed from: x  reason: collision with root package name */
    int f4132x = 0;

    /* renamed from: y  reason: collision with root package name */
    int f4133y = 0;

    /* renamed from: z  reason: collision with root package name */
    private SparseArray<ConstraintWidget> f4134z = new SparseArray<>();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4135a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4135a = r0
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4135a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4135a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4135a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.<clinit>():void");
        }
    }

    class c implements b.C0027b {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f4186a;

        /* renamed from: b  reason: collision with root package name */
        int f4187b;

        /* renamed from: c  reason: collision with root package name */
        int f4188c;

        /* renamed from: d  reason: collision with root package name */
        int f4189d;

        /* renamed from: e  reason: collision with root package name */
        int f4190e;

        /* renamed from: f  reason: collision with root package name */
        int f4191f;

        /* renamed from: g  reason: collision with root package name */
        int f4192g;

        public c(ConstraintLayout constraintLayout) {
            this.f4186a = constraintLayout;
        }

        private boolean d(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i12 == size) {
                return true;
            }
            return false;
        }

        public final void a() {
            int childCount = this.f4186a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f4186a.getChildAt(i10);
                if (childAt instanceof f) {
                    ((f) childAt).a(this.f4186a);
                }
            }
            int size = this.f4186a.f4116b.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((a) this.f4186a.f4116b.get(i11)).p(this.f4186a);
                }
            }
        }

        @SuppressLint({"WrongCall"})
        public final void b(ConstraintWidget constraintWidget, b.a aVar) {
            int i10;
            int i11;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            int i12;
            int i13;
            int i14;
            int i15;
            boolean z16;
            boolean z17;
            int i16;
            int i17;
            boolean z18;
            boolean z19;
            boolean z20;
            boolean z21;
            boolean z22;
            boolean z23;
            boolean z24;
            ConstraintWidget constraintWidget2 = constraintWidget;
            b.a aVar2 = aVar;
            if (constraintWidget2 != null) {
                if (constraintWidget.V() == 8 && !constraintWidget.j0()) {
                    aVar2.f3861e = 0;
                    aVar2.f3862f = 0;
                    aVar2.f3863g = 0;
                } else if (constraintWidget.K() != null) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar2.f3857a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = aVar2.f3858b;
                    int i18 = aVar2.f3859c;
                    int i19 = aVar2.f3860d;
                    int i20 = this.f4187b + this.f4188c;
                    int i21 = this.f4189d;
                    View view = (View) constraintWidget.s();
                    int[] iArr = a.f4135a;
                    int i22 = iArr[dimensionBehaviour.ordinal()];
                    if (i22 == 1) {
                        i10 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                    } else if (i22 == 2) {
                        i10 = ViewGroup.getChildMeasureSpec(this.f4191f, i21, -2);
                    } else if (i22 == 3) {
                        i10 = ViewGroup.getChildMeasureSpec(this.f4191f, i21 + constraintWidget.B(), -1);
                    } else if (i22 != 4) {
                        i10 = 0;
                    } else {
                        i10 = ViewGroup.getChildMeasureSpec(this.f4191f, i21, -2);
                        if (constraintWidget2.f3799w == 1) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                        int i23 = aVar2.f3866j;
                        if (i23 == b.a.f3855l || i23 == b.a.f3856m) {
                            if (view.getMeasuredHeight() == constraintWidget.x()) {
                                z23 = true;
                            } else {
                                z23 = false;
                            }
                            if (aVar2.f3866j == b.a.f3856m || !z22 || ((z22 && z23) || (view instanceof f) || constraintWidget.n0())) {
                                z24 = true;
                            } else {
                                z24 = false;
                            }
                            if (z24) {
                                i10 = View.MeasureSpec.makeMeasureSpec(constraintWidget.W(), 1073741824);
                            }
                        }
                    }
                    int i24 = iArr[dimensionBehaviour2.ordinal()];
                    if (i24 == 1) {
                        i11 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                    } else if (i24 == 2) {
                        i11 = ViewGroup.getChildMeasureSpec(this.f4192g, i20, -2);
                    } else if (i24 == 3) {
                        i11 = ViewGroup.getChildMeasureSpec(this.f4192g, i20 + constraintWidget.U(), -1);
                    } else if (i24 != 4) {
                        i11 = 0;
                    } else {
                        i11 = ViewGroup.getChildMeasureSpec(this.f4192g, i20, -2);
                        if (constraintWidget2.f3801x == 1) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        int i25 = aVar2.f3866j;
                        if (i25 == b.a.f3855l || i25 == b.a.f3856m) {
                            if (view.getMeasuredWidth() == constraintWidget.W()) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (aVar2.f3866j == b.a.f3856m || !z19 || ((z19 && z20) || (view instanceof f) || constraintWidget.o0())) {
                                z21 = true;
                            } else {
                                z21 = false;
                            }
                            if (z21) {
                                i11 = View.MeasureSpec.makeMeasureSpec(constraintWidget.x(), 1073741824);
                            }
                        }
                    }
                    d dVar = (d) constraintWidget.K();
                    if (dVar != null && g.b(ConstraintLayout.this.f4123j, 256) && view.getMeasuredWidth() == constraintWidget.W() && view.getMeasuredWidth() < dVar.W() && view.getMeasuredHeight() == constraintWidget.x() && view.getMeasuredHeight() < dVar.x() && view.getBaseline() == constraintWidget.p() && !constraintWidget.m0()) {
                        if (!d(constraintWidget.C(), i10, constraintWidget.W()) || !d(constraintWidget.D(), i11, constraintWidget.x())) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (z18) {
                            aVar2.f3861e = constraintWidget.W();
                            aVar2.f3862f = constraintWidget.x();
                            aVar2.f3863g = constraintWidget.p();
                            return;
                        }
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                    if (dimensionBehaviour2 == dimensionBehaviour4 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (dimensionBehaviour == dimensionBehaviour4 || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (!z10 || constraintWidget2.f3762d0 <= 0.0f) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (!z11 || constraintWidget2.f3762d0 <= 0.0f) {
                        z15 = false;
                    } else {
                        z15 = true;
                    }
                    if (view != null) {
                        b bVar = (b) view.getLayoutParams();
                        int i26 = aVar2.f3866j;
                        if (i26 == b.a.f3855l || i26 == b.a.f3856m || !z10 || constraintWidget2.f3799w != 0 || !z11 || constraintWidget2.f3801x != 0) {
                            if (!(view instanceof j) || !(constraintWidget2 instanceof h)) {
                                view.measure(i10, i11);
                            } else {
                                ((j) view).t((h) constraintWidget2, i10, i11);
                            }
                            constraintWidget2.V0(i10, i11);
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            i13 = view.getBaseline();
                            int i27 = constraintWidget2.f3805z;
                            if (i27 > 0) {
                                i12 = Math.max(i27, measuredWidth);
                            } else {
                                i12 = measuredWidth;
                            }
                            int i28 = constraintWidget2.A;
                            if (i28 > 0) {
                                i12 = Math.min(i28, i12);
                            }
                            int i29 = constraintWidget2.C;
                            if (i29 > 0) {
                                i14 = Math.max(i29, measuredHeight);
                                i16 = i10;
                            } else {
                                i16 = i10;
                                i14 = measuredHeight;
                            }
                            int i30 = constraintWidget2.D;
                            if (i30 > 0) {
                                i14 = Math.min(i30, i14);
                            }
                            if (!g.b(ConstraintLayout.this.f4123j, 1)) {
                                if (z14 && z12) {
                                    i12 = (int) ((((float) i14) * constraintWidget2.f3762d0) + 0.5f);
                                } else if (z15 && z13) {
                                    i14 = (int) ((((float) i12) / constraintWidget2.f3762d0) + 0.5f);
                                }
                            }
                            if (!(measuredWidth == i12 && measuredHeight == i14)) {
                                if (measuredWidth != i12) {
                                    i17 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                                } else {
                                    i17 = i16;
                                }
                                if (measuredHeight != i14) {
                                    i11 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                                }
                                view.measure(i17, i11);
                                constraintWidget2.V0(i17, i11);
                                i12 = view.getMeasuredWidth();
                                i14 = view.getMeasuredHeight();
                                i13 = view.getBaseline();
                            }
                            i15 = -1;
                        } else {
                            i15 = -1;
                            i14 = 0;
                            i13 = 0;
                            i12 = 0;
                        }
                        if (i13 != i15) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (i12 == aVar2.f3859c && i14 == aVar2.f3860d) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        aVar2.f3865i = z17;
                        if (bVar.f4149g0) {
                            z16 = true;
                        }
                        if (!(!z16 || i13 == -1 || constraintWidget.p() == i13)) {
                            aVar2.f3865i = true;
                        }
                        aVar2.f3861e = i12;
                        aVar2.f3862f = i14;
                        aVar2.f3864h = z16;
                        aVar2.f3863g = i13;
                    }
                }
            }
        }

        public void c(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f4187b = i12;
            this.f4188c = i13;
            this.f4189d = i14;
            this.f4190e = i15;
            this.f4191f = i10;
            this.f4192g = i11;
        }
    }

    public ConstraintLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q(attributeSet, 0, 0);
    }

    private boolean A() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            } else if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            w();
        }
        return z10;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    public static i getSharedValues() {
        if (E == null) {
            E = new i();
        }
        return E;
    }

    private final ConstraintWidget h(int i10) {
        if (i10 == 0) {
            return this.f4117c;
        }
        View view = this.f4115a.get(i10);
        if (view == null && (view = findViewById(i10)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f4117c;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f4179v0;
    }

    private void q(AttributeSet attributeSet, int i10, int i11) {
        this.f4117c.B0(this);
        this.f4117c.V1(this.B);
        this.f4115a.put(getId(), this);
        this.f4124k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout, i10, i11);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = obtainStyledAttributes.getIndex(i12);
                if (index == h.ConstraintLayout_Layout_android_minWidth) {
                    this.f4118d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4118d);
                } else if (index == h.ConstraintLayout_Layout_android_minHeight) {
                    this.f4119e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4119e);
                } else if (index == h.ConstraintLayout_Layout_android_maxWidth) {
                    this.f4120f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4120f);
                } else if (index == h.ConstraintLayout_Layout_android_maxHeight) {
                    this.f4121g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4121g);
                } else if (index == h.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f4123j = obtainStyledAttributes.getInt(index, this.f4123j);
                } else if (index == h.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            t(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f4125l = null;
                        }
                    }
                } else if (index == h.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        c cVar = new c();
                        this.f4124k = cVar;
                        cVar.w(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f4124k = null;
                    }
                    this.f4126m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4117c.W1(this.f4123j);
    }

    private void s() {
        this.f4122h = true;
        this.f4128p = -1;
        this.f4129q = -1;
        this.f4130t = -1;
        this.f4131w = -1;
        this.f4132x = 0;
        this.f4133y = 0;
    }

    private void w() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ConstraintWidget p10 = p(getChildAt(i10));
            if (p10 != null) {
                p10.t0();
            }
        }
        if (isInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    x(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    h(childAt.getId()).C0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f4126m != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.f4126m && (childAt2 instanceof d)) {
                    this.f4124k = ((d) childAt2).getConstraintSet();
                }
            }
        }
        c cVar = this.f4124k;
        if (cVar != null) {
            cVar.d(this, true);
        }
        this.f4117c.u1();
        int size = this.f4116b.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.f4116b.get(i13).r(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof f) {
                ((f) childAt3).b(this);
            }
        }
        this.f4134z.clear();
        this.f4134z.put(0, this.f4117c);
        this.f4134z.put(getId(), this.f4117c);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.f4134z.put(childAt4.getId(), p(childAt4));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt5 = getChildAt(i16);
            ConstraintWidget p11 = p(childAt5);
            if (p11 != null) {
                this.f4117c.a(p11);
                d(isInEditMode, childAt5, p11, (b) childAt5.getLayoutParams(), this.f4134z);
            }
        }
    }

    private void z(ConstraintWidget constraintWidget, b bVar, SparseArray<ConstraintWidget> sparseArray, int i10, ConstraintAnchor.Type type) {
        View view = this.f4115a.get(i10);
        ConstraintWidget constraintWidget2 = sparseArray.get(i10);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof b)) {
            bVar.f4149g0 = true;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                b bVar2 = (b) view.getLayoutParams();
                bVar2.f4149g0 = true;
                bVar2.f4179v0.K0(true);
            }
            constraintWidget.o(type2).b(constraintWidget2.o(type), bVar.D, bVar.C, true);
            constraintWidget.K0(true);
            constraintWidget.o(ConstraintAnchor.Type.TOP).q();
            constraintWidget.o(ConstraintAnchor.Type.BOTTOM).q();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* access modifiers changed from: protected */
    public void d(boolean z10, View view, ConstraintWidget constraintWidget, b bVar, SparseArray<ConstraintWidget> sparseArray) {
        int i10;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        View view2 = view;
        ConstraintWidget constraintWidget6 = constraintWidget;
        b bVar2 = bVar;
        SparseArray<ConstraintWidget> sparseArray2 = sparseArray;
        bVar.a();
        bVar2.f4181w0 = false;
        constraintWidget6.j1(view.getVisibility());
        if (bVar2.f4155j0) {
            constraintWidget6.T0(true);
            constraintWidget6.j1(8);
        }
        constraintWidget6.B0(view2);
        if (view2 instanceof a) {
            ((a) view2).n(constraintWidget6, this.f4117c.P1());
        }
        if (bVar2.f4151h0) {
            f fVar = (f) constraintWidget6;
            int i11 = bVar2.f4173s0;
            int i12 = bVar2.f4175t0;
            float f10 = bVar2.f4177u0;
            if (f10 != -1.0f) {
                fVar.z1(f10);
            } else if (i11 != -1) {
                fVar.x1(i11);
            } else if (i12 != -1) {
                fVar.y1(i12);
            }
        } else {
            int i13 = bVar2.f4159l0;
            int i14 = bVar2.f4161m0;
            int i15 = bVar2.f4163n0;
            int i16 = bVar2.f4165o0;
            int i17 = bVar2.f4167p0;
            int i18 = bVar2.f4169q0;
            float f11 = bVar2.f4171r0;
            int i19 = bVar2.f4166p;
            if (i19 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray2.get(i19);
                if (constraintWidget7 != null) {
                    constraintWidget6.l(constraintWidget7, bVar2.f4170r, bVar2.f4168q);
                }
            } else {
                if (i13 != -1) {
                    ConstraintWidget constraintWidget8 = sparseArray2.get(i13);
                    if (constraintWidget8 != null) {
                        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                        constraintWidget.e0(type, constraintWidget8, type, bVar2.leftMargin, i17);
                    }
                } else if (!(i14 == -1 || (constraintWidget5 = sparseArray2.get(i14)) == null)) {
                    constraintWidget.e0(ConstraintAnchor.Type.LEFT, constraintWidget5, ConstraintAnchor.Type.RIGHT, bVar2.leftMargin, i17);
                }
                if (i15 != -1) {
                    ConstraintWidget constraintWidget9 = sparseArray2.get(i15);
                    if (constraintWidget9 != null) {
                        constraintWidget.e0(ConstraintAnchor.Type.RIGHT, constraintWidget9, ConstraintAnchor.Type.LEFT, bVar2.rightMargin, i18);
                    }
                } else if (!(i16 == -1 || (constraintWidget4 = sparseArray2.get(i16)) == null)) {
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.e0(type2, constraintWidget4, type2, bVar2.rightMargin, i18);
                }
                int i20 = bVar2.f4152i;
                if (i20 != -1) {
                    ConstraintWidget constraintWidget10 = sparseArray2.get(i20);
                    if (constraintWidget10 != null) {
                        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                        constraintWidget.e0(type3, constraintWidget10, type3, bVar2.topMargin, bVar2.f4182x);
                    }
                } else {
                    int i21 = bVar2.f4154j;
                    if (!(i21 == -1 || (constraintWidget3 = sparseArray2.get(i21)) == null)) {
                        constraintWidget.e0(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.BOTTOM, bVar2.topMargin, bVar2.f4182x);
                    }
                }
                int i22 = bVar2.f4156k;
                if (i22 != -1) {
                    ConstraintWidget constraintWidget11 = sparseArray2.get(i22);
                    if (constraintWidget11 != null) {
                        constraintWidget.e0(ConstraintAnchor.Type.BOTTOM, constraintWidget11, ConstraintAnchor.Type.TOP, bVar2.bottomMargin, bVar2.f4184z);
                    }
                } else {
                    int i23 = bVar2.f4158l;
                    if (!(i23 == -1 || (constraintWidget2 = sparseArray2.get(i23)) == null)) {
                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                        constraintWidget.e0(type4, constraintWidget2, type4, bVar2.bottomMargin, bVar2.f4184z);
                    }
                }
                int i24 = bVar2.f4160m;
                if (i24 != -1) {
                    z(constraintWidget, bVar, sparseArray, i24, ConstraintAnchor.Type.BASELINE);
                } else {
                    int i25 = bVar2.f4162n;
                    if (i25 != -1) {
                        z(constraintWidget, bVar, sparseArray, i25, ConstraintAnchor.Type.TOP);
                    } else {
                        int i26 = bVar2.f4164o;
                        if (i26 != -1) {
                            z(constraintWidget, bVar, sparseArray, i26, ConstraintAnchor.Type.BOTTOM);
                        }
                    }
                }
                if (f11 >= 0.0f) {
                    constraintWidget6.M0(f11);
                }
                float f12 = bVar2.H;
                if (f12 >= 0.0f) {
                    constraintWidget6.d1(f12);
                }
            }
            if (z10 && !((i10 = bVar2.X) == -1 && bVar2.Y == -1)) {
                constraintWidget6.b1(i10, bVar2.Y);
            }
            if (bVar2.f4145e0) {
                constraintWidget6.P0(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget6.k1(bVar2.width);
                if (bVar2.width == -2) {
                    constraintWidget6.P0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (bVar2.width == -1) {
                if (bVar2.f4137a0) {
                    constraintWidget6.P0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget6.P0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget6.o(ConstraintAnchor.Type.LEFT).f3741g = bVar2.leftMargin;
                constraintWidget6.o(ConstraintAnchor.Type.RIGHT).f3741g = bVar2.rightMargin;
            } else {
                constraintWidget6.P0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget6.k1(0);
            }
            if (bVar2.f4147f0) {
                constraintWidget6.g1(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget6.L0(bVar2.height);
                if (bVar2.height == -2) {
                    constraintWidget6.g1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (bVar2.height == -1) {
                if (bVar2.f4139b0) {
                    constraintWidget6.g1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget6.g1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget6.o(ConstraintAnchor.Type.TOP).f3741g = bVar2.topMargin;
                constraintWidget6.o(ConstraintAnchor.Type.BOTTOM).f3741g = bVar2.bottomMargin;
            } else {
                constraintWidget6.g1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget6.L0(0);
            }
            constraintWidget6.D0(bVar2.I);
            constraintWidget6.R0(bVar2.L);
            constraintWidget6.i1(bVar2.M);
            constraintWidget6.N0(bVar2.N);
            constraintWidget6.e1(bVar2.O);
            constraintWidget6.l1(bVar2.f4143d0);
            constraintWidget6.Q0(bVar2.P, bVar2.R, bVar2.T, bVar2.V);
            constraintWidget6.h1(bVar2.Q, bVar2.S, bVar2.U, bVar2.W);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<a> arrayList = this.f4116b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.f4116b.get(i10).q(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(AppsFlyerKit.COMMA);
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i12 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i13 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(Opcodes.V_PREVIEW);
                        float f10 = (float) i12;
                        float f11 = (float) (i12 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f12 = (float) i13;
                        float f13 = f10;
                        float f14 = f10;
                        float f15 = f12;
                        Paint paint2 = paint;
                        float f16 = f11;
                        Paint paint3 = paint2;
                        canvas2.drawLine(f13, f15, f16, f12, paint3);
                        float parseInt4 = (float) (i13 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f17 = f11;
                        float f18 = parseInt4;
                        canvas2.drawLine(f17, f15, f16, f18, paint3);
                        float f19 = parseInt4;
                        float f20 = f14;
                        canvas2.drawLine(f17, f19, f20, f18, paint3);
                        float f21 = f14;
                        canvas2.drawLine(f21, f19, f20, f12, paint3);
                        Paint paint4 = paint2;
                        paint4.setColor(-16711936);
                        Paint paint5 = paint4;
                        float f22 = f11;
                        Paint paint6 = paint5;
                        canvas2.drawLine(f21, f12, f22, parseInt4, paint6);
                        canvas2.drawLine(f21, parseInt4, f22, f12, paint6);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    /* renamed from: f */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public void forceLayout() {
        s();
        super.forceLayout();
    }

    public Object g(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.f4127n;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f4127n.get(str);
    }

    public int getMaxHeight() {
        return this.f4121g;
    }

    public int getMaxWidth() {
        return this.f4120f;
    }

    public int getMinHeight() {
        return this.f4119e;
    }

    public int getMinWidth() {
        return this.f4118d;
    }

    public int getOptimizationLevel() {
        return this.f4117c.J1();
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        if (this.f4117c.f3783o == null) {
            int id3 = getId();
            if (id3 != -1) {
                this.f4117c.f3783o = getContext().getResources().getResourceEntryName(id3);
            } else {
                this.f4117c.f3783o = Message.Thread.PARENT_ATTRIBUTE_NAME;
            }
        }
        if (this.f4117c.t() == null) {
            d dVar = this.f4117c;
            dVar.C0(dVar.f3783o);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" setDebugName ");
            sb3.append(this.f4117c.t());
        }
        Iterator<ConstraintWidget> it = this.f4117c.r1().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.s();
            if (view != null) {
                if (next.f3783o == null && (id2 = view.getId()) != -1) {
                    next.f3783o = getContext().getResources().getResourceEntryName(id2);
                }
                if (next.t() == null) {
                    next.C0(next.f3783o);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(" setDebugName ");
                    sb4.append(next.t());
                }
            }
        }
        this.f4117c.O(sb2);
        return sb2.toString();
    }

    public View l(int i10) {
        return this.f4115a.get(i10);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            b bVar = (b) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = bVar.f4179v0;
            if ((childAt.getVisibility() != 8 || bVar.f4151h0 || bVar.f4153i0 || bVar.f4157k0 || isInEditMode) && !bVar.f4155j0) {
                int X = constraintWidget.X();
                int Y = constraintWidget.Y();
                int W = constraintWidget.W() + X;
                int x10 = constraintWidget.x() + Y;
                childAt.layout(X, Y, W, x10);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(X, Y, W, x10);
                }
            }
        }
        int size = this.f4116b.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.f4116b.get(i15).o(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.C == i10) {
            int i12 = this.D;
        }
        if (!this.f4122h) {
            int childCount = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                } else if (getChildAt(i13).isLayoutRequested()) {
                    this.f4122h = true;
                    break;
                } else {
                    i13++;
                }
            }
        }
        boolean z10 = this.f4122h;
        this.C = i10;
        this.D = i11;
        this.f4117c.Y1(r());
        if (this.f4122h) {
            this.f4122h = false;
            if (A()) {
                this.f4117c.a2();
            }
        }
        v(this.f4117c, this.f4123j, i10, i11);
        u(i10, i11, this.f4117c.W(), this.f4117c.x(), this.f4117c.Q1(), this.f4117c.O1());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget p10 = p(view);
        if ((view instanceof Guideline) && !(p10 instanceof f)) {
            b bVar = (b) view.getLayoutParams();
            f fVar = new f();
            bVar.f4179v0 = fVar;
            bVar.f4151h0 = true;
            fVar.A1(bVar.Z);
        }
        if (view instanceof a) {
            a aVar = (a) view;
            aVar.s();
            ((b) view.getLayoutParams()).f4153i0 = true;
            if (!this.f4116b.contains(aVar)) {
                this.f4116b.add(aVar);
            }
        }
        this.f4115a.put(view.getId(), view);
        this.f4122h = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f4115a.remove(view.getId());
        this.f4117c.t1(p(view));
        this.f4116b.remove(view);
        this.f4122h = true;
    }

    public final ConstraintWidget p(View view) {
        if (view == this) {
            return this.f4117c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f4179v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f4179v0;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        boolean z10;
        if ((getContext().getApplicationInfo().flags & 4194304) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    public void requestLayout() {
        s();
        super.requestLayout();
    }

    public void setConstraintSet(c cVar) {
        this.f4124k = cVar;
    }

    public void setId(int i10) {
        this.f4115a.remove(getId());
        super.setId(i10);
        this.f4115a.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 != this.f4121g) {
            this.f4121g = i10;
            requestLayout();
        }
    }

    public void setMaxWidth(int i10) {
        if (i10 != this.f4120f) {
            this.f4120f = i10;
            requestLayout();
        }
    }

    public void setMinHeight(int i10) {
        if (i10 != this.f4119e) {
            this.f4119e = i10;
            requestLayout();
        }
    }

    public void setMinWidth(int i10) {
        if (i10 != this.f4118d) {
            this.f4118d = i10;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(e eVar) {
        b bVar = this.f4125l;
        if (bVar != null) {
            bVar.c(eVar);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f4123j = i10;
        this.f4117c.W1(i10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void t(int i10) {
        this.f4125l = new b(getContext(), this, i10);
    }

    /* access modifiers changed from: protected */
    public void u(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        c cVar = this.B;
        int i14 = cVar.f4190e;
        int resolveSizeAndState = View.resolveSizeAndState(i12 + cVar.f4189d, i10, 0);
        int min = Math.min(this.f4120f, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f4121g, View.resolveSizeAndState(i13 + i14, i11, 0) & 16777215);
        if (z10) {
            min |= 16777216;
        }
        if (z11) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.f4128p = min;
        this.f4129q = min2;
    }

    /* access modifiers changed from: protected */
    public void v(d dVar, int i10, int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i14 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.B.c(i11, i12, max, max2, paddingWidth, i14);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            i13 = Math.max(0, getPaddingLeft());
        } else if (r()) {
            i13 = max4;
        } else {
            i13 = max3;
        }
        int i15 = size - paddingWidth;
        int i16 = size2 - i14;
        y(dVar, mode, i15, mode2, i16);
        dVar.R1(i10, mode, i15, mode2, i16, this.f4128p, this.f4129q, i13, max);
    }

    public void x(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f4127n == null) {
                this.f4127n = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f4127n.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* access modifiers changed from: protected */
    public void y(d dVar, int i10, int i11, int i12, int i13) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        c cVar = this.B;
        int i14 = cVar.f4190e;
        int i15 = cVar.f4189d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i10 != Integer.MIN_VALUE) {
            if (i10 == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i11 = Math.max(0, this.f4118d);
                }
            } else if (i10 != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i11 = Math.min(this.f4120f - i15, i11);
                dimensionBehaviour = dimensionBehaviour2;
            }
            i11 = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i11 = Math.max(0, this.f4118d);
            }
        }
        if (i12 != Integer.MIN_VALUE) {
            if (i12 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i13 = Math.max(0, this.f4119e);
                }
            } else if (i12 == 1073741824) {
                i13 = Math.min(this.f4121g - i14, i13);
            }
            i13 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i13 = Math.max(0, this.f4119e);
            }
        }
        if (!(i11 == dVar.W() && i13 == dVar.x())) {
            dVar.N1();
        }
        dVar.m1(0);
        dVar.n1(0);
        dVar.X0(this.f4120f - i15);
        dVar.W0(this.f4121g - i14);
        dVar.a1(0);
        dVar.Z0(0);
        dVar.P0(dimensionBehaviour);
        dVar.k1(i11);
        dVar.g1(dimensionBehaviour2);
        dVar.L0(i13);
        dVar.a1(this.f4118d - i15);
        dVar.Z0(this.f4119e - i14);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        q(attributeSet, i10, 0);
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public int A = Integer.MIN_VALUE;
        public int B = Integer.MIN_VALUE;
        public int C = Integer.MIN_VALUE;
        public int D = 0;
        boolean E = true;
        boolean F = true;
        public float G = 0.5f;
        public float H = 0.5f;
        public String I = null;
        float J = 0.0f;
        int K = 1;
        public float L = -1.0f;
        public float M = -1.0f;
        public int N = 0;
        public int O = 0;
        public int P = 0;
        public int Q = 0;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public float V = 1.0f;
        public float W = 1.0f;
        public int X = -1;
        public int Y = -1;
        public int Z = -1;

        /* renamed from: a  reason: collision with root package name */
        public int f4136a = -1;

        /* renamed from: a0  reason: collision with root package name */
        public boolean f4137a0 = false;

        /* renamed from: b  reason: collision with root package name */
        public int f4138b = -1;

        /* renamed from: b0  reason: collision with root package name */
        public boolean f4139b0 = false;

        /* renamed from: c  reason: collision with root package name */
        public float f4140c = -1.0f;

        /* renamed from: c0  reason: collision with root package name */
        public String f4141c0 = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4142d = true;

        /* renamed from: d0  reason: collision with root package name */
        public int f4143d0 = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f4144e = -1;

        /* renamed from: e0  reason: collision with root package name */
        boolean f4145e0 = true;

        /* renamed from: f  reason: collision with root package name */
        public int f4146f = -1;

        /* renamed from: f0  reason: collision with root package name */
        boolean f4147f0 = true;

        /* renamed from: g  reason: collision with root package name */
        public int f4148g = -1;

        /* renamed from: g0  reason: collision with root package name */
        boolean f4149g0 = false;

        /* renamed from: h  reason: collision with root package name */
        public int f4150h = -1;

        /* renamed from: h0  reason: collision with root package name */
        boolean f4151h0 = false;

        /* renamed from: i  reason: collision with root package name */
        public int f4152i = -1;

        /* renamed from: i0  reason: collision with root package name */
        boolean f4153i0 = false;

        /* renamed from: j  reason: collision with root package name */
        public int f4154j = -1;

        /* renamed from: j0  reason: collision with root package name */
        boolean f4155j0 = false;

        /* renamed from: k  reason: collision with root package name */
        public int f4156k = -1;

        /* renamed from: k0  reason: collision with root package name */
        boolean f4157k0 = false;

        /* renamed from: l  reason: collision with root package name */
        public int f4158l = -1;

        /* renamed from: l0  reason: collision with root package name */
        int f4159l0 = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f4160m = -1;

        /* renamed from: m0  reason: collision with root package name */
        int f4161m0 = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f4162n = -1;

        /* renamed from: n0  reason: collision with root package name */
        int f4163n0 = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f4164o = -1;

        /* renamed from: o0  reason: collision with root package name */
        int f4165o0 = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f4166p = -1;

        /* renamed from: p0  reason: collision with root package name */
        int f4167p0 = Integer.MIN_VALUE;

        /* renamed from: q  reason: collision with root package name */
        public int f4168q = 0;

        /* renamed from: q0  reason: collision with root package name */
        int f4169q0 = Integer.MIN_VALUE;

        /* renamed from: r  reason: collision with root package name */
        public float f4170r = 0.0f;

        /* renamed from: r0  reason: collision with root package name */
        float f4171r0 = 0.5f;

        /* renamed from: s  reason: collision with root package name */
        public int f4172s = -1;

        /* renamed from: s0  reason: collision with root package name */
        int f4173s0;

        /* renamed from: t  reason: collision with root package name */
        public int f4174t = -1;

        /* renamed from: t0  reason: collision with root package name */
        int f4175t0;

        /* renamed from: u  reason: collision with root package name */
        public int f4176u = -1;

        /* renamed from: u0  reason: collision with root package name */
        float f4177u0;

        /* renamed from: v  reason: collision with root package name */
        public int f4178v = -1;

        /* renamed from: v0  reason: collision with root package name */
        ConstraintWidget f4179v0 = new ConstraintWidget();

        /* renamed from: w  reason: collision with root package name */
        public int f4180w = Integer.MIN_VALUE;

        /* renamed from: w0  reason: collision with root package name */
        public boolean f4181w0 = false;

        /* renamed from: x  reason: collision with root package name */
        public int f4182x = Integer.MIN_VALUE;

        /* renamed from: y  reason: collision with root package name */
        public int f4183y = Integer.MIN_VALUE;

        /* renamed from: z  reason: collision with root package name */
        public int f4184z = Integer.MIN_VALUE;

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f4185a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f4185a = sparseIntArray;
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(h.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(h.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = a.f4185a.get(index);
                switch (i11) {
                    case 1:
                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f4166p);
                        this.f4166p = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.f4166p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.f4168q = obtainStyledAttributes.getDimensionPixelSize(index, this.f4168q);
                        break;
                    case 4:
                        float f10 = obtainStyledAttributes.getFloat(index, this.f4170r) % 360.0f;
                        this.f4170r = f10;
                        if (f10 >= 0.0f) {
                            break;
                        } else {
                            this.f4170r = (360.0f - f10) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f4136a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4136a);
                        break;
                    case 6:
                        this.f4138b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4138b);
                        break;
                    case 7:
                        this.f4140c = obtainStyledAttributes.getFloat(index, this.f4140c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f4144e);
                        this.f4144e = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.f4144e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f4146f);
                        this.f4146f = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.f4146f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f4148g);
                        this.f4148g = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.f4148g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f4150h);
                        this.f4150h = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.f4150h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f4152i);
                        this.f4152i = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.f4152i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f4154j);
                        this.f4154j = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.f4154j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f4156k);
                        this.f4156k = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.f4156k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f4158l);
                        this.f4158l = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.f4158l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f4160m);
                        this.f4160m = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.f4160m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f4172s);
                        this.f4172s = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.f4172s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f4174t);
                        this.f4174t = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.f4174t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f4176u);
                        this.f4176u = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.f4176u = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f4178v);
                        this.f4178v = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.f4178v = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.f4180w = obtainStyledAttributes.getDimensionPixelSize(index, this.f4180w);
                        break;
                    case 22:
                        this.f4182x = obtainStyledAttributes.getDimensionPixelSize(index, this.f4182x);
                        break;
                    case 23:
                        this.f4183y = obtainStyledAttributes.getDimensionPixelSize(index, this.f4183y);
                        break;
                    case 24:
                        this.f4184z = obtainStyledAttributes.getDimensionPixelSize(index, this.f4184z);
                        break;
                    case 25:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.f4137a0 = obtainStyledAttributes.getBoolean(index, this.f4137a0);
                        break;
                    case 28:
                        this.f4139b0 = obtainStyledAttributes.getBoolean(index, this.f4139b0);
                        break;
                    case 29:
                        this.G = obtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 30:
                        this.H = obtainStyledAttributes.getFloat(index, this.H);
                        break;
                    case 31:
                        this.P = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.Q = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.R) != -2) {
                                break;
                            } else {
                                this.R = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.T) != -2) {
                                break;
                            } else {
                                this.T = -2;
                                break;
                            }
                        }
                    case 35:
                        this.V = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    case 36:
                        try {
                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.S) != -2) {
                                break;
                            } else {
                                this.S = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.U) != -2) {
                                break;
                            } else {
                                this.U = -2;
                                break;
                            }
                        }
                    case 38:
                        this.W = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                c.B(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.L = obtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 46:
                                this.M = obtainStyledAttributes.getFloat(index, this.M);
                                break;
                            case 47:
                                this.N = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.O = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.X = obtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case 50:
                                this.Y = obtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                                break;
                            case 51:
                                this.f4141c0 = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f4162n);
                                this.f4162n = resourceId15;
                                if (resourceId15 != -1) {
                                    break;
                                } else {
                                    this.f4162n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f4164o);
                                this.f4164o = resourceId16;
                                if (resourceId16 != -1) {
                                    break;
                                } else {
                                    this.f4164o = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 54:
                                this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        c.z(this, obtainStyledAttributes, index, 0);
                                        this.E = true;
                                        break;
                                    case 65:
                                        c.z(this, obtainStyledAttributes, index, 1);
                                        this.F = true;
                                        break;
                                    case 66:
                                        this.f4143d0 = obtainStyledAttributes.getInt(index, this.f4143d0);
                                        break;
                                    case 67:
                                        this.f4142d = obtainStyledAttributes.getBoolean(index, this.f4142d);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f4151h0 = false;
            this.f4145e0 = true;
            this.f4147f0 = true;
            int i10 = this.width;
            if (i10 == -2 && this.f4137a0) {
                this.f4145e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i11 = this.height;
            if (i11 == -2 && this.f4139b0) {
                this.f4147f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f4145e0 = false;
                if (i10 == 0 && this.P == 1) {
                    this.width = -2;
                    this.f4137a0 = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f4147f0 = false;
                if (i11 == 0 && this.Q == 1) {
                    this.height = -2;
                    this.f4139b0 = true;
                }
            }
            if (this.f4140c != -1.0f || this.f4136a != -1 || this.f4138b != -1) {
                this.f4151h0 = true;
                this.f4145e0 = true;
                this.f4147f0 = true;
                if (!(this.f4179v0 instanceof f)) {
                    this.f4179v0 = new f();
                }
                ((f) this.f4179v0).A1(this.Z);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r11) {
            /*
                r10 = this;
                int r0 = r10.leftMargin
                int r1 = r10.rightMargin
                super.resolveLayoutDirection(r11)
                int r11 = r10.getLayoutDirection()
                r2 = 0
                r3 = 1
                if (r3 != r11) goto L_0x0011
                r11 = r3
                goto L_0x0012
            L_0x0011:
                r11 = r2
            L_0x0012:
                r4 = -1
                r10.f4163n0 = r4
                r10.f4165o0 = r4
                r10.f4159l0 = r4
                r10.f4161m0 = r4
                int r5 = r10.f4180w
                r10.f4167p0 = r5
                int r5 = r10.f4183y
                r10.f4169q0 = r5
                float r5 = r10.G
                r10.f4171r0 = r5
                int r6 = r10.f4136a
                r10.f4173s0 = r6
                int r7 = r10.f4138b
                r10.f4175t0 = r7
                float r8 = r10.f4140c
                r10.f4177u0 = r8
                r9 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r11 == 0) goto L_0x0094
                int r11 = r10.f4172s
                if (r11 == r4) goto L_0x003f
                r10.f4163n0 = r11
            L_0x003d:
                r2 = r3
                goto L_0x0046
            L_0x003f:
                int r11 = r10.f4174t
                if (r11 == r4) goto L_0x0046
                r10.f4165o0 = r11
                goto L_0x003d
            L_0x0046:
                int r11 = r10.f4176u
                if (r11 == r4) goto L_0x004d
                r10.f4161m0 = r11
                r2 = r3
            L_0x004d:
                int r11 = r10.f4178v
                if (r11 == r4) goto L_0x0054
                r10.f4159l0 = r11
                r2 = r3
            L_0x0054:
                int r11 = r10.A
                if (r11 == r9) goto L_0x005a
                r10.f4169q0 = r11
            L_0x005a:
                int r11 = r10.B
                if (r11 == r9) goto L_0x0060
                r10.f4167p0 = r11
            L_0x0060:
                r11 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x0068
                float r2 = r11 - r5
                r10.f4171r0 = r2
            L_0x0068:
                boolean r2 = r10.f4151h0
                if (r2 == 0) goto L_0x00b8
                int r2 = r10.Z
                if (r2 != r3) goto L_0x00b8
                boolean r2 = r10.f4142d
                if (r2 == 0) goto L_0x00b8
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x0082
                float r11 = r11 - r8
                r10.f4177u0 = r11
                r10.f4173s0 = r4
                r10.f4175t0 = r4
                goto L_0x00b8
            L_0x0082:
                if (r6 == r4) goto L_0x008b
                r10.f4175t0 = r6
                r10.f4173s0 = r4
                r10.f4177u0 = r2
                goto L_0x00b8
            L_0x008b:
                if (r7 == r4) goto L_0x00b8
                r10.f4173s0 = r7
                r10.f4175t0 = r4
                r10.f4177u0 = r2
                goto L_0x00b8
            L_0x0094:
                int r11 = r10.f4172s
                if (r11 == r4) goto L_0x009a
                r10.f4161m0 = r11
            L_0x009a:
                int r11 = r10.f4174t
                if (r11 == r4) goto L_0x00a0
                r10.f4159l0 = r11
            L_0x00a0:
                int r11 = r10.f4176u
                if (r11 == r4) goto L_0x00a6
                r10.f4163n0 = r11
            L_0x00a6:
                int r11 = r10.f4178v
                if (r11 == r4) goto L_0x00ac
                r10.f4165o0 = r11
            L_0x00ac:
                int r11 = r10.A
                if (r11 == r9) goto L_0x00b2
                r10.f4167p0 = r11
            L_0x00b2:
                int r11 = r10.B
                if (r11 == r9) goto L_0x00b8
                r10.f4169q0 = r11
            L_0x00b8:
                int r11 = r10.f4176u
                if (r11 != r4) goto L_0x0102
                int r11 = r10.f4178v
                if (r11 != r4) goto L_0x0102
                int r11 = r10.f4174t
                if (r11 != r4) goto L_0x0102
                int r11 = r10.f4172s
                if (r11 != r4) goto L_0x0102
                int r11 = r10.f4148g
                if (r11 == r4) goto L_0x00d7
                r10.f4163n0 = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e5
                if (r1 <= 0) goto L_0x00e5
                r10.rightMargin = r1
                goto L_0x00e5
            L_0x00d7:
                int r11 = r10.f4150h
                if (r11 == r4) goto L_0x00e5
                r10.f4165o0 = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e5
                if (r1 <= 0) goto L_0x00e5
                r10.rightMargin = r1
            L_0x00e5:
                int r11 = r10.f4144e
                if (r11 == r4) goto L_0x00f4
                r10.f4159l0 = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                r10.leftMargin = r0
                goto L_0x0102
            L_0x00f4:
                int r11 = r10.f4146f
                if (r11 == r4) goto L_0x0102
                r10.f4161m0 = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                r10.leftMargin = r0
            L_0x0102:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(int i10, int i11) {
            super(i10, i11);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
