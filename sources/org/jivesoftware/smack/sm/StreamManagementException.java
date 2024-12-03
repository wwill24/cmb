package org.jivesoftware.smack.sm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.Stanza;

public abstract class StreamManagementException extends SmackException {
    private static final long serialVersionUID = 3767590115788821101L;

    public static class StreamIdDoesNotMatchException extends StreamManagementException {
        private static final long serialVersionUID = 1191073341336559621L;

        public StreamIdDoesNotMatchException(String str, String str2) {
            super("Stream IDs do not match. Expected '" + str + "', but got '" + str2 + "'");
        }
    }

    public static class StreamManagementCounterError extends StreamManagementException {
        private static final long serialVersionUID = 1;
        private final long ackedStanzaCount;
        private final List<Stanza> ackedStanzas;
        private final long handledCount;
        private final int outstandingStanzasCount;
        private final long previousServerHandledCount;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public StreamManagementCounterError(long r3, long r5, long r7, java.util.List<org.jivesoftware.smack.packet.Stanza> r9) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "There was an error regarding the Stream Management counters. Server reported "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " handled stanzas, which means that the "
                r0.append(r1)
                r0.append(r7)
                java.lang.String r1 = " recently send stanzas by client are now acked by the server. But Smack had only "
                r0.append(r1)
                int r1 = r9.size()
                r0.append(r1)
                java.lang.String r1 = " to acknowledge. The stanza id of the last acked outstanding stanza is "
                r0.append(r1)
                boolean r1 = r9.isEmpty()
                if (r1 == 0) goto L_0x002f
                java.lang.String r1 = "<no acked stanzas>"
                goto L_0x003f
            L_0x002f:
                int r1 = r9.size()
                int r1 = r1 + -1
                java.lang.Object r1 = r9.get(r1)
                org.jivesoftware.smack.packet.Stanza r1 = (org.jivesoftware.smack.packet.Stanza) r1
                java.lang.String r1 = r1.getStanzaId()
            L_0x003f:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                r2.handledCount = r3
                r2.previousServerHandledCount = r5
                r2.ackedStanzaCount = r7
                int r3 = r9.size()
                r2.outstandingStanzasCount = r3
                java.util.List r3 = java.util.Collections.unmodifiableList(r9)
                r2.ackedStanzas = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.sm.StreamManagementException.StreamManagementCounterError.<init>(long, long, long, java.util.List):void");
        }

        public long getAckedStanzaCount() {
            return this.ackedStanzaCount;
        }

        public List<Stanza> getAckedStanzas() {
            return this.ackedStanzas;
        }

        public long getHandledCount() {
            return this.handledCount;
        }

        public int getOutstandingStanzasCount() {
            return this.outstandingStanzasCount;
        }

        public long getPreviousServerHandledCount() {
            return this.previousServerHandledCount;
        }
    }

    public static class StreamManagementNotEnabledException extends StreamManagementException {
        private static final long serialVersionUID = 2624821584352571307L;
    }

    public static final class UnacknowledgedQueueFullException extends StreamManagementException {
        private static final long serialVersionUID = 1;
        private final int droppedElements;
        private final List<Element> elements;
        private final int overflowElementNum;
        private final List<Stanza> unacknowledgesStanzas;

        private UnacknowledgedQueueFullException(String str, int i10, int i11, List<Element> list, List<Stanza> list2) {
            super(str);
            this.overflowElementNum = i10;
            this.droppedElements = i11;
            this.elements = list;
            this.unacknowledgesStanzas = list2;
        }

        public static UnacknowledgedQueueFullException newWith(int i10, List<Element> list, BlockingQueue<Stanza> blockingQueue) {
            int size = blockingQueue.size();
            ArrayList arrayList = new ArrayList(size);
            arrayList.addAll(blockingQueue);
            int size2 = (list.size() - i10) - 1;
            return new UnacknowledgedQueueFullException("The queue size " + size + " is not able to fit another " + size2 + " potential stanzas type top-level stream-elements.", i10, size2, list, arrayList);
        }

        public int getDroppedElements() {
            return this.droppedElements;
        }

        public List<Element> getElements() {
            return this.elements;
        }

        public int getOverflowElementNum() {
            return this.overflowElementNum;
        }

        public List<Stanza> getUnacknowledgesStanzas() {
            return this.unacknowledgesStanzas;
        }
    }

    public StreamManagementException() {
    }

    public StreamManagementException(String str) {
        super(str);
    }
}
