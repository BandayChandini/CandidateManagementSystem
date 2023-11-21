package candidate.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewCandidate extends JFrame implements ActionListener{
	JTable table;
	Choice ccandidateId;
	 JButton search, print, update, back;
	ViewCandidate(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel searchlbl=new JLabel("Search by Candidate Id");
		searchlbl.setBounds(20,20,50,20);
		add (searchlbl);
		ccandidateId=new Choice();
		ccandidateId.setBounds(180,20,150,20);
		add (ccandidateId);
		 try {
	            conn c = new conn();
	            ResultSet rs = c.s.executeQuery("select * from candidate");
	            while(rs.next()) {
	                ccandidateId.add(rs.getString("candId"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
		table=new JTable();
		try {
			conn c=new conn();
			ResultSet rs=c.s.executeQuery("select * from candidate");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0,100,900,600);
		add(jsp);
		  
	        search = new JButton("Search");
	        search.setBounds(20, 70, 80, 20);
	        search.addActionListener(this);
	        add(search);
	        
	        print = new JButton("Print");
	        print.setBounds(120, 70, 80, 20);
	        print.addActionListener(this);
	        add(print);
	        
	        update = new JButton("Update");
	        update.setBounds(220, 70, 80, 20);
	        update.addActionListener(this);
	        add(update);
	        
	        back = new JButton("Back");
	        back.setBounds(320, 70, 80, 20);
	        back.addActionListener(this);
	        add(back);
	        
	        setSize(900, 700);
	        setLocation(300, 100);
	        setVisible(true);
	    }
	    
		
	 public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource() == search) {
	            String query = "select * from candidate where candId = '"+ccandidateId.getSelectedItem()+"'";
	            try {
	                conn c = new conn();
	                ResultSet rs = c.s.executeQuery(query);
	                table.setModel(DbUtils.resultSetToTableModel(rs));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else if (ae.getSource() == print) {
	            try {
	                table.print();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else if (ae.getSource() == update) {
	            setVisible(false);
	            new UpdateCandidate(ccandidateId.getSelectedItem());
	        } else {
	            setVisible(false);
	            new Home();
	        }
	    }

	    public static void main(String[] args) {
	        new ViewCandidate();
	    }
	}