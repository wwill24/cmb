package ea;

import android.view.View;
import com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem;
import com.coffeemeetsbagel.likes_you.presentation.c;
import java.util.List;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f40650a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f40651b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40652c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LikesYouGridUiItem.c f40653d;

    public /* synthetic */ h(f fVar, c cVar, List list, LikesYouGridUiItem.c cVar2) {
        this.f40650a = fVar;
        this.f40651b = cVar;
        this.f40652c = list;
        this.f40653d = cVar2;
    }

    public final void onClick(View view) {
        c.Z(this.f40650a, this.f40651b, this.f40652c, this.f40653d, view);
    }
}
