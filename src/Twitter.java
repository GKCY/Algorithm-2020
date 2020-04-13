import java.util.*;

public class Twitter {
    private int  timestamp = 0;
    public HashMap<Integer, User> userMap;

    class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            next = null;
        }
    }

    class User {
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            followed = new HashSet<>();
            this.id = id;
            this.head = null;
            follow(id);
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            //不可以取关自己
            if (id != this.id)
                followed.remove(id);
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            this.head = tweet;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId))
            userMap.put(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId))
            return res;
        Set<Integer> follow = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(follow.size(), (a, b) -> (b.time-a.time));
        for (int followId:
                follow) {
            Tweet tweet = userMap.get(followId).head;
            if (tweet != null)
                pq.add(tweet);
        }

        while (!pq.isEmpty()) {
            if (res.size() == 10)
                break;
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (tweet.next != null)
                pq.add(tweet.next);
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId))
            userMap.put(followerId, new User(followerId));
        if (!userMap.containsKey(followeeId))
            userMap.put(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter t = new Twitter();
        System.out.println(t.getNewsFeed(1));

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

