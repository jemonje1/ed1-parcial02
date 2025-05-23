package ed.lab;

import java.util.HashMap;

public class E02Logger {
    public HashMap<String, Integer> map = new HashMap<>();
    public E02Logger() {
        map = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp >= map.get(message)) {
            map.put(message, timestamp + 10);
            return true;
        }
        else {
            return false;
        }
    }

}
