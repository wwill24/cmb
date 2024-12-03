package io.sentry.android.core.internal.util;

import io.sentry.util.d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.VisibleForTesting;

@ApiStatus.Internal
public final class e {

    /* renamed from: b  reason: collision with root package name */
    private static final e f31023b = new e();

    /* renamed from: a  reason: collision with root package name */
    private final List<Integer> f31024a = new ArrayList();

    private e() {
    }

    public static e a() {
        return f31023b;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String b() {
        return "/sys/devices/system/cpu";
    }

    public synchronized List<Integer> c() {
        if (!this.f31024a.isEmpty()) {
            return this.f31024a;
        }
        File[] listFiles = new File(b()).listFiles();
        if (listFiles == null) {
            return new ArrayList();
        }
        for (File file : listFiles) {
            if (file.getName().matches("cpu[0-9]+")) {
                File file2 = new File(file, "cpufreq/cpuinfo_max_freq");
                if (file2.exists() && file2.canRead()) {
                    try {
                        String b10 = d.b(file2);
                        if (b10 != null) {
                            this.f31024a.add(Integer.valueOf((int) (Long.parseLong(b10.trim()) / 1000)));
                        }
                    } catch (IOException | NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return this.f31024a;
    }
}
