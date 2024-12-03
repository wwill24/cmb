package com.leanplum.migration.model;

import com.leanplum.internal.CollectionUtil;
import com.leanplum.internal.Constants;
import com.leanplum.internal.JsonConverter;
import com.leanplum.utils.StringPreference;
import com.leanplum.utils.StringPreferenceNullable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.j;
import wk.l;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR/\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR/\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR5\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0002¢\u0006\u0018\n\u0004\b\u0018\u0010\u000b\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR<\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00198F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR/\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR+\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR+\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b)\u0010%\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR\u001e\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020*@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/leanplum/migration/model/MigrationConfig;", "", "()V", "<set-?>", "", "accountId", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "accountId$delegate", "Lcom/leanplum/utils/StringPreferenceNullable;", "accountRegion", "getAccountRegion", "setAccountRegion", "accountRegion$delegate", "accountToken", "getAccountToken", "setAccountToken", "accountToken$delegate", "appId", "getAppId$annotations", "getAppId", "setAppId", "appId$delegate", "", "attributeMap", "getAttributeMap", "()Ljava/util/Map;", "attributeMappings", "getAttributeMappings", "setAttributeMappings", "attributeMappings$delegate", "hash", "getHash", "setHash", "hash$delegate", "Lcom/leanplum/utils/StringPreference;", "state", "getState", "setState", "state$delegate", "", "trackGooglePlayPurchases", "getTrackGooglePlayPurchases", "()Z", "update", "", "data", "Lcom/leanplum/migration/model/ResponseData;", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class MigrationConfig {
    static final /* synthetic */ l[] $$delegatedProperties;
    public static final MigrationConfig INSTANCE = new MigrationConfig();
    private static final StringPreferenceNullable accountId$delegate = new StringPreferenceNullable("ct_account_id", (String) null, 2, (DefaultConstructorMarker) null);
    private static final StringPreferenceNullable accountRegion$delegate = new StringPreferenceNullable("ct_region_code", (String) null, 2, (DefaultConstructorMarker) null);
    private static final StringPreferenceNullable accountToken$delegate = new StringPreferenceNullable("ct_account_token", (String) null, 2, (DefaultConstructorMarker) null);
    private static final StringPreferenceNullable appId$delegate = new StringPreferenceNullable("app_id", (String) null, 2, (DefaultConstructorMarker) null);
    private static Map<String, String> attributeMap;
    private static final StringPreferenceNullable attributeMappings$delegate = new StringPreferenceNullable("ct_attribute_mappings", (String) null, 2, (DefaultConstructorMarker) null);
    private static final StringPreference hash$delegate = new StringPreference("ct_config_hash", "defaultHash");
    private static final StringPreference state$delegate = new StringPreference("migration_state", "undefined");
    private static boolean trackGooglePlayPurchases = true;

    static {
        Class<MigrationConfig> cls = MigrationConfig.class;
        $$delegatedProperties = new l[]{kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, "state", "getState()Ljava/lang/String;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, "hash", "getHash()Ljava/lang/String;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, Constants.Params.CT_ACCOUNT_ID, "getAccountId()Ljava/lang/String;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, "accountToken", "getAccountToken()Ljava/lang/String;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, "accountRegion", "getAccountRegion()Ljava/lang/String;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, Constants.Params.CT_ATTRIBUTE_MAPPINGS, "getAttributeMappings()Ljava/lang/String;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, "appId", "getAppId()Ljava/lang/String;", 0))};
    }

    private MigrationConfig() {
    }

    public static final String getAppId() {
        return appId$delegate.getValue((Object) INSTANCE, $$delegatedProperties[6]);
    }

    public static /* synthetic */ void getAppId$annotations() {
    }

    private final String getAttributeMappings() {
        return attributeMappings$delegate.getValue((Object) this, $$delegatedProperties[5]);
    }

    private final void setAccountId(String str) {
        accountId$delegate.setValue((Object) this, (l<?>) $$delegatedProperties[2], str);
    }

    private final void setAccountRegion(String str) {
        accountRegion$delegate.setValue((Object) this, (l<?>) $$delegatedProperties[4], str);
    }

    private final void setAccountToken(String str) {
        accountToken$delegate.setValue((Object) this, (l<?>) $$delegatedProperties[3], str);
    }

    public static final void setAppId(String str) {
        appId$delegate.setValue((Object) INSTANCE, (l<?>) $$delegatedProperties[6], str);
    }

    private final void setAttributeMappings(String str) {
        attributeMappings$delegate.setValue((Object) this, (l<?>) $$delegatedProperties[5], str);
    }

    private final void setHash(String str) {
        hash$delegate.setValue((Object) this, (l<?>) $$delegatedProperties[1], str);
    }

    private final void setState(String str) {
        state$delegate.setValue((Object) this, (l<?>) $$delegatedProperties[0], str);
    }

    public final String getAccountId() {
        return accountId$delegate.getValue((Object) this, $$delegatedProperties[2]);
    }

    public final String getAccountRegion() {
        return accountRegion$delegate.getValue((Object) this, $$delegatedProperties[4]);
    }

    public final String getAccountToken() {
        return accountToken$delegate.getValue((Object) this, $$delegatedProperties[3]);
    }

    public final Map<String, String> getAttributeMap() {
        if (attributeMap == null) {
            Map<String, String> map = (Map) CollectionUtil.uncheckedCast(JsonConverter.fromJson(getAttributeMappings()));
            if (map == null) {
                map = h0.i();
            }
            attributeMap = map;
        }
        return attributeMap;
    }

    public final String getHash() {
        return hash$delegate.getValue((Object) this, $$delegatedProperties[1]);
    }

    public final String getState() {
        return state$delegate.getValue((Object) this, $$delegatedProperties[0]);
    }

    public final boolean getTrackGooglePlayPurchases() {
        return trackGooglePlayPurchases;
    }

    public final void update(ResponseData responseData) {
        j.g(responseData, "data");
        setState(responseData.getState());
        setHash(responseData.getHash());
        setAccountId(responseData.getAccountId());
        setAccountToken(responseData.getToken());
        setAccountRegion(responseData.getRegionCode());
        String attributeMappings = responseData.getAttributeMappings();
        attributeMap = null;
        Unit unit = Unit.f32013a;
        setAttributeMappings(attributeMappings);
    }
}
