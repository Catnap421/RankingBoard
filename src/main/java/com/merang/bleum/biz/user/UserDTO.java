package com.merang.bleum.biz.user;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserDTO {
    private final Long id;
    private final String email;
    private final String name;
}