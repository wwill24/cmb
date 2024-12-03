package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/internal/FeatureManager;", "", "()V", "FEATURE_MANAGER_STORE", "", "featureMapping", "", "Lcom/facebook/internal/FeatureManager$Feature;", "", "checkFeature", "", "feature", "callback", "Lcom/facebook/internal/FeatureManager$Callback;", "defaultStatus", "", "disableFeature", "getFeature", "className", "getGKStatus", "initializeFeatureMapping", "isEnabled", "Callback", "Feature", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FeatureManager {
    private static final String FEATURE_MANAGER_STORE = "com.facebook.internal.FEATURE_MANAGER";
    public static final FeatureManager INSTANCE = new FeatureManager();
    private static final Map<Feature, String[]> featureMapping = new HashMap();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FeatureManager$Callback;", "", "onCompleted", "", "enabled", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void onCompleted(boolean z10);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\"\b\u0001\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001*B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006+"}, d2 = {"Lcom/facebook/internal/FeatureManager$Feature;", "", "code", "", "(Ljava/lang/String;II)V", "parent", "getParent", "()Lcom/facebook/internal/FeatureManager$Feature;", "toKey", "", "toString", "Unknown", "Core", "AppEvents", "CodelessEvents", "CloudBridge", "RestrictiveDataFiltering", "AAM", "PrivacyProtection", "SuggestedEvents", "IntelligentIntegrity", "ModelRequest", "EventDeactivation", "OnDeviceEventProcessing", "OnDevicePostInstallEventProcessing", "IapLogging", "IapLoggingLib2", "Instrument", "CrashReport", "CrashShield", "ThreadCheck", "ErrorReport", "AnrReport", "Monitoring", "ServiceUpdateCompliance", "Megatron", "Elora", "Login", "ChromeCustomTabsPrefetching", "IgnoreAppSwitchToLoggedOut", "BypassAppSwitch", "Share", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        CloudBridge(67584),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        Instrument(Opcodes.ACC_DEPRECATED),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        AnrReport(131840),
        Monitoring(196608),
        ServiceUpdateCompliance(196864),
        Megatron(Opcodes.ASM4),
        Elora(Opcodes.ASM5),
        Login(16777216),
        ChromeCustomTabsPrefetching(16842752),
        IgnoreAppSwitchToLoggedOut(16908288),
        BypassAppSwitch(16973824),
        Share(33554432);
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final int code;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FeatureManager$Feature$Companion;", "", "()V", "fromInt", "Lcom/facebook/internal/FeatureManager$Feature;", "code", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Feature fromInt(int i10) {
                Feature[] values = Feature.values();
                int length = values.length;
                int i11 = 0;
                while (i11 < length) {
                    Feature feature = values[i11];
                    i11++;
                    if (feature.code == i10) {
                        return feature;
                    }
                }
                return Feature.Unknown;
            }
        }

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Feature.values().length];
                iArr[Feature.Core.ordinal()] = 1;
                iArr[Feature.AppEvents.ordinal()] = 2;
                iArr[Feature.CodelessEvents.ordinal()] = 3;
                iArr[Feature.RestrictiveDataFiltering.ordinal()] = 4;
                iArr[Feature.Instrument.ordinal()] = 5;
                iArr[Feature.CrashReport.ordinal()] = 6;
                iArr[Feature.CrashShield.ordinal()] = 7;
                iArr[Feature.ThreadCheck.ordinal()] = 8;
                iArr[Feature.ErrorReport.ordinal()] = 9;
                iArr[Feature.AnrReport.ordinal()] = 10;
                iArr[Feature.AAM.ordinal()] = 11;
                iArr[Feature.CloudBridge.ordinal()] = 12;
                iArr[Feature.PrivacyProtection.ordinal()] = 13;
                iArr[Feature.SuggestedEvents.ordinal()] = 14;
                iArr[Feature.IntelligentIntegrity.ordinal()] = 15;
                iArr[Feature.ModelRequest.ordinal()] = 16;
                iArr[Feature.EventDeactivation.ordinal()] = 17;
                iArr[Feature.OnDeviceEventProcessing.ordinal()] = 18;
                iArr[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 19;
                iArr[Feature.IapLogging.ordinal()] = 20;
                iArr[Feature.IapLoggingLib2.ordinal()] = 21;
                iArr[Feature.Monitoring.ordinal()] = 22;
                iArr[Feature.Megatron.ordinal()] = 23;
                iArr[Feature.Elora.ordinal()] = 24;
                iArr[Feature.ServiceUpdateCompliance.ordinal()] = 25;
                iArr[Feature.Login.ordinal()] = 26;
                iArr[Feature.ChromeCustomTabsPrefetching.ordinal()] = 27;
                iArr[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 28;
                iArr[Feature.BypassAppSwitch.ordinal()] = 29;
                iArr[Feature.Share.ordinal()] = 30;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        private Feature(int i10) {
            this.code = i10;
        }

        public final Feature getParent() {
            int i10 = this.code;
            if ((i10 & 255) > 0) {
                return Companion.fromInt(i10 & -256);
            }
            if ((65280 & i10) > 0) {
                return Companion.fromInt(i10 & Opcodes.V_PREVIEW);
            }
            if ((16711680 & i10) > 0) {
                return Companion.fromInt(i10 & -16777216);
            }
            return Companion.fromInt(0);
        }

        public final String toKey() {
            return j.p("FBSDKFeature", this);
        }

        public String toString() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return "CoreKit";
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "RestrictiveDataFiltering";
                case 5:
                    return "Instrument";
                case 6:
                    return "CrashReport";
                case 7:
                    return "CrashShield";
                case 8:
                    return "ThreadCheck";
                case 9:
                    return "ErrorReport";
                case 10:
                    return "AnrReport";
                case 11:
                    return "AAM";
                case 12:
                    return "AppEventsCloudbridge";
                case 13:
                    return "PrivacyProtection";
                case 14:
                    return "SuggestedEvents";
                case 15:
                    return "IntelligentIntegrity";
                case 16:
                    return "ModelRequest";
                case 17:
                    return "EventDeactivation";
                case 18:
                    return "OnDeviceEventProcessing";
                case 19:
                    return "OnDevicePostInstallEventProcessing";
                case 20:
                    return "IAPLogging";
                case 21:
                    return "IAPLoggingLib2";
                case 22:
                    return "Monitoring";
                case 23:
                    return "Megatron";
                case 24:
                    return "Elora";
                case 25:
                    return "ServiceUpdateCompliance";
                case 26:
                    return "LoginKit";
                case 27:
                    return "ChromeCustomTabsPrefetching";
                case 28:
                    return "IgnoreAppSwitchToLoggedOut";
                case 29:
                    return "BypassAppSwitch";
                case 30:
                    return "ShareKit";
                default:
                    return "unknown";
            }
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Feature.values().length];
            iArr[Feature.RestrictiveDataFiltering.ordinal()] = 1;
            iArr[Feature.Instrument.ordinal()] = 2;
            iArr[Feature.CrashReport.ordinal()] = 3;
            iArr[Feature.CrashShield.ordinal()] = 4;
            iArr[Feature.ThreadCheck.ordinal()] = 5;
            iArr[Feature.ErrorReport.ordinal()] = 6;
            iArr[Feature.AnrReport.ordinal()] = 7;
            iArr[Feature.AAM.ordinal()] = 8;
            iArr[Feature.CloudBridge.ordinal()] = 9;
            iArr[Feature.PrivacyProtection.ordinal()] = 10;
            iArr[Feature.SuggestedEvents.ordinal()] = 11;
            iArr[Feature.IntelligentIntegrity.ordinal()] = 12;
            iArr[Feature.ModelRequest.ordinal()] = 13;
            iArr[Feature.EventDeactivation.ordinal()] = 14;
            iArr[Feature.OnDeviceEventProcessing.ordinal()] = 15;
            iArr[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 16;
            iArr[Feature.IapLogging.ordinal()] = 17;
            iArr[Feature.IapLoggingLib2.ordinal()] = 18;
            iArr[Feature.ChromeCustomTabsPrefetching.ordinal()] = 19;
            iArr[Feature.Monitoring.ordinal()] = 20;
            iArr[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 21;
            iArr[Feature.BypassAppSwitch.ordinal()] = 22;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FeatureManager() {
    }

    public static final void checkFeature(Feature feature, Callback callback) {
        j.g(feature, "feature");
        j.g(callback, "callback");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FeatureManager$checkFeature$1(callback, feature));
    }

    private final boolean defaultStatus(Feature feature) {
        switch (WhenMappings.$EnumSwitchMapping$0[feature.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return false;
            default:
                return true;
        }
    }

    public static final void disableFeature(Feature feature) {
        j.g(feature, "feature");
        FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).edit().putString(feature.toKey(), FacebookSdk.getSdkVersion()).apply();
    }

    public static final Feature getFeature(String str) {
        j.g(str, "className");
        INSTANCE.initializeFeatureMapping();
        for (Map.Entry next : featureMapping.entrySet()) {
            Feature feature = (Feature) next.getKey();
            String[] strArr = (String[]) next.getValue();
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    String str2 = strArr[i10];
                    i10++;
                    if (r.J(str, str2, false, 2, (Object) null)) {
                        return feature;
                    }
                }
            }
        }
        return Feature.Unknown;
    }

    private final boolean getGKStatus(Feature feature) {
        boolean defaultStatus = defaultStatus(feature);
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        return FetchedAppGateKeepersManager.getGateKeeperForKey(feature.toKey(), FacebookSdk.getApplicationId(), defaultStatus);
    }

    private final synchronized void initializeFeatureMapping() {
        Map<Feature, String[]> map = featureMapping;
        if (map.isEmpty()) {
            map.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
            map.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
            map.put(Feature.CloudBridge, new String[]{"com.facebook.appevents.cloudbridge."});
            map.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
            map.put(Feature.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
            map.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
            map.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
            map.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
            map.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
            map.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
            map.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
            map.put(Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
            map.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
        }
    }

    public static final boolean isEnabled(Feature feature) {
        j.g(feature, "feature");
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        String string = FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).getString(feature.toKey(), (String) null);
        if (string != null && j.b(string, FacebookSdk.getSdkVersion())) {
            return false;
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return INSTANCE.getGKStatus(feature);
        }
        if (!isEnabled(parent) || !INSTANCE.getGKStatus(feature)) {
            return false;
        }
        return true;
    }
}
