package ucam.calidad.playlist;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MusicService 
{
	private Map<String, Playlist> playlists;

    public MusicService() {
        this.playlists = new HashMap<>();
    }

    public boolean createPlaylist(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
        }
        if (playlists.containsKey(name)) {
            return false; // ya existe
        }
        playlists.put(name, new Playlist(name));
        return true;
    }

    public boolean deletePlaylist(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
        }
        return playlists.remove(name) != null;
    }

    public Playlist getPlaylist(String name) {
        return playlists.get(name);
    }

    public Collection<String> getPlaylistNames() {
        return Collections.unmodifiableSet(playlists.keySet());
    }

    public int getPlaylistCount() {
        return playlists.size();
    }
}
