package thinlet.drafts;

import java.awt.*;
import thinlet.*;

/**
 *
 */
public class Style {
	
	/**
	 *
	 */
	public void loadFontNames(Thinlet thinlet, Object namecombo) {
		String[] fontlist = null;
		try { // 1.4
			Object lge = Class.forName("java.awt.GraphicsEnvironment").
				getMethod("getLocalGraphicsEnvironment", null).invoke(null, null);
			fontlist = (String[]) lge.getClass().
				getMethod("getAvailableFontFamilyNames", null).invoke(lge, null);
		} catch (Exception exc) { // 1.1
			fontlist = thinlet.getToolkit().getFontList();
		}
		String currentname = thinlet.getFont().getName();
		for (int i = 0; i < fontlist.length; i++) {
			Object choice = thinlet.create("choice");
			thinlet.setString(choice, "text", fontlist[i]);
			thinlet.add(namecombo, choice);
			
			if (fontlist[i].equals(currentname)) {
				thinlet.setInteger(namecombo, "selected", i);
			}
		}
	}
	
	/**
	 *
	 */
	public void loadFontSizes(Thinlet thinlet, Object sizecombo) {
		int[] sizelist = { 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
		int currentsize = thinlet.getFont().getSize();
		for (int i = 0; i < sizelist.length; i++) {
			Object choice = thinlet.create("choice");
			thinlet.setString(choice, "text", String.valueOf(sizelist[i]));
			thinlet.add(sizecombo, choice);
			
			if (sizelist[i] == currentsize) {
				thinlet.setInteger(sizecombo, "selected", i);
				thinlet.setString(sizecombo, "text", String.valueOf(currentsize)); // fix it
			}
		}
	}
	
	/**
	 *
	 */
	public void changeFont(Thinlet thinlet, String name, boolean bold, boolean italic, String size) {
		thinlet.setFont(new Font(name, (bold ? Font.BOLD : 0) |
			(italic ? Font.ITALIC : 0), Integer.parseInt(size)));
	}
	
	/**
	 *
	 */
	public void changeColors(Thinlet thinlet, int index) {
		switch (index) {
			case 0: //default
				thinlet.setColors(0xe6e6e6, 0x000000, 0xffffff,
					0x909090, 0xb0b0b0, 0xededed, 0xb9b9b9, 0x89899a, 0xc5c5dd);
				break;
			case 1: //yellow
				thinlet.setColors(0xeeeecc, 0x000000, 0xffffff,
					0x999966, 0xb0b096, 0xededcb, 0xcccc99, 0xcc6600, 0xffcc66);
				break;
			case 2: //blue
				thinlet.setColors(0x6375d6, 0xffffff, 0x7f8fdd,
					0xd6dff5, 0x9caae5, 0x666666, 0x003399, 0xff3333, 0x666666);
				break;
			case 3: //xp
				thinlet.setColors(0xeae2b2, 0x000000, 0xf5f4f0,
					0x968B4B, 0xb0b0b0, 0xededed, 0xa8b680, 0x89899a, 0xc5c5dd);
		}
	}
}