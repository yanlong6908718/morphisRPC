package TestCase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.logging.Logger;

public class BaseCase {
    //before all
    @BeforeAll
    public  static void beforeAll(){
    }
    //before each
    @BeforeEach
    public  void beforeEach(){

    }

    //after all
    @AfterEach
    public  void afterEach(){

    }
    //after each
    @AfterAll
    public  static void afterAll(){

    }

    static Logger log=Logger.getLogger(BaseCase.class.getName());
}
