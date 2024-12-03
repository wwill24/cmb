package com.coffemeetsbagel.hide_report.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import com.coffeemeetsbagel.models.Resource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class d extends q<Resource, C0476d> {

    /* renamed from: j  reason: collision with root package name */
    public static final a f37691j = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private final c f37692f;

    /* renamed from: g  reason: collision with root package name */
    private int f37693g = -1;

    /* renamed from: h  reason: collision with root package name */
    private final e f37694h = new e(this);

    public static final class a extends h.f<Resource> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public boolean a(Resource resource, Resource resource2) {
            j.g(resource, "oldItem");
            j.g(resource2, "newItem");
            return j.b(resource2, resource);
        }

        /* renamed from: e */
        public boolean b(Resource resource, Resource resource2) {
            j.g(resource, "oldItem");
            j.g(resource2, "newItem");
            return j.b(resource.getKey(), resource2.getKey());
        }
    }

    public interface b {
        void a(int i10);
    }

    public interface c {
        void a(Resource resource);
    }

    /* renamed from: com.coffemeetsbagel.hide_report.list.d$d  reason: collision with other inner class name */
    public static final class C0476d extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final rc.d f37695u;

        /* renamed from: v  reason: collision with root package name */
        private final b f37696v;

        /* renamed from: w  reason: collision with root package name */
        private final c f37697w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0476d(rc.d dVar, b bVar, c cVar) {
            super(dVar.getRoot());
            j.g(dVar, "binding");
            j.g(bVar, "itemClickListener");
            j.g(cVar, "listener");
            this.f37695u = dVar;
            this.f37696v = bVar;
            this.f37697w = cVar;
        }

        /* access modifiers changed from: private */
        public static final void X(C0476d dVar, Resource resource, View view) {
            j.g(dVar, "this$0");
            j.g(resource, "$resource");
            dVar.f37696v.a(dVar.r());
            dVar.f37697w.a(resource);
        }

        public final void W(Resource resource, boolean z10) {
            j.g(resource, "resource");
            this.f37695u.f41834b.setOnClickListener(new e(this, resource));
            this.f37695u.f41834b.setText(resource.getValue());
            this.f37695u.f41834b.setChecked(z10);
        }
    }

    public static final class e implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f37698a;

        e(d dVar) {
            this.f37698a = dVar;
        }

        public void a(int i10) {
            this.f37698a.O(i10);
            this.f37698a.l();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(f37691j);
        j.g(cVar, "listener");
        this.f37692f = cVar;
    }

    public final Resource L() {
        Object obj = G().get(this.f37693g);
        j.f(obj, "currentList[selectedPosition]");
        return (Resource) obj;
    }

    /* renamed from: M */
    public void v(C0476d dVar, int i10) {
        j.g(dVar, "holder");
        Object H = H(i10);
        j.f(H, "getItem(position)");
        dVar.W((Resource) H, this.f37693g == i10);
    }

    /* renamed from: N */
    public C0476d x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        rc.d c10 = rc.d.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        j.f(c10, "inflate(inflater, parent, false)");
        return new C0476d(c10, this.f37694h, this.f37692f);
    }

    public final void O(int i10) {
        this.f37693g = i10;
    }
}
