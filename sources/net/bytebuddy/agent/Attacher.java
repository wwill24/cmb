package net.bytebuddy.agent;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import net.bytebuddy.agent.utility.nullability.MaybeNull;

public class Attacher {
    public static final String DUMP_PROPERTY = "net.bytebuddy.agent.attacher.dump";

    private Attacher() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    protected static void install(Class<?> cls, String str, String str2, boolean z10, @MaybeNull String str3) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str4;
        Class<String> cls2 = String.class;
        Object invoke = cls.getMethod("attach", new Class[]{cls2}).invoke((Object) null, new Object[]{str});
        if (z10) {
            str4 = "loadAgentPath";
        } else {
            str4 = "loadAgent";
        }
        try {
            cls.getMethod(str4, new Class[]{cls2, cls2}).invoke(invoke, new Object[]{str2, str3});
        } finally {
            cls.getMethod("detach", new Class[0]).invoke(invoke, new Object[0]);
        }
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
    public static void main(String[] strArr) {
        PrintStream printStream;
        String str;
        try {
            if (strArr.length >= 5) {
                if (strArr[4].length() != 0) {
                    StringBuilder sb2 = new StringBuilder(strArr[4].substring(1));
                    for (int i10 = 5; i10 < strArr.length; i10++) {
                        sb2.append(' ');
                        sb2.append(strArr[i10]);
                    }
                    str = sb2.toString();
                    install(Class.forName(strArr[0]), strArr[1], strArr[2], Boolean.parseBoolean(strArr[3]), str);
                    return;
                }
            }
            str = null;
            install(Class.forName(strArr[0]), strArr[1], strArr[2], Boolean.parseBoolean(strArr[3]), str);
            return;
        } catch (Throwable th2) {
            printStream.close();
            throw th2;
        }
        System.exit(1);
    }
}
