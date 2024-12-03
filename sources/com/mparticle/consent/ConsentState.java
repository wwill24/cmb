package com.mparticle.consent;

import androidx.annotation.NonNull;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.b;

public final class ConsentState {
    private static final String SERIALIZED_CCPA_KEY = "CCPA";
    private static final String SERIALIZED_GDPR_KEY = "GDPR";
    private CCPAConsent ccpaConsentState;
    private Map<String, GDPRConsent> gdprConsentState;

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public static String canonicalizeForDeduplication(String str) {
        if (MPUtility.isEmpty((CharSequence) str)) {
            return null;
        }
        return str.toLowerCase(Locale.US).trim();
    }

    @NonNull
    public static Builder withConsentState(@NonNull ConsentState consentState) {
        return new Builder();
    }

    public CCPAConsent getCCPAConsentState() {
        return this.ccpaConsentState;
    }

    @NonNull
    public Map<String, GDPRConsent> getGDPRConsentState() {
        return Collections.unmodifiableMap(this.gdprConsentState);
    }

    @NonNull
    public String toString() {
        b bVar = new b();
        try {
            b bVar2 = new b();
            bVar.put(SERIALIZED_GDPR_KEY, (Object) bVar2);
            for (Map.Entry next : this.gdprConsentState.entrySet()) {
                bVar2.put((String) next.getKey(), (Object) ((GDPRConsent) next.getValue()).toString());
            }
            CCPAConsent cCPAConsent = this.ccpaConsentState;
            if (cCPAConsent != null) {
                bVar.put(SERIALIZED_CCPA_KEY, (Object) cCPAConsent.toString());
            }
        } catch (JSONException unused) {
        }
        return bVar.toString();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public CCPAConsent ccpaConsent;
        /* access modifiers changed from: private */
        public Map<String, GDPRConsent> gdprConsentState;

        @NonNull
        public Builder addGDPRConsentState(@NonNull String str, @NonNull GDPRConsent gDPRConsent) {
            String access$400 = ConsentState.canonicalizeForDeduplication(str);
            if (MPUtility.isEmpty((CharSequence) access$400)) {
                Logger.error("Cannot set GDPR Consent with null or empty purpose.");
                return this;
            }
            if (this.gdprConsentState == null) {
                this.gdprConsentState = new HashMap();
            }
            this.gdprConsentState.put(access$400, gDPRConsent);
            return this;
        }

        @NonNull
        public ConsentState build() {
            return new ConsentState(this);
        }

        @NonNull
        @Deprecated
        public Builder removeCCPAConsent() {
            return removeCCPAConsentState();
        }

        @NonNull
        public Builder removeCCPAConsentState() {
            this.ccpaConsent = null;
            return this;
        }

        @NonNull
        public Builder removeGDPRConsentState(@NonNull String str) {
            String access$400 = ConsentState.canonicalizeForDeduplication(str);
            if (MPUtility.isEmpty((CharSequence) access$400)) {
                Logger.error("Cannot remove GDPR Consent with null or empty purpose");
                return this;
            }
            Map<String, GDPRConsent> map = this.gdprConsentState;
            if (map == null) {
                return this;
            }
            map.remove(access$400);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setCCPAConsent(@NonNull CCPAConsent cCPAConsent) {
            return setCCPAConsentState(cCPAConsent);
        }

        @NonNull
        public Builder setCCPAConsentState(@NonNull CCPAConsent cCPAConsent) {
            this.ccpaConsent = cCPAConsent;
            return this;
        }

        @NonNull
        public Builder setGDPRConsentState(Map<String, GDPRConsent> map) {
            if (map == null) {
                this.gdprConsentState = new HashMap();
                return this;
            }
            HashMap hashMap = new HashMap(map);
            this.gdprConsentState = new HashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                addGDPRConsentState((String) entry.getKey(), (GDPRConsent) entry.getValue());
            }
            return this;
        }

        @NonNull
        public String toString() {
            return build().toString();
        }

        public Builder() {
            this.gdprConsentState = new HashMap();
            this.ccpaConsent = null;
        }

        private Builder(ConsentState consentState) {
            this.gdprConsentState = new HashMap();
            this.ccpaConsent = null;
            setGDPRConsentState(consentState.getGDPRConsentState());
            setCCPAConsentState(consentState.getCCPAConsentState());
        }

        private Builder(String str) {
            this.gdprConsentState = new HashMap();
            this.ccpaConsent = null;
            if (!MPUtility.isEmpty((CharSequence) str)) {
                try {
                    b bVar = new b(str);
                    if (bVar.has(ConsentState.SERIALIZED_GDPR_KEY)) {
                        b jSONObject = bVar.getJSONObject(ConsentState.SERIALIZED_GDPR_KEY);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            addGDPRConsentState(next, GDPRConsent.withGDPRConsent(jSONObject.getString(next)).build());
                        }
                    }
                    if (bVar.has(ConsentState.SERIALIZED_CCPA_KEY)) {
                        setCCPAConsentState(CCPAConsent.withCCPAConsent(bVar.getString(ConsentState.SERIALIZED_CCPA_KEY)).build());
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    private ConsentState() {
        this.gdprConsentState = null;
    }

    @NonNull
    public static Builder withConsentState(@NonNull String str) {
        return new Builder(str);
    }

    private ConsentState(Builder builder) {
        this.gdprConsentState = null;
        this.gdprConsentState = builder.gdprConsentState;
        this.ccpaConsentState = builder.ccpaConsent;
    }
}
