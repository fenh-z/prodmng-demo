package com.example.controller;

import com.example.busi.impl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/12/6 11:14 上午
 * @Describe
 */
@Controller
@RequestMapping
public class PurchaseController {

    @Autowired
    private PurchaseServiceImpl purchaseService;

    @RequestMapping("/purchase")
    @ResponseBody
    public Result purchase(Long userId, Long productId, Integer quantity) {
        boolean ret = purchaseService.purchase(userId, productId, quantity);
        String retMsg = ret ? "SUCC" : "FAIL";
        Result result = new Result(ret, retMsg);
        return result;
    }

    class Result {
        private boolean success = false;
        private String message = null;

        public Result() {
        }

        public Result(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "success=" + success +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

}
