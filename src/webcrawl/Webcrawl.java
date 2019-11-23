/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/**
 *
 * @author Aswin Timalsina
 */
public class Webcrawl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
       File file = new File("web.html");
       Document doc = Jsoup.parse(file, "utf-8");
       
       Element metat = new Element(Tag.valueOf("meta"), "");
       metat.attr("charset", "utf-8");
       doc.head().appendChild(metat);
       
       doc.body().addClass("content");
       
     Element tagP = new Element(Tag.valueOf("p"), "");
     tagP.text("The amount of heat required to raise the temperature of one gram pure water through one degree celsius is called ...");
     doc.body().appendChild(tagP);
     
     tagP.before("<p>Author: Abdullah fakira</p>");
     
     Element pAuth = doc.body().select("p:contains(Author)").first();
     pAuth.attr("align", "center");
       
       FileWriter writer = new FileWriter("updated.html");
       writer.write(doc.toString());
       writer.close();  
       
       
       Document web = Jsoup.connect("http://google.com").get();
       Elements links = web.select()
}}
