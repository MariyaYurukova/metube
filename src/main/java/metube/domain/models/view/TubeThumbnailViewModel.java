package metube.domain.models.view;

import metube.domain.entities.Tube;

public class TubeThumbnailViewModel  implements Viewable<Tube> {


    private String id;
    private String title;
    private String author;
    private String youtubeId;

    public TubeThumbnailViewModel() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }
}
