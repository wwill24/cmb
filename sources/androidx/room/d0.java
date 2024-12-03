package androidx.room;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import t1.k;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00138\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u001a"}, d2 = {"Landroidx/room/d0;", "Lt1/k;", "", "bindIndex", "", "value", "", "b", "index", "B1", "", "f1", "", "K", "", "P0", "", "l1", "close", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "bindArgsCache", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class d0 implements k {

    /* renamed from: a  reason: collision with root package name */
    private final List<Object> f6828a = new ArrayList();

    private final void b(int i10, Object obj) {
        int size;
        int i11 = i10 - 1;
        if (i11 >= this.f6828a.size() && (size = this.f6828a.size()) <= i11) {
            while (true) {
                this.f6828a.add((Object) null);
                if (size == i11) {
                    break;
                }
                size++;
            }
        }
        this.f6828a.set(i11, obj);
    }

    public void B1(int i10) {
        b(i10, (Object) null);
    }

    public void K(int i10, double d10) {
        b(i10, Double.valueOf(d10));
    }

    public void P0(int i10, String str) {
        j.g(str, "value");
        b(i10, str);
    }

    public final List<Object> a() {
        return this.f6828a;
    }

    public void close() {
    }

    public void f1(int i10, long j10) {
        b(i10, Long.valueOf(j10));
    }

    public void l1(int i10, byte[] bArr) {
        j.g(bArr, "value");
        b(i10, bArr);
    }
}
