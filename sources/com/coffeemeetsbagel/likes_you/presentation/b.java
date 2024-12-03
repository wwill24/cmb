package com.coffeemeetsbagel.likes_you.presentation;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem;
import da.e;
import ea.f;
import ea.g;
import kotlin.jvm.internal.j;

public final class b extends RecyclerView.d0 {

    /* renamed from: u  reason: collision with root package name */
    private final e f34297u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar.getRoot());
        j.g(eVar, "binding");
        this.f34297u = eVar;
    }

    /* access modifiers changed from: private */
    public static final void X(f fVar, View view) {
        j.g(fVar, "$itemClickListener");
        fVar.c();
    }

    public final void W(f fVar, LikesYouGridUiItem.e eVar) {
        j.g(fVar, "itemClickListener");
        j.g(eVar, "item");
        this.f34297u.f40585d.setOnClickListener(new g(fVar));
        this.f34297u.f40586e.setText(eVar.c());
        this.f34297u.f40583b.setImageResource(eVar.b());
    }
}
