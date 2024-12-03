package g2;

import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0016\u0010\u0018\u001a\u00020\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0019\u001a\u00020\u0017H\u0007¨\u0006\u001d"}, d2 = {"Lg2/b0;", "", "Landroidx/work/WorkInfo$State;", "state", "", "j", "value", "f", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "a", "c", "Landroidx/work/NetworkType;", "networkType", "g", "d", "Landroidx/work/OutOfQuotaPolicy;", "policy", "h", "e", "", "Lb2/a$b;", "triggers", "", "i", "bytes", "b", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f15035a = new b0();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f15036a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f15037b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f15038c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f15039d;

        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|41|42|(2:43|44)|45|47) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|47) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0077 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0098 */
        static {
            /*
                androidx.work.WorkInfo$State[] r0 = androidx.work.WorkInfo.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo.State.ENQUEUED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                androidx.work.WorkInfo$State r3 = androidx.work.WorkInfo.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.BLOCKED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.CANCELLED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r7 = 6
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                f15036a = r0
                androidx.work.BackoffPolicy[] r0 = androidx.work.BackoffPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.EXPONENTIAL     // Catch:{ NoSuchFieldError -> 0x004e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.LINEAR     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                f15037b = r0
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.NetworkType r6 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                androidx.work.NetworkType r6 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x006f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                androidx.work.NetworkType r6 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x007f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                androidx.work.NetworkType r3 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r3] = r5     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                f15038c = r0
                androidx.work.OutOfQuotaPolicy[] r0 = androidx.work.OutOfQuotaPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.OutOfQuotaPolicy r3 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                androidx.work.OutOfQuotaPolicy r1 = androidx.work.OutOfQuotaPolicy.DROP_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                f15039d = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.b0.a.<clinit>():void");
        }
    }

    private b0() {
    }

    public static final int a(BackoffPolicy backoffPolicy) {
        j.g(backoffPolicy, "backoffPolicy");
        int i10 = a.f15037b[backoffPolicy.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.io.b.a(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005c, code lost:
        kotlin.io.b.a(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Set<b2.a.b> b(byte[] r9) {
        /*
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.j.g(r9, r0)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            int r1 = r9.length
            r2 = 0
            if (r1 != 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = r2
        L_0x0011:
            if (r1 == 0) goto L_0x0014
            return r0
        L_0x0014:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r9)
            r9 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0050 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0050 }
            int r4 = r3.readInt()     // Catch:{ all -> 0x0047 }
        L_0x0023:
            if (r2 >= r4) goto L_0x0041
            java.lang.String r5 = r3.readUTF()     // Catch:{ all -> 0x0047 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x0047 }
            boolean r6 = r3.readBoolean()     // Catch:{ all -> 0x0047 }
            b2.a$b r7 = new b2.a$b     // Catch:{ all -> 0x0047 }
            java.lang.String r8 = "uri"
            kotlin.jvm.internal.j.f(r5, r8)     // Catch:{ all -> 0x0047 }
            r7.<init>(r5, r6)     // Catch:{ all -> 0x0047 }
            r0.add(r7)     // Catch:{ all -> 0x0047 }
            int r2 = r2 + 1
            goto L_0x0023
        L_0x0041:
            kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0047 }
            kotlin.io.b.a(r3, r9)     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0047:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r4 = move-exception
            kotlin.io.b.a(r3, r2)     // Catch:{ IOException -> 0x0050 }
            throw r4     // Catch:{ IOException -> 0x0050 }
        L_0x004e:
            r9 = move-exception
            goto L_0x005a
        L_0x0050:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x004e }
        L_0x0054:
            kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x004e }
            kotlin.io.b.a(r1, r9)
            return r0
        L_0x005a:
            throw r9     // Catch:{ all -> 0x005b }
        L_0x005b:
            r0 = move-exception
            kotlin.io.b.a(r1, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.b0.b(byte[]):java.util.Set");
    }

    public static final BackoffPolicy c(int i10) {
        if (i10 == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i10 == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to BackoffPolicy");
    }

    public static final NetworkType d(int i10) {
        if (i10 == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i10 == 1) {
            return NetworkType.CONNECTED;
        }
        if (i10 == 2) {
            return NetworkType.UNMETERED;
        }
        if (i10 == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i10 == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i10 == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to NetworkType");
    }

    public static final OutOfQuotaPolicy e(int i10) {
        if (i10 == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i10 == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to OutOfQuotaPolicy");
    }

    public static final WorkInfo.State f(int i10) {
        if (i10 == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i10 == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i10 == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i10 == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i10 == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i10 == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to State");
    }

    public static final int g(NetworkType networkType) {
        j.g(networkType, "networkType");
        int i10 = a.f15038c[networkType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    public static final int h(OutOfQuotaPolicy outOfQuotaPolicy) {
        j.g(outOfQuotaPolicy, "policy");
        int i10 = a.f15039d[outOfQuotaPolicy.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.b.a(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        kotlin.io.b.a(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] i(java.util.Set<b2.a.b> r4) {
        /*
            java.lang.String r0 = "triggers"
            kotlin.jvm.internal.j.g(r4, r0)
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x000f
            r4 = 0
            byte[] r4 = new byte[r4]
            return r4
        L_0x000f:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x005d }
            r1.<init>(r0)     // Catch:{ all -> 0x005d }
            int r2 = r4.size()     // Catch:{ all -> 0x0056 }
            r1.writeInt(r2)     // Catch:{ all -> 0x0056 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0056 }
        L_0x0024:
            boolean r2 = r4.hasNext()     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0043
            java.lang.Object r2 = r4.next()     // Catch:{ all -> 0x0056 }
            b2.a$b r2 = (b2.a.b) r2     // Catch:{ all -> 0x0056 }
            android.net.Uri r3 = r2.a()     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0056 }
            r1.writeUTF(r3)     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.b()     // Catch:{ all -> 0x0056 }
            r1.writeBoolean(r2)     // Catch:{ all -> 0x0056 }
            goto L_0x0024
        L_0x0043:
            kotlin.Unit r4 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0056 }
            r4 = 0
            kotlin.io.b.a(r1, r4)     // Catch:{ all -> 0x005d }
            kotlin.io.b.a(r0, r4)
            byte[] r4 = r0.toByteArray()
            java.lang.String r0 = "outputStream.toByteArray()"
            kotlin.jvm.internal.j.f(r4, r0)
            return r4
        L_0x0056:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r2 = move-exception
            kotlin.io.b.a(r1, r4)     // Catch:{ all -> 0x005d }
            throw r2     // Catch:{ all -> 0x005d }
        L_0x005d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x005f }
        L_0x005f:
            r1 = move-exception
            kotlin.io.b.a(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.b0.i(java.util.Set):byte[]");
    }

    public static final int j(WorkInfo.State state) {
        j.g(state, "state");
        switch (a.f15036a[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
