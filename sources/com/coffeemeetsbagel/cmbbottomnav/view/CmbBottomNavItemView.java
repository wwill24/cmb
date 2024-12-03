package com.coffeemeetsbagel.cmbbottomnav.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import lc.j;
import v5.a;
import v5.b;
import v5.c;
import v5.d;
import v5.f;
import w9.b;

public class CmbBottomNavItemView extends ConstraintLayout {
    private CmbImageView F;
    private CmbTextView G;
    private CmbTextView H;
    int I = ((int) getContext().getResources().getDimension(b.avatar_size));
    int J = ((int) getContext().getResources().getDimension(b.two_dp));
    int K = ((int) getContext().getResources().getDimension(b.zero_dp));

    private enum SelectedState {
        SELECTED,
        NOT_SELECTED
    }

    public CmbBottomNavItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean C(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            E();
            return true;
        } else if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            return false;
        } else {
            F();
            if (motionEvent.getAction() == 1) {
                performClick();
            }
            return true;
        }
    }

    private void D(String str, List<w9.b> list) {
        if (str != null) {
            com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
            Context context = getContext();
            CmbImageView cmbImageView = this.F;
            Integer valueOf = Integer.valueOf(c.ic_avatar_placeholder);
            int i10 = this.I;
            bVar.b(context, str, cmbImageView, valueOf, (Integer) null, new ImageLoaderContract.b(i10, i10), list, Collections.emptyMap(), (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
            return;
        }
        com.coffeemeetsbagel.image_loader.b bVar2 = com.coffeemeetsbagel.image_loader.b.f13967a;
        Context context2 = getContext();
        int i11 = c.ic_avatar_placeholder;
        CmbImageView cmbImageView2 = this.F;
        int i12 = this.I;
        bVar2.a(context2, i11, cmbImageView2, new ImageLoaderContract.b(i12, i12), list, (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null);
    }

    private void E() {
        animate().scaleX(0.9f).setDuration(100).start();
        animate().scaleY(0.9f).setDuration(100).start();
    }

    private void F() {
        animate().scaleX(1.0f).setDuration(100).start();
        animate().scaleY(1.0f).setDuration(100).start();
    }

    public void G() {
        this.G.setBackgroundDrawable(getContext().getResources().getDrawable(c.bottom_nav_badge_boost));
    }

    public void H(Boolean bool, String str) {
        int i10;
        CmbTextView cmbTextView = this.G;
        if (bool.booleanValue()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        cmbTextView.setVisibility(i10);
        if (str != null) {
            this.G.setText(str);
        }
    }

    public void I(int i10, String str) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(a.main_color, typedValue, true);
        int i11 = typedValue.data;
        if (i10 != d.bottom_nav_item_badge_profile) {
            Drawable drawable = this.F.getDrawable();
            drawable.clearColorFilter();
            drawable.setColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
            drawable.invalidateSelf();
        } else {
            setProfileIconSelectedState(str);
        }
        this.H.setTextColor(i11);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.F = (CmbImageView) findViewById(d.cmb_bottom_nav_item_icon);
        this.G = (CmbTextView) findViewById(d.cmb_bottom_nav_item_badge);
        this.H = (CmbTextView) findViewById(d.cmb_bottom_nav_item_title);
        setOnTouchListener(new z5.a(this));
    }

    public void setIcon(Drawable drawable) {
        this.F.setImageDrawable(drawable);
    }

    public void setProfileIconFromUrl(String str) {
        Object tag = this.F.getTag();
        SelectedState selectedState = SelectedState.NOT_SELECTED;
        if (tag != selectedState) {
            D(str, Arrays.asList(new w9.b[]{b.a.f18329a, new b.d(this.K, this.J, j.f41113a.a(getContext(), a.light_gray))}));
            this.F.setTag(selectedState);
        }
    }

    public void setProfileIconSelectedState(String str) {
        int a10 = j.f41113a.a(getContext(), a.main_color);
        Object tag = this.F.getTag();
        SelectedState selectedState = SelectedState.SELECTED;
        if (tag != selectedState) {
            D(str, Arrays.asList(new w9.b[]{b.a.f18329a, new b.d(this.K, this.J, a10)}));
            this.F.setTag(selectedState);
        }
    }

    public void setTitle(String str) {
        this.H.setText(str);
    }

    public void setUnselected(String str) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(a.icon_gray, typedValue, true);
        int i10 = typedValue.data;
        Drawable drawable = this.F.getDrawable();
        if (this.H.getText() != "" && drawable != null) {
            if (this.H.getText().equals(getContext().getString(f.f18072me))) {
                setProfileIconFromUrl(str);
            } else {
                drawable.clearColorFilter();
                drawable.invalidateSelf();
            }
            this.H.setTextColor(i10);
        }
    }
}
