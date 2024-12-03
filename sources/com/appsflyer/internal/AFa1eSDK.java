package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AFa1eSDK {
    private static final BitSet afErrorLog;
    private static volatile AFa1eSDK afRDLog;
    final Runnable AFInAppEventParameterName;
    final Runnable AFInAppEventType;
    final Handler AFKeystoreWrapper;
    /* access modifiers changed from: private */
    public final Map<AFa1jSDK, Map<String, Object>> AFLogger;
    /* access modifiers changed from: private */
    public final Runnable AFLogger$LogLevel;
    /* access modifiers changed from: private */
    public boolean AFVersionDeclaration;
    /* access modifiers changed from: private */
    public final Map<AFa1jSDK, AFa1jSDK> afDebugLog;
    /* access modifiers changed from: private */
    public final SensorManager afErrorLogForExcManagerOnly;
    final Runnable afInfoLog;
    /* access modifiers changed from: private */
    public int afWarnLog;
    private long getLevel;
    boolean valueOf;
    final Object values = new Object();

    static {
        BitSet bitSet = new BitSet(6);
        afErrorLog = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private AFa1eSDK(@NonNull SensorManager sensorManager, Handler handler) {
        BitSet bitSet = afErrorLog;
        this.afDebugLog = new HashMap(bitSet.size());
        this.AFLogger = new ConcurrentHashMap(bitSet.size());
        this.AFInAppEventParameterName = new Runnable() {
            public final void run() {
                synchronized (AFa1eSDK.this.values) {
                    AFa1eSDK aFa1eSDK = AFa1eSDK.this;
                    aFa1eSDK.AFKeystoreWrapper.post(new Runnable() {
                        public final void run() {
                            try {
                                for (Sensor next : AFa1eSDK.this.afErrorLogForExcManagerOnly.getSensorList(-1)) {
                                    if (AFa1eSDK.values(next.getType())) {
                                        AFa1jSDK aFa1jSDK = new AFa1jSDK(next);
                                        if (!AFa1eSDK.this.afDebugLog.containsKey(aFa1jSDK)) {
                                            AFa1eSDK.this.afDebugLog.put(aFa1jSDK, aFa1jSDK);
                                        }
                                        AFa1eSDK.this.afErrorLogForExcManagerOnly.registerListener((SensorEventListener) AFa1eSDK.this.afDebugLog.get(aFa1jSDK), next, 0, AFa1eSDK.this.AFKeystoreWrapper);
                                    }
                                }
                            } catch (Throwable th2) {
                                AFLogger.afErrorLogForExcManagerOnly("registerListeners error", th2);
                            }
                            boolean unused = AFa1eSDK.this.AFVersionDeclaration = true;
                        }
                    });
                    AFa1eSDK aFa1eSDK2 = AFa1eSDK.this;
                    aFa1eSDK2.AFKeystoreWrapper.postDelayed(aFa1eSDK2.AFLogger$LogLevel, 100);
                    AFa1eSDK.this.valueOf = true;
                }
            }
        };
        this.AFInAppEventType = new Runnable() {
            public final void run() {
                synchronized (AFa1eSDK.this.values) {
                    AFa1eSDK aFa1eSDK = AFa1eSDK.this;
                    aFa1eSDK.AFKeystoreWrapper.post(new Runnable() {
                        public final void run() {
                            try {
                                if (!AFa1eSDK.this.afDebugLog.isEmpty()) {
                                    for (AFa1jSDK aFa1jSDK : AFa1eSDK.this.afDebugLog.values()) {
                                        AFa1eSDK.this.afErrorLogForExcManagerOnly.unregisterListener(aFa1jSDK);
                                        aFa1jSDK.AFInAppEventParameterName(AFa1eSDK.this.AFLogger, true);
                                    }
                                }
                            } catch (Throwable th2) {
                                AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th2);
                            }
                            int unused = AFa1eSDK.this.afWarnLog = 0;
                            boolean unused2 = AFa1eSDK.this.AFVersionDeclaration = false;
                        }
                    });
                }
            }
        };
        this.afInfoLog = new Runnable() {
            public final void run() {
                synchronized (AFa1eSDK.this.values) {
                    AFa1eSDK aFa1eSDK = AFa1eSDK.this;
                    if (aFa1eSDK.valueOf) {
                        aFa1eSDK.AFKeystoreWrapper.removeCallbacks(aFa1eSDK.AFInAppEventParameterName);
                        AFa1eSDK aFa1eSDK2 = AFa1eSDK.this;
                        aFa1eSDK2.AFKeystoreWrapper.removeCallbacks(aFa1eSDK2.AFInAppEventType);
                        AFa1eSDK aFa1eSDK3 = AFa1eSDK.this;
                        aFa1eSDK3.AFKeystoreWrapper.post(new Runnable() {
                            public final void run() {
                                try {
                                    if (!AFa1eSDK.this.afDebugLog.isEmpty()) {
                                        for (AFa1jSDK aFa1jSDK : AFa1eSDK.this.afDebugLog.values()) {
                                            AFa1eSDK.this.afErrorLogForExcManagerOnly.unregisterListener(aFa1jSDK);
                                            aFa1jSDK.AFInAppEventParameterName(AFa1eSDK.this.AFLogger, true);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th2);
                                }
                                int unused = AFa1eSDK.this.afWarnLog = 0;
                                boolean unused2 = AFa1eSDK.this.AFVersionDeclaration = false;
                            }
                        });
                        AFa1eSDK.this.valueOf = false;
                    }
                }
            }
        };
        this.afWarnLog = 1;
        this.getLevel = 0;
        this.AFLogger$LogLevel = new Runnable() {
            public final void run() {
                synchronized (AFa1eSDK.this.values) {
                    if (AFa1eSDK.this.afWarnLog == 0) {
                        int unused = AFa1eSDK.this.afWarnLog = 1;
                    }
                    AFa1eSDK aFa1eSDK = AFa1eSDK.this;
                    aFa1eSDK.AFKeystoreWrapper.postDelayed(aFa1eSDK.AFInAppEventType, ((long) aFa1eSDK.afWarnLog) * 500);
                }
            }
        };
        this.afErrorLogForExcManagerOnly = sensorManager;
        this.AFKeystoreWrapper = handler;
    }

    /* access modifiers changed from: private */
    public static boolean values(int i10) {
        return i10 >= 0 && afErrorLog.get(i10);
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Object> AFInAppEventParameterName() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<Map<String, Object>> AFInAppEventType2 = AFInAppEventType();
        if (!AFInAppEventType2.isEmpty()) {
            concurrentHashMap.put("sensors", AFInAppEventType2);
        } else {
            List<Map<String, Object>> values2 = values();
            if (!values2.isEmpty()) {
                concurrentHashMap.put("sensors", values2);
            }
        }
        return concurrentHashMap;
    }

    @NonNull
    private List<Map<String, Object>> AFInAppEventType() {
        synchronized (this.values) {
            if (!this.afDebugLog.isEmpty() && this.AFVersionDeclaration) {
                for (AFa1jSDK AFInAppEventParameterName2 : this.afDebugLog.values()) {
                    AFInAppEventParameterName2.AFInAppEventParameterName(this.AFLogger, false);
                }
            }
            if (this.AFLogger.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.AFLogger.values());
            return copyOnWriteArrayList2;
        }
    }

    static AFa1eSDK valueOf(Context context) {
        if (afRDLog != null) {
            return afRDLog;
        }
        HandlerThread handlerThread = new HandlerThread("internal");
        handlerThread.start();
        return valueOf((SensorManager) context.getApplicationContext().getSystemService("sensor"), new Handler(handlerThread.getLooper()));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void AFKeystoreWrapper() {
        this.AFKeystoreWrapper.post(this.afInfoLog);
    }

    /* access modifiers changed from: package-private */
    public final List<Map<String, Object>> values() {
        for (AFa1jSDK AFInAppEventParameterName2 : this.afDebugLog.values()) {
            AFInAppEventParameterName2.AFInAppEventParameterName(this.AFLogger, true);
        }
        Map<AFa1jSDK, Map<String, Object>> map = this.AFLogger;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.AFLogger.values());
    }

    private static AFa1eSDK valueOf(SensorManager sensorManager, Handler handler) {
        if (afRDLog == null) {
            synchronized (AFa1eSDK.class) {
                if (afRDLog == null) {
                    afRDLog = new AFa1eSDK(sensorManager, handler);
                }
            }
        }
        return afRDLog;
    }
}
