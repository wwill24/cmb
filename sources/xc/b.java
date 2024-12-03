package xc;

import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ANRHandler.m143sendANRReports$lambda2((InstrumentData) obj, (InstrumentData) obj2);
    }
}
