package com.coffeemeetsbagel.feature.rlcs.viewer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.DialogMultiButtonDls;
import com.coffeemeetsbagel.feature.rlcs.viewer.a;
import ga.e;
import ga.f;
import ga.g;
import j5.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lc.c;

public class RlcsViewerActivity extends o implements g, a.e {

    /* renamed from: f  reason: collision with root package name */
    Toolbar f13387f;

    /* renamed from: g  reason: collision with root package name */
    RecyclerView f13388g;

    /* renamed from: h  reason: collision with root package name */
    a f13389h;

    /* renamed from: j  reason: collision with root package name */
    Dialog f13390j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public f f13391k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public i9.b f13392l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f13393m;

    /* renamed from: n  reason: collision with root package name */
    private Set<String> f13394n;

    /* renamed from: p  reason: collision with root package name */
    private Set<String> f13395p;

    /* renamed from: q  reason: collision with root package name */
    private int f13396q;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            RlcsViewerActivity.this.f13391k.e();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (RlcsViewerActivity.this.f13393m && RlcsViewerActivity.this.f13392l.g() > 0) {
                RlcsViewerActivity rlcsViewerActivity = RlcsViewerActivity.this;
                rlcsViewerActivity.f13388g.s1(rlcsViewerActivity.f13392l.g() - 1);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(int i10, View view) {
        c.h(this.f13390j);
        this.f13391k.d(i10);
    }

    public void B(int i10) {
        this.f13396q = i10;
        p0().m();
    }

    /* access modifiers changed from: package-private */
    public f K0(e eVar, g gVar) {
        return new i9.c(eVar, gVar);
    }

    public void U(List<String> list) {
        this.f13392l.I(list);
        this.f13392l.l();
        if (this.f13393m) {
            this.f13388g.post(new b());
        }
    }

    public void Z(Set<String> set) {
        this.f13395p = set;
        this.f13391k.b(set);
        p0().m();
    }

    public void h(Set<String> set) {
        this.f13394n = set;
    }

    public void n(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<DialogMultiButtonDls.Button> arrayList2 = new ArrayList<>();
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            arrayList.add(new i9.a(this, intValue2));
            arrayList2.add(new DialogMultiButtonDls.Button(DialogMultiButtonDls.Button.Type.SECONDARY, getString(R.string.num_lines, new Object[]{Integer.valueOf(intValue2)})));
        }
        this.f13390j = new DialogMultiButtonDls((Context) this, (int) R.string.choose_number_of_lines_dialog_title, (int) R.string.choose_number_of_lines_prompt, (List<DialogMultiButtonDls.Button>) arrayList2);
        for (DialogMultiButtonDls.Button button : arrayList2) {
            ((DialogMultiButtonDls) this.f13390j).c(button, (View.OnClickListener) arrayList.get(arrayList2.indexOf(button)));
        }
        this.f13390j.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_rlcs_viewer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.f13387f = toolbar;
        toolbar.setTitle((int) R.string.viewing_logs_title);
        z0(this.f13387f);
        p0().u(true);
        p0().w(true);
        this.f13388g = (RecyclerView) findViewById(R.id.recycler);
        this.f13392l = new i9.b();
        this.f13388g.setLayoutManager(new LinearLayoutManager(this));
        this.f13388g.setAdapter(this.f13392l);
        this.f13393m = true;
        this.f13394n = new HashSet();
        this.f13395p = new HashSet();
        f K0 = K0(F0(), this);
        this.f13391k = K0;
        K0.start();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rlcs_viewer, menu);
        menu.findItem(R.id.menu_item_auto_scroll).setTitle(getString(R.string.auto_scroll_menu_item, new Object[]{String.valueOf(this.f13393m)}));
        MenuItem findItem = menu.findItem(R.id.menu_item_filter);
        if (this.f13395p.isEmpty()) {
            findItem.setIcon(R.drawable.ic_discoverfilter);
        } else {
            findItem.setActionView(R.layout.menu_item_filters_on);
            findItem.getActionView().setOnClickListener(new a());
        }
        menu.findItem(R.id.menu_item_change_num_cached_lines).setTitle(getString(R.string.num_lines_to_cache_menu_item, new Object[]{Integer.valueOf(this.f13396q)}));
        return true;
    }

    public void onDestroy() {
        c.h(this.f13389h);
        c.h(this.f13390j);
        this.f13391k.stop();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home) {
            finish();
        } else if (menuItem.getItemId() == R.id.menu_item_auto_scroll) {
            this.f13393m = !this.f13393m;
            p0().m();
        } else if (menuItem.getItemId() == R.id.menu_item_filter) {
            this.f13391k.e();
        } else if (menuItem.getItemId() == R.id.menu_item_change_num_cached_lines) {
            this.f13391k.a();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void v() {
        a aVar = new a(this, this.f13394n, this.f13395p, this);
        this.f13389h = aVar;
        aVar.show();
    }
}
