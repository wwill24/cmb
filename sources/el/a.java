package el;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u0014\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lel/a;", "", "", "f", "Lel/d;", "queue", "", "e", "(Lel/d;)V", "", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "", "Z", "()Z", "cancelable", "c", "Lel/d;", "d", "()Lel/d;", "setQueue$okhttp", "J", "()J", "g", "(J)V", "nextExecuteNanoTime", "<init>", "(Ljava/lang/String;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f29616a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29617b;

    /* renamed from: c  reason: collision with root package name */
    private d f29618c;

    /* renamed from: d  reason: collision with root package name */
    private long f29619d;

    public a(String str, boolean z10) {
        j.g(str, "name");
        this.f29616a = str;
        this.f29617b = z10;
        this.f29619d = -1;
    }

    public final boolean a() {
        return this.f29617b;
    }

    public final String b() {
        return this.f29616a;
    }

    public final long c() {
        return this.f29619d;
    }

    public final d d() {
        return this.f29618c;
    }

    public final void e(d dVar) {
        boolean z10;
        j.g(dVar, "queue");
        d dVar2 = this.f29618c;
        if (dVar2 != dVar) {
            if (dVar2 == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f29618c = dVar;
                return;
            }
            throw new IllegalStateException("task is in multiple queues".toString());
        }
    }

    public abstract long f();

    public final void g(long j10) {
        this.f29619d = j10;
    }

    public String toString() {
        return this.f29616a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}
