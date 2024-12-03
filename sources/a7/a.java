package a7;

import android.content.Intent;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.Map;

public interface a {
    void a(NetworkProfile networkProfile);

    void b(String str);

    void c(String str, String str2);

    void d(String str);

    String e(String str);

    void f(String str);

    void g(String str);

    void h(Map<String, String> map);

    @Deprecated
    void i(String str);

    @Deprecated
    void j(String str, Map<String, String> map);

    void k(Intent intent);

    void logout();

    void trackEvent(String str, Map<String, String> map);
}
