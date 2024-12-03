package org.jivesoftware.smackx.filetransfer;

import com.facebook.internal.AnalyticsEvents;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jxmpp.jid.Jid;

public abstract class FileTransfer {
    private static final int BUFFER_SIZE = 8192;
    protected long amountWritten = -1;
    private Error error;
    private Exception exception;
    private String fileName;
    private String filePath;
    private long fileSize;
    protected FileTransferNegotiator negotiator;
    private Jid peer;
    private Status status = Status.initial;
    private final Object statusMonitor = new Object();
    protected String streamID;

    public enum Error {
        not_acceptable("The peer did not find any of the provided stream mechanisms acceptable."),
        bad_file("The provided file to transfer does not exist or could not be read."),
        no_response("The remote user did not respond or the connection timed out."),
        connection("An error occurred over the socket connected to send the file."),
        stream("An error occurred while sending or receiving the file.");
        
        private final String msg;

        private Error(String str) {
            this.msg = str;
        }

        public String getMessage() {
            return this.msg;
        }

        public String toString() {
            return this.msg;
        }
    }

    public enum Status {
        error("Error"),
        initial("Initial"),
        negotiating_transfer("Negotiating Transfer"),
        refused("Refused"),
        negotiating_stream("Negotiating Stream"),
        negotiated("Negotiated"),
        in_progress("In Progress"),
        complete("Complete"),
        cancelled(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED);
        
        private final String status;

        private Status(String str) {
            this.status = str;
        }

        public String toString() {
            return this.status;
        }
    }

    protected FileTransfer(Jid jid, String str, FileTransferNegotiator fileTransferNegotiator) {
        this.peer = jid;
        this.streamID = str;
        this.negotiator = fileTransferNegotiator;
    }

    public abstract void cancel();

    public long getAmountWritten() {
        return this.amountWritten;
    }

    public Error getError() {
        return this.error;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public Jid getPeer() {
        return this.peer;
    }

    public double getProgress() {
        long j10 = this.amountWritten;
        if (j10 <= 0) {
            return 0.0d;
        }
        long j11 = this.fileSize;
        if (j11 <= 0) {
            return 0.0d;
        }
        return ((double) j10) / ((double) j11);
    }

    public Status getStatus() {
        return this.status;
    }

    public String getStreamID() {
        return this.streamID;
    }

    public boolean isDone() {
        Status status2 = this.status;
        return status2 == Status.cancelled || status2 == Status.error || status2 == Status.complete || status2 == Status.refused;
    }

    /* access modifiers changed from: protected */
    public void setError(Error error2) {
        this.error = error2;
    }

    /* access modifiers changed from: protected */
    public void setException(Exception exc) {
        this.exception = exc;
        Status status2 = getStatus();
        Status status3 = Status.error;
        if (status2 != status3) {
            updateStatus(status2, status3);
        }
    }

    /* access modifiers changed from: protected */
    public void setFileInfo(String str, long j10) {
        this.fileName = str;
        this.fileSize = j10;
    }

    /* access modifiers changed from: protected */
    public void setStatus(Status status2) {
        synchronized (this.statusMonitor) {
            this.status = status2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean updateStatus(Status status2, Status status3) {
        synchronized (this.statusMonitor) {
            if (status2 != this.status) {
                return false;
            }
            this.status = status3;
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void writeToStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        this.amountWritten = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0 && !getStatus().equals(Status.cancelled)) {
                outputStream.write(bArr, 0, read);
                this.amountWritten += (long) read;
            }
        }
        if (!getStatus().equals(Status.cancelled) && getError() == null && this.amountWritten != this.fileSize) {
            setStatus(Status.error);
            this.error = Error.connection;
        }
    }

    /* access modifiers changed from: protected */
    public void setFileInfo(String str, String str2, long j10) {
        this.filePath = str;
        this.fileName = str2;
        this.fileSize = j10;
    }
}
