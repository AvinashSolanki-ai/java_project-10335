import java.util.Random;

// Step 1: Define Song Class
class Song {
    private String title;
    private String artist;

    // Constructor to initialize song details
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getter methods (Encapsulation)
    public String getTitle() { return title; }
    public String getArtist() { return artist; }

    // Helper method to display details
    public String toString() {
        return title + " - " + artist;
    }
}

// Step 2: Create Playlist Class
class Playlist {
    private Song[] songs; // Array of Song objects (Aggregation)
    private int count;

    public Playlist(int size) {
        songs = new Song[size];
        count = 0;
    }

    // Step 3: Implement addSong() Method
    public void addSong(Song s) {
        if (count < songs.length) {
            songs[count] = s;
            count++;
        } else {
            System.out.println("Playlist is full!");
        }
    }

    // Step 4: Implement shufflePlaylist() Method (Fisher-Yates logic)
    public void shufflePlaylist() {
        System.out.println("\nShuffling Playlist...");
        Random rand = new Random();
        
        for (int i = count - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            
            // Swap songs[i] with the element at random index j
            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }
    }

    // Step 5: Display Playlist Queue (Enhanced for-loop)
    public void displayPlaylist() {
        int i = 1;
        for (Song s : songs) {
            if (s != null) {
                System.out.println(i + ". " + s.toString());
                i++;
            }
        }
    }
}

// Step 6: Test in Main Method
public class MusicSystem {
    public static void main(String[] args) {
        // Create Playlist object with size 3
        Playlist myPlaylist = new Playlist(3);

        // Add multiple Song objects
        myPlaylist.addSong(new Song("Believer", "Imagine Dragons"));
        myPlaylist.addSong(new Song("Shape of You", "Ed Sheeran"));
        myPlaylist.addSong(new Song("Blinding Lights", "The Weeknd"));

        // Display original order
        System.out.println("Playlist:");
        myPlaylist.displayPlaylist();

        // Shuffle playlist
        myPlaylist.shufflePlaylist();

        // Display shuffled order
        System.out.println("\nShuffled Playlist:");
        myPlaylist.displayPlaylist();
    }
}