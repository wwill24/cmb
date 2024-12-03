package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;

public abstract class ShareButtonBase extends FacebookButtonBase {
    private CallbackManager callbackManager;
    private boolean enabledExplicitlySet = false;
    private int requestCode = 0;
    private ShareContent shareContent;

    protected ShareButtonBase(Context context, AttributeSet attributeSet, int i10, String str, String str2) {
        super(context, attributeSet, i10, 0, str, str2);
        int i11;
        if (isInEditMode()) {
            i11 = 0;
        } else {
            i11 = getDefaultRequestCode();
        }
        this.requestCode = i11;
        internalSetEnabled(false);
    }

    private void internalSetEnabled(boolean z10) {
        setEnabled(z10);
        this.enabledExplicitlySet = false;
    }

    private void memorizeCallbackManager(CallbackManager callbackManager2) {
        CallbackManager callbackManager3 = this.callbackManager;
        if (callbackManager3 == null) {
            this.callbackManager = callbackManager2;
        } else if (callbackManager3 != callbackManager2) {
            ShareButtonBase.class.toString();
        }
    }

    /* access modifiers changed from: protected */
    public boolean canShare() {
        return getDialog().canShow(getShareContent());
    }

    /* access modifiers changed from: protected */
    public void configureButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        super.configureButton(context, attributeSet, i10, i11);
        setInternalOnClickListener(getShareOnClickListener());
    }

    /* access modifiers changed from: protected */
    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    /* access modifiers changed from: protected */
    public abstract ShareDialog getDialog();

    public int getRequestCode() {
        return this.requestCode;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        ShareButtonBase.this.callExternalOnClickListener(view);
                        ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(th2, this);
                    }
                }
            }
        };
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<Sharer.Result> facebookCallback) {
        memorizeCallbackManager(callbackManager2);
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager2, facebookCallback);
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.enabledExplicitlySet = true;
    }

    /* access modifiers changed from: protected */
    public void setRequestCode(int i10) {
        if (!FacebookSdk.isFacebookRequestCode(i10)) {
            this.requestCode = i10;
            return;
        }
        throw new IllegalArgumentException("Request code " + i10 + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
        if (!this.enabledExplicitlySet) {
            internalSetEnabled(canShare());
        }
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<Sharer.Result> facebookCallback, int i10) {
        setRequestCode(i10);
        registerCallback(callbackManager2, facebookCallback);
    }
}
