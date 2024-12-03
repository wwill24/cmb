package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;
import kotlin.Metadata;
import wc.b;
import wc.c;
import wc.d;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentManager;", "", "()V", "start", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InstrumentManager {
    public static final InstrumentManager INSTANCE = new InstrumentManager();

    private InstrumentManager() {
    }

    public static final void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new b());
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new c());
            FeatureManager.checkFeature(FeatureManager.Feature.AnrReport, new d());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: start$lambda-0  reason: not valid java name */
    public static final void m136start$lambda0(boolean z10) {
        if (z10) {
            CrashHandler.Companion.enable();
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                ExceptionAnalyzer.enable();
                CrashShieldHandler.enable();
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck)) {
                ThreadCheckHandler.enable();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: start$lambda-1  reason: not valid java name */
    public static final void m137start$lambda1(boolean z10) {
        if (z10) {
            ErrorReportHandler.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: start$lambda-2  reason: not valid java name */
    public static final void m138start$lambda2(boolean z10) {
        if (z10) {
            ANRHandler.enable();
        }
    }
}
