package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ratpack.http.Status;
import ratpack.test.MainClassApplicationUnderTest;
import ratpack.test.http.TestHttpClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.platform.commons.util.StringUtils.isBlank;

class FileHandlerTest {

    final MainClassApplicationUnderTest app = new MainClassApplicationUnderTest(Main.class);
    final TestHttpClient client = app.getHttpClient();

    @AfterEach
    void after() {
        app.close();
    }

    @DisplayName("should return HTTP 200 and content length headers when a file is not found")
    @Test
    void fileNotFound() {
        var response = client.get("/file");

        assertEquals(Status.OK, response.getStatus());
        assertTrue(response.getHeaders().contains("content-length"));
        assertEquals("42", response.getHeaders().get("content-length"));
        assertTrue(isBlank(response.getBody().getText()));
    }

}
