package w7;

import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.util.ComparisonUtils;
import com.coffeemeetsbagel.models.util.StringUtils;
import java.util.List;
import org.apache.commons.cli.HelpFormatter;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private Integer f18279a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f18280b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f18281c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f18282d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f18283e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f18284f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f18285g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f18286h;

    private boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public Integer b() {
        return this.f18279a;
    }

    public Integer c() {
        return this.f18280b;
    }

    public List<String> d() {
        return this.f18285g;
    }

    public List<String> e() {
        return this.f18284f;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (!ComparisonUtils.equalsWithNullCheck(this.f18279a, jVar.f18279a) || !ComparisonUtils.equalsWithNullCheck(this.f18280b, jVar.f18280b) || !ComparisonUtils.equalsWithNullCheck(this.f18281c, jVar.f18281c) || !ComparisonUtils.equalsWithNullCheck(this.f18282d, jVar.f18282d) || !ComparisonUtils.equalsWithNullCheck(this.f18283e, jVar.f18283e) || !ComparisonUtils.equalsWithNullCheck(this.f18284f, jVar.f18284f) || !ComparisonUtils.equalsWithNullCheck(this.f18285g, jVar.f18285g) || !ComparisonUtils.equalsWithNullCheck(this.f18286h, jVar.f18286h)) {
            return false;
        }
        return true;
    }

    public Integer f() {
        return this.f18281c;
    }

    public Integer g() {
        return this.f18282d;
    }

    public Integer h() {
        return this.f18283e;
    }

    public Boolean i() {
        return this.f18286h;
    }

    public boolean j() {
        return a(this.f18279a, this.f18280b, this.f18281c, this.f18282d, this.f18283e, this.f18284f, this.f18285g, this.f18286h);
    }

    public j k(int i10, int i11) {
        this.f18279a = Integer.valueOf(i10);
        this.f18280b = Integer.valueOf(i11);
        return this;
    }

    public j l(List<String> list) {
        this.f18285g = list;
        return this;
    }

    public j m(List<String> list) {
        this.f18284f = list;
        return this;
    }

    public j n(int i10, int i11) {
        if (i10 == 0) {
            this.f18281c = 122;
        } else {
            this.f18281c = Integer.valueOf(i10);
        }
        if (i11 == 0) {
            this.f18281c = Integer.valueOf(Height.CENTIMETRES_MAX);
        } else {
            this.f18282d = Integer.valueOf(i11);
        }
        return this;
    }

    public void o(int i10) {
        this.f18283e = Integer.valueOf(i10);
    }

    public j p(boolean z10) {
        this.f18286h = Boolean.valueOf(z10);
        return this;
    }

    public String toString() {
        return "age: " + this.f18279a + HelpFormatter.DEFAULT_OPT_PREFIX + this.f18280b + " height: " + this.f18281c + HelpFormatter.DEFAULT_OPT_PREFIX + this.f18282d + " distance: " + this.f18283e + " ethnicity: " + StringUtils.join(this.f18284f) + " degree: " + StringUtils.join(this.f18285g) + " active: " + this.f18286h;
    }
}
