package com.coffeemeetsbagel.likes_you.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem;
import da.d;
import ea.e;
import ea.f;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class a extends q<LikesYouGridUiItem, RecyclerView.d0> {

    /* renamed from: k  reason: collision with root package name */
    public static final C0410a f34292k = new C0410a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private final f f34293f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageLoaderContract f34294g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f34295h;

    /* renamed from: j  reason: collision with root package name */
    private final String f34296j = "LikesYouGridAdapter";

    /* renamed from: com.coffeemeetsbagel.likes_you.presentation.a$a  reason: collision with other inner class name */
    public static final class C0410a extends h.f<LikesYouGridUiItem> {
        private C0410a() {
        }

        public /* synthetic */ C0410a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public boolean a(LikesYouGridUiItem likesYouGridUiItem, LikesYouGridUiItem likesYouGridUiItem2) {
            j.g(likesYouGridUiItem, "oldItem");
            j.g(likesYouGridUiItem2, "newItem");
            return j.b(likesYouGridUiItem, likesYouGridUiItem2);
        }

        /* renamed from: e */
        public boolean b(LikesYouGridUiItem likesYouGridUiItem, LikesYouGridUiItem likesYouGridUiItem2) {
            j.g(likesYouGridUiItem, "oldItem");
            j.g(likesYouGridUiItem2, "newItem");
            if ((likesYouGridUiItem instanceof LikesYouGridUiItem.c) && (likesYouGridUiItem2 instanceof LikesYouGridUiItem.c)) {
                return j.b(((LikesYouGridUiItem.c) likesYouGridUiItem).f(), ((LikesYouGridUiItem.c) likesYouGridUiItem2).f());
            }
            if (!(likesYouGridUiItem2 instanceof LikesYouGridUiItem.d) || !(likesYouGridUiItem instanceof LikesYouGridUiItem.d)) {
                return false;
            }
            return j.b(((LikesYouGridUiItem.d) likesYouGridUiItem).c(), ((LikesYouGridUiItem.d) likesYouGridUiItem2).c());
        }
    }

    public static final class b extends RecyclerView.d0 {
        b(View view) {
            super(view);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(f fVar, ImageLoaderContract imageLoaderContract, boolean z10) {
        super(f34292k);
        j.g(fVar, "itemClickListener");
        j.g(imageLoaderContract, "imageLoader");
        this.f34293f = fVar;
        this.f34294g = imageLoaderContract;
        this.f34295h = z10;
    }

    public int i(int i10) {
        return ((LikesYouGridUiItem) H(i10)).a().b();
    }

    public void v(RecyclerView.d0 d0Var, int i10) {
        j.g(d0Var, "holder");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f34296j;
        aVar.a(str, "onBindViewHolder - position " + i10);
        LikesYouGridUiItem likesYouGridUiItem = (LikesYouGridUiItem) H(i10);
        if (likesYouGridUiItem instanceof LikesYouGridUiItem.c) {
            String str2 = this.f34296j;
            LikesYouGridUiItem.c cVar = (LikesYouGridUiItem.c) likesYouGridUiItem;
            boolean h10 = cVar.h();
            aVar.a(str2, "item at position " + i10 + " is blurred? " + h10);
            List G = G();
            j.f(G, "currentList");
            ArrayList<LikesYouGridUiItem.c> arrayList = new ArrayList<>();
            for (Object next : G) {
                if (next instanceof LikesYouGridUiItem.c) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
            for (LikesYouGridUiItem.c cVar2 : arrayList) {
                arrayList2.add(new Triple(cVar2.f(), cVar2.c(), cVar2.g()));
            }
            ((c) d0Var).Y(cVar, this.f34293f, arrayList2);
        } else if (likesYouGridUiItem instanceof LikesYouGridUiItem.d) {
            ((c) d0Var).a0((LikesYouGridUiItem.d) likesYouGridUiItem, this.f34293f);
        } else if (likesYouGridUiItem instanceof LikesYouGridUiItem.e) {
            ((b) d0Var).W(this.f34293f, (LikesYouGridUiItem.e) likesYouGridUiItem);
        } else if (likesYouGridUiItem instanceof LikesYouGridUiItem.b) {
            ((e) d0Var).W(this.f34293f);
        }
    }

    public RecyclerView.d0 x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        if (i10 == LikesYouGridUiItem.ViewType.UPSELL_CARD.b()) {
            da.e c10 = da.e.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            j.f(c10, "inflate(\n               …  false\n                )");
            ViewGroup.LayoutParams layoutParams = c10.getRoot().getLayoutParams();
            j.e(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            ((StaggeredGridLayoutManager.c) layoutParams).f(true);
            return new b(c10);
        } else if (i10 == LikesYouGridUiItem.ViewType.CARD.b()) {
            d c11 = d.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            j.f(c11, "inflate(\n               …  false\n                )");
            ViewGroup.LayoutParams layoutParams2 = c11.getRoot().getLayoutParams();
            j.e(layoutParams2, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            ((StaggeredGridLayoutManager.c) layoutParams2).f(false);
            return new c(c11, this.f34294g, this.f34295h);
        } else if (i10 != LikesYouGridUiItem.ViewType.EDIT_PREFS_CARD.b()) {
            return new b(new View(viewGroup.getContext()));
        } else {
            da.b c12 = da.b.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            j.f(c12, "inflate(\n               …  false\n                )");
            ViewGroup.LayoutParams layoutParams3 = c12.getRoot().getLayoutParams();
            j.e(layoutParams3, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            ((StaggeredGridLayoutManager.c) layoutParams3).f(true);
            return new e(c12);
        }
    }
}
