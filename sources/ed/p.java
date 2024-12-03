package ed;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import ed.d;

public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(Priority priority);
    }

    public static a a() {
        return new d.b().d(Priority.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract Priority d();

    public boolean e() {
        return c() != null;
    }

    public p f(Priority priority) {
        return a().b(b()).d(priority).c(c()).a();
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        if (c() == null) {
            str = "";
        } else {
            str = Base64.encodeToString(c(), 2);
        }
        objArr[2] = str;
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
