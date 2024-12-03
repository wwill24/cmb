package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    g f818a;

    /* renamed from: b  reason: collision with root package name */
    private int f819b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f820c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f821d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f822e;

    /* renamed from: f  reason: collision with root package name */
    private final int f823f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f821d = z10;
        this.f822e = layoutInflater;
        this.f818a = gVar;
        this.f823f = i10;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        i v10 = this.f818a.v();
        if (v10 != null) {
            ArrayList<i> z10 = this.f818a.z();
            int size = z10.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (z10.get(i10) == v10) {
                    this.f819b = i10;
                    return;
                }
            }
        }
        this.f819b = -1;
    }

    public g b() {
        return this.f818a;
    }

    /* renamed from: c */
    public i getItem(int i10) {
        ArrayList<i> arrayList;
        if (this.f821d) {
            arrayList = this.f818a.z();
        } else {
            arrayList = this.f818a.E();
        }
        int i11 = this.f819b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return arrayList.get(i10);
    }

    public void d(boolean z10) {
        this.f820c = z10;
    }

    public int getCount() {
        ArrayList<i> arrayList;
        if (this.f821d) {
            arrayList = this.f818a.z();
        } else {
            arrayList = this.f818a.E();
        }
        if (this.f819b < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        boolean z10;
        if (view == null) {
            view = this.f822e.inflate(this.f823f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i12 = i10 - 1;
        if (i12 >= 0) {
            i11 = getItem(i12).getGroupId();
        } else {
            i11 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (!this.f818a.F() || groupId == i11) {
            z10 = false;
        } else {
            z10 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z10);
        n.a aVar = (n.a) view;
        if (this.f820c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.c(getItem(i10), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
