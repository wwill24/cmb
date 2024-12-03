package androidx.constraintlayout.core.widgets.analyzer;

import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.List;
import q0.a;

public class DependencyNode implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f3814a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3815b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3816c = false;

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f3817d;

    /* renamed from: e  reason: collision with root package name */
    Type f3818e = Type.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    int f3819f;

    /* renamed from: g  reason: collision with root package name */
    public int f3820g;

    /* renamed from: h  reason: collision with root package name */
    int f3821h = 1;

    /* renamed from: i  reason: collision with root package name */
    e f3822i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3823j = false;

    /* renamed from: k  reason: collision with root package name */
    List<a> f3824k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    List<DependencyNode> f3825l = new ArrayList();

    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f3817d = widgetRun;
    }

    public void a(a aVar) {
        for (DependencyNode dependencyNode : this.f3825l) {
            if (!dependencyNode.f3823j) {
                return;
            }
        }
        this.f3816c = true;
        a aVar2 = this.f3814a;
        if (aVar2 != null) {
            aVar2.a(this);
        }
        if (this.f3815b) {
            this.f3817d.a(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i10 = 0;
        for (DependencyNode next : this.f3825l) {
            if (!(next instanceof e)) {
                i10++;
                dependencyNode2 = next;
            }
        }
        if (dependencyNode2 != null && i10 == 1 && dependencyNode2.f3823j) {
            e eVar = this.f3822i;
            if (eVar != null) {
                if (eVar.f3823j) {
                    this.f3819f = this.f3821h * eVar.f3820g;
                } else {
                    return;
                }
            }
            d(dependencyNode2.f3820g + this.f3819f);
        }
        a aVar3 = this.f3814a;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    public void b(a aVar) {
        this.f3824k.add(aVar);
        if (this.f3823j) {
            aVar.a(aVar);
        }
    }

    public void c() {
        this.f3825l.clear();
        this.f3824k.clear();
        this.f3823j = false;
        this.f3820g = 0;
        this.f3816c = false;
        this.f3815b = false;
    }

    public void d(int i10) {
        if (!this.f3823j) {
            this.f3823j = true;
            this.f3820g = i10;
            for (a next : this.f3824k) {
                next.a(next);
            }
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f3817d.f3836b.t());
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(this.f3818e);
        sb2.append("(");
        if (this.f3823j) {
            obj = Integer.valueOf(this.f3820g);
        } else {
            obj = "unresolved";
        }
        sb2.append(obj);
        sb2.append(") <t=");
        sb2.append(this.f3825l.size());
        sb2.append(":d=");
        sb2.append(this.f3824k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
