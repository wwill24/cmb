package org.jivesoftware.smack.roster;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.SubscribeListener;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

public class RosterUtil {
    public static void askForSubscriptionIfRequired(Roster roster, BareJid bareJid) throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException {
        RosterEntry entry = roster.getEntry(bareJid);
        if (entry == null || (!entry.canSeeHisPresence() && !entry.isSubscriptionPending())) {
            roster.sendSubscriptionRequest(bareJid);
        }
    }

    public static void ensureNotSubscribed(Roster roster, BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException {
        RosterEntry entry = roster.getEntry(bareJid);
        if (entry != null && entry.canSeeMyPresence()) {
            entry.cancelSubscription();
        }
    }

    public static void ensureNotSubscribedToEachOther(XMPPConnection xMPPConnection, XMPPConnection xMPPConnection2) throws SmackException.NotConnectedException, InterruptedException {
        Roster instanceFor = Roster.getInstanceFor(xMPPConnection);
        BareJid i12 = xMPPConnection.getUser().i1();
        Roster instanceFor2 = Roster.getInstanceFor(xMPPConnection2);
        ensureNotSubscribed(instanceFor, xMPPConnection2.getUser().i1());
        ensureNotSubscribed(instanceFor2, i12);
    }

    public static void ensureSubscribed(XMPPConnection xMPPConnection, XMPPConnection xMPPConnection2, long j10) throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException, TimeoutException {
        ensureSubscribedTo(xMPPConnection, xMPPConnection2, j10);
        ensureSubscribedTo(xMPPConnection2, xMPPConnection, j10);
    }

    public static void ensureSubscribedTo(XMPPConnection xMPPConnection, XMPPConnection xMPPConnection2, long j10) throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException, TimeoutException {
        ensureSubscribedTo(xMPPConnection, xMPPConnection2, new Date(System.currentTimeMillis() + j10));
    }

    public static void preApproveSubscriptionIfRequiredAndPossible(Roster roster, BareJid bareJid) throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException {
        if (roster.isSubscriptionPreApprovalSupported()) {
            RosterEntry entry = roster.getEntry(bareJid);
            if (entry == null || (!entry.canSeeMyPresence() && !entry.isApproved())) {
                try {
                    roster.preApprove(bareJid);
                } catch (SmackException.FeatureNotSupportedException e10) {
                    throw new AssertionError(e10);
                }
            }
        }
    }

    public static void waitUntilOtherEntityIsSubscribed(Roster roster, BareJid bareJid, long j10) throws InterruptedException, TimeoutException {
        waitUntilOtherEntityIsSubscribed(roster, bareJid, new Date(System.currentTimeMillis() + j10));
    }

    public static void ensureSubscribedTo(XMPPConnection xMPPConnection, XMPPConnection xMPPConnection2, Date date) throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException, TimeoutException {
        Roster instanceFor = Roster.getInstanceFor(xMPPConnection);
        BareJid i12 = xMPPConnection2.getUser().i1();
        if (!instanceFor.iAmSubscribedTo(i12)) {
            final BareJid i13 = xMPPConnection.getUser().i1();
            AnonymousClass2 r22 = new SubscribeListener() {
                public SubscribeListener.SubscribeAnswer processSubscribe(Jid jid, Presence presence) {
                    if (jid.Y(BareJid.this)) {
                        return SubscribeListener.SubscribeAnswer.Approve;
                    }
                    return null;
                }
            };
            Roster instanceFor2 = Roster.getInstanceFor(xMPPConnection2);
            instanceFor2.addSubscribeListener(r22);
            try {
                instanceFor.sendSubscriptionRequest(i12);
                waitUntilOtherEntityIsSubscribed(instanceFor2, i13, date);
            } finally {
                instanceFor2.removeSubscribeListener(r22);
            }
        }
    }

    public static void waitUntilOtherEntityIsSubscribed(Roster roster, BareJid bareJid, Date date) throws InterruptedException, TimeoutException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        AnonymousClass1 r22 = new AbstractRosterListener() {
            private void signal() {
                reentrantLock.lock();
                try {
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }

            public void entriesAdded(Collection<Jid> collection) {
                signal();
            }

            public void entriesUpdated(Collection<Jid> collection) {
                signal();
            }
        };
        roster.addRosterListener(r22);
        reentrantLock.lock();
        boolean z10 = true;
        while (!roster.isSubscribedToMyPresence(bareJid)) {
            try {
                if (z10) {
                    z10 = newCondition.awaitUntil(date);
                } else {
                    throw new TimeoutException();
                }
            } finally {
                reentrantLock.unlock();
                roster.removeRosterListener(r22);
            }
        }
    }
}
