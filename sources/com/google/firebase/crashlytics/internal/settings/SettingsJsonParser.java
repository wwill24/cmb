package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.b;

public class SettingsJsonParser {
    private final CurrentTimeProvider currentTimeProvider;

    SettingsJsonParser(CurrentTimeProvider currentTimeProvider2) {
        this.currentTimeProvider = currentTimeProvider2;
    }

    private static SettingsJsonTransform getJsonTransformForVersion(int i10) {
        if (i10 == 3) {
            return new SettingsV3JsonTransform();
        }
        Logger logger = Logger.getLogger();
        logger.e("Could not determine SettingsJsonTransform for settings version " + i10 + ". Using default settings values.");
        return new DefaultSettingsJsonTransform();
    }

    public Settings parseSettingsJson(b bVar) throws JSONException {
        return getJsonTransformForVersion(bVar.getInt("settings_version")).buildFromJson(this.currentTimeProvider, bVar);
    }
}
