package okhttp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\n"}, d2 = {"Lokhttp3/m;", "", "Lokhttp3/t;", "url", "", "Lokhttp3/l;", "cookies", "", "b", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface m {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33143a = a.f33145a;

    /* renamed from: b  reason: collision with root package name */
    public static final m f33144b = new a.C0379a();

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lokhttp3/m$a;", "", "Lokhttp3/m;", "NO_COOKIES", "Lokhttp3/m;", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f33145a = new a();

        @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lokhttp3/m$a$a;", "Lokhttp3/m;", "Lokhttp3/t;", "url", "", "Lokhttp3/l;", "cookies", "", "b", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: okhttp3.m$a$a  reason: collision with other inner class name */
        private static final class C0379a implements m {
            public List<l> a(t tVar) {
                j.g(tVar, "url");
                return q.j();
            }

            public void b(t tVar, List<l> list) {
                j.g(tVar, "url");
                j.g(list, "cookies");
            }
        }

        private a() {
        }
    }

    List<l> a(t tVar);

    void b(t tVar, List<l> list);
}
