package com.coffeemeetsbagel.store.subscription_benefits;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import ub.c;

public final class d extends q<vb.b, a> {

    /* renamed from: f  reason: collision with root package name */
    public static final b f36938f = new b((DefaultConstructorMarker) null);

    public static final class a extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final c f36939u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar) {
            super(cVar.getRoot());
            j.g(cVar, "binding");
            this.f36939u = cVar;
        }

        public final void V(vb.b bVar) {
            j.g(bVar, "benefit");
            this.f36939u.f41966d.setText(bVar.f());
            this.f36939u.f41964b.setText(bVar.b());
            com.coffeemeetsbagel.image_loader.b bVar2 = com.coffeemeetsbagel.image_loader.b.f13967a;
            Context context = this.f6302a.getContext();
            j.f(context, "itemView.context");
            ImageLoaderContract.a.a(bVar2, context, bVar.d(), this.f36939u.f41965c, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, (List) null, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4088, (Object) null);
        }
    }

    public static final class b extends h.f<vb.b> {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public boolean a(vb.b bVar, vb.b bVar2) {
            j.g(bVar, "oldItem");
            j.g(bVar2, "newItem");
            return j.b(bVar, bVar2);
        }

        /* renamed from: e */
        public boolean b(vb.b bVar, vb.b bVar2) {
            j.g(bVar, "oldItem");
            j.g(bVar2, "newItem");
            return j.b(bVar.e(), bVar2.e());
        }
    }

    public d() {
        super(f36938f);
    }

    /* renamed from: L */
    public void v(a aVar, int i10) {
        j.g(aVar, "holder");
        Object H = H(i10);
        j.f(H, "getItem(position)");
        aVar.V((vb.b) H);
    }

    /* renamed from: M */
    public a x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        c c10 = c.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        j.f(c10, "inflate(inflater, parent, false)");
        return new a(c10);
    }
}
