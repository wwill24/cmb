package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbFrameLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView;

public abstract class m extends ViewDataBinding {
    @NonNull
    public final LinearLayout D;
    @NonNull
    public final LinearLayout E;
    @NonNull
    public final RecyclerView F;
    @NonNull
    public final CmbEditText G;
    @NonNull
    public final CmbTextView H;
    @NonNull
    public final DelayAutoCompleteTextView I;
    @NonNull
    public final DelayAutoCompleteTextView J;
    @NonNull
    public final CmbEditText K;
    @NonNull
    public final CmbEditText L;
    @NonNull
    public final CmbEditText M;
    @NonNull
    public final CmbTextView N;
    @NonNull
    public final q O;
    @NonNull
    public final CmbFrameLayout P;
    @NonNull
    public final q Q;
    @NonNull
    public final q R;
    @NonNull
    public final q S;
    @NonNull
    public final o T;
    @NonNull
    public final q U;
    @NonNull
    public final q V;
    @NonNull
    public final o W;
    @NonNull
    public final q X;
    @NonNull
    public final q Y;
    @NonNull
    public final q Z;
    @NonNull

    /* renamed from: a0  reason: collision with root package name */
    public final o f15792a0;
    @NonNull

    /* renamed from: b0  reason: collision with root package name */
    public final q f15793b0;
    @NonNull

    /* renamed from: c0  reason: collision with root package name */
    public final q f15794c0;
    @NonNull

    /* renamed from: d0  reason: collision with root package name */
    public final q f15795d0;
    @NonNull

    /* renamed from: e0  reason: collision with root package name */
    public final ProgressBar f15796e0;
    @NonNull

    /* renamed from: f0  reason: collision with root package name */
    public final ProgressBar f15797f0;
    @NonNull

    /* renamed from: g0  reason: collision with root package name */
    public final NestedScrollView f15798g0;
    @NonNull

    /* renamed from: h0  reason: collision with root package name */
    public final CmbTextView f15799h0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected m(Object obj, View view, int i10, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, CmbEditText cmbEditText, CmbTextView cmbTextView, DelayAutoCompleteTextView delayAutoCompleteTextView, DelayAutoCompleteTextView delayAutoCompleteTextView2, CmbEditText cmbEditText2, CmbEditText cmbEditText3, CmbEditText cmbEditText4, CmbTextView cmbTextView2, q qVar, CmbFrameLayout cmbFrameLayout, q qVar2, q qVar3, q qVar4, o oVar, q qVar5, q qVar6, o oVar2, q qVar7, q qVar8, q qVar9, o oVar3, q qVar10, q qVar11, q qVar12, ProgressBar progressBar, ProgressBar progressBar2, NestedScrollView nestedScrollView, CmbTextView cmbTextView3) {
        super(obj, view, i10);
        this.D = linearLayout;
        this.E = linearLayout2;
        this.F = recyclerView;
        this.G = cmbEditText;
        this.H = cmbTextView;
        this.I = delayAutoCompleteTextView;
        this.J = delayAutoCompleteTextView2;
        this.K = cmbEditText2;
        this.L = cmbEditText3;
        this.M = cmbEditText4;
        this.N = cmbTextView2;
        this.O = qVar;
        this.P = cmbFrameLayout;
        this.Q = qVar2;
        this.R = qVar3;
        this.S = qVar4;
        this.T = oVar;
        this.U = qVar5;
        this.V = qVar6;
        this.W = oVar2;
        this.X = qVar7;
        this.Y = qVar8;
        this.Z = qVar9;
        this.f15792a0 = oVar3;
        this.f15793b0 = qVar10;
        this.f15794c0 = qVar11;
        this.f15795d0 = qVar12;
        this.f15796e0 = progressBar;
        this.f15797f0 = progressBar2;
        this.f15798g0 = nestedScrollView;
        this.f15799h0 = cmbTextView3;
    }

    @NonNull
    public static m G(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        return H(layoutInflater, viewGroup, z10, g.d());
    }

    @NonNull
    @Deprecated
    public static m H(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (m) ViewDataBinding.q(layoutInflater, R.layout.fragment_my_profile_details_dls, viewGroup, z10, obj);
    }
}
