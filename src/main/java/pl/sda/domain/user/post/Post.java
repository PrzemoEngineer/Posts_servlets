package pl.sda.domain.user.post;

import pl.sda.domain.user.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Post {

    @Id
    private Integer id;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User author;
    private Instant createdAt;

    public Post(String content, User author, Instant createdAt) {
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", createdAt=" + createdAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
