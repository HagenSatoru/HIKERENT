package com.Hikerent.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private Long userId;

    private Long cartId;

    private List<Long> cartItemIds;

}