package de.memory.gui.player2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.memory.api.IPlayer;
import de.memory.gui.MemoryGUI;
import de.memory.gui.OvalView;

public class Player2View extends MemoryGUI {

	private OvalView player2Oval = new OvalView(Color.RED);
	private JLabel player2Pairs = new JLabel("0");
	private JButton collectPairButton = new JButton("collect pair");
	
	protected Player2View() {
		super("Player 2");
		playerNumber = 2;
	}

	@Override
	protected JComponent northView() {
		// TODO Auto-generated method stub
		return getHeaderView();
	}

	@Override
	protected JComponent southView() {
		collectPairButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getModel().getPlayer(2).collectPair();
			}
		});
		JPanel footer = new JPanel();
		footer.setLayout(new BorderLayout());
		footer.add(collectPairButton, BorderLayout.CENTER);
		return footer;
	}

	@Override
	protected JComponent eastView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected JComponent westView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void updateView() {
		super.updateView();
		this.player2Pairs.setText(""+getModel().getPlayer(2).getAmountCardPairs());
		this.player2Pairs.repaint();
		this.player2Oval.setColor( player.isActive() ? Color.GREEN : Color.RED);
		this.player2Oval.repaint();
	}
	
	private JComponent getHeaderView() {
		JPanel header = new JPanel();
		header.setLayout(new GridLayout (2,2));
		header.add(new JLabel("Player 2"));
		header.add(this.player2Oval);
		header.add(new JLabel("Pairs:"));
		header.add(this.player2Pairs);
		
		return header;
	}
	
	@Override
	public void startNewGame() {
		//reset visibility of all memory field elements
		resetVisibilityMemoryFieldElements();
	}
}
