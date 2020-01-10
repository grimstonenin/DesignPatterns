package main.udemyDesignPatterns.CreationalDesignPatterns.Builder;

import java.util.ArrayList;

class HtmlBuilder{
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName){
        this.rootName = rootName;
        root.name = rootName;
    }

    public void addChild(String childName, String childText){
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
    }

    public void clear(){
        root = new HtmlElement();
        root.name = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

class HtmlElement{
    String name, text;
    ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public HtmlElement() {
    }

    @Override
    public String toString() {
        return "HtmlElement{}";
    }
}

public class Demo {

    public static void main(String[] args) {
        String hello = "hello";
        System.out.println("<p>" + hello + "</p>");

        String[] words = {"hello", "world"};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ul>\n");
        for (String word : words){
            stringBuilder.append(String.format("<li>%s</li>\n", word));
        }

        stringBuilder.append("</ul>");
        System.out.println(stringBuilder);


        HtmlBuilder htmlBuilder = new HtmlBuilder("ul");
        htmlBuilder.addChild("li", "hello");
        htmlBuilder.addChild("li", "world");
        System.out.println(htmlBuilder);

    }
}
