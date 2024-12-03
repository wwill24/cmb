package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.n1;
import androidx.core.view.accessibility.k;
import androidx.core.view.l0;
import androidx.core.view.n0;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import bf.k;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.material.internal.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.e
public class TabLayout extends HorizontalScrollView {

    /* renamed from: h0  reason: collision with root package name */
    private static final int f20149h0 = k.Widget_Design_TabLayout;

    /* renamed from: i0  reason: collision with root package name */
    private static final androidx.core.util.e<g> f20150i0 = new androidx.core.util.g(16);
    final int B;
    int C;
    private final int D;
    private final int E;
    private final int F;
    private int G;
    int H;
    int I;
    int J;
    int K;
    boolean L;
    boolean M;
    int N;
    int O;
    boolean P;
    /* access modifiers changed from: private */
    public c Q;
    /* access modifiers changed from: private */
    public final TimeInterpolator R;
    private c S;
    private final ArrayList<c> T;
    private c U;
    private ValueAnimator V;
    ViewPager W;

    /* renamed from: a  reason: collision with root package name */
    int f20151a;

    /* renamed from: a0  reason: collision with root package name */
    private androidx.viewpager.widget.a f20152a0;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<g> f20153b;

    /* renamed from: b0  reason: collision with root package name */
    private DataSetObserver f20154b0;

    /* renamed from: c  reason: collision with root package name */
    private g f20155c;

    /* renamed from: c0  reason: collision with root package name */
    private h f20156c0;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final f f20157d;

    /* renamed from: d0  reason: collision with root package name */
    private b f20158d0;

    /* renamed from: e  reason: collision with root package name */
    int f20159e;

    /* renamed from: e0  reason: collision with root package name */
    private boolean f20160e0;

    /* renamed from: f  reason: collision with root package name */
    int f20161f;
    /* access modifiers changed from: private */

    /* renamed from: f0  reason: collision with root package name */
    public int f20162f0;

    /* renamed from: g  reason: collision with root package name */
    int f20163g;

    /* renamed from: g0  reason: collision with root package name */
    private final androidx.core.util.e<i> f20164g0;

    /* renamed from: h  reason: collision with root package name */
    int f20165h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final int f20166j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final int f20167k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f20168l;

    /* renamed from: m  reason: collision with root package name */
    ColorStateList f20169m;

    /* renamed from: n  reason: collision with root package name */
    ColorStateList f20170n;

    /* renamed from: p  reason: collision with root package name */
    ColorStateList f20171p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    Drawable f20172q;

    /* renamed from: t  reason: collision with root package name */
    private int f20173t;

    /* renamed from: w  reason: collision with root package name */
    PorterDuff.Mode f20174w;

    /* renamed from: x  reason: collision with root package name */
    float f20175x;

    /* renamed from: y  reason: collision with root package name */
    float f20176y;

