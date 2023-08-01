package testVagrant;


import java.util.*;

public class RecentlyPlayedSongsStore {
   /* OVERVIEW
    Create an in-memory store for recently played songs that can accommodate N songs per user, with a fixed initial capacity. This store must have the capability to store a list of song-user pairs, with each song linked to a user. It should also be able to fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.
    EXAMPLE
    Illustration, when 4 different songs were played by a user & Initial capacity is 3:
    Let's assume that the user has played 3 songs - S1, S2 and S3.
    The playlist would look like -> S1,S2,S3
    When S4 song is played -> S2,S3,S4
    When S2 song is played -> S3,S4,S2
    When S1 song is played -> S4,S2,S1
    */
   //Time Complexity = O(N)
   //Space Complexity = O(U*N) where U is users
    private int capacity;
    private Map<String,  LinkedList<String>> recentPlayedSongs;
    public static void main(String[] args) {
        int initialCapacity = 3;
        RecentlyPlayedSongsStore store = new RecentlyPlayedSongsStore(initialCapacity);

        // User 1
        store.addRecentlyPlayedSong("User1", "S1");
        store.addRecentlyPlayedSong("User1", "S2");
        store.addRecentlyPlayedSong("User1", "S3");

        System.out.println("User1's Recently Played Songs: " + store.getRecentlyPlayedSongs("User1"));


        // User 1 - Plays song S4
        store.addRecentlyPlayedSong("User1", "S4");
        System.out.println("User1's Recently Played Songs after playing song S4: " + store.getRecentlyPlayedSongs("User1"));

        // User 1 - Plays song S2 again
        store.addRecentlyPlayedSong("User1", "S2");
        System.out.println("User1's Recently Played Songs after playing song S2 again: " + store.getRecentlyPlayedSongs("User1"));

        // User 1 - Plays song S1 again
        store.addRecentlyPlayedSong("User1", "S1");
        System.out.println("User1's Recently Played Songs after playing song S1 again: " + store.getRecentlyPlayedSongs("User1"));
    }




    public RecentlyPlayedSongsStore(int capacity) {
        this.capacity = capacity;
        this.recentPlayedSongs = new HashMap<>();
    }


    public void addRecentlyPlayedSong(String user, String song) {
        if (!recentPlayedSongs.containsKey(user)) {
            recentPlayedSongs.put(user,new LinkedList<>() );
        }

        LinkedList<String> songsList = recentPlayedSongs.get(user);

        // Remove the song if it already exists in the list to update its recentness
        songsList.remove(song);

        // Add the song to the beginning of the list
        songsList.add(0, song);

        // Check if the list has exceeded the capacity, remove the least recently played song
        if (songsList.size() > capacity) {
            songsList.removeLast();
        }
    }
    public LinkedList<String> getRecentlyPlayedSongs(String user) {
        return recentPlayedSongs.getOrDefault(user,new LinkedList<>());
    }
}
