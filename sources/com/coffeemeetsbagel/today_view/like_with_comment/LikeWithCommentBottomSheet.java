package com.coffeemeetsbagel.today_view.like_with_comment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import hc.c;
import java.util.Map;
import k6.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import w9.b;

public final class LikeWithCommentBottomSheet extends com.google.android.material.bottomsheet.b {

    /* renamed from: f  reason: collision with root package name */
    public static final a f37353f = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final String f37354b;

    /* renamed from: c  reason: collision with root package name */
    private l f37355c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f37356d;

    /* renamed from: e  reason: collision with root package name */
    private Function0<Unit> f37357e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LikeWithCommentBottomSheet a(String str) {
            j.g(str, "avatarUrl");
            return new LikeWithCommentBottomSheet(str, (DefaultConstructorMarker) null);
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LikeWithCommentBottomSheet f37358a;

        b(LikeWithCommentBottomSheet likeWithCommentBottomSheet) {
            this.f37358a = likeWithCommentBottomSheet;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            boolean z10;
            LikeWithCommentBottomSheet likeWithCommentBottomSheet = this.f37358a;
            if (StringsKt__StringsKt.W0(String.valueOf(charSequence)).toString().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            likeWithCommentBottomSheet.Q0(z10);
            if (charSequence == null) {
                return;
            }
            if (charSequence.length() < 130) {
                this.f37358a.I0().f15785d.setVisibility(8);
                return;
            }
            this.f37358a.I0().f15785d.setText(String.valueOf(140 - charSequence.length()));
            this.f37358a.I0().f15785d.setVisibility(0);
        }
    }

    private LikeWithCommentBottomSheet(String str) {
        this.f37354b = str;
        this.f37357e = LikeWithCommentBottomSheet$mDismissListener$1.f37359a;
    }

    public /* synthetic */ LikeWithCommentBottomSheet(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* access modifiers changed from: private */
    public final l I0() {
        l lVar = this.f37355c;
        j.d(lVar);
        return lVar;
    }

    public static final LikeWithCommentBottomSheet L0(String str) {
        return f37353f.a(str);
    }

    /* access modifiers changed from: private */
    public static final void M0(DialogInterface dialogInterface) {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        com.google.android.material.bottomsheet.a aVar = dialogInterface instanceof com.google.android.material.bottomsheet.a ? (com.google.android.material.bottomsheet.a) dialogInterface : null;
        if (aVar != null) {
            bottomSheetBehavior = aVar.n();
        }
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.Q0(3);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean N0(LikeWithCommentBottomSheet likeWithCommentBottomSheet, View view, TextView textView, int i10, KeyEvent keyEvent) {
        Object obj;
        j.g(likeWithCommentBottomSheet, "this$0");
        j.g(view, "$view");
        if (i10 != 6) {
            return false;
        }
        Context context = likeWithCommentBottomSheet.getContext();
        if (context != null) {
            obj = context.getSystemService("input_method");
        } else {
            obj = null;
        }
        j.e(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) obj).hideSoftInputFromWindow(view.getWindowToken(), 0);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void O0(LikeWithCommentBottomSheet likeWithCommentBottomSheet, View view) {
        j.g(likeWithCommentBottomSheet, "this$0");
        likeWithCommentBottomSheet.dismiss();
    }

    /* access modifiers changed from: private */
    public final void Q0(boolean z10) {
        TextView textView = I0().f15790j;
        textView.setEnabled(z10);
        textView.setClickable(z10);
    }

    public final String J0() {
        return StringsKt__StringsKt.W0(I0().f15787f.getText().toString()).toString();
    }

    public final void P0(Function0<Unit> function0) {
        j.g(function0, "dismissListener");
        this.f37357e = function0;
    }

    public final void R0(View.OnClickListener onClickListener) {
        j.g(onClickListener, "sendLikeButtonClickListener");
        this.f37356d = onClickListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        this.f37355c = l.c(layoutInflater, viewGroup, false);
        ConstraintLayout b10 = I0().getRoot();
        j.f(b10, "binding.root");
        return b10;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f37355c = null;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        j.g(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        this.f37357e.invoke();
    }

    public void onViewCreated(View view, Bundle bundle) {
        View view2 = view;
        j.g(view2, "view");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new hc.a());
        }
        Q0(false);
        int dimension = (int) view.getResources().getDimension(R.dimen.photo_size_large);
        com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
        Context context = view.getContext();
        j.f(context, "view.context");
        ImageLoaderContract.a.a(bVar, context, this.f37354b, I0().f15788g, Integer.valueOf(R.drawable.icon_profile_placeholder), (Integer) null, new ImageLoaderContract.b(dimension, dimension), q.m(b.a.f18329a, b.c.f18331a), (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 3984, (Object) null);
        I0().f15785d.setVisibility(8);
        I0().f15787f.addTextChangedListener(new b(this));
        I0().f15787f.setOnEditorActionListener(new hc.b(this, view2));
        I0().f15786e.setOnClickListener(new c(this));
        I0().f15790j.setOnClickListener(this.f37356d);
    }
}
