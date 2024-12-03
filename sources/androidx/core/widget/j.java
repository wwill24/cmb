package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

public final class j {

    static class a {
        static boolean a(ListView listView, int i10) {
            return listView.canScrollList(i10);
        }

        static void b(ListView listView, int i10) {
            listView.scrollListBy(i10);
        }
    }

    public static void a(@NonNull ListView listView, int i10) {
        a.b(listView, i10);
    }
}
