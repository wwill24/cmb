package g2;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH'J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH'J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H'¨\u0006\u0013"}, d2 = {"Lg2/j;", "", "Lg2/i;", "systemIdInfo", "", "b", "", "workSpecId", "", "generation", "d", "Lg2/m;", "id", "c", "f", "g", "a", "", "e", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public interface j {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static i a(j jVar, m mVar) {
            kotlin.jvm.internal.j.g(mVar, "id");
            return jVar.d(mVar.b(), mVar.a());
        }

        public static void b(j jVar, m mVar) {
            kotlin.jvm.internal.j.g(mVar, "id");
            jVar.f(mVar.b(), mVar.a());
        }
    }

    void a(m mVar);

    void b(i iVar);

    i c(m mVar);

    i d(String str, int i10);

    List<String> e();

    void f(String str, int i10);

    void g(String str);
}
