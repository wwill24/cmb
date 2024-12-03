package g2;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0007\u001a\u00020\u0006H'J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¨\u0006\r"}, d2 = {"Lg2/z;", "", "Lg2/y;", "workTag", "", "b", "", "id", "", "a", "", "tags", "c", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public interface z {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static void a(z zVar, String str, Set<String> set) {
            j.g(str, "id");
            j.g(set, "tags");
            for (String yVar : set) {
                zVar.b(new y(yVar, str));
            }
        }
    }

    List<String> a(String str);

    void b(y yVar);

    void c(String str, Set<String> set);
}
