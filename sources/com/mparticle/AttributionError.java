package com.mparticle;

import androidx.annotation.NonNull;

public class AttributionError {
    private String message;
    private int serviceProviderId;

    public String getMessage() {
        return this.message;
    }

    public int getServiceProviderId() {
        return this.serviceProviderId;
    }

    @NonNull
    public AttributionError setMessage(String str) {
        this.message = str;
        return this;
    }

    @NonNull
    public AttributionError setServiceProviderId(int i10) {
        this.serviceProviderId = i10;
        return this;
    }

    @NonNull
    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("Attribution Error:\n");
        boolean z11 = false;
        if (this.serviceProviderId > 0) {
            sb2.append("Service provider ID:\n");
            sb2.append(this.serviceProviderId);
            sb2.append("\n");
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.message != null) {
            sb2.append("Message:\n");
            sb2.append(this.message);
            sb2.append("\n");
        } else {
            z11 = z10;
        }
        if (z11) {
            sb2.append("Empty error");
        }
        return sb2.toString();
    }
}
