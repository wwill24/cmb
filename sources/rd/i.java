package rd;

import java.util.Comparator;

final class i implements Comparator<m> {
    i(j jVar) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((m) obj).getClass().getCanonicalName().compareTo(((m) obj2).getClass().getCanonicalName());
    }
}
