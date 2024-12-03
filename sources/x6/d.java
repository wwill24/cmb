package x6;

import kotlin.jvm.internal.DefaultConstructorMarker;

public class d<DbType> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18563a;

    /* renamed from: b  reason: collision with root package name */
    private final DbType f18564b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f18565c;

    public d() {
        this(false, (Object) null, (Throwable) null, 7, (DefaultConstructorMarker) null);
    }

    public d(boolean z10, DbType dbtype, Throwable th2) {
        this.f18563a = z10;
        this.f18564b = dbtype;
        this.f18565c = th2;
    }

    public final boolean a() {
        return this.f18563a;
    }

    public final DbType b() {
        return this.f18564b;
    }

    public final Throwable c() {
        return this.f18565c;
    }

    public final DbType d() {
        return this.f18564b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(boolean z10, Object obj, Throwable th2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : obj, (i10 & 4) != 0 ? null : th2);
    }
}
