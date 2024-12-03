package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.h1;
import androidx.core.view.n0;
import d.a;
import d.f;
import d.g;
import d.j;

public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    private i f728a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f729b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f730c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f731d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f732e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f733f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f734g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f735h;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f736j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f737k;

    /* renamed from: l  reason: collision with root package name */
    private int f738l;

    /* renamed from: m  reason: collision with root package name */
    private Context f739m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f740n;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f741p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f742q;

    /* renamed from: t  reason: collision with root package name */
    private LayoutInflater f743t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f744w;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.listMenuViewStyle);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i10) {
        LinearLayout linearLayout = this.f736j;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, this, false);
        this.f732e = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, this, false);
        this.f729b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, this, false);
        this.f730c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f743t == null) {
            this.f743t = LayoutInflater.from(getContext());
        }
        return this.f743t;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        int i10;
        ImageView imageView = this.f734g;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f735h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f735h.getLayoutParams();
            rect.top += this.f735h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public void c(i iVar, int i10) {
        int i11;
        this.f728a = iVar;
        if (iVar.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        h(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    public boolean d() {
        return false;
    }

    public i getItemData() {
        return this.f728a;
    }

    public void h(boolean z10, char c10) {
        int i10;
        if (!z10 || !this.f728a.A()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            this.f733f.setText(this.f728a.h());
        }
        if (this.f733f.getVisibility() != i10) {
            this.f733f.setVisibility(i10);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        n0.w0(this, this.f737k);
        TextView textView = (TextView) findViewById(f.title);
        this.f731d = textView;
        int i10 = this.f738l;
        if (i10 != -1) {
            textView.setTextAppearance(this.f739m, i10);
        }
        this.f733f = (TextView) findViewById(f.shortcut);
        ImageView imageView = (ImageView) findViewById(f.submenuarrow);
        this.f734g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f741p);
        }
        this.f735h = (ImageView) findViewById(f.group_divider);
        this.f736j = (LinearLayout) findViewById(f.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f729b != null && this.f740n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f729b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        View view;
        CompoundButton compoundButton;
        if (z10 || this.f730c != null || this.f732e != null) {
            if (this.f728a.m()) {
                if (this.f730c == null) {
                    g();
                }
                compoundButton = this.f730c;
                view = this.f732e;
            } else {
                if (this.f732e == null) {
                    e();
                }
                compoundButton = this.f732e;
                view = this.f730c;
            }
            if (z10) {
                compoundButton.setChecked(this.f728a.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f732e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f730c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f728a.m()) {
            if (this.f730c == null) {
                g();
            }
            compoundButton = this.f730c;
        } else {
            if (this.f732e == null) {
                e();
            }
            compoundButton = this.f732e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f744w = z10;
        this.f740n = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        int i10;
        ImageView imageView = this.f735h;
        if (imageView != null) {
            if (this.f742q || !z10) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            imageView.setVisibility(i10);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10;
        if (this.f728a.z() || this.f744w) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || this.f740n) {
            ImageView imageView = this.f729b;
            if (imageView != null || drawable != null || this.f740n) {
                if (imageView == null) {
                    f();
                }
                if (drawable != null || this.f740n) {
                    ImageView imageView2 = this.f729b;
                    if (!z10) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f729b.getVisibility() != 0) {
                        this.f729b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f729b.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f731d.setText(charSequence);
            if (this.f731d.getVisibility() != 0) {
                this.f731d.setVisibility(0);
            }
        } else if (this.f731d.getVisibility() != 8) {
            this.f731d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        h1 v10 = h1.v(getContext(), attributeSet, j.MenuView, i10, 0);
        this.f737k = v10.g(j.MenuView_android_itemBackground);
        this.f738l = v10.n(j.MenuView_android_itemTextAppearance, -1);
        this.f740n = v10.a(j.MenuView_preserveIconSpacing, false);
        this.f739m = context;
        this.f741p = v10.g(j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, a.dropDownListViewStyle, 0);
        this.f742q = obtainStyledAttributes.hasValue(0);
        v10.w();
        obtainStyledAttributes.recycle();
    }
}
