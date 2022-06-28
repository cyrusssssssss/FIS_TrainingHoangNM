package fis.finalTest.controller;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {
    private String code;
    private String message;
}
