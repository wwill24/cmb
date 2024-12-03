package com.clevertap.android.sdk.pushnotification;

import androidx.annotation.NonNull;
import com.clevertap.android.sdk.p;
import com.google.firebase.messaging.Constants;

public interface PushConstants {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10708a = PushType.FCM.toString();

    public enum PushType {
        FCM(Constants.ScionAnalytics.ORIGIN_FCM, "fcm_token", "com.clevertap.android.sdk.pushnotification.fcm.FcmPushProvider", "com.google.firebase.messaging.FirebaseMessagingService", 1, ""),
        XPS("xps", "xps_token", "com.clevertap.android.xps.XiaomiPushProvider", "com.xiaomi.mipush.sdk.MiPushClient", 1, ""),
        HPS("hps", "hps_token", "com.clevertap.android.hms.HmsPushProvider", "com.huawei.hms.push.HmsMessageService", 1, ""),
        BPS("bps", "bps_token", "com.clevertap.android.bps.BaiduPushProvider", "com.baidu.android.pushservice.PushMessageReceiver", 1, ""),
        ADM("adm", "adm_token", "com.clevertap.android.adm.AmazonPushProvider", "com.amazon.device.messaging.ADM", 1, "");
        
        private final String ctProviderClassName;
        private final String messagingSDKClassName;
        private int runningDevices;
        private String serverRegion;
        private final String tokenPrefKey;
        private final String type;

        private PushType(String str, String str2, String str3, String str4, int i10, String str5) {
            this.type = str;
            this.tokenPrefKey = str2;
            this.ctProviderClassName = str3;
            this.messagingSDKClassName = str4;
            this.runningDevices = i10;
            this.serverRegion = str5;
        }

        public String a() {
            return this.ctProviderClassName;
        }

        public String b() {
            return this.messagingSDKClassName;
        }

        public int c() {
            return this.runningDevices;
        }

        public String d() {
            p.o("PushConstants: getServerRegion called, returning region:" + this.serverRegion);
            return this.serverRegion;
        }

        public String e() {
            return this.tokenPrefKey;
        }

        public String h() {
            return this.type;
        }

        @NonNull
        public String toString() {
            return " [PushType:" + name() + "] ";
        }
    }
}
