package src.Model.Data;

import java.util.ArrayList;
import src.Node.Data.Element;

public class ModelElement {
    public ArrayList<Element> ElementList;

    public ModelElement() {
        this.ElementList = new ArrayList<>();
    }

    public void addElement(Element element) {
        this.ElementList.add(element);
    }

    public int searchElement(String id) {
        for (Element element : ElementList) {
            if (element.getId().equals(id)) {
                return ElementList.indexOf(element);
            }
        }
        return -1;
    }

    public Element getElement(int index) {
        return ElementList.get(index);
    }

    public ArrayList<Element> getAllElements() {
        return ElementList;
    }
}
