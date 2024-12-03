package com.google.firebase.abt;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AbtExperimentInfo {
    private static final String[] ALL_REQUIRED_KEYS = {"experimentId", EXPERIMENT_START_TIME_KEY, TIME_TO_LIVE_KEY, TRIGGER_TIMEOUT_KEY, "variantId"};
    static final String EXPERIMENT_ID_KEY = "experimentId";
    static final String EXPERIMENT_START_TIME_KEY = "experimentStartTime";
    static final String TIME_TO_LIVE_KEY = "timeToLiveMillis";
    static final String TRIGGER_EVENT_KEY = "triggerEvent";
    static final String TRIGGER_TIMEOUT_KEY = "triggerTimeoutMillis";
    static final String VARIANT_ID_KEY = "variantId";
    static final DateFormat protoTimestampStringParser = new SimpleDateFormat(DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601, Locale.US);
    private final String experimentId;
    private final Date experimentStartTime;
    private final long timeToLiveInMillis;
    private final String triggerEventName;
    private final long triggerTimeoutInMillis;
    private final String variantId;

    public AbtExperimentInfo(String str, String str2, String str3, Date date, long j10, long j11) {
        this.experimentId = str;
        this.variantId = str2;
        this.triggerEventName = str3;
        this.experimentStartTime = date;
        this.triggerTimeoutInMillis = j10;
        this.timeToLiveInMillis = j11;
    }

    static AbtExperimentInfo fromConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str = conditionalUserProperty.triggerEventName;
        if (str == null) {
            str = "";
        }
        return new AbtExperimentInfo(conditionalUserProperty.name, String.valueOf(conditionalUserProperty.value), str, new Date(conditionalUserProperty.creationTimestamp), conditionalUserProperty.triggerTimeout, conditionalUserProperty.timeToLive);
    }

    static AbtExperimentInfo fromMap(Map<String, String> map) throws AbtException {
        String str;
        validateExperimentInfoMap(map);
        try {
            Date parse = protoTimestampStringParser.parse(map.get(EXPERIMENT_START_TIME_KEY));
            long parseLong = Long.parseLong(map.get(TRIGGER_TIMEOUT_KEY));
            long parseLong2 = Long.parseLong(map.get(TIME_TO_LIVE_KEY));
            String str2 = map.get("experimentId");
            String str3 = map.get("variantId");
            if (map.containsKey(TRIGGER_EVENT_KEY)) {
                str = map.get(TRIGGER_EVENT_KEY);
            } else {
                str = "";
            }
            return new AbtExperimentInfo(str2, str3, str, parse, parseLong, parseLong2);
        } catch (ParseException e10) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e10);
        } catch (NumberFormatException e11) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e11);
        }
    }

    static void validateAbtExperimentInfo(AbtExperimentInfo abtExperimentInfo) throws AbtException {
        validateExperimentInfoMap(abtExperimentInfo.toStringMap());
    }

    private static void validateExperimentInfoMap(Map<String, String> map) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (String str : ALL_REQUIRED_KEYS) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", new Object[]{arrayList}));
        }
    }

    /* access modifiers changed from: package-private */
    public String getExperimentId() {
        return this.experimentId;
    }

    /* access modifiers changed from: package-private */
    public long getStartTimeInMillisSinceEpoch() {
        return this.experimentStartTime.getTime();
    }

    /* access modifiers changed from: package-private */
    public long getTimeToLiveInMillis() {
        return this.timeToLiveInMillis;
    }

    /* access modifiers changed from: package-private */
    public String getTriggerEventName() {
        return this.triggerEventName;
    }

    /* access modifiers changed from: package-private */
    public long getTriggerTimeoutInMillis() {
        return this.triggerTimeoutInMillis;
    }

    /* access modifiers changed from: package-private */
    public String getVariantId() {
        return this.variantId;
    }

    /* access modifiers changed from: package-private */
    public AnalyticsConnector.ConditionalUserProperty toConditionalUserProperty(String str) {
        String str2;
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = str;
        conditionalUserProperty.creationTimestamp = getStartTimeInMillisSinceEpoch();
        conditionalUserProperty.name = this.experimentId;
        conditionalUserProperty.value = this.variantId;
        if (TextUtils.isEmpty(this.triggerEventName)) {
            str2 = null;
        } else {
            str2 = this.triggerEventName;
        }
        conditionalUserProperty.triggerEventName = str2;
        conditionalUserProperty.triggerTimeout = this.triggerTimeoutInMillis;
        conditionalUserProperty.timeToLive = this.timeToLiveInMillis;
        return conditionalUserProperty;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> toStringMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("experimentId", this.experimentId);
        hashMap.put("variantId", this.variantId);
        hashMap.put(TRIGGER_EVENT_KEY, this.triggerEventName);
        hashMap.put(EXPERIMENT_START_TIME_KEY, protoTimestampStringParser.format(this.experimentStartTime));
        hashMap.put(TRIGGER_TIMEOUT_KEY, Long.toString(this.triggerTimeoutInMillis));
        hashMap.put(TIME_TO_LIVE_KEY, Long.toString(this.timeToLiveInMillis));
        return hashMap;
    }
}
