package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.b;

interface SettingsJsonTransform {
    Settings buildFromJson(CurrentTimeProvider currentTimeProvider, b bVar) throws JSONException;
}
