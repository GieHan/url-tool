package de.gie.tool.urltool.alias;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Alias {
    @Id
    @SequenceGenerator(
            name = "alias_sequence",
            sequenceName = "alias_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "alias_sequence"
    )

    private Long id;
    private String longUrl;
    private String aliasName;
    private int durationTime;
    private LocalDate creationDate;

    public Alias() {
    }

    public Alias(String longUrl, String aliasUrl, int durationTime) {
        this.longUrl = longUrl;
        this.aliasName = aliasUrl;
        this.durationTime = durationTime;
        this.creationDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Alias{" +
                "longUrl='" + longUrl + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", durationTime=" + durationTime +
                ", creationDate=" + creationDate +
                '}';
    }
}
