package tm;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public abstract class a implements d {

    /* renamed from: c  reason: collision with root package name */
    protected static final Logger f33875c = Logger.getLogger(a.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final String f33876a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33877b;

    protected a(String str, int i10) {
        this.f33876a = str;
        this.f33877b = i10;
    }

    protected static List<String> b(Collection<? extends InetAddress> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (InetAddress hostAddress : collection) {
            arrayList.add(hostAddress.getHostAddress());
        }
        return arrayList;
    }

    /* renamed from: a */
    public final int compareTo(d dVar) {
        return Integer.compare(getPriority(), dVar.getPriority());
    }

    public final String getName() {
        return this.f33876a;
    }

    public final int getPriority() {
        return this.f33877b;
    }
}
