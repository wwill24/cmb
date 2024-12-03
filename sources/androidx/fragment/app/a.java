package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a extends b0 implements FragmentManager.m {

    /* renamed from: t  reason: collision with root package name */
    final FragmentManager f5728t;

    /* renamed from: u  reason: collision with root package name */
    boolean f5729u;

    /* renamed from: v  reason: collision with root package name */
    int f5730v;

    /* renamed from: w  reason: collision with root package name */
    boolean f5731w;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    a(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager r3) {
        /*
            r2 = this;
            androidx.fragment.app.l r0 = r3.u0()
            androidx.fragment.app.m r1 = r3.w0()
            if (r1 == 0) goto L_0x0017
            androidx.fragment.app.m r1 = r3.w0()
            android.content.Context r1 = r1.f()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r2.<init>(r0, r1)
            r0 = -1
            r2.f5730v = r0
            r0 = 0
            r2.f5731w = r0
            r2.f5728t = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.<init>(androidx.fragment.app.FragmentManager):void");
    }

    /* access modifiers changed from: package-private */
    public int A(boolean z10) {
        if (!this.f5729u) {
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Commit: ");
                sb2.append(this);
                PrintWriter printWriter = new PrintWriter(new g0("FragmentManager"));
                B("  ", printWriter);
                printWriter.close();
            }
            this.f5729u = true;
            if (this.f5790i) {
                this.f5730v = this.f5728t.m();
            } else {
                this.f5730v = -1;
            }
            this.f5728t.a0(this, z10);
            return this.f5730v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void B(String str, PrintWriter printWriter) {
        C(str, printWriter, true);
    }

    public void C(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f5792k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f5730v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f5729u);
            if (this.f5789h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f5789h));
            }
            if (!(this.f5785d == 0 && this.f5786e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5785d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5786e));
            }
            if (!(this.f5787f == 0 && this.f5788g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5787f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5788g));
            }
            if (!(this.f5793l == 0 && this.f5794m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5793l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f5794m);
            }
            if (!(this.f5795n == 0 && this.f5796o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5795n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f5796o);
            }
        }
        if (!this.f5784c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f5784c.size();
            for (int i10 = 0; i10 < size; i10++) {
                b0.a aVar = this.f5784c.get(i10);
                switch (aVar.f5801a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f5801a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f5802b);
                if (z10) {
                    if (!(aVar.f5804d == 0 && aVar.f5805e == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f5804d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f5805e));
                    }
                    if (aVar.f5806f != 0 || aVar.f5807g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f5806f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f5807g));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void D() {
        int size = this.f5784c.size();
        for (int i10 = 0; i10 < size; i10++) {
            b0.a aVar = this.f5784c.get(i10);
            Fragment fragment = aVar.f5802b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f5731w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f5789h);
                fragment.setSharedElementNames(this.f5797p, this.f5798q);
            }
            switch (aVar.f5801a) {
                case 1:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.t1(fragment, false);
                    this.f5728t.j(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.k1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.G0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.t1(fragment, false);
                    this.f5728t.x1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.y(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.t1(fragment, false);
                    this.f5728t.o(fragment);
                    break;
                case 8:
                    this.f5728t.v1(fragment);
                    break;
                case 9:
                    this.f5728t.v1((Fragment) null);
                    break;
                case 10:
                    this.f5728t.u1(fragment, aVar.f5809i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f5801a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void E() {
        for (int size = this.f5784c.size() - 1; size >= 0; size--) {
            b0.a aVar = this.f5784c.get(size);
            Fragment fragment = aVar.f5802b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f5731w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.p1(this.f5789h));
                fragment.setSharedElementNames(this.f5798q, this.f5797p);
            }
            switch (aVar.f5801a) {
                case 1:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.t1(fragment, true);
                    this.f5728t.k1(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.x1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.t1(fragment, true);
                    this.f5728t.G0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.o(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f5804d, aVar.f5805e, aVar.f5806f, aVar.f5807g);
                    this.f5728t.t1(fragment, true);
                    this.f5728t.y(fragment);
                    break;
                case 8:
                    this.f5728t.v1((Fragment) null);
                    break;
                case 9:
                    this.f5728t.v1(fragment);
                    break;
                case 10:
                    this.f5728t.u1(fragment, aVar.f5808h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f5801a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment F(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.f5784c.size()) {
            b0.a aVar = this.f5784c.get(i10);
            int i11 = aVar.f5801a;
            if (i11 != 1) {
                if (i11 == 2) {
                    Fragment fragment3 = aVar.f5802b;
                    int i12 = fragment3.mContainerId;
                    boolean z10 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.mContainerId == i12) {
                            if (fragment4 == fragment3) {
                                z10 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f5784c.add(i10, new b0.a(9, fragment4, true));
                                    i10++;
                                    fragment2 = null;
                                }
                                b0.a aVar2 = new b0.a(3, fragment4, true);
                                aVar2.f5804d = aVar.f5804d;
                                aVar2.f5806f = aVar.f5806f;
                                aVar2.f5805e = aVar.f5805e;
                                aVar2.f5807g = aVar.f5807g;
                                this.f5784c.add(i10, aVar2);
                                arrayList2.remove(fragment4);
                                i10++;
                            }
                        }
                    }
                    if (z10) {
                        this.f5784c.remove(i10);
                        i10--;
                    } else {
                        aVar.f5801a = 1;
                        aVar.f5803c = true;
                        arrayList2.add(fragment3);
                    }
                } else if (i11 == 3 || i11 == 6) {
                    arrayList2.remove(aVar.f5802b);
                    Fragment fragment5 = aVar.f5802b;
                    if (fragment5 == fragment2) {
                        this.f5784c.add(i10, new b0.a(9, fragment5));
                        i10++;
                        fragment2 = null;
                    }
                } else if (i11 != 7) {
                    if (i11 == 8) {
                        this.f5784c.add(i10, new b0.a(9, fragment2, true));
                        aVar.f5803c = true;
                        i10++;
                        fragment2 = aVar.f5802b;
                    }
                }
                i10++;
            }
            arrayList2.add(aVar.f5802b);
            i10++;
        }
        return fragment2;
    }

    public String G() {
        return this.f5792k;
    }

    public void H() {
        if (this.f5800s != null) {
            for (int i10 = 0; i10 < this.f5800s.size(); i10++) {
                this.f5800s.get(i10).run();
            }
            this.f5800s = null;
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment I(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f5784c.size() - 1; size >= 0; size--) {
            b0.a aVar = this.f5784c.get(size);
            int i10 = aVar.f5801a;
            if (i10 != 1) {
                if (i10 != 3) {
                    switch (i10) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f5802b;
                            break;
                        case 10:
                            aVar.f5809i = aVar.f5808h;
                            break;
                    }
                }
                arrayList.add(aVar.f5802b);
            }
            arrayList.remove(aVar.f5802b);
        }
        return fragment;
    }

    public boolean a(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Run: ");
            sb2.append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f5790i) {
            return true;
        }
        this.f5728t.i(this);
        return true;
    }

    public int i() {
        return A(false);
    }

    public int j() {
        return A(true);
    }

    public void k() {
        n();
        this.f5728t.d0(this, false);
    }

    public void l() {
        n();
        this.f5728t.d0(this, true);
    }

    @NonNull
    public b0 m(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f5728t) {
            return super.m(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void o(int i10, Fragment fragment, String str, int i11) {
        super.o(i10, fragment, str, i11);
        fragment.mFragmentManager = this.f5728t;
    }

    @NonNull
    public b0 p(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f5728t) {
            return super.p(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public boolean q() {
        return this.f5784c.isEmpty();
    }

    @NonNull
    public b0 r(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f5728t) {
            return super.r(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f5730v >= 0) {
            sb2.append(" #");
            sb2.append(this.f5730v);
        }
        if (this.f5792k != null) {
            sb2.append(" ");
            sb2.append(this.f5792k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    @NonNull
    public b0 w(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f5728t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f5728t);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.w(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    @NonNull
    public b0 y(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f5728t) {
            return super.y(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void z(int i10) {
        if (this.f5790i) {
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Bump nesting in ");
                sb2.append(this);
                sb2.append(" by ");
                sb2.append(i10);
            }
            int size = this.f5784c.size();
            for (int i11 = 0; i11 < size; i11++) {
                b0.a aVar = this.f5784c.get(i11);
                Fragment fragment = aVar.f5802b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i10;
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Bump nesting of ");
                        sb3.append(aVar.f5802b);
                        sb3.append(" to ");
                        sb3.append(aVar.f5802b.mBackStackNesting);
                    }
                }
            }
        }
    }
}
