package qe;

import android.os.Looper;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ClassLoader f41805a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Thread f41806b;

    public static synchronized ClassLoader a() {
        ClassLoader classLoader;
        synchronized (b.class) {
            if (f41805a == null) {
                f41805a = b();
            }
            classLoader = f41805a;
        }
        return classLoader;
    }

    private static synchronized ClassLoader b() {
        synchronized (b.class) {
            ClassLoader classLoader = null;
            if (f41806b == null) {
                f41806b = c();
                if (f41806b == null) {
                    return null;
                }
            }
            synchronized (f41806b) {
                try {
                    classLoader = f41806b.getContextClassLoader();
                } catch (SecurityException e10) {
                    String message = e10.getMessage();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get thread context classloader ");
                    sb2.append(message);
                }
            }
            return classLoader;
        }
    }

    private static synchronized Thread c() {
        a aVar;
        a aVar2;
        SecurityException e10;
        ThreadGroup threadGroup;
        synchronized (b.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= activeGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i11];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i11++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i10 >= activeCount) {
                            aVar = null;
                            break;
                        }
                        aVar = threadArr[i10];
                        if ("GmsDynamite".equals(aVar.getName())) {
                            break;
                        }
                        i10++;
                    }
                    if (aVar == null) {
                        try {
                            aVar2 = new a(threadGroup, "GmsDynamite");
                            try {
                                aVar2.setContextClassLoader((ClassLoader) null);
                                aVar2.start();
                            } catch (SecurityException e11) {
                                e10 = e11;
                            }
                        } catch (SecurityException e12) {
                            e10 = e12;
                            aVar2 = aVar;
                            String message = e10.getMessage();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to enumerate thread/threadgroup ");
                            sb2.append(message);
                            aVar = aVar2;
                            return aVar;
                        }
                        aVar = aVar2;
                    }
                } catch (SecurityException e13) {
                    e10 = e13;
                    aVar2 = null;
                    String message2 = e10.getMessage();
                    StringBuilder sb22 = new StringBuilder();
                    sb22.append("Failed to enumerate thread/threadgroup ");
                    sb22.append(message2);
                    aVar = aVar2;
                    return aVar;
                }
            }
            return aVar;
        }
    }
}
