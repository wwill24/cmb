package b3;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class y {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7821a = JsonReader.a.a("nm", "mm", "hd");

    static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        boolean z10 = false;
        MergePaths.MergePathsMode mergePathsMode = null;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7821a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                mergePathsMode = MergePaths.MergePathsMode.b(jsonReader.l());
            } else if (y10 != 2) {
                jsonReader.C();
                jsonReader.E();
            } else {
                z10 = jsonReader.h();
            }
        }
        return new MergePaths(str, mergePathsMode, z10);
    }
}
