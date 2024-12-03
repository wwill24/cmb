package com.coffeemeetsbagel.dialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.dialogs.b.a;
import java.util.List;

public class h0<Item extends b.a> extends b {

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f12110d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Item> f12111e;

    static class a<Item extends b.a> extends d<Item> {

        /* renamed from: f  reason: collision with root package name */
        private Item f12112f;

        public a(b.C0132b<Item> bVar, List<Item> list, Item item) {
            super(bVar, list);
            this.f12112f = item;
        }

        /* access modifiers changed from: package-private */
        public boolean H(Item item) {
            return item.equals(this.f12112f);
        }

        /* access modifiers changed from: package-private */
        public void L(int i10) {
            if (this.f12112f != this.f12093e.get(i10)) {
                this.f12112f = (b.a) this.f12093e.get(i10);
                this.f12092d.b((b.a) this.f12093e.get(i10));
            } else {
                this.f12112f = null;
                this.f12092d.a((b.a) this.f12093e.get(i10));
            }
            m(i10);
        }

        /* access modifiers changed from: package-private */
        public void M(Item item) {
            if (this.f12093e.contains(item)) {
                this.f12112f = item;
                m(this.f12093e.indexOf(item));
            }
        }

        public int g() {
            return this.f12093e.size();
        }
    }

    public h0(Context context, String str, String str2, g0<Item> g0Var, List<Item> list) {
        super(context, str, str2);
        a<Item> aVar = new a<>(g0Var, list, null);
        this.f12111e = aVar;
        this.f12110d.setAdapter(aVar);
        this.f12110d.setLayoutManager(new LinearLayoutManager(context, 1, false));
    }

    /* access modifiers changed from: package-private */
    public View b(Context context, ViewGroup viewGroup) {
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.single_select_closeable_dialog_dls, viewGroup, false);
        this.f12110d = recyclerView;
        return recyclerView;
    }

    public void h(Item item) {
        this.f12111e.M(item);
    }
}
