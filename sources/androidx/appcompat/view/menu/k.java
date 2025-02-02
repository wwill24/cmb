package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;

abstract class k implements p, m, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Rect f892a;

    k() {
    }

    protected static int n(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i10) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i11 = 0;
        int i12 = 0;
        View view = null;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = listAdapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i13, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i10) {
                return i10;
            }
            if (measuredWidth > i11) {
                i11 = measuredWidth;
            }
        }
        return i11;
    }

    protected static boolean x(g gVar) {
        int size = gVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = gVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static f y(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (f) listAdapter;
    }

    public boolean d(g gVar, i iVar) {
        return false;
    }

    public boolean i(g gVar, i iVar) {
        return false;
    }

    public void j(@NonNull Context context, g gVar) {
    }

    public abstract void k(g gVar);

    /* access modifiers changed from: protected */
    public boolean l() {
        return true;
    }

    public Rect m() {
        return this.f892a;
    }

    public abstract void o(View view);

    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        int i11;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        g gVar = y(listAdapter).f818a;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i10);
        if (l()) {
            i11 = 0;
        } else {
            i11 = 4;
        }
        gVar.M(menuItem, this, i11);
    }

    public void q(Rect rect) {
        this.f892a = rect;
    }

    public abstract void r(boolean z10);

    public abstract void s(int i10);

    public abstract void t(int i10);

    public abstract void u(PopupWindow.OnDismissListener onDismissListener);

    public abstract void v(boolean z10);

    public abstract void w(int i10);
}
