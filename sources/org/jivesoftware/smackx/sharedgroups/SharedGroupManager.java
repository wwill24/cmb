package org.jivesoftware.smackx.sharedgroups;

import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.sharedgroups.packet.SharedGroupsInfo;

public class SharedGroupManager {
    public static List<String> getSharedGroups(XMPPConnection xMPPConnection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        SharedGroupsInfo sharedGroupsInfo = new SharedGroupsInfo();
        sharedGroupsInfo.setType(IQ.Type.get);
        return ((SharedGroupsInfo) xMPPConnection.createStanzaCollectorAndSend(sharedGroupsInfo).nextResultOrThrow()).getGroups();
    }
}
