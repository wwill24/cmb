package q8;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.mparticle.MParticle;
import java.util.Map;

public interface a {
    void a(NetworkProfile networkProfile);

    void b(String str);

    void c(String str, MParticle.EventType eventType, Map<String, String> map);

    void d(String str);

    void e(String str);

    void logout();

    void setUserAttribute(String str, Object obj);
}
