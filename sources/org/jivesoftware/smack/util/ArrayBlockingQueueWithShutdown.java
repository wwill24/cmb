package org.jivesoftware.smack.util;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueueWithShutdown<E> extends AbstractQueue<E> implements BlockingQueue<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public int count;
    private volatile boolean isShutdown;
    /* access modifiers changed from: private */
    public final E[] items;
    /* access modifiers changed from: private */
    public final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    /* access modifiers changed from: private */
    public int putIndex;
    /* access modifiers changed from: private */
    public int takeIndex;

    private class Itr implements Iterator<E> {
        private int lastRet = -1;
        private int nextIndex;
        private E nextItem;

        Itr() {
            if (ArrayBlockingQueueWithShutdown.this.count == 0) {
                this.nextIndex = -1;
                return;
            }
            this.nextIndex = ArrayBlockingQueueWithShutdown.this.takeIndex;
            this.nextItem = ArrayBlockingQueueWithShutdown.this.items[ArrayBlockingQueueWithShutdown.this.takeIndex];
        }

        private void checkNext() {
            if (this.nextIndex == ArrayBlockingQueueWithShutdown.this.putIndex) {
                this.nextIndex = -1;
                this.nextItem = null;
                return;
            }
            E e10 = ArrayBlockingQueueWithShutdown.this.items[this.nextIndex];
            this.nextItem = e10;
            if (e10 == null) {
                this.nextIndex = -1;
            }
        }

        public boolean hasNext() {
            return this.nextIndex >= 0;
        }

        public E next() {
            ArrayBlockingQueueWithShutdown.this.lock.lock();
            try {
                int i10 = this.nextIndex;
                if (i10 >= 0) {
                    this.lastRet = i10;
                    E e10 = this.nextItem;
                    this.nextIndex = ArrayBlockingQueueWithShutdown.this.inc(i10);
                    checkNext();
                    return e10;
                }
                throw new NoSuchElementException();
            } finally {
                ArrayBlockingQueueWithShutdown.this.lock.unlock();
            }
        }

        public void remove() {
            ArrayBlockingQueueWithShutdown.this.lock.lock();
            try {
                int i10 = this.lastRet;
                if (i10 >= 0) {
                    this.lastRet = -1;
                    int access$300 = ArrayBlockingQueueWithShutdown.this.takeIndex;
                    ArrayBlockingQueueWithShutdown.this.removeAt(i10);
                    if (i10 == access$300) {
                        i10 = ArrayBlockingQueueWithShutdown.this.takeIndex;
                    }
                    this.nextIndex = i10;
                    checkNext();
                    return;
                }
                throw new IllegalStateException();
            } finally {
                ArrayBlockingQueueWithShutdown.this.lock.unlock();
            }
        }
    }

    public enum TryPutResult {
        couldNotLock,
        queueWasShutDown,
        queueWasFull,
        putSuccessful
    }

    public enum TryTakeResultCode {
        couldNotLock,
        queueWasShutDown,
        queueWasEmpty,
        takeSuccessful
    }

    static {
        Class<ArrayBlockingQueueWithShutdown> cls = ArrayBlockingQueueWithShutdown.class;
    }

    public ArrayBlockingQueueWithShutdown(int i10) {
        this(i10, false);
    }

    private static void checkNotNull(Object obj) {
        obj.getClass();
    }

    private void checkNotShutdown() throws InterruptedException {
        if (this.isShutdown) {
            throw new InterruptedException("Queue was already shut down");
        }
    }

    private E extract() {
        E[] eArr = this.items;
        int i10 = this.takeIndex;
        E e10 = eArr[i10];
        eArr[i10] = null;
        this.takeIndex = inc(i10);
        this.count--;
        this.notFull.signal();
        return e10;
    }

    private boolean hasElements() {
        return !hasNoElements();
    }

    private boolean hasNoElements() {
        return this.count == 0;
    }

    /* access modifiers changed from: private */
    public int inc(int i10) {
        int i11 = i10 + 1;
        if (i11 == this.items.length) {
            return 0;
        }
        return i11;
    }

    private void insert(E e10) {
        insert(e10, true);
    }

    private boolean isFull() {
        return this.count == this.items.length;
    }

    private boolean isNotFull() {
        return !isFull();
    }

    private void putInternal(E e10, boolean z10) throws InterruptedException {
        while (isFull()) {
            try {
                this.notFull.await();
                checkNotShutdown();
            } catch (InterruptedException e11) {
                this.notFull.signal();
                throw e11;
            }
        }
        insert(e10, z10);
    }

    /* access modifiers changed from: private */
    public void removeAt(int i10) {
        int i11 = this.takeIndex;
        if (i10 == i11) {
            this.items[i11] = null;
            this.takeIndex = inc(i11);
        } else {
            while (true) {
                int inc = inc(i10);
                if (inc == this.putIndex) {
                    break;
                }
                E[] eArr = this.items;
                eArr[i10] = eArr[inc];
                i10 = inc;
            }
            this.items[i10] = null;
            this.putIndex = i10;
        }
        this.count--;
        this.notFull.signal();
    }

    public int drainTo(Collection<? super E> collection) {
        checkNotNull(collection);
        if (collection != this) {
            this.lock.lock();
            try {
                int i10 = this.takeIndex;
                int i11 = 0;
                while (i11 < this.count) {
                    collection.add(this.items[i10]);
                    this.items[i10] = null;
                    i10 = inc(i10);
                    i11++;
                }
                if (i11 > 0) {
                    this.count = 0;
                    this.putIndex = 0;
                    this.takeIndex = 0;
                    this.notFull.signalAll();
                }
                return i11;
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isShutdown() {
        this.lock.lock();
        try {
            return this.isShutdown;
        } finally {
            this.lock.unlock();
        }
    }

    public Iterator<E> iterator() {
        this.lock.lock();
        try {
            return new Itr();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean offer(E e10) {
        boolean z10;
        checkNotNull(e10);
        this.lock.lock();
        try {
            if (!isFull()) {
                if (!this.isShutdown) {
                    insert(e10);
                    z10 = true;
                    return z10;
                }
            }
            z10 = false;
            return z10;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean offerAndShutdown(E e10) {
        checkNotNull(e10);
        this.lock.lock();
        try {
            boolean offer = offer(e10);
            shutdown();
            return offer;
        } finally {
            this.lock.unlock();
        }
    }

    public E peek() {
        E e10;
        this.lock.lock();
        try {
            if (hasNoElements()) {
                e10 = null;
            } else {
                e10 = this.items[this.takeIndex];
            }
            return e10;
        } finally {
            this.lock.unlock();
        }
    }

    public E poll() {
        E extract;
        this.lock.lock();
        try {
            if (hasNoElements()) {
                extract = null;
            } else {
                extract = extract();
            }
            return extract;
        } finally {
            this.lock.unlock();
        }
    }

    public void put(E e10) throws InterruptedException {
        checkNotNull(e10);
        this.lock.lockInterruptibly();
        try {
            putInternal(e10, true);
        } finally {
            this.lock.unlock();
        }
    }

    public void putAll(Collection<? extends E> collection) throws InterruptedException {
        checkNotNull(collection);
        this.lock.lockInterruptibly();
        try {
            for (Object putInternal : collection) {
                putInternal(putInternal, false);
            }
        } finally {
            this.notEmpty.signalAll();
            this.lock.unlock();
        }
    }

    public boolean putIfNotShutdown(E e10) throws InterruptedException {
        checkNotNull(e10);
        this.lock.lockInterruptibly();
        try {
            if (this.isShutdown) {
                return false;
            }
            putInternal(e10, true);
            this.lock.unlock();
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    public int remainingCapacity() {
        this.lock.lock();
        try {
            return this.items.length - this.count;
        } finally {
            this.lock.unlock();
        }
    }

    public void shutdown() {
        this.lock.lock();
        try {
            this.isShutdown = true;
            this.notEmpty.signalAll();
            this.notFull.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    public int size() {
        this.lock.lock();
        try {
            return this.count;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean start() {
        this.lock.lock();
        try {
            boolean z10 = this.isShutdown;
            this.isShutdown = false;
            return z10;
        } finally {
            this.lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        this.lock.lockInterruptibly();
        try {
            checkNotShutdown();
            while (hasNoElements()) {
                this.notEmpty.await();
                checkNotShutdown();
            }
            E extract = extract();
            this.lock.unlock();
            return extract;
        } catch (InterruptedException e10) {
            this.notEmpty.signal();
            throw e10;
        } catch (Throwable th2) {
            this.lock.unlock();
            throw th2;
        }
    }

    public TryPutResult tryPut(E e10) {
        TryPutResult tryPutResult;
        checkNotNull(e10);
        if (!this.lock.tryLock()) {
            return TryPutResult.couldNotLock;
        }
        try {
            if (this.isShutdown) {
                tryPutResult = TryPutResult.queueWasShutDown;
            } else if (isFull()) {
                tryPutResult = TryPutResult.queueWasFull;
            } else {
                insert(e10);
                tryPutResult = TryPutResult.putSuccessful;
            }
            return tryPutResult;
        } finally {
            this.lock.unlock();
        }
    }

    public TryTakeResult<E> tryTake() {
        if (!this.lock.tryLock()) {
            return new TryTakeResult<>(TryTakeResultCode.couldNotLock);
        }
        try {
            if (this.isShutdown) {
                return new TryTakeResult<>(TryTakeResultCode.queueWasShutDown);
            }
            if (hasNoElements()) {
                TryTakeResult<E> tryTakeResult = new TryTakeResult<>(TryTakeResultCode.queueWasEmpty);
                this.lock.unlock();
                return tryTakeResult;
            }
            TryTakeResult<E> tryTakeResult2 = new TryTakeResult<>(extract());
            this.lock.unlock();
            return tryTakeResult2;
        } finally {
            this.lock.unlock();
        }
    }

    public static final class TryTakeResult<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final E element;
        private final TryTakeResultCode resultCode;

        static {
            Class<ArrayBlockingQueueWithShutdown> cls = ArrayBlockingQueueWithShutdown.class;
        }

        public E getElement() {
            return this.element;
        }

        public TryTakeResultCode getResultCode() {
            return this.resultCode;
        }

        private TryTakeResult(TryTakeResultCode tryTakeResultCode) {
            this.resultCode = tryTakeResultCode;
            this.element = null;
        }

        private TryTakeResult(E e10) {
            this.resultCode = TryTakeResultCode.takeSuccessful;
            this.element = e10;
        }
    }

    public ArrayBlockingQueueWithShutdown(int i10, boolean z10) {
        this.isShutdown = false;
        if (i10 > 0) {
            this.items = new Object[i10];
            ReentrantLock reentrantLock = new ReentrantLock(z10);
            this.lock = reentrantLock;
            this.notEmpty = reentrantLock.newCondition();
            this.notFull = reentrantLock.newCondition();
            return;
        }
        throw new IllegalArgumentException();
    }

    private void insert(E e10, boolean z10) {
        E[] eArr = this.items;
        int i10 = this.putIndex;
        eArr[i10] = e10;
        this.putIndex = inc(i10);
        this.count++;
        if (z10) {
            this.notEmpty.signal();
        }
    }

    public boolean offer(E e10, long j10, TimeUnit timeUnit) throws InterruptedException {
        boolean z10;
        checkNotNull(e10);
        long nanos = timeUnit.toNanos(j10);
        this.lock.lockInterruptibly();
        while (true) {
            try {
                if (isNotFull()) {
                    insert(e10);
                    z10 = true;
                    break;
                } else if (nanos <= 0) {
                    z10 = false;
                    break;
                } else {
                    nanos = this.notFull.awaitNanos(nanos);
                    checkNotShutdown();
                }
            } catch (InterruptedException e11) {
                this.notFull.signal();
                throw e11;
            } catch (Throwable th2) {
                this.lock.unlock();
                throw th2;
            }
        }
        this.lock.unlock();
        return z10;
    }

    public E poll(long j10, TimeUnit timeUnit) throws InterruptedException {
        E extract;
        long nanos = timeUnit.toNanos(j10);
        this.lock.lockInterruptibly();
        try {
            checkNotShutdown();
            while (true) {
                if (hasElements()) {
                    extract = extract();
                    break;
                } else if (nanos <= 0) {
                    extract = null;
                    break;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                    checkNotShutdown();
                }
            }
            this.lock.unlock();
            return extract;
        } catch (InterruptedException e10) {
            this.notEmpty.signal();
            throw e10;
        } catch (Throwable th2) {
            this.lock.unlock();
            throw th2;
        }
    }

    public int drainTo(Collection<? super E> collection, int i10) {
        checkNotNull(collection);
        if (collection != this) {
            int i11 = 0;
            if (i10 <= 0) {
                return 0;
            }
            this.lock.lock();
            try {
                int i12 = this.takeIndex;
                int i13 = this.count;
                if (i10 >= i13) {
                    i10 = i13;
                }
                while (i11 < i10) {
                    collection.add(this.items[i12]);
                    this.items[i12] = null;
                    i12 = inc(i12);
                    i11++;
                }
                if (i11 > 0) {
                    this.count -= i11;
                    this.takeIndex = i12;
                    this.notFull.signalAll();
                }
                return i11;
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
