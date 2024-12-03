package t8;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.coffeemeetsbagel.photo.Photo;
import java.util.List;
import jc.b;

public interface l {

    public interface a {
        void a();
    }

    String a(int i10);

    void b(List<Photo> list);

    void c(b<Integer> bVar, String str, int i10);

    void clear();

    String d();

    String e();

    void f(int i10);

    String g(Bitmap bitmap, Activity activity, Uri uri, String str);

    void h(Activity activity, int i10, boolean z10, String str, String str2);

    void i(Activity activity, int i10, int i11, Intent intent);

    void j(Activity activity, int i10, String str);

    boolean k(Uri uri, String str, int i10, Activity activity, boolean z10, String str2, String str3, String str4, boolean z11, boolean z12);

    void l(Activity activity, int i10, boolean z10, String str, String str2, View view, a aVar);
}
