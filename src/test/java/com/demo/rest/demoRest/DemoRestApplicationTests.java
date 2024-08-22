package com.demo.rest.demoRest;

import com.demo.rest.demoRest.controller.HelloController;
import com.demo.rest.demoRest.controller.UserController;
import com.demo.rest.demoRest.service.dto.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class DemoRestApplicationTests {

    @Autowired
    HelloController helloController;

    @Autowired
    UserController userController;


	@Test
	void testHelloController() {
        System.out.println("Cliente --> recibe " + helloController.hello());
	}

    @Test
    void testUserController() {
        System.out.println();

        System.out.println("Test fetchAllUsers");
        System.out.println(userController.fetchUsers());
        System.out.println();

        System.out.println("Test fetchUsers");
        System.out.println(userController.fetchUser(UUID.fromString("bbcc4621-d88f-4a94-ae2f-b38072bf5081")));
        System.out.println();


        UserRequest userRequest = UserRequest.builder()
                .name("Victor")
                .sensitiveInformation("TOP SECRET")
                .age(23)
                .build();
        System.out.println("Test saveUsers");
        System.out.println(userController.saveNewUser(userRequest));
        System.out.println();

        System.out.println("Test fetchAllUsers");
        System.out.println(userController.fetchUsers());
        System.out.println();

    }

}
