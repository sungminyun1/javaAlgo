package anything;

public class ThreadSafety {
    private final Object myLock = new Object();
    public int val;

    void sync(){
        synchronized (myLock){
            val++;
        }
    }
}
