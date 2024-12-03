package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.l0;
import org.jivesoftware.smack.sm.packet.StreamManagement;

class z {

    /* renamed from: a  reason: collision with root package name */
    private final o f5907a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f5908b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f5909c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5910d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f5911e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f5912a;

        a(View view) {
            this.f5912a = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f5912a.removeOnAttachStateChangeListener(this);
            n0.p0(this.f5912a);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5914a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5914a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5914a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5914a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5914a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.z.b.<clinit>():void");
        }
    }

    z(@NonNull o oVar, @NonNull a0 a0Var, @NonNull Fragment fragment) {
        this.f5907a = oVar;
        this.f5908b = a0Var;
        this.f5909c = fragment;
    }

    private boolean l(@NonNull View view) {
        if (view == this.f5909c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f5909c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f5909c.performSaveInstanceState(bundle);
        this.f5907a.j(this.f5909c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f5909c.mView != null) {
            t();
        }
        if (this.f5909c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f5909c.mSavedViewState);
        }
        if (this.f5909c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f5909c.mSavedViewRegistryState);
        }
        if (!this.f5909c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f5909c.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ACTIVITY_CREATED: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        o oVar = this.f5907a;
        Fragment fragment2 = this.f5909c;
        oVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int j10 = this.f5908b.j(this.f5909c);
        Fragment fragment = this.f5909c;
        fragment.mContainer.addView(fragment.mView, j10);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ATTACHED: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        Fragment fragment2 = fragment.mTarget;
        z zVar = null;
        if (fragment2 != null) {
            z n10 = this.f5908b.n(fragment2.mWho);
            if (n10 != null) {
                Fragment fragment3 = this.f5909c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                zVar = n10;
            } else {
                throw new IllegalStateException("Fragment " + this.f5909c + " declared target fragment " + this.f5909c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (zVar = this.f5908b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f5909c + " declared target fragment " + this.f5909c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (zVar != null) {
            zVar.m();
        }
        Fragment fragment4 = this.f5909c;
        fragment4.mHost = fragment4.mFragmentManager.w0();
        Fragment fragment5 = this.f5909c;
        fragment5.mParentFragment = fragment5.mFragmentManager.z0();
        this.f5907a.g(this.f5909c, false);
        this.f5909c.performAttach();
        this.f5907a.b(this.f5909c, false);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        Fragment fragment = this.f5909c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i10 = this.f5911e;
        int i11 = b.f5914a[fragment.mMaxState.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                i10 = Math.min(i10, 5);
            } else if (i11 == 3) {
                i10 = Math.min(i10, 1);
            } else if (i11 != 4) {
                i10 = Math.min(i10, -1);
            } else {
                i10 = Math.min(i10, 0);
            }
        }
        Fragment fragment2 = this.f5909c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i10 = Math.max(this.f5911e, 2);
                View view = this.f5909c.mView;
                if (view != null && view.getParent() == null) {
                    i10 = Math.min(i10, 2);
                }
            } else {
                i10 = this.f5911e < 4 ? Math.min(i10, fragment2.mState) : Math.min(i10, 1);
            }
        }
        if (!this.f5909c.mAdded) {
            i10 = Math.min(i10, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        Fragment fragment3 = this.f5909c;
        ViewGroup viewGroup = fragment3.mContainer;
        if (viewGroup != null) {
            lifecycleImpact = SpecialEffectsController.n(viewGroup, fragment3.getParentFragmentManager()).l(this);
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i10 = Math.min(i10, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i10 = Math.max(i10, 3);
        } else {
            Fragment fragment4 = this.f5909c;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i10 = Math.min(i10, 1);
                } else {
                    i10 = Math.min(i10, -1);
                }
            }
        }
        Fragment fragment5 = this.f5909c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i10 = Math.min(i10, 4);
        }
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("computeExpectedState() of ");
            sb2.append(i10);
            sb2.append(" for ");
            sb2.append(this.f5909c);
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATED: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        if (!fragment.mIsCreated) {
            this.f5907a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f5909c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            o oVar = this.f5907a;
            Fragment fragment3 = this.f5909c;
            oVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f5909c.mState = 1;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        String str;
        if (!this.f5909c.mFromLayout) {
            if (FragmentManager.J0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("moveto CREATE_VIEW: ");
                sb2.append(this.f5909c);
            }
            Fragment fragment = this.f5909c;
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
            ViewGroup viewGroup = null;
            Fragment fragment2 = this.f5909c;
            ViewGroup viewGroup2 = fragment2.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i10 = fragment2.mContainerId;
                if (i10 != 0) {
                    if (i10 != -1) {
                        viewGroup = (ViewGroup) fragment2.mFragmentManager.r0().c(this.f5909c.mContainerId);
                        if (viewGroup == null) {
                            Fragment fragment3 = this.f5909c;
                            if (!fragment3.mRestored) {
                                try {
                                    str = fragment3.getResources().getResourceName(this.f5909c.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f5909c.mContainerId) + " (" + str + ") for fragment " + this.f5909c);
                            }
                        } else if (!(viewGroup instanceof FragmentContainerView)) {
                            FragmentStrictMode.p(this.f5909c, viewGroup);
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create fragment " + this.f5909c + " for a container view with no id");
                    }
                }
            }
            Fragment fragment4 = this.f5909c;
            fragment4.mContainer = viewGroup;
            fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
            View view = this.f5909c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment5 = this.f5909c;
                fragment5.mView.setTag(h1.b.fragment_container_view_tag, fragment5);
                if (viewGroup != null) {
                    b();
                }
                Fragment fragment6 = this.f5909c;
                if (fragment6.mHidden) {
                    fragment6.mView.setVisibility(8);
                }
                if (n0.V(this.f5909c.mView)) {
                    n0.p0(this.f5909c.mView);
                } else {
                    View view2 = this.f5909c.mView;
                    view2.addOnAttachStateChangeListener(new a(view2));
                }
                this.f5909c.performViewCreated();
                o oVar = this.f5907a;
                Fragment fragment7 = this.f5909c;
                oVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
                int visibility = this.f5909c.mView.getVisibility();
                this.f5909c.setPostOnViewCreatedAlpha(this.f5909c.mView.getAlpha());
                Fragment fragment8 = this.f5909c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.f5909c.setFocusedView(findFocus);
                        if (FragmentManager.J0(2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("requestFocus: Saved focused view ");
                            sb3.append(findFocus);
                            sb3.append(" for Fragment ");
                            sb3.append(this.f5909c);
                        }
                    }
                    this.f5909c.mView.setAlpha(0.0f);
                }
            }
            this.f5909c.mState = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        boolean z10;
        boolean z11;
        Fragment f10;
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATED: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        boolean z12 = true;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            Fragment fragment2 = this.f5909c;
            if (!fragment2.mBeingSaved) {
                this.f5908b.B(fragment2.mWho, (FragmentState) null);
            }
        }
        if (z10 || this.f5908b.p().r(this.f5909c)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            m<?> mVar = this.f5909c.mHost;
            if (mVar instanceof l0) {
                z12 = this.f5908b.p().o();
            } else if (mVar.f() instanceof Activity) {
                z12 = true ^ ((Activity) mVar.f()).isChangingConfigurations();
            }
            if ((z10 && !this.f5909c.mBeingSaved) || z12) {
                this.f5908b.p().g(this.f5909c);
            }
            this.f5909c.performDestroy();
            this.f5907a.d(this.f5909c, false);
            for (z next : this.f5908b.k()) {
                if (next != null) {
                    Fragment k10 = next.k();
                    if (this.f5909c.mWho.equals(k10.mTargetWho)) {
                        k10.mTarget = this.f5909c;
                        k10.mTargetWho = null;
                    }
                }
            }
            Fragment fragment3 = this.f5909c;
            String str = fragment3.mTargetWho;
            if (str != null) {
                fragment3.mTarget = this.f5908b.f(str);
            }
            this.f5908b.s(this);
            return;
        }
        String str2 = this.f5909c.mTargetWho;
        if (!(str2 == null || (f10 = this.f5908b.f(str2)) == null || !f10.mRetainInstance)) {
            this.f5909c.mTarget = f10;
        }
        this.f5909c.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        View view;
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATE_VIEW: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f5909c.performDestroyView();
        this.f5907a.n(this.f5909c, false);
        Fragment fragment2 = this.f5909c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.o(null);
        this.f5909c.mInLayout = false;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom ATTACHED: ");
            sb2.append(this.f5909c);
        }
        this.f5909c.performDetach();
        boolean z10 = false;
        this.f5907a.e(this.f5909c, false);
        Fragment fragment = this.f5909c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z10 = true;
        }
        if (z10 || this.f5908b.p().r(this.f5909c)) {
            if (FragmentManager.J0(3)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("initState called for fragment: ");
                sb3.append(this.f5909c);
            }
            this.f5909c.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f5909c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.J0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("moveto CREATE_VIEW: ");
                sb2.append(this.f5909c);
            }
            Fragment fragment2 = this.f5909c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), (ViewGroup) null, this.f5909c.mSavedFragmentState);
            View view = this.f5909c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f5909c;
                fragment3.mView.setTag(h1.b.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f5909c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f5909c.performViewCreated();
                o oVar = this.f5907a;
                Fragment fragment5 = this.f5909c;
                oVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f5909c.mState = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Fragment k() {
        return this.f5909c;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f5910d) {
            try {
                this.f5910d = true;
                boolean z10 = false;
                while (true) {
                    int d10 = d();
                    Fragment fragment = this.f5909c;
                    int i10 = fragment.mState;
                    if (d10 != i10) {
                        if (d10 <= i10) {
                            switch (i10 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    if (fragment.mBeingSaved && this.f5908b.q(fragment.mWho) == null) {
                                        s();
                                    }
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.f5909c.mState = 1;
                                    break;
                                case 2:
                                    fragment.mInLayout = false;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.J0(3)) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("movefrom ACTIVITY_CREATED: ");
                                        sb2.append(this.f5909c);
                                    }
                                    Fragment fragment2 = this.f5909c;
                                    if (fragment2.mBeingSaved) {
                                        s();
                                    } else if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        t();
                                    }
                                    Fragment fragment3 = this.f5909c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        SpecialEffectsController.n(viewGroup2, fragment3.getParentFragmentManager()).d(this);
                                    }
                                    this.f5909c.mState = 3;
                                    break;
                                case 4:
                                    w();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i10 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        SpecialEffectsController.n(viewGroup3, fragment.getParentFragmentManager()).b(SpecialEffectsController.Operation.State.b(this.f5909c.mView.getVisibility()), this);
                                    }
                                    this.f5909c.mState = 4;
                                    break;
                                case 5:
                                    v();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                        z10 = true;
                    } else {
                        if (!z10 && i10 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f5909c.mBeingSaved) {
                            if (FragmentManager.J0(3)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Cleaning up state of never attached fragment: ");
                                sb3.append(this.f5909c);
                            }
                            this.f5908b.p().g(this.f5909c);
                            this.f5908b.s(this);
                            if (FragmentManager.J0(3)) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("initState called for fragment: ");
                                sb4.append(this.f5909c);
                            }
                            this.f5909c.initState();
                        }
                        Fragment fragment4 = this.f5909c;
                        if (fragment4.mHiddenChanged) {
                            if (!(fragment4.mView == null || (viewGroup = fragment4.mContainer) == null)) {
                                SpecialEffectsController n10 = SpecialEffectsController.n(viewGroup, fragment4.getParentFragmentManager());
                                if (this.f5909c.mHidden) {
                                    n10.c(this);
                                } else {
                                    n10.e(this);
                                }
                            }
                            Fragment fragment5 = this.f5909c;
                            FragmentManager fragmentManager = fragment5.mFragmentManager;
                            if (fragmentManager != null) {
                                fragmentManager.H0(fragment5);
                            }
                            Fragment fragment6 = this.f5909c;
                            fragment6.mHiddenChanged = false;
                            fragment6.onHiddenChanged(fragment6.mHidden);
                            this.f5909c.mChildFragmentManager.K();
                        }
                        this.f5910d = false;
                        return;
                    }
                }
            } catch (Throwable th2) {
                this.f5910d = false;
                throw th2;
            }
        } else if (FragmentManager.J0(2)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Ignoring re-entrant call to moveToExpectedState() for ");
            sb5.append(k());
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom RESUMED: ");
            sb2.append(this.f5909c);
        }
        this.f5909c.performPause();
        this.f5907a.f(this.f5909c, false);
    }

    /* access modifiers changed from: package-private */
    public void o(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.f5909c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f5909c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f5909c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f5909c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.f5909c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f5909c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.f5909c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f5909c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        String str;
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto RESUMED: ");
            sb2.append(this.f5909c);
        }
        View focusedView = this.f5909c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.J0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("requestFocus: Restoring focused view ");
                sb3.append(focusedView);
                sb3.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = StreamManagement.Failed.ELEMENT;
                }
                sb3.append(str);
                sb3.append(" on Fragment ");
                sb3.append(this.f5909c);
                sb3.append(" resulting in focused view ");
                sb3.append(this.f5909c.mView.findFocus());
            }
        }
        this.f5909c.setFocusedView((View) null);
        this.f5909c.performResume();
        this.f5907a.i(this.f5909c, false);
        Fragment fragment = this.f5909c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* access modifiers changed from: package-private */
    public Fragment.SavedState r() {
        Bundle q10;
        if (this.f5909c.mState <= -1 || (q10 = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q10);
    }

    /* access modifiers changed from: package-private */
    public void s() {
        FragmentState fragmentState = new FragmentState(this.f5909c);
        Fragment fragment = this.f5909c;
        if (fragment.mState <= -1 || fragmentState.f5697n != null) {
            fragmentState.f5697n = fragment.mSavedFragmentState;
        } else {
            Bundle q10 = q();
            fragmentState.f5697n = q10;
            if (this.f5909c.mTargetWho != null) {
                if (q10 == null) {
                    fragmentState.f5697n = new Bundle();
                }
                fragmentState.f5697n.putString("android:target_state", this.f5909c.mTargetWho);
                int i10 = this.f5909c.mTargetRequestCode;
                if (i10 != 0) {
                    fragmentState.f5697n.putInt("android:target_req_state", i10);
                }
            }
        }
        this.f5908b.B(this.f5909c.mWho, fragmentState);
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.f5909c.mView != null) {
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Saving view state for fragment ");
                sb2.append(this.f5909c);
                sb2.append(" with view ");
                sb2.append(this.f5909c.mView);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f5909c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f5909c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f5909c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.f5909c.mSavedViewRegistryState = bundle;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i10) {
        this.f5911e = i10;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto STARTED: ");
            sb2.append(this.f5909c);
        }
        this.f5909c.performStart();
        this.f5907a.k(this.f5909c, false);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom STARTED: ");
            sb2.append(this.f5909c);
        }
        this.f5909c.performStop();
        this.f5907a.l(this.f5909c, false);
    }

    z(@NonNull o oVar, @NonNull a0 a0Var, @NonNull ClassLoader classLoader, @NonNull l lVar, @NonNull FragmentState fragmentState) {
        this.f5907a = oVar;
        this.f5908b = a0Var;
        Fragment a10 = fragmentState.a(lVar, classLoader);
        this.f5909c = a10;
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Instantiated fragment ");
            sb2.append(a10);
        }
    }

    z(@NonNull o oVar, @NonNull a0 a0Var, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.f5907a = oVar;
        this.f5908b = a0Var;
        this.f5909c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f5697n;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
