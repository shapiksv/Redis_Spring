package com.springredisexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccount implements Serializable {

    @Id
    private String id;
    @Indexed
    private String name;
}
