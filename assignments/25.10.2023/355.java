class Tweet {
    int tweetId;
    long timestamp;

    public Tweet(int tweetId, long timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }
}

public class Twitter {
    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;
    private long timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timestamp++);
        
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        
        if (!tweets.containsKey(userId)) return feed;

        PriorityQueue<Tweet> feedTweets = new PriorityQueue<>((a, b) -> Long.compare(b.timestamp, a.timestamp));

        feedTweets.addAll(tweets.get(userId));
        
        // System.out.println(following);

        if (following.containsKey(userId)) {
            // System.out.println("getNewsFeed");
            for (int followeeId : following.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    feedTweets.addAll(tweets.get(followeeId));
                }
            }
        }

        int count = 0;
        while (!feedTweets.isEmpty() && count < 10) {
            feed.add(feedTweets.poll().tweetId);
            count++;
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);

        tweets.putIfAbsent(followerId, new ArrayList<>());
        // System.out.println(following);
    }

    public void unfollow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).remove(followeeId);
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