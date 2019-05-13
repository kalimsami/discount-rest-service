package controller;

import model.BillType;
import model.Discount;
import model.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DiscountController {
    private static final Logger log = LoggerFactory.getLogger(DiscountController.class);

    @RequestMapping(value = "/getdiscount", method = RequestMethod.GET)
    public double getDiscount(@RequestParam(value = "userType") UserType userType,
                              @RequestParam(value = "yearOfAssociation", defaultValue="0") int yearOfAssociation,
                              @RequestParam(value = "billType") BillType billType,
                              @RequestParam(value = "billAmount") double billAmount) {

        log.info("Param userType is :: " + userType);
        log.info("Param yearOfAssociation is :: " + yearOfAssociation);
        log.info("Param billType is :: " + billType);
        log.info("Param billAmount is :: " + billAmount);

        return new Discount(userType, yearOfAssociation, billType).calculateNetPayableAmount(billAmount);
    }
}
