package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.core.view.h0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public class ViewPager extends ViewGroup {

    /* renamed from: o0  reason: collision with root package name */
    static final int[] f7166o0 = {16842931};

    /* renamed from: p0  reason: collision with root package name */
    private static final Comparator<f> f7167p0 = new a();

    /* renamed from: q0  reason: collision with root package name */
    private static final Interpolator f7168q0 = new b();

    /* renamed from: r0  reason: collision with root package name */
    private static final n f7169r0 = new n();
    private boolean B;
    private boolean C;
    private boolean D;
    private int E = 1;
    private boolean F;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private float K;
    private float L;
    private float M;
    private float N;
    private int O = -1;
    private VelocityTracker P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private EdgeEffect V;
    private EdgeEffect W;

    /* renamed from: a  reason: collision with root package name */
    private int f7170a;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f7171a0 = true;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<f> f7172b = new ArrayList<>();

    /* renamed from: b0  reason: collision with root package name */
    private boolean f7173b0 = false;

    /* renamed from: c  reason: collision with root package name */
    private final f f7174c = new f();

    /* renamed from: c0  reason: collision with root package name */
    private boolean f7175c0;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f7176d = new Rect();

    /* renamed from: d0  reason: collision with root package name */
    private int f7177d0;

    /* renamed from: e  reason: collision with root package name */
    a f7178e;

    /* renamed from: e0  reason: collision with root package name */
    private List<j> f7179e0;

    /* renamed from: f  reason: collision with root package name */
    int f7180f;

    /* renamed from: f0  reason: collision with root package name */
    private j f7181f0;

    /* renamed from: g  reason: collision with root package name */
    private int f7182g = -1;

    /* renamed from: g0  reason: collision with root package name */
    private j f7183g0;

    /* renamed from: h  reason: collision with root package name */
    private Parcelable f7184h = null;

    /* renamed from: h0  reason: collision with root package name */
    private List<i> f7185h0;

    /* renamed from: i0  reason: collision with root package name */
    private k f7186i0;

    /* renamed from: j  reason: collision with root package name */
    private ClassLoader f7187j = null;

    /* renamed from: j0  reason: collision with root package name */
    private int f7188j0;

    /* renamed from: k  reason: collision with root package name */
    private Scroller f7189k;

    /* renamed from: k0  reason: collision with root package name */
    private int f7190k0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7191l;

    /* renamed from: l0  reason: collision with root package name */
    private ArrayList<View> f7192l0;

    /* renamed from: m  reason: collision with root package name */
    private l f7193m;

    /* renamed from: m0  reason: collision with root package name */
    private final Runnable f7194m0 = new c();

    /* renamed from: n  reason: collision with root package name */
    private int f7195n;

    /* renamed from: n0  reason: collision with root package name */
    private int f7196n0 = 0;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f7197p;

    /* renamed from: q  reason: collision with root package name */
    private int f7198q;

    /* renamed from: t  reason: collision with root package name */
    private int f7199t;

    /* renamed from: w  reason: collision with root package name */
    private float f7200w = -3.4028235E38f;

    /* renamed from: x  reason: collision with root package name */
    private float f7201x = Float.MAX_VALUE;

    /* renamed from: y  reason: collision with root package name */
    private int f7202y;

    /* renamed from: z  reason: collision with root package name */
    private int f7203z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f7204c;

        /* renamed from: d  reason: collision with root package name */
        Parcelable f7205d;

        /* renamed from: e  reason: collision with root package name */
        ClassLoader f7206e;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f7204c + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f7204c);
            parcel.writeParcelable(this.f7205d, i10);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f7204c = parcel.readInt();
            this.f7205d = parcel.readParcelable(classLoader);
            this.f7206e = classLoader;
        }
    }

    static class a implements Comparator<f> {
        a() {
        }

        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.f7211b - fVar2.f7211b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.E();
        }
    }

    class d implements h0 {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f7208a = new Rect();

        d() {
        }

        public k2 a(View view, k2 k2Var) {
            k2 e02 = n0.e0(view, k2Var);
            if (e02.n()) {
                return e02;
            }
            Rect rect = this.f7208a;
            rect.left = e02.i();
            rect.top = e02.k();
            rect.right = e02.j();
            rect.bottom = e02.h();
            int childCount = ViewPager.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                k2 g10 = n0.g(ViewPager.this.getChildAt(i10), e02);
                rect.left = Math.min(g10.i(), rect.left);
                rect.top = Math.min(g10.k(), rect.top);
                rect.right = Math.min(g10.j(), rect.right);
                rect.bottom = Math.min(g10.h(), rect.bottom);
            }
            return e02.o(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {

        /* renamed from: a  reason: collision with root package name */
        Object f7210a;

        /* renamed from: b  reason: collision with root package name */
        int f7211b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7212c;

        /* renamed from: d  reason: collision with root package name */
        float f7213d;

        /* renamed from: e  reason: collision with root package name */
        float f7214e;

        f() {
        }
    }

    class h extends androidx.core.view.a {
        h() {
        }

        private boolean n() {
            a aVar = ViewPager.this.f7178e;
            return aVar != null && aVar.e() > 1;
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() == 4096 && (aVar = ViewPager.this.f7178e) != null) {
                accessibilityEvent.setItemCount(aVar.e());
                accessibilityEvent.setFromIndex(ViewPager.this.f7180f);
                accessibilityEvent.setToIndex(ViewPager.this.f7180f);
            }
        }

        public void g(View view, androidx.core.view.accessibility.k kVar) {
            super.g(view, kVar);
            kVar.a0(ViewPager.class.getName());
            kVar.u0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                kVar.a(Opcodes.ACC_SYNTHETIC);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                kVar.a(8192);
            }
        }

        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            if (i10 != 4096) {
                if (i10 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f7180f - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f7180f + 1);
                return true;
            }
        }
    }

    public interface i {
        void a(@NonNull ViewPager viewPager, a aVar, a aVar2);
    }

    public interface j {
        void S(int i10, float f10, int i11);

        void m0(int i10);

        void q(int i10);
    }

    public interface k {
        void a(@NonNull View view, float f10);
    }

    private class l extends DataSetObserver {
        l() {
        }

        public void onChanged() {
            ViewPager.this.h();
        }

        public void onInvalidated() {
            ViewPager.this.h();
        }
    }

    public static class m implements j {
        public void S(int i10, float f10, int i11) {
        }

        public void m0(int i10) {
        }
    }

    static class n implements Comparator<View> {
        n() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z10 = gVar.f7215a;
            if (z10 == gVar2.f7215a) {
                return gVar.f7219e - gVar2.f7219e;
            }
            if (z10) {
                return 1;
            }
            return -1;
        }
    }

    public ViewPager(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v();
    }

    private boolean C(int i10) {
        if (this.f7172b.size() != 0) {
            f t10 = t();
            int clientWidth = getClientWidth();
            int i11 = this.f7195n;
            int i12 = clientWidth + i11;
            float f10 = (float) clientWidth;
            int i13 = t10.f7211b;
            float f11 = ((((float) i10) / f10) - t10.f7214e) / (t10.f7213d + (((float) i11) / f10));
            this.f7175c0 = false;
            y(i13, f11, (int) (((float) i12) * f11));
            if (this.f7175c0) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f7171a0) {
            return false;
        } else {
            this.f7175c0 = false;
            y(0, 0.0f, 0);
            if (this.f7175c0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean D(float f10) {
        boolean z10;
        boolean z11;
        float f11 = this.K - f10;
        this.K = f10;
        float scrollX = ((float) getScrollX()) + f11;
        float clientWidth = (float) getClientWidth();
        float f12 = this.f7200w * clientWidth;
        float f13 = this.f7201x * clientWidth;
        boolean z12 = false;
        f fVar = this.f7172b.get(0);
        ArrayList<f> arrayList = this.f7172b;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f7211b != 0) {
            f12 = fVar.f7214e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (fVar2.f7211b != this.f7178e.e() - 1) {
            f13 = fVar2.f7214e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f12) {
            if (z10) {
                this.V.onPull(Math.abs(f12 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f12;
        } else if (scrollX > f13) {
            if (z11) {
                this.W.onPull(Math.abs(scrollX - f13) / clientWidth);
                z12 = true;
            }
            scrollX = f13;
        }
        int i10 = (int) scrollX;
        this.K += scrollX - ((float) i10);
        scrollTo(i10, getScrollY());
        C(i10);
        return z12;
    }

    private void G(int i10, int i11, int i12, int i13) {
        float f10;
        if (i11 <= 0 || this.f7172b.isEmpty()) {
            f u10 = u(this.f7180f);
            if (u10 != null) {
                f10 = Math.min(u10.f7214e, this.f7201x);
            } else {
                f10 = 0.0f;
            }
            int paddingLeft = (int) (f10 * ((float) ((i10 - getPaddingLeft()) - getPaddingRight())));
            if (paddingLeft != getScrollX()) {
                g(false);
                scrollTo(paddingLeft, getScrollY());
            }
        } else if (!this.f7189k.isFinished()) {
            this.f7189k.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i11 - getPaddingLeft()) - getPaddingRight()) + i13))) * ((float) (((i10 - getPaddingLeft()) - getPaddingRight()) + i12))), getScrollY());
        }
    }

    private void H() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((g) getChildAt(i10).getLayoutParams()).f7215a) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void K(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private boolean L() {
        this.O = -1;
        o();
        this.V.onRelease();
        this.W.onRelease();
        if (this.V.isFinished() || this.W.isFinished()) {
            return true;
        }
        return false;
    }

    private void M(int i10, boolean z10, int i11, boolean z11) {
        int i12;
        f u10 = u(i10);
        if (u10 != null) {
            i12 = (int) (((float) getClientWidth()) * Math.max(this.f7200w, Math.min(u10.f7214e, this.f7201x)));
        } else {
            i12 = 0;
        }
        if (z10) {
            Q(i12, 0, i11);
            if (z11) {
                k(i10);
                return;
            }
            return;
        }
        if (z11) {
            k(i10);
        }
        g(false);
        scrollTo(i12, 0);
        C(i12);
    }

    private void R() {
        if (this.f7190k0 != 0) {
            ArrayList<View> arrayList = this.f7192l0;
            if (arrayList == null) {
                this.f7192l0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f7192l0.add(getChildAt(i10));
            }
            Collections.sort(this.f7192l0, f7169r0);
        }
    }

    private void e(f fVar, int i10, f fVar2) {
        float f10;
        float f11;
        float f12;
        int i11;
        int i12;
        f fVar3;
        f fVar4;
        int e10 = this.f7178e.e();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f10 = ((float) this.f7195n) / ((float) clientWidth);
        } else {
            f10 = 0.0f;
        }
        if (fVar2 != null) {
            int i13 = fVar2.f7211b;
            int i14 = fVar.f7211b;
            if (i13 < i14) {
                float f13 = fVar2.f7214e + fVar2.f7213d + f10;
                int i15 = i13 + 1;
                int i16 = 0;
                while (i15 <= fVar.f7211b && i16 < this.f7172b.size()) {
                    Object obj = this.f7172b.get(i16);
                    while (true) {
                        fVar4 = (f) obj;
                        if (i15 > fVar4.f7211b && i16 < this.f7172b.size() - 1) {
                            i16++;
                            obj = this.f7172b.get(i16);
                        }
                    }
                    while (i15 < fVar4.f7211b) {
                        f13 += this.f7178e.h(i15) + f10;
                        i15++;
                    }
                    fVar4.f7214e = f13;
                    f13 += fVar4.f7213d + f10;
                    i15++;
                }
            } else if (i13 > i14) {
                int size = this.f7172b.size() - 1;
                float f14 = fVar2.f7214e;
                while (true) {
                    i13--;
                    if (i13 < fVar.f7211b || size < 0) {
                        break;
                    }
                    Object obj2 = this.f7172b.get(size);
                    while (true) {
                        fVar3 = (f) obj2;
                        if (i13 < fVar3.f7211b && size > 0) {
                            size--;
                            obj2 = this.f7172b.get(size);
                        }
                    }
                    while (i13 > fVar3.f7211b) {
                        f14 -= this.f7178e.h(i13) + f10;
                        i13--;
                    }
                    f14 -= fVar3.f7213d + f10;
                    fVar3.f7214e = f14;
                }
            }
        }
        int size2 = this.f7172b.size();
        float f15 = fVar.f7214e;
        int i17 = fVar.f7211b;
        int i18 = i17 - 1;
        if (i17 == 0) {
            f11 = f15;
        } else {
            f11 = -3.4028235E38f;
        }
        this.f7200w = f11;
        int i19 = e10 - 1;
        if (i17 == i19) {
            f12 = (fVar.f7213d + f15) - 1.0f;
        } else {
            f12 = Float.MAX_VALUE;
        }
        this.f7201x = f12;
        int i20 = i10 - 1;
        while (i20 >= 0) {
            f fVar5 = this.f7172b.get(i20);
            while (true) {
                i12 = fVar5.f7211b;
                if (i18 <= i12) {
                    break;
                }
                f15 -= this.f7178e.h(i18) + f10;
                i18--;
            }
            f15 -= fVar5.f7213d + f10;
            fVar5.f7214e = f15;
            if (i12 == 0) {
                this.f7200w = f15;
            }
            i20--;
            i18--;
        }
        float f16 = fVar.f7214e + fVar.f7213d + f10;
        int i21 = fVar.f7211b + 1;
        int i22 = i10 + 1;
        while (i22 < size2) {
            f fVar6 = this.f7172b.get(i22);
            while (true) {
                i11 = fVar6.f7211b;
                if (i21 >= i11) {
                    break;
                }
                f16 += this.f7178e.h(i21) + f10;
                i21++;
            }
            if (i11 == i19) {
                this.f7201x = (fVar6.f7213d + f16) - 1.0f;
            }
            fVar6.f7214e = f16;
            f16 += fVar6.f7213d + f10;
            i22++;
            i21++;
        }
        this.f7173b0 = false;
    }

    private void g(boolean z10) {
        boolean z11;
        if (this.f7196n0 == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            setScrollingCacheEnabled(false);
            if (!this.f7189k.isFinished()) {
                this.f7189k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f7189k.getCurrX();
                int currY = this.f7189k.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        C(currX);
                    }
                }
            }
        }
        this.D = false;
        for (int i10 = 0; i10 < this.f7172b.size(); i10++) {
            f fVar = this.f7172b.get(i10);
            if (fVar.f7212c) {
                fVar.f7212c = false;
                z11 = true;
            }
        }
        if (!z11) {
            return;
        }
        if (z10) {
            n0.k0(this, this.f7194m0);
        } else {
            this.f7194m0.run();
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int i(int i10, float f10, int i11, int i12) {
        float f11;
        if (Math.abs(i12) <= this.S || Math.abs(i11) <= this.Q) {
            if (i10 >= this.f7180f) {
                f11 = 0.4f;
            } else {
                f11 = 0.6f;
            }
            i10 += (int) (f10 + f11);
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.f7172b.size() <= 0) {
            return i10;
        }
        ArrayList<f> arrayList = this.f7172b;
        return Math.max(this.f7172b.get(0).f7211b, Math.min(i10, arrayList.get(arrayList.size() - 1).f7211b));
    }

    private void j(int i10, float f10, int i11) {
        j jVar = this.f7181f0;
        if (jVar != null) {
            jVar.S(i10, f10, i11);
        }
        List<j> list = this.f7179e0;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                j jVar2 = this.f7179e0.get(i12);
                if (jVar2 != null) {
                    jVar2.S(i10, f10, i11);
                }
            }
        }
        j jVar3 = this.f7183g0;
        if (jVar3 != null) {
            jVar3.S(i10, f10, i11);
        }
    }

    private void k(int i10) {
        j jVar = this.f7181f0;
        if (jVar != null) {
            jVar.q(i10);
        }
        List<j> list = this.f7179e0;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.f7179e0.get(i11);
                if (jVar2 != null) {
                    jVar2.q(i10);
                }
            }
        }
        j jVar3 = this.f7183g0;
        if (jVar3 != null) {
            jVar3.q(i10);
        }
    }

    private void l(int i10) {
        j jVar = this.f7181f0;
        if (jVar != null) {
            jVar.m0(i10);
        }
        List<j> list = this.f7179e0;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.f7179e0.get(i11);
                if (jVar2 != null) {
                    jVar2.m0(i10);
                }
            }
        }
        j jVar3 = this.f7183g0;
        if (jVar3 != null) {
            jVar3.m0(i10);
        }
    }

    private void n(boolean z10) {
        int i10;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (z10) {
                i10 = this.f7188j0;
            } else {
                i10 = 0;
            }
            getChildAt(i11).setLayerType(i10, (Paint) null);
        }
    }

    private void o() {
        this.F = false;
        this.G = false;
        VelocityTracker velocityTracker = this.P;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.P = null;
        }
    }

    private Rect q(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.C != z10) {
            this.C = z10;
        }
    }

    private f t() {
        float f10;
        float f11;
        int i10;
        int clientWidth = getClientWidth();
        float f12 = 0.0f;
        if (clientWidth > 0) {
            f10 = ((float) getScrollX()) / ((float) clientWidth);
        } else {
            f10 = 0.0f;
        }
        if (clientWidth > 0) {
            f11 = ((float) this.f7195n) / ((float) clientWidth);
        } else {
            f11 = 0.0f;
        }
        f fVar = null;
        int i11 = 0;
        int i12 = -1;
        boolean z10 = true;
        float f13 = 0.0f;
        while (i11 < this.f7172b.size()) {
            f fVar2 = this.f7172b.get(i11);
            if (!z10 && fVar2.f7211b != (i10 = i12 + 1)) {
                fVar2 = this.f7174c;
                fVar2.f7214e = f12 + f13 + f11;
                fVar2.f7211b = i10;
                fVar2.f7213d = this.f7178e.h(i10);
                i11--;
            }
            f12 = fVar2.f7214e;
            float f14 = fVar2.f7213d + f12 + f11;
            if (!z10 && f10 < f12) {
                return fVar;
            }
            if (f10 < f14 || i11 == this.f7172b.size() - 1) {
                return fVar2;
            }
            i12 = fVar2.f7211b;
            f13 = fVar2.f7213d;
            i11++;
            z10 = false;
            fVar = fVar2;
        }
        return fVar;
    }

    private static boolean w(@NonNull View view) {
        if (view.getClass().getAnnotation(e.class) != null) {
            return true;
        }
        return false;
    }

    private boolean x(float f10, float f11) {
        return (f10 < ((float) this.I) && f11 > 0.0f) || (f10 > ((float) (getWidth() - this.I)) && f11 < 0.0f);
    }

    private void z(MotionEvent motionEvent) {
        int i10;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O) {
            if (actionIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.K = motionEvent.getX(i10);
            this.O = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.P;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        int i10 = this.f7180f;
        if (i10 <= 0) {
            return false;
        }
        N(i10 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        a aVar = this.f7178e;
        if (aVar == null || this.f7180f >= aVar.e() - 1) {
            return false;
        }
        N(this.f7180f + 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void E() {
        F(this.f7180f);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.f7180f
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$f r2 = r0.u(r2)
            r0.f7180f = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.a r1 = r0.f7178e
            if (r1 != 0) goto L_0x0018
            r17.R()
            return
        L_0x0018:
            boolean r1 = r0.D
            if (r1 == 0) goto L_0x0020
            r17.R()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.viewpager.widget.a r1 = r0.f7178e
            r1.s(r0)
            int r1 = r0.E
            int r4 = r0.f7180f
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.a r6 = r0.f7178e
            int r6 = r6.e()
            int r7 = r6 + -1
            int r8 = r0.f7180f
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.f7170a
            if (r6 != r7) goto L_0x020e
            r7 = r5
        L_0x004a:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r8 = r0.f7172b
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x0066
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r8 = r0.f7172b
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$f r8 = (androidx.viewpager.widget.ViewPager.f) r8
            int r9 = r8.f7211b
            int r10 = r0.f7180f
            if (r9 < r10) goto L_0x0063
            if (r9 != r10) goto L_0x0066
            goto L_0x0067
        L_0x0063:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0066:
            r8 = 0
        L_0x0067:
            if (r8 != 0) goto L_0x0071
            if (r6 <= 0) goto L_0x0071
            int r8 = r0.f7180f
            androidx.viewpager.widget.ViewPager$f r8 = r0.a(r8, r7)
        L_0x0071:
            r9 = 0
            if (r8 == 0) goto L_0x019b
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0081
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r11 = r0.f7172b
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$f r11 = (androidx.viewpager.widget.ViewPager.f) r11
            goto L_0x0082
        L_0x0081:
            r11 = 0
        L_0x0082:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x008c
            r14 = r9
            goto L_0x0098
        L_0x008c:
            float r14 = r8.f7213d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r14 = r14 + r15
        L_0x0098:
            int r3 = r0.f7180f
            int r3 = r3 + -1
            r15 = r9
        L_0x009d:
            if (r3 < 0) goto L_0x00fd
            int r16 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00cb
            if (r3 >= r4) goto L_0x00cb
            if (r11 != 0) goto L_0x00a8
            goto L_0x00fd
        L_0x00a8:
            int r5 = r11.f7211b
            if (r3 != r5) goto L_0x00f9
            boolean r5 = r11.f7212c
            if (r5 != 0) goto L_0x00f9
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            r5.remove(r10)
            androidx.viewpager.widget.a r5 = r0.f7178e
            java.lang.Object r11 = r11.f7210a
            r5.b(r0, r3, r11)
            int r10 = r10 + -1
            int r7 = r7 + -1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x00f8
        L_0x00cb:
            if (r11 == 0) goto L_0x00e1
            int r5 = r11.f7211b
            if (r3 != r5) goto L_0x00e1
            float r5 = r11.f7213d
            float r15 = r15 + r5
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x00f8
        L_0x00e1:
            int r5 = r10 + 1
            androidx.viewpager.widget.ViewPager$f r5 = r0.a(r3, r5)
            float r5 = r5.f7213d
            float r15 = r15 + r5
            int r7 = r7 + 1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x00f8
        L_0x00f7:
            r5 = 0
        L_0x00f8:
            r11 = r5
        L_0x00f9:
            int r3 = r3 + -1
            r5 = 0
            goto L_0x009d
        L_0x00fd:
            float r3 = r8.f7213d
            int r4 = r7 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x018f
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0116
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x0117
        L_0x0116:
            r5 = 0
        L_0x0117:
            if (r12 > 0) goto L_0x011b
            r10 = r9
            goto L_0x0123
        L_0x011b:
            int r10 = r17.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r12
            float r10 = r10 / r11
            float r10 = r10 + r13
        L_0x0123:
            int r11 = r0.f7180f
        L_0x0125:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x018f
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x0159
            if (r11 <= r1) goto L_0x0159
            if (r5 != 0) goto L_0x0132
            goto L_0x018f
        L_0x0132:
            int r12 = r5.f7211b
            if (r11 != r12) goto L_0x018e
            boolean r12 = r5.f7212c
            if (r12 != 0) goto L_0x018e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r12 = r0.f7172b
            r12.remove(r4)
            androidx.viewpager.widget.a r12 = r0.f7178e
            java.lang.Object r5 = r5.f7210a
            r12.b(r0, r11, r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x018e
        L_0x0157:
            r5 = 0
            goto L_0x018e
        L_0x0159:
            if (r5 == 0) goto L_0x0175
            int r12 = r5.f7211b
            if (r11 != r12) goto L_0x0175
            float r5 = r5.f7213d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x018e
        L_0x0175:
            androidx.viewpager.widget.ViewPager$f r5 = r0.a(r11, r4)
            int r4 = r4 + 1
            float r5 = r5.f7213d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
        L_0x018e:
            goto L_0x0125
        L_0x018f:
            r0.e(r8, r7, r2)
            androidx.viewpager.widget.a r1 = r0.f7178e
            int r2 = r0.f7180f
            java.lang.Object r3 = r8.f7210a
            r1.p(r0, r2, r3)
        L_0x019b:
            androidx.viewpager.widget.a r1 = r0.f7178e
            r1.d(r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01a5:
            if (r2 >= r1) goto L_0x01ce
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r4 = (androidx.viewpager.widget.ViewPager.g) r4
            r4.f7220f = r2
            boolean r5 = r4.f7215a
            if (r5 != 0) goto L_0x01cb
            float r5 = r4.f7217c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01cb
            androidx.viewpager.widget.ViewPager$f r3 = r0.s(r3)
            if (r3 == 0) goto L_0x01cb
            float r5 = r3.f7213d
            r4.f7217c = r5
            int r3 = r3.f7211b
            r4.f7219e = r3
        L_0x01cb:
            int r2 = r2 + 1
            goto L_0x01a5
        L_0x01ce:
            r17.R()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x020d
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01e2
            androidx.viewpager.widget.ViewPager$f r3 = r0.r(r1)
            goto L_0x01e3
        L_0x01e2:
            r3 = 0
        L_0x01e3:
            if (r3 == 0) goto L_0x01eb
            int r1 = r3.f7211b
            int r2 = r0.f7180f
            if (r1 == r2) goto L_0x020d
        L_0x01eb:
            r5 = 0
        L_0x01ec:
            int r1 = r17.getChildCount()
            if (r5 >= r1) goto L_0x020d
            android.view.View r1 = r0.getChildAt(r5)
            androidx.viewpager.widget.ViewPager$f r2 = r0.s(r1)
            if (r2 == 0) goto L_0x020a
            int r2 = r2.f7211b
            int r3 = r0.f7180f
            if (r2 != r3) goto L_0x020a
            r2 = 2
            boolean r1 = r1.requestFocus(r2)
            if (r1 == 0) goto L_0x020a
            goto L_0x020d
        L_0x020a:
            int r5 = r5 + 1
            goto L_0x01ec
        L_0x020d:
            return
        L_0x020e:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x021b }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x021b }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x021b }
            goto L_0x0223
        L_0x021b:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0223:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.f7170a
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.a r1 = r0.f7178e
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.F(int):void");
    }

    public void I(@NonNull i iVar) {
        List<i> list = this.f7185h0;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void J(@NonNull j jVar) {
        List<j> list = this.f7179e0;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public void N(int i10, boolean z10) {
        this.D = false;
        O(i10, z10, false);
    }

    /* access modifiers changed from: package-private */
    public void O(int i10, boolean z10, boolean z11) {
        P(i10, z10, z11, 0);
    }

    /* access modifiers changed from: package-private */
    public void P(int i10, boolean z10, boolean z11, int i11) {
        a aVar = this.f7178e;
        boolean z12 = false;
        if (aVar == null || aVar.e() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z11 || this.f7180f != i10 || this.f7172b.size() == 0) {
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 >= this.f7178e.e()) {
                i10 = this.f7178e.e() - 1;
            }
            int i12 = this.E;
            int i13 = this.f7180f;
            if (i10 > i13 + i12 || i10 < i13 - i12) {
                for (int i14 = 0; i14 < this.f7172b.size(); i14++) {
                    this.f7172b.get(i14).f7212c = true;
                }
            }
            if (this.f7180f != i10) {
                z12 = true;
            }
            if (this.f7171a0) {
                this.f7180f = i10;
                if (z12) {
                    k(i10);
                }
                requestLayout();
                return;
            }
            F(i10);
            M(i10, z10, i11, z12);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(int i10, int i11, int i12) {
        boolean z10;
        int i13;
        int i14;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f7189k;
        if (scroller == null || scroller.isFinished()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            if (this.f7191l) {
                i13 = this.f7189k.getCurrX();
            } else {
                i13 = this.f7189k.getStartX();
            }
            this.f7189k.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i13 = getScrollX();
        }
        int i15 = i13;
        int scrollY = getScrollY();
        int i16 = i10 - i15;
        int i17 = i11 - scrollY;
        if (i16 == 0 && i17 == 0) {
            g(false);
            E();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i18 = clientWidth / 2;
        float f10 = (float) clientWidth;
        float f11 = (float) i18;
        float m10 = f11 + (m(Math.min(1.0f, (((float) Math.abs(i16)) * 1.0f) / f10)) * f11);
        int abs = Math.abs(i12);
        if (abs > 0) {
            i14 = Math.round(Math.abs(m10 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i14 = (int) (((((float) Math.abs(i16)) / ((f10 * this.f7178e.h(this.f7180f)) + ((float) this.f7195n))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i14, 600);
        this.f7191l = false;
        this.f7189k.startScroll(i15, scrollY, i16, i17, min);
        n0.j0(this);
    }

    /* access modifiers changed from: package-private */
    public f a(int i10, int i11) {
        f fVar = new f();
        fVar.f7211b = i10;
        fVar.f7210a = this.f7178e.i(this, i10);
        fVar.f7213d = this.f7178e.h(i10);
        if (i11 < 0 || i11 >= this.f7172b.size()) {
            this.f7172b.add(fVar);
        } else {
            this.f7172b.add(i11, fVar);
        }
        return fVar;
    }

    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        f s10;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (s10 = s(childAt)) != null && s10.f7211b == this.f7180f) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i11 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        f s10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (s10 = s(childAt)) != null && s10.f7211b == this.f7180f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean w10 = gVar.f7215a | w(view);
        gVar.f7215a = w10;
        if (!this.B) {
            super.addView(view, i10, layoutParams);
        } else if (!w10) {
            gVar.f7218d = true;
            addViewInLayout(view, i10, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void b(@NonNull i iVar) {
        if (this.f7185h0 == null) {
            this.f7185h0 = new ArrayList();
        }
        this.f7185h0.add(iVar);
    }

    public void c(@NonNull j jVar) {
        if (this.f7179e0 == null) {
            this.f7179e0 = new ArrayList();
        }
        this.f7179e0.add(jVar);
    }

    public boolean canScrollHorizontally(int i10) {
        if (this.f7178e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i10 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.f7200w))) {
                return true;
            }
            return false;
        } else if (i10 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.f7201x))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.f7191l = true;
        if (this.f7189k.isFinished() || !this.f7189k.computeScrollOffset()) {
            g(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f7189k.getCurrX();
        int currY = this.f7189k.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!C(currX)) {
                this.f7189k.abortAnimation();
                scrollTo(0, currY);
            }
        }
        n0.j0(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto L_0x000b
        L_0x0009:
            r0 = r3
            goto L_0x0060
        L_0x000b:
            if (r0 == 0) goto L_0x0060
            android.view.ViewParent r4 = r0.getParent()
        L_0x0011:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x001e
            if (r4 != r6) goto L_0x0019
            r4 = r1
            goto L_0x001f
        L_0x0019:
            android.view.ViewParent r4 = r4.getParent()
            goto L_0x0011
        L_0x001e:
            r4 = r2
        L_0x001f:
            if (r4 != 0) goto L_0x0060
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L_0x0035:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x004e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0035
        L_0x004e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            goto L_0x0009
        L_0x0060:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto L_0x00b1
            if (r3 == r0) goto L_0x00b1
            if (r7 != r5) goto L_0x0091
            android.graphics.Rect r1 = r6.f7176d
            android.graphics.Rect r1 = r6.q(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f7176d
            android.graphics.Rect r2 = r6.q(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x008b
            if (r1 < r2) goto L_0x008b
            boolean r0 = r6.A()
            goto L_0x008f
        L_0x008b:
            boolean r0 = r3.requestFocus()
        L_0x008f:
            r2 = r0
            goto L_0x00c4
        L_0x0091:
            if (r7 != r4) goto L_0x00c4
            android.graphics.Rect r1 = r6.f7176d
            android.graphics.Rect r1 = r6.q(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f7176d
            android.graphics.Rect r2 = r6.q(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x00ac
            if (r1 > r2) goto L_0x00ac
            boolean r0 = r6.B()
            goto L_0x008f
        L_0x00ac:
            boolean r0 = r3.requestFocus()
            goto L_0x008f
        L_0x00b1:
            if (r7 == r5) goto L_0x00c0
            if (r7 != r1) goto L_0x00b6
            goto L_0x00c0
        L_0x00b6:
            if (r7 == r4) goto L_0x00bb
            r0 = 2
            if (r7 != r0) goto L_0x00c4
        L_0x00bb:
            boolean r2 = r6.B()
            goto L_0x00c4
        L_0x00c0:
            boolean r2 = r6.A()
        L_0x00c4:
            if (r2 == 0) goto L_0x00cd
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        L_0x00cd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.d(int):boolean");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || p(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f s10;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (s10 = s(childAt)) != null && s10.f7211b == this.f7180f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z10 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f7178e) != null && aVar.e() > 1)) {
            if (!this.V.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f7200w * ((float) width));
                this.V.setSize(height, width);
                z10 = false | this.V.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.W.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f7201x + 1.0f)) * ((float) width2));
                this.W.setSize(height2, width2);
                z10 |= this.W.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.V.finish();
            this.W.finish();
        }
        if (z10) {
            n0.j0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f7197p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    public boolean f(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom()) {
                    if (f(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z10 || !view.canScrollHorizontally(-i10)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.f7178e;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i10, int i11) {
        if (this.f7190k0 == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((g) this.f7192l0.get(i11).getLayoutParams()).f7220f;
    }

    public int getCurrentItem() {
        return this.f7180f;
    }

    public int getOffscreenPageLimit() {
        return this.E;
    }

    public int getPageMargin() {
        return this.f7195n;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        boolean z10;
        int e10 = this.f7178e.e();
        this.f7170a = e10;
        if (this.f7172b.size() >= (this.E * 2) + 1 || this.f7172b.size() >= e10) {
            z10 = false;
        } else {
            z10 = true;
        }
        int i10 = this.f7180f;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < this.f7172b.size()) {
            f fVar = this.f7172b.get(i11);
            int f10 = this.f7178e.f(fVar.f7210a);
            if (f10 != -1) {
                if (f10 == -2) {
                    this.f7172b.remove(i11);
                    i11--;
                    if (!z11) {
                        this.f7178e.s(this);
                        z11 = true;
                    }
                    this.f7178e.b(this, fVar.f7211b, fVar.f7210a);
                    int i12 = this.f7180f;
                    if (i12 == fVar.f7211b) {
                        i10 = Math.max(0, Math.min(i12, e10 - 1));
                    }
                } else {
                    int i13 = fVar.f7211b;
                    if (i13 != f10) {
                        if (i13 == this.f7180f) {
                            i10 = f10;
                        }
                        fVar.f7211b = f10;
                    }
                }
                z10 = true;
            }
            i11++;
        }
        if (z11) {
            this.f7178e.d(this);
        }
        Collections.sort(this.f7172b, f7167p0);
        if (z10) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                g gVar = (g) getChildAt(i14).getLayoutParams();
                if (!gVar.f7215a) {
                    gVar.f7217c = 0.0f;
                }
            }
            O(i10, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public float m(float f10) {
        return (float) Math.sin((double) ((f10 - 0.5f) * 0.47123894f));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7171a0 = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f7194m0);
        Scroller scroller = this.f7189k;
        if (scroller != null && !scroller.isFinished()) {
            this.f7189k.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r0 = r17
            super.onDraw(r18)
            int r1 = r0.f7195n
            if (r1 <= 0) goto L_0x00a8
            android.graphics.drawable.Drawable r1 = r0.f7197p
            if (r1 == 0) goto L_0x00a8
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r1 = r0.f7172b
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00a8
            androidx.viewpager.widget.a r1 = r0.f7178e
            if (r1 == 0) goto L_0x00a8
            int r1 = r17.getScrollX()
            int r2 = r17.getWidth()
            int r3 = r0.f7195n
            float r3 = (float) r3
            float r4 = (float) r2
            float r3 = r3 / r4
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            float r7 = r5.f7214e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r8 = r0.f7172b
            int r8 = r8.size()
            int r9 = r5.f7211b
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r10 = r0.f7172b
            int r11 = r8 + -1
            java.lang.Object r10 = r10.get(r11)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
            int r10 = r10.f7211b
        L_0x0045:
            if (r9 >= r10) goto L_0x00a8
        L_0x0047:
            int r11 = r5.f7211b
            if (r9 <= r11) goto L_0x0058
            if (r6 >= r8) goto L_0x0058
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.f7172b
            int r6 = r6 + 1
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x0047
        L_0x0058:
            if (r9 != r11) goto L_0x0064
            float r7 = r5.f7214e
            float r11 = r5.f7213d
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r7 = r7 + r11
            float r7 = r7 + r3
            goto L_0x006f
        L_0x0064:
            androidx.viewpager.widget.a r11 = r0.f7178e
            float r11 = r11.h(r9)
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r11 = r11 + r3
            float r7 = r7 + r11
        L_0x006f:
            int r11 = r0.f7195n
            float r11 = (float) r11
            float r11 = r11 + r12
            float r13 = (float) r1
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x0097
            android.graphics.drawable.Drawable r11 = r0.f7197p
            int r13 = java.lang.Math.round(r12)
            int r14 = r0.f7198q
            int r15 = r0.f7195n
            float r15 = (float) r15
            float r15 = r15 + r12
            int r15 = java.lang.Math.round(r15)
            r16 = r3
            int r3 = r0.f7199t
            r11.setBounds(r13, r14, r15, r3)
            android.graphics.drawable.Drawable r3 = r0.f7197p
            r11 = r18
            r3.draw(r11)
            goto L_0x009b
        L_0x0097:
            r11 = r18
            r16 = r3
        L_0x009b:
            int r3 = r1 + r2
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a3
            goto L_0x00a8
        L_0x00a3:
            int r9 = r9 + 1
            r3 = r16
            goto L_0x0045
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f10;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            L();
            return false;
        }
        if (action != 0) {
            if (this.F) {
                return true;
            }
            if (this.G) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.M = x10;
            this.K = x10;
            float y10 = motionEvent.getY();
            this.N = y10;
            this.L = y10;
            this.O = motionEvent2.getPointerId(0);
            this.G = false;
            this.f7191l = true;
            this.f7189k.computeScrollOffset();
            if (this.f7196n0 != 2 || Math.abs(this.f7189k.getFinalX() - this.f7189k.getCurrX()) <= this.T) {
                g(false);
                this.F = false;
            } else {
                this.f7189k.abortAnimation();
                this.D = false;
                E();
                this.F = true;
                K(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.O;
            if (i10 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i10);
                float x11 = motionEvent2.getX(findPointerIndex);
                float f11 = x11 - this.K;
                float abs = Math.abs(f11);
                float y11 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y11 - this.N);
                int i11 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
                if (i11 != 0 && !x(this.K, f11)) {
                    if (f(this, false, (int) f11, (int) x11, (int) y11)) {
                        this.K = x11;
                        this.L = y11;
                        this.G = true;
                        return false;
                    }
                }
                int i12 = this.J;
                if (abs > ((float) i12) && abs * 0.5f > abs2) {
                    this.F = true;
                    K(true);
                    setScrollState(1);
                    float f12 = this.M;
                    float f13 = (float) this.J;
                    if (i11 > 0) {
                        f10 = f12 + f13;
                    } else {
                        f10 = f12 - f13;
                    }
                    this.K = f10;
                    this.L = y11;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i12)) {
                    this.G = true;
                }
                if (this.F && D(x11)) {
                    n0.j0(this);
                }
            }
        } else if (action == 6) {
            z(motionEvent);
        }
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        this.P.addMovement(motionEvent2);
        return this.F;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b6
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b2
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r12 = (androidx.viewpager.widget.ViewPager.g) r12
            boolean r14 = r12.f7215a
            if (r14 == 0) goto L_0x00b2
            int r12 = r12.f7216b
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x005c
            r15 = 3
            if (r14 == r15) goto L_0x0056
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006d
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
            goto L_0x0068
        L_0x0056:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006d
        L_0x005c:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
        L_0x0068:
            r17 = r14
            r14 = r4
            r4 = r17
        L_0x006d:
            r15 = 16
            if (r12 == r15) goto L_0x008e
            r15 = 48
            if (r12 == r15) goto L_0x0088
            r15 = 80
            if (r12 == r15) goto L_0x007b
            r12 = r5
            goto L_0x009f
        L_0x007b:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
            goto L_0x009a
        L_0x0088:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x009f
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
        L_0x009a:
            r17 = r12
            r12 = r5
            r5 = r17
        L_0x009f:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r5 + r16
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b6:
            int r2 = r2 - r4
            int r2 = r2 - r6
            r6 = 0
        L_0x00b9:
            if (r6 >= r1) goto L_0x0106
            android.view.View r8 = r0.getChildAt(r6)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0103
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r9 = (androidx.viewpager.widget.ViewPager.g) r9
            boolean r10 = r9.f7215a
            if (r10 != 0) goto L_0x0103
            androidx.viewpager.widget.ViewPager$f r10 = r0.s(r8)
            if (r10 == 0) goto L_0x0103
            float r13 = (float) r2
            float r10 = r10.f7214e
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r4
            boolean r14 = r9.f7218d
            if (r14 == 0) goto L_0x00f6
            r14 = 0
            r9.f7218d = r14
            float r9 = r9.f7217c
            float r13 = r13 * r9
            int r9 = (int) r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r14 = r3 - r5
            int r14 = r14 - r7
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r8.measure(r9, r13)
        L_0x00f6:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r10
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r5
            r8.layout(r10, r5, r9, r13)
        L_0x0103:
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x0106:
            r0.f7198q = r5
            int r3 = r3 - r7
            r0.f7199t = r3
            r0.f7177d0 = r11
            boolean r1 = r0.f7171a0
            if (r1 == 0) goto L_0x0118
            int r1 = r0.f7180f
            r2 = 0
            r0.M(r1, r2, r2, r2)
            goto L_0x0119
        L_0x0118:
            r2 = 0
        L_0x0119:
            r0.f7171a0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        g gVar;
        g gVar2;
        boolean z10;
        int i12;
        setMeasuredDimension(View.getDefaultSize(0, i10), View.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.I = Math.min(measuredWidth / 10, this.H);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            boolean z11 = true;
            int i14 = 1073741824;
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (!(childAt.getVisibility() == 8 || (gVar2 = (g) childAt.getLayoutParams()) == null || !gVar2.f7215a)) {
                int i15 = gVar2.f7216b;
                int i16 = i15 & 7;
                int i17 = i15 & 112;
                if (i17 == 48 || i17 == 80) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!(i16 == 3 || i16 == 5)) {
                    z11 = false;
                }
                int i18 = Integer.MIN_VALUE;
                if (z10) {
                    i12 = Integer.MIN_VALUE;
                    i18 = 1073741824;
                } else if (z11) {
                    i12 = 1073741824;
                } else {
                    i12 = Integer.MIN_VALUE;
                }
                int i19 = gVar2.width;
                if (i19 != -2) {
                    if (i19 == -1) {
                        i19 = paddingLeft;
                    }
                    i18 = 1073741824;
                } else {
                    i19 = paddingLeft;
                }
                int i20 = gVar2.height;
                if (i20 == -2) {
                    i20 = measuredHeight;
                    i14 = i12;
                } else if (i20 == -1) {
                    i20 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i19, i18), View.MeasureSpec.makeMeasureSpec(i20, i14));
                if (z10) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z11) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i13++;
        }
        this.f7202y = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f7203z = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.B = true;
        E();
        this.B = false;
        int childCount2 = getChildCount();
        for (int i21 = 0; i21 < childCount2; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.f7215a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * gVar.f7217c), 1073741824), this.f7203z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        f s10;
        int childCount = getChildCount();
        int i13 = -1;
        if ((i10 & 2) != 0) {
            i13 = childCount;
            i12 = 0;
            i11 = 1;
        } else {
            i12 = childCount - 1;
            i11 = -1;
        }
        while (i12 != i13) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 0 && (s10 = s(childAt)) != null && s10.f7211b == this.f7180f && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i12 += i11;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        a aVar = this.f7178e;
        if (aVar != null) {
            aVar.m(savedState.f7205d, savedState.f7206e);
            O(savedState.f7204c, false, true);
            return;
        }
        this.f7182g = savedState.f7204c;
        this.f7184h = savedState.f7205d;
        this.f7187j = savedState.f7206e;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7204c = this.f7180f;
        a aVar = this.f7178e;
        if (aVar != null) {
            savedState.f7205d = aVar.n();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.f7195n;
            G(i10, i12, i14, i14);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        float f10;
        if (this.U) {
            return true;
        }
        boolean z10 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f7178e) == null || aVar.e() == 0) {
            return false;
        }
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        this.P.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f7189k.abortAnimation();
            this.D = false;
            E();
            float x10 = motionEvent.getX();
            this.M = x10;
            this.K = x10;
            float y10 = motionEvent.getY();
            this.N = y10;
            this.L = y10;
            this.O = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.F) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.O);
                    if (findPointerIndex == -1) {
                        z10 = L();
                    } else {
                        float x11 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x11 - this.K);
                        float y11 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y11 - this.L);
                        if (abs > ((float) this.J) && abs > abs2) {
                            this.F = true;
                            K(true);
                            float f11 = this.M;
                            if (x11 - f11 > 0.0f) {
                                f10 = f11 + ((float) this.J);
                            } else {
                                f10 = f11 - ((float) this.J);
                            }
                            this.K = f10;
                            this.L = y11;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.F) {
                    z10 = false | D(motionEvent.getX(motionEvent.findPointerIndex(this.O)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.K = motionEvent.getX(actionIndex);
                    this.O = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    z(motionEvent);
                    this.K = motionEvent.getX(motionEvent.findPointerIndex(this.O));
                }
            } else if (this.F) {
                M(this.f7180f, true, 0, false);
                z10 = L();
            }
        } else if (this.F) {
            VelocityTracker velocityTracker = this.P;
            velocityTracker.computeCurrentVelocity(1000, (float) this.R);
            int xVelocity = (int) velocityTracker.getXVelocity(this.O);
            this.D = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f t10 = t();
            float f12 = (float) clientWidth;
            P(i(t10.f7211b, ((((float) scrollX) / f12) - t10.f7214e) / (t10.f7213d + (((float) this.f7195n) / f12)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.O)) - this.M)), true, true, xVelocity);
            z10 = L();
        }
        if (z10) {
            n0.j0(this);
        }
        return true;
    }

    public boolean p(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return d(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return d(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return B();
                } else {
                    return d(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return A();
            } else {
                return d(17);
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public f r(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return s(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public void removeView(View view) {
        if (this.B) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    public f s(View view) {
        for (int i10 = 0; i10 < this.f7172b.size(); i10++) {
            f fVar = this.f7172b.get(i10);
            if (this.f7178e.j(view, fVar.f7210a)) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(a aVar) {
        a aVar2 = this.f7178e;
        if (aVar2 != null) {
            aVar2.q((DataSetObserver) null);
            this.f7178e.s(this);
            for (int i10 = 0; i10 < this.f7172b.size(); i10++) {
                f fVar = this.f7172b.get(i10);
                this.f7178e.b(this, fVar.f7211b, fVar.f7210a);
            }
            this.f7178e.d(this);
            this.f7172b.clear();
            H();
            this.f7180f = 0;
            scrollTo(0, 0);
        }
        a aVar3 = this.f7178e;
        this.f7178e = aVar;
        this.f7170a = 0;
        if (aVar != null) {
            if (this.f7193m == null) {
                this.f7193m = new l();
            }
            this.f7178e.q(this.f7193m);
            this.D = false;
            boolean z10 = this.f7171a0;
            this.f7171a0 = true;
            this.f7170a = this.f7178e.e();
            if (this.f7182g >= 0) {
                this.f7178e.m(this.f7184h, this.f7187j);
                O(this.f7182g, false, true);
                this.f7182g = -1;
                this.f7184h = null;
                this.f7187j = null;
            } else if (!z10) {
                E();
            } else {
                requestLayout();
            }
        }
        List<i> list = this.f7185h0;
        if (list != null && !list.isEmpty()) {
            int size = this.f7185h0.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f7185h0.get(i11).a(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i10) {
        this.D = false;
        O(i10, !this.f7171a0, false);
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Requested offscreen page limit ");
            sb2.append(i10);
            sb2.append(" too small; defaulting to ");
            sb2.append(1);
            i10 = 1;
        }
        if (i10 != this.E) {
            this.E = i10;
            E();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.f7181f0 = jVar;
    }

    public void setPageMargin(int i10) {
        int i11 = this.f7195n;
        this.f7195n = i10;
        int width = getWidth();
        G(width, width, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f7197p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i10) {
        boolean z10;
        if (this.f7196n0 != i10) {
            this.f7196n0 = i10;
            if (this.f7186i0 != null) {
                if (i10 != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                n(z10);
            }
            l(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public f u(int i10) {
        for (int i11 = 0; i11 < this.f7172b.size(); i11++) {
            f fVar = this.f7172b.get(i11);
            if (fVar.f7211b == i10) {
                return fVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        setWillNotDraw(false);
        setDescendantFocusability(Opcodes.ASM4);
        setFocusable(true);
        Context context = getContext();
        this.f7189k = new Scroller(context, f7168q0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.J = viewConfiguration.getScaledPagingTouchSlop();
        this.Q = (int) (400.0f * f10);
        this.R = viewConfiguration.getScaledMaximumFlingVelocity();
        this.V = new EdgeEffect(context);
        this.W = new EdgeEffect(context);
        this.S = (int) (25.0f * f10);
        this.T = (int) (2.0f * f10);
        this.H = (int) (f10 * 16.0f);
        n0.s0(this, new h());
        if (n0.z(this) == 0) {
            n0.D0(this, 1);
        }
        n0.H0(this, new d());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7197p;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f7177d0
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L_0x001b:
            if (r7 >= r6) goto L_0x006b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r9 = (androidx.viewpager.widget.ViewPager.g) r9
            boolean r10 = r9.f7215a
            if (r10 != 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            int r9 = r9.f7216b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004d
            r10 = 3
            if (r9 == r10) goto L_0x0047
            r10 = 5
            if (r9 == r10) goto L_0x003a
            r9 = r3
            goto L_0x005c
        L_0x003a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L_0x0059
        L_0x0047:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L_0x005c
        L_0x004d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L_0x0059:
            r11 = r9
            r9 = r3
            r3 = r11
        L_0x005c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L_0x0067
            r8.offsetLeftAndRight(r3)
        L_0x0067:
            r3 = r9
        L_0x0068:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x006b:
            r12.j(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$k r13 = r12.f7186i0
            if (r13 == 0) goto L_0x009f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007a:
            if (r1 >= r14) goto L_0x009f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r0 = (androidx.viewpager.widget.ViewPager.g) r0
            boolean r0 = r0.f7215a
            if (r0 == 0) goto L_0x008b
            goto L_0x009c
        L_0x008b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$k r3 = r12.f7186i0
            r3.a(r15, r0)
        L_0x009c:
            int r1 = r1 + 1
            goto L_0x007a
        L_0x009f:
            r12.f7175c0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.y(int, float, int):void");
    }

    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7215a;

        /* renamed from: b  reason: collision with root package name */
        public int f7216b;

        /* renamed from: c  reason: collision with root package name */
        float f7217c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        boolean f7218d;

        /* renamed from: e  reason: collision with root package name */
        int f7219e;

        /* renamed from: f  reason: collision with root package name */
        int f7220f;

        public g() {
            super(-1, -1);
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f7166o0);
            this.f7216b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(androidx.core.content.a.getDrawable(getContext(), i10));
    }
}
