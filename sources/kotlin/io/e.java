package kotlin.io;

import com.google.android.gms.common.api.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.sequences.Sequence;

public final class e implements Sequence<File> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final File f32093a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final FileWalkDirection f32094b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Function1<File, Boolean> f32095c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Function1<File, Unit> f32096d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Function2<File, IOException, Unit> f32097e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f32098f;

    private static abstract class a extends c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(file);
            j.g(file, "rootDir");
        }
    }

    private final class b extends kotlin.collections.a<File> {

        /* renamed from: c  reason: collision with root package name */
        private final ArrayDeque<c> f32099c;

        private final class a extends a {

            /* renamed from: b  reason: collision with root package name */
            private boolean f32101b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f32102c;

            /* renamed from: d  reason: collision with root package name */
            private int f32103d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f32104e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b f32105f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, File file) {
                super(file);
                j.g(file, "rootDir");
                this.f32105f = bVar;
            }

            public File b() {
                if (!this.f32104e && this.f32102c == null) {
                    Function1 d10 = e.this.f32095c;
                    boolean z10 = false;
                    if (d10 != null && !((Boolean) d10.invoke(a())).booleanValue()) {
                        z10 = true;
                    }
                    if (z10) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f32102c = listFiles;
                    if (listFiles == null) {
                        Function2 e10 = e.this.f32097e;
                        if (e10 != null) {
                            e10.invoke(a(), new AccessDeniedException(a(), (File) null, "Cannot list files in a directory", 2, (DefaultConstructorMarker) null));
                        }
                        this.f32104e = true;
                    }
                }
                File[] fileArr = this.f32102c;
                if (fileArr != null) {
                    int i10 = this.f32103d;
                    j.d(fileArr);
                    if (i10 < fileArr.length) {
                        File[] fileArr2 = this.f32102c;
                        j.d(fileArr2);
                        int i11 = this.f32103d;
                        this.f32103d = i11 + 1;
                        return fileArr2[i11];
                    }
                }
                if (!this.f32101b) {
                    this.f32101b = true;
                    return a();
                }
                Function1 f10 = e.this.f32096d;
                if (f10 != null) {
                    f10.invoke(a());
                }
                return null;
            }
        }

        /* renamed from: kotlin.io.e$b$b  reason: collision with other inner class name */
        private final class C0369b extends c {

            /* renamed from: b  reason: collision with root package name */
            private boolean f32106b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f32107c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0369b(b bVar, File file) {
                super(file);
                j.g(file, "rootFile");
                this.f32107c = bVar;
            }

            public File b() {
                if (this.f32106b) {
                    return null;
                }
                this.f32106b = true;
                return a();
            }
        }

        private final class c extends a {

            /* renamed from: b  reason: collision with root package name */
            private boolean f32108b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f32109c;

            /* renamed from: d  reason: collision with root package name */
            private int f32110d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ b f32111e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(b bVar, File file) {
                super(file);
                j.g(file, "rootDir");
                this.f32111e = bVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
                if (r0.length == 0) goto L_0x0085;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f32108b
                    r1 = 0
                    if (r0 != 0) goto L_0x002c
                    kotlin.io.e$b r0 = r10.f32111e
                    kotlin.io.e r0 = kotlin.io.e.this
                    kotlin.jvm.functions.Function1 r0 = r0.f32095c
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L_0x0022
                    java.io.File r4 = r10.a()
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L_0x0022
                    r2 = r3
                L_0x0022:
                    if (r2 == 0) goto L_0x0025
                    return r1
                L_0x0025:
                    r10.f32108b = r3
                    java.io.File r0 = r10.a()
                    return r0
                L_0x002c:
                    java.io.File[] r0 = r10.f32109c
                    if (r0 == 0) goto L_0x004b
                    int r2 = r10.f32110d
                    kotlin.jvm.internal.j.d(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L_0x0039
                    goto L_0x004b
                L_0x0039:
                    kotlin.io.e$b r0 = r10.f32111e
                    kotlin.io.e r0 = kotlin.io.e.this
                    kotlin.jvm.functions.Function1 r0 = r0.f32096d
                    if (r0 == 0) goto L_0x004a
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L_0x004a:
                    return r1
                L_0x004b:
                    java.io.File[] r0 = r10.f32109c
                    if (r0 != 0) goto L_0x0097
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f32109c = r0
                    if (r0 != 0) goto L_0x007b
                    kotlin.io.e$b r0 = r10.f32111e
                    kotlin.io.e r0 = kotlin.io.e.this
                    kotlin.jvm.functions.Function2 r0 = r0.f32097e
                    if (r0 == 0) goto L_0x007b
                    java.io.File r2 = r10.a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L_0x007b:
                    java.io.File[] r0 = r10.f32109c
                    if (r0 == 0) goto L_0x0085
                    kotlin.jvm.internal.j.d(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L_0x0097
                L_0x0085:
                    kotlin.io.e$b r0 = r10.f32111e
                    kotlin.io.e r0 = kotlin.io.e.this
                    kotlin.jvm.functions.Function1 r0 = r0.f32096d
                    if (r0 == 0) goto L_0x0096
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L_0x0096:
                    return r1
                L_0x0097:
                    java.io.File[] r0 = r10.f32109c
                    kotlin.jvm.internal.j.d(r0)
                    int r1 = r10.f32110d
                    int r2 = r1 + 1
                    r10.f32110d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.e.b.c.b():java.io.File");
            }
        }

        public /* synthetic */ class d {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f32112a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    kotlin.io.FileWalkDirection[] r0 = kotlin.io.FileWalkDirection.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.TOP_DOWN     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.BOTTOM_UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f32112a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.e.b.d.<clinit>():void");
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f32099c = arrayDeque;
            if (e.this.f32093a.isDirectory()) {
                arrayDeque.push(f(e.this.f32093a));
            } else if (e.this.f32093a.isFile()) {
                arrayDeque.push(new C0369b(this, e.this.f32093a));
            } else {
                c();
            }
        }

        private final a f(File file) {
            int i10 = d.f32112a[e.this.f32094b.ordinal()];
            if (i10 == 1) {
                return new c(this, file);
            }
            if (i10 == 2) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final File g() {
            File b10;
            while (true) {
                c peek = this.f32099c.peek();
                if (peek == null) {
                    return null;
                }
                b10 = peek.b();
                if (b10 == null) {
                    this.f32099c.pop();
                } else if (j.b(b10, peek.a()) || !b10.isDirectory() || this.f32099c.size() >= e.this.f32098f) {
                    return b10;
                } else {
                    this.f32099c.push(f(b10));
                }
            }
            return b10;
        }

        /* access modifiers changed from: protected */
        public void a() {
            File g10 = g();
            if (g10 != null) {
                d(g10);
            } else {
                c();
            }
        }
    }

    private static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        private final File f32113a;

        public c(File file) {
            j.g(file, "root");
            this.f32113a = file;
        }

        public final File a() {
            return this.f32113a;
        }

        public abstract File b();
    }

    private e(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function12, Function2<? super File, ? super IOException, Unit> function2, int i10) {
        this.f32093a = file;
        this.f32094b = fileWalkDirection;
        this.f32095c = function1;
        this.f32096d = function12;
        this.f32097e = function2;
        this.f32098f = i10;
    }

    public Iterator<File> iterator() {
        return new b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ e(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i11 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i11 & 32) != 0 ? a.e.API_PRIORITY_OTHER : i10);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(File file, FileWalkDirection fileWalkDirection) {
        this(file, fileWalkDirection, (Function1) null, (Function1) null, (Function2) null, 0, 32, (DefaultConstructorMarker) null);
        j.g(file, "start");
        j.g(fileWalkDirection, "direction");
    }
}
