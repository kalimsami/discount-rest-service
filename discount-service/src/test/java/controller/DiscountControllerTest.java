package controller;

import app.DiscountApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DiscountApplication.class)
@AutoConfigureMockMvc
public class DiscountControllerTest {

    private static final String GET_DISCOUNT_API_URL = "/getdiscount";
    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String GROSSORY = "GROSSORY";
    private static final String NON_GROSSORY = "NON_GROSSORY";
    private static final String AFFILIATE = "AFFILIATE";
    private static final String CUSTOMER = "CUSTOMER";
    private static final String USER_TYPE = "userType";
    private static final String BILL_TYPE = "billType";
    private static final String BILL_AMOUNT = "billAmount";
    private static final String YEAR_OF_ASSOCIATION = "yearOfAssociation";
    private static final String GIVEN_BILL_AMOUNT = "990";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void discountForEmployeeForGrossory() throws Exception {

        this.mockMvc.perform(get(GET_DISCOUNT_API_URL)
                .param(USER_TYPE, EMPLOYEE)
                .param(BILL_TYPE, GROSSORY)
                .param(BILL_AMOUNT, GIVEN_BILL_AMOUNT))
                .andExpect(MockMvcResultMatchers.content().string("945.0"));
    }

    @Test
    public void discountForAffiliateForGrossory() throws Exception {

        this.mockMvc.perform(get(GET_DISCOUNT_API_URL)
                .param(USER_TYPE, AFFILIATE)
                .param(BILL_TYPE, GROSSORY)
                .param(BILL_AMOUNT, GIVEN_BILL_AMOUNT))
                .andExpect(MockMvcResultMatchers.content().string("945.0"));
    }

    @Test
    public void discountForCustomerForGrossory() throws Exception {

        this.mockMvc.perform(get(GET_DISCOUNT_API_URL)
                .param(USER_TYPE, CUSTOMER)
                .param(YEAR_OF_ASSOCIATION, "1")
                .param(BILL_TYPE, GROSSORY)
                .param(BILL_AMOUNT, GIVEN_BILL_AMOUNT))
                .andExpect(MockMvcResultMatchers.content().string("945.0"));
    }

    @Test
    public void discountForOldCustomerForGrossory() throws Exception {

        this.mockMvc.perform(get(GET_DISCOUNT_API_URL)
                .param(USER_TYPE, CUSTOMER)
                .param(YEAR_OF_ASSOCIATION, "3")
                .param(BILL_TYPE, GROSSORY)
                .param(BILL_AMOUNT, GIVEN_BILL_AMOUNT))
                .andExpect(MockMvcResultMatchers.content().string("945.0"));
    }

    @Test
    public void discountForEmployeeForNonGrossory() throws Exception {

        this.mockMvc.perform(get(GET_DISCOUNT_API_URL)
                .param(USER_TYPE, EMPLOYEE)
                .param(BILL_TYPE, NON_GROSSORY)
                .param(BILL_AMOUNT, GIVEN_BILL_AMOUNT))
                .andExpect(MockMvcResultMatchers.content().string("648.0"));
    }

    @Test
    public void discountForAffiliateForNonGrossory() throws Exception {

        this.mockMvc.perform(get(GET_DISCOUNT_API_URL)
                .param(USER_TYPE, AFFILIATE)
                .param(BILL_TYPE, NON_GROSSORY)
                .param(BILL_AMOUNT, GIVEN_BILL_AMOUNT))
                .andExpect(MockMvcResultMatchers.content().string("846.0"));
    }

    @Test
    public void discountForCustomerForNonGrossory() throws Exception {

        this.mockMvc.perform(get(GET_DISCOUNT_API_URL)
                .param(USER_TYPE, CUSTOMER)
                .param(YEAR_OF_ASSOCIATION, "1")
                .param(BILL_TYPE, NON_GROSSORY)
                .param(BILL_AMOUNT, GIVEN_BILL_AMOUNT))
                .andExpect(MockMvcResultMatchers.content().string("945.0"));
    }

    @Test
    public void discountForOldCustomerForNonGrossory() throws Exception {

        this.mockMvc.perform(get(GET_DISCOUNT_API_URL)
                .param(USER_TYPE, CUSTOMER)
                .param(YEAR_OF_ASSOCIATION, "3")
                .param(BILL_TYPE, NON_GROSSORY)
                .param(BILL_AMOUNT, GIVEN_BILL_AMOUNT))
                .andExpect(MockMvcResultMatchers.content().string("895.5"));
    }

}
