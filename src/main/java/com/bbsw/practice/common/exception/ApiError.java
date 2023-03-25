package com.bbsw.practice.common.exception;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    @NonNull
    String status;

    @NonNull
    String message;

    List<String> details;

}
