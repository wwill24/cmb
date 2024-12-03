package com.facebook.appevents;

import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventsManager$start$1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
    AppEventsManager$start$1() {
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m45onSuccess$lambda0(boolean z10) {
        if (z10) {
            MetadataIndexer.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-1  reason: not valid java name */
    public static final void m46onSuccess$lambda1(boolean z10) {
        if (z10) {
            RestrictiveDataManager.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-2  reason: not valid java name */
    public static final void m47onSuccess$lambda2(boolean z10) {
        if (z10) {
            ModelManager.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-3  reason: not valid java name */
    public static final void m48onSuccess$lambda3(boolean z10) {
        if (z10) {
            EventDeactivationManager.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-4  reason: not valid java name */
    public static final void m49onSuccess$lambda4(boolean z10) {
        if (z10) {
            InAppPurchaseManager.enableAutoLogging();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-5  reason: not valid java name */
    public static final void m50onSuccess$lambda5(boolean z10) {
        if (z10) {
            AppEventsCAPIManager.enable();
        }
    }

    public void onError() {
    }

    public void onSuccess(FetchedAppSettings fetchedAppSettings) {
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.AAM, new k());
        FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new l());
        FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new m());
        FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new n());
        FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new o());
        FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, new p());
    }
}
