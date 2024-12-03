package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.activity.result.d;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B;\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010&\u001a\u00020\u001c\u0012\u0006\u0010*\u001a\u00020\u001c¢\u0006\u0004\bL\u0010MJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0003J*\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J*\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0012J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0014J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J*\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J\u0012\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010#\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010$\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010%\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u001a\u0010&\u001a\u00020\u001c8\u0004X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u001c8\u0004X\u0004¢\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b+\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u00068\u0014XD¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020\u00068$X¤\u0004¢\u0006\u0006\u001a\u0004\b;\u0010:R\u0013\u0010?\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0013\u0010E\u001a\u0004\u0018\u00010B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010:R\u0014\u0010K\u001a\u00020H8TX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/facebook/FacebookButtonBase;", "Landroid/widget/Button;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "", "parseBackgroundAttributes", "parseCompoundDrawableAttributes", "parseContentAttributes", "parseTextAttributes", "setupOnClickListener", "Landroid/app/Fragment;", "fragment", "setFragment", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "onAttachedToWindow", "Landroid/graphics/Canvas;", "canvas", "onDraw", "getCompoundPaddingLeft", "getCompoundPaddingRight", "", "text", "measureTextWidth", "configureButton", "Landroid/view/View;", "v", "callExternalOnClickListener", "setInternalOnClickListener", "logButtonCreated", "logButtonTapped", "analyticsButtonCreatedEventName", "Ljava/lang/String;", "getAnalyticsButtonCreatedEventName", "()Ljava/lang/String;", "analyticsButtonTappedEventName", "getAnalyticsButtonTappedEventName", "externalOnClickListener", "Landroid/view/View$OnClickListener;", "internalOnClickListener", "", "overrideCompoundPadding", "Z", "overrideCompoundPaddingLeft", "I", "overrideCompoundPaddingRight", "Lcom/facebook/internal/FragmentWrapper;", "parentFragment", "Lcom/facebook/internal/FragmentWrapper;", "defaultStyleResource", "getDefaultStyleResource", "()I", "getDefaultRequestCode", "defaultRequestCode", "getNativeFragment", "()Landroid/app/Fragment;", "nativeFragment", "getFragment", "()Landroidx/fragment/app/Fragment;", "Landroidx/activity/result/d;", "getAndroidxActivityResultRegistryOwner", "()Landroidx/activity/result/d;", "androidxActivityResultRegistryOwner", "getRequestCode", "requestCode", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILjava/lang/String;Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"ResourceType"})
public abstract class FacebookButtonBase extends Button {
    private final String analyticsButtonCreatedEventName;
    private final String analyticsButtonTappedEventName;
    private final int defaultStyleResource;
    private View.OnClickListener externalOnClickListener;
    private View.OnClickListener internalOnClickListener;
    private boolean overrideCompoundPadding;
    private int overrideCompoundPaddingLeft;
    private int overrideCompoundPaddingRight;
    private FragmentWrapper parentFragment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FacebookButtonBase(Context context, AttributeSet attributeSet, int i10, int i11, String str, String str2) {
        super(context, attributeSet, 0);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "analyticsButtonCreatedEventName");
        j.g(str2, "analyticsButtonTappedEventName");
        i11 = i11 == 0 ? getDefaultStyleResource() : i11;
        configureButton(context, attributeSet, i10, i11 == 0 ? R.style.com_facebook_button : i11);
        this.analyticsButtonCreatedEventName = str;
        this.analyticsButtonTappedEventName = str2;
        setClickable(true);
        setFocusable(true);
    }

    private final void parseBackgroundAttributes(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!isInEditMode()) {
                    obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842964}, i10, i11);
                    j.f(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                    if (obtainStyledAttributes.hasValue(0)) {
                        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                        if (resourceId != 0) {
                            setBackgroundResource(resourceId);
                        } else {
                            setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                        }
                    } else {
                        setBackgroundColor(a.getColor(context, R.color.com_facebook_blue));
                    }
                    obtainStyledAttributes.recycle();
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    @SuppressLint({"ResourceType"})
    private final void parseCompoundDrawableAttributes(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, i10, i11);
                j.f(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getResourceId(2, 0), obtainStyledAttributes.getResourceId(3, 0));
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
                obtainStyledAttributes.recycle();
                setCompoundDrawablePadding(dimensionPixelSize);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final void parseContentAttributes(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842966, 16842967, 16842968, 16842969}, i10, i11);
                j.f(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), obtainStyledAttributes.getDimensionPixelSize(1, 0), obtainStyledAttributes.getDimensionPixelSize(2, 0), obtainStyledAttributes.getDimensionPixelSize(3, 0));
                obtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final void parseTextAttributes(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        TypedArray obtainStyledAttributes2;
        TypedArray obtainStyledAttributes3;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842904}, i10, i11);
                j.f(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, colorResources, defStyleAttr, defStyleRes)");
                setTextColor(obtainStyledAttributes.getColorStateList(0));
                obtainStyledAttributes.recycle();
                obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842927}, i10, i11);
                j.f(obtainStyledAttributes2, "context.theme.obtainStyledAttributes(attrs, gravityResources, defStyleAttr, defStyleRes)");
                int i12 = obtainStyledAttributes2.getInt(0, 17);
                obtainStyledAttributes2.recycle();
                setGravity(i12);
                obtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842901, 16842903, 16843087}, i10, i11);
                j.f(obtainStyledAttributes3, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                setTextSize(0, (float) obtainStyledAttributes3.getDimensionPixelSize(0, 0));
                setTypeface(Typeface.create(getTypeface(), 1));
                String string = obtainStyledAttributes3.getString(2);
                obtainStyledAttributes3.recycle();
                setText(string);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final void setupOnClickListener() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.setOnClickListener(new e(this));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupOnClickListener$lambda-0  reason: not valid java name */
    public static final void m16setupOnClickListener$lambda0(FacebookButtonBase facebookButtonBase, View view) {
        if (!CrashShieldHandler.isObjectCrashing(FacebookButtonBase.class)) {
            try {
                j.g(facebookButtonBase, "this$0");
                facebookButtonBase.logButtonTapped(facebookButtonBase.getContext());
                View.OnClickListener onClickListener = facebookButtonBase.internalOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                View.OnClickListener onClickListener2 = facebookButtonBase.externalOnClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, FacebookButtonBase.class);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void callExternalOnClickListener(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                View.OnClickListener onClickListener = this.externalOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void configureButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(context, IdentityHttpResponse.CONTEXT);
                parseBackgroundAttributes(context, attributeSet, i10, i11);
                parseCompoundDrawableAttributes(context, attributeSet, i10, i11);
                parseContentAttributes(context, attributeSet, i10, i11);
                parseTextAttributes(context, attributeSet, i10, i11);
                setupOnClickListener();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Activity getActivity() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Context context = getContext();
            while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            throw new FacebookException("Unable to get Activity.");
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String getAnalyticsButtonCreatedEventName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.analyticsButtonCreatedEventName;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String getAnalyticsButtonTappedEventName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.analyticsButtonTappedEventName;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final d getAndroidxActivityResultRegistryOwner() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Activity activity = getActivity();
            if (activity instanceof d) {
                return (d) activity;
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public int getCompoundPaddingLeft() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            if (this.overrideCompoundPadding) {
                return this.overrideCompoundPaddingLeft;
            }
            return super.getCompoundPaddingLeft();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    public int getCompoundPaddingRight() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            if (this.overrideCompoundPadding) {
                return this.overrideCompoundPaddingRight;
            }
            return super.getCompoundPaddingRight();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getDefaultRequestCode();

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.defaultStyleResource;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    public final Fragment getFragment() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            FragmentWrapper fragmentWrapper = this.parentFragment;
            if (fragmentWrapper == null) {
                return null;
            }
            return fragmentWrapper.getSupportFragment();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final android.app.Fragment getNativeFragment() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            FragmentWrapper fragmentWrapper = this.parentFragment;
            if (fragmentWrapper == null) {
                return null;
            }
            return fragmentWrapper.getNativeFragment();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public int getRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getDefaultRequestCode();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void logButtonCreated(Context context) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InternalAppEventsLogger.Companion.createInstance(context, (String) null).logEventImplicitly(this.analyticsButtonCreatedEventName);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void logButtonTapped(Context context) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InternalAppEventsLogger.Companion.createInstance(context, (String) null).logEventImplicitly(this.analyticsButtonTappedEventName);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int measureTextWidth(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return (int) Math.ceil((double) getPaint().measureText(str));
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onAttachedToWindow();
                if (!isInEditMode()) {
                    logButtonCreated(getContext());
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z10;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(canvas, "canvas");
                if ((getGravity() & 1) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    int compoundPaddingLeft = getCompoundPaddingLeft();
                    int compoundPaddingRight = getCompoundPaddingRight();
                    int min = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - measureTextWidth(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
                    this.overrideCompoundPaddingLeft = compoundPaddingLeft - min;
                    this.overrideCompoundPaddingRight = compoundPaddingRight + min;
                    this.overrideCompoundPadding = true;
                }
                super.onDraw(canvas);
                this.overrideCompoundPadding = false;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void setFragment(android.app.Fragment fragment) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(fragment, "fragment");
                this.parentFragment = new FragmentWrapper(fragment);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setInternalOnClickListener(View.OnClickListener onClickListener) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.internalOnClickListener = onClickListener;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.externalOnClickListener = onClickListener;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void setFragment(Fragment fragment) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(fragment, "fragment");
                this.parentFragment = new FragmentWrapper(fragment);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
