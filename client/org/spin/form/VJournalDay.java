/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2014 E.R.P. Consultores y Asociados, C.A.               *
 * All Rights Reserved.                                                       *
 * Contributor(s): Raul Muñoz www.erpconsultoresyasociados.com                *
 *****************************************************************************/
package org.spin.form;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.compiere.apps.form.FormFrame;
import org.compiere.apps.form.FormPanel;
import org.compiere.grid.ed.VLookup;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.plaf.CompiereColor;
import org.compiere.swing.CPanel;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.compiere.util.Trx;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class VJournalDay extends JournalDay
			implements FormPanel, ChangeListener,ActionListener,MouseListener {

	
		
	@Override
	public void init(int WindowNo, FormFrame frame) {
		
		m_WindowNo = WindowNo;
			m_frame = frame;
		Env.setContext(Env.getCtx(), m_WindowNo, "IsSOTrx", "Y");   //  defaults to no
		try
		{
			dyInit();
			jbInit();
			frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
			
		}
		catch(Exception e)
		{
			
		}
	}
	/**	Window No			*/
	private int         m_WindowNo = 0;
	/**	FormFrame			*/
		private FormFrame 	m_frame;
	private BorderLayout 	mainLayout = new BorderLayout();
	JCheckBox[] conceptBox;
	JButton[] h_IncidenceButton;
	JPanel[] sliderPanel;
	private CPanel 		mainPanel    = new CPanel();
	private CPanel 		northPanel   = new CPanel();
	private CPanel		rightPanel	 = new CPanel();
	private CPanel		leftPanel	 = new CPanel();
	private JSplitPane	detailPanel  = new JSplitPane();
	private String		trxName = Trx.createTrxName("GM");
	/** Journal */
	private JLabel 		journalLabel  = new JLabel();
	private VLookup 	journalSearch = null;
	private CPanel		hoursPanel    = new CPanel();
	private JLabel 		groupLabel  = new JLabel();
	private JScrollPane scrollPane;
	/** Save */
	private JButton		bSave = new JButton();
	/** Incidence */
	static final int N_HOUR = 24;
	static final int N_MIN  = 60;
	private int s_Hour      = 120;
//	private int s_division  = 5;
//	private int s_Conv_Hour = s_Hour/s_division;
//	private int s_Slider    = s_Conv_Hour*N_HOUR;
//	private int s_Conv_Min  = N_MIN/s_Conv_Hour;
	private int start_Hour  = 1;
	private int start_Min  	= 1;
	private int end_Hour 	= 1;
	private int end_Min 	= 1;
	private JButton add_MinButton = new JButton();
	private JTextField s_HourText = new JTextField(4);
	private JTextField s_MinText = new JTextField(4);
	private JTextField e_HourText = new JTextField(4);
	private JTextField e_MinText = new JTextField(4);
	private JLabel s_HourLabel = new JLabel();
	private JLabel s_MinLabel = new JLabel();
	private JLabel e_HourLabel = new JLabel();
	private JLabel e_MinLabel = new JLabel();
	private JPanel editHourPanel = new JPanel();
	private int s_IncideceButton;
	private int aux =0 ;
    private JDialog f7;
	private void jbInit() {
		CompiereColor.setBackground(mainPanel);
		mainPanel.setLayout(mainLayout);
		//
		journalLabel.setText(Msg.translate(Env.getCtx(), "Journal"));
		northPanel.add(journalSearch);
		northPanel.add(bSave);
		
		bSave.setText(Msg.translate(Env.getCtx(), "Save"));
		add_MinButton.setText("Edit");
		add_MinButton.addActionListener(this);
		
		//	Hour Edit Panel
		editHourPanel.setVisible(false);
		s_HourText.setText("00");
		s_MinText.setText("00");
		e_HourText.setText("00");
		e_MinText.setText("00");
		s_HourLabel.setText("Hora Inicio");
		s_MinLabel.setText(":");
		e_HourLabel.setText("Hora Final");
		e_MinLabel.setText(":");
		editHourPanel.add(s_HourLabel);
		editHourPanel.add(s_HourText);
		editHourPanel.add(s_MinLabel);
		editHourPanel.add(s_MinText);
		editHourPanel.add(e_HourLabel);
		editHourPanel.add(e_HourText);
		editHourPanel.add(e_MinLabel);
		editHourPanel.add(e_MinText);
		editHourPanel.add(add_MinButton);
		northPanel.add(editHourPanel);
		
		//	Split Panel
		detailPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		detailPanel.setBorder(BorderFactory.createEtchedBorder());
		detailPanel.setPreferredSize(new Dimension(600,250));
		detailPanel.setMinimumSize(new Dimension(600, 200));
		detailPanel.setLeftComponent(leftPanel);
		detailPanel.setRightComponent(rightPanel);
		//	Scroll Panel
		scrollPane = new JScrollPane(rightPanel,
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		detailPanel.setRightComponent(scrollPane);
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(detailPanel, BorderLayout.CENTER);
	}
	public void dyInit() throws Exception{
		//	GET Journal
		int AD_Column_ID = 1000077;		//	C_Order.C_BPartner_ID
		GridLayout experimentLayout = new GridLayout(0,24,0,0);
		
		MLookup lookupBPartner = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		journalSearch = new VLookup("HR_Journal_ID", true, false, true, lookupBPartner);
		hoursPanel.setBackground(Color.BLUE);
		hoursPanel.setMaximumSize(new Dimension(s_Hour*25, 15));
		leftPanel.setLayout(new BorderLayout()); 
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		hoursPanel.setLayout(experimentLayout);
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		groupLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
		groupLabel.setText("Grupos de Incidencias:");
		leftPanel.add(groupLabel);

		for(int i = 0; i < 24; i++){
			JLabel hoursLabel = new JLabel("",JLabel.CENTER);
			if(i < 10)
				hoursLabel.setText("0"+i+":30");
			else 
				hoursLabel.setText(i+":30");
	
			hoursLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			hoursLabel.setForeground(Color.WHITE);
			hoursLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
			hoursLabel.setPreferredSize(new Dimension(s_Hour, 15));
			hoursLabel.setMinimumSize(new Dimension(s_Hour, 15));
			hoursLabel.setMaximumSize(new Dimension(s_Hour, 15));
			hoursPanel.add(hoursLabel);
		}

		rightPanel.add(hoursPanel);
		addItems();
//		f7 = new JDialog(m_frame, true);
//		f7.setBounds(150,200  - 200 - 32, 300, 200);
//	       
//	      
//        JLabel l7 = new JLabel("Famous writers: ");
//        l7.setHorizontalAlignment(SwingConstants.CENTER);
//        // create radio buttons
//        f7.add(editHourPanel);
//        // place radio buttons into a single group
//       
//        Container cp7 = f7.getContentPane();
//        // create three containers to improve layouting
//        cp7.setLayout(new GridLayout(1, 3));
//        Container cp71 = new Container();
//        Container cp72 = new Container();
//        Container cp73 = new Container();
//        // add the label into a separate panel
//        JPanel p7 = new JPanel();
//        p7.setLayout(new FlowLayout());
//        p7.add(l7);
//        // add a label and radio buttons one after another into a single column
//        cp72.setLayout(new GridLayout(4, 1));
//        cp72.add(editHourPanel);
//        
//        // add three containers
//        cp7.add(cp71);
//        cp7.add(cp72);
//        cp7.add(cp73);
			
	}
	
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 10/09/2014, 09:21:46
	 * @return void
	 */
	public void addItems() {
		int i=0;
		ArrayList<KeyNamePair> data = getGroupIncidenceData(trxName);
		conceptBox = new JCheckBox[data.size()];
		h_IncidenceButton = new JButton[data.size()];
		sliderPanel = new JPanel[data.size()];
	
		for(KeyNamePair pp : data) {
			
				conceptBox[i]  = new JCheckBox(pp.toString(), true);
			    sliderPanel[i] = new JPanel();
			    conceptBox[i].setFont(new Font("SanSerif", Font.PLAIN, 14));
				conceptBox[i].addActionListener(this);
			    conceptBox[i].setMaximumSize(new Dimension(150, 15));
			    conceptBox[i].setName("--"+i);
			    addPanelHour(i);
			    sliderPanel[i].setLayout(null);
			    sliderPanel[i].setMaximumSize(new Dimension(s_Hour*25, 15));
			    sliderPanel[i].add(h_IncidenceButton[i]);
			    //	Add Label Cocept rightPanel
			    leftPanel.add(conceptBox[i]);
			    //	Add Slider Hours rightPanel
			    rightPanel.add(sliderPanel[i]);		   
			    i++;
		}
		
	}
	public void addPanelHour(int i) {
			h_IncidenceButton[i]  = new JButton();
		 	h_IncidenceButton[i].setName(String.valueOf(i));
		    h_IncidenceButton[i].setBackground(Color.GREEN);
		    h_IncidenceButton[i].setForeground(Color.GREEN);
		    h_IncidenceButton[i].setSize(new Dimension(40,11));
		    h_IncidenceButton[i].setLocation(20, 0);
		    h_IncidenceButton[i].addActionListener(this);
		    h_IncidenceButton[i].setText(String.valueOf(i));

	}
	  @Override
	  public void mousePressed(MouseEvent e) {
		  int count=conceptBox.length;

			for(int i = 0; i < count; i++){
				
			}
	    }

	@Override
	public void stateChanged(ChangeEvent e) {
		
		int count=conceptBox.length;
		for(int i = 0; i < count; i++){
			
		}
	}
	public void actionPerformed(ActionEvent e){
		int count=conceptBox.length;     f7.setVisible(true);
		if(e.getActionCommand().equals(add_MinButton.getText())){
			start_Hour = Integer.parseInt(s_HourText.getText())*s_Hour;
			end_Hour   = Integer.parseInt(e_HourText.getText())*s_Hour;
			start_Min  = Integer.parseInt(s_MinText.getText())*s_Hour/N_MIN;
			end_Min  = Integer.parseInt(e_MinText.getText())*s_Hour/N_MIN;
			s_IncideceButton = (end_Hour+end_Min)-(start_Hour+start_Min);
		    h_IncidenceButton[aux].setSize(new Dimension(s_IncideceButton,11));
		    h_IncidenceButton[aux].setLocation(start_Hour+start_Min, 0);
	    	editHourPanel.setVisible(false);
	    }
	       
		for(int i = 0; i < count; i++){
			if(conceptBox[i].isSelected())
				h_IncidenceButton[i].setVisible(true);
			else 
				h_IncidenceButton[i].setVisible(false);
				
		    if(e.getActionCommand().equals(h_IncidenceButton[i].getName())){
		    	aux=i;
		    	
			    h_IncidenceButton[aux].getLocation();
			    start_Hour = h_IncidenceButton[i].getLocation().x/s_Hour;
			    end_Hour = h_IncidenceButton[i].getSize().width/s_Hour+h_IncidenceButton[i].getLocation().x/s_Hour;
			    start_Min  = (h_IncidenceButton[i].getLocation().x/(s_Hour))/(s_Hour/N_MIN);
				end_Min  = (h_IncidenceButton[i].getSize().width/s_Hour+h_IncidenceButton[i].getLocation().x/(s_Hour/N_MIN))/(s_Hour/N_MIN);
			    editHourPanel.setVisible(true);
		    	s_HourText.setText(""+start_Hour);
				s_MinText.setText(""+start_Min);
				e_HourText.setText(""+end_Hour);
				e_MinText.setText(""+end_Min);
		    }
		}
	}
	@Override
	public void dispose() {
		

	}
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {

		
	}
	
	

}


