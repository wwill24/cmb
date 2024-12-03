package b2;

import android.annotation.SuppressLint;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.c;
import g2.u;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000 \n2\u00020\u0001:\u0002\u0003\bB'\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0013¨\u0006\u0017"}, d2 = {"Lb2/n;", "", "Ljava/util/UUID;", "a", "Ljava/util/UUID;", "()Ljava/util/UUID;", "id", "Lg2/u;", "b", "Lg2/u;", "d", "()Lg2/u;", "workSpec", "", "", "c", "Ljava/util/Set;", "()Ljava/util/Set;", "tags", "()Ljava/lang/String;", "stringId", "<init>", "(Ljava/util/UUID;Lg2/u;Ljava/util/Set;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class n {

    /* renamed from: d  reason: collision with root package name */
    public static final b f7746d = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final UUID f7747a;

    /* renamed from: b  reason: collision with root package name */
    private final u f7748b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f7749c;

    @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0000*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\u0019\b\u0000\u0012\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014¢\u0006\u0004\b6\u00107J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00028\u0001H ¢\u0006\u0004\b\u0013\u0010\u0012R\"\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00148\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020&8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\"\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u00102\u001a\b\u0012\u0004\u0012\u00020.0-8\u0000X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b/\u00101R\u0014\u00105\u001a\u00028\u00008 X \u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lb2/n$a;", "B", "Lb2/n;", "W", "", "Ljava/util/UUID;", "id", "i", "(Ljava/util/UUID;)Lb2/n$a;", "Landroidx/work/b;", "inputData", "j", "(Landroidx/work/b;)Lb2/n$a;", "Landroidx/work/OutOfQuotaPolicy;", "policy", "h", "(Landroidx/work/OutOfQuotaPolicy;)Lb2/n$a;", "a", "()Lb2/n;", "b", "Ljava/lang/Class;", "Landroidx/work/c;", "Ljava/lang/Class;", "getWorkerClass$work_runtime_release", "()Ljava/lang/Class;", "workerClass", "", "Z", "c", "()Z", "setBackoffCriteriaSet$work_runtime_release", "(Z)V", "backoffCriteriaSet", "Ljava/util/UUID;", "d", "()Ljava/util/UUID;", "setId$work_runtime_release", "(Ljava/util/UUID;)V", "Lg2/u;", "Lg2/u;", "g", "()Lg2/u;", "setWorkSpec$work_runtime_release", "(Lg2/u;)V", "workSpec", "", "", "e", "Ljava/util/Set;", "()Ljava/util/Set;", "tags", "f", "()Lb2/n$a;", "thisObject", "<init>", "(Ljava/lang/Class;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class a<B extends a<B, ?>, W extends n> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<? extends c> f7750a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7751b;

        /* renamed from: c  reason: collision with root package name */
        private UUID f7752c;

        /* renamed from: d  reason: collision with root package name */
        private u f7753d;

        /* renamed from: e  reason: collision with root package name */
        private final Set<String> f7754e;

        public a(Class<? extends c> cls) {
            j.g(cls, "workerClass");
            this.f7750a = cls;
            UUID randomUUID = UUID.randomUUID();
            j.f(randomUUID, "randomUUID()");
            this.f7752c = randomUUID;
            String uuid = this.f7752c.toString();
            j.f(uuid, "id.toString()");
            String name = cls.getName();
            j.f(name, "workerClass.name");
            this.f7753d = new u(uuid, name);
            String name2 = cls.getName();
            j.f(name2, "workerClass.name");
            this.f7754e = n0.g(name2);
        }

        public final W a() {
            boolean z10;
            W b10 = b();
            a aVar = this.f7753d.f15086j;
            boolean z11 = false;
            if (aVar.e() || aVar.f() || aVar.g() || aVar.h()) {
                z10 = true;
            } else {
                z10 = false;
            }
            u uVar = this.f7753d;
            if (uVar.f15093q) {
                if (!z10) {
                    if (uVar.f15083g <= 0) {
                        z11 = true;
                    }
                    if (!z11) {
                        throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
                }
            }
            UUID randomUUID = UUID.randomUUID();
            j.f(randomUUID, "randomUUID()");
            i(randomUUID);
            return b10;
        }

        public abstract W b();

        public final boolean c() {
            return this.f7751b;
        }

        public final UUID d() {
            return this.f7752c;
        }

        public final Set<String> e() {
            return this.f7754e;
        }

        public abstract B f();

        public final u g() {
            return this.f7753d;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public B h(OutOfQuotaPolicy outOfQuotaPolicy) {
            j.g(outOfQuotaPolicy, "policy");
            u uVar = this.f7753d;
            uVar.f15093q = true;
            uVar.f15094r = outOfQuotaPolicy;
            return f();
        }

        public final B i(UUID uuid) {
            j.g(uuid, "id");
            this.f7752c = uuid;
            String uuid2 = uuid.toString();
            j.f(uuid2, "id.toString()");
            this.f7753d = new u(uuid2, this.f7753d);
            return f();
        }

        public final B j(androidx.work.b bVar) {
            j.g(bVar, "inputData");
            this.f7753d.f15081e = bVar;
            return f();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lb2/n$b;", "", "", "DEFAULT_BACKOFF_DELAY_MILLIS", "J", "MAX_BACKOFF_MILLIS", "MIN_BACKOFF_MILLIS", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public n(UUID uuid, u uVar, Set<String> set) {
        j.g(uuid, "id");
        j.g(uVar, "workSpec");
        j.g(set, "tags");
        this.f7747a = uuid;
        this.f7748b = uVar;
        this.f7749c = set;
    }

    public UUID a() {
        return this.f7747a;
    }

    public final String b() {
        String uuid = a().toString();
        j.f(uuid, "id.toString()");
        return uuid;
    }

    public final Set<String> c() {
        return this.f7749c;
    }

    public final u d() {
        return this.f7748b;
    }
}
