package com.couponservice.coupon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;
    
    Logger logger = LoggerFactory.getLogger(CouponController.class);

    @GetMapping(value = "/list")
    public List<Coupon> getAllCoupons(){
    	logger.info("logger info get all coupons");
		logger.trace("logger get all coupons activated");
    	logger.error("Error happend in get all coupons");
        return couponRepository.findAll();
    }

    @PostMapping(value = "/add")
    public String addCoupon(@RequestBody Coupon coupon){
    	logger.info("logger info add all coupons");
		logger.trace("logger add coupon activated");
    	logger.error("Error happend in add coupon");
        couponRepository.save(coupon);
        return "Coupon Added Successfully";
    }

    @DeleteMapping(value = "/delete/{couponID}")
    public String deleteProduct(@PathVariable String couponID) {
    	logger.info("logger info delete coupon");
		logger.trace("logger delete coupon activated");
    	logger.error("Error happend in delete coupon");
       System.out.println("Delete method called");
        couponRepository.deleteById(couponID);
        return "Deleted Successfully";
    }

    @PutMapping(value = "/update/{couponID}")
    public Coupon updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
    	logger.info("logger info update coupon");
		logger.trace("logger update coupon activated");
    	logger.error("Error happend in update coupon");
        return couponRepository.save(coupon);

    }
}
