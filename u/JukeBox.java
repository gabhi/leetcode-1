import java.util.*;

public class JukeBox {
	CDPlayer cdPlayer;
	User user;
	List<CD> cds; // lots to choose
	public static void main(String[] args) {}
}

class CDPlayer {
	CD cd;       // current CD
	Playlist p;
}

class CD {
	String hardwareId;
}

class Playlist {
	int id = 0;
	List<Song> songs;
	boolean cycle;
	public Playlist() {}
	Song current() {
		if(songs == null) return null;
		return songs.get(id);
	}

	Song next() {
		if(songs == null) return null;
		if(id == songs.size() - 1) {
			if(cycle) {
				id = 0;
				return songs.get(id);
			} else return null;
		}
		return songs.get(++id);
	}

	Song last() {
		if(songs == null) return null;
		if(id == 0) {
			if(cycle) {
				id = songs.size() - 1;
				return songs.get(id);
			}
			else return null;
		} 
		return songs.get(--id);
	}
}

class Song {
	String id;
	String name;
}

class User {
	String name;
}