package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.c;
import androidx.constraintlayout.core.widgets.analyzer.g;
import androidx.constraintlayout.core.widgets.analyzer.m;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor {

    /* renamed from: a  reason: collision with root package name */
    private HashSet<ConstraintAnchor> f3735a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f3736b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3737c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintWidget f3738d;

    /* renamed from: e  reason: collision with root package name */
    public final Type f3739e;

    /* renamed from: f  reason: collision with root package name */
    public ConstraintAnchor f3740f;

    /* renamed from: g  reason: collision with root package name */
    public int f3741g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f3742h = Integer.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    SolverVariable f3743i;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3754a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3754a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3754a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3754a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3754a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3754a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3754a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3754a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3754a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f3754a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintAnchor.a.<clinit>():void");
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f3738d = constraintWidget;
        this.f3739e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i10) {
        return b(constraintAnchor, i10, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i10, int i11, boolean z10) {
        if (constraintAnchor == null) {
            q();
            return true;
        } else if (!z10 && !p(constraintAnchor)) {
            return false;
        } else {
            this.f3740f = constraintAnchor;
            if (constraintAnchor.f3735a == null) {
                constraintAnchor.f3735a = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.f3740f.f3735a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.f3741g = i10;
            this.f3742h = i11;
            return true;
        }
    }

    public void c(int i10, ArrayList<m> arrayList, m mVar) {
        HashSet<ConstraintAnchor> hashSet = this.f3735a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                g.a(it.next().f3738d, i10, arrayList, mVar);
            }
        }
    }

    public HashSet<ConstraintAnchor> d() {
        return this.f3735a;
    }

    public int e() {
        if (!this.f3737c) {
            return 0;
        }
        return this.f3736b;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.f3738d.V() == 8) {
            return 0;
        }
        if (this.f3742h == Integer.MIN_VALUE || (constraintAnchor = this.f3740f) == null || constraintAnchor.f3738d.V() != 8) {
            return this.f3741g;
        }
        return this.f3742h;
    }

    public final ConstraintAnchor g() {
        switch (a.f3754a[this.f3739e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f3738d.Q;
            case 3:
                return this.f3738d.O;
            case 4:
                return this.f3738d.R;
            case 5:
                return this.f3738d.P;
            default:
                throw new AssertionError(this.f3739e.name());
        }
    }

    public ConstraintWidget h() {
        return this.f3738d;
    }

    public SolverVariable i() {
        return this.f3743i;
    }

    public ConstraintAnchor j() {
        return this.f3740f;
    }

    public Type k() {
        return this.f3739e;
    }

    public boolean l() {
        HashSet<ConstraintAnchor> hashSet = this.f3735a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet<ConstraintAnchor> hashSet = this.f3735a;
        if (hashSet != null && hashSet.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.f3737c;
    }

    public boolean o() {
        return this.f3740f != null;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type k10 = constraintAnchor.k();
        Type type = this.f3739e;
        if (k10 != type) {
            switch (a.f3754a[type.ordinal()]) {
                case 1:
                    if (k10 == Type.BASELINE || k10 == Type.CENTER_X || k10 == Type.CENTER_Y) {
                        return false;
                    }
                    return true;
                case 2:
                case 3:
                    if (k10 == Type.LEFT || k10 == Type.RIGHT) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!(constraintAnchor.h() instanceof f)) {
                        return z10;
                    }
                    if (z10 || k10 == Type.CENTER_X) {
                        z12 = true;
                    }
                    return z12;
                case 4:
                case 5:
                    if (k10 == Type.TOP || k10 == Type.BOTTOM) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!(constraintAnchor.h() instanceof f)) {
                        return z11;
                    }
                    if (z11 || k10 == Type.CENTER_Y) {
                        z12 = true;
                    }
                    return z12;
                case 6:
                    if (k10 == Type.LEFT || k10 == Type.RIGHT) {
                        return false;
                    }
                    return true;
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.f3739e.name());
            }
        } else if (type != Type.BASELINE || (constraintAnchor.h().Z() && h().Z())) {
            return true;
        } else {
            return false;
        }
    }

    public void q() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f3740f;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.f3735a) == null)) {
            hashSet.remove(this);
            if (this.f3740f.f3735a.size() == 0) {
                this.f3740f.f3735a = null;
            }
        }
        this.f3735a = null;
        this.f3740f = null;
        this.f3741g = 0;
        this.f3742h = Integer.MIN_VALUE;
        this.f3737c = false;
        this.f3736b = 0;
    }

    public void r() {
        this.f3737c = false;
        this.f3736b = 0;
    }

    public void s(c cVar) {
        SolverVariable solverVariable = this.f3743i;
        if (solverVariable == null) {
            this.f3743i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.e();
        }
    }

    public void t(int i10) {
        this.f3736b = i10;
        this.f3737c = true;
    }

    public String toString() {
        return this.f3738d.t() + CertificateUtil.DELIMITER + this.f3739e.toString();
    }

    public void u(int i10) {
        if (o()) {
            this.f3742h = i10;
        }
    }
}
