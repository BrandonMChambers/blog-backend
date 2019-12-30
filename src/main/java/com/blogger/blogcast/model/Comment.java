package com.blogger.blogcast.model;
import javax.persistence.*;

/**
 * I might have been overly explicit in my table and column annotations.
 * if they need to be changed or removed, that's fine
 *
 *
 */

/**
 * Comment Postable
 *      body
 *      userId
 *      timestamp
 *      blogEntryId
 *      edited?
 *          editedTimestamp
 *
 * Comment Readable
 *      commentId
 *      body
 *      username
 *      timestamp
 *      blogEntryId
 *      edited?
 *          editedTimestamp
 */

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "COMMENT_BODY")
    private String body;

    @JoinColumn(name = "USER_ID")
    private Long authorId;

    @JoinColumn(name = "BLOG_ENTRY_ID")
    private Long blog_entry_id;

    /**
     * Leaving these here, at least for this initial commit
     * Idk if we will bring these back into the project
     */
//    private Set<Reaction> reactions;
//    private Set<Tag> tags;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBlog_entry_id() {
        return blog_entry_id;
    }

    public void setBlog_entry_id(Long blog_entry_id) {
        this.blog_entry_id = blog_entry_id;
    }

    @Override
    public String toString(){

        return "Comment{" + "id=" + id + ", body=" + body + ", authorId=" + authorId + ", blog_entry_id=" + blog_entry_id + "}";
    }
}
