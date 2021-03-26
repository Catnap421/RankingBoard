package com.merang.bleum.biz.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDTO {
    private final Long id;
    private final String email;
    private final String name;
}
