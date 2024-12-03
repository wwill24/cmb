package zc;

import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class c implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return ErrorReportHandler.m147listErrorReportFiles$lambda3(file, str);
    }
}
