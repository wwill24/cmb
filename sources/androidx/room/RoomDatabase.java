package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import com.facebook.appevents.UserDataStore;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import t1.i;
import t1.j;
import t1.l;
import t1.m;

@Metadata(bv = {}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b&\u0018\u0000 f2\u00020\u0001:\u00079? s!,\u001fB\u0007¢\u0006\u0004\br\u0010<J-\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u000f\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0017J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u001a\u0010\u0014\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0003\u0012\u0004\u0012\u00020\u00130\u0012H\u0017J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000fH$J\b\u0010\u001b\u001a\u00020\u001aH$J\"\u0010\u001c\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00150\u0012H\u0015J\u0016\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00030\u001dH\u0017J\b\u0010\u001f\u001a\u00020\tH'J\b\u0010 \u001a\u00020\tH\u0017J\b\u0010!\u001a\u00020\tH\u0017J\u001c\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0017J\u0010\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020\tH\u0017J\b\u0010-\u001a\u00020\tH\u0017J\b\u0010.\u001a\u00020\tH\u0017J#\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010/2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0016¢\u0006\u0004\b2\u00103J\u0010\u00106\u001a\u00020\t2\u0006\u00105\u001a\u000204H\u0014J\b\u00108\u001a\u000207H\u0016R\u001e\u0010=\u001a\u0004\u0018\u0001048\u0004@\u0004X\u000e¢\u0006\f\n\u0004\b9\u0010:\u0012\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020>8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010@R\u0016\u0010D\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010CR\u001a\u0010H\u001a\u00020\u001a8\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010J\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010IR\u0016\u0010K\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010IR$\u0010O\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u00158\u0004@\u0004X\u000e¢\u0006\f\n\u0004\b\u001b\u0010M\u0012\u0004\bN\u0010<R6\u0010\u0014\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0003\u0012\u0004\u0012\u00020\u00130P8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020V8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010ZR\u001d\u0010a\u001a\b\u0012\u0004\u0012\u00020]0\\8G¢\u0006\f\n\u0004\b\r\u0010^\u001a\u0004\b_\u0010`R#\u0010c\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010P8G¢\u0006\f\n\u0004\bF\u0010Q\u001a\u0004\bb\u0010SR$\u0010e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010P8\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010QR\u0014\u0010h\u001a\u00020>8VX\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020>8VX\u0004¢\u0006\u0006\u001a\u0004\bi\u0010gR\u0014\u0010\u0006\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010kR\u0017\u0010o\u001a\u0002078G¢\u0006\f\u0012\u0004\bn\u0010<\u001a\u0004\bl\u0010mR\u0014\u0010q\u001a\u0002078@X\u0004¢\u0006\u0006\u001a\u0004\bp\u0010m¨\u0006t"}, d2 = {"Landroidx/room/RoomDatabase;", "", "T", "Ljava/lang/Class;", "clazz", "Lt1/j;", "openHelper", "D", "(Ljava/lang/Class;Lt1/j;)Ljava/lang/Object;", "", "u", "v", "Ljava/util/concurrent/locks/Lock;", "l", "()Ljava/util/concurrent/locks/Lock;", "Landroidx/room/e;", "configuration", "t", "", "Lp1/a;", "autoMigrationSpecs", "", "Lp1/b;", "k", "config", "i", "Landroidx/room/m;", "h", "q", "", "p", "f", "c", "d", "Lt1/l;", "query", "Landroid/os/CancellationSignal;", "signal", "Landroid/database/Cursor;", "z", "", "sql", "Lt1/m;", "g", "e", "j", "C", "V", "Ljava/util/concurrent/Callable;", "body", "B", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "Lt1/i;", "db", "w", "", "s", "a", "Lt1/i;", "getMDatabase$annotations", "()V", "mDatabase", "Ljava/util/concurrent/Executor;", "b", "Ljava/util/concurrent/Executor;", "internalQueryExecutor", "internalTransactionExecutor", "Lt1/j;", "internalOpenHelper", "Landroidx/room/m;", "m", "()Landroidx/room/m;", "invalidationTracker", "Z", "allowMainThreadQueries", "writeAheadLoggingEnabled", "Landroidx/room/RoomDatabase$b;", "Ljava/util/List;", "getMCallbacks$annotations", "mCallbacks", "", "Ljava/util/Map;", "getAutoMigrationSpecs", "()Ljava/util/Map;", "setAutoMigrationSpecs", "(Ljava/util/Map;)V", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "readWriteLock", "Landroidx/room/c;", "Landroidx/room/c;", "autoCloser", "Ljava/lang/ThreadLocal;", "", "Ljava/lang/ThreadLocal;", "getSuspendingTransactionId", "()Ljava/lang/ThreadLocal;", "suspendingTransactionId", "getBackingFieldMap", "backingFieldMap", "n", "typeConverters", "o", "()Ljava/util/concurrent/Executor;", "queryExecutor", "r", "transactionExecutor", "()Lt1/j;", "y", "()Z", "isOpenInternal$annotations", "isOpenInternal", "x", "isMainThread", "<init>", "JournalMode", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class RoomDatabase {

    /* renamed from: o  reason: collision with root package name */
    public static final c f6755o = new c((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    protected volatile i f6756a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f6757b;

    /* renamed from: c  reason: collision with root package name */
    private Executor f6758c;

    /* renamed from: d  reason: collision with root package name */
    private j f6759d;

    /* renamed from: e  reason: collision with root package name */
    private final m f6760e = h();

    /* renamed from: f  reason: collision with root package name */
    private boolean f6761f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6762g;

    /* renamed from: h  reason: collision with root package name */
    protected List<? extends b> f6763h;

    /* renamed from: i  reason: collision with root package name */
    private Map<Class<? extends p1.a>, p1.a> f6764i = new LinkedHashMap();

    /* renamed from: j  reason: collision with root package name */
    private final ReentrantReadWriteLock f6765j = new ReentrantReadWriteLock();

    /* renamed from: k  reason: collision with root package name */
    private c f6766k;

    /* renamed from: l  reason: collision with root package name */
    private final ThreadLocal<Integer> f6767l = new ThreadLocal<>();

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, Object> f6768m;

    /* renamed from: n  reason: collision with root package name */
    private final Map<Class<?>, Object> f6769n;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", "Landroid/app/ActivityManager;", "activityManager", "", "b", "Landroid/content/Context;", "context", "c", "(Landroid/content/Context;)Landroidx/room/RoomDatabase$JournalMode;", "<init>", "(Ljava/lang/String;I)V", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean b(ActivityManager activityManager) {
            return t1.c.b(activityManager);
        }

        public final JournalMode c(Context context) {
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            kotlin.jvm.internal.j.e(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            if (!b((ActivityManager) systemService)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B)\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b_\u0010`J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000f\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010 R\u0018\u0010,\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010%R\u0018\u0010.\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010%R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u00103R\u0016\u0010@\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u00103R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001e\u0010S\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010\u001dR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010^\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006a"}, d2 = {"Landroidx/room/RoomDatabase$a;", "Landroidx/room/RoomDatabase;", "T", "", "Lt1/j$c;", "factory", "f", "", "Lp1/b;", "migrations", "b", "([Lp1/b;)Landroidx/room/RoomDatabase$a;", "c", "Ljava/util/concurrent/Executor;", "executor", "g", "e", "Landroidx/room/RoomDatabase$b;", "callback", "a", "d", "()Landroidx/room/RoomDatabase;", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "Ljava/lang/Class;", "klass", "", "Ljava/lang/String;", "name", "", "Ljava/util/List;", "callbacks", "Landroidx/room/RoomDatabase$f;", "Landroidx/room/RoomDatabase$f;", "queryCallback", "Ljava/util/concurrent/Executor;", "queryCallbackExecutor", "typeConverters", "Lp1/a;", "h", "autoMigrationSpecs", "i", "queryExecutor", "j", "transactionExecutor", "k", "Lt1/j$c;", "", "l", "Z", "allowMainThreadQueries", "Landroidx/room/RoomDatabase$JournalMode;", "m", "Landroidx/room/RoomDatabase$JournalMode;", "journalMode", "Landroid/content/Intent;", "n", "Landroid/content/Intent;", "multiInstanceInvalidationIntent", "o", "requireMigration", "p", "allowDestructiveMigrationOnDowngrade", "", "q", "J", "autoCloseTimeout", "Ljava/util/concurrent/TimeUnit;", "r", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeUnit", "Landroidx/room/RoomDatabase$d;", "s", "Landroidx/room/RoomDatabase$d;", "migrationContainer", "", "", "t", "Ljava/util/Set;", "migrationsNotRequiredFrom", "u", "migrationStartAndEndVersions", "v", "copyFromAssetPath", "Ljava/io/File;", "w", "Ljava/io/File;", "copyFromFile", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "x", "Ljava/util/concurrent/Callable;", "copyFromInputStream", "<init>", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static class a<T extends RoomDatabase> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6774a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f6775b;

        /* renamed from: c  reason: collision with root package name */
        private final String f6776c;

        /* renamed from: d  reason: collision with root package name */
        private final List<b> f6777d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private f f6778e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f6779f;

        /* renamed from: g  reason: collision with root package name */
        private final List<Object> f6780g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        private List<p1.a> f6781h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        private Executor f6782i;

        /* renamed from: j  reason: collision with root package name */
        private Executor f6783j;

        /* renamed from: k  reason: collision with root package name */
        private j.c f6784k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f6785l;

        /* renamed from: m  reason: collision with root package name */
        private JournalMode f6786m = JournalMode.AUTOMATIC;

        /* renamed from: n  reason: collision with root package name */
        private Intent f6787n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f6788o = true;

        /* renamed from: p  reason: collision with root package name */
        private boolean f6789p;

        /* renamed from: q  reason: collision with root package name */
        private long f6790q = -1;

        /* renamed from: r  reason: collision with root package name */
        private TimeUnit f6791r;

        /* renamed from: s  reason: collision with root package name */
        private final d f6792s = new d();

        /* renamed from: t  reason: collision with root package name */
        private Set<Integer> f6793t = new LinkedHashSet();

        /* renamed from: u  reason: collision with root package name */
        private Set<Integer> f6794u;

        /* renamed from: v  reason: collision with root package name */
        private String f6795v;

        /* renamed from: w  reason: collision with root package name */
        private File f6796w;

        /* renamed from: x  reason: collision with root package name */
        private Callable<InputStream> f6797x;

        public a(Context context, Class<T> cls, String str) {
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            kotlin.jvm.internal.j.g(cls, "klass");
            this.f6774a = context;
            this.f6775b = cls;
            this.f6776c = str;
        }

        public a<T> a(b bVar) {
            kotlin.jvm.internal.j.g(bVar, "callback");
            this.f6777d.add(bVar);
            return this;
        }

        public a<T> b(p1.b... bVarArr) {
            kotlin.jvm.internal.j.g(bVarArr, "migrations");
            if (this.f6794u == null) {
                this.f6794u = new HashSet();
            }
            for (p1.b bVar : bVarArr) {
                Set<Integer> set = this.f6794u;
                kotlin.jvm.internal.j.d(set);
                set.add(Integer.valueOf(bVar.f16904a));
                Set<Integer> set2 = this.f6794u;
                kotlin.jvm.internal.j.d(set2);
                set2.add(Integer.valueOf(bVar.f16905b));
            }
            this.f6792s.b((p1.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
            return this;
        }

        public a<T> c() {
            this.f6785l = true;
            return this;
        }

        public T d() {
            n0 n0Var;
            int i10;
            int i11;
            int i12;
            Executor executor = this.f6782i;
            if (executor == null && this.f6783j == null) {
                Executor f10 = i.c.f();
                this.f6783j = f10;
                this.f6782i = f10;
            } else if (executor != null && this.f6783j == null) {
                this.f6783j = executor;
            } else if (executor == null) {
                this.f6782i = this.f6783j;
            }
            Set<Integer> set = this.f6794u;
            boolean z10 = true;
            if (set != null) {
                kotlin.jvm.internal.j.d(set);
                for (Integer intValue : set) {
                    int intValue2 = intValue.intValue();
                    if (!(!this.f6793t.contains(Integer.valueOf(intValue2)))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + intValue2).toString());
                    }
                }
            }
            d dVar = this.f6784k;
            if (dVar == null) {
                dVar = new androidx.sqlite.db.framework.d();
            }
            if (dVar != null) {
                if (this.f6790q > 0) {
                    if (this.f6776c != null) {
                        long j10 = this.f6790q;
                        TimeUnit timeUnit = this.f6791r;
                        if (timeUnit != null) {
                            Executor executor2 = this.f6782i;
                            if (executor2 != null) {
                                dVar = new d(dVar, new c(j10, timeUnit, executor2));
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
                    }
                }
                String str = this.f6795v;
                if (!(str == null && this.f6796w == null && this.f6797x == null)) {
                    if (this.f6776c != null) {
                        if (str == null) {
                            i10 = 0;
                        } else {
                            i10 = 1;
                        }
                        File file = this.f6796w;
                        if (file == null) {
                            i11 = 0;
                        } else {
                            i11 = 1;
                        }
                        Callable<InputStream> callable = this.f6797x;
                        if (callable == null) {
                            i12 = 0;
                        } else {
                            i12 = 1;
                        }
                        if (i10 + i11 + i12 != 1) {
                            z10 = false;
                        }
                        if (z10) {
                            dVar = new n0(str, file, callable, dVar);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.".toString());
                    }
                }
            } else {
                dVar = null;
            }
            if (dVar != null) {
                f fVar = this.f6778e;
                if (fVar != null) {
                    Executor executor3 = this.f6779f;
                    if (executor3 == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    } else if (fVar != null) {
                        n0Var = new c0(dVar, executor3, fVar);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    n0Var = dVar;
                }
                Context context = this.f6774a;
                String str2 = this.f6776c;
                d dVar2 = this.f6792s;
                List<b> list = this.f6777d;
                boolean z11 = this.f6785l;
                JournalMode c10 = this.f6786m.c(context);
                Executor executor4 = this.f6782i;
                if (executor4 != null) {
                    Executor executor5 = this.f6783j;
                    if (executor5 != null) {
                        e eVar = new e(context, str2, n0Var, dVar2, list, z11, c10, executor4, executor5, this.f6787n, this.f6788o, this.f6789p, this.f6793t, this.f6795v, this.f6796w, this.f6797x, (e) null, this.f6780g, this.f6781h);
                        T t10 = (RoomDatabase) h0.b(this.f6775b, "_Impl");
                        t10.t(eVar);
                        return t10;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        public a<T> e() {
            this.f6788o = false;
            this.f6789p = true;
            return this;
        }

        public a<T> f(j.c cVar) {
            this.f6784k = cVar;
            return this;
        }

        public a<T> g(Executor executor) {
            kotlin.jvm.internal.j.g(executor, "executor");
            this.f6782i = executor;
            return this;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Landroidx/room/RoomDatabase$b;", "", "Lt1/i;", "db", "", "a", "c", "b", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class b {
        public void a(i iVar) {
            kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        }

        public void b(i iVar) {
            kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        }

        public void c(i iVar) {
            kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomDatabase$c;", "", "", "MAX_BIND_PARAMETER_CNT", "I", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J#\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000f\"\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u00130\u0013H\u0016J \u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nR,\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u001a0\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001b¨\u0006\u001e"}, d2 = {"Landroidx/room/RoomDatabase$d;", "", "Lp1/b;", "migration", "", "a", "", "result", "", "upgrade", "", "start", "end", "", "e", "", "migrations", "b", "([Lp1/b;)V", "", "f", "d", "startVersion", "endVersion", "c", "", "Ljava/util/TreeMap;", "Ljava/util/Map;", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Integer, TreeMap<Integer, p1.b>> f6798a = new LinkedHashMap();

        private final void a(p1.b bVar) {
            int i10 = bVar.f16904a;
            int i11 = bVar.f16905b;
            Map<Integer, TreeMap<Integer, p1.b>> map = this.f6798a;
            Integer valueOf = Integer.valueOf(i10);
            TreeMap<Integer, p1.b> treeMap = map.get(valueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(valueOf, treeMap);
            }
            TreeMap treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i11))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Overriding migration ");
                sb2.append(treeMap2.get(Integer.valueOf(i11)));
                sb2.append(" with ");
                sb2.append(bVar);
            }
            treeMap2.put(Integer.valueOf(i11), bVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
            if (r6 <= r12) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
            if (r6 < r11) goto L_0x0056;
         */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x005b A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.List<p1.b> e(java.util.List<p1.b> r9, boolean r10, int r11, int r12) {
            /*
                r8 = this;
            L_0x0000:
                r0 = 1
                r1 = 0
                if (r10 == 0) goto L_0x0007
                if (r11 >= r12) goto L_0x000b
                goto L_0x0009
            L_0x0007:
                if (r11 <= r12) goto L_0x000b
            L_0x0009:
                r2 = r0
                goto L_0x000c
            L_0x000b:
                r2 = r1
            L_0x000c:
                if (r2 == 0) goto L_0x006e
                java.util.Map<java.lang.Integer, java.util.TreeMap<java.lang.Integer, p1.b>> r2 = r8.f6798a
                java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
                java.lang.Object r2 = r2.get(r3)
                java.util.TreeMap r2 = (java.util.TreeMap) r2
                r3 = 0
                if (r2 != 0) goto L_0x001e
                return r3
            L_0x001e:
                if (r10 == 0) goto L_0x0025
                java.util.NavigableSet r4 = r2.descendingKeySet()
                goto L_0x0029
            L_0x0025:
                java.util.Set r4 = r2.keySet()
            L_0x0029:
                java.util.Iterator r4 = r4.iterator()
            L_0x002d:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L_0x006a
                java.lang.Object r5 = r4.next()
                java.lang.Integer r5 = (java.lang.Integer) r5
                java.lang.String r6 = "targetVersion"
                if (r10 == 0) goto L_0x004b
                int r7 = r11 + 1
                kotlin.jvm.internal.j.f(r5, r6)
                int r6 = r5.intValue()
                if (r7 > r6) goto L_0x0058
                if (r6 > r12) goto L_0x0058
                goto L_0x0056
            L_0x004b:
                kotlin.jvm.internal.j.f(r5, r6)
                int r6 = r5.intValue()
                if (r12 > r6) goto L_0x0058
                if (r6 >= r11) goto L_0x0058
            L_0x0056:
                r6 = r0
                goto L_0x0059
            L_0x0058:
                r6 = r1
            L_0x0059:
                if (r6 == 0) goto L_0x002d
                java.lang.Object r11 = r2.get(r5)
                kotlin.jvm.internal.j.d(r11)
                r9.add(r11)
                int r11 = r5.intValue()
                goto L_0x006b
            L_0x006a:
                r0 = r1
            L_0x006b:
                if (r0 != 0) goto L_0x0000
                return r3
            L_0x006e:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.d.e(java.util.List, boolean, int, int):java.util.List");
        }

        public void b(p1.b... bVarArr) {
            kotlin.jvm.internal.j.g(bVarArr, "migrations");
            for (p1.b a10 : bVarArr) {
                a(a10);
            }
        }

        public final boolean c(int i10, int i11) {
            Map<Integer, Map<Integer, p1.b>> f10 = f();
            if (!f10.containsKey(Integer.valueOf(i10))) {
                return false;
            }
            Map map = f10.get(Integer.valueOf(i10));
            if (map == null) {
                map = h0.i();
            }
            return map.containsKey(Integer.valueOf(i11));
        }

        public List<p1.b> d(int i10, int i11) {
            boolean z10;
            if (i10 == i11) {
                return q.j();
            }
            if (i11 > i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            return e(new ArrayList(), z10, i10, i11);
        }

        public Map<Integer, Map<Integer, p1.b>> f() {
            return this.f6798a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomDatabase$e;", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class e {
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/room/RoomDatabase$f;", "", "", "sqlQuery", "", "bindArgs", "", "a", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public interface f {
        void a(String str, List<? extends Object> list);
    }

    public RoomDatabase() {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        kotlin.jvm.internal.j.f(synchronizedMap, "synchronizedMap(mutableMapOf())");
        this.f6768m = synchronizedMap;
        this.f6769n = new LinkedHashMap();
    }

    public static /* synthetic */ Cursor A(RoomDatabase roomDatabase, l lVar, CancellationSignal cancellationSignal, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                cancellationSignal = null;
            }
            return roomDatabase.z(lVar, cancellationSignal);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    private final <T> T D(Class<T> cls, j jVar) {
        if (cls.isInstance(jVar)) {
            return jVar;
        }
        if (jVar instanceof f) {
            return D(cls, ((f) jVar).a());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void u() {
        c();
        i n12 = n().n1();
        m().u(n12);
        if (n12.O1()) {
            n12.b0();
        } else {
            n12.beginTransaction();
        }
    }

    /* access modifiers changed from: private */
    public final void v() {
        n().n1().endTransaction();
        if (!s()) {
            m().m();
        }
    }

    public <V> V B(Callable<V> callable) {
        kotlin.jvm.internal.j.g(callable, "body");
        e();
        try {
            V call = callable.call();
            C();
            return call;
        } finally {
            j();
        }
    }

    public void C() {
        n().n1().setTransactionSuccessful();
    }

    public void c() {
        if (!this.f6761f && !(!x())) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
        }
    }

    public void d() {
        if (!(s() || this.f6767l.get() == null)) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
        }
    }

    public void e() {
        c();
        c cVar = this.f6766k;
        if (cVar == null) {
            u();
        } else {
            cVar.g(new RoomDatabase$beginTransaction$1(this));
        }
    }

    public abstract void f();

    public m g(String str) {
        kotlin.jvm.internal.j.g(str, "sql");
        c();
        d();
        return n().n1().T0(str);
    }

    /* access modifiers changed from: protected */
    public abstract m h();

    /* access modifiers changed from: protected */
    public abstract j i(e eVar);

    public void j() {
        c cVar = this.f6766k;
        if (cVar == null) {
            v();
        } else {
            cVar.g(new RoomDatabase$endTransaction$1(this));
        }
    }

    public List<p1.b> k(Map<Class<? extends p1.a>, p1.a> map) {
        kotlin.jvm.internal.j.g(map, "autoMigrationSpecs");
        return q.j();
    }

    public final Lock l() {
        ReentrantReadWriteLock.ReadLock readLock = this.f6765j.readLock();
        kotlin.jvm.internal.j.f(readLock, "readWriteLock.readLock()");
        return readLock;
    }

    public m m() {
        return this.f6760e;
    }

    public j n() {
        j jVar = this.f6759d;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("internalOpenHelper");
        return null;
    }

    public Executor o() {
        Executor executor = this.f6757b;
        if (executor != null) {
            return executor;
        }
        kotlin.jvm.internal.j.y("internalQueryExecutor");
        return null;
    }

    public Set<Class<? extends p1.a>> p() {
        return n0.e();
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> q() {
        return h0.i();
    }

    public Executor r() {
        Executor executor = this.f6758c;
        if (executor != null) {
            return executor;
        }
        kotlin.jvm.internal.j.y("internalTransactionExecutor");
        return null;
    }

    public boolean s() {
        return n().n1().E1();
    }

    public void t(e eVar) {
        boolean z10;
        boolean z11;
        kotlin.jvm.internal.j.g(eVar, "configuration");
        this.f6759d = i(eVar);
        Set<Class<? extends p1.a>> p10 = p();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends p1.a>> it = p10.iterator();
        while (true) {
            boolean z12 = true;
            int i10 = -1;
            if (it.hasNext()) {
                Class next = it.next();
                int size = eVar.f6846r.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i11 = size - 1;
                        if (next.isAssignableFrom(eVar.f6846r.get(size).getClass())) {
                            bitSet.set(size);
                            i10 = size;
                            break;
                        } else if (i11 < 0) {
                            break;
                        } else {
                            size = i11;
                        }
                    }
                }
                if (i10 < 0) {
                    z12 = false;
                }
                if (z12) {
                    this.f6764i.put(next, eVar.f6846r.get(i10));
                } else {
                    throw new IllegalArgumentException(("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.").toString());
                }
            } else {
                int size2 = eVar.f6846r.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i12 = size2 - 1;
                        if (!bitSet.get(size2)) {
                            throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
                        } else if (i12 < 0) {
                            break;
                        } else {
                            size2 = i12;
                        }
                    }
                }
                for (p1.b next2 : k(this.f6764i)) {
                    if (!eVar.f6832d.c(next2.f16904a, next2.f16905b)) {
                        eVar.f6832d.b(next2);
                    }
                }
                m0 m0Var = (m0) D(m0.class, n());
                if (m0Var != null) {
                    m0Var.e(eVar);
                }
                AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) D(AutoClosingRoomOpenHelper.class, n());
                if (autoClosingRoomOpenHelper != null) {
                    this.f6766k = autoClosingRoomOpenHelper.f6731b;
                    m().p(autoClosingRoomOpenHelper.f6731b);
                }
                if (eVar.f6835g == JournalMode.WRITE_AHEAD_LOGGING) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                n().setWriteAheadLoggingEnabled(z10);
                this.f6763h = eVar.f6833e;
                this.f6757b = eVar.f6836h;
                this.f6758c = new p0(eVar.f6837i);
                this.f6761f = eVar.f6834f;
                this.f6762g = z10;
                if (eVar.f6838j != null) {
                    if (eVar.f6830b != null) {
                        m().q(eVar.f6829a, eVar.f6830b, eVar.f6838j);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                Map<Class<?>, List<Class<?>>> q10 = q();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry next3 : q10.entrySet()) {
                    Class cls = (Class) next3.getKey();
                    Iterator it2 = ((List) next3.getValue()).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Class cls2 = (Class) it2.next();
                            int size3 = eVar.f6845q.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i13 = size3 - 1;
                                    if (cls2.isAssignableFrom(eVar.f6845q.get(size3).getClass())) {
                                        bitSet2.set(size3);
                                        break;
                                    } else if (i13 < 0) {
                                        break;
                                    } else {
                                        size3 = i13;
                                    }
                                }
                            }
                            size3 = -1;
                            if (size3 >= 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                this.f6769n.put(cls2, eVar.f6845q.get(size3));
                            } else {
                                throw new IllegalArgumentException(("A required type converter (" + cls2 + ") for " + cls.getCanonicalName() + " is missing in the database configuration.").toString());
                            }
                        }
                    }
                }
                int size4 = eVar.f6845q.size() - 1;
                if (size4 >= 0) {
                    while (true) {
                        int i14 = size4 - 1;
                        if (!bitSet2.get(size4)) {
                            throw new IllegalArgumentException("Unexpected type converter " + eVar.f6845q.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                        } else if (i14 >= 0) {
                            size4 = i14;
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void w(i iVar) {
        kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        m().j(iVar);
    }

    public final boolean x() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final boolean y() {
        i iVar = this.f6756a;
        return iVar != null && iVar.isOpen();
    }

    public Cursor z(l lVar, CancellationSignal cancellationSignal) {
        kotlin.jvm.internal.j.g(lVar, "query");
        c();
        d();
        if (cancellationSignal != null) {
            return n().n1().t1(lVar, cancellationSignal);
        }
        return n().n1().Z0(lVar);
    }
}
