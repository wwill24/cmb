package siftscience.android;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.d;
import com.google.gson.e;
import com.leanplum.internal.Constants;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lg.c;

public final class Sift {
    static final d GSON = new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b();
    static final String SDK_VERSION = "1.3.0";
    /* access modifiers changed from: private */
    public static final String TAG = "siftscience.android.Sift";
    /* access modifiers changed from: private */
    public static volatile AppStateCollector appStateCollector;
    /* access modifiers changed from: private */
    public static volatile DevicePropertiesCollector devicePropertiesCollector;
    private static volatile ExecutorService executors;
    private static volatile boolean hasUnboundUserId = false;
    private static volatile SiftImpl instance;
    private static volatile String unboundUserId;

    public static class Config {
        private static final String DEFAULT_SERVER_URL_FORMAT = "https://api3.siftscience.com/v3/accounts/%s/mobile_events";
        @c(alternate = {"accountId"}, value = "account_id")
        public final String accountId;
        @c(alternate = {"beaconKey"}, value = "beacon_key")
        public final String beaconKey;
        @c(alternate = {"disallowLocationCollection"}, value = "disallow_location_collection")
        public final boolean disallowLocationCollection;
        @c(alternate = {"serverUrlFormat"}, value = "server_url_format")
        public final String serverUrlFormat;

        public boolean equals(Object obj) {
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            if (!Utils.equals(this.accountId, config.accountId) || !Utils.equals(this.beaconKey, config.beaconKey) || !Utils.equals(this.serverUrlFormat, config.serverUrlFormat) || !Utils.equals(Boolean.valueOf(this.disallowLocationCollection), Boolean.valueOf(config.disallowLocationCollection))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isValid() {
            boolean z10;
            ArrayList arrayList = new ArrayList();
            String str = this.accountId;
            if (str == null || str.isEmpty()) {
                arrayList.add(Constants.Params.CT_ACCOUNT_ID);
            }
            String str2 = this.beaconKey;
            if (str2 == null || str2.isEmpty()) {
                arrayList.add("beacon key");
            }
            String str3 = this.serverUrlFormat;
            if (str3 == null || str3.isEmpty()) {
                arrayList.add("server URL format");
            }
            if (arrayList.size() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                String unused = Sift.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The following configuration properties are missing or empty: ");
                sb2.append(TextUtils.join(AppsFlyerKit.COMMA, arrayList));
            }
            return z10;
        }

        public static class Builder {
            private String accountId;
            private String beaconKey;
            private boolean disallowLocationCollection;
            private String serverUrlFormat;

            public Builder() {
                this.serverUrlFormat = Config.DEFAULT_SERVER_URL_FORMAT;
            }

            public Config build() {
                return new Config(this.accountId, this.beaconKey, this.serverUrlFormat, this.disallowLocationCollection);
            }

            public Builder withAccountId(String str) {
                this.accountId = str;
                return this;
            }

            public Builder withBeaconKey(String str) {
                this.beaconKey = str;
                return this;
            }

            public Builder withDisallowLocationCollection(boolean z10) {
                this.disallowLocationCollection = z10;
                return this;
            }

            public Builder withServerUrlFormat(String str) {
                this.serverUrlFormat = str;
                return this;
            }

            public Builder(Config config) {
                this.accountId = config.accountId;
                this.beaconKey = config.beaconKey;
                this.serverUrlFormat = config.serverUrlFormat;
                this.disallowLocationCollection = config.disallowLocationCollection;
            }
        }

        Config() {
            this((String) null, (String) null, DEFAULT_SERVER_URL_FORMAT, false);
        }

        private Config(String str, String str2, String str3, boolean z10) {
            this.accountId = str;
            this.beaconKey = str2;
            this.serverUrlFormat = str3;
            this.disallowLocationCollection = z10;
        }
    }

    private Sift() {
    }

    public static void close() {
        if (executors != null && !executors.isShutdown()) {
            executors.shutdown();
            try {
                executors.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
        }
    }

    public static void collect() {
        if (executors == null || (executors != null && executors.isShutdown())) {
            executors = Executors.newSingleThreadScheduledExecutor();
        }
        executors.submit(new Runnable() {
            public void run() {
                Sift.appStateCollector.collect();
                Sift.devicePropertiesCollector.collect();
            }
        });
    }

    public static void open(@NonNull Context context, Config config, String str) {
        synchronized (Sift.class) {
            if (instance == null) {
                Context applicationContext = context.getApplicationContext();
                instance = new SiftImpl(applicationContext, config, unboundUserId, hasUnboundUserId);
                devicePropertiesCollector = new DevicePropertiesCollector(instance, applicationContext);
                appStateCollector = new AppStateCollector(instance, applicationContext);
                unboundUserId = null;
                hasUnboundUserId = false;
            } else if (config != null) {
                instance.setConfig(config);
            }
        }
        AppStateCollector appStateCollector2 = appStateCollector;
        if (str == null) {
            str = context.getClass().getSimpleName();
        }
        appStateCollector2.setActivityName(str);
    }

    public static void pause() {
        SiftImpl siftImpl = instance;
        if (siftImpl != null) {
            siftImpl.save();
        }
        AppStateCollector appStateCollector2 = appStateCollector;
        if (appStateCollector2 != null) {
            appStateCollector2.disconnectLocationServices();
        }
    }

    public static void resume(@NonNull Context context) {
        resume(context, (String) null);
    }

    public static synchronized void setUserId(String str) {
        synchronized (Sift.class) {
            if (instance != null) {
                instance.setUserId(str);
            } else {
                unboundUserId = str;
                hasUnboundUserId = true;
            }
        }
    }

    public static synchronized void unsetUserId() {
        synchronized (Sift.class) {
            setUserId((String) null);
        }
    }

    public static void upload() {
        if (instance != null) {
            instance.forceUploadAppStateEvent();
            instance.forceUploadDevicePropertiesEvent();
        }
    }

    public static void resume(@NonNull Context context, String str) {
        AppStateCollector appStateCollector2 = appStateCollector;
        if (appStateCollector2 != null) {
            appStateCollector2.reconnectLocationServices();
            if (str == null) {
                str = context.getClass().getSimpleName();
            }
            appStateCollector2.setActivityName(str);
        }
    }

    public static void open(@NonNull Context context, String str) {
        open(context, (Config) null, str);
    }

    public static void open(@NonNull Context context, Config config) {
        open(context, config, (String) null);
    }

    public static void open(@NonNull Context context) {
        open(context, (Config) null, (String) null);
    }
}
