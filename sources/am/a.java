package am;

public abstract class a extends r {
    /* access modifiers changed from: protected */
    public void j(r rVar) {
        if (rVar instanceof a) {
            super.j(rVar);
            return;
        }
        throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
    }

    /* renamed from: m */
    public a f() {
        return (a) super.f();
    }
}
