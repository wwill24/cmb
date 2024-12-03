package androidx.room;

import kotlin.Metadata;
import net.bytebuddy.implementation.MethodDelegation;
import t1.j;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/room/d;", "Lt1/j$c;", "Lt1/j$b;", "configuration", "Landroidx/room/AutoClosingRoomOpenHelper;", "b", "a", "Lt1/j$c;", "delegate", "Landroidx/room/c;", "Landroidx/room/c;", "autoCloser", "<init>", "(Lt1/j$c;Landroidx/room/c;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class d implements j.c {

    /* renamed from: a  reason: collision with root package name */
    private final j.c f6826a;

    /* renamed from: b  reason: collision with root package name */
    private final c f6827b;

    public d(j.c cVar, c cVar2) {
        kotlin.jvm.internal.j.g(cVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        kotlin.jvm.internal.j.g(cVar2, "autoCloser");
        this.f6826a = cVar;
        this.f6827b = cVar2;
    }

    /* renamed from: b */
    public AutoClosingRoomOpenHelper a(j.b bVar) {
        kotlin.jvm.internal.j.g(bVar, "configuration");
        return new AutoClosingRoomOpenHelper(this.f6826a.a(bVar), this.f6827b);
    }
}
