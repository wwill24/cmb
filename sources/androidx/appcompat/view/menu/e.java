package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import d.g;
import java.util.ArrayList;

public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    Context f807a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f808b;

    /* renamed from: c  reason: collision with root package name */
    g f809c;

    /* renamed from: d  reason: collision with root package name */
    ExpandedMenuView f810d;

    /* renamed from: e  reason: collision with root package name */
    int f811e;

    /* renamed from: f  reason: collision with root package name */
    int f812f;

    /* renamed from: g  reason: collision with root package name */
    int f813g;

    /* renamed from: h  reason: collision with root package name */
    private m.a f814h;

    /* renamed from: j  reason: collision with root package name */
    a f815j;

    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private int f816a = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            i v10 = e.this.f809c.v();
            if (v10 != null) {
                ArrayList<i> z10 = e.this.f809c.z();
                int size = z10.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (z10.get(i10) == v10) {
                        this.f816a = i10;
                        return;
                    }
                }
            }
            this.f816a = -1;
        }

        /* renamed from: b */
        public i getItem(int i10) {
            ArrayList<i> z10 = e.this.f809c.z();
            int i11 = i10 + e.this.f811e;
            int i12 = this.f816a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return z10.get(i11);
        }

        public int getCount() {
            int size = e.this.f809c.z().size() - e.this.f811e;
            if (this.f816a < 0) {
                return size;
            }
            return size - 1;
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f808b.inflate(eVar.f813g, viewGroup, false);
            }
            ((n.a) view).c(getItem(i10), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i10) {
        this(i10, 0);
        this.f807a = context;
        this.f808b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f815j == null) {
            this.f815j = new a();
        }
        return this.f815j;
    }

    public n b(ViewGroup viewGroup) {
        if (this.f810d == null) {
            this.f810d = (ExpandedMenuView) this.f808b.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f815j == null) {
                this.f815j = new a();
            }
            this.f810d.setAdapter(this.f815j);
            this.f810d.setOnItemClickListener(this);
        }
        return this.f810d;
    }

    public void c(g gVar, boolean z10) {
        m.a aVar = this.f814h;
        if (aVar != null) {
            aVar.c(gVar, z10);
        }
    }

    public boolean d(g gVar, i iVar) {
        return false;
    }

    public void e(m.a aVar) {
        this.f814h = aVar;
    }

    public boolean f(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).b((IBinder) null);
        m.a aVar = this.f814h;
        if (aVar == null) {
            return true;
        }
        aVar.d(rVar);
        return true;
    }

    public void g(boolean z10) {
        a aVar = this.f815j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public boolean h() {
        return false;
    }

    public boolean i(g gVar, i iVar) {
        return false;
    }

    public void j(Context context, g gVar) {
        if (this.f812f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f812f);
            this.f807a = contextThemeWrapper;
            this.f808b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f807a != null) {
            this.f807a = context;
            if (this.f808b == null) {
                this.f808b = LayoutInflater.from(context);
            }
        }
        this.f809c = gVar;
        a aVar = this.f815j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f809c.M(this.f815j.getItem(i10), this, 0);
    }

    public e(int i10, int i11) {
        this.f813g = i10;
        this.f812f = i11;
    }
}
