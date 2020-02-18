package tech.donau.course;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

@QuarkusTest
public class StaticContentTest {
    @TestHTTPResource("index.html")
    URL url;

    @Test
    public void testRootPath() throws IOException {
        final String body = IOUtils.toString(url, Charset.defaultCharset());
        System.out.println(body);
        Assertions.assertTrue(body.contains("<div>This is a test div</div>"));
    }
}
