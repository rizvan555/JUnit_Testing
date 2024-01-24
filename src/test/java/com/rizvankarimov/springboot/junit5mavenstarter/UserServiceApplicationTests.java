package com.rizvankarimov.springboot.junit5mavenstarter;

import com.rizvankarimov.springboot.junit5mavenstarter.dto.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceApplicationTests {

private UserServiceApplication userServiceApplication;

    @BeforeEach
    void prepare(){
        System.out.println("Before each test" + this); //Burada "this" UserServiceApplicationTests classinin obyektini, yeni ki, "toString" gosterir
        userServiceApplication = new UserServiceApplication();
    }

    // Bu test methodu, UserServiceApplication sınıfının getAll() methodunu test eder.
    // Burada eger yeni user elave edilmeyibse getAll() methodu bos bir list qaytarir.
    @Test
    void usersEmptyIfNoUserAdded() {
        System.out.println("Test 1" + this);
        var users = userServiceApplication.getAll();
        assertTrue(users.isEmpty()); // assertTrue() methodu, verilen ifadenin true olmasini yoxlayir.
    }


    // Bu test methodu, UserServiceApplication sınıfının add() methodunu test eder.
    // Burada eger yeni user elave edilibse getAll() methodu user listinin size-ni yoxlayir ki, 2 olmalidir.
    @Test
    void userSizeIfUserAdded(){
        System.out.println("Test 2" + this);
        userServiceApplication.add(new User());
        userServiceApplication.add(new User());
        var users = userServiceApplication.getAll();
        assertEquals(2, users.size());
    }

    @AfterEach
    void deleteDataFromDatabase(){
        System.out.println("After each test" + this);
    }

}
