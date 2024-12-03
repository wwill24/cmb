package s8;

import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f17524a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17525b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f17526c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f17527d;

    public d(int i10, String str, View.OnClickListener onClickListener, Integer num) {
        j.g(str, "label");
        j.g(onClickListener, "onClickListener");
        this.f17524a = i10;
        this.f17525b = str;
        this.f17526c = onClickListener;
        this.f17527d = num;
    }

    public final int a() {
        return this.f17524a;
    }

    public final String b() {
        return this.f17525b;
    }

    public final Integer c() {
        return this.f17527d;
    }

    public final View.OnClickListener d() {
        return this.f17526c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f17524a == dVar.f17524a && j.b(this.f17525b, dVar.f17525b) && j.b(this.f17526c, dVar.f17526c) && j.b(this.f17527d, dVar.f17527d);
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.f17524a) * 31) + this.f17525b.hashCode()) * 31) + this.f17526c.hashCode()) * 31;
        Integer num = this.f17527d;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        int i10 = this.f17524a;
        String str = this.f17525b;
        View.OnClickListener onClickListener = this.f17526c;
        Integer num = this.f17527d;
        return "OverflowDialogItem(drawable=" + i10 + ", label=" + str + ", onClickListener=" + onClickListener + ", numNotifications=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i10, String str, View.OnClickListener onClickListener, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, onClickListener, (i11 & 8) != 0 ? 0 : num);
    }
}
