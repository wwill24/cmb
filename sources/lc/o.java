package lc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.coffeemeetsbagel.bakery.Bakery;
import java.io.File;

public class o {
    public static Uri a(String str, Context context) {
        return FileProvider.f(context, "com.coffeemeetsbagel.fileprovider", new File(str));
    }

    public static void b(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("localFilePath=");
        sb2.append(str);
        boolean delete = new File(str).delete();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("file ");
        sb3.append(str);
        sb3.append(" deletion status=");
        sb3.append(delete);
    }

    public static String c(Uri uri) throws Exception {
        if (uri != null) {
            Cursor query = Bakery.w().getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query == null || query.getColumnIndex("_data") == -1) {
                return uri.getPath();
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            query.close();
            return string;
        }
        throw new IllegalArgumentException("contentUri null!");
    }

    public static void d(String str, String str2, String str3) {
        File file = new File(str3);
        File file2 = new File(str);
        File file3 = new File(str2);
        file2.renameTo(file);
        file3.renameTo(file2);
        file.renameTo(file3);
    }
}