    /* renamed from: z  reason: collision with root package name */
    float f20177z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    private class b implements ViewPager.i {

        /* renamed from: a  reason: collision with root package name */
        private boolean f20179a;

        b() {
        }

        public void a(@NonNull ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.W == viewPager) {
                tabLayout.M(aVar2, this.f20179a);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z10) {
            this.f20179a = z10;
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void a(T t10);

        void b(T t10);

        void c(T t10);
    }

    public interface d extends c<g> {
    }

    private class e extends DataSetObserver {
        e() {
        }

        public void onChanged() {
            TabLayout.this.F();
        }

        public void onInvalidated() {
            TabLayout.this.F();
        }
    }

    class f extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        ValueAnimator f20182a;

        /* renamed from: b  reason: collision with root package name */
        private int f20183b = -1;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f20185a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f20186b;

            a(View view, View view2) {
                this.f20185a = view;
                this.f20186b = view2;
            }

            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                f.this.j(this.f20185a, this.f20186b, valueAnimator.getAnimatedFraction());
            }
        }

        f(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        private void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f20151a == -1) {
                tabLayout.f20151a = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f20151a);
        }

        private void f(int i10) {
            if (TabLayout.this.f20162f0 == 0) {
                View childAt = getChildAt(i10);
                c e10 = TabLayout.this.Q;
                TabLayout tabLayout = TabLayout.this;
                e10.c(tabLayout, childAt, tabLayout.f20172q);
                TabLayout.this.f20151a = i10;
            }
        }

        /* access modifiers changed from: private */
        public void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        /* access modifiers changed from: private */
        public void j(View view, View view2, float f10) {
            boolean z10;
            if (view == null || view.getWidth() <= 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                c e10 = TabLayout.this.Q;
                TabLayout tabLayout = TabLayout.this;
                e10.d(tabLayout, view, view2, f10, tabLayout.f20172q);
            } else {
                Drawable drawable = TabLayout.this.f20172q;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f20172q.getBounds().bottom);
            }
            n0.j0(this);
        }

        private void k(boolean z10, int i10, int i11) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f20151a != i10) {
                View childAt = getChildAt(tabLayout.getSelectedTabPosition());
                View childAt2 = getChildAt(i10);
                if (childAt2 == null) {
                    g();
                    return;
                }
                TabLayout.this.f20151a = i10;
                a aVar = new a(childAt, childAt2);
                if (z10) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.f20182a = valueAnimator;
                    valueAnimator.setInterpolator(TabLayout.this.R);
                    valueAnimator.setDuration((long) i11);
                    valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                    valueAnimator.addUpdateListener(aVar);
                    valueAnimator.start();
                    return;
                }
                this.f20182a.removeAllUpdateListeners();
                this.f20182a.addUpdateListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i10, int i11) {
            ValueAnimator valueAnimator = this.f20182a;
            if (!(valueAnimator == null || !valueAnimator.isRunning() || TabLayout.this.f20151a == i10)) {
                this.f20182a.cancel();
            }
            k(true, i10, i11);
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public void draw(@NonNull Canvas canvas) {
            int height = TabLayout.this.f20172q.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.f20172q.getIntrinsicHeight();
            }
            int i10 = TabLayout.this.J;
            int i11 = 0;
            if (i10 == 0) {
                i11 = getHeight() - height;
                height = getHeight();
            } else if (i10 == 1) {
                i11 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            } else if (i10 != 2) {
                if (i10 != 3) {
                    height = 0;
                } else {
                    height = getHeight();
                }
            }
            if (TabLayout.this.f20172q.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f20172q.getBounds();
                TabLayout.this.f20172q.setBounds(bounds.left, i11, bounds.right, height);
                TabLayout.this.f20172q.draw(canvas);
            }
            super.draw(canvas);
        }

        /* access modifiers changed from: package-private */
        public void h(int i10, float f10) {
            TabLayout.this.f20151a = Math.round(((float) i10) + f10);
            ValueAnimator valueAnimator = this.f20182a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f20182a.cancel();
            }
            j(getChildAt(i10), getChildAt(i10 + 1), f10);
        }

        /* access modifiers changed from: package-private */
        public void i(int i10) {
            Rect bounds = TabLayout.this.f20172q.getBounds();
            TabLayout.this.f20172q.setBounds(bounds.left, 0, bounds.right, i10);
            requestLayout();
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f20182a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z10 = true;
                if (tabLayout.H == 1 || tabLayout.K == 2) {
                    int childCount = getChildCount();
                    int i12 = 0;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        View childAt = getChildAt(i13);
                        if (childAt.getVisibility() == 0) {
                            i12 = Math.max(i12, childAt.getMeasuredWidth());
                        }
                    }
                    if (i12 > 0) {
                        if (i12 * childCount <= getMeasuredWidth() - (((int) r.c(getContext(), 16)) * 2)) {
                            boolean z11 = false;
                            for (int i14 = 0; i14 < childCount; i14++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i14).getLayoutParams();
                                if (layoutParams.width != i12 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i12;
                                    layoutParams.weight = 0.0f;
                                    z11 = true;
                                }
                            }
                            z10 = z11;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.H = 0;
                            tabLayout2.U(false);
                        }
                        if (z10) {
                            super.onMeasure(i10, i11);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private Object f20188a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f20189b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f20190c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f20191d;

        /* renamed from: e  reason: collision with root package name */
        private int f20192e = -1;

        /* renamed from: f  reason: collision with root package name */
        private View f20193f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f20194g = 1;

        /* renamed from: h  reason: collision with root package name */
        public TabLayout f20195h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        public i f20196i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f20197j = -1;

        public View e() {
            return this.f20193f;
        }

        public Drawable f() {
            return this.f20189b;
        }

        public int g() {
            return this.f20192e;
        }

        public int h() {
            return this.f20194g;
        }

        public Object i() {
            return this.f20188a;
        }

        public CharSequence j() {
            return this.f20190c;
        }

        public boolean k() {
            TabLayout tabLayout = this.f20195h;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition == -1 || selectedTabPosition != this.f20192e) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public void l() {
            this.f20195h = null;
            this.f20196i = null;
            this.f20188a = null;
            this.f20189b = null;
            this.f20197j = -1;
            this.f20190c = null;
            this.f20191d = null;
            this.f20192e = -1;
            this.f20193f = null;
        }

        public void m() {
            TabLayout tabLayout = this.f20195h;
            if (tabLayout != null) {
                tabLayout.K(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public g n(CharSequence charSequence) {
            this.f20191d = charSequence;
            u();
            return this;
        }

        @NonNull
        public g o(int i10) {
            return p(LayoutInflater.from(this.f20196i.getContext()).inflate(i10, this.f20196i, false));
        }

        @NonNull
        public g p(View view) {
            this.f20193f = view;
            u();
            return this;
        }

        @NonNull
        public g q(Drawable drawable) {
            this.f20189b = drawable;
            TabLayout tabLayout = this.f20195h;
            if (tabLayout.H == 1 || tabLayout.K == 2) {
                tabLayout.U(true);
            }
            u();
            if (com.google.android.material.badge.b.f19167a && this.f20196i.l() && this.f20196i.f20205e.isVisible()) {
                this.f20196i.invalidate();
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public void r(int i10) {
            this.f20192e = i10;
        }

        @NonNull
        public g s(Object obj) {
            this.f20188a = obj;
            return this;
        }

        @NonNull
        public g t(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f20191d) && !TextUtils.isEmpty(charSequence)) {
                this.f20196i.setContentDescription(charSequence);
            }
            this.f20190c = charSequence;
            u();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void u() {
            i iVar = this.f20196i;
            if (iVar != null) {
                iVar.t();
            }
        }
    }

    public static class h implements ViewPager.j {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f20198a;

        /* renamed from: b  reason: collision with root package name */
        private int f20199b;

        /* renamed from: c  reason: collision with root package name */
        private int f20200c;

        public h(TabLayout tabLayout) {
            this.f20198a = new WeakReference<>(tabLayout);
        }

        public void S(int i10, float f10, int i11) {
            boolean z10;
            TabLayout tabLayout = this.f20198a.get();
            if (tabLayout != null) {
                int i12 = this.f20200c;
                boolean z11 = false;
                if (i12 != 2 || this.f20199b == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!(i12 == 2 && this.f20199b == 0)) {
                    z11 = true;
                }
                tabLayout.O(i10, f10, z10, z11);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f20200c = 0;
            this.f20199b = 0;
        }

        public void m0(int i10) {
            this.f20199b = this.f20200c;
            this.f20200c = i10;
            TabLayout tabLayout = this.f20198a.get();
            if (tabLayout != null) {
                tabLayout.V(this.f20200c);
            }
        }

        public void q(int i10) {
            boolean z10;
            TabLayout tabLayout = this.f20198a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i10 && i10 < tabLayout.getTabCount()) {
                int i11 = this.f20200c;
                if (i11 == 0 || (i11 == 2 && this.f20199b == 0)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                tabLayout.L(tabLayout.B(i10), z10);
            }
        }
    }

    public final class i extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private g f20201a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f20202b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f20203c;

        /* renamed from: d  reason: collision with root package name */
        private View f20204d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public com.google.android.material.badge.a f20205e;

        /* renamed from: f  reason: collision with root package name */
        private View f20206f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f20207g;

        /* renamed from: h  reason: collision with root package name */
        private ImageView f20208h;

        /* renamed from: j  reason: collision with root package name */
        private Drawable f20209j;

        /* renamed from: k  reason: collision with root package name */
        private int f20210k = 2;

        class a implements View.OnLayoutChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f20212a;

            a(View view) {
                this.f20212a = view;
            }

            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (this.f20212a.getVisibility() == 0) {
                    i.this.s(this.f20212a);
                }
            }
        }

        public i(@NonNull Context context) {
            super(context);
            u(context);
            n0.I0(this, TabLayout.this.f20159e, TabLayout.this.f20161f, TabLayout.this.f20163g, TabLayout.this.f20165h);
            setGravity(17);
            setOrientation(TabLayout.this.L ^ true ? 1 : 0);
            setClickable(true);
            n0.J0(this, l0.b(getContext(), CloseCodes.PROTOCOL_ERROR));
        }

        private void f(View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new a(view));
            }
        }

        private float g(@NonNull Layout layout, int i10, float f10) {
            return layout.getLineWidth(i10) * (f10 / layout.getPaint().getTextSize());
        }

        private com.google.android.material.badge.a getBadge() {
            return this.f20205e;
        }

        @NonNull
        private com.google.android.material.badge.a getOrCreateBadge() {
            if (this.f20205e == null) {
                this.f20205e = com.google.android.material.badge.a.c(getContext());
            }
            r();
            com.google.android.material.badge.a aVar = this.f20205e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h(boolean z10) {
            setClipChildren(z10);
            setClipToPadding(z10);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z10);
                viewGroup.setClipToPadding(z10);
            }
        }

        @NonNull
        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* access modifiers changed from: private */
        public void j(@NonNull Canvas canvas) {
            Drawable drawable = this.f20209j;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f20209j.draw(canvas);
            }
        }

        private FrameLayout k(@NonNull View view) {
            if ((view == this.f20203c || view == this.f20202b) && com.google.android.material.badge.b.f19167a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* access modifiers changed from: private */
        public boolean l() {
            return this.f20205e != null;
        }

        private void m() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.b.f19167a) {
                viewGroup = i();
                addView(viewGroup, 0);
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(bf.h.design_layout_tab_icon, viewGroup, false);
            this.f20203c = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void n() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.b.f19167a) {
                viewGroup = i();
                addView(viewGroup);
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(bf.h.design_layout_tab_text, viewGroup, false);
            this.f20202b = textView;
            viewGroup.addView(textView);
        }

        private void p(View view) {
            if (l() && view != null) {
                h(false);
                com.google.android.material.badge.b.a(this.f20205e, view, k(view));
                this.f20204d = view;
            }
        }

        private void q() {
            if (l()) {
                h(true);
                View view = this.f20204d;
                if (view != null) {
                    com.google.android.material.badge.b.b(this.f20205e, view);
                    this.f20204d = null;
                }
            }
        }

        private void r() {
            g gVar;
            g gVar2;
            if (l()) {
                if (this.f20206f != null) {
                    q();
                } else if (this.f20203c != null && (gVar2 = this.f20201a) != null && gVar2.f() != null) {
                    View view = this.f20204d;
                    ImageView imageView = this.f20203c;
                    if (view != imageView) {
                        q();
                        p(this.f20203c);
                        return;
                    }
                    s(imageView);
                } else if (this.f20202b == null || (gVar = this.f20201a) == null || gVar.h() != 1) {
                    q();
                } else {
                    View view2 = this.f20204d;
                    TextView textView = this.f20202b;
                    if (view2 != textView) {
                        q();
                        p(this.f20202b);
                        return;
                    }
                    s(textView);
                }
            }
        }

        /* access modifiers changed from: private */
        public void s(@NonNull View view) {
            if (l() && view == this.f20204d) {
                com.google.android.material.badge.b.c(this.f20205e, view, k(view));
            }
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void u(android.content.Context r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.B
                r1 = 0
                if (r0 == 0) goto L_0x001f
                android.graphics.drawable.Drawable r6 = e.a.b(r6, r0)
                r5.f20209j = r6
                if (r6 == 0) goto L_0x0021
                boolean r6 = r6.isStateful()
                if (r6 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r6 = r5.f20209j
                int[] r0 = r5.getDrawableState()
                r6.setState(r0)
                goto L_0x0021
            L_0x001f:
                r5.f20209j = r1
            L_0x0021:
                android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable
                r6.<init>()
                r0 = 0
                r6.setColor(r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.f20171p
                if (r0 == 0) goto L_0x0058
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r2 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r2)
                r2 = -1
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.f20171p
                android.content.res.ColorStateList r2 = rf.b.a(r2)
                android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.P
                if (r4 == 0) goto L_0x0050
                r6 = r1
            L_0x0050:
                if (r4 == 0) goto L_0x0053
                goto L_0x0054
            L_0x0053:
                r1 = r0
            L_0x0054:
                r3.<init>(r2, r6, r1)
                r6 = r3
            L_0x0058:
                androidx.core.view.n0.w0(r5, r6)
                com.google.android.material.tabs.TabLayout r6 = com.google.android.material.tabs.TabLayout.this
                r6.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.i.u(android.content.Context):void");
        }

        private void x(TextView textView, ImageView imageView, boolean z10) {
            Drawable drawable;
            CharSequence charSequence;
            int i10;
            CharSequence charSequence2;
            int i11;
            g gVar = this.f20201a;
            CharSequence charSequence3 = null;
            if (gVar == null || gVar.f() == null) {
                drawable = null;
            } else {
                drawable = androidx.core.graphics.drawable.a.r(this.f20201a.f()).mutate();
            }
            if (drawable != null) {
                androidx.core.graphics.drawable.a.o(drawable, TabLayout.this.f20170n);
                PorterDuff.Mode mode = TabLayout.this.f20174w;
                if (mode != null) {
                    androidx.core.graphics.drawable.a.p(drawable, mode);
                }
            }
            g gVar2 = this.f20201a;
            if (gVar2 != null) {
                charSequence = gVar2.j();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z11 = true;
            boolean z12 = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (!z12 || this.f20201a.f20194g != 1) {
                    z11 = false;
                }
                if (z12) {
                    charSequence2 = charSequence;
                } else {
                    charSequence2 = null;
                }
                textView.setText(charSequence2);
                if (z11) {
                    i11 = 0;
                } else {
                    i11 = 8;
                }
                textView.setVisibility(i11);
                if (z12) {
                    setVisibility(0);
                }
            } else {
                z11 = false;
            }
            if (z10 && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (!z11 || imageView.getVisibility() != 0) {
                    i10 = 0;
                } else {
                    i10 = (int) r.c(getContext(), 8);
                }
                if (TabLayout.this.L) {
                    if (i10 != androidx.core.view.h.a(marginLayoutParams)) {
                        androidx.core.view.h.c(marginLayoutParams, i10);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i10 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i10;
                    androidx.core.view.h.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f20201a;
            if (gVar3 != null) {
                charSequence3 = gVar3.f20191d;
            }
            if (!z12) {
                charSequence = charSequence3;
            }
            n1.a(this, charSequence);
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f20209j;
            boolean z10 = false;
            if (drawable != null && drawable.isStateful()) {
                z10 = false | this.f20209j.setState(drawableState);
            }
            if (z10) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.f20202b, this.f20203c, this.f20206f};
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < 3; i12++) {
                View view = viewArr[i12];
                if (view != null && view.getVisibility() == 0) {
                    if (z10) {
                        i11 = Math.min(i11, view.getTop());
                    } else {
                        i11 = view.getTop();
                    }
                    if (z10) {
                        i10 = Math.max(i10, view.getBottom());
                    } else {
                        i10 = view.getBottom();
                    }
                    z10 = true;
                }
            }
            return i10 - i11;
        }

        /* access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.f20202b, this.f20203c, this.f20206f};
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < 3; i12++) {
                View view = viewArr[i12];
                if (view != null && view.getVisibility() == 0) {
                    if (z10) {
                        i11 = Math.min(i11, view.getLeft());
                    } else {
                        i11 = view.getLeft();
                    }
                    if (z10) {
                        i10 = Math.max(i10, view.getRight());
                    } else {
                        i10 = view.getRight();
                    }
                    z10 = true;
                }
            }
            return i10 - i11;
        }

        public g getTab() {
            return this.f20201a;
        }

        /* access modifiers changed from: package-private */
        public void o() {
            setTab((g) null);
            setSelected(false);
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            com.google.android.material.badge.a aVar = this.f20205e;
            if (aVar != null && aVar.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(contentDescription + ", " + this.f20205e.f());
            }
            androidx.core.view.accessibility.k C0 = androidx.core.view.accessibility.k.C0(accessibilityNodeInfo);
            C0.d0(k.c.a(0, 1, this.f20201a.g(), 1, false, isSelected()));
            if (isSelected()) {
                C0.b0(false);
                C0.S(k.a.f4763i);
            }
            C0.s0(getResources().getString(bf.j.item_view_role_description));
        }

        public void onMeasure(int i10, int i11) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i10 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.C, Integer.MIN_VALUE);
            }
            super.onMeasure(i10, i11);
            if (this.f20202b != null) {
                float f10 = TabLayout.this.f20175x;
                int i12 = this.f20210k;
                ImageView imageView = this.f20203c;
                boolean z10 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f20202b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f10 = TabLayout.this.f20177z;
                    }
                } else {
                    i12 = 1;
                }
                float textSize = this.f20202b.getTextSize();
                int lineCount = this.f20202b.getLineCount();
                int g10 = l.g(this.f20202b);
                int i13 = (f10 > textSize ? 1 : (f10 == textSize ? 0 : -1));
                if (i13 != 0 || (g10 >= 0 && i12 != g10)) {
                    if (TabLayout.this.K == 1 && i13 > 0 && lineCount == 1 && ((layout = this.f20202b.getLayout()) == null || g(layout, 0, f10) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z10 = false;
                    }
                    if (z10) {
                        this.f20202b.setTextSize(0, f10);
                        this.f20202b.setMaxLines(i12);
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f20201a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f20201a.m();
            return true;
        }

        public void setSelected(boolean z10) {
            if (isSelected() != z10) {
            }
            super.setSelected(z10);
            TextView textView = this.f20202b;
            if (textView != null) {
                textView.setSelected(z10);
            }
            ImageView imageView = this.f20203c;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f20206f;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        /* access modifiers changed from: package-private */
        public void setTab(g gVar) {
            if (gVar != this.f20201a) {
                this.f20201a = gVar;
                t();
            }
        }

        /* access modifiers changed from: package-private */
        public final void t() {
            boolean z10;
            w();
            g gVar = this.f20201a;
            if (gVar == null || !gVar.k()) {
                z10 = false;
            } else {
                z10 = true;
            }
            setSelected(z10);
        }

        /* access modifiers changed from: package-private */
        public final void v() {
            setOrientation(TabLayout.this.L ^ true ? 1 : 0);
            TextView textView = this.f20207g;
            if (textView == null && this.f20208h == null) {
                x(this.f20202b, this.f20203c, true);
            } else {
                x(textView, this.f20208h, false);
            }
        }

        /* access modifiers changed from: package-private */
        public final void w() {
            View view;
            ViewParent parent;
            g gVar = this.f20201a;
            if (gVar != null) {
                view = gVar.e();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.f20206f;
                    if (!(view2 == null || (parent = view2.getParent()) == null)) {
                        ((ViewGroup) parent).removeView(this.f20206f);
                    }
                    addView(view);
                }
                this.f20206f = view;
                TextView textView = this.f20202b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f20203c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f20203c.setImageDrawable((Drawable) null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.f20207g = textView2;
                if (textView2 != null) {
                    this.f20210k = l.g(textView2);
                }
                this.f20208h = (ImageView) view.findViewById(16908294);
            } else {
                View view3 = this.f20206f;
                if (view3 != null) {
                    removeView(view3);
                    this.f20206f = null;
                }
                this.f20207g = null;
                this.f20208h = null;
            }
            if (this.f20206f == null) {
                if (this.f20203c == null) {
                    m();
                }
                if (this.f20202b == null) {
                    n();
                    this.f20210k = l.g(this.f20202b);
                }
                l.s(this.f20202b, TabLayout.this.f20166j);
                if (!isSelected() || TabLayout.this.f20168l == -1) {
                    l.s(this.f20202b, TabLayout.this.f20167k);
                } else {
                    l.s(this.f20202b, TabLayout.this.f20168l);
                }
                ColorStateList colorStateList = TabLayout.this.f20169m;
                if (colorStateList != null) {
                    this.f20202b.setTextColor(colorStateList);
                }
                x(this.f20202b, this.f20203c, true);
                r();
                f(this.f20203c);
                f(this.f20202b);
            } else {
                TextView textView3 = this.f20207g;
                if (!(textView3 == null && this.f20208h == null)) {
                    x(textView3, this.f20208h, false);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f20191d)) {
                setContentDescription(gVar.f20191d);
            }
        }
    }

    public static class j implements d {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f20214a;

        public j(ViewPager viewPager) {
            this.f20214a = viewPager;
        }

        public void a(@NonNull g gVar) {
            this.f20214a.setCurrentItem(gVar.g());
        }

        public void b(g gVar) {
        }

        public void c(g gVar) {
        }
    }

    public TabLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.tabStyle);
    }

    private void A() {
        if (this.V == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.V = valueAnimator;
            valueAnimator.setInterpolator(this.R);
            this.V.setDuration((long) this.I);
            this.V.addUpdateListener(new a());
        }
    }

    private boolean C() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    private void J(int i10) {
        i iVar = (i) this.f20157d.getChildAt(i10);
        this.f20157d.removeViewAt(i10);
        if (iVar != null) {
            iVar.o();
            this.f20164g0.a(iVar);
        }
        requestLayout();
    }

    private void R(ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.W;
        if (viewPager2 != null) {
            h hVar = this.f20156c0;
            if (hVar != null) {
                viewPager2.J(hVar);
            }
            b bVar = this.f20158d0;
            if (bVar != null) {
                this.W.I(bVar);
            }
        }
        c cVar = this.U;
        if (cVar != null) {
            I(cVar);
            this.U = null;
        }
        if (viewPager != null) {
            this.W = viewPager;
            if (this.f20156c0 == null) {
                this.f20156c0 = new h(this);
            }
            this.f20156c0.a();
            viewPager.c(this.f20156c0);
            j jVar = new j(viewPager);
            this.U = jVar;
            g(jVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                M(adapter, z10);
            }
            if (this.f20158d0 == null) {
                this.f20158d0 = new b();
            }
            this.f20158d0.b(z10);
            viewPager.b(this.f20158d0);
            N(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.W = null;
            M((androidx.viewpager.widget.a) null, false);
        }
        this.f20160e0 = z11;
    }

    private void S() {
        int size = this.f20153b.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f20153b.get(i10).u();
        }
    }

    private void T(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.K == 1 && this.H == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int getDefaultHeight() {
        int size = this.f20153b.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                g gVar = this.f20153b.get(i10);
                if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.j())) {
                    z10 = true;
                    break;
                }
                i10++;
            } else {
                break;
            }
        }
        if (!z10 || this.L) {
            return 48;
        }
        return 72;
    }

    private int getTabMinWidth() {
        int i10 = this.D;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.K;
        if (i11 == 0 || i11 == 2) {
            return this.F;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f20157d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void l(@NonNull TabItem tabItem) {
        g E2 = E();
        CharSequence charSequence = tabItem.f20146a;
        if (charSequence != null) {
            E2.t(charSequence);
        }
        Drawable drawable = tabItem.f20147b;
        if (drawable != null) {
            E2.q(drawable);
        }
        int i10 = tabItem.f20148c;
        if (i10 != 0) {
            E2.o(i10);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            E2.n(tabItem.getContentDescription());
        }
        i(E2);
    }

    private void m(@NonNull g gVar) {
        i iVar = gVar.f20196i;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.f20157d.addView(iVar, gVar.g(), u());
    }

    private void n(View view) {
        if (view instanceof TabItem) {
            l((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void o(int i10) {
        if (i10 != -1) {
            if (getWindowToken() == null || !n0.W(this) || this.f20157d.d()) {
                N(i10, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int r10 = r(i10, 0.0f);
            if (scrollX != r10) {
                A();
                this.V.setIntValues(new int[]{scrollX, r10});
                this.V.start();
            }
            this.f20157d.c(i10, this.I);
        }
    }

    private void p(int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                this.f20157d.setGravity(1);
                return;
            } else if (i10 != 2) {
                return;
            }
        }
        this.f20157d.setGravity(8388611);
    }

    private void q() {
        int i10;
        int i11 = this.K;
        if (i11 == 0 || i11 == 2) {
            i10 = Math.max(0, this.G - this.f20159e);
        } else {
            i10 = 0;
        }
        n0.I0(this.f20157d, i10, 0, 0, 0);
        int i12 = this.K;
        if (i12 == 0) {
            p(this.H);
        } else if (i12 == 1 || i12 == 2) {
            this.f20157d.setGravity(1);
        }
        U(true);
    }

    private int r(int i10, float f10) {
        View childAt;
        View view;
        int i11 = this.K;
        int i12 = 0;
        if ((i11 != 0 && i11 != 2) || (childAt = this.f20157d.getChildAt(i10)) == null) {
            return 0;
        }
        int i13 = i10 + 1;
        if (i13 < this.f20157d.getChildCount()) {
            view = this.f20157d.getChildAt(i13);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i12 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i14 = (int) (((float) (width + i12)) * 0.5f * f10);
        if (n0.B(this) == 0) {
            return left + i14;
        }
        return left - i14;
    }

    private void s(@NonNull g gVar, int i10) {
        gVar.r(i10);
        this.f20153b.add(i10, gVar);
        int size = this.f20153b.size();
        int i11 = -1;
        for (int i12 = i10 + 1; i12 < size; i12++) {
            if (this.f20153b.get(i12).g() == this.f20151a) {
                i11 = i12;
            }
            this.f20153b.get(i12).r(i12);
        }
        this.f20151a = i11;
    }

    private void setSelectedTabView(int i10) {
        boolean z10;
        boolean z11;
        int childCount = this.f20157d.getChildCount();
        if (i10 < childCount) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = this.f20157d.getChildAt(i11);
                boolean z12 = true;
                if ((i11 != i10 || childAt.isSelected()) && (i11 == i10 || !childAt.isSelected())) {
                    if (i11 == i10) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    childAt.setSelected(z11);
                    if (i11 != i10) {
                        z12 = false;
                    }
                    childAt.setActivated(z12);
                } else {
                    if (i11 == i10) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    childAt.setSelected(z10);
                    if (i11 != i10) {
                        z12 = false;
                    }
                    childAt.setActivated(z12);
                    if (childAt instanceof i) {
                        ((i) childAt).w();
                    }
                }
            }
        }
    }

    @NonNull
    private static ColorStateList t(int i10, int i11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    @NonNull
    private LinearLayout.LayoutParams u() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        T(layoutParams);
        return layoutParams;
    }

    @NonNull
    private i w(@NonNull g gVar) {
        i iVar;
        androidx.core.util.e<i> eVar = this.f20164g0;
        if (eVar != null) {
            iVar = eVar.acquire();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            iVar = new i(getContext());
        }
        iVar.setTab(gVar);
        iVar.setFocusable(true);
        iVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.f20191d)) {
            iVar.setContentDescription(gVar.f20190c);
        } else {
            iVar.setContentDescription(gVar.f20191d);
        }
        return iVar;
    }

    private void x(@NonNull g gVar) {
        for (int size = this.T.size() - 1; size >= 0; size--) {
            this.T.get(size).c(gVar);
        }
    }

    private void y(@NonNull g gVar) {
        for (int size = this.T.size() - 1; size >= 0; size--) {
            this.T.get(size).a(gVar);
        }
    }

    private void z(@NonNull g gVar) {
        for (int size = this.T.size() - 1; size >= 0; size--) {
            this.T.get(size).b(gVar);
        }
    }

    public g B(int i10) {
        if (i10 < 0 || i10 >= getTabCount()) {
            return null;
        }
        return this.f20153b.get(i10);
    }

    public boolean D() {
        return this.M;
    }

    @NonNull
    public g E() {
        g v10 = v();
        v10.f20195h = this;
        v10.f20196i = w(v10);
        if (v10.f20197j != -1) {
            v10.f20196i.setId(v10.f20197j);
        }
        return v10;
    }

    /* access modifiers changed from: package-private */
    public void F() {
        int currentItem;
        H();
        androidx.viewpager.widget.a aVar = this.f20152a0;
        if (aVar != null) {
            int e10 = aVar.e();
            for (int i10 = 0; i10 < e10; i10++) {
                k(E().t(this.f20152a0.g(i10)), false);
            }
            ViewPager viewPager = this.W;
            if (viewPager != null && e10 > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                K(B(currentItem));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean G(g gVar) {
        return f20150i0.a(gVar);
    }

    public void H() {
        for (int childCount = this.f20157d.getChildCount() - 1; childCount >= 0; childCount--) {
            J(childCount);
        }
        Iterator<g> it = this.f20153b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.l();
            G(next);
        }
        this.f20155c = null;
    }

    @Deprecated
    public void I(c cVar) {
        this.T.remove(cVar);
    }

    public void K(g gVar) {
        L(gVar, true);
    }

    public void L(g gVar, boolean z10) {
        int i10;
        g gVar2 = this.f20155c;
        if (gVar2 != gVar) {
            if (gVar != null) {
                i10 = gVar.g();
            } else {
                i10 = -1;
            }
            if (z10) {
                if ((gVar2 == null || gVar2.g() == -1) && i10 != -1) {
                    N(i10, 0.0f, true);
                } else {
                    o(i10);
                }
                if (i10 != -1) {
                    setSelectedTabView(i10);
                }
            }
            this.f20155c = gVar;
            if (!(gVar2 == null || gVar2.f20195h == null)) {
                z(gVar2);
            }
            if (gVar != null) {
                y(gVar);
            }
        } else if (gVar2 != null) {
            x(gVar);
            o(gVar.g());
        }
    }

    /* access modifiers changed from: package-private */
    public void M(androidx.viewpager.widget.a aVar, boolean z10) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.f20152a0;
        if (!(aVar2 == null || (dataSetObserver = this.f20154b0) == null)) {
            aVar2.t(dataSetObserver);
        }
        this.f20152a0 = aVar;
        if (z10 && aVar != null) {
            if (this.f20154b0 == null) {
                this.f20154b0 = new e();
            }
            aVar.l(this.f20154b0);
        }
        F();
    }

    public void N(int i10, float f10, boolean z10) {
        O(i10, f10, z10, true);
    }

    public void O(int i10, float f10, boolean z10, boolean z11) {
        int i11;
        int round = Math.round(((float) i10) + f10);
        if (round >= 0 && round < this.f20157d.getChildCount()) {
            if (z11) {
                this.f20157d.h(i10, f10);
            }
            ValueAnimator valueAnimator = this.V;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.V.cancel();
            }
            if (i10 < 0) {
                i11 = 0;
            } else {
                i11 = r(i10, f10);
            }
            scrollTo(i11, 0);
            if (z10) {
                setSelectedTabView(round);
            }
        }
    }

    public void P(int i10, int i11) {
        setTabTextColors(t(i10, i11));
    }

    public void Q(ViewPager viewPager, boolean z10) {
        R(viewPager, z10, false);
    }

    /* access modifiers changed from: package-private */
    public void U(boolean z10) {
        for (int i10 = 0; i10 < this.f20157d.getChildCount(); i10++) {
            View childAt = this.f20157d.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            T((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z10) {
                childAt.requestLayout();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void V(int i10) {
        this.f20162f0 = i10;
    }

    public void addView(View view) {
        n(view);
    }

    @Deprecated
    public void g(c cVar) {
        if (!this.T.contains(cVar)) {
            this.T.add(cVar);
        }
    }

    public int getSelectedTabPosition() {
        g gVar = this.f20155c;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f20153b.size();
    }

    public int getTabGravity() {
        return this.H;
    }

    public ColorStateList getTabIconTint() {
        return this.f20170n;
    }

    public int getTabIndicatorAnimationMode() {
        return this.O;
    }

    public int getTabIndicatorGravity() {
        return this.J;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.C;
    }

    public int getTabMode() {
        return this.K;
    }

    public ColorStateList getTabRippleColor() {
        return this.f20171p;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.f20172q;
    }

    public ColorStateList getTabTextColors() {
        return this.f20169m;
    }

    public void h(@NonNull d dVar) {
        g(dVar);
    }

    public void i(@NonNull g gVar) {
        k(gVar, this.f20153b.isEmpty());
    }

    public void j(@NonNull g gVar, int i10, boolean z10) {
        if (gVar.f20195h == this) {
            s(gVar, i10);
            m(gVar);
            if (z10) {
                gVar.m();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void k(@NonNull g gVar, boolean z10) {
        j(gVar, this.f20153b.size(), z10);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tf.h.e(this);
        if (this.W == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                R((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f20160e0) {
            setupWithViewPager((ViewPager) null);
            this.f20160e0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        for (int i10 = 0; i10 < this.f20157d.getChildCount(); i10++) {
            View childAt = this.f20157d.getChildAt(i10);
            if (childAt instanceof i) {
                ((i) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.accessibility.k.C0(accessibilityNodeInfo).c0(k.b.a(1, getTabCount(), false, 1));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return C() && super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.r.c(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L_0x002e
            if (r1 == 0) goto L_0x001f
            goto L_0x0041
        L_0x001f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L_0x0041
        L_0x002e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L_0x0041
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L_0x0041
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L_0x0041:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L_0x005f
            int r1 = r6.E
            if (r1 <= 0) goto L_0x0050
            goto L_0x005d
        L_0x0050:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.r.c(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L_0x005d:
            r6.C = r1
        L_0x005f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto L_0x00ad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.K
            if (r0 == 0) goto L_0x0082
            if (r0 == r5) goto L_0x0076
            r1 = 2
            if (r0 == r1) goto L_0x0082
            goto L_0x008d
        L_0x0076:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L_0x008d
        L_0x0080:
            r4 = r5
            goto L_0x008d
        L_0x0082:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L_0x008d
            goto L_0x0080
        L_0x008d:
            if (r4 == 0) goto L_0x00ad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || C()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        tf.h.d(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.L != z10) {
            this.L = z10;
            for (int i10 = 0; i10 < this.f20157d.getChildCount(); i10++) {
                View childAt = this.f20157d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).v();
                }
            }
            q();
        }
    }

    public void setInlineLabelResource(int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        A();
        this.V.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
        this.f20172q = mutate;
        jf.b.g(mutate, this.f20173t);
        int i10 = this.N;
        if (i10 == -1) {
            i10 = this.f20172q.getIntrinsicHeight();
        }
        this.f20157d.i(i10);
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.f20173t = i10;
        jf.b.g(this.f20172q, i10);
        U(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.J != i10) {
            this.J = i10;
            n0.j0(this.f20157d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.N = i10;
        this.f20157d.i(i10);
    }

    public void setTabGravity(int i10) {
        if (this.H != i10) {
            this.H = i10;
            q();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f20170n != colorStateList) {
            this.f20170n = colorStateList;
            S();
        }
    }

    public void setTabIconTintResource(int i10) {
        setTabIconTint(e.a.a(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        this.O = i10;
        if (i10 == 0) {
            this.Q = new c();
        } else if (i10 == 1) {
            this.Q = new a();
        } else if (i10 == 2) {
            this.Q = new b();
        } else {
            throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.M = z10;
        this.f20157d.g();
        n0.j0(this.f20157d);
    }

    public void setTabMode(int i10) {
        if (i10 != this.K) {
            this.K = i10;
            q();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f20171p != colorStateList) {
            this.f20171p = colorStateList;
            for (int i10 = 0; i10 < this.f20157d.getChildCount(); i10++) {
                View childAt = this.f20157d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i10) {
        setTabRippleColor(e.a.a(getContext(), i10));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f20169m != colorStateList) {
            this.f20169m = colorStateList;
            S();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        M(aVar, false);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.P != z10) {
            this.P = z10;
            for (int i10 = 0; i10 < this.f20157d.getChildCount(); i10++) {
                View childAt = this.f20157d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        Q(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* access modifiers changed from: protected */
    public g v() {
        g acquire = f20150i0.acquire();
        if (acquire == null) {
            return new g();
        }
        return acquire;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r12, android.util.AttributeSet r13, int r14) {
        /*
            r11 = this;
            int r4 = f20149h0
            android.content.Context r12 = wf.a.c(r12, r13, r14, r4)
            r11.<init>(r12, r13, r14)
            r12 = -1
            r11.f20151a = r12
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r11.f20153b = r0
            r11.f20168l = r12
            r6 = 0
            r11.f20173t = r6
            r0 = 2147483647(0x7fffffff, float:NaN)
            r11.C = r0
            r11.N = r12
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r11.T = r0
            androidx.core.util.f r0 = new androidx.core.util.f
            r1 = 12
            r0.<init>(r1)
            r11.f20164g0 = r0
            android.content.Context r7 = r11.getContext()
            r11.setHorizontalScrollBarEnabled(r6)
            com.google.android.material.tabs.TabLayout$f r8 = new com.google.android.material.tabs.TabLayout$f
            r8.<init>(r7)
            r11.f20157d = r8
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -2
            r0.<init>(r1, r12)
            super.addView(r8, r6, r0)
            int[] r2 = bf.l.TabLayout
            r9 = 1
            int[] r5 = new int[r9]
            int r10 = bf.l.TabLayout_tabTextAppearance
            r5[r6] = r10
            r0 = r7
            r1 = r13
            r3 = r14
            android.content.res.TypedArray r13 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            android.graphics.drawable.Drawable r14 = r11.getBackground()
            boolean r14 = r14 instanceof android.graphics.drawable.ColorDrawable
            if (r14 == 0) goto L_0x0081
            android.graphics.drawable.Drawable r14 = r11.getBackground()
            android.graphics.drawable.ColorDrawable r14 = (android.graphics.drawable.ColorDrawable) r14
            tf.g r0 = new tf.g
            r0.<init>()
            int r14 = r14.getColor()
            android.content.res.ColorStateList r14 = android.content.res.ColorStateList.valueOf(r14)
            r0.b0(r14)
            r0.Q(r7)
            float r14 = androidx.core.view.n0.w(r11)
            r0.a0(r14)
            androidx.core.view.n0.w0(r11, r0)
        L_0x0081:
            int r14 = bf.l.TabLayout_tabIndicator
            android.graphics.drawable.Drawable r14 = qf.c.d(r7, r13, r14)
            r11.setSelectedTabIndicator((android.graphics.drawable.Drawable) r14)
            int r14 = bf.l.TabLayout_tabIndicatorColor
            int r14 = r13.getColor(r14, r6)
            r11.setSelectedTabIndicatorColor(r14)
            int r14 = bf.l.TabLayout_tabIndicatorHeight
            int r14 = r13.getDimensionPixelSize(r14, r12)
            r8.i(r14)
            int r14 = bf.l.TabLayout_tabIndicatorGravity
            int r14 = r13.getInt(r14, r6)
            r11.setSelectedTabIndicatorGravity(r14)
            int r14 = bf.l.TabLayout_tabIndicatorAnimationMode
            int r14 = r13.getInt(r14, r6)
            r11.setTabIndicatorAnimationMode(r14)
            int r14 = bf.l.TabLayout_tabIndicatorFullWidth
            boolean r14 = r13.getBoolean(r14, r9)
            r11.setTabIndicatorFullWidth(r14)
            int r14 = bf.l.TabLayout_tabPadding
            int r14 = r13.getDimensionPixelSize(r14, r6)
            r11.f20165h = r14
            r11.f20163g = r14
            r11.f20161f = r14
            r11.f20159e = r14
            int r0 = bf.l.TabLayout_tabPaddingStart
            int r14 = r13.getDimensionPixelSize(r0, r14)
            r11.f20159e = r14
            int r14 = bf.l.TabLayout_tabPaddingTop
            int r0 = r11.f20161f
            int r14 = r13.getDimensionPixelSize(r14, r0)
            r11.f20161f = r14
            int r14 = bf.l.TabLayout_tabPaddingEnd
            int r0 = r11.f20163g
            int r14 = r13.getDimensionPixelSize(r14, r0)
            r11.f20163g = r14
            int r14 = bf.l.TabLayout_tabPaddingBottom
            int r0 = r11.f20165h
            int r14 = r13.getDimensionPixelSize(r14, r0)
            r11.f20165h = r14
            boolean r14 = com.google.android.material.internal.p.g(r7)
            if (r14 == 0) goto L_0x00f6
            int r14 = bf.b.textAppearanceTitleSmall
            r11.f20166j = r14
            goto L_0x00fa
        L_0x00f6:
            int r14 = bf.b.textAppearanceButton
            r11.f20166j = r14
        L_0x00fa:
            int r14 = bf.k.TextAppearance_Design_Tab
            int r14 = r13.getResourceId(r10, r14)
            r11.f20167k = r14
            int[] r0 = d.j.TextAppearance
            android.content.res.TypedArray r1 = r7.obtainStyledAttributes(r14, r0)
            int r2 = d.j.TextAppearance_android_textSize     // Catch:{ all -> 0x0219 }
            int r3 = r1.getDimensionPixelSize(r2, r6)     // Catch:{ all -> 0x0219 }
            float r3 = (float) r3     // Catch:{ all -> 0x0219 }
            r11.f20175x = r3     // Catch:{ all -> 0x0219 }
            int r3 = d.j.TextAppearance_android_textColor     // Catch:{ all -> 0x0219 }
            android.content.res.ColorStateList r4 = qf.c.a(r7, r1, r3)     // Catch:{ all -> 0x0219 }
            r11.f20169m = r4     // Catch:{ all -> 0x0219 }
            r1.recycle()
            int r1 = bf.l.TabLayout_tabSelectedTextAppearance
            boolean r4 = r13.hasValue(r1)
            if (r4 == 0) goto L_0x012a
            int r14 = r13.getResourceId(r1, r14)
            r11.f20168l = r14
        L_0x012a:
            int r14 = r11.f20168l
            if (r14 == r12) goto L_0x0166
            android.content.res.TypedArray r14 = r7.obtainStyledAttributes(r14, r0)
            float r0 = r11.f20175x     // Catch:{ all -> 0x0161 }
            int r0 = (int) r0     // Catch:{ all -> 0x0161 }
            int r0 = r14.getDimensionPixelSize(r2, r0)     // Catch:{ all -> 0x0161 }
            float r0 = (float) r0     // Catch:{ all -> 0x0161 }
            r11.f20176y = r0     // Catch:{ all -> 0x0161 }
            android.content.res.ColorStateList r0 = qf.c.a(r7, r14, r3)     // Catch:{ all -> 0x0161 }
            if (r0 == 0) goto L_0x015d
            android.content.res.ColorStateList r1 = r11.f20169m     // Catch:{ all -> 0x0161 }
            int r1 = r1.getDefaultColor()     // Catch:{ all -> 0x0161 }
            int[] r2 = new int[r9]     // Catch:{ all -> 0x0161 }
            r3 = 16842913(0x10100a1, float:2.369401E-38)
            r2[r6] = r3     // Catch:{ all -> 0x0161 }
            int r3 = r0.getDefaultColor()     // Catch:{ all -> 0x0161 }
            int r0 = r0.getColorForState(r2, r3)     // Catch:{ all -> 0x0161 }
            android.content.res.ColorStateList r0 = t(r1, r0)     // Catch:{ all -> 0x0161 }
            r11.f20169m = r0     // Catch:{ all -> 0x0161 }
        L_0x015d:
            r14.recycle()
            goto L_0x0166
        L_0x0161:
            r12 = move-exception
            r14.recycle()
            throw r12
        L_0x0166:
            int r14 = bf.l.TabLayout_tabTextColor
            boolean r0 = r13.hasValue(r14)
            if (r0 == 0) goto L_0x0174
            android.content.res.ColorStateList r14 = qf.c.a(r7, r13, r14)
            r11.f20169m = r14
        L_0x0174:
            int r14 = bf.l.TabLayout_tabSelectedTextColor
            boolean r0 = r13.hasValue(r14)
            if (r0 == 0) goto L_0x018c
            int r14 = r13.getColor(r14, r6)
            android.content.res.ColorStateList r0 = r11.f20169m
            int r0 = r0.getDefaultColor()
            android.content.res.ColorStateList r14 = t(r0, r14)
            r11.f20169m = r14
        L_0x018c:
            int r14 = bf.l.TabLayout_tabIconTint
            android.content.res.ColorStateList r14 = qf.c.a(r7, r13, r14)
            r11.f20170n = r14
            int r14 = bf.l.TabLayout_tabIconTintMode
            int r14 = r13.getInt(r14, r12)
            r0 = 0
            android.graphics.PorterDuff$Mode r14 = com.google.android.material.internal.r.j(r14, r0)
            r11.f20174w = r14
            int r14 = bf.l.TabLayout_tabRippleColor
            android.content.res.ColorStateList r14 = qf.c.a(r7, r13, r14)
            r11.f20171p = r14
            int r14 = bf.l.TabLayout_tabIndicatorAnimationDuration
            r0 = 300(0x12c, float:4.2E-43)
            int r14 = r13.getInt(r14, r0)
            r11.I = r14
            int r14 = bf.b.motionEasingEmphasizedInterpolator
            android.animation.TimeInterpolator r0 = cf.a.f18978b
            android.animation.TimeInterpolator r14 = of.a.g(r7, r14, r0)
            r11.R = r14
            int r14 = bf.l.TabLayout_tabMinWidth
            int r14 = r13.getDimensionPixelSize(r14, r12)
            r11.D = r14
            int r14 = bf.l.TabLayout_tabMaxWidth
            int r12 = r13.getDimensionPixelSize(r14, r12)
            r11.E = r12
            int r12 = bf.l.TabLayout_tabBackground
            int r12 = r13.getResourceId(r12, r6)
            r11.B = r12
            int r12 = bf.l.TabLayout_tabContentStart
            int r12 = r13.getDimensionPixelSize(r12, r6)
            r11.G = r12
            int r12 = bf.l.TabLayout_tabMode
            int r12 = r13.getInt(r12, r9)
            r11.K = r12
            int r12 = bf.l.TabLayout_tabGravity
            int r12 = r13.getInt(r12, r6)
            r11.H = r12
            int r12 = bf.l.TabLayout_tabInlineLabel
            boolean r12 = r13.getBoolean(r12, r6)
            r11.L = r12
            int r12 = bf.l.TabLayout_tabUnboundedRipple
            boolean r12 = r13.getBoolean(r12, r6)
            r11.P = r12
            r13.recycle()
            android.content.res.Resources r12 = r11.getResources()
            int r13 = bf.d.design_tab_text_size_2line
            int r13 = r12.getDimensionPixelSize(r13)
            float r13 = (float) r13
            r11.f20177z = r13
            int r13 = bf.d.design_tab_scrollable_min_width
            int r12 = r12.getDimensionPixelSize(r13)
            r11.F = r12
            r11.q()
            return
        L_0x0219:
            r12 = move-exception
            r1.recycle()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void addView(View view, int i10) {
        n(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.S;
        if (cVar2 != null) {
            I(cVar2);
        }
        this.S = cVar;
        if (cVar != null) {
            g(cVar);
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    public void setSelectedTabIndicator(int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(e.a.b(getContext(), i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
