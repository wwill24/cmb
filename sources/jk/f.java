package jk;

import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.Comparator;
import kotlin.jvm.internal.j;

final class f implements Comparator<Comparable<? super Object>> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f31891a = new f();

    private f() {
    }

    /* renamed from: a */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        j.g(comparable, "a");
        j.g(comparable2, NetworkProfile.BISEXUAL);
        return comparable2.compareTo(comparable);
    }

    public final Comparator<Comparable<Object>> reversed() {
        return e.f31890a;
    }
}
