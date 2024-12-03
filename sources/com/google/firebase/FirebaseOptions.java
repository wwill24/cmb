package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;

public final class FirebaseOptions {
    private static final String API_KEY_RESOURCE_NAME = "google_api_key";
    private static final String APP_ID_RESOURCE_NAME = "google_app_id";
    private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
    private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
    private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
    private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
    private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
    /* access modifiers changed from: private */
    public final String apiKey;
    /* access modifiers changed from: private */
    public final String applicationId;
    /* access modifiers changed from: private */
    public final String databaseUrl;
    /* access modifiers changed from: private */
    public final String gaTrackingId;
    /* access modifiers changed from: private */
    public final String gcmSenderId;
    /* access modifiers changed from: private */
    public final String projectId;
    /* access modifiers changed from: private */
    public final String storageBucket;

    public static final class Builder {
        private String apiKey;
        private String applicationId;
        private String databaseUrl;
        private String gaTrackingId;
        private String gcmSenderId;
        private String projectId;
        private String storageBucket;

        public Builder() {
        }

        public Builder(@NonNull FirebaseOptions firebaseOptions) {
            this.applicationId = firebaseOptions.applicationId;
            this.apiKey = firebaseOptions.apiKey;
            this.databaseUrl = firebaseOptions.databaseUrl;
            this.gaTrackingId = firebaseOptions.gaTrackingId;
            this.gcmSenderId = firebaseOptions.gcmSenderId;
            this.storageBucket = firebaseOptions.storageBucket;
            this.projectId = firebaseOptions.projectId;
        }

        @NonNull
        public FirebaseOptions build() {
            return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
        }

        @NonNull
        public Builder setApiKey(@NonNull String str) {
            this.apiKey = p.h(str, "ApiKey must be set.");
            return this;
        }

        @NonNull
        public Builder setApplicationId(@NonNull String str) {
            this.applicationId = p.h(str, "ApplicationId must be set.");
            return this;
        }

        @NonNull
        public Builder setDatabaseUrl(String str) {
            this.databaseUrl = str;
            return this;
        }

        @NonNull
        public Builder setGaTrackingId(String str) {
            this.gaTrackingId = str;
            return this;
        }

        @NonNull
        public Builder setGcmSenderId(String str) {
            this.gcmSenderId = str;
            return this;
        }

        @NonNull
        public Builder setProjectId(String str) {
            this.projectId = str;
            return this;
        }

        @NonNull
        public Builder setStorageBucket(String str) {
            this.storageBucket = str;
            return this;
        }
    }

    public static FirebaseOptions fromResource(@NonNull Context context) {
        r rVar = new r(context);
        String a10 = rVar.a(APP_ID_RESOURCE_NAME);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        return new FirebaseOptions(a10, rVar.a(API_KEY_RESOURCE_NAME), rVar.a(DATABASE_URL_RESOURCE_NAME), rVar.a(GA_TRACKING_ID_RESOURCE_NAME), rVar.a(GCM_SENDER_ID_RESOURCE_NAME), rVar.a(STORAGE_BUCKET_RESOURCE_NAME), rVar.a(PROJECT_ID_RESOURCE_NAME));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        if (!n.b(this.applicationId, firebaseOptions.applicationId) || !n.b(this.apiKey, firebaseOptions.apiKey) || !n.b(this.databaseUrl, firebaseOptions.databaseUrl) || !n.b(this.gaTrackingId, firebaseOptions.gaTrackingId) || !n.b(this.gcmSenderId, firebaseOptions.gcmSenderId) || !n.b(this.storageBucket, firebaseOptions.storageBucket) || !n.b(this.projectId, firebaseOptions.projectId)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getApiKey() {
        return this.apiKey;
    }

    @NonNull
    public String getApplicationId() {
        return this.applicationId;
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getGaTrackingId() {
        return this.gaTrackingId;
    }

    public String getGcmSenderId() {
        return this.gcmSenderId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getStorageBucket() {
        return this.storageBucket;
    }

    public int hashCode() {
        return n.c(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
    }

    public String toString() {
        return n.d(this).a("applicationId", this.applicationId).a("apiKey", this.apiKey).a("databaseUrl", this.databaseUrl).a("gcmSenderId", this.gcmSenderId).a("storageBucket", this.storageBucket).a("projectId", this.projectId).toString();
    }

    private FirebaseOptions(@NonNull String str, @NonNull String str2, String str3, String str4, String str5, String str6, String str7) {
        p.p(!me.r.b(str), "ApplicationId must be set.");
        this.applicationId = str;
        this.apiKey = str2;
        this.databaseUrl = str3;
        this.gaTrackingId = str4;
        this.gcmSenderId = str5;
        this.storageBucket = str6;
        this.projectId = str7;
    }
}
