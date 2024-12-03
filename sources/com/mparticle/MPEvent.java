package com.mparticle;

import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.mparticle.BaseEvent;
import com.mparticle.MParticle;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.listeners.InternalListenerManager;
import com.mparticle.kits.ReportingMessage;
import com.mparticle.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class MPEvent extends BaseEvent {
    private String category;
    /* access modifiers changed from: private */
    public Double duration;
    /* access modifiers changed from: private */
    public Double endTime;
    /* access modifiers changed from: private */
    public boolean entering;
    private int eventHash;
    private String eventName;
    private MParticle.EventType eventType;
    /* access modifiers changed from: private */
    public boolean screenEvent;
    /* access modifiers changed from: private */
    public Double startTime;

    public static class Builder {
        private static final String EVENT_CATEGORY = "category";
        private static final String EVENT_CUSTOM_FLAGS = "customFlags";
        private static final String EVENT_DURATION = "duration";
        private static final String EVENT_END_TIME = "endTime";
        private static final String EVENT_INFO = "customAttributes";
        private static final String EVENT_NAME = "eventName";
        private static final String EVENT_SHOULD_UPLOAD_EVENT = "shouldUploadEvent";
        private static final String EVENT_START_TIME = "startTime";
        private static final String EVENT_TYPE = "eventType";
        /* access modifiers changed from: private */
        public String category;
        /* access modifiers changed from: private */
        public Map<String, ?> customAttributes;
        /* access modifiers changed from: private */
        public Map<String, List<String>> customFlags = null;
        /* access modifiers changed from: private */
        public Double duration = null;
        /* access modifiers changed from: private */
        public Double endTime = null;
        /* access modifiers changed from: private */
        public boolean entering = true;
        /* access modifiers changed from: private */
        public String eventName;
        /* access modifiers changed from: private */
        public MParticle.EventType eventType;
        /* access modifiers changed from: private */
        public boolean screenEvent;
        /* access modifiers changed from: private */
        public Boolean shouldUploadEvent;
        /* access modifiers changed from: private */
        public Double startTime = null;

        private Builder() {
        }

        public static Builder parseString(@NonNull String str) {
            Builder builder;
            Exception e10;
            try {
                b bVar = new b(str);
                builder = new Builder(bVar.getString(EVENT_NAME), MParticle.EventType.valueOf(bVar.getString(EVENT_TYPE)));
                try {
                    builder.category = bVar.optString(EVENT_CATEGORY);
                    if (bVar.has(EVENT_DURATION)) {
                        builder.duration = Double.valueOf(bVar.getDouble(EVENT_DURATION));
                    }
                    if (bVar.has(EVENT_START_TIME)) {
                        builder.startTime = Double.valueOf(bVar.getDouble(EVENT_START_TIME));
                    }
                    if (bVar.has("endTime")) {
                        builder.endTime = Double.valueOf(bVar.getDouble("endTime"));
                    }
                    if (bVar.has(EVENT_INFO)) {
                        b jSONObject = bVar.getJSONObject(EVENT_INFO);
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject.getString(next));
                        }
                        builder.customAttributes = new HashMap(hashMap);
                    }
                    if (bVar.has(EVENT_CUSTOM_FLAGS)) {
                        b jSONObject2 = bVar.getJSONObject(EVENT_CUSTOM_FLAGS);
                        HashMap hashMap2 = new HashMap();
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            a jSONArray = jSONObject2.getJSONArray(next2);
                            hashMap2.put(next2, new LinkedList());
                            for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                                ((List) hashMap2.get(next2)).add(jSONArray.n(i10));
                            }
                        }
                        builder.customFlags = hashMap2;
                    }
                    if (bVar.has(EVENT_SHOULD_UPLOAD_EVENT)) {
                        builder.shouldUploadEvent = Boolean.valueOf(bVar.getBoolean(EVENT_SHOULD_UPLOAD_EVENT));
                    }
                    return builder;
                } catch (Exception e11) {
                    e10 = e11;
                    Logger.warning("Failed to deserialize MPEvent.Builder: " + e10.toString());
                    return builder;
                }
            } catch (Exception e12) {
                e10 = e12;
                builder = null;
                Logger.warning("Failed to deserialize MPEvent.Builder: " + e10.toString());
                return builder;
            }
        }

        @NonNull
        private Builder startTime(double d10) {
            this.startTime = Double.valueOf(d10);
            return this;
        }

        @NonNull
        public Builder addCustomFlag(String str, String str2) {
            if (this.customFlags == null) {
                this.customFlags = new HashMap();
            }
            if (!this.customFlags.containsKey(str)) {
                this.customFlags.put(str, new LinkedList());
            }
            this.customFlags.get(str).add(str2);
            return this;
        }

        @NonNull
        public MPEvent build() {
            return new MPEvent(this);
        }

        @NonNull
        public Builder category(String str) {
            this.category = str;
            return this;
        }

        @NonNull
        public Builder customAttributes(Map<String, ?> map) {
            this.customAttributes = map;
            return this;
        }

        @NonNull
        public Builder customFlags(Map<String, List<String>> map) {
            this.customFlags = map;
            return this;
        }

        @NonNull
        public Builder duration(double d10) {
            this.duration = Double.valueOf(d10);
            return this;
        }

        @NonNull
        public Builder endTime() {
            return endTime((double) System.currentTimeMillis());
        }

        @NonNull
        public Builder eventName(@NonNull String str) {
            if (str != null) {
                this.eventName = str;
            }
            return this;
        }

        @NonNull
        public Builder eventType(@NonNull MParticle.EventType eventType2) {
            if (eventType2 != null) {
                this.eventType = eventType2;
            }
            return this;
        }

        @NonNull
        @Deprecated
        public Builder info(Map<String, String> map) {
            this.customAttributes = map;
            return this;
        }

        @NonNull
        public Builder internalNavigationDirection(boolean z10) {
            this.entering = z10;
            return this;
        }

        @NonNull
        public Builder shouldUploadEvent(boolean z10) {
            this.shouldUploadEvent = Boolean.valueOf(z10);
            return this;
        }

        @NonNull
        public String toString() {
            try {
                b bVar = new b();
                bVar.put(EVENT_TYPE, (Object) this.eventType.toString());
                bVar.put(EVENT_NAME, (Object) this.eventName);
                String str = this.category;
                if (str != null) {
                    bVar.put(EVENT_CATEGORY, (Object) str);
                }
                Double d10 = this.duration;
                if (d10 != null) {
                    bVar.put(EVENT_DURATION, (Object) d10);
                }
                if (this.customAttributes != null) {
                    b bVar2 = new b();
                    for (Map.Entry next : this.customAttributes.entrySet()) {
                        bVar2.put((String) next.getKey(), next.getValue());
                    }
                    bVar.put(EVENT_INFO, (Object) bVar2);
                }
                Double d11 = this.startTime;
                if (d11 != null) {
                    bVar.put(EVENT_START_TIME, (Object) d11);
                }
                Double d12 = this.endTime;
                if (d12 != null) {
                    bVar.put("endTime", (Object) d12);
                }
                if (this.customFlags != null) {
                    b bVar3 = new b();
                    for (Map.Entry next2 : this.customFlags.entrySet()) {
                        bVar3.put((String) next2.getKey(), (Object) new a((Collection<?>) (List) next2.getValue()));
                    }
                    bVar.put(EVENT_CUSTOM_FLAGS, (Object) bVar3);
                }
                Boolean bool = this.shouldUploadEvent;
                if (bool != null) {
                    bVar.put(EVENT_SHOULD_UPLOAD_EVENT, (Object) bool);
                }
                return bVar.toString();
            } catch (JSONException e10) {
                Logger.warning("Failed to serialize MPEvent.Builder: " + e10.toString());
                return super.toString();
            }
        }

        private Builder endTime(double d10) {
            this.endTime = Double.valueOf(d10);
            return this;
        }

        @NonNull
        public Builder startTime() {
            return startTime((double) System.currentTimeMillis());
        }

        public Builder(@NonNull String str, @NonNull MParticle.EventType eventType2) {
            this.eventName = str;
            this.eventType = eventType2;
        }

        public Builder(@NonNull String str) {
            this.eventName = str;
            this.eventType = MParticle.EventType.Other;
        }

        public Builder(@NonNull MPEvent mPEvent) {
            this.eventName = mPEvent.getEventName();
            this.eventType = mPEvent.getEventType();
            this.category = mPEvent.getCategory();
            this.customAttributes = mPEvent.getCustomAttributes();
            this.duration = mPEvent.duration;
            this.startTime = mPEvent.startTime;
            this.endTime = mPEvent.endTime;
            this.customFlags = mPEvent.getCustomFlags();
            this.entering = mPEvent.entering;
            this.screenEvent = mPEvent.screenEvent;
            this.shouldUploadEvent = Boolean.valueOf(mPEvent.isShouldUploadEvent());
        }
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && toString().equals(obj.toString()));
    }

    public String getCategory() {
        return this.category;
    }

    public int getEventHash() {
        if (this.eventHash == 0) {
            this.eventHash = MPUtility.mpHash(this.eventType.ordinal() + this.eventName);
        }
        return this.eventHash;
    }

    @NonNull
    public String getEventName() {
        return this.eventName;
    }

    @NonNull
    public MParticle.EventType getEventType() {
        return this.eventType;
    }

    @Deprecated
    public Map<String, String> getInfo() {
        return getCustomAttributeStrings();
    }

    public Double getLength() {
        Double d10 = this.duration;
        if (d10 != null) {
            return d10;
        }
        Double d11 = this.endTime;
        if (d11 == null || this.startTime == null) {
            return null;
        }
        double doubleValue = d11.doubleValue() - this.startTime.doubleValue();
        if (doubleValue <= 0.0d) {
            doubleValue = 0.0d;
        }
        return Double.valueOf(doubleValue);
    }

    @NonNull
    public d getMessage() {
        return new y.a(ReportingMessage.MessageType.EVENT).a(getEventType()).b(getEventName()).b(getLength()).a(getCustomFlags()).a(MPUtility.enforceAttributeConstraints(getCustomAttributeStrings()));
    }

    /* access modifiers changed from: package-private */
    public boolean getNavigationDirection() {
        return this.entering;
    }

    public boolean isScreenEvent() {
        return this.screenEvent;
    }

    public void setCustomAttributes(@NonNull Map<String, ?> map) {
        super.setCustomAttributes(map);
    }

    @Deprecated
    public void setInfo(Map<String, String> map) {
        setCustomAttributes(map);
    }

    /* access modifiers changed from: protected */
    public MPEvent setScreenEvent(boolean z10) {
        BaseEvent.Type type;
        this.screenEvent = z10;
        if (z10) {
            type = BaseEvent.Type.SCREEN_VIEW;
        } else {
            type = BaseEvent.Type.EVENT;
        }
        setType(type);
        return this;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.eventName != null) {
            sb2.append("Event name: ");
            sb2.append(this.eventName);
            sb2.append("\n");
        }
        if (this.eventType != null) {
            sb2.append("type: ");
            sb2.append(this.eventType.name());
            sb2.append("\n");
        }
        Double length = getLength();
        if (length != null && length.doubleValue() > 0.0d) {
            sb2.append("length: ");
            sb2.append(length);
            sb2.append("ms");
            sb2.append("\n");
        }
        if (getCustomAttributeStrings() != null) {
            sb2.append("customAttributes:\n");
            ArrayList<String> arrayList = new ArrayList<>(getCustomAttributeStrings().keySet());
            Collections.sort(arrayList);
            for (String str : arrayList) {
                sb2.append(str);
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append(getCustomAttributeStrings().get(str));
                sb2.append("\n");
            }
        }
        if (getCustomFlags() != null) {
            sb2.append("custom flags:\n");
            sb2.append(getCustomFlags().toString());
        }
        return sb2.toString();
    }

    private MPEvent() {
        super(BaseEvent.Type.EVENT);
        this.duration = null;
        this.startTime = null;
        this.endTime = null;
        this.entering = true;
    }

    private MPEvent(Builder builder) {
        super(BaseEvent.Type.EVENT);
        this.duration = null;
        this.startTime = null;
        this.endTime = null;
        this.entering = true;
        if (builder.eventType == null) {
            Logger.error("MPEvent created with no event type!");
        } else {
            this.eventType = builder.eventType;
        }
        if (builder.eventName == null) {
            Logger.error("MPEvent created with no event name!");
        } else if (builder.eventName.length() > 256) {
            Logger.error("MPEvent created with too long of a name and will be truncated, the limit is: 256");
            this.eventName = builder.eventName.substring(0, 256);
        } else {
            this.eventName = builder.eventName;
        }
        this.entering = builder.entering;
        setCustomAttributes(builder.customAttributes);
        if (builder.category != null) {
            this.category = builder.category;
            if (getCustomAttributeStrings() == null) {
                setCustomAttributes(new HashMap());
            }
            getCustomAttributeStrings().put("$Category", builder.category);
        }
        if (builder.duration != null) {
            this.duration = builder.duration;
        }
        if (builder.endTime != null) {
            this.endTime = builder.endTime;
        }
        if (builder.startTime != null) {
            this.startTime = builder.startTime;
        }
        if (builder.customFlags != null) {
            setCustomFlags(builder.customFlags);
        }
        if (builder.shouldUploadEvent != null) {
            setShouldUploadEvent(builder.shouldUploadEvent.booleanValue());
        }
        this.screenEvent = builder.screenEvent;
    }

    public MPEvent(@NonNull MPEvent mPEvent) {
        super(BaseEvent.Type.EVENT);
        this.duration = null;
        this.startTime = null;
        this.endTime = null;
        this.entering = true;
        this.eventType = mPEvent.eventType;
        this.eventName = mPEvent.eventName;
        if (mPEvent.getCustomAttributes() != null) {
            setCustomAttributes(mPEvent.getCustomAttributes());
        } else {
            setCustomAttributes((Map<String, ?>) null);
        }
        this.category = mPEvent.category;
        this.duration = mPEvent.duration;
        this.endTime = mPEvent.endTime;
        this.startTime = mPEvent.startTime;
        setCustomFlags(mPEvent.getCustomFlags());
        this.entering = mPEvent.entering;
        this.screenEvent = mPEvent.screenEvent;
        setShouldUploadEvent(mPEvent.isShouldUploadEvent());
        InternalListenerManager.getListener().onCompositeObjects(mPEvent, this);
    }
}
