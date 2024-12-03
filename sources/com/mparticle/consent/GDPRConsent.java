package com.mparticle.consent;

import androidx.annotation.NonNull;
import com.mparticle.internal.MPUtility;
import org.json.JSONException;
import org.json.b;

public final class GDPRConsent extends a {
    @NonNull
    public static Builder builder(boolean z10) {
        return new Builder(z10);
    }

    @NonNull
    public static Builder withGDPRConsent(@NonNull GDPRConsent gDPRConsent) {
        return new Builder();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Boolean mConsented;
        /* access modifiers changed from: private */
        public String mDocument;
        /* access modifiers changed from: private */
        public String mHardwareId;
        /* access modifiers changed from: private */
        public String mLocation;
        /* access modifiers changed from: private */
        public Long mTimestamp;

        /* access modifiers changed from: private */
        public static Builder withString(String str) {
            Builder builder = GDPRConsent.builder(false);
            if (MPUtility.isEmpty((CharSequence) str)) {
                return builder;
            }
            try {
                b bVar = new b(str);
                builder.consented(bVar.optBoolean("consented"));
                if (bVar.has("timestamp")) {
                    builder.timestamp(Long.valueOf(bVar.optLong("timestamp")));
                }
                builder.document(bVar.optString("document", (String) null));
                builder.location(bVar.optString("location", (String) null));
                builder.hardwareId(bVar.optString("hardware_id", (String) null));
            } catch (JSONException unused) {
            }
            return builder;
        }

        @NonNull
        public GDPRConsent build() {
            return new GDPRConsent(this);
        }

        @NonNull
        public Builder consented(boolean z10) {
            this.mConsented = Boolean.valueOf(z10);
            return this;
        }

        @NonNull
        public Builder document(String str) {
            this.mDocument = str;
            return this;
        }

        @NonNull
        public Builder hardwareId(String str) {
            this.mHardwareId = str;
            return this;
        }

        @NonNull
        public Builder location(String str) {
            this.mLocation = str;
            return this;
        }

        @NonNull
        public Builder timestamp(Long l10) {
            this.mTimestamp = l10;
            return this;
        }

        @NonNull
        public String toString() {
            return build().toString();
        }

        private Builder(GDPRConsent gDPRConsent) {
            this.mConsented = null;
            this.mDocument = null;
            this.mTimestamp = null;
            this.mLocation = null;
            this.mHardwareId = null;
            consented(gDPRConsent.isConsented()).document(gDPRConsent.getDocument()).timestamp(gDPRConsent.getTimestamp()).location(gDPRConsent.getLocation()).hardwareId(gDPRConsent.getHardwareId());
        }

        private Builder(boolean z10) {
            this.mConsented = null;
            this.mDocument = null;
            this.mTimestamp = null;
            this.mLocation = null;
            this.mHardwareId = null;
            consented(z10);
        }
    }

    private GDPRConsent() {
    }

    static Builder withGDPRConsent(String str) {
        return Builder.withString(str);
    }

    private GDPRConsent(Builder builder) {
        if (builder.mTimestamp == null) {
            this.mTimestamp = Long.valueOf(System.currentTimeMillis());
        } else {
            this.mTimestamp = builder.mTimestamp;
        }
        this.mConsented = builder.mConsented.booleanValue();
        this.mDocument = builder.mDocument;
        this.mLocation = builder.mLocation;
        this.mHardwareId = builder.mHardwareId;
    }
}
