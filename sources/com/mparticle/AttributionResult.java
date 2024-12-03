package com.mparticle;

import androidx.annotation.NonNull;
import org.json.b;

public class AttributionResult {
    private String linkUrl = null;
    private b parameters;
    private int serviceProviderId;

    public String getLink() {
        return this.linkUrl;
    }

    public b getParameters() {
        return this.parameters;
    }

    public int getServiceProviderId() {
        return this.serviceProviderId;
    }

    @NonNull
    public AttributionResult setLink(String str) {
        this.linkUrl = str;
        return this;
    }

    @NonNull
    public AttributionResult setParameters(b bVar) {
        this.parameters = bVar;
        return this;
    }

    @NonNull
    public AttributionResult setServiceProviderId(int i10) {
        this.serviceProviderId = i10;
        return this;
    }

    @NonNull
    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("Attribution Result:\n");
        boolean z11 = false;
        if (this.serviceProviderId > 0) {
            sb2.append("Service provider ID:\n");
            sb2.append(this.serviceProviderId);
            sb2.append("\n");
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.linkUrl != null) {
            sb2.append("Link URL:\n");
            sb2.append(this.linkUrl);
            sb2.append("\n");
            z10 = false;
        }
        if (this.parameters != null) {
            sb2.append("Link parameters:\n");
            sb2.append(this.parameters.toString());
            sb2.append("\n");
        } else {
            z11 = z10;
        }
        if (z11) {
            sb2.append("Empty");
        }
        return sb2.toString();
    }
}
