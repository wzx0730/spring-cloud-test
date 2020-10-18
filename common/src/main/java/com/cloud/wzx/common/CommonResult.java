package com.cloud.wzx.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CommonResult <T>{
    private T date;
    private Boolean Success;
    private String msg;
}
