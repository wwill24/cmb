package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigStorageClient {
    private static final String JSON_STRING_ENCODING = "UTF-8";
    private static final Map<String, ConfigStorageClient> clientInstances = new HashMap();
    private final Context context;
    private final String fileName;

    private ConfigStorageClient(Context context2, String str) {
        this.context = context2;
        this.fileName = str;
    }

    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigStorageClient.class) {
            clientInstances.clear();
        }
    }

    public static synchronized ConfigStorageClient getInstance(Context context2, String str) {
        ConfigStorageClient configStorageClient;
        synchronized (ConfigStorageClient.class) {
            Map<String, ConfigStorageClient> map = clientInstances;
            if (!map.containsKey(str)) {
                map.put(str, new ConfigStorageClient(context2, str));
            }
            configStorageClient = map.get(str);
        }
        return configStorageClient;
    }

    public synchronized Void clear() {
        this.context.deleteFile(this.fileName);
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getFileName() {
        return this.fileName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[SYNTHETIC, Splitter:B:14:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[Catch:{ FileNotFoundException | JSONException -> 0x0035, all -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.firebase.remoteconfig.internal.ConfigContainer read() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            android.content.Context r1 = r6.context     // Catch:{ FileNotFoundException | JSONException -> 0x0035, all -> 0x002b }
            java.lang.String r2 = r6.fileName     // Catch:{ FileNotFoundException | JSONException -> 0x0035, all -> 0x002b }
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ FileNotFoundException | JSONException -> 0x0035, all -> 0x002b }
            int r2 = r1.available()     // Catch:{ FileNotFoundException | JSONException -> 0x0036, all -> 0x0029 }
            byte[] r3 = new byte[r2]     // Catch:{ FileNotFoundException | JSONException -> 0x0036, all -> 0x0029 }
            r4 = 0
            r1.read(r3, r4, r2)     // Catch:{ FileNotFoundException | JSONException -> 0x0036, all -> 0x0029 }
            java.lang.String r2 = new java.lang.String     // Catch:{ FileNotFoundException | JSONException -> 0x0036, all -> 0x0029 }
            java.lang.String r4 = "UTF-8"
            r2.<init>(r3, r4)     // Catch:{ FileNotFoundException | JSONException -> 0x0036, all -> 0x0029 }
            org.json.b r3 = new org.json.b     // Catch:{ FileNotFoundException | JSONException -> 0x0036, all -> 0x0029 }
            r3.<init>((java.lang.String) r2)     // Catch:{ FileNotFoundException | JSONException -> 0x0036, all -> 0x0029 }
            com.google.firebase.remoteconfig.internal.ConfigContainer r0 = com.google.firebase.remoteconfig.internal.ConfigContainer.copyOf(r3)     // Catch:{ FileNotFoundException | JSONException -> 0x0036, all -> 0x0029 }
            r1.close()     // Catch:{ all -> 0x003c }
            monitor-exit(r6)
            return r0
        L_0x0029:
            r0 = move-exception
            goto L_0x002f
        L_0x002b:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ all -> 0x003c }
        L_0x0034:
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r1 = r0
        L_0x0036:
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ all -> 0x003c }
            goto L_0x003f
        L_0x003c:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x003f:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigStorageClient.read():com.google.firebase.remoteconfig.internal.ConfigContainer");
    }

    public synchronized Void write(ConfigContainer configContainer) throws IOException {
        FileOutputStream openFileOutput = this.context.openFileOutput(this.fileName, 0);
        try {
            openFileOutput.write(configContainer.toString().getBytes("UTF-8"));
        } finally {
            openFileOutput.close();
        }
        return null;
    }
}
