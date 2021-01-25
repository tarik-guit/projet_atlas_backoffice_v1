package backoffice.back.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class genererpasswordTest {

    @Test
    void generateCommonLangPassword() {
        genererpassword n=new genererpassword();
        System.out.println(n.generateCommonLangPassword());
    }
}