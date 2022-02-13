package com.udacity.pricing;
import com.udacity.pricing.api.PricingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
public class PricingServiceApplicationTests {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PricingController pricingController;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getPrice() throws Exception {
        mockMvc.perform(get("http://localhost:8082/services/price?vehicleId=1"))
                .andExpect(status().isOk());
        verify(pricingController, times(1)).get(1L);
    }

}
