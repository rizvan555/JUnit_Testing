package com.rizvankarimov.springboot.junit5mavenstarter.assertjTest;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.services.InfoService;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.contentOf;

public class FileTest {
    @Test
    void testFile() {
        File file = new File("/Users/rizvan/Downloads/junit5-maven-starter/src/main/resources/test.txt");

        assertThat(file)
                .exists()
                .canRead()
                .canWrite()
                .isFile()
                .hasExtension("txt")
                .hasName("test.txt")
                .hasParent("/Users/rizvan/Downloads/junit5-maven-starter/src/main/resources");

        assertThat(contentOf(file))
                .startsWith("S")
                .endsWith("m")
                .contains("Salamunaleykum")
                .doesNotContain("Salamunaleykummmmm");
    }

    @Test
    void testExeption() {
        Exception exception = new MailServerUnavailableException("test");
        assertThat(exception)
                .hasMessage("test")
                .isInstanceOf(MailServerUnavailableException.class)
                .hasMessageContaining("test");
    }
}
