package ed.lab;

import java.util.*;

public class E01MeetingRooms {
    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        int count = 0;
        Map<Integer, MeetingInterval> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (MeetingInterval m : meetingIntervals) {
            map.put(m.endTime(), m);
            pq.add(m.endTime());
        }
        List<MeetingInterval> activeMeetings = new ArrayList<>();
        while (!pq.isEmpty()) {
            int end = pq.poll();
            MeetingInterval current = map.get(end);
            List<MeetingInterval> updatedActive = new ArrayList<>();
            for (MeetingInterval m : activeMeetings) {
                if (m.endTime() > current.startTime()) {
                    updatedActive.add(m);
                }
            }
            updatedActive.add(current);
            count = Math.max(count, updatedActive.size());
            activeMeetings = updatedActive;
        }
        return count;
    }

}
