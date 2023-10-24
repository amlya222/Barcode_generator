import javax.swing.*;
import net.connectcode.Code128Auto;
import java.awt.event.*;

public class Barcode implements ActionListener
{
	JLabel l,l1;
	JTextField tx;
	JFrame f;
	JButton btn;
	
	public Barcode()
	{
		f = new JFrame();
		f.setSize(500,400);
		f.setVisible(true);
		f.setLayout(null);
		l = new JLabel("Enter string to convert in Barcode :");
		f.add(l);
		l.setBounds(40,50,200,40);
		tx = new JTextField("");
		f.add(tx);
		tx.setBounds(250,50,200,40);
		btn = new JButton("Convert");
		f.add(btn);
		btn.setBounds(200,100,80,35);
		btn.addActionListener(this);
		l1 = new JLabel("Here will print barcode..!");
		f.add(l1);
		l1.setBounds(170,200,200,70);
	}
	public void actionPerformed(ActionEvent e)
	{
		try{
			Code128Auto code128 = new Code128Auto();
			String barcode = code128.encode(tx.getText());
			l1.setText(barcode);
			l1.setFont(new java.awt.Font("CCode128_S3_Trial",java.awt.Font.PLAIN,24));
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public static void main(String sa[])
	{
		new Barcode();
	}
}