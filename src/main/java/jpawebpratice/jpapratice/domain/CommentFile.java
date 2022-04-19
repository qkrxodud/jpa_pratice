package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CommentFile {

    @Id @GeneratedValue
    @Column(name = "comment_file_id")
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
