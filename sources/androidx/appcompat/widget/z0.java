package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.LinearLayoutCompat;

public class z0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: k  reason: collision with root package name */
    private static final Interpolator f1506k = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    Runnable f1507a;

    /* renamed from: b  reason: collision with root package name */
    private c f1508b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayoutCompat f1509c;

    /* renamed from: d  reason: collision with root package name */
    private Spinner f1510d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1511e;

    /* renamed from: f  reason: collision with root package name */
    int f1512f;

    /* renamed from: g  reason: collision with root package name */
    int f1513g;

    /* renamed from: h  reason: collision with root package name */
    private int f1514h;

    /* renamed from: j  reason: collision with root package name */
    private int f1515j;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1516a;

        a(View view) {
            this.f1516a = view;
        }

        public void run() {
            z0.this.smoothScrollTo(this.f1516a.getLeft() - ((z0.this.getWidth() - this.f1516a.getWidth()) / 2), 0);
            z0.this.f1507a = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        public int getCount() {
            return z0.this.f1509c.getChildCount();
        }

        public Object getItem(int i10) {
            return ((d) z0.this.f1509c.getChildAt(i10)).b();
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return z0.this.c((a.c) getItem(i10), true);
            }
            ((d) view).a((a.c) getItem(i10));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            boolean z10;
            ((d) view).b().e();
            int childCount = z0.this.f1509c.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = z0.this.f1509c.getChildAt(i10);
                if (childAt == view) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                childAt.setSelected(z10);
            }
        }
    }

    private class d extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f1520a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f1521b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f1522c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f1523d;

        /* renamed from: e  reason: collision with root package name */
        private View f1524e;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(android.content.Context r6, androidx.appcompat.app.a.c r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.z0.this = r5
                int r5 = d.a.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f1520a = r1
                r4.f1521b = r7
                androidx.appcompat.widget.h1 r5 = androidx.appcompat.widget.h1.v(r6, r0, r1, r5, r3)
                boolean r6 = r5.s(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.w()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z0.d.<init>(androidx.appcompat.widget.z0, android.content.Context, androidx.appcompat.app.a$c, boolean):void");
        }

        public void a(a.c cVar) {
            this.f1521b = cVar;
            c();
        }

        public a.c b() {
            return this.f1521b;
        }

        public void c() {
            a.c cVar = this.f1521b;
            View b10 = cVar.b();
            CharSequence charSequence = null;
            if (b10 != null) {
                ViewParent parent = b10.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b10);
                    }
                    addView(b10);
                }
                this.f1524e = b10;
                TextView textView = this.f1522c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1523d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1523d.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f1524e;
            if (view != null) {
                removeView(view);
                this.f1524e = null;
            }
            Drawable c10 = cVar.c();
            CharSequence d10 = cVar.d();
            if (c10 != null) {
                if (this.f1523d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1523d = appCompatImageView;
                }
                this.f1523d.setImageDrawable(c10);
                this.f1523d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1523d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1523d.setImageDrawable((Drawable) null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(d10);
            if (z10) {
                if (this.f1522c == null) {
                    d0 d0Var = new d0(getContext(), (AttributeSet) null, d.a.actionBarTabTextStyle);
                    d0Var.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    d0Var.setLayoutParams(layoutParams2);
                    addView(d0Var);
                    this.f1522c = d0Var;
                }
                this.f1522c.setText(d10);
                this.f1522c.setVisibility(0);
            } else {
                TextView textView2 = this.f1522c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1522c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1523d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            if (!z10) {
                charSequence = cVar.a();
            }
            n1.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i10, int i11) {
            int i12;
            super.onMeasure(i10, i11);
            if (z0.this.f1512f > 0 && getMeasuredWidth() > (i12 = z0.this.f1512f)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
            }
        }

        public void setSelected(boolean z10) {
            boolean z11;
            if (isSelected() != z10) {
                z11 = true;
            } else {
                z11 = false;
            }
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, d.a.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private boolean d() {
        Spinner spinner = this.f1510d;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (!d()) {
            if (this.f1510d == null) {
                this.f1510d = b();
            }
            removeView(this.f1509c);
            addView(this.f1510d, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1510d.getAdapter() == null) {
                this.f1510d.setAdapter(new b());
            }
            Runnable runnable = this.f1507a;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f1507a = null;
            }
            this.f1510d.setSelection(this.f1515j);
        }
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1510d);
        addView(this.f1509c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1510d.getSelectedItemPosition());
        return false;
    }

    public void a(int i10) {
        View childAt = this.f1509c.getChildAt(i10);
        Runnable runnable = this.f1507a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f1507a = aVar;
        post(aVar);
    }

    /* access modifiers changed from: package-private */
    public d c(a.c cVar, boolean z10) {
        d dVar = new d(getContext(), cVar, z10);
        if (z10) {
            dVar.setBackgroundDrawable((Drawable) null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1514h));
        } else {
            dVar.setFocusable(true);
            if (this.f1508b == null) {
                this.f1508b = new c();
            }
            dVar.setOnClickListener(this.f1508b);
        }
        return dVar;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1507a;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(getContext());
        setContentHeight(b10.f());
        this.f1513g = b10.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1507a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((d) view).b().e();
    }

    public void onMeasure(int i10, int i11) {
        boolean z10;
        int mode = View.MeasureSpec.getMode(i10);
        boolean z11 = true;
        if (mode == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        setFillViewport(z10);
        int childCount = this.f1509c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1512f = -1;
        } else {
            if (childCount > 2) {
                this.f1512f = (int) (((float) View.MeasureSpec.getSize(i10)) * 0.4f);
            } else {
                this.f1512f = View.MeasureSpec.getSize(i10) / 2;
            }
            this.f1512f = Math.min(this.f1512f, this.f1513g);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1514h, 1073741824);
        if (z10 || !this.f1511e) {
            z11 = false;
        }
        if (z11) {
            this.f1509c.measure(0, makeMeasureSpec);
            if (this.f1509c.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i10, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z10 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1515j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z10) {
        this.f1511e = z10;
    }

    public void setContentHeight(int i10) {
        this.f1514h = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        boolean z10;
        this.f1515j = i10;
        int childCount = this.f1509c.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.f1509c.getChildAt(i11);
            if (i11 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            childAt.setSelected(z10);
            if (z10) {
                a(i10);
            }
        }
        Spinner spinner = this.f1510d;
        if (spinner != null && i10 >= 0) {
            spinner.setSelection(i10);
        }
    }
}
