package com.mparticle.consent;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.b;

public class a {
    static final String SERIALIZED_KEY_CONSENTED = "consented";
    static final String SERIALIZED_KEY_DOCUMENT = "document";
    static final String SERIALIZED_KEY_HARDWARE_ID = "hardware_id";
    static final String SERIALIZED_KEY_LOCATION = "location";
    static final String SERIALIZED_KEY_TIMESTAMP = "timestamp";
    boolean mConsented;
    String mDocument;
    String mHardwareId;
    String mLocation;
    Long mTimestamp;

    public String getDocument() {
        return this.mDocument;
    }

    public String getHardwareId() {
        return this.mHardwareId;
    }

    public String getLocation() {
        return this.mLocation;
    }

    @NonNull
    public Long getTimestamp() {
        return this.mTimestamp;
    }

    public boolean isConsented() {
        return this.mConsented;
    }

    @NonNull
    public String toString() {
        b bVar = new b();
        try {
            bVar.put(SERIALIZED_KEY_CONSENTED, isConsented());
            if (getTimestamp() != null) {
                bVar.put("timestamp", (Object) getTimestamp());
            }
            if (getDocument() != null) {
                bVar.put(SERIALIZED_KEY_DOCUMENT, (Object) getDocument());
            }
            if (getLocation() != null) {
                bVar.put("location", (Object) getLocation());
            }
            if (getHardwareId() != null) {
                bVar.put(SERIALIZED_KEY_HARDWARE_ID, (Object) getHardwareId());
            }
        } catch (JSONException unused) {
        }
        return bVar.toString();
    }
}
