import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlForm;
import org.htmlunit.html.HtmlPage;
import org.htmlunit.html.HtmlSubmitInput;
import org.htmlunit.html.HtmlTextInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValidation {
    @Test
    public void homePage() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://www.htmlunit.org/");
            assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

            final String pageAsXml = page.asXml();
            assertTrue(pageAsXml.contains("<body class=\"topBarDisabled\">"));

            final String pageAsText = page.asNormalizedText();
            assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
        }
    }
}
