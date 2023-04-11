package kr.co.pcmpetclinicstudy.owner;

import kr.co.pcmpetclinicstudy.controller.OwnersController;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class OwnerControllerTest {



    @Autowired
    OwnersController ownersController;

    @Autowired
    MockMvc mockMvc;
}
