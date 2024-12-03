package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import com.google.firebase.perf.FirebasePerformance;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0004,1\u001f\"BS\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020+\u0012\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00\u0012\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0400\u0012\u0012\u0010b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0004\bc\u0010dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J'\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0017J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0017J\u000f\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u0002H\u0016J#\u0010&\u001a\u00020\u00022\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0000¢\u0006\u0004\b(\u0010\u0015J\u000f\u0010)\u001a\u00020\u0002H\u0000¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0013\u001a\u00020+8\u0000X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R&\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b04008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u00102R&\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006008\u0000X\u0004¢\u0006\f\n\u0004\b\"\u00102\u001a\u0004\b6\u00107R\"\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n8\u0000X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010>R\u001a\u0010D\u001a\u00020?8GX\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010ER$\u0010L\u001a\u0004\u0018\u00010G8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b6\u0010H\u001a\u0004\b9\u0010I\"\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010QR&\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020T0S8\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010U\u001a\u0004\b@\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010YR\u0014\u0010\\\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010[R\u0014\u0010]\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010[R\u001a\u0010a\u001a\u00020^8\u0006X\u0004¢\u0006\f\n\u0004\b\u0011\u0010_\u0012\u0004\b`\u0010*¨\u0006e"}, d2 = {"Landroidx/room/m;", "", "", "l", "Lt1/i;", "db", "", "tableId", "s", "r", "", "", "names", "o", "([Ljava/lang/String;)[Ljava/lang/String;", "Landroidx/room/c;", "autoCloser", "p", "(Landroidx/room/c;)V", "database", "j", "(Lt1/i;)V", "Landroid/content/Context;", "context", "name", "Landroid/content/Intent;", "serviceIntent", "q", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Landroidx/room/m$c;", "observer", "c", "n", "", "d", "()Z", "m", "tables", "k", "([Ljava/lang/String;)V", "u", "t", "()V", "Landroidx/room/RoomDatabase;", "a", "Landroidx/room/RoomDatabase;", "f", "()Landroidx/room/RoomDatabase;", "", "b", "Ljava/util/Map;", "shadowTablesMap", "", "viewTables", "i", "()Ljava/util/Map;", "tableIdLookup", "e", "[Ljava/lang/String;", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "tablesNames", "Landroidx/room/c;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "h", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingRefresh", "Z", "initialized", "Lt1/m;", "Lt1/m;", "()Lt1/m;", "setCleanupStatement$room_runtime_release", "(Lt1/m;)V", "cleanupStatement", "Landroidx/room/m$b;", "Landroidx/room/m$b;", "observedTableTracker", "Landroidx/room/k;", "Landroidx/room/k;", "invalidationLiveDataContainer", "Lj/b;", "Landroidx/room/m$d;", "Lj/b;", "()Lj/b;", "observerMap", "Landroidx/room/p;", "Landroidx/room/p;", "multiInstanceInvalidationClient", "Ljava/lang/Object;", "syncTriggersLock", "trackerLock", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "refreshRunnable", "tableNames", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public class m {

    /* renamed from: q  reason: collision with root package name */
    public static final a f6889q = new a((DefaultConstructorMarker) null);

    /* renamed from: r  reason: collision with root package name */
    private static final String[] f6890r = {"UPDATE", FirebasePerformance.HttpMethod.DELETE, "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f6891a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f6892b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Set<String>> f6893c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Integer> f6894d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f6895e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public c f6896f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f6897g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f6898h;

    /* renamed from: i  reason: collision with root package name */
    private volatile t1.m f6899i;

    /* renamed from: j  reason: collision with root package name */
    private final b f6900j;

    /* renamed from: k  reason: collision with root package name */
    private final k f6901k;

    /* renamed from: l  reason: collision with root package name */
    private final j.b<c, d> f6902l;

    /* renamed from: m  reason: collision with root package name */
    private p f6903m;

    /* renamed from: n  reason: collision with root package name */
    private final Object f6904n;

    /* renamed from: o  reason: collision with root package name */
    private final Object f6905o;

    /* renamed from: p  reason: collision with root package name */
    public final Runnable f6906p;

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u000f\u0010\r\u0012\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u0012\u0010\r\u0012\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/room/m$a;", "", "", "tableName", "triggerType", "b", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lt1/i;", "database", "", "a", "(Lt1/i;)V", "CREATE_TRACKING_TABLE_SQL", "Ljava/lang/String;", "INVALIDATED_COLUMN_NAME", "RESET_UPDATED_TABLES_SQL", "getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations", "()V", "SELECT_UPDATED_TABLES_SQL", "getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations", "TABLE_ID_COLUMN_NAME", "", "TRIGGERS", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "<init>", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(i iVar) {
            j.g(iVar, "database");
            if (iVar.O1()) {
                iVar.b0();
            } else {
                iVar.beginTransaction();
            }
        }

        public final String b(String str, String str2) {
            j.g(str, "tableName");
            j.g(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }
    }

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u000f\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003J\u0012\u0010\u0007\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003J\u0006\u0010\t\u001a\u00020\bJ\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0007R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Landroidx/room/m$b;", "", "", "", "tableIds", "", "b", "c", "", "d", "a", "", "[J", "getTableObservers", "()[J", "tableObservers", "", "[Z", "triggerStates", "[I", "triggerStateChanges", "Z", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "needsSync", "tableCount", "<init>", "(I)V", "e", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        public static final a f6907e = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final long[] f6908a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f6909b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f6910c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6911d;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Landroidx/room/m$b$a;", "", "", "ADD", "I", "NO_OP", "REMOVE", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(int i10) {
            this.f6908a = new long[i10];
            this.f6909b = new boolean[i10];
            this.f6910c = new int[i10];
        }

        public final int[] a() {
            boolean z10;
            synchronized (this) {
                if (!this.f6911d) {
                    return null;
                }
                long[] jArr = this.f6908a;
                int length = jArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    int i13 = 1;
                    if (jArr[i10] > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean[] zArr = this.f6909b;
                    if (z10 != zArr[i11]) {
                        int[] iArr = this.f6910c;
                        if (!z10) {
                            i13 = 2;
                        }
                        iArr[i11] = i13;
                    } else {
                        this.f6910c[i11] = 0;
                    }
                    zArr[i11] = z10;
                    i10++;
                    i11 = i12;
                }
                this.f6911d = false;
                int[] iArr2 = (int[]) this.f6910c.clone();
                return iArr2;
            }
        }

        public final boolean b(int... iArr) {
            boolean z10;
            j.g(iArr, "tableIds");
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f6908a;
                    long j10 = jArr[i10];
                    jArr[i10] = 1 + j10;
                    if (j10 == 0) {
                        this.f6911d = true;
                        z10 = true;
                    }
                }
                Unit unit = Unit.f32013a;
            }
            return z10;
        }

        public final boolean c(int... iArr) {
            boolean z10;
            j.g(iArr, "tableIds");
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f6908a;
                    long j10 = jArr[i10];
                    jArr[i10] = j10 - 1;
                    if (j10 == 1) {
                        this.f6911d = true;
                        z10 = true;
                    }
                }
                Unit unit = Unit.f32013a;
            }
            return z10;
        }

        public final void d() {
            synchronized (this) {
                Arrays.fill(this.f6909b, false);
                this.f6911d = true;
                Unit unit = Unit.f32013a;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&R\"\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00078\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8PX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Landroidx/room/m$c;", "", "", "", "tables", "", "c", "", "a", "[Ljava/lang/String;", "()[Ljava/lang/String;", "", "b", "()Z", "isRemote", "<init>", "([Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        private final String[] f6912a;

        public c(String[] strArr) {
            j.g(strArr, "tables");
            this.f6912a = strArr;
        }

        public final String[] a() {
            return this.f6912a;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set<String> set);
    }

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0000¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\r8\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00138\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015R\u001c\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/room/m$d;", "", "", "", "invalidatedTablesIds", "", "b", "(Ljava/util/Set;)V", "", "", "tables", "c", "([Ljava/lang/String;)V", "Landroidx/room/m$c;", "a", "Landroidx/room/m$c;", "getObserver$room_runtime_release", "()Landroidx/room/m$c;", "observer", "", "[I", "()[I", "tableIds", "[Ljava/lang/String;", "tableNames", "d", "Ljava/util/Set;", "singleTableSet", "<init>", "(Landroidx/room/m$c;[I[Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final c f6913a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f6914b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f6915c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f6916d;

        public d(c cVar, int[] iArr, String[] strArr) {
            boolean z10;
            Set<String> set;
            j.g(cVar, "observer");
            j.g(iArr, "tableIds");
            j.g(strArr, "tableNames");
            this.f6913a = cVar;
            this.f6914b = iArr;
            this.f6915c = strArr;
            boolean z11 = true;
            if (strArr.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                set = m0.d(strArr[0]);
            } else {
                set = n0.e();
            }
            this.f6916d = set;
            if (!(iArr.length != strArr.length ? false : z11)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final int[] a() {
            return this.f6914b;
        }

        public final void b(Set<Integer> set) {
            Set<String> set2;
            j.g(set, "invalidatedTablesIds");
            int[] iArr = this.f6914b;
            int length = iArr.length;
            if (length != 0) {
                int i10 = 0;
                if (length != 1) {
                    Set b10 = m0.b();
                    int[] iArr2 = this.f6914b;
                    int length2 = iArr2.length;
                    int i11 = 0;
                    while (i10 < length2) {
                        int i12 = i11 + 1;
                        if (set.contains(Integer.valueOf(iArr2[i10]))) {
                            b10.add(this.f6915c[i11]);
                        }
                        i10++;
                        i11 = i12;
                    }
                    set2 = m0.a(b10);
                } else if (set.contains(Integer.valueOf(iArr[0]))) {
                    set2 = this.f6916d;
                } else {
                    set2 = n0.e();
                }
            } else {
                set2 = n0.e();
            }
            if (!set2.isEmpty()) {
                this.f6913a.c(set2);
            }
        }

        public final void c(String[] strArr) {
            Set<String> set;
            j.g(strArr, "tables");
            int length = this.f6915c.length;
            if (length != 0) {
                boolean z10 = false;
                if (length != 1) {
                    Set b10 = m0.b();
                    for (String str : strArr) {
                        for (String str2 : this.f6915c) {
                            if (r.t(str2, str, true)) {
                                b10.add(str2);
                            }
                        }
                    }
                    set = m0.a(b10);
                } else {
                    int length2 = strArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            break;
                        } else if (r.t(strArr[i10], this.f6915c[0], true)) {
                            z10 = true;
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (z10) {
                        set = this.f6916d;
                    } else {
                        set = n0.e();
                    }
                }
            } else {
                set = n0.e();
            }
            if (!set.isEmpty()) {
                this.f6913a.c(set);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/room/m$e", "Ljava/lang/Runnable;", "", "", "a", "", "run", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f6917a;

        e(m mVar) {
            this.f6917a = mVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
            kotlin.io.b.a(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
            throw r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.Set<java.lang.Integer> a() {
            /*
                r5 = this;
                androidx.room.m r0 = r5.f6917a
                java.util.Set r1 = kotlin.collections.m0.b()
                androidx.room.RoomDatabase r0 = r0.f()
                t1.a r2 = new t1.a
                java.lang.String r3 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;"
                r2.<init>(r3)
                r3 = 0
                r4 = 2
                android.database.Cursor r0 = androidx.room.RoomDatabase.A(r0, r2, r3, r4, r3)
            L_0x0017:
                boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0066 }
                if (r2 == 0) goto L_0x002a
                r2 = 0
                int r2 = r0.getInt(r2)     // Catch:{ all -> 0x0066 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0066 }
                r1.add(r2)     // Catch:{ all -> 0x0066 }
                goto L_0x0017
            L_0x002a:
                kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0066 }
                kotlin.io.b.a(r0, r3)
                java.util.Set r0 = kotlin.collections.m0.a(r1)
                boolean r1 = r0.isEmpty()
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x0065
                androidx.room.m r1 = r5.f6917a
                t1.m r1 = r1.e()
                java.lang.String r2 = "Required value was null."
                if (r1 == 0) goto L_0x005b
                androidx.room.m r1 = r5.f6917a
                t1.m r1 = r1.e()
                if (r1 == 0) goto L_0x0051
                r1.H()
                goto L_0x0065
            L_0x0051:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x005b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x0065:
                return r0
            L_0x0066:
                r1 = move-exception
                throw r1     // Catch:{ all -> 0x0068 }
            L_0x0068:
                r2 = move-exception
                kotlin.io.b.a(r0, r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.m.e.a():java.util.Set");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
            if (r0 != null) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
            r0.e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
            if (r0 == null) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00aa, code lost:
            if (r0 == null) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b2, code lost:
            if ((!r3.isEmpty()) == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b4, code lost:
            r0 = r4.f6917a.g();
            r1 = r4.f6917a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bc, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r1 = r1.g().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c9, code lost:
            if (r1.hasNext() == false) goto L_0x00db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00cb, code lost:
            ((androidx.room.m.d) ((java.util.Map.Entry) r1.next()).getValue()).b(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00db, code lost:
            r1 = kotlin.Unit.f32013a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00dd, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x009d */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x008d=Splitter:B:33:0x008d, B:37:0x009d=Splitter:B:37:0x009d} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                androidx.room.m r0 = r4.f6917a
                androidx.room.RoomDatabase r0 = r0.f()
                java.util.concurrent.locks.Lock r0 = r0.l()
                r0.lock()
                r1 = 1
                androidx.room.m r2 = r4.f6917a     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                boolean r2 = r2.d()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                if (r2 != 0) goto L_0x0025
                r0.unlock()
                androidx.room.m r0 = r4.f6917a
                androidx.room.c r0 = r0.f6896f
                if (r0 == 0) goto L_0x0024
                r0.e()
            L_0x0024:
                return
            L_0x0025:
                androidx.room.m r2 = r4.f6917a     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.h()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                r3 = 0
                boolean r2 = r2.compareAndSet(r1, r3)     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                if (r2 != 0) goto L_0x0041
                r0.unlock()
                androidx.room.m r0 = r4.f6917a
                androidx.room.c r0 = r0.f6896f
                if (r0 == 0) goto L_0x0040
                r0.e()
            L_0x0040:
                return
            L_0x0041:
                androidx.room.m r2 = r4.f6917a     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                androidx.room.RoomDatabase r2 = r2.f()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                boolean r2 = r2.s()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                if (r2 == 0) goto L_0x005c
                r0.unlock()
                androidx.room.m r0 = r4.f6917a
                androidx.room.c r0 = r0.f6896f
                if (r0 == 0) goto L_0x005b
                r0.e()
            L_0x005b:
                return
            L_0x005c:
                androidx.room.m r2 = r4.f6917a     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                androidx.room.RoomDatabase r2 = r2.f()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                t1.j r2 = r2.n()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                t1.i r2 = r2.n1()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                r2.b0()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                java.util.Set r3 = r4.a()     // Catch:{ all -> 0x0086 }
                r2.setTransactionSuccessful()     // Catch:{ all -> 0x0086 }
                r2.endTransaction()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                r0.unlock()
                androidx.room.m r0 = r4.f6917a
                androidx.room.c r0 = r0.f6896f
                if (r0 == 0) goto L_0x00ad
            L_0x0082:
                r0.e()
                goto L_0x00ad
            L_0x0086:
                r3 = move-exception
                r2.endTransaction()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
                throw r3     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x008d }
            L_0x008b:
                r1 = move-exception
                goto L_0x00e3
            L_0x008d:
                java.util.Set r3 = kotlin.collections.n0.e()     // Catch:{ all -> 0x008b }
                r0.unlock()
                androidx.room.m r0 = r4.f6917a
                androidx.room.c r0 = r0.f6896f
                if (r0 == 0) goto L_0x00ad
                goto L_0x0082
            L_0x009d:
                java.util.Set r3 = kotlin.collections.n0.e()     // Catch:{ all -> 0x008b }
                r0.unlock()
                androidx.room.m r0 = r4.f6917a
                androidx.room.c r0 = r0.f6896f
                if (r0 == 0) goto L_0x00ad
                goto L_0x0082
            L_0x00ad:
                boolean r0 = r3.isEmpty()
                r0 = r0 ^ r1
                if (r0 == 0) goto L_0x00e2
                androidx.room.m r0 = r4.f6917a
                j.b r0 = r0.g()
                androidx.room.m r1 = r4.f6917a
                monitor-enter(r0)
                j.b r1 = r1.g()     // Catch:{ all -> 0x00df }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00df }
            L_0x00c5:
                boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00df }
                if (r2 == 0) goto L_0x00db
                java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00df }
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00df }
                java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00df }
                androidx.room.m$d r2 = (androidx.room.m.d) r2     // Catch:{ all -> 0x00df }
                r2.b(r3)     // Catch:{ all -> 0x00df }
                goto L_0x00c5
            L_0x00db:
                kotlin.Unit r1 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00df }
                monitor-exit(r0)
                goto L_0x00e2
            L_0x00df:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x00e2:
                return
            L_0x00e3:
                r0.unlock()
                androidx.room.m r0 = r4.f6917a
                androidx.room.c r0 = r0.f6896f
                if (r0 == 0) goto L_0x00f1
                r0.e()
            L_0x00f1:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.m.e.run():void");
        }
    }

    public m(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        String str;
        j.g(roomDatabase, "database");
        j.g(map, "shadowTablesMap");
        j.g(map2, "viewTables");
        j.g(strArr, "tableNames");
        this.f6891a = roomDatabase;
        this.f6892b = map;
        this.f6893c = map2;
        this.f6900j = new b(strArr.length);
        this.f6901k = new k(roomDatabase);
        this.f6902l = new j.b<>();
        this.f6904n = new Object();
        this.f6905o = new Object();
        this.f6894d = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str2 = strArr[i10];
            Locale locale = Locale.US;
            j.f(locale, "US");
            String lowerCase = str2.toLowerCase(locale);
            j.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.f6894d.put(lowerCase, Integer.valueOf(i10));
            String str3 = this.f6892b.get(strArr[i10]);
            if (str3 != null) {
                j.f(locale, "US");
                str = str3.toLowerCase(locale);
                j.f(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i10] = lowerCase;
        }
        this.f6895e = strArr2;
        for (Map.Entry next : this.f6892b.entrySet()) {
            Locale locale2 = Locale.US;
            j.f(locale2, "US");
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            j.f(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.f6894d.containsKey(lowerCase2)) {
                j.f(locale2, "US");
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                j.f(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map3 = this.f6894d;
                map3.put(lowerCase3, h0.j(map3, lowerCase2));
            }
        }
        this.f6906p = new e(this);
    }

    /* access modifiers changed from: private */
    public final void l() {
        synchronized (this.f6905o) {
            this.f6898h = false;
            this.f6900j.d();
            t1.m mVar = this.f6899i;
            if (mVar != null) {
                mVar.close();
                Unit unit = Unit.f32013a;
            }
        }
    }

    private final String[] o(String[] strArr) {
        Set b10 = m0.b();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.f6893c;
            Locale locale = Locale.US;
            j.f(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            j.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.f6893c;
                j.f(locale, "US");
                String lowerCase2 = str.toLowerCase(locale);
                j.f(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                j.d(set);
                b10.addAll(set);
            } else {
                b10.add(str);
            }
        }
        Object[] array2 = m0.a(b10).toArray(new String[0]);
        j.e(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array2;
    }

    private final void r(i iVar, int i10) {
        iVar.D("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f6895e[i10];
        for (String str2 : f6890r) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + f6889q.b(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE " + "room_table_modification_log" + " SET " + "invalidated" + " = 1" + " WHERE " + "table_id" + " = " + i10 + " AND " + "invalidated" + " = 0" + "; END";
            j.f(str3, "StringBuilder().apply(builderAction).toString()");
            iVar.D(str3);
        }
    }

    private final void s(i iVar, int i10) {
        String str = this.f6895e[i10];
        for (String str2 : f6890r) {
            String str3 = "DROP TRIGGER IF EXISTS " + f6889q.b(str, str2);
            j.f(str3, "StringBuilder().apply(builderAction).toString()");
            iVar.D(str3);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void c(c cVar) {
        d j10;
        j.g(cVar, "observer");
        String[] o10 = o(cVar.a());
        ArrayList arrayList = new ArrayList(o10.length);
        int length = o10.length;
        int i10 = 0;
        while (i10 < length) {
            String str = o10[i10];
            Map<String, Integer> map = this.f6894d;
            Locale locale = Locale.US;
            j.f(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            j.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num != null) {
                arrayList.add(Integer.valueOf(num.intValue()));
                i10++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        int[] w02 = CollectionsKt___CollectionsKt.w0(arrayList);
        d dVar = new d(cVar, w02, o10);
        synchronized (this.f6902l) {
            j10 = this.f6902l.j(cVar, dVar);
        }
        if (j10 == null && this.f6900j.b(Arrays.copyOf(w02, w02.length))) {
            t();
        }
    }

    public final boolean d() {
        if (!this.f6891a.y()) {
            return false;
        }
        if (!this.f6898h) {
            this.f6891a.n().n1();
        }
        if (!this.f6898h) {
            return false;
        }
        return true;
    }

    public final t1.m e() {
        return this.f6899i;
    }

    public final RoomDatabase f() {
        return this.f6891a;
    }

    public final j.b<c, d> g() {
        return this.f6902l;
    }

    public final AtomicBoolean h() {
        return this.f6897g;
    }

    public final Map<String, Integer> i() {
        return this.f6894d;
    }

    public final void j(i iVar) {
        j.g(iVar, "database");
        synchronized (this.f6905o) {
            if (!this.f6898h) {
                iVar.D("PRAGMA temp_store = MEMORY;");
                iVar.D("PRAGMA recursive_triggers='ON';");
                iVar.D("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                u(iVar);
                this.f6899i = iVar.T0("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
                this.f6898h = true;
                Unit unit = Unit.f32013a;
            }
        }
    }

    public final void k(String... strArr) {
        j.g(strArr, "tables");
        synchronized (this.f6902l) {
            Iterator<T> it = this.f6902l.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                j.f(entry, "(observer, wrapper)");
                d dVar = (d) entry.getValue();
                if (!((c) entry.getKey()).b()) {
                    dVar.c(strArr);
                }
            }
            Unit unit = Unit.f32013a;
        }
    }

    public void m() {
        if (this.f6897g.compareAndSet(false, true)) {
            c cVar = this.f6896f;
            if (cVar != null) {
                cVar.j();
            }
            this.f6891a.o().execute(this.f6906p);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void n(c cVar) {
        d m10;
        j.g(cVar, "observer");
        synchronized (this.f6902l) {
            m10 = this.f6902l.m(cVar);
        }
        if (m10 != null) {
            b bVar = this.f6900j;
            int[] a10 = m10.a();
            if (bVar.c(Arrays.copyOf(a10, a10.length))) {
                t();
            }
        }
    }

    public final void p(c cVar) {
        j.g(cVar, "autoCloser");
        this.f6896f = cVar;
        cVar.l(new l(this));
    }

    public final void q(Context context, String str, Intent intent) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "name");
        j.g(intent, "serviceIntent");
        this.f6903m = new p(context, str, intent, this, this.f6891a.o());
    }

    public final void t() {
        if (this.f6891a.y()) {
            u(this.f6891a.n().n1());
        }
    }

    /* JADX INFO: finally extract failed */
    public final void u(i iVar) {
        j.g(iVar, "database");
        if (!iVar.E1()) {
            try {
                Lock l10 = this.f6891a.l();
                l10.lock();
                try {
                    synchronized (this.f6904n) {
                        int[] a10 = this.f6900j.a();
                        if (a10 != null) {
                            f6889q.a(iVar);
                            try {
                                int length = a10.length;
                                int i10 = 0;
                                int i11 = 0;
                                while (i10 < length) {
                                    int i12 = a10[i10];
                                    int i13 = i11 + 1;
                                    if (i12 == 1) {
                                        r(iVar, i11);
                                    } else if (i12 == 2) {
                                        s(iVar, i11);
                                    }
                                    i10++;
                                    i11 = i13;
                                }
                                iVar.setTransactionSuccessful();
                                iVar.endTransaction();
                                Unit unit = Unit.f32013a;
                                l10.unlock();
                            } catch (Throwable th2) {
                                iVar.endTransaction();
                                throw th2;
                            }
                        }
                    }
                } finally {
                    l10.unlock();
                }
            } catch (SQLiteException | IllegalStateException unused) {
            }
        }
    }
}
