package de.memory.gui.player2;

import java.util.Properties;

import aQute.bnd.annotation.component.Component;
import de.memory.api.IMemoryModel;
import de.memory.api.IMemoryView;
import de.memory.api.IMemoryViewFactory;

@Component
public class Player2ViewFactory implements IMemoryViewFactory {
	private final Properties prop = new Properties();
	
	public Player2ViewFactory() {
		// TODO Auto-generated constructor stub
		prop.put("type", "player2");
	}
	@Override
	public IMemoryView createView(IMemoryModel model) {
		Player2View view = new Player2View();
		view.activate();
		model.addView(view);		
		return view;
	}

	@Override
	public Properties getProperties() {
		// TODO Auto-generated method stub
		return prop;
	}

}
