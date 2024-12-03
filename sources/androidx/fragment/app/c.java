package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.h;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.l;
import androidx.lifecycle.m0;
import androidx.lifecycle.u;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId = -1;
    private boolean mCancelable = true;
    private boolean mCreatingDialog;
    /* access modifiers changed from: private */
    public Dialog mDialog;
    private boolean mDialogCreated = false;
    private Runnable mDismissRunnable = new a();
    private boolean mDismissed;
    private Handler mHandler;
    private u<l> mObserver = new d();
    private DialogInterface.OnCancelListener mOnCancelListener = new b();
    /* access modifiers changed from: private */
    public DialogInterface.OnDismissListener mOnDismissListener = new C0059c();
    private boolean mShownByMe;
    /* access modifiers changed from: private */
    public boolean mShowsDialog = true;
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mViewDestroyed;

    class a implements Runnable {
        a() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            c.this.mOnDismissListener.onDismiss(c.this.mDialog);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.mDialog != null) {
                c cVar = c.this;
                cVar.onCancel(cVar.mDialog);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$c  reason: collision with other inner class name */
    class C0059c implements DialogInterface.OnDismissListener {
        C0059c() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.mDialog != null) {
                c cVar = c.this;
                cVar.onDismiss(cVar.mDialog);
            }
        }
    }

    class d implements u<l> {
        d() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a */
        public void b(l lVar) {
            if (lVar != null && c.this.mShowsDialog) {
                View requireView = c.this.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } else if (c.this.mDialog != null) {
                    if (FragmentManager.J0(3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("DialogFragment ");
                        sb2.append(this);
                        sb2.append(" setting the content view on ");
                        sb2.append(c.this.mDialog);
                    }
                    c.this.mDialog.setContentView(requireView);
                }
            }
        }
    }

    class e extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f5814a;

        e(j jVar) {
            this.f5814a = jVar;
        }

        public View c(int i10) {
            if (this.f5814a.d()) {
                return this.f5814a.c(i10);
            }
            return c.this.onFindViewById(i10);
        }

        public boolean d() {
            return this.f5814a.d() || c.this.onHasView();
        }
    }

    public c() {
    }

    private void dismissInternal(boolean z10, boolean z11, boolean z12) {
        if (!this.mDismissed) {
            this.mDismissed = true;
            this.mShownByMe = false;
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.mDialog.dismiss();
                if (!z11) {
                    if (Looper.myLooper() == this.mHandler.getLooper()) {
                        onDismiss(this.mDialog);
                    } else {
                        this.mHandler.post(this.mDismissRunnable);
                    }
                }
            }
            this.mViewDestroyed = true;
            if (this.mBackStackId >= 0) {
                if (z12) {
                    getParentFragmentManager().f1(this.mBackStackId, 1);
                } else {
                    getParentFragmentManager().d1(this.mBackStackId, 1, z10);
                }
                this.mBackStackId = -1;
                return;
            }
            b0 p10 = getParentFragmentManager().p();
            p10.x(true);
            p10.r(this);
            if (z12) {
                p10.k();
            } else if (z10) {
                p10.j();
            } else {
                p10.i();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void prepareDialog(Bundle bundle) {
        if (this.mShowsDialog && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                Dialog onCreateDialog = onCreateDialog(bundle);
                this.mDialog = onCreateDialog;
                if (this.mShowsDialog) {
                    setupDialog(onCreateDialog, this.mStyle);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
                this.mCreatingDialog = false;
            } catch (Throwable th2) {
                this.mCreatingDialog = false;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public j createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    public void dismiss() {
        dismissInternal(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false, false);
    }

    public void dismissNow() {
        dismissInternal(false, false, true);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().j(this.mObserver);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
    }

    public void onCreate(Bundle bundle) {
        boolean z10;
        super.onCreate(bundle);
        this.mHandler = new Handler();
        if (this.mContainerId == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mShowsDialog = z10;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCreateDialog called for DialogFragment ");
            sb2.append(this);
        }
        return new h(requireContext(), getTheme());
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().n(this.mObserver);
    }

    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            if (FragmentManager.J0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onDismiss called for DialogFragment ");
                sb2.append(this);
            }
            dismissInternal(true, true, false);
        }
    }

    /* access modifiers changed from: package-private */
    public View onFindViewById(int i10) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (!this.mShowsDialog || this.mCreatingDialog) {
            if (FragmentManager.J0(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (!this.mShowsDialog) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("mShowsDialog = false: ");
                    sb2.append(str);
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("mCreatingDialog = true: ");
                    sb3.append(str);
                }
            }
            return onGetLayoutInflater;
        }
        prepareDialog(bundle);
        if (FragmentManager.J0(2)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("get layout inflater for DialogFragment ");
            sb4.append(this);
            sb4.append(" from dialog context");
        }
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return onGetLayoutInflater.cloneInContext(dialog.getContext());
        }
        return onGetLayoutInflater;
    }

    /* access modifiers changed from: package-private */
    public boolean onHasView() {
        return this.mDialogCreated;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int i10 = this.mStyle;
        if (i10 != 0) {
            bundle.putInt(SAVED_STYLE, i10);
        }
        int i11 = this.mTheme;
        if (i11 != 0) {
            bundle.putInt(SAVED_THEME, i11);
        }
        boolean z10 = this.mCancelable;
        if (!z10) {
            bundle.putBoolean(SAVED_CANCELABLE, z10);
        }
        boolean z11 = this.mShowsDialog;
        if (!z11) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z11);
        }
        int i12 = this.mBackStackId;
        if (i12 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i12);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            ViewTreeLifecycleOwner.b(decorView, this);
            m0.a(decorView, this);
            ViewTreeSavedStateRegistryOwner.b(decorView, this);
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public void performCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView == null && this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z10) {
        this.mCancelable = z10;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z10);
        }
    }

    public void setShowsDialog(boolean z10) {
        this.mShowsDialog = z10;
    }

    public void setStyle(int i10, int i11) {
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting style and theme for DialogFragment ");
            sb2.append(this);
            sb2.append(" to ");
            sb2.append(i10);
            sb2.append(", ");
            sb2.append(i11);
        }
        this.mStyle = i10;
        if (i10 == 2 || i10 == 3) {
            this.mTheme = 16973913;
        }
        if (i11 != 0) {
            this.mTheme = i11;
        }
    }

    public void setupDialog(@NonNull Dialog dialog, int i10) {
        if (!(i10 == 1 || i10 == 2)) {
            if (i10 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(@NonNull FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        b0 p10 = fragmentManager.p();
        p10.x(true);
        p10.e(this, str);
        p10.i();
    }

    public void showNow(@NonNull FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        b0 p10 = fragmentManager.p();
        p10.x(true);
        p10.e(this, str);
        p10.k();
    }

    public int show(@NonNull b0 b0Var, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        b0Var.e(this, str);
        this.mViewDestroyed = false;
        int i10 = b0Var.i();
        this.mBackStackId = i10;
        return i10;
    }

    public c(int i10) {
        super(i10);
    }
}
