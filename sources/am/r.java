package am;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    private r f18891a = null;

    /* renamed from: b  reason: collision with root package name */
    private r f18892b = null;

    /* renamed from: c  reason: collision with root package name */
    private r f18893c = null;

    /* renamed from: d  reason: collision with root package name */
    private r f18894d = null;

    /* renamed from: e  reason: collision with root package name */
    private r f18895e = null;

    public abstract void a(y yVar);

    public void b(r rVar) {
        rVar.l();
        rVar.j(this);
        r rVar2 = this.f18893c;
        if (rVar2 != null) {
            rVar2.f18895e = rVar;
            rVar.f18894d = rVar2;
            this.f18893c = rVar;
            return;
        }
        this.f18892b = rVar;
        this.f18893c = rVar;
    }

    public r c() {
        return this.f18892b;
    }

    public r d() {
        return this.f18893c;
    }

    public r e() {
        return this.f18895e;
    }

    public r f() {
        return this.f18891a;
    }

    public r g() {
        return this.f18894d;
    }

    public void h(r rVar) {
        rVar.l();
        r rVar2 = this.f18895e;
        rVar.f18895e = rVar2;
        if (rVar2 != null) {
            rVar2.f18894d = rVar;
        }
        rVar.f18894d = this;
        this.f18895e = rVar;
        r rVar3 = this.f18891a;
        rVar.f18891a = rVar3;
        if (rVar.f18895e == null) {
            rVar3.f18893c = rVar;
        }
    }

    public void i(r rVar) {
        rVar.l();
        r rVar2 = this.f18894d;
        rVar.f18894d = rVar2;
        if (rVar2 != null) {
            rVar2.f18895e = rVar;
        }
        rVar.f18895e = this;
        this.f18894d = rVar;
        r rVar3 = this.f18891a;
        rVar.f18891a = rVar3;
        if (rVar.f18894d == null) {
            rVar3.f18892b = rVar;
        }
    }

    /* access modifiers changed from: protected */
    public void j(r rVar) {
        this.f18891a = rVar;
    }

    /* access modifiers changed from: protected */
    public String k() {
        return "";
    }

    public void l() {
        r rVar = this.f18894d;
        if (rVar != null) {
            rVar.f18895e = this.f18895e;
        } else {
            r rVar2 = this.f18891a;
            if (rVar2 != null) {
                rVar2.f18892b = this.f18895e;
            }
        }
        r rVar3 = this.f18895e;
        if (rVar3 != null) {
            rVar3.f18894d = rVar;
        } else {
            r rVar4 = this.f18891a;
            if (rVar4 != null) {
                rVar4.f18893c = rVar;
            }
        }
        this.f18891a = null;
        this.f18895e = null;
        this.f18894d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + k() + "}";
    }
}
