package com.facebook.bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/bolts/AggregateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "detailMessage", "", "innerThrowables", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "printStackTrace", "", "err", "Ljava/io/PrintStream;", "Ljava/io/PrintWriter;", "Companion", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AggregateException extends Exception {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 1;
    private final List<Throwable> innerThrowables;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/bolts/AggregateException$Companion;", "", "()V", "serialVersionUID", "", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AggregateException(java.lang.String r2, java.util.List<? extends java.lang.Throwable> r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0012
            boolean r0 = r3.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0012
            r0 = 0
            java.lang.Object r0 = r3.get(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            r1.<init>(r2, r0)
            if (r3 != 0) goto L_0x001c
            java.util.List r3 = kotlin.collections.q.j()
        L_0x001c:
            java.util.List r2 = java.util.Collections.unmodifiableList(r3)
            java.lang.String r3 = "unmodifiableList(innerThrowables ?: emptyList())"
            kotlin.jvm.internal.j.f(r2, r3)
            r1.innerThrowables = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bolts.AggregateException.<init>(java.lang.String, java.util.List):void");
    }

    public void printStackTrace(PrintStream printStream) {
        j.g(printStream, "err");
        super.printStackTrace(printStream);
        int i10 = -1;
        for (Throwable next : this.innerThrowables) {
            printStream.append("\n");
            printStream.append("  Inner throwable #");
            i10++;
            printStream.append(String.valueOf(i10));
            printStream.append(": ");
            if (next != null) {
                next.printStackTrace(printStream);
            }
            printStream.append("\n");
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        j.g(printWriter, "err");
        super.printStackTrace(printWriter);
        int i10 = -1;
        for (Throwable next : this.innerThrowables) {
            printWriter.append("\n");
            printWriter.append("  Inner throwable #");
            i10++;
            printWriter.append(String.valueOf(i10));
            printWriter.append(": ");
            if (next != null) {
                next.printStackTrace(printWriter);
            }
            printWriter.append("\n");
        }
    }
}
