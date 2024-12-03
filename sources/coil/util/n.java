package coil.util;

import android.os.SystemClock;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcoil/util/n;", "", "", "a", "Lcoil/util/s;", "logger", "b", "Ljava/io/File;", "Ljava/io/File;", "fileDescriptorList", "", "c", "I", "decodesSinceLastFileDescriptorCheck", "", "d", "J", "lastFileDescriptorCheckTimestamp", "e", "Z", "hasAvailableFileDescriptors", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f8437a = new n();

    /* renamed from: b  reason: collision with root package name */
    private static final File f8438b = new File("/proc/self/fd");

    /* renamed from: c  reason: collision with root package name */
    private static int f8439c = 30;

    /* renamed from: d  reason: collision with root package name */
    private static long f8440d = SystemClock.uptimeMillis();

    /* renamed from: e  reason: collision with root package name */
    private static boolean f8441e = true;

    private n() {
    }

    private final boolean a() {
        int i10 = f8439c;
        f8439c = i10 + 1;
        if (i10 >= 30 || SystemClock.uptimeMillis() > f8440d + ((long) 30000)) {
            return true;
        }
        return false;
    }

    public final synchronized boolean b(s sVar) {
        if (a()) {
            boolean z10 = false;
            f8439c = 0;
            f8440d = SystemClock.uptimeMillis();
            String[] list = f8438b.list();
            if (list == null) {
                list = new String[0];
            }
            int length = list.length;
            if (length < 800) {
                z10 = true;
            }
            f8441e = z10;
            if (!z10 && sVar != null && sVar.getLevel() <= 5) {
                sVar.a("FileDescriptorCounter", 5, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + length, (Throwable) null);
            }
        }
        return f8441e;
    }
}
