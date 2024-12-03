package r5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import q5.o;

public class b extends com.google.android.material.bottomsheet.b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f17277d = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f17278b;

    /* renamed from: c  reason: collision with root package name */
    private final C0201b f17279c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: r5.b$b  reason: collision with other inner class name */
    public interface C0201b {
        void l1();
    }

    public b(ViewGroup viewGroup, C0201b bVar) {
        j.g(viewGroup, "componentView");
        this.f17278b = viewGroup;
        this.f17279c = bVar;
    }

    /* access modifiers changed from: private */
    public static final void E0(b bVar, DialogInterface dialogInterface) {
        j.g(bVar, "this$0");
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        com.google.android.material.bottomsheet.a aVar = dialogInterface instanceof com.google.android.material.bottomsheet.a ? (com.google.android.material.bottomsheet.a) dialogInterface : null;
        if (aVar != null) {
            bottomSheetBehavior = aVar.n();
        }
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.L0(bVar.f17278b.getMeasuredHeight());
        }
    }

    public void onActivityCreated(Bundle bundle) {
        Window window;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setWindowAnimations(o.slide_bottom_sheet);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnShowListener(new a(this));
        }
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, o.DialogStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        return this.f17278b;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        ViewParent viewParent;
        j.g(dialogInterface, "dialog");
        fa.a.f40771d.a("SlideBottomSheet", "onDismiss");
        super.onDismiss(dialogInterface);
        View view = getView();
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        j.e(viewParent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) viewParent).removeView(getView());
        C0201b bVar = this.f17279c;
        if (bVar != null) {
            bVar.l1();
        }
    }
}
