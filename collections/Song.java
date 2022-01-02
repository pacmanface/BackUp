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
        return author+" /"+title+" /"+album+" /"+timeInSeconds;
    }

    @Override
    public int compareTo(Song song) {
        return title.compareTo(song.getTitle());
    }

}
