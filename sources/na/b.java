package na;

import java.util.Map;

public interface b {
    static /* synthetic */ void f(b bVar, Map map, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                map = null;
            }
            bVar.e(map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNextInteraction");
    }

    void c();

    void d();

    void e(Map<String, String> map);

    void onError(String str);
}
