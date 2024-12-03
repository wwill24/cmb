package com.leanplum.migration;

import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;
import com.leanplum.migration.model.MigrationState;
import com.leanplum.migration.model.ResponseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/leanplum/migration/ResponseHandler;", "", "Lorg/json/b;", "json", "Lcom/leanplum/migration/model/ResponseData;", "handleMigrateStateContent", "", "handleMigrateState", "<init>", "()V", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class ResponseHandler {
    public final String handleMigrateState(b bVar) {
        j.g(bVar, JsonPacketExtension.ELEMENT);
        try {
            if (!bVar.isNull(Constants.Params.MIGRATE_STATE)) {
                return bVar.getJSONObject(Constants.Params.MIGRATE_STATE).getString(Constants.Params.MIGRATE_STATE_HASH);
            }
            return null;
        } catch (JSONException e10) {
            Log.e("Error parsing response for CT config.", (Throwable) e10);
            return null;
        }
    }

    public final ResponseData handleMigrateStateContent(b bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        j.g(bVar, JsonPacketExtension.ELEMENT);
        try {
            if (!bVar.isNull("sdk")) {
                String string = bVar.getString("sdk");
                String string2 = bVar.getString(Constants.Params.MIGRATE_STATE_HASH);
                MigrationState.Companion companion = MigrationState.Companion;
                j.f(string, "state");
                if (companion.from(string).useCleverTap()) {
                    b optJSONObject = bVar.optJSONObject("ct");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString(Constants.Params.CT_ACCOUNT_ID);
                        String optString2 = optJSONObject.optString("token");
                        String optString3 = optJSONObject.optString(Constants.Params.CT_REGION_CODE);
                        b optJSONObject2 = optJSONObject.optJSONObject(Constants.Params.CT_ATTRIBUTE_MAPPINGS);
                        if (optJSONObject2 != null) {
                            str5 = optJSONObject2.toString();
                        } else {
                            str5 = null;
                        }
                        str = str5;
                        str3 = optString2;
                        str2 = optString3;
                        str4 = optString;
                    } else {
                        str4 = null;
                        str3 = null;
                        str2 = null;
                        str = null;
                    }
                    j.f(string2, "hash");
                    return new ResponseData(string, string2, str4, str3, str2, str);
                }
                j.f(string2, "hash");
                return new ResponseData(string, string2, (String) null, (String) null, (String) null, (String) null, 60, (DefaultConstructorMarker) null);
            }
        } catch (JSONException e10) {
            Log.e("Error parsing response for CT config.", (Throwable) e10);
        }
        return null;
    }
}
