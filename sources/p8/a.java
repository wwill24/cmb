package p8;

import java.util.Collection;
import kotlin.jvm.internal.j;
import org.jxmpp.jid.Jid;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Collection<Jid> f17048a;

    public final Collection<Jid> a() {
        return this.f17048a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && j.b(this.f17048a, ((a) obj).f17048a);
    }

    public int hashCode() {
        return this.f17048a.hashCode();
    }

    public String toString() {
        Collection<Jid> collection = this.f17048a;
        return "MongooseJob(addresses=" + collection + ")";
    }
}
