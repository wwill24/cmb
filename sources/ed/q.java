package ed;

import cd.b;
import cd.d;
import cd.e;
import cd.f;
import java.util.Set;

final class q implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f40751a;

    /* renamed from: b  reason: collision with root package name */
    private final p f40752b;

    /* renamed from: c  reason: collision with root package name */
    private final t f40753c;

    q(Set<b> set, p pVar, t tVar) {
        this.f40751a = set;
        this.f40752b = pVar;
        this.f40753c = tVar;
    }

    public <T> e<T> a(String str, Class<T> cls, b bVar, d<T, byte[]> dVar) {
        if (this.f40751a.contains(bVar)) {
            return new s(this.f40752b, str, bVar, dVar, this.f40753c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{bVar, this.f40751a}));
    }
}
