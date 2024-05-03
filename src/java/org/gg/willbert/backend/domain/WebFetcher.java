package org.gg.willbert.backend.domain;

import org.htmlunit.AjaxController;
import org.htmlunit.NicelyResynchronizingAjaxController;
import org.htmlunit.WebClient;
import org.htmlunit.WebRequest;
import org.htmlunit.html.*;

import java.net.URL;
import java.util.List;

public class WebFetcher {
    public static final String SEARCH_FOR_ITEM_FORMAT = "https://www.willys.se/sok?q=%s";

    public static void main(String[] args) throws Exception {
        searchForItem("banan");
    }
    public static void searchForItem(String item) throws Exception {

        String pageString=String.format(SEARCH_FOR_ITEM_FORMAT,item);

        try (final org.htmlunit.WebClient webClient = new WebClient()) {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.setJavaScriptTimeout(5000);
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.getOptions().setTimeout(5000);

            // Get the first page
            URL url = new URL(pageString);
            WebRequest request = new WebRequest(url);
            final HtmlPage searchPage = webClient.getPage(request);
            webClient.waitForBackgroundJavaScript(5000);
            webClient.getAjaxController().processSynchron(searchPage, request, false);
            String content = searchPage.asXml();
            System.out.println(content);

            // Get main div
            final HtmlDivision mainDiv = searchPage.getHtmlElementById("__next");

            final HtmlDivision secondDiv = (HtmlDivision) mainDiv.getFirstChild();

            final HtmlDivision thirdDiv = (HtmlDivision) secondDiv.getChildNodes().get(1);

            System.out.println(thirdDiv.getChildElementCount());

            // <main>
            final HtmlMain fourthDiv = (HtmlMain) thirdDiv.getChildNodes().getFirst();

            final HtmlSection fifthDiv = (HtmlSection) fourthDiv.getChildNodes().getFirst();
            ///
            int i = webClient.waitForBackgroundJavaScript(1000);

            while (i > 0)
            {
                i = webClient.waitForBackgroundJavaScript(1000);

                if (i == 0)
                {
                    break;
                }
                synchronized (searchPage)
                {
                    System.out.println("wait");
                    searchPage.wait(500);
                }
            }
            ///
            final HtmlDivision sixthDiv = (HtmlDivision) fifthDiv.getChildNodes().getFirst();

            // infinite-scroll-component
            final HtmlDivision seventhDiv = (HtmlDivision) sixthDiv.getChildNodes().get(3);

            final HtmlDivision eightDiv = (HtmlDivision) seventhDiv.getChildNodes().getFirst();

            // grid div with result data...
            final HtmlDivision ninthDiv = (HtmlDivision) eightDiv.getChildNodes().getFirst();

            final HtmlDivision firstItem = (HtmlDivision) ninthDiv.getChildNodes().getFirst();

            final String firstItemName = firstItem.getChildNodes().get(1).getChildNodes().getFirst().asXml();

            //get div which has a 'id' attribute of 'banner'
            //final HtmlDivision searchResultsDiv = (HtmlDivision) searchPage.getByXPath("//div[@class='infinite-scroll-component ']").getFirst();

            // take out the first result
            // TODO: handle the list of children to find best result.
            //final HtmlDivision searchResult = (HtmlDivision) searchResultsDiv.getFirstChild();

            System.out.println("HelloWorld");
            System.out.println(searchPage);
            System.out.println(mainDiv);
            System.out.println(firstItemName);

        }
    }
}
