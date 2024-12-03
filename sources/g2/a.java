package g2;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u000b"}, d2 = {"Lg2/a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "workSpecId", "prerequisiteId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f15028a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15029b;

    public a(String str, String str2) {
        j.g(str, "workSpecId");
        j.g(str2, "prerequisiteId");
        this.f15028a = str;
        this.f15029b = str2;
    }

    public final String a() {
        return this.f15029b;
    }

    public final String b() {
        return this.f15028a;
    }
}
