package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CommentFiles {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    private String filePath;
    private String fileName;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    private int fileSize;

}
