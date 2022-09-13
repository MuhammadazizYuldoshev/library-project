package uz.pdp.libraryproject.record;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Record {
    private int id;
    private boolean isReturned;
    private LocalDateTime dateTime;
    private int userId;
}
