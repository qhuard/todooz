package fr.todooz.util;

import java.util.ArrayList;
import java.util.List;

public class TagCloud {

	private List<String> tags = new ArrayList<String>();

    public void add(String tag) {
        tags.add(tag);
    }

    public int size() {
        return tags.size();
    }

}
