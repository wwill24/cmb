package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class ConfigContainer {
    static final String ABT_EXPERIMENTS_KEY = "abt_experiments_key";
    static final String CONFIGS_KEY = "configs_key";
    /* access modifiers changed from: private */
    public static final Date DEFAULTS_FETCH_TIME = new Date(0);
    static final String FETCH_TIME_KEY = "fetch_time_key";
    static final String PERSONALIZATION_METADATA_KEY = "personalization_metadata_key";
    static final String TEMPLATE_VERSION_NUMBER_KEY = "template_version_number_key";
    private a abtExperiments;
    private b configsJson;
    private b containerJson;
    private Date fetchTime;
    private b personalizationMetadata;
    private long templateVersionNumber;

    public static class Builder {
        private a builderAbtExperiments;
        private b builderConfigsJson;
        private Date builderFetchTime;
        private b builderPersonalizationMetadata;
        private long builderTemplateVersionNumber;

        public ConfigContainer build() throws JSONException {
            return new ConfigContainer(this.builderConfigsJson, this.builderFetchTime, this.builderAbtExperiments, this.builderPersonalizationMetadata, this.builderTemplateVersionNumber);
        }

        public Builder replaceConfigsWith(Map<String, String> map) {
            this.builderConfigsJson = new b((Map<?, ?>) map);
            return this;
        }

        public Builder withAbtExperiments(a aVar) {
            try {
                this.builderAbtExperiments = new a(aVar.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withFetchTime(Date date) {
            this.builderFetchTime = date;
            return this;
        }

        public Builder withPersonalizationMetadata(b bVar) {
            try {
                this.builderPersonalizationMetadata = new b(bVar.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withTemplateVersionNumber(long j10) {
            this.builderTemplateVersionNumber = j10;
            return this;
        }

        private Builder() {
            this.builderConfigsJson = new b();
            this.builderFetchTime = ConfigContainer.DEFAULTS_FETCH_TIME;
            this.builderAbtExperiments = new a();
            this.builderPersonalizationMetadata = new b();
            this.builderTemplateVersionNumber = 0;
        }

        public Builder replaceConfigsWith(b bVar) {
            try {
                this.builderConfigsJson = new b(bVar.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder(ConfigContainer configContainer) {
            this.builderConfigsJson = configContainer.getConfigs();
            this.builderFetchTime = configContainer.getFetchTime();
            this.builderAbtExperiments = configContainer.getAbtExperiments();
            this.builderPersonalizationMetadata = configContainer.getPersonalizationMetadata();
            this.builderTemplateVersionNumber = configContainer.getTemplateVersionNumber();
        }
    }

    static ConfigContainer copyOf(b bVar) throws JSONException {
        b optJSONObject = bVar.optJSONObject(PERSONALIZATION_METADATA_KEY);
        if (optJSONObject == null) {
            optJSONObject = new b();
        }
        return new ConfigContainer(bVar.getJSONObject(CONFIGS_KEY), new Date(bVar.getLong(FETCH_TIME_KEY)), bVar.getJSONArray(ABT_EXPERIMENTS_KEY), optJSONObject, bVar.optLong(TEMPLATE_VERSION_NUMBER_KEY));
    }

    private static ConfigContainer deepCopyOf(b bVar) throws JSONException {
        return copyOf(new b(bVar.toString()));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigContainer)) {
            return false;
        }
        return this.containerJson.toString().equals(((ConfigContainer) obj).toString());
    }

    public a getAbtExperiments() {
        return this.abtExperiments;
    }

    public Set<String> getChangedParams(ConfigContainer configContainer) throws JSONException {
        b configs = deepCopyOf(configContainer.containerJson).getConfigs();
        HashSet hashSet = new HashSet();
        Iterator<String> keys = getConfigs().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!configContainer.getConfigs().has(next)) {
                hashSet.add(next);
            } else if (!getConfigs().get(next).equals(configContainer.getConfigs().get(next))) {
                hashSet.add(next);
            } else if ((getPersonalizationMetadata().has(next) && !configContainer.getPersonalizationMetadata().has(next)) || (!getPersonalizationMetadata().has(next) && configContainer.getPersonalizationMetadata().has(next))) {
                hashSet.add(next);
            } else if (!getPersonalizationMetadata().has(next) || !configContainer.getPersonalizationMetadata().has(next) || getPersonalizationMetadata().getJSONObject(next).toString().equals(configContainer.getPersonalizationMetadata().getJSONObject(next).toString())) {
                configs.remove(next);
            } else {
                hashSet.add(next);
            }
        }
        Iterator<String> keys2 = configs.keys();
        while (keys2.hasNext()) {
            hashSet.add(keys2.next());
        }
        return hashSet;
    }

    public b getConfigs() {
        return this.configsJson;
    }

    public Date getFetchTime() {
        return this.fetchTime;
    }

    public b getPersonalizationMetadata() {
        return this.personalizationMetadata;
    }

    public long getTemplateVersionNumber() {
        return this.templateVersionNumber;
    }

    public int hashCode() {
        return this.containerJson.hashCode();
    }

    public String toString() {
        return this.containerJson.toString();
    }

    private ConfigContainer(b bVar, Date date, a aVar, b bVar2, long j10) throws JSONException {
        b bVar3 = new b();
        bVar3.put(CONFIGS_KEY, (Object) bVar);
        bVar3.put(FETCH_TIME_KEY, date.getTime());
        bVar3.put(ABT_EXPERIMENTS_KEY, (Object) aVar);
        bVar3.put(PERSONALIZATION_METADATA_KEY, (Object) bVar2);
        bVar3.put(TEMPLATE_VERSION_NUMBER_KEY, j10);
        this.configsJson = bVar;
        this.fetchTime = date;
        this.abtExperiments = aVar;
        this.personalizationMetadata = bVar2;
        this.templateVersionNumber = j10;
        this.containerJson = bVar3;
    }

    public static Builder newBuilder(ConfigContainer configContainer) {
        return new Builder(configContainer);
    }
}
