package com.example.unleashapp.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class LitService {
	
	public void init()
	{
		//con=new HttpS
	}
	public void getPage() throws IOException
	{
		Document doc=Jsoup.connect("https://www.literotica.com/stories/memberpage.php?uid=3586621&page=submissions").get();
File f=new File("lit.html");
//FileUtils.write(f, doc.outerHtml(), StandardCharsets.UTF_8);
		Elements elements=doc.getElementsByTag("table");
		elements=elements.get(7).child(1).getElementsByClass("sl");
		//element.childrenSize()
		//elements=element.g.getElementsContainingOwnText("Starting from Scratch Ch: 178 Part Series");
		
		//System.out.println(elements.eq(774));
	elements=elements.eq(774).get(0).getElementsByClass("bb");
		
		String title=elements.get(0).html().replace(":", "");
		//System.out.println(elements.get(0).html().split(".")[0]);
		elements.get(0).attr("href");
		System.out.println(title);
		File f2=new File(title);
		System.out.println(f2.getAbsolutePath());
		doc=Jsoup.connect(elements.get(0).attr("href")).get();
		String inner=doc.getElementsByClass("aa_ht").get(0).getElementsByTag("div").html();
		//System.out.println(inner.replaceAll("<[^>]*>", ""));
		inner=inner.replaceAll("<[^>]*>", "");
		System.out.println(inner);
		System.out.println(f2.getAbsolutePath());
	FileUtils.writeByteArrayToFile(f2, inner.getBytes());
	elements=doc.getElementsByClass("l_bh");
	System.out.println(elements);
	}
	public void getPage(String url,String title,int num) throws IOException
	{
		
		
		//String inner=doc.getElementsByClass("aa_ht").get(0).getElementsByTag("div").html().replaceAll("<[^>]*>", "");
		File f2=new File(title);
		//FileUtils.write(f2, inner, StandardCharsets.UTF_8, true);
		for(int i=1;i<=num;i++)
		{
			Document doc=null;
			String inner=null;
			if(i==1)
			{
				doc=Jsoup.connect(url).get();
			//	doc.getElementsByClass("aa-ht");
				//System.out.println(doc.getElementsByClass("aa_ht").get(0).html().replaceAll("<[^>]*>", ""));
				inner=doc.getElementsByClass("aa_ht").get(0).html().replaceAll("<[^>]*>", "");
				//FileUtils.writeStringToFile(f2, inner, StandardCharsets.UTF_8, true);
				FileUtils.write(f2, inner, StandardCharsets.ISO_8859_1, true);
			}
			else
			{
				doc=Jsoup.connect(url+"?page="+i).get();
				inner=doc.getElementsByClass("aa_ht").get(0).html().replaceAll("<[^>]*>", "");
				//FileUtils.writeStringToFile(f2, inner, StandardCharsets.UTF_8, true);

				FileUtils.write(f2, inner, StandardCharsets.ISO_8859_1, true);
			}

			
			
		}
		//FileUtils.writeByteArrayToFile(f2, inner.getBytes());
		//Elements elements=doc.getElementsByClass("l_bh").get(0).getElementsByTag("a");
		/*System.out.println(elements.get(0).getElementsByTag("a"));
		elements.forEach(s->{
			System.out.println(s.attr("href"));
		});*/
		

	}
	

}
