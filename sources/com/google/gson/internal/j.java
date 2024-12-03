package com.google.gson.internal;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import mg.o;

public final class j {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.google.gson.JsonIOException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.google.gson.k.f21376a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: MalformedJsonException (r2v4 'e' com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.gson.j a(com.google.gson.stream.JsonReader r2) throws com.google.gson.JsonParseException {
        /*
            r2.peek()     // Catch:{ EOFException -> 0x0024, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.google.gson.q<com.google.gson.j> r1 = mg.o.V     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.b(r2)     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.google.gson.j r2 = (com.google.gson.j) r2     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.google.gson.k r2 = com.google.gson.k.f21376a
            return r2
        L_0x002b:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.j.a(com.google.gson.stream.JsonReader):com.google.gson.j");
    }

    public static void b(com.google.gson.j jVar, JsonWriter jsonWriter) throws IOException {
        o.V.d(jsonWriter, jVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    private static final class b extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f21366a;

        /* renamed from: b  reason: collision with root package name */
        private final a f21367b = new a();

        private static class a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            private char[] f21368a;

            /* renamed from: b  reason: collision with root package name */
            private String f21369b;

            private a() {
            }

            /* access modifiers changed from: package-private */
            public void a(char[] cArr) {
                this.f21368a = cArr;
                this.f21369b = null;
            }

            public char charAt(int i10) {
                return this.f21368a[i10];
            }

            public int length() {
                return this.f21368a.length;
            }

            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f21368a, i10, i11 - i10);
            }

            public String toString() {
                if (this.f21369b == null) {
                    this.f21369b = new String(this.f21368a);
                }
                return this.f21369b;
            }
        }

        b(Appendable appendable) {
            this.f21366a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i10, int i11) throws IOException {
            this.f21367b.a(cArr);
            this.f21366a.append(this.f21367b, i10, i11 + i10);
        }

        public Writer append(CharSequence charSequence) throws IOException {
            this.f21366a.append(charSequence);
            return this;
        }

        public void write(int i10) throws IOException {
            this.f21366a.append((char) i10);
        }

        public Writer append(CharSequence charSequence, int i10, int i11) throws IOException {
            this.f21366a.append(charSequence, i10, i11);
            return this;
        }

        public void write(String str, int i10, int i11) throws IOException {
            Objects.requireNonNull(str);
            this.f21366a.append(str, i10, i11 + i10);
        }
    }
}
