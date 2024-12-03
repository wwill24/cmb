package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import c3.f;
import c3.j;
import d3.c;
import d3.e;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import w2.d;

public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: q  reason: collision with root package name */
    private static final String f8458q = LottieAnimationView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static final e0<Throwable> f8459t = new f();

    /* renamed from: a  reason: collision with root package name */
    private final e0<h> f8460a = new e(this);

    /* renamed from: b  reason: collision with root package name */
    private final e0<Throwable> f8461b = new a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public e0<Throwable> f8462c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f8463d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f8464e = new LottieDrawable();

    /* renamed from: f  reason: collision with root package name */
    private String f8465f;

    /* renamed from: g  reason: collision with root package name */
    private int f8466g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8467h = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8468j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8469k = true;

    /* renamed from: l  reason: collision with root package name */
    private final Set<UserActionTaken> f8470l = new HashSet();

    /* renamed from: m  reason: collision with root package name */
    private final Set<g0> f8471m = new HashSet();

    /* renamed from: n  reason: collision with root package name */
    private k0<h> f8472n;

    /* renamed from: p  reason: collision with root package name */
    private h f8473p;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f8474a;

        /* renamed from: b  reason: collision with root package name */
        int f8475b;

        /* renamed from: c  reason: collision with root package name */
        float f8476c;

        /* renamed from: d  reason: collision with root package name */
        boolean f8477d;

        /* renamed from: e  reason: collision with root package name */
        String f8478e;

        /* renamed from: f  reason: collision with root package name */
        int f8479f;

        /* renamed from: g  reason: collision with root package name */
        int f8480g;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (a) null);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f8474a);
            parcel.writeFloat(this.f8476c);
            parcel.writeInt(this.f8477d ? 1 : 0);
            parcel.writeString(this.f8478e);
            parcel.writeInt(this.f8479f);
            parcel.writeInt(this.f8480g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f8474a = parcel.readString();
            this.f8476c = parcel.readFloat();
            this.f8477d = parcel.readInt() != 1 ? false : true;
            this.f8478e = parcel.readString();
            this.f8479f = parcel.readInt();
            this.f8480g = parcel.readInt();
        }
    }

    private enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    class a implements e0<Throwable> {
        a() {
        }

        /* renamed from: a */
        public void onResult(Throwable th2) {
            e0 e0Var;
            if (LottieAnimationView.this.f8463d != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f8463d);
            }
            if (LottieAnimationView.this.f8462c == null) {
                e0Var = LottieAnimationView.f8459t;
            } else {
                e0Var = LottieAnimationView.this.f8462c;
            }
            e0Var.onResult(th2);
        }
    }

    class b extends c<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f8489d;

        b(e eVar) {
            this.f8489d = eVar;
        }

        public T a(d3.b<T> bVar) {
            return this.f8489d.a(bVar);
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s(attributeSet, n0.lottieAnimationViewStyle);
    }

    private void D() {
        boolean t10 = t();
        setImageDrawable((Drawable) null);
        setImageDrawable(this.f8464e);
        if (t10) {
            this.f8464e.v0();
        }
    }

    private void E(float f10, boolean z10) {
        if (z10) {
            this.f8470l.add(UserActionTaken.SET_PROGRESS);
        }
        this.f8464e.S0(f10);
    }

    private void n() {
        k0<h> k0Var = this.f8472n;
        if (k0Var != null) {
            k0Var.j(this.f8460a);
            this.f8472n.i(this.f8461b);
        }
    }

    private void o() {
        this.f8473p = null;
        this.f8464e.u();
    }

    private k0<h> q(String str) {
        if (isInEditMode()) {
            return new k0<>(new g(this, str), true);
        }
        if (this.f8469k) {
            return p.j(getContext(), str);
        }
        return p.k(getContext(), str, (String) null);
    }

    private k0<h> r(int i10) {
        if (isInEditMode()) {
            return new k0<>(new d(this, i10), true);
        }
        if (this.f8469k) {
            return p.s(getContext(), i10);
        }
        return p.t(getContext(), i10, (String) null);
    }

    private void s(AttributeSet attributeSet, int i10) {
        String string;
        boolean z10 = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o0.LottieAnimationView, i10, 0);
        this.f8469k = obtainStyledAttributes.getBoolean(o0.LottieAnimationView_lottie_cacheComposition, true);
        int i11 = o0.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i11);
        int i12 = o0.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i12);
        int i13 = o0.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i13);
        if (!hasValue || !hasValue2) {
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(i11, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(i12);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(i13)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(o0.LottieAnimationView_lottie_fallbackRes, 0));
            if (obtainStyledAttributes.getBoolean(o0.LottieAnimationView_lottie_autoPlay, false)) {
                this.f8468j = true;
            }
            if (obtainStyledAttributes.getBoolean(o0.LottieAnimationView_lottie_loop, false)) {
                this.f8464e.U0(-1);
            }
            int i14 = o0.LottieAnimationView_lottie_repeatMode;
            if (obtainStyledAttributes.hasValue(i14)) {
                setRepeatMode(obtainStyledAttributes.getInt(i14, 1));
            }
            int i15 = o0.LottieAnimationView_lottie_repeatCount;
            if (obtainStyledAttributes.hasValue(i15)) {
                setRepeatCount(obtainStyledAttributes.getInt(i15, -1));
            }
            int i16 = o0.LottieAnimationView_lottie_speed;
            if (obtainStyledAttributes.hasValue(i16)) {
                setSpeed(obtainStyledAttributes.getFloat(i16, 1.0f));
            }
            int i17 = o0.LottieAnimationView_lottie_clipToCompositionBounds;
            if (obtainStyledAttributes.hasValue(i17)) {
                setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i17, true));
            }
            int i18 = o0.LottieAnimationView_lottie_defaultFontFileExtension;
            if (obtainStyledAttributes.hasValue(i18)) {
                setDefaultFontFileExtension(obtainStyledAttributes.getString(i18));
            }
            setImageAssetsFolder(obtainStyledAttributes.getString(o0.LottieAnimationView_lottie_imageAssetsFolder));
            int i19 = o0.LottieAnimationView_lottie_progress;
            E(obtainStyledAttributes.getFloat(i19, 0.0f), obtainStyledAttributes.hasValue(i19));
            p(obtainStyledAttributes.getBoolean(o0.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
            int i20 = o0.LottieAnimationView_lottie_colorFilter;
            if (obtainStyledAttributes.hasValue(i20)) {
                k(new d("**"), h0.K, new c(new p0(e.a.a(getContext(), obtainStyledAttributes.getResourceId(i20, -1)).getDefaultColor())));
            }
            int i21 = o0.LottieAnimationView_lottie_renderMode;
            if (obtainStyledAttributes.hasValue(i21)) {
                RenderMode renderMode = RenderMode.AUTOMATIC;
                int i22 = obtainStyledAttributes.getInt(i21, renderMode.ordinal());
                if (i22 >= RenderMode.values().length) {
                    i22 = renderMode.ordinal();
                }
                setRenderMode(RenderMode.values()[i22]);
            }
            setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(o0.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
            int i23 = o0.LottieAnimationView_lottie_useCompositionFrameRate;
            if (obtainStyledAttributes.hasValue(i23)) {
                setUseCompositionFrameRate(obtainStyledAttributes.getBoolean(i23, false));
            }
            obtainStyledAttributes.recycle();
            LottieDrawable lottieDrawable = this.f8464e;
            if (j.f(getContext()) != 0.0f) {
                z10 = true;
            }
            lottieDrawable.Y0(Boolean.valueOf(z10));
            return;
        }
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }

    private void setCompositionTask(k0<h> k0Var) {
        this.f8470l.add(UserActionTaken.SET_ANIMATION);
        o();
        n();
        this.f8472n = k0Var.d(this.f8460a).c(this.f8461b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ i0 u(String str) throws Exception {
        if (this.f8469k) {
            return p.l(getContext(), str);
        }
        return p.m(getContext(), str, (String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ i0 v(int i10) throws Exception {
        if (this.f8469k) {
            return p.u(getContext(), i10);
        }
        return p.v(getContext(), i10, (String) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void w(Throwable th2) {
        if (j.k(th2)) {
            f.d("Unable to load composition.", th2);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th2);
    }

    public void A() {
        this.f8464e.s0();
    }

    public void B(InputStream inputStream, String str) {
        setCompositionTask(p.n(inputStream, str));
    }

    public void C(String str, String str2) {
        B(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public boolean getClipToCompositionBounds() {
        return this.f8464e.F();
    }

    public h getComposition() {
        return this.f8473p;
    }

    public long getDuration() {
        h hVar = this.f8473p;
        if (hVar != null) {
            return (long) hVar.d();
        }
        return 0;
    }

    public int getFrame() {
        return this.f8464e.J();
    }

    public String getImageAssetsFolder() {
        return this.f8464e.L();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f8464e.N();
    }

    public float getMaxFrame() {
        return this.f8464e.O();
    }

    public float getMinFrame() {
        return this.f8464e.P();
    }

    public m0 getPerformanceTracker() {
        return this.f8464e.Q();
    }

    public float getProgress() {
        return this.f8464e.R();
    }

    public RenderMode getRenderMode() {
        return this.f8464e.S();
    }

    public int getRepeatCount() {
        return this.f8464e.T();
    }

    public int getRepeatMode() {
        return this.f8464e.U();
    }

    public float getSpeed() {
        return this.f8464e.V();
    }

    public void i(Animator.AnimatorListener animatorListener) {
        this.f8464e.p(animatorListener);
    }

    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).S() == RenderMode.SOFTWARE) {
            this.f8464e.invalidateSelf();
        }
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f8464e;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean j(@NonNull g0 g0Var) {
        h hVar = this.f8473p;
        if (hVar != null) {
            g0Var.a(hVar);
        }
        return this.f8471m.add(g0Var);
    }

    public <T> void k(d dVar, T t10, c<T> cVar) {
        this.f8464e.q(dVar, t10, cVar);
    }

    public <T> void l(d dVar, T t10, e<T> eVar) {
        this.f8464e.q(dVar, t10, new b(eVar));
    }

    public void m() {
        this.f8470l.add(UserActionTaken.PLAY_OPTION);
        this.f8464e.t();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.f8468j) {
            this.f8464e.q0();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8465f = savedState.f8474a;
        Set<UserActionTaken> set = this.f8470l;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.f8465f)) {
            setAnimation(this.f8465f);
        }
        this.f8466g = savedState.f8475b;
        if (!this.f8470l.contains(userActionTaken) && (i10 = this.f8466g) != 0) {
            setAnimation(i10);
        }
        if (!this.f8470l.contains(UserActionTaken.SET_PROGRESS)) {
            E(savedState.f8476c, false);
        }
        if (!this.f8470l.contains(UserActionTaken.PLAY_OPTION) && savedState.f8477d) {
            y();
        }
        if (!this.f8470l.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f8478e);
        }
        if (!this.f8470l.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f8479f);
        }
        if (!this.f8470l.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.f8480g);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8474a = this.f8465f;
        savedState.f8475b = this.f8466g;
        savedState.f8476c = this.f8464e.R();
        savedState.f8477d = this.f8464e.a0();
        savedState.f8478e = this.f8464e.L();
        savedState.f8479f = this.f8464e.U();
        savedState.f8480g = this.f8464e.T();
        return savedState;
    }

    public void p(boolean z10) {
        this.f8464e.z(z10);
    }

    public void setAnimation(int i10) {
        this.f8466g = i10;
        this.f8465f = null;
        setCompositionTask(r(i10));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        C(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        k0<h> k0Var;
        if (this.f8469k) {
            k0Var = p.w(getContext(), str);
        } else {
            k0Var = p.x(getContext(), str, (String) null);
        }
        setCompositionTask(k0Var);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.f8464e.x0(z10);
    }

    public void setCacheComposition(boolean z10) {
        this.f8469k = z10;
    }

    public void setClipToCompositionBounds(boolean z10) {
        this.f8464e.y0(z10);
    }

    public void setComposition(@NonNull h hVar) {
        if (c.f8524a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Set Composition \n");
            sb2.append(hVar);
        }
        this.f8464e.setCallback(this);
        this.f8473p = hVar;
        this.f8467h = true;
        boolean z02 = this.f8464e.z0(hVar);
        this.f8467h = false;
        if (getDrawable() != this.f8464e || z02) {
            if (!z02) {
                D();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (g0 a10 : this.f8471m) {
                a10.a(hVar);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f8464e.A0(str);
    }

    public void setFailureListener(e0<Throwable> e0Var) {
        this.f8462c = e0Var;
    }

    public void setFallbackResource(int i10) {
        this.f8463d = i10;
    }

    public void setFontAssetDelegate(a aVar) {
        this.f8464e.B0(aVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.f8464e.C0(map);
    }

    public void setFrame(int i10) {
        this.f8464e.D0(i10);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z10) {
        this.f8464e.E0(z10);
    }

    public void setImageAssetDelegate(b bVar) {
        this.f8464e.F0(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f8464e.G0(str);
    }

    public void setImageBitmap(Bitmap bitmap) {
        n();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        n();
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i10) {
        n();
        super.setImageResource(i10);
    }

    public void setMaintainOriginalImageBounds(boolean z10) {
        this.f8464e.H0(z10);
    }

    public void setMaxFrame(int i10) {
        this.f8464e.I0(i10);
    }

    public void setMaxProgress(float f10) {
        this.f8464e.K0(f10);
    }

    public void setMinAndMaxFrame(String str) {
        this.f8464e.M0(str);
    }

    public void setMinFrame(int i10) {
        this.f8464e.N0(i10);
    }

    public void setMinProgress(float f10) {
        this.f8464e.P0(f10);
    }

    public void setOutlineMasksAndMattes(boolean z10) {
        this.f8464e.Q0(z10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f8464e.R0(z10);
    }

    public void setProgress(float f10) {
        E(f10, true);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f8464e.T0(renderMode);
    }

    public void setRepeatCount(int i10) {
        this.f8470l.add(UserActionTaken.SET_REPEAT_COUNT);
        this.f8464e.U0(i10);
    }

    public void setRepeatMode(int i10) {
        this.f8470l.add(UserActionTaken.SET_REPEAT_MODE);
        this.f8464e.V0(i10);
    }

    public void setSafeMode(boolean z10) {
        this.f8464e.W0(z10);
    }

    public void setSpeed(float f10) {
        this.f8464e.X0(f10);
    }

    public void setTextDelegate(q0 q0Var) {
        this.f8464e.Z0(q0Var);
    }

    public void setUseCompositionFrameRate(boolean z10) {
        this.f8464e.a1(z10);
    }

    public boolean t() {
        return this.f8464e.Z();
    }

    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.f8467h && drawable == (lottieDrawable = this.f8464e) && lottieDrawable.Z()) {
            x();
        } else if (!this.f8467h && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.Z()) {
                lottieDrawable2.p0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void x() {
        this.f8468j = false;
        this.f8464e.p0();
    }

    public void y() {
        this.f8470l.add(UserActionTaken.PLAY_OPTION);
        this.f8464e.q0();
    }

    public void z() {
        this.f8464e.r0();
    }

    public void setMaxFrame(String str) {
        this.f8464e.J0(str);
    }

    public void setMinFrame(String str) {
        this.f8464e.O0(str);
    }

    public void setAnimation(String str) {
        this.f8465f = str;
        this.f8466g = 0;
        setCompositionTask(q(str));
    }
}
