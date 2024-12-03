package j$.time.format;

public abstract /* synthetic */ class G {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f42616a = {1, 2, 3, 4, 5};

    public static /* synthetic */ int a(int i10) {
        if (i10 != 0) {
            return i10 - 1;
        }
        throw null;
    }

    public static /* synthetic */ String b(int i10) {
        return i10 == 1 ? "NORMAL" : i10 == 2 ? "ALWAYS" : i10 == 3 ? "NEVER" : i10 == 4 ? "NOT_NEGATIVE" : i10 == 5 ? "EXCEEDS_PAD" : "null";
    }

    public static /* synthetic */ int[] c(int i10) {
        int[] iArr = new int[i10];
        System.arraycopy(f42616a, 0, iArr, 0, i10);
        return iArr;
    }
}
