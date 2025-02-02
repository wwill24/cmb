package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.Sharer;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import java.util.ArrayList;
import java.util.List;

public final class MessageDialog extends ShareDialog {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
    private boolean shouldFailOnDataError;

    private class NativeHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private NativeHandler() {
            super(MessageDialog.this);
        }

        public boolean canShow(ShareContent shareContent, boolean z10) {
            return shareContent != null && MessageDialog.canShow(shareContent.getClass());
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            ShareContentValidation.validateForMessage(shareContent);
            final AppCall createBaseAppCall = MessageDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = MessageDialog.this.getShouldFailOnDataError();
            MessageDialog.logDialogShare(MessageDialog.this.getActivityContext(), shareContent, createBaseAppCall);
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() {
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), (ShareContent<?, ?>) shareContent, shouldFailOnDataError);
                }

                public Bundle getParameters() {
                    return NativeDialogParameters.create(createBaseAppCall.getCallId(), (ShareContent<?, ?>) shareContent, shouldFailOnDataError);
                }
            }, MessageDialog.getFeature(shareContent.getClass()));
            return createBaseAppCall;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageDialog(android.app.Activity r2) {
        /*
            r1 = this;
            int r0 = DEFAULT_REQUEST_CODE
            r1.<init>((android.app.Activity) r2, (int) r0)
            r2 = 0
            r1.shouldFailOnDataError = r2
            com.facebook.share.internal.ShareInternalUtility.registerStaticShareCallback(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.MessageDialog.<init>(android.app.Activity):void");
    }

    public static boolean canShow(Class<? extends ShareContent<?, ?>> cls) {
        DialogFeature feature = getFeature(cls);
        if (feature == null || !DialogPresenter.canPresentNativeDialogWithFeature(feature)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static DialogFeature getFeature(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSAGE_DIALOG;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void logDialogShare(Context context, ShareContent shareContent, AppCall appCall) {
        String str;
        DialogFeature feature = getFeature(shareContent.getClass());
        if (feature == MessageDialogFeature.MESSAGE_DIALOG) {
            str = "status";
        } else if (feature == MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE) {
            str = AnalyticsEvents.PARAMETER_SHARE_MESSENGER_GENERIC_TEMPLATE;
        } else if (feature == MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE) {
            str = AnalyticsEvents.PARAMETER_SHARE_MESSENGER_MEDIA_TEMPLATE;
        } else {
            str = "unknown";
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_UUID, appCall.getCallId().toString());
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PAGE_ID, shareContent.getPageId());
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_MESSENGER_DIALOG_SHOW, bundle);
    }

    public static void show(Activity activity, ShareContent shareContent) {
        new MessageDialog(activity).show(shareContent);
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        return arrayList;
    }

    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Sharer.Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
    }

    public void setShouldFailOnDataError(boolean z10) {
        this.shouldFailOnDataError = z10;
    }

    public static void show(Fragment fragment, ShareContent shareContent) {
        show(new FragmentWrapper(fragment), shareContent);
    }

    public static void show(android.app.Fragment fragment, ShareContent shareContent) {
        show(new FragmentWrapper(fragment), shareContent);
    }

    public MessageDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private static void show(FragmentWrapper fragmentWrapper, ShareContent shareContent) {
        new MessageDialog(fragmentWrapper).show(shareContent);
    }

    public MessageDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MessageDialog(com.facebook.internal.FragmentWrapper r2) {
        /*
            r1 = this;
            int r0 = DEFAULT_REQUEST_CODE
            r1.<init>((com.facebook.internal.FragmentWrapper) r2, (int) r0)
            r2 = 0
            r1.shouldFailOnDataError = r2
            com.facebook.share.internal.ShareInternalUtility.registerStaticShareCallback(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.MessageDialog.<init>(com.facebook.internal.FragmentWrapper):void");
    }

    MessageDialog(Activity activity, int i10) {
        super(activity, i10);
        this.shouldFailOnDataError = false;
        ShareInternalUtility.registerStaticShareCallback(i10);
    }

    MessageDialog(Fragment fragment, int i10) {
        this(new FragmentWrapper(fragment), i10);
    }

    MessageDialog(android.app.Fragment fragment, int i10) {
        this(new FragmentWrapper(fragment), i10);
    }

    private MessageDialog(FragmentWrapper fragmentWrapper, int i10) {
        super(fragmentWrapper, i10);
        this.shouldFailOnDataError = false;
        ShareInternalUtility.registerStaticShareCallback(i10);
    }
}
