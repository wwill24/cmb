package com.google.mlkit.common.sdkinternal;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import java.util.UUID;
import tg.b;

public class m {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final Component<?> f21439b = Component.builder(m.class).add(Dependency.required((Class<?>) i.class)).add(Dependency.required((Class<?>) Context.class)).factory(d0.f21398a).build();

    /* renamed from: a  reason: collision with root package name */
    private final Context f21440a;

    public m(@NonNull Context context) {
        this.f21440a = context;
    }

    private final SharedPreferences e() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.f21440a.getSystemService("device_policy");
        if (devicePolicyManager == null) {
            return this.f21440a.getSharedPreferences("com.google.mlkit.internal", 0);
        }
        int storageEncryptionStatus = devicePolicyManager.getStorageEncryptionStatus();
        if (storageEncryptionStatus != 3 && storageEncryptionStatus != 5) {
            return this.f21440a.getSharedPreferences("com.google.mlkit.internal", 0);
        }
        Context createDeviceProtectedStorageContext = this.f21440a.createDeviceProtectedStorageContext();
        createDeviceProtectedStorageContext.moveSharedPreferencesFrom(this.f21440a, "com.google.mlkit.internal");
        return createDeviceProtectedStorageContext.getSharedPreferences("com.google.mlkit.internal", 0);
    }

    @NonNull
    public synchronized String a() {
        String string = e().getString("ml_sdk_instance_id", (String) null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        e().edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }

    public synchronized long b(@NonNull b bVar) {
        return e().getLong(String.format("downloading_begin_time_%s", new Object[]{bVar.d()}), 0);
    }

    public synchronized long c(@NonNull b bVar) {
        return e().getLong(String.format("model_first_use_time_%s", new Object[]{bVar.d()}), 0);
    }

    public synchronized void d(@NonNull b bVar, long j10) {
        e().edit().putLong(String.format("model_first_use_time_%s", new Object[]{bVar.d()}), j10).apply();
    }
}
