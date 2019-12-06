package com.example.busi.inter;

public interface IPurchaseService {
    boolean purchase(Long userId, Long productId, int quantity);
}
