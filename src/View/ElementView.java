package src.View;

import java.util.ArrayList;
import src.Node.Data.Dragon;
import src.Node.Data.Element;

public class ElementView {

    // TODO : complete show element details
    public void showElementDetails(Element element) {
        System.out.println("Element ID   : " + element.getId());
        System.out.println("Element Name : " + element.getName());
        System.out.println("Element Weakness : " + element.getWeakness());
        System.out.println("Element Strength : " + element.getStrength());
    }

    public void showElement(Element element) {
        System.out.println("Element ID : " + element.getId());
        System.out.println("Element Name : " + element.getName());
    }

    public void showAllElementDetails(ArrayList<Element> elementList) {
        for (Element element : elementList) {
            System.out.println("========================");
            showElementDetails(element);
        }
        System.out.println("========================");
    }

    public void showAllElement(ArrayList<Element> elementList) {
        for (Element element : elementList) {
            System.out.println("========================");
            showElement(element);
        }
        System.out.println("========================");
    }
}
