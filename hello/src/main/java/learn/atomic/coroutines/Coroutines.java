package learn.atomic.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class Coroutines {
    public static <T> void resumeCoroutineAfterDelay(Continuation<T> continuation, long delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                continuation.resumeWith(Unit.INSTANCE);
            } catch (InterruptedException intrEx) {
                // exiting
            }
        }).start();
    }
}
