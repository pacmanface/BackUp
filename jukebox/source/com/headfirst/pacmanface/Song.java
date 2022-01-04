public class Song implements Comparable<Song> {

    private String title;
    private String album;
    private String author;
    private int timeInSeconds;

    public Song(String title, String album, String author, int timeInSeconds){
        this.title = title;
        this.album = album;
        this.author = author;
        this.timeInSeconds = timeInSeconds;
    }

    public String getTitle(){
        return title;
    }

    public String getAlbum(){
        return album;
    }

    public String getAuthor(){
        return author;
    }

    public int getTime(){
        return timeInSeconds;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Song song) {
        return title.compareTo(song.getTitle());
    }

    @Override
    public boolean equals(Object obj) {
        Song song = (Song) obj;
        return title.equals(song.getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

}
