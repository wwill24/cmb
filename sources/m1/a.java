package m1;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.j;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<b<?>, Object> f16278a = new LinkedHashMap();

    /* renamed from: m1.a$a  reason: collision with other inner class name */
    public static final class C0171a extends a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0171a f16279b = new C0171a();

        private C0171a() {
        }

        public <T> T a(b<T> bVar) {
            j.g(bVar, SDKConstants.PARAM_KEY);
            return null;
        }
    }

    public interface b<T> {
    }

    public abstract <T> T a(b<T> bVar);

    public final Map<b<?>, Object> b() {
        return this.f16278a;
    }
}
