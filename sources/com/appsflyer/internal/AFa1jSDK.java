package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class AFa1jSDK implements SensorEventListener {
    private final long[] AFInAppEventParameterName = new long[2];
    @NonNull
    private final String AFInAppEventType;
    @NonNull
    private final String AFKeystoreWrapper;
    private long AFLogger;
    private double afErrorLog;
    private Executor afInfoLog;
    private final int afRDLog;
    private final float[][] valueOf = new float[2][];
    private final int values;

    AFa1jSDK(Sensor sensor) {
        int type = sensor.getType();
        this.values = type;
        String name = sensor.getName();
        String str = "";
        name = name == null ? str : name;
        this.AFKeystoreWrapper = name;
        String vendor = sensor.getVendor();
        str = vendor != null ? vendor : str;
        this.AFInAppEventType = str;
        this.afRDLog = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
    }

    @NonNull
    private synchronized Executor AFInAppEventType() {
        if (this.afInfoLog == null) {
            this.afInfoLog = Executors.newSingleThreadExecutor();
        }
        return this.afInfoLog;
    }

    private boolean AFKeystoreWrapper(int i10, @NonNull String str, @NonNull String str2) {
        if (this.values != i10 || !this.AFKeystoreWrapper.equals(str) || !this.AFInAppEventType.equals(str2)) {
            return false;
        }
        return true;
    }

    private static double valueOf(@NonNull float[] fArr, @NonNull float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d10 = 0.0d;
        for (int i10 = 0; i10 < min; i10++) {
            d10 += StrictMath.pow((double) (fArr[i10] - fArr2[i10]), 2.0d);
        }
        return Math.sqrt(d10);
    }

    private boolean values() {
        return this.valueOf[0] != null;
    }

    /* access modifiers changed from: package-private */
    public final void AFInAppEventParameterName(@NonNull Map<AFa1jSDK, Map<String, Object>> map, boolean z10) {
        if (values()) {
            map.put(this, valueOf());
            if (z10) {
                int length = this.valueOf.length;
                for (int i10 = 0; i10 < length; i10++) {
                    this.valueOf[i10] = null;
                }
                int length2 = this.AFInAppEventParameterName.length;
                for (int i11 = 0; i11 < length2; i11++) {
                    this.AFInAppEventParameterName[i11] = 0;
                }
                this.afErrorLog = 0.0d;
                this.AFLogger = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, valueOf());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AFa1jSDK)) {
            return false;
        }
        AFa1jSDK aFa1jSDK = (AFa1jSDK) obj;
        return AFKeystoreWrapper(aFa1jSDK.values, aFa1jSDK.AFKeystoreWrapper, aFa1jSDK.AFInAppEventType);
    }

    public final int hashCode() {
        return this.afRDLog;
    }

    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AFInAppEventType().execute(new a(this, sensorEvent));
        } else {
            valueOf(sensorEvent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: AFInAppEventType */
    public void valueOf(SensorEvent sensorEvent) {
        long j10 = sensorEvent.timestamp;
        float[] fArr = sensorEvent.values;
        long currentTimeMillis = System.currentTimeMillis();
        float[][] fArr2 = this.valueOf;
        float[] fArr3 = fArr2[0];
        if (fArr3 == null) {
            fArr2[0] = Arrays.copyOf(fArr, fArr.length);
            this.AFInAppEventParameterName[0] = currentTimeMillis;
            return;
        }
        float[] fArr4 = fArr2[1];
        if (fArr4 == null) {
            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
            this.valueOf[1] = copyOf;
            this.AFInAppEventParameterName[1] = currentTimeMillis;
            this.afErrorLog = valueOf(fArr3, copyOf);
        } else if (50000000 <= j10 - this.AFLogger) {
            this.AFLogger = j10;
            if (Arrays.equals(fArr4, fArr)) {
                this.AFInAppEventParameterName[1] = currentTimeMillis;
                return;
            }
            double valueOf2 = valueOf(fArr3, fArr);
            if (valueOf2 > this.afErrorLog) {
                this.valueOf[1] = Arrays.copyOf(fArr, fArr.length);
                this.AFInAppEventParameterName[1] = currentTimeMillis;
                this.afErrorLog = valueOf2;
            }
        }
    }

    @NonNull
    private static List<Float> valueOf(@NonNull float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf2 : fArr) {
            arrayList.add(Float.valueOf(valueOf2));
        }
        return arrayList;
    }

    @NonNull
    private Map<String, Object> valueOf() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.AFKeystoreWrapper);
        concurrentHashMap.put("sV", this.AFInAppEventType);
        float[] fArr = this.valueOf[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", valueOf(fArr));
        }
        float[] fArr2 = this.valueOf[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", valueOf(fArr2));
        }
        return concurrentHashMap;
    }
}
