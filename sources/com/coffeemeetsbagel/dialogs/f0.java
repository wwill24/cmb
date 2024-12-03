package com.coffeemeetsbagel.dialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.dialogs.b.a;
import j5.x;
import java.util.ArrayList;
import java.util.List;
import qj.q;

public class f0<Item extends b.a> extends b {

    /* renamed from: d  reason: collision with root package name */
    private final b.C0132b<Item> f12101d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f12102e;

    /* renamed from: f  reason: collision with root package name */
    private b<Item> f12103f;

    /* renamed from: g  reason: collision with root package name */
    private CmbTextView f12104g;

    class a implements b.C0132b<Item> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.C0132b f12105a;

        a(b.C0132b bVar) {
            this.f12105a = bVar;
        }

        /* renamed from: c */
        public void a(Item item) {
            this.f12105a.a(item);
        }

        /* renamed from: d */
        public void b(Item item) {
            this.f12105a.b(item);
        }
    }

    static class b<Item extends b.a> extends d<Item> {
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final List<Item> f12107f = new ArrayList();

        public b(b.C0132b<Item> bVar, List<Item> list) {
            super(bVar, list);
        }

        /* access modifiers changed from: package-private */
        public boolean H(Item item) {
            return this.f12107f.contains(item);
        }

        /* access modifiers changed from: package-private */
        public void L(int i10) {
            if (!this.f12107f.contains(this.f12093e.get(i10))) {
                this.f12107f.add((b.a) this.f12093e.get(i10));
                this.f12092d.b((b.a) this.f12093e.get(i10));
            } else {
                this.f12107f.remove(this.f12093e.get(i10));
                this.f12092d.a((b.a) this.f12093e.get(i10));
            }
            m(i10);
        }

        /* access modifiers changed from: package-private */
        public void N(List<Item> list) {
            this.f12107f.clear();
            this.f12107f.addAll(list);
            l();
        }

        public int g() {
            return this.f12093e.size();
        }
    }

    public f0(Context context, String str, String str2, String str3, b.C0132b<Item> bVar, List<Item> list) {
        super(context, str, str2);
        this.f12101d = bVar;
        b<Item> bVar2 = new b<>(new a(bVar), list);
        this.f12103f = bVar2;
        this.f12102e.setAdapter(bVar2);
        this.f12102e.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.f12104g.setText(str3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List j(x xVar) throws Exception {
        return this.f12103f.f12107f;
    }

    /* access modifiers changed from: package-private */
    public View b(Context context, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.multi_select_closeable_dialog_dls, viewGroup, false);
        this.f12102e = (RecyclerView) relativeLayout.findViewById(R.id.multi_select_recycler);
        this.f12104g = (CmbTextView) relativeLayout.findViewById(R.id.primary_button);
        return relativeLayout;
    }

    public q<List<Item>> i() {
        return this.f12104g.s().W(new e0(this));
    }

    public void k(List<Item> list) {
        this.f12103f.N(list);
    }
}
