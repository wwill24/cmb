package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import i3.b;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

public final class GlideException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement[] f9286a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private b key;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void a(Throwable th2, List<Throwable> list) {
        if (th2 instanceof GlideException) {
            for (Throwable a10 : ((GlideException) th2).e()) {
                a(a10, list);
            }
            return;
        }
        list.add(th2);
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            appendable.append("Cause (").append(String.valueOf(i11)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th2 = list.get(i10);
            if (th2 instanceof GlideException) {
                ((GlideException) th2).h(appendable);
            } else {
                d(th2, appendable);
            }
            i10 = i11;
        }
    }

    private static void d(Throwable th2, Appendable appendable) {
        try {
            appendable.append(th2.getClass().toString()).append(": ").append(th2.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th2);
        }
    }

    private void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new a(appendable));
    }

    public List<Throwable> e() {
        return this.causes;
    }

    public List<Throwable> f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public void g(String str) {
        List<Throwable> f10 = f();
        int size = f10.size();
        int i10 = 0;
        while (i10 < size) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Root cause (");
            int i11 = i10 + 1;
            sb2.append(i11);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(")");
            Throwable th2 = f10.get(i10);
            i10 = i11;
        }
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.detailMessage);
        String str3 = "";
        if (this.dataClass != null) {
            str = ", " + this.dataClass;
        } else {
            str = str3;
        }
        sb2.append(str);
        if (this.dataSource != null) {
            str2 = ", " + this.dataSource;
        } else {
            str2 = str3;
        }
        sb2.append(str2);
        if (this.key != null) {
            str3 = ", " + this.key;
        }
        sb2.append(str3);
        List<Throwable> f10 = f();
        if (f10.isEmpty()) {
            return sb2.toString();
        }
        if (f10.size() == 1) {
            sb2.append("\nThere was 1 cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(f10.size());
            sb2.append(" causes:");
        }
        for (Throwable next : f10) {
            sb2.append(10);
            sb2.append(next.getClass().getName());
            sb2.append(PropertyUtils.MAPPED_DELIM);
            sb2.append(next.getMessage());
            sb2.append(PropertyUtils.MAPPED_DELIM2);
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public void i(b bVar, DataSource dataSource2) {
        j(bVar, dataSource2, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public void j(b bVar, DataSource dataSource2, Class<?> cls) {
        this.key = bVar;
        this.dataSource = dataSource2;
        this.dataClass = cls;
    }

    public void k(Exception exc) {
        this.exception = exc;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th2) {
        this(str, (List<Throwable>) Collections.singletonList(th2));
    }

    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(f9286a);
        this.causes = list;
    }

    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    private static final class a implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f9287a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9288b = true;

        a(Appendable appendable) {
            this.f9287a = appendable;
        }

        @NonNull
        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(char c10) throws IOException {
            boolean z10 = false;
            if (this.f9288b) {
                this.f9288b = false;
                this.f9287a.append("  ");
            }
            if (c10 == 10) {
                z10 = true;
            }
            this.f9288b = z10;
            this.f9287a.append(c10);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a10 = a(charSequence);
            return append(a10, 0, a10.length());
        }

        public Appendable append(CharSequence charSequence, int i10, int i11) throws IOException {
            CharSequence a10 = a(charSequence);
            boolean z10 = false;
            if (this.f9288b) {
                this.f9288b = false;
                this.f9287a.append("  ");
            }
            if (a10.length() > 0 && a10.charAt(i11 - 1) == 10) {
                z10 = true;
            }
            this.f9288b = z10;
            this.f9287a.append(a10, i10, i11);
            return this;
        }
    }
}
