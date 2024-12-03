package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lokhttp3/p;", "", "", "hostname", "", "Ljava/net/InetAddress;", "lookup", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33154a = a.f33156a;

    /* renamed from: b  reason: collision with root package name */
    public static final p f33155b = new a.C0380a();

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lokhttp3/p$a;", "", "Lokhttp3/p;", "SYSTEM", "Lokhttp3/p;", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f33156a = new a();

        @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lokhttp3/p$a$a;", "Lokhttp3/p;", "", "hostname", "", "Ljava/net/InetAddress;", "lookup", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: okhttp3.p$a$a  reason: collision with other inner class name */
        private static final class C0380a implements p {
            public List<InetAddress> lookup(String str) {
                j.g(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    j.f(allByName, "getAllByName(hostname)");
                    return l.p0(allByName);
                } catch (NullPointerException e10) {
                    UnknownHostException unknownHostException = new UnknownHostException(j.p("Broken system behaviour for dns lookup of ", str));
                    unknownHostException.initCause(e10);
                    throw unknownHostException;
                }
            }
        }

        private a() {
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
