package kr.co.pcmpetclinicstudy.owner;

import kr.co.pcmpetclinicstudy.controller.OwnerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class OwnerControllerTest {

    @Autowired
    OwnerController ownersController;

    @Autowired
    MockMvc mockMvc;
}
