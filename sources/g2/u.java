package g2;

import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import b2.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b/\b\b\u0018\u0000 L2\u00020\u0001:\u0003&(\u0003BÍ\u0001\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u0015¢\u0006\u0004\bF\u0010GB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010H\u001a\u00020\u0006¢\u0006\u0004\bF\u0010IB\u0019\b\u0016\u0012\u0006\u0010J\u001a\u00020\u0006\u0012\u0006\u0010$\u001a\u00020\u0000¢\u0006\u0004\bF\u0010KJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016JÓ\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0003\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u0015HÆ\u0001J\t\u0010#\u001a\u00020\u0015HÖ\u0001J\u0013\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0014\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\"\u0010'R\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010.R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b6\u0010.R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b7\u0010.R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b8\u0010.R\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b9\u0010.R\u0016\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010 \u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u00103\u001a\u0004\b-\u0010?\"\u0004\b@\u0010AR\u001a\u0010!\u001a\u00020\u00158\u0006X\u0004¢\u0006\f\n\u0004\bB\u00103\u001a\u0004\b,\u0010?R\u0011\u0010D\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b0\u0010CR\u0011\u0010E\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b/\u0010C¨\u0006M"}, d2 = {"Lg2/u;", "", "", "c", "", "h", "", "toString", "id", "Landroidx/work/WorkInfo$State;", "state", "workerClassName", "inputMergerClassName", "Landroidx/work/b;", "input", "output", "initialDelay", "intervalDuration", "flexDuration", "Lb2/a;", "constraints", "", "runAttemptCount", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "expedited", "Landroidx/work/OutOfQuotaPolicy;", "outOfQuotaPolicy", "periodCount", "generation", "d", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "b", "Landroidx/work/WorkInfo$State;", "e", "Landroidx/work/b;", "f", "g", "J", "i", "j", "Lb2/a;", "k", "I", "l", "Landroidx/work/BackoffPolicy;", "m", "n", "o", "p", "q", "Z", "r", "Landroidx/work/OutOfQuotaPolicy;", "s", "()I", "setPeriodCount", "(I)V", "t", "()Z", "isPeriodic", "isBackedOff", "<init>", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/b;Landroidx/work/b;JJJLb2/a;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;II)V", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "(Ljava/lang/String;Lg2/u;)V", "u", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class u {

    /* renamed from: u  reason: collision with root package name */
    public static final a f15074u = new a((DefaultConstructorMarker) null);

    /* renamed from: v  reason: collision with root package name */
    private static final String f15075v;

    /* renamed from: w  reason: collision with root package name */
    public static final k.a<List<c>, List<WorkInfo>> f15076w = new t();

    /* renamed from: a  reason: collision with root package name */
    public final String f15077a;

    /* renamed from: b  reason: collision with root package name */
    public WorkInfo.State f15078b;

    /* renamed from: c  reason: collision with root package name */
    public String f15079c;

    /* renamed from: d  reason: collision with root package name */
    public String f15080d;

    /* renamed from: e  reason: collision with root package name */
    public androidx.work.b f15081e;

    /* renamed from: f  reason: collision with root package name */
    public androidx.work.b f15082f;

    /* renamed from: g  reason: collision with root package name */
    public long f15083g;

    /* renamed from: h  reason: collision with root package name */
    public long f15084h;

    /* renamed from: i  reason: collision with root package name */
    public long f15085i;

    /* renamed from: j  reason: collision with root package name */
    public b2.a f15086j;

    /* renamed from: k  reason: collision with root package name */
    public int f15087k;

    /* renamed from: l  reason: collision with root package name */
    public BackoffPolicy f15088l;

    /* renamed from: m  reason: collision with root package name */
    public long f15089m;

    /* renamed from: n  reason: collision with root package name */
    public long f15090n;

    /* renamed from: o  reason: collision with root package name */
    public long f15091o;

    /* renamed from: p  reason: collision with root package name */
    public long f15092p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f15093q;

    /* renamed from: r  reason: collision with root package name */
    public OutOfQuotaPolicy f15094r;

    /* renamed from: s  reason: collision with root package name */
    private int f15095s;

    /* renamed from: t  reason: collision with root package name */
    private final int f15096t;

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R,\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lg2/u$a;", "", "", "SCHEDULE_NOT_REQUESTED_YET", "J", "", "TAG", "Ljava/lang/String;", "Lk/a;", "", "Lg2/u$c;", "Landroidx/work/WorkInfo;", "WORK_INFO_MAPPER", "Lk/a;", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lg2/u$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "id", "Landroidx/work/WorkInfo$State;", "b", "Landroidx/work/WorkInfo$State;", "state", "<init>", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f15097a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f15098b;

        public b(String str, WorkInfo.State state) {
            j.g(str, "id");
            j.g(state, "state");
            this.f15097a = str;
            this.f15098b = state;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return j.b(this.f15097a, bVar.f15097a) && this.f15098b == bVar.f15098b;
        }

        public int hashCode() {
            return (this.f15097a.hashCode() * 31) + this.f15098b.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.f15097a + ", state=" + this.f15098b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\f\b\b\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010*\u001a\u00020\u00068\u0006X\u0004¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040+8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00106\u001a\b\u0012\u0004\u0012\u00020\u00190+8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101¨\u00067"}, d2 = {"Lg2/u$c;", "", "Landroidx/work/WorkInfo;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "Landroidx/work/WorkInfo$State;", "b", "Landroidx/work/WorkInfo$State;", "getState", "()Landroidx/work/WorkInfo$State;", "setState", "(Landroidx/work/WorkInfo$State;)V", "state", "Landroidx/work/b;", "c", "Landroidx/work/b;", "getOutput", "()Landroidx/work/b;", "setOutput", "(Landroidx/work/b;)V", "output", "d", "I", "getRunAttemptCount", "()I", "setRunAttemptCount", "(I)V", "runAttemptCount", "e", "getGeneration", "generation", "", "f", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "tags", "g", "getProgress", "setProgress", "progress", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private String f15099a;

        /* renamed from: b  reason: collision with root package name */
        private WorkInfo.State f15100b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.work.b f15101c;

        /* renamed from: d  reason: collision with root package name */
        private int f15102d;

        /* renamed from: e  reason: collision with root package name */
        private final int f15103e;

        /* renamed from: f  reason: collision with root package name */
        private List<String> f15104f;

        /* renamed from: g  reason: collision with root package name */
        private List<androidx.work.b> f15105g;

        public final WorkInfo a() {
            androidx.work.b bVar;
            if (!this.f15105g.isEmpty()) {
                bVar = this.f15105g.get(0);
            } else {
                bVar = androidx.work.b.f7398c;
            }
            return new WorkInfo(UUID.fromString(this.f15099a), this.f15100b, this.f15101c, this.f15104f, bVar, this.f15102d, this.f15103e);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return j.b(this.f15099a, cVar.f15099a) && this.f15100b == cVar.f15100b && j.b(this.f15101c, cVar.f15101c) && this.f15102d == cVar.f15102d && this.f15103e == cVar.f15103e && j.b(this.f15104f, cVar.f15104f) && j.b(this.f15105g, cVar.f15105g);
        }

        public int hashCode() {
            return (((((((((((this.f15099a.hashCode() * 31) + this.f15100b.hashCode()) * 31) + this.f15101c.hashCode()) * 31) + Integer.hashCode(this.f15102d)) * 31) + Integer.hashCode(this.f15103e)) * 31) + this.f15104f.hashCode()) * 31) + this.f15105g.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.f15099a + ", state=" + this.f15100b + ", output=" + this.f15101c + ", runAttemptCount=" + this.f15102d + ", generation=" + this.f15103e + ", tags=" + this.f15104f + ", progress=" + this.f15105g + PropertyUtils.MAPPED_DELIM2;
        }
    }

    static {
        String i10 = f.i("WorkSpec");
        j.f(i10, "tagWithPrefix(\"WorkSpec\")");
        f15075v = i10;
    }

    public u(String str, WorkInfo.State state, String str2, String str3, androidx.work.b bVar, androidx.work.b bVar2, long j10, long j11, long j12, b2.a aVar, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12) {
        androidx.work.b bVar3 = bVar2;
        b2.a aVar2 = aVar;
        BackoffPolicy backoffPolicy2 = backoffPolicy;
        OutOfQuotaPolicy outOfQuotaPolicy2 = outOfQuotaPolicy;
        j.g(str, "id");
        j.g(state, "state");
        j.g(str2, "workerClassName");
        j.g(bVar, "input");
        j.g(bVar3, "output");
        j.g(aVar2, "constraints");
        j.g(backoffPolicy2, "backoffPolicy");
        j.g(outOfQuotaPolicy2, "outOfQuotaPolicy");
        this.f15077a = str;
        this.f15078b = state;
        this.f15079c = str2;
        this.f15080d = str3;
        this.f15081e = bVar;
        this.f15082f = bVar3;
        this.f15083g = j10;
        this.f15084h = j11;
        this.f15085i = j12;
        this.f15086j = aVar2;
        this.f15087k = i10;
        this.f15088l = backoffPolicy2;
        this.f15089m = j13;
        this.f15090n = j14;
        this.f15091o = j15;
        this.f15092p = j16;
        this.f15093q = z10;
        this.f15094r = outOfQuotaPolicy2;
        this.f15095s = i11;
        this.f15096t = i12;
    }

    /* access modifiers changed from: private */
    public static final List b(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((c) it.next()).a());
        }
        return arrayList;
    }

    public static /* synthetic */ u e(u uVar, String str, WorkInfo.State state, String str2, String str3, androidx.work.b bVar, androidx.work.b bVar2, long j10, long j11, long j12, b2.a aVar, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12, int i13, Object obj) {
        u uVar2 = uVar;
        int i14 = i13;
        return uVar.d((i14 & 1) != 0 ? uVar2.f15077a : str, (i14 & 2) != 0 ? uVar2.f15078b : state, (i14 & 4) != 0 ? uVar2.f15079c : str2, (i14 & 8) != 0 ? uVar2.f15080d : str3, (i14 & 16) != 0 ? uVar2.f15081e : bVar, (i14 & 32) != 0 ? uVar2.f15082f : bVar2, (i14 & 64) != 0 ? uVar2.f15083g : j10, (i14 & 128) != 0 ? uVar2.f15084h : j11, (i14 & 256) != 0 ? uVar2.f15085i : j12, (i14 & 512) != 0 ? uVar2.f15086j : aVar, (i14 & 1024) != 0 ? uVar2.f15087k : i10, (i14 & 2048) != 0 ? uVar2.f15088l : backoffPolicy, (i14 & Opcodes.ACC_SYNTHETIC) != 0 ? uVar2.f15089m : j13, (i14 & 8192) != 0 ? uVar2.f15090n : j14, (i14 & Opcodes.ACC_ENUM) != 0 ? uVar2.f15091o : j15, (i14 & 32768) != 0 ? uVar2.f15092p : j16, (i14 & 65536) != 0 ? uVar2.f15093q : z10, (131072 & i14) != 0 ? uVar2.f15094r : outOfQuotaPolicy, (i14 & Opcodes.ASM4) != 0 ? uVar2.f15095s : i11, (i14 & Opcodes.ASM8) != 0 ? uVar2.f15096t : i12);
    }

    public final long c() {
        long j10;
        boolean z10 = false;
        if (i()) {
            if (this.f15088l == BackoffPolicy.LINEAR) {
                z10 = true;
            }
            if (z10) {
                j10 = this.f15089m * ((long) this.f15087k);
            } else {
                j10 = (long) Math.scalb((float) this.f15089m, this.f15087k - 1);
            }
            return this.f15090n + j.h(j10, 18000000);
        }
        long j11 = 0;
        if (j()) {
            int i10 = this.f15095s;
            long j12 = this.f15090n;
            if (i10 == 0) {
                j12 += this.f15083g;
            }
            long j13 = this.f15085i;
            long j14 = this.f15084h;
            if (j13 != j14) {
                z10 = true;
            }
            if (z10) {
                if (i10 == 0) {
                    j11 = ((long) -1) * j13;
                }
                j12 += j14;
            } else if (i10 != 0) {
                j11 = j14;
            }
            return j12 + j11;
        }
        long j15 = this.f15090n;
        if (j15 == 0) {
            j15 = System.currentTimeMillis();
        }
        return this.f15083g + j15;
    }

    public final u d(String str, WorkInfo.State state, String str2, String str3, androidx.work.b bVar, androidx.work.b bVar2, long j10, long j11, long j12, b2.a aVar, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12) {
        String str4 = str;
        j.g(str4, "id");
        j.g(state, "state");
        j.g(str2, "workerClassName");
        j.g(bVar, "input");
        j.g(bVar2, "output");
        j.g(aVar, "constraints");
        j.g(backoffPolicy, "backoffPolicy");
        j.g(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new u(str4, state, str2, str3, bVar, bVar2, j10, j11, j12, aVar, i10, backoffPolicy, j13, j14, j15, j16, z10, outOfQuotaPolicy, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return j.b(this.f15077a, uVar.f15077a) && this.f15078b == uVar.f15078b && j.b(this.f15079c, uVar.f15079c) && j.b(this.f15080d, uVar.f15080d) && j.b(this.f15081e, uVar.f15081e) && j.b(this.f15082f, uVar.f15082f) && this.f15083g == uVar.f15083g && this.f15084h == uVar.f15084h && this.f15085i == uVar.f15085i && j.b(this.f15086j, uVar.f15086j) && this.f15087k == uVar.f15087k && this.f15088l == uVar.f15088l && this.f15089m == uVar.f15089m && this.f15090n == uVar.f15090n && this.f15091o == uVar.f15091o && this.f15092p == uVar.f15092p && this.f15093q == uVar.f15093q && this.f15094r == uVar.f15094r && this.f15095s == uVar.f15095s && this.f15096t == uVar.f15096t;
    }

    public final int f() {
        return this.f15096t;
    }

    public final int g() {
        return this.f15095s;
    }

    public final boolean h() {
        return !j.b(b2.a.f7723j, this.f15086j);
    }

    public int hashCode() {
        int hashCode = ((((this.f15077a.hashCode() * 31) + this.f15078b.hashCode()) * 31) + this.f15079c.hashCode()) * 31;
        String str = this.f15080d;
        int hashCode2 = (((((((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f15081e.hashCode()) * 31) + this.f15082f.hashCode()) * 31) + Long.hashCode(this.f15083g)) * 31) + Long.hashCode(this.f15084h)) * 31) + Long.hashCode(this.f15085i)) * 31) + this.f15086j.hashCode()) * 31) + Integer.hashCode(this.f15087k)) * 31) + this.f15088l.hashCode()) * 31) + Long.hashCode(this.f15089m)) * 31) + Long.hashCode(this.f15090n)) * 31) + Long.hashCode(this.f15091o)) * 31) + Long.hashCode(this.f15092p)) * 31;
        boolean z10 = this.f15093q;
        if (z10) {
            z10 = true;
        }
        return ((((((hashCode2 + (z10 ? 1 : 0)) * 31) + this.f15094r.hashCode()) * 31) + Integer.hashCode(this.f15095s)) * 31) + Integer.hashCode(this.f15096t);
    }

    public final boolean i() {
        return this.f15078b == WorkInfo.State.ENQUEUED && this.f15087k > 0;
    }

    public final boolean j() {
        return this.f15084h != 0;
    }

    public String toString() {
        return "{WorkSpec: " + this.f15077a + '}';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ u(java.lang.String r31, androidx.work.WorkInfo.State r32, java.lang.String r33, java.lang.String r34, androidx.work.b r35, androidx.work.b r36, long r37, long r39, long r41, b2.a r43, int r44, androidx.work.BackoffPolicy r45, long r46, long r48, long r50, long r52, boolean r54, androidx.work.OutOfQuotaPolicy r55, int r56, int r57, int r58, kotlin.jvm.internal.DefaultConstructorMarker r59) {
        /*
            r30 = this;
            r0 = r58
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.ENQUEUED
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r32
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0013
            r1 = 0
            r6 = r1
            goto L_0x0015
        L_0x0013:
            r6 = r34
        L_0x0015:
            r1 = r0 & 16
            java.lang.String r2 = "EMPTY"
            if (r1 == 0) goto L_0x0022
            androidx.work.b r1 = androidx.work.b.f7398c
            kotlin.jvm.internal.j.f(r1, r2)
            r7 = r1
            goto L_0x0024
        L_0x0022:
            r7 = r35
        L_0x0024:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002f
            androidx.work.b r1 = androidx.work.b.f7398c
            kotlin.jvm.internal.j.f(r1, r2)
            r8 = r1
            goto L_0x0031
        L_0x002f:
            r8 = r36
        L_0x0031:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0039
            r9 = r2
            goto L_0x003b
        L_0x0039:
            r9 = r37
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r39
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0049
            r13 = r2
            goto L_0x004b
        L_0x0049:
            r13 = r41
        L_0x004b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0053
            b2.a r1 = b2.a.f7723j
            r15 = r1
            goto L_0x0055
        L_0x0053:
            r15 = r43
        L_0x0055:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r5 = 0
            if (r1 == 0) goto L_0x005d
            r16 = r5
            goto L_0x005f
        L_0x005d:
            r16 = r44
        L_0x005f:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0068
            androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
            r17 = r1
            goto L_0x006a
        L_0x0068:
            r17 = r45
        L_0x006a:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0071
            r18 = 30000(0x7530, double:1.4822E-319)
            goto L_0x0073
        L_0x0071:
            r18 = r46
        L_0x0073:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007a
            r20 = r2
            goto L_0x007c
        L_0x007a:
            r20 = r48
        L_0x007c:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0083
            r22 = r2
            goto L_0x0085
        L_0x0083:
            r22 = r50
        L_0x0085:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0090
            r1 = -1
            r24 = r1
            goto L_0x0092
        L_0x0090:
            r24 = r52
        L_0x0092:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009a
            r26 = r5
            goto L_0x009c
        L_0x009a:
            r26 = r54
        L_0x009c:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a6
            androidx.work.OutOfQuotaPolicy r1 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST
            r27 = r1
            goto L_0x00a8
        L_0x00a6:
            r27 = r55
        L_0x00a8:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b0
            r28 = r5
            goto L_0x00b2
        L_0x00b0:
            r28 = r56
        L_0x00b2:
            r1 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00ba
            r29 = r5
            goto L_0x00bc
        L_0x00ba:
            r29 = r57
        L_0x00bc:
            r2 = r30
            r3 = r31
            r5 = r33
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.u.<init>(java.lang.String, androidx.work.WorkInfo$State, java.lang.String, java.lang.String, androidx.work.b, androidx.work.b, long, long, long, b2.a, int, androidx.work.BackoffPolicy, long, long, long, long, boolean, androidx.work.OutOfQuotaPolicy, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u(String str, String str2) {
        this(str, (WorkInfo.State) null, str2, (String) null, (androidx.work.b) null, (androidx.work.b) null, 0, 0, 0, (b2.a) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 1048570, (DefaultConstructorMarker) null);
        j.g(str, "id");
        j.g(str2, "workerClassName_");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public u(java.lang.String r34, g2.u r35) {
        /*
            r33 = this;
            r0 = r35
            r1 = r33
            r2 = r34
            java.lang.String r3 = "newId"
            r4 = r34
            kotlin.jvm.internal.j.g(r4, r3)
            java.lang.String r3 = "other"
            kotlin.jvm.internal.j.g(r0, r3)
            java.lang.String r4 = r0.f15079c
            androidx.work.WorkInfo$State r3 = r0.f15078b
            java.lang.String r5 = r0.f15080d
            androidx.work.b r7 = new androidx.work.b
            r6 = r7
            androidx.work.b r8 = r0.f15081e
            r7.<init>((androidx.work.b) r8)
            androidx.work.b r8 = new androidx.work.b
            r7 = r8
            androidx.work.b r9 = r0.f15082f
            r8.<init>((androidx.work.b) r9)
            long r8 = r0.f15083g
            long r10 = r0.f15084h
            long r12 = r0.f15085i
            b2.a r15 = new b2.a
            r14 = r15
            r31 = r1
            b2.a r1 = r0.f15086j
            r15.<init>(r1)
            int r15 = r0.f15087k
            androidx.work.BackoffPolicy r1 = r0.f15088l
            r16 = r1
            r32 = r2
            long r1 = r0.f15089m
            r17 = r1
            long r1 = r0.f15090n
            r19 = r1
            long r1 = r0.f15091o
            r21 = r1
            long r1 = r0.f15092p
            r23 = r1
            boolean r1 = r0.f15093q
            r25 = r1
            androidx.work.OutOfQuotaPolicy r1 = r0.f15094r
            r26 = r1
            int r0 = r0.f15095s
            r27 = r0
            r28 = 0
            r29 = 524288(0x80000, float:7.34684E-40)
            r30 = 0
            r1 = r31
            r2 = r32
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.u.<init>(java.lang.String, g2.u):void");
    }
}
