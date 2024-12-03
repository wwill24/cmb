package com.coffeemeetsbagel.models;

import fa.a;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.xdata.FormField;
import org.json.b;

public enum VerificationStatus {
    REQUIRED(FormField.Required.ELEMENT),
    IN_REVIEW("in_review"),
    REJECTED("rejected"),
    NONE("");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final String TAG = null;
    private final String apiStatus;
    private String referenceId;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VerificationStatus fromApiKey(String str) {
            VerificationStatus verificationStatus;
            VerificationStatus[] values = VerificationStatus.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
            for (VerificationStatus verificationStatus2 : values) {
                linkedHashMap.put(verificationStatus2.getApiStatus(), verificationStatus2);
            }
            if (!linkedHashMap.containsKey(str)) {
                return VerificationStatus.NONE;
            }
            if (str == null || (verificationStatus = (VerificationStatus) linkedHashMap.get(str)) == null) {
                return VerificationStatus.NONE;
            }
            return verificationStatus;
        }

        public final VerificationStatus fromJsonString(String str) {
            if (str == null) {
                str = "";
            }
            try {
                a.C0491a aVar = a.f40771d;
                String tag = getTAG();
                aVar.a(tag, "fromResponseBody(): " + str);
                b jSONObject = new b(str).getJSONObject("verification");
                VerificationStatus fromApiKey = fromApiKey(jSONObject.getString("status"));
                String string = jSONObject.getString("reference_id");
                j.f(string, "verification.getString(\"reference_id\")");
                fromApiKey.setReferenceId(string);
                String tag2 = getTAG();
                aVar.a(tag2, 9 + fromApiKey.name());
                return fromApiKey;
            } catch (Exception e10) {
                a.C0491a aVar2 = a.f40771d;
                String tag3 = getTAG();
                aVar2.a(tag3, "\tException: " + e10);
                return VerificationStatus.NONE;
            }
        }

        public final String getTAG() {
            return VerificationStatus.TAG;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        TAG = "VerificationStatus";
    }

    private VerificationStatus(String str) {
        this.apiStatus = str;
        this.referenceId = "";
    }

    public final String getApiStatus() {
        return this.apiStatus;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public final void setReferenceId(String str) {
        j.g(str, "<set-?>");
        this.referenceId = str;
    }
}
