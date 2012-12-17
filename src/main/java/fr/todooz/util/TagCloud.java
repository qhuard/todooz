package fr.todooz.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TagCloud {

	private List<String> tags = new ArrayList<String>();
	private List<String> toptags = new ArrayList<String>();
	
    public void add(String tag) {
    		tags.add(tag);
    }
    
    public void add(String... tags) {
        	
    	if (tags != null) {
    		for (String tag : tags) {
    			if (contains(tag) == false && tag != null && tag != "")	
    				this.tags.add(tag);
        	}
    	}        		
    }

    public int size() {
        return tags.size();
    }
    
    public boolean contains(String string) {
		return tags.contains(string);
	}

	public void top(int i) {
		// TODO Auto-generated method stub
		int n = 0;
		if (tags.size() > i) {
			while (n<i) {
				n++;
				String tag;
				tag = tags.get(n);
				toptags.add(tag);
				}
			tags = toptags;
		}
	}

	public void shuffle() {
		// TODO Auto-generated method stub
		Collections.shuffle(tags);
	}

}
