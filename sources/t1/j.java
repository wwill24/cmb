package t1;

import android.content.Context;
import com.facebook.appevents.UserDataStore;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\b\u0010\u0006\u001a\u00020\u0004H&R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lt1/j;", "Ljava/io/Closeable;", "", "enabled", "", "setWriteAheadLoggingEnabled", "close", "", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Lt1/i;", "n1", "()Lt1/i;", "writableDatabase", "a", "b", "c", "sqlite_release"}, k = 1, mv = {1, 7, 1})
public interface j extends Closeable {

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b&\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011¨\u0006\u0015"}, d2 = {"Lt1/j$a;", "", "", "fileName", "", "a", "Lt1/i;", "db", "b", "d", "", "oldVersion", "newVersion", "g", "e", "f", "c", "I", "version", "<init>", "(I)V", "sqlite_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0205a f17634b = new C0205a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final int f17635a;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lt1/j$a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sqlite_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: t1.j$a$a  reason: collision with other inner class name */
        public static final class C0205a {
            private C0205a() {
            }

            public /* synthetic */ C0205a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(int i10) {
            this.f17635a = i10;
        }

        private final void a(String str) {
            int i10;
            boolean z10;
            boolean z11 = true;
            if (!r.t(str, ":memory:", true)) {
                int length = str.length() - 1;
                int i11 = 0;
                boolean z12 = false;
                while (i11 <= length) {
                    if (!z12) {
                        i10 = i11;
                    } else {
                        i10 = length;
                    }
                    if (kotlin.jvm.internal.j.i(str.charAt(i10), 32) <= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z12) {
                        if (!z10) {
                            z12 = true;
                        } else {
                            i11++;
                        }
                    } else if (!z10) {
                        break;
                    } else {
                        length--;
                    }
                }
                if (str.subSequence(i11, length + 1).toString().length() != 0) {
                    z11 = false;
                }
                if (!z11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("deleting the database file: ");
                    sb2.append(str);
                    try {
                        b.a(new File(str));
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public void b(i iVar) {
            kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
            if (r1 != null) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
            r4 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            if (r4.hasNext() != false) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
            r1 = ((android.util.Pair) r4.next()).second;
            kotlin.jvm.internal.j.f(r1, "p.second");
            a((java.lang.String) r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
            r4 = r4.getPath();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
            if (r4 != null) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
            a(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0031 */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002f A[ExcHandler: all (r2v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
          PHI: (r1v10 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:6:0x002a, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:6:0x002a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(t1.i r4) {
            /*
                r3 = this;
                java.lang.String r0 = "p.second"
                java.lang.String r1 = "db"
                kotlin.jvm.internal.j.g(r4, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Corruption reported by sqlite on database: "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r2 = ".path"
                r1.append(r2)
                boolean r1 = r4.isOpen()
                if (r1 != 0) goto L_0x0029
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0028
                r3.a(r4)
            L_0x0028:
                return
            L_0x0029:
                r1 = 0
                java.util.List r1 = r4.A()     // Catch:{ SQLiteException -> 0x0031, all -> 0x002f }
                goto L_0x0031
            L_0x002f:
                r2 = move-exception
                goto L_0x0035
            L_0x0031:
                r4.close()     // Catch:{ IOException -> 0x005c, all -> 0x002f }
                goto L_0x005c
            L_0x0035:
                if (r1 == 0) goto L_0x0052
                java.util.Iterator r4 = r1.iterator()
            L_0x003b:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x005b
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.j.f(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.a(r1)
                goto L_0x003b
            L_0x0052:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x005b
                r3.a(r4)
            L_0x005b:
                throw r2
            L_0x005c:
                if (r1 == 0) goto L_0x0079
                java.util.Iterator r4 = r1.iterator()
            L_0x0062:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x0082
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.j.f(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.a(r1)
                goto L_0x0062
            L_0x0079:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0082
                r3.a(r4)
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t1.j.a.c(t1.i):void");
        }

        public abstract void d(i iVar);

        public abstract void e(i iVar, int i10, int i11);

        public void f(i iVar) {
            kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        }

        public abstract void g(i iVar, int i10, int i11);
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0002\u0003\u0007B5\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0017"}, d2 = {"Lt1/j$b;", "", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "name", "Lt1/j$a;", "c", "Lt1/j$a;", "callback", "", "d", "Z", "useNoBackupDirectory", "e", "allowDataLossOnRecovery", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lt1/j$a;ZZ)V", "f", "sqlite_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {

        /* renamed from: f  reason: collision with root package name */
        public static final C0206b f17636f = new C0206b((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final Context f17637a;

        /* renamed from: b  reason: collision with root package name */
        public final String f17638b;

        /* renamed from: c  reason: collision with root package name */
        public final a f17639c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f17640d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f17641e;

        @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0014¨\u0006\u0017"}, d2 = {"Lt1/j$b$a;", "", "Lt1/j$b;", "b", "", "name", "d", "Lt1/j$a;", "callback", "c", "", "useNoBackupDirectory", "e", "allowDataLossOnRecovery", "a", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Ljava/lang/String;", "Lt1/j$a;", "Z", "<init>", "(Landroid/content/Context;)V", "sqlite_release"}, k = 1, mv = {1, 7, 1})
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private final Context f17642a;

            /* renamed from: b  reason: collision with root package name */
            private String f17643b;

            /* renamed from: c  reason: collision with root package name */
            private a f17644c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f17645d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f17646e;

            public a(Context context) {
                kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
                this.f17642a = context;
            }

            public a a(boolean z10) {
                this.f17646e = z10;
                return this;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
                if (r0 == false) goto L_0x001a;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public t1.j.b b() {
                /*
                    r7 = this;
                    t1.j$a r3 = r7.f17644c
                    if (r3 == 0) goto L_0x0038
                    boolean r0 = r7.f17645d
                    r1 = 0
                    r2 = 1
                    if (r0 == 0) goto L_0x001a
                    java.lang.String r0 = r7.f17643b
                    if (r0 == 0) goto L_0x0017
                    int r0 = r0.length()
                    if (r0 != 0) goto L_0x0015
                    goto L_0x0017
                L_0x0015:
                    r0 = r1
                    goto L_0x0018
                L_0x0017:
                    r0 = r2
                L_0x0018:
                    if (r0 != 0) goto L_0x001b
                L_0x001a:
                    r1 = r2
                L_0x001b:
                    if (r1 == 0) goto L_0x002c
                    t1.j$b r6 = new t1.j$b
                    android.content.Context r1 = r7.f17642a
                    java.lang.String r2 = r7.f17643b
                    boolean r4 = r7.f17645d
                    boolean r5 = r7.f17646e
                    r0 = r6
                    r0.<init>(r1, r2, r3, r4, r5)
                    return r6
                L_0x002c:
                    java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                    java.lang.String r1 = "Must set a non-null database name to a configuration that uses the no backup directory."
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                L_0x0038:
                    java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                    java.lang.String r1 = "Must set a callback to create the configuration."
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: t1.j.b.a.b():t1.j$b");
            }

            public a c(a aVar) {
                kotlin.jvm.internal.j.g(aVar, "callback");
                this.f17644c = aVar;
                return this;
            }

            public a d(String str) {
                this.f17643b = str;
                return this;
            }

            public a e(boolean z10) {
                this.f17645d = z10;
                return this;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lt1/j$b$b;", "", "Landroid/content/Context;", "context", "Lt1/j$b$a;", "a", "<init>", "()V", "sqlite_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: t1.j$b$b  reason: collision with other inner class name */
        public static final class C0206b {
            private C0206b() {
            }

            public /* synthetic */ C0206b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(Context context) {
                kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
                return new a(context);
            }
        }

        public b(Context context, String str, a aVar, boolean z10, boolean z11) {
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            kotlin.jvm.internal.j.g(aVar, "callback");
            this.f17637a = context;
            this.f17638b = str;
            this.f17639c = aVar;
            this.f17640d = z10;
            this.f17641e = z11;
        }

        public static final a a(Context context) {
            return f17636f.a(context);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lt1/j$c;", "", "Lt1/j$b;", "configuration", "Lt1/j;", "a", "sqlite_release"}, k = 1, mv = {1, 7, 1})
    public interface c {
        j a(b bVar);
    }

    void close();

    String getDatabaseName();

    i n1();

    void setWriteAheadLoggingEnabled(boolean z10);
}
