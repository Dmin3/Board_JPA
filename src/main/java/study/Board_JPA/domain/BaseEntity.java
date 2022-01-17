package study.Board_JPA.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Column(name = "create", updatable = false)
    private String createDate;

    @Column(name = "update")
    private String updateDate;

    @PrePersist
    public void prePersist(){
        String now = formatDate();
        createDate = now;
        updateDate = now;
    }

    @PreUpdate
    public void preUpdate(){
        String now = formatDate();
        updateDate = now;
    }

    private String formatDate(){
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
        return format;
    }


}
