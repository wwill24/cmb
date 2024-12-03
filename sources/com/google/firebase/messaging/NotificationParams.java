package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONException;
import org.json.a;

public class NotificationParams {
    private static final int COLOR_TRANSPARENT_IN_HEX = -16777216;
    private static final int EMPTY_JSON_ARRAY_LENGTH = 1;
    private static final String TAG = "NotificationParams";
    private static final int VISIBILITY_MAX = 1;
    private static final int VISIBILITY_MIN = -1;
    @NonNull
    private final Bundle data;

    public NotificationParams(@NonNull Bundle bundle) {
        if (bundle != null) {
            this.data = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    private static int getLightColor(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != COLOR_TRANSPARENT_IN_HEX) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean isAnalyticsKey(String str) {
        return str.startsWith(Constants.AnalyticsKeys.PREFIX) || str.equals("from");
    }

    private static boolean isReservedKey(String str) {
        if (str.startsWith(Constants.MessagePayloadKeys.RESERVED_CLIENT_LIB_PREFIX) || str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) || str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD)) {
            return true;
        }
        return false;
    }

    private static String keyWithOldPrefix(String str) {
        if (!str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            return str;
        }
        return str.replace(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX, Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD);
    }

    private String normalizePrefix(String str) {
        if (!this.data.containsKey(str) && str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            String keyWithOldPrefix = keyWithOldPrefix(str);
            if (this.data.containsKey(keyWithOldPrefix)) {
                return keyWithOldPrefix;
            }
        }
        return str;
    }

    private static String userFriendlyKey(String str) {
        if (str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            return str.substring(6);
        }
        return str;
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(string) || Boolean.parseBoolean(string)) {
            return true;
        }
        return false;
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't parse value of ");
            sb2.append(userFriendlyKey(str));
            sb2.append("(");
            sb2.append(string);
            sb2.append(") into an int");
            return null;
        }
    }

    public a getJSONArray(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new a(string);
        } catch (JSONException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Malformed JSON for key ");
            sb2.append(userFriendlyKey(str));
            sb2.append(": ");
            sb2.append(string);
            sb2.append(", falling back to default");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int[] getLightSettings() {
        a jSONArray = getJSONArray(Constants.MessageNotificationKeys.LIGHT_SETTINGS);
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArray.o() == 3) {
                iArr[0] = getLightColor(jSONArray.w(0));
                iArr[1] = jSONArray.q(1);
                iArr[2] = jSONArray.q(2);
                return iArr;
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("LightSettings is invalid: ");
            sb2.append(jSONArray);
            sb2.append(". Skipping setting LightSettings");
            return null;
        } catch (IllegalArgumentException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("LightSettings is invalid: ");
            sb3.append(jSONArray);
            sb3.append(". ");
            sb3.append(e10.getMessage());
            sb3.append(". Skipping setting LightSettings");
            return null;
        }
    }

    public Uri getLink() {
        String string = getString(Constants.MessageNotificationKeys.LINK_ANDROID);
        if (TextUtils.isEmpty(string)) {
            string = getString(Constants.MessageNotificationKeys.LINK);
        }
        if (!TextUtils.isEmpty(string)) {
            return Uri.parse(string);
        }
        return null;
    }

    public Object[] getLocalizationArgsForKey(String str) {
        a jSONArray = getJSONArray(str + Constants.MessageNotificationKeys.TEXT_ARGS_SUFFIX);
        if (jSONArray == null) {
            return null;
        }
        int o10 = jSONArray.o();
        String[] strArr = new String[o10];
        for (int i10 = 0; i10 < o10; i10++) {
            strArr[i10] = jSONArray.w(i10);
        }
        return strArr;
    }

    public String getLocalizationResourceForKey(String str) {
        return getString(str + Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX);
    }

    public String getLocalizedString(Resources resources, String str, String str2) {
        String localizationResourceForKey = getLocalizationResourceForKey(str2);
        if (TextUtils.isEmpty(localizationResourceForKey)) {
            return null;
        }
        int identifier = resources.getIdentifier(localizationResourceForKey, "string", str);
        if (identifier == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userFriendlyKey(str2 + Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX));
            sb2.append(" resource not found: ");
            sb2.append(str2);
            sb2.append(" Default value will be used.");
            return null;
        }
        Object[] localizationArgsForKey = getLocalizationArgsForKey(str2);
        if (localizationArgsForKey == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, localizationArgsForKey);
        } catch (MissingFormatArgumentException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing format argument for ");
            sb3.append(userFriendlyKey(str2));
            sb3.append(": ");
            sb3.append(Arrays.toString(localizationArgsForKey));
            sb3.append(" Default value will be used.");
            return null;
        }
    }

    public Long getLong(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(string));
        } catch (NumberFormatException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't parse value of ");
            sb2.append(userFriendlyKey(str));
            sb2.append("(");
            sb2.append(string);
            sb2.append(") into a long");
            return null;
        }
    }

    public String getNotificationChannelId() {
        return getString(Constants.MessageNotificationKeys.CHANNEL);
    }

    /* access modifiers changed from: package-private */
    public Integer getNotificationCount() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_COUNT);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= 0) {
            return integer;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notificationCount is invalid: ");
        sb2.append(integer);
        sb2.append(". Skipping setting notificationCount.");
        return null;
    }

    /* access modifiers changed from: package-private */
    public Integer getNotificationPriority() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_PRIORITY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= -2 && integer.intValue() <= 2) {
            return integer;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notificationPriority is invalid ");
        sb2.append(integer);
        sb2.append(". Skipping setting notificationPriority.");
        return null;
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String string = getString(str2);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return getLocalizedString(resources, str, str2);
    }

    public String getSoundResourceName() {
        String string = getString(Constants.MessageNotificationKeys.SOUND_2);
        if (TextUtils.isEmpty(string)) {
            return getString(Constants.MessageNotificationKeys.SOUND);
        }
        return string;
    }

    public String getString(String str) {
        return this.data.getString(normalizePrefix(str));
    }

    public long[] getVibrateTimings() {
        a jSONArray = getJSONArray(Constants.MessageNotificationKeys.VIBRATE_TIMINGS);
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.o() > 1) {
                int o10 = jSONArray.o();
                long[] jArr = new long[o10];
                for (int i10 = 0; i10 < o10; i10++) {
                    jArr[i10] = jSONArray.t(i10);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("User defined vibrateTimings is invalid: ");
            sb2.append(jSONArray);
            sb2.append(". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Integer getVisibility() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.VISIBILITY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= -1 && integer.intValue() <= 1) {
            return integer;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("visibility is invalid: ");
        sb2.append(integer);
        sb2.append(". Skipping setting visibility.");
        return null;
    }

    public boolean hasImage() {
        return !TextUtils.isEmpty(getString(Constants.MessageNotificationKeys.IMAGE_URL));
    }

    public boolean isNotification() {
        return getBoolean(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION);
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = new Bundle(this.data);
        for (String next : this.data.keySet()) {
            if (!isAnalyticsKey(next)) {
                bundle.remove(next);
            }
        }
        return bundle;
    }

    public Bundle paramsWithReservedKeysRemoved() {
        Bundle bundle = new Bundle(this.data);
        for (String next : this.data.keySet()) {
            if (isReservedKey(next)) {
                bundle.remove(next);
            }
        }
        return bundle;
    }

    public static boolean isNotification(Bundle bundle) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)) || AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString(keyWithOldPrefix(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)));
    }
}
