package zc;

import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ErrorReportHandler.m148sendErrorReports$lambda0((ErrorReportData) obj, (ErrorReportData) obj2);
    }
}
