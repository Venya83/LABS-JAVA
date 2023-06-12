package ps1_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paint {

	public static void main(String[] args) {
	
okno window = new okno();

	}

}

class okno extends JFrame
{
	public okno()
	{
		setBounds(0,0,800,600);
		
		setTitle("Рулю мышой");
	
panel pan = new panel();

Container con = getContentPane();
con.add(pan);

setVisible(true);
}
}
class panel extends JPanel{
Color[] masColor;
int tCol = 0;
int mX,mY;
Boolean flag = false;

public panel() {
	addMouseListener(new myMouse1());
	addMouseMotionListener(new myMouse2());
	
	JButton eraserButton = new JButton("Eraser");
	eraserButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        tCol = -1;
	    }
	});
	add(eraserButton);
}
public void paintComponent(Graphics gr)
{ 
	Color[] masColor;
	masColor = new Color[7];
	masColor[0] = Color.BLACK;
	masColor[1] = Color.GREEN;
	masColor[2] = Color.BLUE;
	masColor[3] = Color.RED;
	masColor[4] = Color.YELLOW;
	masColor[5] = Color.PINK;
	masColor[6] = Color.ORANGE;
	masColor[6] = Color.CYAN;
	for (int i=0; i<7; i++)
	{
gr.setColor(masColor[i]);
gr.fillRect(i*100, 0, 100, 50);
if (flag==true)
{
	gr.setColor(masColor[tCol]);
	gr.fillRect(mX, mY, 5, 5);
}
	}
	
}
public class myMouse1 implements MouseListener
{
	public void mouseClicked(MouseEvent e)
	{
}
	public void mousePressed(MouseEvent e)
	{
		int tX = e.getX();
		int tY = e.getY();
		int col = e.getClickCount();
		int btn = e.getButton();
		if ((tX>0) && (tX<700) && (tY>0) && (tY<50));
		{
			if (col==1)
			{
				if (btn==1)
				{
				tCol = tX / 100;
				}
				}
	}
		}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	
}
}
public class myMouse2 implements MouseMotionListener
{
	public void mouseDragged(MouseEvent e)
	{
		int tX = e.getX();
		int tY = e.getY();
		if  (tY>50)
			if (tCol == -1) {
				Graphics gr = ((JComponent) e.getSource()).getGraphics();
			    gr.setColor(getBackground());
			    gr.fillRect(mX, mY, 20, 20);
			}


			if (tCol == -1) {
			    mX = e.getX();
			    mY = e.getY();
			    flag = true;
			    repaint();
			}

		{
			mX = tX;
			mY = tY;
			flag=true;
			repaint();
		}
}
	public void mouseMoved(MouseEvent e)
	{
		int tX = e.getX();
		int tY = e.getY();
		int col = e.getClickCount();
		int btn = e.getButton();
		if ((tX>0) && (tX<700) && (tY>0) && (tY<50));
		{
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		{
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
}
}
