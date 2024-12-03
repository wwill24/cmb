package com.mparticle.networking;

import androidx.annotation.NonNull;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.networking.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;

public class DomainMapping {
    private boolean eventsOnly;
    private List<Certificate> mCertificates;
    private b.C0262b mType;
    private String mUrl;
    private boolean overridesSubdirectory;

    public static class Builder {
        List<Certificate> certificates;
        boolean eventsOnly;
        String newUrl;
        boolean overridesSubdirectory;
        b.C0262b type;

        /* access modifiers changed from: private */
        public static Builder withJson(String str) {
            try {
                org.json.b bVar = new org.json.b(str);
                Builder builder = new Builder(b.C0262b.a(bVar.getInt("mType")), bVar.getString("url"));
                org.json.a jSONArray = bVar.getJSONArray("mCertificates");
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    builder.addCertificate(Certificate.withCertificate(jSONArray.j(i10)));
                }
                return builder;
            } catch (JSONException e10) {
                Logger.error(e10, new String[0]);
                return null;
            }
        }

        @NonNull
        public Builder addCertificate(@NonNull Certificate certificate) {
            return addCertificate(certificate, (Integer) null);
        }

        @NonNull
        public DomainMapping build() {
            return new DomainMapping(this);
        }

        @NonNull
        public Builder setCertificates(List<Certificate> list) {
            this.certificates = new ArrayList();
            for (Certificate next : list) {
                if (next != null) {
                    addCertificate(next);
                }
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setEventsOnly(boolean z10) {
            this.eventsOnly = z10;
            return this;
        }

        @NonNull
        public Builder addCertificate(@NonNull String str, @NonNull String str2) {
            Certificate with = Certificate.with(str, str2);
            if (with != null) {
                this.certificates.add(with);
            }
            return this;
        }

        private Builder(b.C0262b bVar) {
            this.certificates = new LinkedList();
            this.overridesSubdirectory = false;
            this.type = bVar;
            this.newUrl = d.a(bVar);
        }

        @NonNull
        public Builder addCertificate(@NonNull Certificate certificate, Integer num) {
            if (certificate != null) {
                if (this.certificates == null) {
                    this.certificates = new LinkedList();
                }
                if (num != null) {
                    this.certificates.add(num.intValue(), certificate);
                } else {
                    this.certificates.add(certificate);
                }
            } else if (!MPUtility.isDevEnv()) {
                Logger.error("NetworkOptions issue: Certificate is null, cannot be added.");
            } else {
                throw new IllegalArgumentException("NetworkOptions issue: Certificate is null, cannot be added.");
            }
            return this;
        }

        private Builder(b.C0262b bVar, String str) {
            this.certificates = new LinkedList();
            this.overridesSubdirectory = false;
            this.type = bVar;
            this.newUrl = str;
        }

        @NonNull
        public Builder addCertificate(@NonNull String str, @NonNull String str2, Integer num) {
            addCertificate(Certificate.with(str, str2), num);
            return this;
        }

        private Builder(b.C0262b bVar, String str, boolean z10) {
            this.certificates = new LinkedList();
            this.type = bVar;
            this.newUrl = str;
            this.overridesSubdirectory = z10;
        }
    }

    public static Builder aliasMapping(String str) {
        return aliasMapping(str, false);
    }

    @NonNull
    public static Builder audienceMapping(String str) {
        return audienceMapping(str, false);
    }

    @NonNull
    public static Builder configMapping(String str) {
        return configMapping(str, false);
    }

    @NonNull
    public static Builder eventsMapping(String str) {
        return eventsMapping(str, false);
    }

    @NonNull
    public static Builder identityMapping(String str) {
        return identityMapping(str, false);
    }

    static Builder withDomainMapping(String str) {
        return Builder.withJson(str);
    }

    static Builder withEndpoint(b.C0262b bVar) {
        return new Builder(bVar);
    }

    @NonNull
    public List<Certificate> getCertificates() {
        return new LinkedList(this.mCertificates);
    }

    /* access modifiers changed from: package-private */
    public b.C0262b getType() {
        return this.mType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    /* access modifiers changed from: package-private */
    public boolean isEventsOnly() {
        return this.eventsOnly;
    }

    public boolean isOverridesSubdirectory() {
        return this.overridesSubdirectory;
    }

    /* access modifiers changed from: package-private */
    public void setCertificates(List<Certificate> list) {
        if (MPUtility.isEmpty((Collection) list)) {
            this.mCertificates = new ArrayList();
        } else {
            this.mCertificates = new ArrayList(list);
        }
    }

    /* access modifiers changed from: package-private */
    public void setUrl(String str) {
        this.mUrl = str;
    }

    /* access modifiers changed from: package-private */
    public org.json.b toJson() {
        org.json.b bVar = new org.json.b();
        try {
            org.json.a aVar = new org.json.a();
            bVar.put("mCertificates", (Object) aVar);
            List<Certificate> list = this.mCertificates;
            if (list != null) {
                for (Certificate json : list) {
                    aVar.E(json.toJson());
                }
            }
            return new org.json.b().put("mType", this.mType.f22622a).put("url", (Object) this.mUrl).put("mCertificates", (Object) aVar);
        } catch (JSONException e10) {
            Logger.error(e10, new String[0]);
            return bVar;
        }
    }

    @NonNull
    public String toString() {
        return toJson().toString();
    }

    private DomainMapping(Builder builder) {
        this.mCertificates = new LinkedList();
        this.mType = builder.type;
        this.mUrl = builder.newUrl;
        List<Certificate> list = builder.certificates;
        if (list == null || list.size() <= 0) {
            Logger.warning(String.format("Domain mapping for %s does not have any mCertificates, default mCertificates will be applied", new Object[]{builder.type.name()}));
        } else {
            this.mCertificates = new LinkedList(builder.certificates);
        }
        this.overridesSubdirectory = builder.overridesSubdirectory;
        this.eventsOnly = builder.eventsOnly;
    }

    public static Builder aliasMapping(String str, boolean z10) {
        return new Builder(b.C0262b.ALIAS, str, z10);
    }

    public static Builder audienceMapping(String str, boolean z10) {
        return new Builder(b.C0262b.AUDIENCE, str, z10);
    }

    public static Builder configMapping(String str, boolean z10) {
        return new Builder(b.C0262b.CONFIG, str, z10);
    }

    public static Builder eventsMapping(String str, boolean z10) {
        return eventsMapping(str, z10, false);
    }

    public static Builder identityMapping(String str, boolean z10) {
        return new Builder(b.C0262b.IDENTITY, str, z10);
    }

    public static Builder eventsMapping(String str, boolean z10, boolean z11) {
        return new Builder(b.C0262b.EVENTS, str, z10).setEventsOnly(z11);
    }
}
