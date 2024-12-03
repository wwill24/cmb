package j$.time.format;

final class n extends o {
    n() {
        super("", (String) null, (o) null, 0);
    }

    private n(String str, String str2, o oVar) {
        super(str, str2, oVar, 0);
    }

    /* access modifiers changed from: protected */
    public final boolean c(char c10, char c11) {
        return x.c(c10, c11);
    }

    /* access modifiers changed from: protected */
    public final o e(String str, String str2, o oVar) {
        return new n(str, str2, oVar);
    }

    /* access modifiers changed from: protected */
    public final boolean h(CharSequence charSequence, int i10, int i11) {
        int length = this.f42651a.length();
        if (length > i11 - i10) {
            return false;
        }
        int i12 = 0;
        while (true) {
            int i13 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i14 = i12 + 1;
            int i15 = i10 + 1;
            if (!x.c(this.f42651a.charAt(i12), charSequence.charAt(i10))) {
                return false;
            }
            i10 = i15;
            length = i13;
            i12 = i14;
        }
    }
}
