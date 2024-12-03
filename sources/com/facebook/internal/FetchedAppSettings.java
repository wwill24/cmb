package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 @2\u00020\u0001:\u0002@ABÅ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u001e\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00180\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u00102\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0002\u0012\u0006\u00106\u001a\u00020\u0002\u0012\b\u00108\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b>\u0010?J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R/\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00180\u00188\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\fR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010\tR\u0017\u0010'\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b'\u0010\u0007\u001a\u0004\b(\u0010\tR\u0017\u0010)\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\fR\u0017\u0010+\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\fR\u0019\u0010.\u001a\u0004\u0018\u00010-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00102\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b2\u0010\u0007\u001a\u0004\b3\u0010\tR\u0017\u00104\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\fR\u0017\u00106\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\fR\u0019\u00108\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b8\u0010\u0007\u001a\u0004\b9\u0010\tR\u0019\u0010:\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b:\u0010\u0007\u001a\u0004\b;\u0010\tR\u0019\u0010<\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b<\u0010\u0007\u001a\u0004\b=\u0010\t¨\u0006B"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings;", "", "", "supportsImplicitLogging", "Z", "", "nuxContent", "Ljava/lang/String;", "getNuxContent", "()Ljava/lang/String;", "nuxEnabled", "getNuxEnabled", "()Z", "", "sessionTimeoutInSeconds", "I", "getSessionTimeoutInSeconds", "()I", "Ljava/util/EnumSet;", "Lcom/facebook/internal/SmartLoginOption;", "smartLoginOptions", "Ljava/util/EnumSet;", "getSmartLoginOptions", "()Ljava/util/EnumSet;", "", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "dialogConfigurations", "Ljava/util/Map;", "getDialogConfigurations", "()Ljava/util/Map;", "automaticLoggingEnabled", "getAutomaticLoggingEnabled", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "errorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "smartLoginBookmarkIconURL", "getSmartLoginBookmarkIconURL", "smartLoginMenuIconURL", "getSmartLoginMenuIconURL", "iAPAutomaticLoggingEnabled", "getIAPAutomaticLoggingEnabled", "codelessEventsEnabled", "getCodelessEventsEnabled", "Lorg/json/a;", "eventBindings", "Lorg/json/a;", "getEventBindings", "()Lorg/json/a;", "sdkUpdateMessage", "getSdkUpdateMessage", "trackUninstallEnabled", "getTrackUninstallEnabled", "monitorViaDialogEnabled", "getMonitorViaDialogEnabled", "rawAamRules", "getRawAamRules", "suggestedEventsSetting", "getSuggestedEventsSetting", "restrictiveDataSetting", "getRestrictiveDataSetting", "<init>", "(ZLjava/lang/String;ZILjava/util/EnumSet;Ljava/util/Map;ZLcom/facebook/internal/FacebookRequestErrorClassification;Ljava/lang/String;Ljava/lang/String;ZZLorg/json/a;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "DialogFeatureConfig", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class FetchedAppSettings {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean automaticLoggingEnabled;
    private final boolean codelessEventsEnabled;
    private final Map<String, Map<String, DialogFeatureConfig>> dialogConfigurations;
    private final FacebookRequestErrorClassification errorClassification;
    private final a eventBindings;
    private final boolean iAPAutomaticLoggingEnabled;
    private final boolean monitorViaDialogEnabled;
    private final String nuxContent;
    private final boolean nuxEnabled;
    private final String rawAamRules;
    private final String restrictiveDataSetting;
    private final String sdkUpdateMessage;
    private final int sessionTimeoutInSeconds;
    private final String smartLoginBookmarkIconURL;
    private final String smartLoginMenuIconURL;
    private final EnumSet<SmartLoginOption> smartLoginOptions;
    private final String suggestedEventsSetting;
    private final boolean supportsImplicitLogging;
    private final boolean trackUninstallEnabled;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings$Companion;", "", "()V", "getDialogFeatureConfig", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "applicationId", "", "actionName", "featureName", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
            boolean z10;
            Map map;
            j.g(str, "applicationId");
            j.g(str2, "actionName");
            j.g(str3, "featureName");
            boolean z11 = true;
            if (str2.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (str3.length() != 0) {
                    z11 = false;
                }
                if (!z11) {
                    FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(str);
                    if (appSettingsWithoutQuery == null) {
                        map = null;
                    } else {
                        map = appSettingsWithoutQuery.getDialogConfigurations().get(str2);
                    }
                    if (map != null) {
                        return (DialogFeatureConfig) map.get(str3);
                    }
                }
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "", "dialogName", "", "featureName", "fallbackUrl", "Landroid/net/Uri;", "versionSpec", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;[I)V", "getDialogName", "()Ljava/lang/String;", "getFallbackUrl", "()Landroid/net/Uri;", "getFeatureName", "getVersionSpec", "()[I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DialogFeatureConfig {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "|";
        private static final String DIALOG_CONFIG_NAME_KEY = "name";
        private static final String DIALOG_CONFIG_URL_KEY = "url";
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        private final String dialogName;
        private final Uri fallbackUrl;
        private final String featureName;
        private final int[] versionSpec;

        @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig$Companion;", "", "Lorg/json/a;", "versionsJSON", "", "parseVersionSpec", "Lorg/json/b;", "dialogConfigJSON", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "parseDialogConfig", "", "DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR", "Ljava/lang/String;", "DIALOG_CONFIG_NAME_KEY", "DIALOG_CONFIG_URL_KEY", "DIALOG_CONFIG_VERSIONS_KEY", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final int[] parseVersionSpec(a aVar) {
                if (aVar == null) {
                    return null;
                }
                int o10 = aVar.o();
                int[] iArr = new int[o10];
                int i10 = 0;
                if (o10 <= 0) {
                    return iArr;
                }
                while (true) {
                    int i11 = i10 + 1;
                    int i12 = -1;
                    int r10 = aVar.r(i10, -1);
                    if (r10 == -1) {
                        String w10 = aVar.w(i10);
                        if (!Utility.isNullOrEmpty(w10)) {
                            try {
                                j.f(w10, "versionString");
                                i12 = Integer.parseInt(w10);
                            } catch (NumberFormatException e10) {
                                Utility.logd(Utility.LOG_TAG, (Exception) e10);
                            }
                            r10 = i12;
                        }
                    }
                    iArr[i10] = r10;
                    if (i11 >= o10) {
                        return iArr;
                    }
                    i10 = i11;
                }
            }

            public final DialogFeatureConfig parseDialogConfig(b bVar) {
                j.g(bVar, "dialogConfigJSON");
                String optString = bVar.optString("name");
                Uri uri = null;
                if (Utility.isNullOrEmpty(optString)) {
                    return null;
                }
                j.f(optString, "dialogNameWithFeature");
                List C0 = StringsKt__StringsKt.C0(optString, new String[]{DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR}, false, 0, 6, (Object) null);
                if (C0.size() != 2) {
                    return null;
                }
                String str = (String) CollectionsKt___CollectionsKt.N(C0);
                String str2 = (String) CollectionsKt___CollectionsKt.Y(C0);
                if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                    return null;
                }
                String optString2 = bVar.optString("url");
                if (!Utility.isNullOrEmpty(optString2)) {
                    uri = Uri.parse(optString2);
                }
                return new DialogFeatureConfig(str, str2, uri, parseVersionSpec(bVar.optJSONArray(DialogFeatureConfig.DIALOG_CONFIG_VERSIONS_KEY)), (DefaultConstructorMarker) null);
            }
        }

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.versionSpec = iArr;
        }

        public /* synthetic */ DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, uri, iArr);
        }

        public final String getDialogName() {
            return this.dialogName;
        }

        public final Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public final String getFeatureName() {
            return this.featureName;
        }

        public final int[] getVersionSpec() {
            return this.versionSpec;
        }
    }

    public FetchedAppSettings(boolean z10, String str, boolean z11, int i10, EnumSet<SmartLoginOption> enumSet, Map<String, ? extends Map<String, DialogFeatureConfig>> map, boolean z12, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z13, boolean z14, a aVar, String str4, boolean z15, boolean z16, String str5, String str6, String str7) {
        FacebookRequestErrorClassification facebookRequestErrorClassification2 = facebookRequestErrorClassification;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        j.g(str, "nuxContent");
        j.g(enumSet, "smartLoginOptions");
        j.g(map, "dialogConfigurations");
        j.g(facebookRequestErrorClassification2, "errorClassification");
        j.g(str8, "smartLoginBookmarkIconURL");
        j.g(str9, "smartLoginMenuIconURL");
        j.g(str10, "sdkUpdateMessage");
        this.supportsImplicitLogging = z10;
        this.nuxContent = str;
        this.nuxEnabled = z11;
        this.sessionTimeoutInSeconds = i10;
        this.smartLoginOptions = enumSet;
        this.dialogConfigurations = map;
        this.automaticLoggingEnabled = z12;
        this.errorClassification = facebookRequestErrorClassification2;
        this.smartLoginBookmarkIconURL = str8;
        this.smartLoginMenuIconURL = str9;
        this.iAPAutomaticLoggingEnabled = z13;
        this.codelessEventsEnabled = z14;
        this.eventBindings = aVar;
        this.sdkUpdateMessage = str10;
        this.trackUninstallEnabled = z15;
        this.monitorViaDialogEnabled = z16;
        this.rawAamRules = str5;
        this.suggestedEventsSetting = str6;
        this.restrictiveDataSetting = str7;
    }

    public static final DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        return Companion.getDialogFeatureConfig(str, str2, str3);
    }

    public final boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public final boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    public final Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.dialogConfigurations;
    }

    public final FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    public final a getEventBindings() {
        return this.eventBindings;
    }

    public final boolean getIAPAutomaticLoggingEnabled() {
        return this.iAPAutomaticLoggingEnabled;
    }

    public final boolean getMonitorViaDialogEnabled() {
        return this.monitorViaDialogEnabled;
    }

    public final String getNuxContent() {
        return this.nuxContent;
    }

    public final boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    public final String getRawAamRules() {
        return this.rawAamRules;
    }

    public final String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    public final String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public final int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    public final String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    public final String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    public final EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    public final String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    public final boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public final boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }
}
