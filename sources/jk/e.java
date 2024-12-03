package jk;

import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.Comparator;
import kotlin.jvm.internal.j;

final class e implements Comparator<Comparable<? super Object>> {

    /* renamed from: a  reason: collision with root package name */
    public static final e f31890a = new e();

    private e() {
    }

    /* renamed from: a */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        j.g(comparable, "a");
        j.g(comparable2, NetworkProfile.BISEXUAL);
        return comparable.compareTo(comparable2);
    }

    public final Comparator<Comparable<Object>> reversed() {
        return f.f31891a;
    }
}
