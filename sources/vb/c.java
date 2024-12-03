package vb;

import com.leanplum.internal.Constants;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f42056a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f42057b;

    /* renamed from: c  reason: collision with root package name */
    private List<d> f42058c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42059d;

    /* renamed from: e  reason: collision with root package name */
    private final String f42060e;

    /* renamed from: f  reason: collision with root package name */
    private final int f42061f;

    public c(List<String> list, List<b> list2, List<d> list3, String str, String str2, int i10) {
        j.g(list, "intents");
        j.g(list2, "benefits");
        j.g(list3, Constants.Keys.VARIANTS);
        j.g(str, "id");
        j.g(str2, "name");
        this.f42056a = list;
        this.f42057b = list2;
        this.f42058c = list3;
        this.f42059d = str;
        this.f42060e = str2;
        this.f42061f = i10;
    }

    private final d j(String str) {
        T t10;
        Iterator<T> it = this.f42058c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (j.b(((d) t10).h(), str)) {
                break;
            }
        }
        return (d) t10;
    }

    public final List<b> a() {
        return this.f42057b;
    }

    public final String b() {
        return this.f42059d;
    }

    public final d c(boolean z10) {
        if (z10) {
            Iterator<T> it = this.f42058c.iterator();
            if (it.hasNext()) {
                T next = it.next();
                if (it.hasNext()) {
                    BigDecimal j10 = ((d) next).j();
                    do {
                        T next2 = it.next();
                        BigDecimal j11 = ((d) next2).j();
                        if (j10.compareTo(j11) > 0) {
                            next = next2;
                            j10 = j11;
                        }
                    } while (it.hasNext());
                }
                return (d) next;
            }
            throw new NoSuchElementException();
        }
        Iterator<T> it2 = this.f42058c.iterator();
        if (it2.hasNext()) {
            T next3 = it2.next();
            if (it2.hasNext()) {
                BigDecimal b10 = ((d) next3).b();
                do {
                    T next4 = it2.next();
                    BigDecimal b11 = ((d) next4).b();
                    if (b10.compareTo(b11) > 0) {
                        next3 = next4;
                        b10 = b11;
                    }
                } while (it2.hasNext());
            }
            return (d) next3;
        }
        throw new NoSuchElementException();
    }

    public final String d() {
        return this.f42060e;
    }

    public final d e() {
        T t10;
        Iterator<T> it = this.f42058c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (((d) t10).k()) {
                break;
            }
        }
        return (d) t10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j.b(this.f42056a, cVar.f42056a) && j.b(this.f42057b, cVar.f42057b) && j.b(this.f42058c, cVar.f42058c) && j.b(this.f42059d, cVar.f42059d) && j.b(this.f42060e, cVar.f42060e) && this.f42061f == cVar.f42061f;
    }

    public final int f() {
        String str;
        d e10 = e();
        if (e10 == null || (str = e10.g()) == null) {
            str = "";
        }
        d j10 = j(str);
        if (e10 == null || j10 == null) {
            return 0;
        }
        return 100 - ((int) (((e10.b().floatValue() * ((float) e10.d())) / (j10.b().floatValue() * ((float) e10.d()))) * ((float) 100)));
    }

    public final long g() {
        d e10 = e();
        if (e10 != null) {
            return e10.f();
        }
        return 0;
    }

    public final d h() {
        String str;
        d e10 = e();
        if (e10 == null || (str = e10.g()) == null) {
            str = "";
        }
        return j(str);
    }

    public int hashCode() {
        return (((((((((this.f42056a.hashCode() * 31) + this.f42057b.hashCode()) * 31) + this.f42058c.hashCode()) * 31) + this.f42059d.hashCode()) * 31) + this.f42060e.hashCode()) * 31) + Integer.hashCode(this.f42061f);
    }

    public final int i() {
        return this.f42061f;
    }

    public final List<d> k() {
        return this.f42058c;
    }

    public final boolean l() {
        T t10;
        Iterator<T> it = this.f42058c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (((d) t10).k()) {
                break;
            }
        }
        if (t10 != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "SubscriptionBundle(intents=" + this.f42056a + ", benefits=" + this.f42057b + ", variants=" + this.f42058c + ", id=" + this.f42059d + ", name=" + this.f42060e + ", tier=" + this.f42061f + PropertyUtils.MAPPED_DELIM2;
    }
}
