package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import bf.d;
import bf.k;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.c;
import com.google.android.material.internal.f;
import com.google.android.material.internal.q;
import f.b;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import tf.h;

public class SearchView extends FrameLayout implements CoordinatorLayout.b {
    private static final int B = k.Widget_Material3_SearchView;

    /* renamed from: a  reason: collision with root package name */
    final ClippableRoundedCornerLayout f20004a;

    /* renamed from: b  reason: collision with root package name */
    final View f20005b;

    /* renamed from: c  reason: collision with root package name */
    final View f20006c;

    /* renamed from: d  reason: collision with root package name */
    final FrameLayout f20007d;

    /* renamed from: e  reason: collision with root package name */
    final MaterialToolbar f20008e;

    /* renamed from: f  reason: collision with root package name */
    final TextView f20009f;

    /* renamed from: g  reason: collision with root package name */
    final EditText f20010g;

    /* renamed from: h  reason: collision with root package name */
    final TouchObserverFrameLayout f20011h;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f20012j;

    /* renamed from: k  reason: collision with root package name */
    private final kf.a f20013k;

    /* renamed from: l  reason: collision with root package name */
    private final Set<a> f20014l;

    /* renamed from: m  reason: collision with root package name */
    private SearchBar f20015m;

    /* renamed from: n  reason: collision with root package name */
    private int f20016n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f20017p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f20018q;

    /* renamed from: t  reason: collision with root package name */
    private boolean f20019t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f20020w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f20021x;
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    private TransitionState f20022y;

    /* renamed from: z  reason: collision with root package name */
    private Map<View, Integer> f20023z;

    public static class Behavior extends CoordinatorLayout.c<SearchView> {
        public Behavior() {
        }

        /* renamed from: E */
        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SearchView searchView, @NonNull View view) {
            if (searchView.b() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }

        public Behavior(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        String f20024c;

        /* renamed from: d  reason: collision with root package name */
        int f20025d;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
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

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f20024c);
            parcel.writeInt(this.f20025d);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f20024c = parcel.readString();
            this.f20025d = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    public interface a {
        void a(@NonNull SearchView searchView, @NonNull TransitionState transitionState, @NonNull TransitionState transitionState2);
    }

    @SuppressLint({"InlinedApi"})
    private void c(ViewGroup viewGroup, boolean z10) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != this) {
                if (childAt.findViewById(this.f20004a.getId()) != null) {
                    c((ViewGroup) childAt, z10);
                } else if (!z10) {
                    Map<View, Integer> map = this.f20023z;
                    if (map != null && map.containsKey(childAt)) {
                        n0.D0(childAt, this.f20023z.get(childAt).intValue());
                    }
                } else {
                    this.f20023z.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    n0.D0(childAt, 4);
                }
            }
        }
    }

    private void d() {
        int i10;
        ImageButton c10 = q.c(this.f20008e);
        if (c10 != null) {
            if (this.f20004a.getVisibility() == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            Drawable q10 = androidx.core.graphics.drawable.a.q(c10.getDrawable());
            if (q10 instanceof b) {
                ((b) q10).b((float) i10);
            }
            if (q10 instanceof f) {
                ((f) q10).a((float) i10);
            }
        }
    }

    private Window getActivityWindow() {
        Activity a10 = c.a(getContext());
        if (a10 == null) {
            return null;
        }
        return a10.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f20015m;
        if (searchBar != null) {
            return searchBar.getCompatElevation();
        }
        return getResources().getDimension(d.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z10) {
        this.f20006c.setVisibility(z10 ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f10) {
        kf.a aVar = this.f20013k;
        if (aVar != null && this.f20005b != null) {
            this.f20005b.setBackgroundColor(aVar.d(f10));
        }
    }

    private void setUpHeaderLayout(int i10) {
        if (i10 != -1) {
            a(LayoutInflater.from(getContext()).inflate(i10, this.f20007d, false));
        }
    }

    private void setUpStatusBarSpacer(int i10) {
        if (this.f20006c.getLayoutParams().height != i10) {
            this.f20006c.getLayoutParams().height = i10;
            this.f20006c.requestLayout();
        }
    }

    public void a(@NonNull View view) {
        this.f20007d.addView(view);
        this.f20007d.setVisibility(0);
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f20012j) {
            this.f20011h.addView(view, i10, layoutParams);
        } else {
            super.addView(view, i10, layoutParams);
        }
    }

    public boolean b() {
        return this.f20015m != null;
    }

    public void e() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f20016n = activityWindow.getAttributes().softInputMode;
        }
    }

    @NonNull
    public CoordinatorLayout.c<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.f20022y;
    }

    @NonNull
    public EditText getEditText() {
        return this.f20010g;
    }

    public CharSequence getHint() {
        return this.f20010g.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.f20009f;
    }

    public CharSequence getSearchPrefixText() {
        return this.f20009f.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f20016n;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f20010g.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.f20008e;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        e();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean z10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setText((CharSequence) savedState.f20024c);
        if (savedState.f20025d == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        setVisible(z10);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        String str;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        if (text == null) {
            str = null;
        } else {
            str = text.toString();
        }
        savedState.f20024c = str;
        savedState.f20025d = this.f20004a.getVisibility();
        return savedState;
    }

    public void setAnimatedNavigationIcon(boolean z10) {
        this.f20017p = z10;
    }

    public void setAutoShowKeyboard(boolean z10) {
        this.f20019t = z10;
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        setUpBackgroundViewElevationOverlay(f10);
    }

    public void setHint(CharSequence charSequence) {
        this.f20010g.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z10) {
        this.f20018q = z10;
    }

    public void setModalForAccessibility(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z10) {
            this.f20023z = new HashMap(viewGroup.getChildCount());
        }
        c(viewGroup, z10);
        if (!z10) {
            this.f20023z = null;
        }
    }

    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        this.f20008e.setOnMenuItemClickListener(hVar);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        int i10;
        this.f20009f.setText(charSequence);
        TextView textView = this.f20009f;
        if (TextUtils.isEmpty(charSequence)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    public void setStatusBarSpacerEnabled(boolean z10) {
        this.f20021x = true;
        setStatusBarSpacerEnabledInternal(z10);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        this.f20010g.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z10) {
        this.f20008e.setTouchscreenBlocksFocus(z10);
    }

    /* access modifiers changed from: package-private */
    public void setTransitionState(@NonNull TransitionState transitionState) {
        if (!this.f20022y.equals(transitionState)) {
            TransitionState transitionState2 = this.f20022y;
            this.f20022y = transitionState;
            for (a a10 : new LinkedHashSet(this.f20014l)) {
                a10.a(this, transitionState2, transitionState);
            }
        }
    }

    public void setUseWindowInsetsController(boolean z10) {
        this.f20020w = z10;
    }

    public void setVisible(boolean z10) {
        boolean z11;
        TransitionState transitionState;
        int i10 = 0;
        if (this.f20004a.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f20004a;
        if (!z10) {
            i10 = 8;
        }
        clippableRoundedCornerLayout.setVisibility(i10);
        d();
        if (z11 != z10) {
            setModalForAccessibility(z10);
        }
        if (z10) {
            transitionState = TransitionState.SHOWN;
        } else {
            transitionState = TransitionState.HIDDEN;
        }
        setTransitionState(transitionState);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f20015m = searchBar;
        throw null;
    }

    public void setHint(int i10) {
        this.f20010g.setHint(i10);
    }

    public void setText(int i10) {
        this.f20010g.setText(i10);
    }
}
