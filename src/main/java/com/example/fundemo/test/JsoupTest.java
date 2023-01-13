package com.example.fundemo.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class JsoupTest {


    public static void main(String[] args) throws Exception {
        parseJD();
    }

    //获取jd页面数据，解析
    private static void parseJD() throws IOException {
        String url = "https://search.jd.com/Search?keyword=vue";
        final Document document = Jsoup.parse(new URL(url), 30000);
        final Element goodsList = document.getElementById("J_goodsList");
        final Elements lis = goodsList.getElementsByTag("li");

        for (Element li : lis) {
            final String img = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            final String price = li.getElementsByClass("p-price").eq(0).text();
            final String title = li.getElementsByClass("p-name").eq(0).text();

            System.out.println("==============================");
            System.out.println(img);
            System.out.println(price);
            System.out.println(title);
        }
    }
}
