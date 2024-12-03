package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import java.lang.reflect.Method;

public class t0 extends p0 implements s0 {
    private static Method Q;
    private s0 P;

    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class b {
        static void a(PopupWindow popupWindow, boolean z10) {
            popupWindow.setTouchModal(z10);
        }
    }

    public static class c extends m0 {

        /* renamed from: p  reason: collision with root package name */
        final int f1443p;

        /* renamed from: q  reason: collision with root package name */
        final int f1444q;

        /* renamed from: t  reason: collision with root package name */
        private s0 f1445t;

        /* renamed from: w  reason: collision with root package name */
        private MenuItem f1446w;

        static class a {
            static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z10) {
            super(context, z10);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f1443p = 21;
                this.f1444q = 22;
                return;
            }
            this.f1443p = 22;
            this.f1444q = 21;
        }

        public /* bridge */ /* synthetic */ int d(int i10, int i11, int i12, int i13, int i14) {
            return super.d(i10, i11, i12, i13, i14);
        }

        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i10) {
            return super.e(motionEvent, i10);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i10;
            f fVar;
            int pointToPosition;
            int i11;
            if (this.f1445t != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i10 = headerViewListAdapter.getHeadersCount();
                    fVar = (f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i10 = 0;
                    fVar = (f) adapter;
                }
                i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i11 = pointToPosition - i10) >= 0 && i11 < fVar.getCount()) {
                    iVar = fVar.getItem(i11);
                }
                MenuItem menuItem = this.f1446w;
                if (menuItem != iVar) {
                    g b10 = fVar.b();
                    if (menuItem != null) {
                        this.f1445t.o(b10, menuItem);
                    }
                    this.f1446w = iVar;
                    if (iVar != null) {
                        this.f1445t.e(b10, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            f fVar;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f1443p) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i10 != this.f1444q) {
                return super.onKeyDown(i10, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    fVar = (f) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    fVar = (f) adapter;
                }
                fVar.b().e(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(s0 s0Var) {
            this.f1445t = s0Var;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                Q = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public t0(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public void S(Object obj) {
        a.a(this.M, (Transition) obj);
    }

    public void T(Object obj) {
        a.b(this.M, (Transition) obj);
    }

    public void U(s0 s0Var) {
        this.P = s0Var;
    }

    public void V(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = Q;
            if (method != null) {
                try {
                    method.invoke(this.M, new Object[]{Boolean.valueOf(z10)});
                } catch (Exception unused) {
                }
            }
        } else {
            b.a(this.M, z10);
        }
    }

    public void e(@NonNull g gVar, @NonNull MenuItem menuItem) {
        s0 s0Var = this.P;
        if (s0Var != null) {
            s0Var.e(gVar, menuItem);
        }
    }

    public void o(@NonNull g gVar, @NonNull MenuItem menuItem) {
        s0 s0Var = this.P;
        if (s0Var != null) {
            s0Var.o(gVar, menuItem);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public m0 s(Context context, boolean z10) {
        c cVar = new c(context, z10);
        cVar.setHoverListener(this);
        return cVar;
    }
}
