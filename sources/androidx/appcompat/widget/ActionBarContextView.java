package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.b;
import androidx.core.view.e2;
import androidx.core.view.n0;
import d.f;
import d.g;
import d.j;

public class ActionBarContextView extends a {

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f939j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f940k;

    /* renamed from: l  reason: collision with root package name */
    private View f941l;

    /* renamed from: m  reason: collision with root package name */
    private View f942m;

    /* renamed from: n  reason: collision with root package name */
    private View f943n;

    /* renamed from: p  reason: collision with root package name */
    private LinearLayout f944p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f945q;

    /* renamed from: t  reason: collision with root package name */
    private TextView f946t;

    /* renamed from: w  reason: collision with root package name */
    private int f947w;

    /* renamed from: x  reason: collision with root package name */
    private int f948x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f949y;

    /* renamed from: z  reason: collision with root package name */
    private int f950z;

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f951a;

        a(b bVar) {
            this.f951a = bVar;
        }

        public void onClick(View view) {
            this.f951a.c();
        }
    }

    public ActionBarContextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void i() {
        int i10;
        if (this.f944p == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f944p = linearLayout;
            this.f945q = (TextView) linearLayout.findViewById(f.action_bar_title);
            this.f946t = (TextView) this.f944p.findViewById(f.action_bar_subtitle);
            if (this.f947w != 0) {
                this.f945q.setTextAppearance(getContext(), this.f947w);
            }
            if (this.f948x != 0) {
                this.f946t.setTextAppearance(getContext(), this.f948x);
            }
        }
        this.f945q.setText(this.f939j);
        this.f946t.setText(this.f940k);
        boolean z10 = !TextUtils.isEmpty(this.f939j);
        boolean z11 = !TextUtils.isEmpty(this.f940k);
        TextView textView = this.f946t;
        int i11 = 0;
        if (z11) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView.setVisibility(i10);
        LinearLayout linearLayout2 = this.f944p;
        if (!z10 && !z11) {
            i11 = 8;
        }
        linearLayout2.setVisibility(i11);
        if (this.f944p.getParent() == null) {
            addView(this.f944p);
        }
    }

    public /* bridge */ /* synthetic */ e2 f(int i10, long j10) {
        return super.f(i10, j10);
    }

    public void g() {
        if (this.f941l == null) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f940k;
    }

    public CharSequence getTitle() {
        return this.f939j;
    }

    public void h(b bVar) {
        View view = this.f941l;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f950z, this, false);
            this.f941l = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f941l);
        }
        View findViewById = this.f941l.findViewById(f.action_mode_close_button);
        this.f942m = findViewById;
        findViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f1189d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.y();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f1189d = actionMenuPresenter2;
        actionMenuPresenter2.J(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.c(this.f1189d, this.f1187b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1189d.o(this);
        this.f1188c = actionMenuView;
        n0.w0(actionMenuView, (Drawable) null);
        addView(this.f1188c, layoutParams);
    }

    public boolean j() {
        return this.f949y;
    }

    public void k() {
        removeAllViews();
        this.f943n = null;
        this.f1188c = null;
        this.f1189d = null;
        View view = this.f942m;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f1189d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.K();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1189d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
            this.f1189d.C();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        boolean b10 = t1.b(this);
        if (b10) {
            i14 = (i12 - i10) - getPaddingRight();
        } else {
            i14 = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f941l;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f941l.getLayoutParams();
            if (b10) {
                i16 = marginLayoutParams.rightMargin;
            } else {
                i16 = marginLayoutParams.leftMargin;
            }
            if (b10) {
                i17 = marginLayoutParams.leftMargin;
            } else {
                i17 = marginLayoutParams.rightMargin;
            }
            int d10 = a.d(i14, i16, b10);
            i14 = a.d(d10 + e(this.f941l, d10, paddingTop, paddingTop2, b10), i17, b10);
        }
        int i18 = i14;
        LinearLayout linearLayout = this.f944p;
        if (!(linearLayout == null || this.f943n != null || linearLayout.getVisibility() == 8)) {
            i18 += e(this.f944p, i18, paddingTop, paddingTop2, b10);
        }
        int i19 = i18;
        View view2 = this.f943n;
        if (view2 != null) {
            e(view2, i19, paddingTop, paddingTop2, b10);
        }
        if (b10) {
            i15 = getPaddingLeft();
        } else {
            i15 = (i12 - i10) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f1188c;
        if (actionMenuView != null) {
            e(actionMenuView, i15, paddingTop, paddingTop2, !b10);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean z10;
        int i13;
        int i14 = 1073741824;
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i11) != 0) {
            int size = View.MeasureSpec.getSize(i10);
            int i15 = this.f1190e;
            if (i15 <= 0) {
                i15 = View.MeasureSpec.getSize(i11);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i16 = i15 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE);
            View view = this.f941l;
            if (view != null) {
                int c10 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f941l.getLayoutParams();
                paddingLeft = c10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f1188c;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f1188c, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f944p;
            if (linearLayout != null && this.f943n == null) {
                if (this.f949y) {
                    this.f944p.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f944p.getMeasuredWidth();
                    if (measuredWidth <= paddingLeft) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        paddingLeft -= measuredWidth;
                    }
                    LinearLayout linearLayout2 = this.f944p;
                    if (z10) {
                        i13 = 0;
                    } else {
                        i13 = 8;
                    }
                    linearLayout2.setVisibility(i13);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f943n;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i17 = layoutParams.width;
                if (i17 != -2) {
                    i12 = 1073741824;
                } else {
                    i12 = Integer.MIN_VALUE;
                }
                if (i17 >= 0) {
                    paddingLeft = Math.min(i17, paddingLeft);
                }
                int i18 = layoutParams.height;
                if (i18 == -2) {
                    i14 = Integer.MIN_VALUE;
                }
                if (i18 >= 0) {
                    i16 = Math.min(i18, i16);
                }
                this.f943n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i12), View.MeasureSpec.makeMeasureSpec(i16, i14));
            }
            if (this.f1190e <= 0) {
                int childCount = getChildCount();
                int i19 = 0;
                for (int i20 = 0; i20 < childCount; i20++) {
                    int measuredHeight = getChildAt(i20).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i19) {
                        i19 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i19);
                return;
            }
            setMeasuredDimension(size, i15);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i10) {
        this.f1190e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f943n;
        if (view2 != null) {
            removeView(view2);
        }
        this.f943n = view;
        if (!(view == null || (linearLayout = this.f944p) == null)) {
            removeView(linearLayout);
            this.f944p = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f940k = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f939j = charSequence;
        i();
        n0.v0(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f949y) {
            requestLayout();
        }
        this.f949y = z10;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h1 v10 = h1.v(context, attributeSet, j.ActionMode, i10, 0);
        n0.w0(this, v10.g(j.ActionMode_background));
        this.f947w = v10.n(j.ActionMode_titleTextStyle, 0);
        this.f948x = v10.n(j.ActionMode_subtitleTextStyle, 0);
        this.f1190e = v10.m(j.ActionMode_height, 0);
        this.f950z = v10.n(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        v10.w();
    }
}
