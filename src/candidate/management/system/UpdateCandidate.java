package candidate.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCandidate extends JFrame implements ActionListener{
	JTextField tfeducation,tffname,tfaddress,tfphone,tfaadhar,tfemail,tmname,tfgender;
	JLabel lblcandId;
	JButton add,back;
	String candId;
	UpdateCandidate(String candId){
		this.candId=candId;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		

		JLabel heading=new JLabel("Update Candidate Details");
		heading.setBounds(320,30,500,50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		JLabel labelname=new JLabel("Name");
		labelname.setBounds(50,150,150,30);
		labelname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelname);
		
		 JLabel lblname=new JLabel();
		 lblname.setBounds(200,150,150,30);
		add(lblname);
		
		JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
		
		JLabel labeldob=new JLabel("Date of Birth");
		labeldob.setBounds(50,200,150,30);
		labeldob.setFont(new Font("serif",Font.PLAIN,20));
		add(labeldob);
		
		 JLabel lbldob=new JLabel();
		 lbldob.setBounds(200,200,150,30);;
		add(lbldob);
		
		JLabel labelmname=new JLabel("Mother's Name");
		labelmname.setBounds(400,200,150,30);
		labelmname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelmname);
		
		 tmname=new JTextField();
		 tmname.setBounds(600,200,150,30);
		add(tmname);
		
		JLabel labeladdress=new JLabel("Address");
		labeladdress.setBounds(50,250,150,30);
		labeladdress.setFont(new Font("serif",Font.PLAIN,20));
		add(labeladdress);
		
		 tfaddress=new JTextField();
		tfaddress.setBounds(200,250,150,30);
		add(tfaddress);
		
		JLabel labelphone=new JLabel("Phone");
		labelphone.setBounds(400,250,150,30);
		labelphone.setFont(new Font("serif",Font.PLAIN,20));
		add(labelphone);
		
		 tfphone=new JTextField();
		tfphone.setBounds(600,250,150,30);
		add(tfphone);
		
		JLabel labelemail=new JLabel("Email");
		labelemail.setBounds(50,300,150,30);
		labelemail.setFont(new Font("serif",Font.PLAIN,20));
		add(labelemail);
		
		 tfemail=new JTextField();
		tfemail.setBounds(200,300,150,30);
		add(tfemail);
		
		JLabel labeleducation=new JLabel("Highest Education");
		labeleducation.setBounds(400,300,350,30);
		labeleducation.setFont(new Font("serif",Font.PLAIN,20));
		add(labeleducation);
		
		tfeducation=new JTextField();
		tfeducation.setBounds(600,300,150,30);
		add(tfeducation);
		
		JLabel labelgender=new JLabel("Gender");
		labelgender.setBounds(50,350,150,30);
		labelgender.setFont(new Font("serif",Font.PLAIN,20));
		add(labelgender);
		
		 tfgender=new JTextField();
		 tfgender.setBounds(200,350,150,30);
		add(tfgender);
		
		 JLabel labelaadhar = new JLabel("Aadhar Number");
	        labelaadhar.setBounds(400, 350, 150, 30);
	        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
	        add(labelaadhar);
	        
	        JLabel lblaadhar = new JLabel();
	        lblaadhar.setBounds(600, 350, 150, 30);
	        add(lblaadhar);
		JLabel labelcandId=new JLabel("Candidate ID");
		labelcandId.setBounds(50,400,150,30);
		labelcandId.setFont(new Font("serif",Font.PLAIN,20));
		add(labelcandId);
		
		 lblcandId = new JLabel();
		lblcandId.setBounds(200, 400, 150, 30);
		lblcandId.setFont(new Font("serif", Font.PLAIN, 20));
	    add(lblcandId);
	    
	    try {
	    	conn c=new conn();
	    	String query="select * from candidate where candId='"+candId+"'";
	    	ResultSet rs=c.s.executeQuery(query);
	    	while(rs.next()) {
	    		 lblname.setText(rs.getString("name"));
	                tffname.setText(rs.getString("fname"));
	                lbldob.setText(rs.getString("dob"));
	                tfaddress.setText(rs.getString("address"));
	                tmname.setText(rs.getString("mname"));
	                tfphone.setText(rs.getString("phone"));
	                tfemail.setText(rs.getString("email"));
	                tfeducation.setText(rs.getString("education"));
	                lblaadhar.setText(rs.getString("aadhar"));
	                lblcandId.setText(rs.getString("candId"));
	                tfgender.setText(rs.getString("gender"));
	    	}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	        
	     add = new JButton("Add Details");
	    add.setBounds(250, 550, 150, 40);
	    add.addActionListener(this);
	    add.setBackground(Color.BLACK);
	    add.setForeground(Color.WHITE);
	    add(add);
	        
	     back = new JButton("Back");
	    back.setBounds(450, 550, 150, 40);
	    back.addActionListener(this);
	    back.setBackground(Color.BLACK);
	    back.setForeground(Color.WHITE);
	    add(back);
	        
	    setSize(900, 700);
	    setLocation(300, 50);
	    setVisible(true);
	    }
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== add) {
			String fname = tffname.getText();
            String mname = tmname.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education =tfeducation.getText();
            String gender = tfgender.getText();
			try {
				conn conn=new conn();
				String query = "update candidate set fname = '"+fname+"', mname = '"+mname+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', gender = '"+gender+"' where candId = '"+candId+"'";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Details updated successfully");
				setVisible(false);
				new Home();
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
		}else {
			setVisible(false);
			new Home();
		}
	}
	
	public static void main(String[] args) {
		new UpdateCandidate("");
	}

}
