package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import net.bytebuddy.pool.TypePool;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    static final e f4692d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f4693e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    private static final String f4694f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    static final a f4695g;

    /* renamed from: h  reason: collision with root package name */
    static final a f4696h;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4697a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4698b;

    /* renamed from: c  reason: collision with root package name */
    private final e f4699c;

    /* renamed from: androidx.core.text.a$a  reason: collision with other inner class name */
    public static final class C0041a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4700a;

        /* renamed from: b  reason: collision with root package name */
        private int f4701b;

        /* renamed from: c  reason: collision with root package name */
        private e f4702c;

        public C0041a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z10) {
            return z10 ? a.f4696h : a.f4695g;
        }

        private void c(boolean z10) {
            this.f4700a = z10;
            this.f4702c = a.f4692d;
            this.f4701b = 2;
        }

        public a a() {
            if (this.f4701b == 2 && this.f4702c == a.f4692d) {
                return b(this.f4700a);
            }
            return new a(this.f4700a, this.f4701b, this.f4702c);
        }
    }

    private static class b {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f4703f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f4704a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f4705b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4706c;

        /* renamed from: d  reason: collision with root package name */
        private int f4707d;

        /* renamed from: e  reason: collision with root package name */
        private char f4708e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f4703f[i10] = Character.getDirectionality(i10);
            }
        }

        b(CharSequence charSequence, boolean z10) {
            this.f4704a = charSequence;
            this.f4705b = z10;
            this.f4706c = charSequence.length();
        }

        private static byte c(char c10) {
            return c10 < 1792 ? f4703f[c10] : Character.getDirectionality(c10);
        }

        private byte f() {
            char charAt;
            int i10 = this.f4707d;
            do {
                int i11 = this.f4707d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f4704a;
                int i12 = i11 - 1;
                this.f4707d = i12;
                charAt = charSequence.charAt(i12);
                this.f4708e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.f4707d = i10;
            this.f4708e = TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
            return 13;
        }

        private byte g() {
            char charAt;
            do {
                int i10 = this.f4707d;
                if (i10 >= this.f4706c) {
                    return 12;
                }
                CharSequence charSequence = this.f4704a;
                this.f4707d = i10 + 1;
                charAt = charSequence.charAt(i10);
                this.f4708e = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte h() {
            char charAt;
            int i10 = this.f4707d;
            while (true) {
                int i11 = this.f4707d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f4704a;
                int i12 = i11 - 1;
                this.f4707d = i12;
                char charAt2 = charSequence.charAt(i12);
                this.f4708e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i13 = this.f4707d;
                        if (i13 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f4704a;
                        int i14 = i13 - 1;
                        this.f4707d = i14;
                        charAt = charSequence2.charAt(i14);
                        this.f4708e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f4707d = i10;
            this.f4708e = '>';
            return 13;
        }

        private byte i() {
            char charAt;
            int i10 = this.f4707d;
            while (true) {
                int i11 = this.f4707d;
                if (i11 < this.f4706c) {
                    CharSequence charSequence = this.f4704a;
                    this.f4707d = i11 + 1;
                    char charAt2 = charSequence.charAt(i11);
                    this.f4708e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i12 = this.f4707d;
                            if (i12 >= this.f4706c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f4704a;
                            this.f4707d = i12 + 1;
                            charAt = charSequence2.charAt(i12);
                            this.f4708e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f4707d = i10;
                    this.f4708e = '<';
                    return 13;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public byte a() {
            char charAt = this.f4704a.charAt(this.f4707d - 1);
            this.f4708e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f4704a, this.f4707d);
                this.f4707d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f4707d--;
            byte c10 = c(this.f4708e);
            if (!this.f4705b) {
                return c10;
            }
            char c11 = this.f4708e;
            if (c11 == '>') {
                return h();
            }
            if (c11 == ';') {
                return f();
            }
            return c10;
        }

        /* access modifiers changed from: package-private */
        public byte b() {
            char charAt = this.f4704a.charAt(this.f4707d);
            this.f4708e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f4704a, this.f4707d);
                this.f4707d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f4707d++;
            byte c10 = c(this.f4708e);
            if (!this.f4705b) {
                return c10;
            }
            char c11 = this.f4708e;
            if (c11 == '<') {
                return i();
            }
            if (c11 == '&') {
                return g();
            }
            return c10;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            this.f4707d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f4707d < this.f4706c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 == 1 || b10 == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (b10 != 9) {
                        switch (b10) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                continue;
                            case 16:
                            case 17:
                                i12++;
                                i11 = 1;
                                continue;
                            case 18:
                                i12--;
                                i11 = 0;
                                continue;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f4707d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case 18:
                        i12++;
                        continue;
                }
                i12--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int e() {
            this.f4707d = this.f4706c;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                while (this.f4707d > 0) {
                    byte a10 = a();
                    if (a10 != 0) {
                        if (a10 == 1 || a10 == 2) {
                            if (i10 == 0) {
                                return 1;
                            }
                            if (i11 == 0) {
                            }
                        } else if (a10 != 9) {
                            switch (a10) {
                                case 14:
                                case 15:
                                    if (i11 == i10) {
                                        return -1;
                                    }
                                    break;
                                case 16:
                                case 17:
                                    if (i11 == i10) {
                                        return 1;
                                    }
                                    break;
                                case 18:
                                    i10++;
                                    break;
                                default:
                                    if (i11 != 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            i10--;
                        } else {
                            continue;
                        }
                    } else if (i10 == 0) {
                        return -1;
                    } else {
                        if (i11 == 0) {
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        e eVar = f.f4724c;
        f4692d = eVar;
        f4695g = new a(false, 2, eVar);
        f4696h = new a(true, 2, eVar);
    }

    a(boolean z10, int i10, e eVar) {
        this.f4697a = z10;
        this.f4698b = i10;
        this.f4699c = eVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0041a().a();
    }

    static boolean e(Locale locale) {
        return g.a(locale) == 1;
    }

    private String f(CharSequence charSequence, e eVar) {
        boolean isRtl = eVar.isRtl(charSequence, 0, charSequence.length());
        if (!this.f4697a && (isRtl || b(charSequence) == 1)) {
            return f4693e;
        }
        if (!this.f4697a) {
            return "";
        }
        if (!isRtl || b(charSequence) == -1) {
            return f4694f;
        }
        return "";
    }

    private String g(CharSequence charSequence, e eVar) {
        boolean isRtl = eVar.isRtl(charSequence, 0, charSequence.length());
        if (!this.f4697a && (isRtl || a(charSequence) == 1)) {
            return f4693e;
        }
        if (!this.f4697a) {
            return "";
        }
        if (!isRtl || a(charSequence) == -1) {
            return f4694f;
        }
        return "";
    }

    public boolean d() {
        return (this.f4698b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f4699c, true);
    }

    public CharSequence i(CharSequence charSequence, e eVar, boolean z10) {
        e eVar2;
        char c10;
        e eVar3;
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = eVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            if (isRtl) {
                eVar3 = f.f4723b;
            } else {
                eVar3 = f.f4722a;
            }
            spannableStringBuilder.append(g(charSequence, eVar3));
        }
        if (isRtl != this.f4697a) {
            if (isRtl) {
                c10 = 8235;
            } else {
                c10 = 8234;
            }
            spannableStringBuilder.append(c10);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            if (isRtl) {
                eVar2 = f.f4723b;
            } else {
                eVar2 = f.f4722a;
            }
            spannableStringBuilder.append(f(charSequence, eVar2));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f4699c, true);
    }

    public String k(String str, e eVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return i(str, eVar, z10).toString();
    }
}
