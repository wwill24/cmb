package g2;

import android.annotation.SuppressLint;
import androidx.work.WorkInfo;
import androidx.work.b;
import g2.u;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\u0006H'J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H'J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H'J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\n\u001a\u00020\u0006H'J\b\u0010\u001f\u001a\u00020\u001eH'J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0016H'J\b\u0010\"\u001a\u00020\u0010H'J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010#\u001a\u00020\u0010H'J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010%\u001a\u00020\u0010H'J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH'J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH'J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010)\u001a\u00020\u0016H'¨\u0006+"}, d2 = {"Lg2/v;", "", "Lg2/u;", "workSpec", "", "f", "", "id", "a", "h", "name", "", "Lg2/u$b;", "n", "Landroidx/work/WorkInfo$State;", "state", "", "p", "b", "Landroidx/work/b;", "output", "q", "", "enqueueTime", "i", "u", "t", "g", "j", "e", "", "s", "startTime", "m", "l", "schedulerLimit", "o", "maxLimit", "k", "d", "r", "startingAt", "c", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"UnknownNullness"})
public interface v {
    void a(String str);

    void b(String str);

    List<u> c(long j10);

    List<u> d();

    List<String> e(String str);

    void f(u uVar);

    WorkInfo.State g(String str);

    u h(String str);

    void i(String str, long j10);

    List<b> j(String str);

    List<u> k(int i10);

    int l();

    int m(String str, long j10);

    List<u.b> n(String str);

    List<u> o(int i10);

    int p(WorkInfo.State state, String str);

    void q(String str, b bVar);

    List<u> r();

    boolean s();

    int t(String str);

    int u(String str);
}
