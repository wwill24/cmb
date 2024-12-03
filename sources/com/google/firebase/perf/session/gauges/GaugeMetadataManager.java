package com.google.firebase.perf.session.gauges;

import android.app.ActivityManager;
import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GaugeMetadataManager {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ActivityManager activityManager;
    private final Context appContext;
    private final ActivityManager.MemoryInfo memoryInfo;
    private final Runtime runtime;

    GaugeMetadataManager(Context context) {
        this(Runtime.getRuntime(), context);
    }

    public int getDeviceRamSizeKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.memoryInfo.totalMem));
    }

    public int getMaxAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.maxMemory()));
    }

    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.MEGABYTES.toKilobytes((long) this.activityManager.getMemoryClass()));
    }

    /* access modifiers changed from: package-private */
    public int readTotalRAM(String str) {
        BufferedReader bufferedReader;
        String readLine;
        int i10;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return 0;
                }
            } while (!readLine.startsWith("MemTotal"));
            Matcher matcher = Pattern.compile("\\d+").matcher(readLine);
            if (matcher.find()) {
                i10 = Integer.parseInt(matcher.group());
            } else {
                i10 = 0;
            }
            bufferedReader.close();
            return i10;
        } catch (IOException e10) {
            logger.warn("Unable to read '" + str + "' file: " + e10.getMessage());
        } catch (NumberFormatException e11) {
            logger.warn("Unable to parse '" + str + "' file: " + e11.getMessage());
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    GaugeMetadataManager(Runtime runtime2, Context context) {
        this.runtime = runtime2;
        this.appContext = context;
        ActivityManager activityManager2 = (ActivityManager) context.getSystemService("activity");
        this.activityManager = activityManager2;
        ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
        this.memoryInfo = memoryInfo2;
        activityManager2.getMemoryInfo(memoryInfo2);
    }
}
