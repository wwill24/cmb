package wn;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;

public abstract class k implements Function0<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42500a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k a(String str, j jVar) {
            j.g(str, JingleS5BTransport.ATTR_MODE);
            j.g(jVar, "replaceData");
            if (j.b(str, "all")) {
                return new a(jVar);
            }
            if (q.j(str) != null) {
                return new c(jVar, Integer.parseInt(str));
            }
            throw new IllegalArgumentException(str);
        }
    }

    private k() {
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
