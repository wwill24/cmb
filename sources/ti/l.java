package ti;

import android.webkit.MimeTypeMap;
import kotlin.jvm.internal.j;

public final class l implements c {
    public String a(String str) {
        String mimeTypeFromExtension;
        j.g(str, "path");
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl == null || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl)) == null) {
            return "image/*";
        }
        return mimeTypeFromExtension;
    }
}
