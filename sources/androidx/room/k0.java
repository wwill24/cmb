package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import t1.k;
import t1.l;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\f\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b9\u0010:J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016R\u001a\u0010\u001b\u001a\u00020\u00058\u0006X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001d8\u0006X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b \u0010!R\u001a\u0010'\u001a\u00020#8\u0006X\u0004¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010!R\"\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030(8\u0006X\u0004¢\u0006\f\n\u0004\b)\u0010*\u0012\u0004\b+\u0010!R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140(8\u0006X\u0004¢\u0006\f\n\u0004\b\b\u0010-\u0012\u0004\b.\u0010!R\u001a\u00103\u001a\u0002008\u0002X\u0004¢\u0006\f\n\u0004\b\t\u00101\u0012\u0004\b2\u0010!R$\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00058\u0016@RX\u000e¢\u0006\f\n\u0004\b5\u0010\u0018\u001a\u0004\b)\u0010\u001aR\u0014\u00108\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u00107¨\u0006<"}, d2 = {"Landroidx/room/k0;", "Lt1/l;", "Lt1/k;", "", "query", "", "initArgCount", "", "f", "g", "statement", "b", "index", "B1", "", "value", "f1", "", "K", "P0", "", "l1", "close", "a", "I", "getCapacity", "()I", "capacity", "Ljava/lang/String;", "", "c", "[J", "getLongBindings$annotations", "()V", "longBindings", "", "d", "[D", "getDoubleBindings$annotations", "doubleBindings", "", "e", "[Ljava/lang/String;", "getStringBindings$annotations", "stringBindings", "[[B", "getBlobBindings$annotations", "blobBindings", "", "[I", "getBindingTypes$annotations", "bindingTypes", "<set-?>", "h", "argCount", "()Ljava/lang/String;", "sql", "<init>", "(I)V", "j", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class k0 implements l, k {

    /* renamed from: j  reason: collision with root package name */
    public static final a f6869j = new a((DefaultConstructorMarker) null);

    /* renamed from: k  reason: collision with root package name */
    public static final TreeMap<Integer, k0> f6870k = new TreeMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final int f6871a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f6872b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f6873c;

    /* renamed from: d  reason: collision with root package name */
    public final double[] f6874d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f6875e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[][] f6876f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f6877g;

    /* renamed from: h  reason: collision with root package name */
    private int f6878h;

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\f\n\u0004\b\r\u0010\f\u0012\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00048\u0006XT¢\u0006\f\n\u0004\b\u0012\u0010\f\u0012\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\fR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00158\u0006X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\n¨\u0006\u001a"}, d2 = {"Landroidx/room/k0$a;", "", "", "query", "", "argumentCount", "Landroidx/room/k0;", "a", "", "b", "()V", "BLOB", "I", "DESIRED_POOL_SIZE", "getDESIRED_POOL_SIZE$annotations", "DOUBLE", "LONG", "NULL", "POOL_LIMIT", "getPOOL_LIMIT$annotations", "STRING", "Ljava/util/TreeMap;", "queryPool", "Ljava/util/TreeMap;", "getQueryPool$annotations", "<init>", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k0 a(String str, int i10) {
            j.g(str, "query");
            TreeMap<Integer, k0> treeMap = k0.f6870k;
            synchronized (treeMap) {
                Map.Entry<Integer, k0> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
                if (ceilingEntry != null) {
                    treeMap.remove(ceilingEntry.getKey());
                    k0 value = ceilingEntry.getValue();
                    value.f(str, i10);
                    j.f(value, "sqliteQuery");
                    return value;
                }
                Unit unit = Unit.f32013a;
                k0 k0Var = new k0(i10, (DefaultConstructorMarker) null);
                k0Var.f(str, i10);
                return k0Var;
            }
        }

        public final void b() {
            TreeMap<Integer, k0> treeMap = k0.f6870k;
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                j.f(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i10 = size - 1;
                    if (size > 0) {
                        it.next();
                        it.remove();
                        size = i10;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private k0(int i10) {
        this.f6871a = i10;
        int i11 = i10 + 1;
        this.f6877g = new int[i11];
        this.f6873c = new long[i11];
        this.f6874d = new double[i11];
        this.f6875e = new String[i11];
        this.f6876f = new byte[i11][];
    }

    public /* synthetic */ k0(int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10);
    }

    public static final k0 c(String str, int i10) {
        return f6869j.a(str, i10);
    }

    public void B1(int i10) {
        this.f6877g[i10] = 1;
    }

    public void K(int i10, double d10) {
        this.f6877g[i10] = 3;
        this.f6874d[i10] = d10;
    }

    public void P0(int i10, String str) {
        j.g(str, "value");
        this.f6877g[i10] = 4;
        this.f6875e[i10] = str;
    }

    public String a() {
        String str = this.f6872b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void b(k kVar) {
        j.g(kVar, "statement");
        int e10 = e();
        if (1 <= e10) {
            int i10 = 1;
            while (true) {
                int i11 = this.f6877g[i10];
                if (i11 == 1) {
                    kVar.B1(i10);
                } else if (i11 == 2) {
                    kVar.f1(i10, this.f6873c[i10]);
                } else if (i11 == 3) {
                    kVar.K(i10, this.f6874d[i10]);
                } else if (i11 == 4) {
                    String str = this.f6875e[i10];
                    if (str != null) {
                        kVar.P0(i10, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (i11 == 5) {
                    byte[] bArr = this.f6876f[i10];
                    if (bArr != null) {
                        kVar.l1(i10, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                if (i10 != e10) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void close() {
    }

    public int e() {
        return this.f6878h;
    }

    public final void f(String str, int i10) {
        j.g(str, "query");
        this.f6872b = str;
        this.f6878h = i10;
    }

    public void f1(int i10, long j10) {
        this.f6877g[i10] = 2;
        this.f6873c[i10] = j10;
    }

    public final void g() {
        TreeMap<Integer, k0> treeMap = f6870k;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f6871a), this);
            f6869j.b();
            Unit unit = Unit.f32013a;
        }
    }

    public void l1(int i10, byte[] bArr) {
        j.g(bArr, "value");
        this.f6877g[i10] = 5;
        this.f6876f[i10] = bArr;
    }
}
