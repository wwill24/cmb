package y4;

import android.graphics.Bitmap;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class u implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityMain f18720a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f18721b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LeanPlumPaintedDoorDefinitions.PaintedDoor f18722c;

    public /* synthetic */ u(ActivityMain activityMain, String str, LeanPlumPaintedDoorDefinitions.PaintedDoor paintedDoor) {
        this.f18720a = activityMain;
        this.f18721b = str;
        this.f18722c = paintedDoor;
    }

    public final Object invoke(Object obj) {
        return this.f18720a.j3(this.f18721b, this.f18722c, (Bitmap) obj);
    }
}
