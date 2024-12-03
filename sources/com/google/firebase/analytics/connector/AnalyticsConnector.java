package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.annotations.DeferredApi;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnalyticsConnector {

    public interface AnalyticsConnectorHandle {
        void registerEventNames(@NonNull Set<String> set);

        void unregister();

        void unregisterEventNames();
    }

    public interface AnalyticsConnectorListener {
        void onMessageTriggered(int i10, Bundle bundle);
    }

    public static class ConditionalUserProperty {
        public boolean active;
        public long creationTimestamp;
        public String expiredEventName;
        public Bundle expiredEventParams;
        @NonNull
        public String name;
        @NonNull
        public String origin;
        public long timeToLive;
        public String timedOutEventName;
        public Bundle timedOutEventParams;
        public String triggerEventName;
        public long triggerTimeout;
        public String triggeredEventName;
        public Bundle triggeredEventParams;
        public long triggeredTimestamp;
        public Object value;
    }

    void clearConditionalUserProperty(@NonNull String str, String str2, Bundle bundle);

    @NonNull
    List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, String str2);

    int getMaxUserProperties(@NonNull String str);

    @NonNull
    Map<String, Object> getUserProperties(boolean z10);

    void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle);

    @DeferredApi
    AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, @NonNull AnalyticsConnectorListener analyticsConnectorListener);

    void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty);

    void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj);
}
