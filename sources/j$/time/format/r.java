package j$.time.format;

enum r implements C0529g {
    SENSITIVE,
    INSENSITIVE,
    STRICT,
    LENIENT;

    public final boolean b(A a10, StringBuilder sb2) {
        return true;
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            xVar.m(true);
        } else if (ordinal == 1) {
            xVar.m(false);
        } else if (ordinal == 2) {
            xVar.q(true);
        } else if (ordinal == 3) {
            xVar.q(false);
        }
        return i10;
    }

    public final String toString() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return "ParseCaseSensitive(true)";
        }
        if (ordinal == 1) {
            return "ParseCaseSensitive(false)";
        }
        if (ordinal == 2) {
            return "ParseStrict(true)";
        }
        if (ordinal == 3) {
            return "ParseStrict(false)";
        }
        throw new IllegalStateException("Unreachable");
    }
}
