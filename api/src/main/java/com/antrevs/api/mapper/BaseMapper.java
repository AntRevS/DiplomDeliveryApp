package com.antrevs.api.mapper;

public interface BaseMapper<FROM, TO> {

    TO map(FROM from);
}
