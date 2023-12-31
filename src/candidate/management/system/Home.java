package candidate.management.system;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Home extends JFrame implements ActionListener{
	JButton add,view,update,remove;
	Home(){
	setLayout(null);
		
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        JLabel heading = new JLabel("Candidate Management System");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);
        
        add=new JButton("Add candidate");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
        
        view=new JButton("View candidate");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("Update candidate");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        image.add(update);
        
        remove=new JButton("Remove candidate");
        remove.setBounds(820,140,150,40);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1120,630);
		setLocation(250,100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
			setVisible(false);
			new AddCandidate();
		}else if(ae.getSource() ==view) {
			setVisible(false);
			new ViewCandidate();
		}else if(ae.getSource() ==update){
			setVisible(false);
			new ViewCandidate();
		}else {
			setVisible(false);
			new RemoveCandidate();
		}
		
	}
	public static void main(String[] args) {
		new Home();
	}
}

