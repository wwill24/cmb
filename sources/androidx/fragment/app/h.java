package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.d;
import androidx.annotation.NonNull;
import androidx.core.app.b;
import androidx.core.app.k0;
import androidx.core.app.l0;
import androidx.core.app.m;
import androidx.core.app.n0;
import androidx.core.app.p0;
import androidx.core.content.e;
import androidx.core.content.f;
import androidx.core.view.a0;
import androidx.core.view.i;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class h extends ComponentActivity implements b.e {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final n mFragmentLifecycleRegistry = new n(this);
    final k mFragments = k.b(new a());
    boolean mResumed;
    boolean mStopped = true;

    class a extends m<h> implements e, f, k0, l0, androidx.lifecycle.l0, androidx.activity.n, d, r1.d, w, i {
        public a() {
            super(h.this);
        }

        public void a(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            h.this.onAttachFragment(fragment);
        }

        public void addMenuProvider(@NonNull a0 a0Var) {
            h.this.addMenuProvider(a0Var);
        }

        public void addOnConfigurationChangedListener(@NonNull androidx.core.util.a<Configuration> aVar) {
            h.this.addOnConfigurationChangedListener(aVar);
        }

        public void addOnMultiWindowModeChangedListener(@NonNull androidx.core.util.a<m> aVar) {
            h.this.addOnMultiWindowModeChangedListener(aVar);
        }

        public void addOnPictureInPictureModeChangedListener(@NonNull androidx.core.util.a<n0> aVar) {
            h.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        public void addOnTrimMemoryListener(@NonNull androidx.core.util.a<Integer> aVar) {
            h.this.addOnTrimMemoryListener(aVar);
        }

        public View c(int i10) {
            return h.this.findViewById(i10);
        }

        public boolean d() {
            Window window = h.this.getWindow();
            if (window == null || window.peekDecorView() == null) {
                return false;
            }
            return true;
        }

        @NonNull
        public ActivityResultRegistry getActivityResultRegistry() {
            return h.this.getActivityResultRegistry();
        }

        @NonNull
        public Lifecycle getLifecycle() {
            return h.this.mFragmentLifecycleRegistry;
        }

        @NonNull
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return h.this.getOnBackPressedDispatcher();
        }

        @NonNull
        public androidx.savedstate.a getSavedStateRegistry() {
            return h.this.getSavedStateRegistry();
        }

        @NonNull
        public androidx.lifecycle.k0 getViewModelStore() {
            return h.this.getViewModelStore();
        }

        public void h(@NonNull String str, FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, String[] strArr) {
            h.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @NonNull
        public LayoutInflater j() {
            return h.this.getLayoutInflater().cloneInContext(h.this);
        }

        public boolean l(@NonNull String str) {
            return b.j(h.this, str);
        }

        public void o() {
            p();
        }

        public void p() {
            h.this.invalidateMenu();
        }

        /* renamed from: q */
        public h i() {
            return h.this;
        }

        public void removeMenuProvider(@NonNull a0 a0Var) {
            h.this.removeMenuProvider(a0Var);
        }

        public void removeOnConfigurationChangedListener(@NonNull androidx.core.util.a<Configuration> aVar) {
            h.this.removeOnConfigurationChangedListener(aVar);
        }

        public void removeOnMultiWindowModeChangedListener(@NonNull androidx.core.util.a<m> aVar) {
            h.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        public void removeOnPictureInPictureModeChangedListener(@NonNull androidx.core.util.a<n0> aVar) {
            h.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        public void removeOnTrimMemoryListener(@NonNull androidx.core.util.a<Integer> aVar) {
            h.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public h() {
        init();
    }

    private void init() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new d(this));
        addOnConfigurationChangedListener(new e(this));
        addOnNewIntentListener(new f(this));
        addOnContextAvailableListener(new g(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.j(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(Configuration configuration) {
        this.mFragments.m();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(Intent intent) {
        this.mFragments.m();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(Context context) {
        this.mFragments.a((Fragment) null);
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z10 = false;
        for (Fragment next : fragmentManager.v0()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z10 |= markState(next.getChildFragmentManager(), state);
                }
                f0 f0Var = next.mViewLifecycleOwner;
                if (f0Var != null && f0Var.getLifecycle().b().b(Lifecycle.State.STARTED)) {
                    next.mViewLifecycleOwner.f(state);
                    z10 = true;
                }
                if (next.mLifecycleRegistry.b().b(Lifecycle.State.STARTED)) {
                    next.mLifecycleRegistry.p(state);
                    z10 = true;
                }
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.mFragments.n(view, str, context, attributeSet);
    }

    public void dump(@NonNull String str, FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                androidx.loader.app.a.c(this).b(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().Y(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @NonNull
    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.c(this);
    }

    /* access modifiers changed from: package-private */
    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i10, i11, intent);
    }

    @Deprecated
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.j(Lifecycle.Event.ON_CREATE);
        this.mFragments.e();
    }

    public View onCreateView(View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.j(Lifecycle.Event.ON_DESTROY);
    }

    public boolean onMenuItemSelected(int i10, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.j(Lifecycle.Event.ON_PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.j(Lifecycle.Event.ON_RESUME);
        this.mFragments.h();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.j(Lifecycle.Event.ON_START);
        this.mFragments.i();
    }

    public void onStateNotSaved() {
        this.mFragments.m();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.j(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(p0 p0Var) {
        b.h(this, p0Var);
    }

    public void setExitSharedElementCallback(p0 p0Var) {
        b.i(this, p0Var);
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        startActivityFromFragment(fragment, intent, i10, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 == -1) {
            b.l(this, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        b.c(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        b.e(this);
    }

    public void supportStartPostponedEnterTransition() {
        b.m(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i10) {
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            b.k(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i10, bundle);
        }
    }

    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public h(int i10) {
        super(i10);
        init();
    }
}
