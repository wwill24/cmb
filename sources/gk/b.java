package gk;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.j;

class b {
    public static void a(Throwable th2, Throwable th3) {
        j.g(th2, "<this>");
        j.g(th3, "exception");
        if (th2 != th3) {
            kk.b.f32004a.a(th2, th3);
        }
    }

    public static String b(Throwable th2) {
        j.g(th2, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        j.f(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
