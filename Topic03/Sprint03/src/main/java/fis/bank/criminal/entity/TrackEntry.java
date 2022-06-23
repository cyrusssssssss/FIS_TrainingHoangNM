package fis.bank.criminal.entity;



import fis.bank.criminal.entity.enums.TrackAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "track_entry")
public class TrackEntry extends AbstractEntity{
    @Column(name = "date_track", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "evidence_id", nullable = false)
    private Evidence evidence;
    @ManyToOne
    @JoinColumn(name = "detective_id", nullable = false)
    private Detective detective;
    @Enumerated(EnumType.STRING)
    @Column(name = "action")
    private TrackAction action;
    private String reason;


}
