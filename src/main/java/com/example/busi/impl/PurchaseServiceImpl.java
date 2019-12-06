package com.example.busi.impl;

import com.example.atom.dao.ProductDao;
import com.example.atom.dao.PurchaseRecordDao;
import com.example.atom.pojo.ProductPo;
import com.example.atom.pojo.PurchaseRecordPo;
import com.example.busi.inter.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/12/6 11:02 上午
 * @Describe
 */
@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private PurchaseRecordDao purchaseRecordDao;

    @Override
    @Transactional
    public boolean purchase(Long userId, Long productId, int quantity) {

        ProductPo product = productDao.getProduct(productId);

        if (product == null) {
            return false;
        }

        if (product.getStock() < quantity) {
            return false;
        }

        productDao.decreaseProduct(productId, quantity);
        purchaseRecordDao.insertPurchaseRecord(this.initPurchaseRecord(userId, product, quantity));

        return true;
    }

    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志 ，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }

}
