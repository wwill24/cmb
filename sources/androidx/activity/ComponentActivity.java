package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.core.app.h;
import androidx.core.app.k0;
import androidx.core.app.m;
import androidx.core.app.n0;
import androidx.core.view.a0;
import androidx.core.view.i;
import androidx.core.view.l;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.c0;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n;
import androidx.lifecycle.y;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import c.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

public class ComponentActivity extends h implements l0, androidx.lifecycle.f, r1.d, n, androidx.activity.result.d, androidx.activity.result.b, androidx.core.content.e, androidx.core.content.f, k0, androidx.core.app.l0, i, k {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final b.a mContextAwareHelper;
    private i0.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    @NonNull
    final j mFullyDrawnReporter;
    private final n mLifecycleRegistry;
    private final l mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<androidx.core.util.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<m>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<n0>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Integer>> mOnTrimMemoryListeners;
    private final f mReportFullyDrawnExecutor;
    final r1.c mSavedStateRegistryController;
    private androidx.lifecycle.k0 mViewModelStore;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            }
        }
    }

    class b extends ActivityResultRegistry {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f305a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a.C0091a f306b;

            a(int i10, a.C0091a aVar) {
                this.f305a = i10;
                this.f306b = aVar;
            }

            public void run() {
                b.this.c(this.f305a, this.f306b.a());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b  reason: collision with other inner class name */
        class C0010b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f308a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f309b;

            C0010b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f308a = i10;
                this.f309b = sendIntentException;
            }

            public void run() {
                b.this.b(this.f308a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f309b));
            }
        }

        b() {
        }

        public <I, O> void f(int i10, @NonNull c.a<I, O> aVar, I i11, androidx.core.app.c cVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0091a<O> synchronousResult = aVar.getSynchronousResult(componentActivity, i11);
            if (synchronousResult != null) {
                new Handler(Looper.getMainLooper()).post(new a(i10, synchronousResult));
                return;
            }
            Intent createIntent = aVar.createIntent(componentActivity, i11);
            Bundle bundle = null;
            if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (createIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = createIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                createIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(createIntent.getAction())) {
                String[] stringArrayExtra = createIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.b.g(componentActivity, stringArrayExtra, i10);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(createIntent.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    androidx.core.app.b.l(componentActivity, intentSenderRequest.e(), i10, intentSenderRequest.a(), intentSenderRequest.c(), intentSenderRequest.d(), 0, bundle2);
                } catch (IntentSender.SendIntentException e10) {
                    new Handler(Looper.getMainLooper()).post(new C0010b(i10, e10));
                }
            } else {
                androidx.core.app.b.k(componentActivity, createIntent, i10, bundle2);
            }
        }
    }

    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static class d {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        Object f311a;

        /* renamed from: b  reason: collision with root package name */
        androidx.lifecycle.k0 f312b;

        e() {
        }
    }

    private interface f extends Executor {
        void G(@NonNull View view);
    }

    class g implements f, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final long f313a = (SystemClock.uptimeMillis() + 10000);

        /* renamed from: b  reason: collision with root package name */
        Runnable f314b;

        /* renamed from: c  reason: collision with root package name */
        boolean f315c = false;

        g() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            Runnable runnable = this.f314b;
            if (runnable != null) {
                runnable.run();
                this.f314b = null;
            }
        }

        public void G(@NonNull View view) {
            if (!this.f315c) {
                this.f315c = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }

        public void execute(Runnable runnable) {
            this.f314b = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f315c) {
                decorView.postOnAnimation(new f(this));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        public void onDraw() {
            Runnable runnable = this.f314b;
            if (runnable != null) {
                runnable.run();
                this.f314b = null;
                if (ComponentActivity.this.mFullyDrawnReporter.c()) {
                    this.f315c = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                }
            } else if (SystemClock.uptimeMillis() > this.f313a) {
                this.f315c = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new b.a();
        this.mMenuHostHelper = new l(new b(this));
        this.mLifecycleRegistry = new n(this);
        r1.c a10 = r1.c.a(this);
        this.mSavedStateRegistryController = a10;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        f createFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = createFullyDrawnExecutor;
        this.mFullyDrawnReporter = new j(createFullyDrawnExecutor, new c(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() != null) {
            getLifecycle().a(new androidx.lifecycle.i() {
                public void e(@NonNull androidx.lifecycle.l lVar, @NonNull Lifecycle.Event event) {
                    View view;
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        if (window != null) {
                            view = window.peekDecorView();
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            c.a(view);
                        }
                    }
                }
            });
            getLifecycle().a(new androidx.lifecycle.i() {
                public void e(@NonNull androidx.lifecycle.l lVar, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.b();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                    }
                }
            });
            getLifecycle().a(new androidx.lifecycle.i() {
                public void e(@NonNull androidx.lifecycle.l lVar, @NonNull Lifecycle.Event event) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().d(this);
                }
            });
            a10.c();
            SavedStateHandleSupport.c(this);
            getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new d(this));
            addOnContextAvailableListener(new e(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private f createFullyDrawnExecutor() {
        return new g();
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        m0.a(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        q.a(getWindow().getDecorView(), this);
        p.a(getWindow().getDecorView(), this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$1() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Context context) {
        Bundle b10 = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (b10 != null) {
            this.mActivityResultRegistry.g(b10);
        }
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(@NonNull a0 a0Var) {
        this.mMenuHostHelper.c(a0Var);
    }

    public final void addOnConfigurationChangedListener(@NonNull androidx.core.util.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(@NonNull b.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    public final void addOnMultiWindowModeChangedListener(@NonNull androidx.core.util.a<m> aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(@NonNull androidx.core.util.a<Intent> aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(@NonNull androidx.core.util.a<n0> aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(@NonNull androidx.core.util.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.f312b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new androidx.lifecycle.k0();
            }
        }
    }

    @NonNull
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @NonNull
    public m1.a getDefaultViewModelCreationExtras() {
        m1.d dVar = new m1.d();
        if (getApplication() != null) {
            dVar.c(i0.a.f6038h, getApplication());
        }
        dVar.c(SavedStateHandleSupport.f5977a, this);
        dVar.c(SavedStateHandleSupport.f5978b, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            dVar.c(SavedStateHandleSupport.f5979c, getIntent().getExtras());
        }
        return dVar;
    }

    @NonNull
    public i0.b getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (this.mDefaultFactory == null) {
            Application application = getApplication();
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = null;
            }
            this.mDefaultFactory = new c0(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    @NonNull
    public j getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f311a;
        }
        return null;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @NonNull
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @NonNull
    public androidx.lifecycle.k0 getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.mActivityResultRegistry.b(i10, i11, intent)) {
            super.onActivityResult(i10, i11, intent);
        }
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.e();
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<androidx.core.util.a<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        y.e(this);
        if (androidx.core.os.a.c()) {
            this.mOnBackPressedDispatcher.f(d.a(this));
        }
        int i10 = this.mContentLayoutId;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    public boolean onCreatePanelMenu(int i10, @NonNull Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i10, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    public void onMultiWindowModeChanged(boolean z10) {
        if (!this.mDispatchingOnMultiWindowModeChanged) {
            Iterator<androidx.core.util.a<m>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new m(z10));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<androidx.core.util.a<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    public void onPanelClosed(int i10, @NonNull Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i10, menu);
    }

    public void onPictureInPictureModeChanged(boolean z10) {
        if (!this.mDispatchingOnPictureInPictureModeChanged) {
            Iterator<androidx.core.util.a<n0>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new n0(z10));
            }
        }
    }

    public boolean onPreparePanel(int i10, View view, @NonNull Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Deprecated
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.mActivityResultRegistry.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        androidx.lifecycle.k0 k0Var = this.mViewModelStore;
        if (k0Var == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            k0Var = eVar.f312b;
        }
        if (k0Var == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f311a = onRetainCustomNonConfigurationInstance;
        eVar2.f312b = k0Var;
        return eVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof n) {
            ((n) lifecycle).p(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<androidx.core.util.a<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i10));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    @NonNull
    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(@NonNull c.a<I, O> aVar, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull androidx.activity.result.a<O> aVar2) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, aVar2);
    }

    public void removeMenuProvider(@NonNull a0 a0Var) {
        this.mMenuHostHelper.l(a0Var);
    }

    public final void removeOnConfigurationChangedListener(@NonNull androidx.core.util.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(@NonNull b.b bVar) {
        this.mContextAwareHelper.e(bVar);
    }

    public final void removeOnMultiWindowModeChangedListener(@NonNull androidx.core.util.a<m> aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(@NonNull androidx.core.util.a<Intent> aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(@NonNull androidx.core.util.a<n0> aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(@NonNull androidx.core.util.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    public void reportFullyDrawn() {
        try {
            if (w1.b.d()) {
                w1.b.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.b();
        } finally {
            w1.b.b();
        }
    }

    public void setContentView(int i10) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(i10);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    public void addMenuProvider(@NonNull a0 a0Var, @NonNull androidx.lifecycle.l lVar) {
        this.mMenuHostHelper.d(a0Var, lVar);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull a0 a0Var, @NonNull androidx.lifecycle.l lVar, @NonNull Lifecycle.State state) {
        this.mMenuHostHelper.e(a0Var, lVar, state);
    }

    /* JADX INFO: finally extract failed */
    public void onMultiWindowModeChanged(boolean z10, @NonNull Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<androidx.core.util.a<m>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new m(z10, configuration));
            }
        } catch (Throwable th2) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public void onPictureInPictureModeChanged(boolean z10, @NonNull Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<androidx.core.util.a<n0>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new n0(z10, configuration));
            }
        } catch (Throwable th2) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th2;
        }
    }

    @NonNull
    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(@NonNull c.a<I, O> aVar, @NonNull androidx.activity.result.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(view);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i10) {
        this();
        this.mContentLayoutId = i10;
    }
}
