package io.sentry;

import io.sentry.protocol.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class z3 {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f31841a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f31842b;

    public z3(List<String> list, List<String> list2) {
        this.f31841a = list;
        this.f31842b = list2;
    }

    public List<s> a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (!className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    s sVar = new s();
                    sVar.r(b(className));
                    sVar.t(className);
                    sVar.q(stackTraceElement.getMethodName());
                    sVar.p(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sVar.s(Integer.valueOf(stackTraceElement.getLineNumber()));
                    }
                    sVar.u(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                    arrayList.add(sVar);
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Boolean b(String str) {
        if (str == null || str.isEmpty()) {
            return Boolean.TRUE;
        }
        List<String> list = this.f31842b;
        if (list != null) {
            for (String startsWith : list) {
                if (str.startsWith(startsWith)) {
                    return Boolean.TRUE;
                }
            }
        }
        List<String> list2 = this.f31841a;
        if (list2 == null) {
            return null;
        }
        for (String startsWith2 : list2) {
            if (str.startsWith(startsWith2)) {
                return Boolean.FALSE;
            }
        }
        return null;
    }
}
