package com.mparticle.networking;

import androidx.annotation.NonNull;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.networking.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class NetworkOptions {
    Map<b.C0262b, DomainMapping> domainMappings;
    boolean pinningDisabledInDevelopment;

    public static class Builder {
        /* access modifiers changed from: private */
        public Map<b.C0262b, DomainMapping> domainMappings;
        /* access modifiers changed from: private */
        public Boolean pinningDisabledInDevelopment;

        @NonNull
        public Builder addDomainMapping(DomainMapping domainMapping) {
            if (this.domainMappings == null) {
                this.domainMappings = new HashMap();
            }
            if (this.domainMappings.containsKey(domainMapping.getType())) {
                try {
                    Logger.warning("Duplicate DomainMapping submitted, DomainMapping:\n" + domainMapping.toJson().toString(4) + "\n will overwrite DomainMapping:\n" + domainMapping.toJson().toString(4));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
            if (domainMapping.getType() == b.C0262b.EVENTS && !domainMapping.isEventsOnly()) {
                Map<b.C0262b, DomainMapping> map = this.domainMappings;
                b.C0262b bVar = b.C0262b.ALIAS;
                if (!map.containsKey(bVar)) {
                    this.domainMappings.put(bVar, domainMapping);
                }
            }
            this.domainMappings.put(domainMapping.getType(), domainMapping);
            return this;
        }

        @NonNull
        public NetworkOptions build() {
            return new NetworkOptions(this);
        }

        @NonNull
        public Builder setDomainMappings(List<DomainMapping> list) {
            if (list == null) {
                this.domainMappings = new HashMap();
                return this;
            }
            for (DomainMapping addDomainMapping : list) {
                addDomainMapping(addDomainMapping);
            }
            return this;
        }

        @NonNull
        public Builder setPinningDisabledInDevelopment(boolean z10) {
            this.pinningDisabledInDevelopment = Boolean.valueOf(z10);
            return this;
        }

        private Builder() {
            this.domainMappings = new HashMap();
        }
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    private org.json.b toJson() {
        org.json.b bVar = new org.json.b();
        try {
            org.json.a aVar = new org.json.a();
            bVar.put("disableDevPinning", this.pinningDisabledInDevelopment);
            bVar.put("domainMappings", (Object) aVar);
            for (DomainMapping domainMapping : this.domainMappings.values()) {
                aVar.E(domainMapping.toString());
            }
        } catch (JSONException e10) {
            Logger.error(e10, new String[0]);
        }
        return bVar;
    }

    public static NetworkOptions withNetworkOptions(String str) {
        if (MPUtility.isEmpty((CharSequence) str)) {
            return null;
        }
        Builder builder = new Builder();
        try {
            org.json.b bVar = new org.json.b(str);
            builder.setPinningDisabledInDevelopment(bVar.optBoolean("disableDevPinning", false));
            org.json.a jSONArray = bVar.getJSONArray("domainMappings");
            for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                builder.addDomainMapping(DomainMapping.withDomainMapping(jSONArray.n(i10)).build());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return builder.build();
    }

    public DomainMapping getAliasDomain() {
        return this.domainMappings.get(b.C0262b.ALIAS);
    }

    public DomainMapping getConfigDomain() {
        return this.domainMappings.get(b.C0262b.CONFIG);
    }

    /* access modifiers changed from: package-private */
    public DomainMapping getDomain(b.C0262b bVar) {
        return this.domainMappings.get(bVar);
    }

    @NonNull
    public List<DomainMapping> getDomainMappings() {
        return new ArrayList(this.domainMappings.values());
    }

    public DomainMapping getEventsDomain() {
        return this.domainMappings.get(b.C0262b.EVENTS);
    }

    public DomainMapping getIdentityDomain() {
        return this.domainMappings.get(b.C0262b.IDENTITY);
    }

    public boolean isPinningDisabledInDevelopment() {
        return this.pinningDisabledInDevelopment;
    }

    @NonNull
    public String toString() {
        return toJson().toString();
    }

    private NetworkOptions() {
        this.domainMappings = new HashMap();
        this.pinningDisabledInDevelopment = false;
    }

    private NetworkOptions(Builder builder) {
        this.domainMappings = new HashMap();
        this.pinningDisabledInDevelopment = false;
        if (builder.domainMappings != null) {
            this.domainMappings = builder.domainMappings;
        }
        if (builder.pinningDisabledInDevelopment != null) {
            this.pinningDisabledInDevelopment = builder.pinningDisabledInDevelopment.booleanValue();
        }
    }
}
