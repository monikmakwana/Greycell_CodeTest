/*
Program of XPath Processor
By : Monik Makwana
*/

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.Scanner;

public class TestCode 
{
    public static void main(String[] args) throws Exception 
    {
		Scanner sc=new Scanner(System.in);
		String expression,finalExpr;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("XMLfile.xml");
		
		XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
		
		System.out.print("\nexpression : ");
		expression=sc.next();
		if(expression.contains("/"))
		{
			finalExpr=expression+"/text()";
			
			XPathExpression expr = xpath.compile(finalExpr);
			
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			System.out.println();
			for (int i = 0; i < nodes.getLength(); i++)
			{
				System.out.println("<sz>"+nodes.item(i).getNodeValue()+"</sz>");
			}
		}
		else
		{
			System.out.println("\nPlease Enter Valid Expression!");
		}
        
	}
}