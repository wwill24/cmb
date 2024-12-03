package wc;

import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class e implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return InstrumentUtility.m141listExceptionReportFiles$lambda3(file, str);
    }
}
