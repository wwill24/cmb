package eh;

import java.util.Comparator;
import java.util.Map;

public final /* synthetic */ class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f23396a = new c();

    private /* synthetic */ c() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
    }
}
