package com.example.retrofitrecyclerview;

public class SampleData {
    String albumid,id,title;

    public String getAlbumid() {
        return albumid;
    }

    public void setAlbumid(String albumid) {
        this.albumid = albumid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SampleData(String albumid, String id, String title) {
        this.albumid = albumid;
        this.id = id;
        this.title = title;
    }

}
