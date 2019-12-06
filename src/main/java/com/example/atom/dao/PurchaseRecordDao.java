package com.example.atom.dao;

import com.example.atom.pojo.PurchaseRecordPo;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRecordDao {
    int insertPurchaseRecord(PurchaseRecordPo purchaseRecordPo);
}
