package detector;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Detector {
	static JList list;
	static ArrayList<Website> websites;

	public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        JPanel layout = new JPanel(new GridLayout(5, 1));
        JPanel listButtons = new JPanel(new GridLayout(1, 5));
        JPanel addUrlForm = new JPanel(new GridLayout(2, 1));
        window.setSize(300, 500);
        window.add(layout);
        JButton save = new JButton("Save");
        
        Timer timer = new Timer();
        
        
        File file = new File("/Users/rafal.sojecki@schibsted.pl/Desktop/config.txt");
        websites = file.getWebsites();
        Number length = 0;
      
        
        Website[] arr = new Website[websites.size()];
        arr = websites.toArray(arr);
        DefaultListModel<Website> model = new DefaultListModel<>();
        JList<Website> l = new JList<>( model );
        
        for ( int i = 0; i < websites.size(); i++ ){
        	  model.addElement( websites.get(i));
        }
        
  
        JTextField newUrl = new JTextField();
        JButton add = new JButton("Add");
        
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	model.addElement(new Website(newUrl.getText()));
            }
        });
    	
        
        JButton remove = new JButton("Remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(l.getSelectedIndex());
            	if (l.getSelectedIndex() >= 0) {
            		model.remove(l.getSelectedIndex());
            	}
            	
            }
        });
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int size = model.getSize();
            	Website[] items = new Website[size];
            	for (int i = 0; i < size; i++) {
            		items[i] = model.get(i);
            	}
            	try {
					file.save(items);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
            	
            }
        });
        
		JScrollPane listScroller = new JScrollPane(l);
		listScroller.setSize(200, 500);
		layout.add(listScroller);
		JLabel label = new JLabel("Type Url to check");
		addUrlForm.add(label);
		addUrlForm.add(newUrl);
		layout.add(addUrlForm);
		listButtons.add(save);
		listButtons.add(add);
		listButtons.add(remove);
		layout.add(listButtons);

		JButton start = new JButton("Start");
        layout.add(start);
        
        JButton stop = new JButton("Stop");
        stop.setVisible(false);
        layout.add(stop);
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                start.setVisible(false);
                stop.setVisible(true);
                int size = model.getSize();
                TimerTask tt = new TimerTask() {
                    public void run() {
                    	Website[] items = new Website[size];
                    	for (int i = 0; i < size; i++) {
                    		items[i] = model.get(i);
                    		try {
            					Cron cron = new Cron(items[i], i);
            				} catch (HttpRequestDetectorException e1) {
            					Website toChangeStatusWebsite = model.getElementAt(e1.getId());
            					toChangeStatusWebsite.setStatus(e1.getStatus());
            					model.set(e1.getId(), toChangeStatusWebsite);
            				}
                    	}
                    }
                 };
                 timer.schedule(tt,0,3000);
            }
        });
        
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(true);
                stop.setVisible(false);
                timer.cancel();
                timer.purge();
            }
        });
        
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
