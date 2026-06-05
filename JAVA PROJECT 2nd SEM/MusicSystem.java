import java.util.Scanner;
import java.util.Random;

// Song Class
class Song {
    private String title;
    private String artist;

    // Constructor
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getter Methods
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

// Playlist Class
class Playlist {
    private Song[] songs;
    private int count;

    // Constructor
    public Playlist(int size) {
        songs = new Song[size];
        count = 0;
    }

    // Add Song Method
    public void addSong(Song s) {
        if (count < songs.length) {
            songs[count] = s;
            count++;
            System.out.println("Song Added Successfully!");
        } else {
            System.out.println("Playlist is Full!");
        }
    }

    // Display Playlist
    public void displayPlaylist() {
        if (count == 0) {
            System.out.println("Playlist is Empty!");
            return;
        }

        System.out.println("\n===== PLAYLIST =====");

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". "
                    + songs[i].getTitle()
                    + " - "
                    + songs[i].getArtist());
        }
    }

    // Shuffle Playlist using Fisher-Yates Algorithm
    public void shufflePlaylist() {
        Random random = new Random();

        for (int i = count - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }
    }
}

// Main Class
public class MusicPlaylistSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Maximum Playlist Size: ");
        int size = sc.nextInt();
        sc.nextLine();

        Playlist playlist = new Playlist(size);

        System.out.print("How Many Songs Do You Want To Add? ");
        int n = sc.nextInt();
        sc.nextLine();

        // Taking song details from user
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter Details for Song " + i);

            System.out.print("Song Title: ");
            String title = sc.nextLine();

            System.out.print("Artist Name: ");
            String artist = sc.nextLine();

            Song song = new Song(title, artist);

            playlist.addSong(song);
        }

        // Display Original Playlist
        System.out.println("\n===== ORIGINAL PLAYLIST =====");
        playlist.displayPlaylist();

        // Shuffle Playlist
        System.out.println("\nShuffling Playlist...");
        playlist.shufflePlaylist();

        // Display Shuffled Playlist
        System.out.println("\n===== SHUFFLED PLAYLIST =====");
        playlist.displayPlaylist();

        sc.close();
    }
}
