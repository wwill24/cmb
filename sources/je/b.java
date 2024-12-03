package je;

import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f41057a = new b();

    private /* synthetic */ b() {
    }

    public final int compare(Object obj, Object obj2) {
        Feature feature = (Feature) obj;
        Feature feature2 = (Feature) obj2;
        Parcelable.Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
        if (!feature.S().equals(feature2.S())) {
            return feature.S().compareTo(feature2.S());
        }
        return (feature.Y() > feature2.Y() ? 1 : (feature.Y() == feature2.Y() ? 0 : -1));
    }
}
