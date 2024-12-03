package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.jivesoftware.smack.packet.Session;
import org.json.JSONException;
import org.json.b;

class SettingsV3JsonTransform implements SettingsJsonTransform {
    SettingsV3JsonTransform() {
    }

    private static Settings.FeatureFlagData buildFeatureFlagDataFrom(b bVar) {
        return new Settings.FeatureFlagData(bVar.optBoolean("collect_reports", true), bVar.optBoolean("collect_anrs", false), bVar.optBoolean("collect_build_ids", false));
    }

    private static Settings.SessionData buildSessionDataFrom(b bVar) {
        return new Settings.SessionData(bVar.optInt("max_custom_exception_events", 8), 4);
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long j10, b bVar) {
        if (bVar.has("expires_at")) {
            return bVar.optLong("expires_at");
        }
        return currentTimeProvider.getCurrentTimeMillis() + (j10 * 1000);
    }

    public Settings buildFromJson(CurrentTimeProvider currentTimeProvider, b bVar) throws JSONException {
        Settings.SessionData sessionData;
        b bVar2 = bVar;
        int optInt = bVar2.optInt("settings_version", 0);
        int optInt2 = bVar2.optInt("cache_duration", 3600);
        double optDouble = bVar2.optDouble("on_demand_upload_rate_per_minute", 10.0d);
        double optDouble2 = bVar2.optDouble("on_demand_backoff_base", 1.2d);
        int optInt3 = bVar2.optInt("on_demand_backoff_step_duration_seconds", 60);
        if (bVar2.has(Session.ELEMENT)) {
            sessionData = buildSessionDataFrom(bVar2.getJSONObject(Session.ELEMENT));
        } else {
            sessionData = buildSessionDataFrom(new b());
        }
        return new Settings(getExpiresAtFrom(currentTimeProvider, (long) optInt2, bVar2), sessionData, buildFeatureFlagDataFrom(bVar2.getJSONObject("features")), optInt, optInt2, optDouble, optDouble2, optInt3);
    }
}
