package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.messaging.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    Bundle bundle;
    private Map<String, String> data;
    private Notification notification;

    public static class Builder {
        private final Bundle bundle;
        private final Map<String, String> data = new a();

        public Builder(@NonNull String str) {
            Bundle bundle2 = new Bundle();
            this.bundle = bundle2;
            if (!TextUtils.isEmpty(str)) {
                bundle2.putString(Constants.MessagePayloadKeys.TO, str);
                return;
            }
            throw new IllegalArgumentException("Invalid to: " + str);
        }

        @NonNull
        public Builder addData(@NonNull String str, String str2) {
            this.data.put(str, str2);
            return this;
        }

        @NonNull
        public RemoteMessage build() {
            Bundle bundle2 = new Bundle();
            for (Map.Entry next : this.data.entrySet()) {
                bundle2.putString((String) next.getKey(), (String) next.getValue());
            }
            bundle2.putAll(this.bundle);
            this.bundle.remove("from");
            return new RemoteMessage(bundle2);
        }

        @NonNull
        public Builder clearData() {
            this.data.clear();
            return this;
        }

        public String getCollapseKey() {
            return this.bundle.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE);
        }

        @NonNull
        public Map<String, String> getData() {
            return this.data;
        }

        @NonNull
        public String getMessageId() {
            return this.bundle.getString(Constants.MessagePayloadKeys.MSGID, "");
        }

        public String getMessageType() {
            return this.bundle.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE);
        }

        public int getTtl() {
            return Integer.parseInt(this.bundle.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE, "0"));
        }

        @NonNull
        public Builder setCollapseKey(String str) {
            this.bundle.putString(Constants.MessagePayloadKeys.COLLAPSE_KEY, str);
            return this;
        }

        @NonNull
        public Builder setData(@NonNull Map<String, String> map) {
            this.data.clear();
            this.data.putAll(map);
            return this;
        }

        @NonNull
        public Builder setMessageId(@NonNull String str) {
            this.bundle.putString(Constants.MessagePayloadKeys.MSGID, str);
            return this;
        }

        @NonNull
        public Builder setMessageType(String str) {
            this.bundle.putString(Constants.MessagePayloadKeys.MESSAGE_TYPE, str);
            return this;
        }

        @NonNull
        public Builder setRawData(byte[] bArr) {
            this.bundle.putByteArray(Constants.MessagePayloadKeys.RAW_DATA, bArr);
            return this;
        }

        @NonNull
        public Builder setTtl(int i10) {
            this.bundle.putString(Constants.MessagePayloadKeys.TTL, String.valueOf(i10));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification {
        private final String body;
        private final String[] bodyLocArgs;
        private final String bodyLocKey;
        private final String channelId;
        private final String clickAction;
        private final String color;
        private final boolean defaultLightSettings;
        private final boolean defaultSound;
        private final boolean defaultVibrateTimings;
        private final Long eventTime;
        private final String icon;
        private final String imageUrl;
        private final int[] lightSettings;
        private final Uri link;
        private final boolean localOnly;
        private final Integer notificationCount;
        private final Integer notificationPriority;
        private final String sound;
        private final boolean sticky;
        private final String tag;
        private final String ticker;
        private final String title;
        private final String[] titleLocArgs;
        private final String titleLocKey;
        private final long[] vibrateTimings;
        private final Integer visibility;

        private static String[] getLocalizationArgs(NotificationParams notificationParams, String str) {
            Object[] localizationArgsForKey = notificationParams.getLocalizationArgsForKey(str);
            if (localizationArgsForKey == null) {
                return null;
            }
            String[] strArr = new String[localizationArgsForKey.length];
            for (int i10 = 0; i10 < localizationArgsForKey.length; i10++) {
                strArr[i10] = String.valueOf(localizationArgsForKey[i10]);
            }
            return strArr;
        }

        public String getBody() {
            return this.body;
        }

        public String[] getBodyLocalizationArgs() {
            return this.bodyLocArgs;
        }

        public String getBodyLocalizationKey() {
            return this.bodyLocKey;
        }

        public String getChannelId() {
            return this.channelId;
        }

        public String getClickAction() {
            return this.clickAction;
        }

        public String getColor() {
            return this.color;
        }

        public boolean getDefaultLightSettings() {
            return this.defaultLightSettings;
        }

        public boolean getDefaultSound() {
            return this.defaultSound;
        }

        public boolean getDefaultVibrateSettings() {
            return this.defaultVibrateTimings;
        }

        public Long getEventTime() {
            return this.eventTime;
        }

        public String getIcon() {
            return this.icon;
        }

        public Uri getImageUrl() {
            String str = this.imageUrl;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        public int[] getLightSettings() {
            return this.lightSettings;
        }

        public Uri getLink() {
            return this.link;
        }

        public boolean getLocalOnly() {
            return this.localOnly;
        }

        public Integer getNotificationCount() {
            return this.notificationCount;
        }

        public Integer getNotificationPriority() {
            return this.notificationPriority;
        }

        public String getSound() {
            return this.sound;
        }

        public boolean getSticky() {
            return this.sticky;
        }

        public String getTag() {
            return this.tag;
        }

        public String getTicker() {
            return this.ticker;
        }

        public String getTitle() {
            return this.title;
        }

        public String[] getTitleLocalizationArgs() {
            return this.titleLocArgs;
        }

        public String getTitleLocalizationKey() {
            return this.titleLocKey;
        }

        public long[] getVibrateTimings() {
            return this.vibrateTimings;
        }

        public Integer getVisibility() {
            return this.visibility;
        }

        private Notification(NotificationParams notificationParams) {
            this.title = notificationParams.getString(Constants.MessageNotificationKeys.TITLE);
            this.titleLocKey = notificationParams.getLocalizationResourceForKey(Constants.MessageNotificationKeys.TITLE);
            this.titleLocArgs = getLocalizationArgs(notificationParams, Constants.MessageNotificationKeys.TITLE);
            this.body = notificationParams.getString(Constants.MessageNotificationKeys.BODY);
            this.bodyLocKey = notificationParams.getLocalizationResourceForKey(Constants.MessageNotificationKeys.BODY);
            this.bodyLocArgs = getLocalizationArgs(notificationParams, Constants.MessageNotificationKeys.BODY);
            this.icon = notificationParams.getString(Constants.MessageNotificationKeys.ICON);
            this.sound = notificationParams.getSoundResourceName();
            this.tag = notificationParams.getString(Constants.MessageNotificationKeys.TAG);
            this.color = notificationParams.getString(Constants.MessageNotificationKeys.COLOR);
            this.clickAction = notificationParams.getString(Constants.MessageNotificationKeys.CLICK_ACTION);
            this.channelId = notificationParams.getString(Constants.MessageNotificationKeys.CHANNEL);
            this.link = notificationParams.getLink();
            this.imageUrl = notificationParams.getString(Constants.MessageNotificationKeys.IMAGE_URL);
            this.ticker = notificationParams.getString(Constants.MessageNotificationKeys.TICKER);
            this.notificationPriority = notificationParams.getInteger(Constants.MessageNotificationKeys.NOTIFICATION_PRIORITY);
            this.visibility = notificationParams.getInteger(Constants.MessageNotificationKeys.VISIBILITY);
            this.notificationCount = notificationParams.getInteger(Constants.MessageNotificationKeys.NOTIFICATION_COUNT);
            this.sticky = notificationParams.getBoolean(Constants.MessageNotificationKeys.STICKY);
            this.localOnly = notificationParams.getBoolean(Constants.MessageNotificationKeys.LOCAL_ONLY);
            this.defaultSound = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_SOUND);
            this.defaultVibrateTimings = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_VIBRATE_TIMINGS);
            this.defaultLightSettings = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_LIGHT_SETTINGS);
            this.eventTime = notificationParams.getLong(Constants.MessageNotificationKeys.EVENT_TIME);
            this.lightSettings = notificationParams.getLightSettings();
            this.vibrateTimings = notificationParams.getVibrateTimings();
        }
    }

    public RemoteMessage(Bundle bundle2) {
        this.bundle = bundle2;
    }

    private int getMessagePriority(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        if ("normal".equals(str)) {
            return 2;
        }
        return 0;
    }

    public String getCollapseKey() {
        return this.bundle.getString(Constants.MessagePayloadKeys.COLLAPSE_KEY);
    }

    @NonNull
    public Map<String, String> getData() {
        if (this.data == null) {
            this.data = Constants.MessagePayloadKeys.extractDeveloperDefinedPayload(this.bundle);
        }
        return this.data;
    }

    public String getFrom() {
        return this.bundle.getString("from");
    }

    public String getMessageId() {
        String string = this.bundle.getString(Constants.MessagePayloadKeys.MSGID);
        if (string == null) {
            return this.bundle.getString(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        return string;
    }

    public String getMessageType() {
        return this.bundle.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE);
    }

    public Notification getNotification() {
        if (this.notification == null && NotificationParams.isNotification(this.bundle)) {
            this.notification = new Notification(new NotificationParams(this.bundle));
        }
        return this.notification;
    }

    public int getOriginalPriority() {
        String string = this.bundle.getString(Constants.MessagePayloadKeys.ORIGINAL_PRIORITY);
        if (string == null) {
            string = this.bundle.getString(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return getMessagePriority(string);
    }

    public int getPriority() {
        String string = this.bundle.getString(Constants.MessagePayloadKeys.DELIVERED_PRIORITY);
        if (string == null) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.bundle.getString(Constants.MessagePayloadKeys.PRIORITY_REDUCED_V19))) {
                return 2;
            }
            string = this.bundle.getString(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return getMessagePriority(string);
    }

    public byte[] getRawData() {
        return this.bundle.getByteArray(Constants.MessagePayloadKeys.RAW_DATA);
    }

    public String getSenderId() {
        return this.bundle.getString(Constants.MessagePayloadKeys.SENDER_ID);
    }

    public long getSentTime() {
        Object obj = this.bundle.get(Constants.MessagePayloadKeys.SENT_TIME);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid sent time: ");
            sb2.append(obj);
            return 0;
        }
    }

    public String getTo() {
        return this.bundle.getString(Constants.MessagePayloadKeys.TO);
    }

    public int getTtl() {
        Object obj = this.bundle.get(Constants.MessagePayloadKeys.TTL);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid TTL: ");
            sb2.append(obj);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void populateSendMessageIntent(Intent intent) {
        intent.putExtras(this.bundle);
    }

    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.bundle);
        return intent;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        RemoteMessageCreator.writeToParcel(this, parcel, i10);
    }
}
