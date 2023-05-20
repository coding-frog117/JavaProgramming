import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel{
	public NorthPanel(){
		setBackground(Color.GRAY);
		setLayout(new FlowLayout());
		JButton JBtnOpen = new JButton("열기");
		JButton JBtnClose = new JButton("닫기");
		JButton JBtnExit = new JButton("나가기");
		
		add(JBtnOpen);
		add(JBtnClose);
		add(JBtnExit);
		
	}
	
}

class CenterPanel extends JPanel{
	CenterPanel(){
		setLayout(null);
		
		for (int i=0; i < 10; i++) {
			int x = (int)(Math.random()*200) + 50;
			int y = (int)(Math.random()*200) + 50;
			
			JLabel label = new JLabel("*");
			label.setBounds(x,y,20,20);
			label.setOpaque(true);
			
			add(label);
		}	
	}
	
}

class SouthPanel extends JPanel{
	public SouthPanel() {
		setBackground(Color.YELLOW);
        
        setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽 정렬된 FlowLayout 사용
        
        JButton inputbtn = new JButton("Word Input");
        inputbtn.setSize(50,40);
        JTextField inputField = new JTextField(18);
        add(inputbtn);
        add(inputField);
		
	}
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 40); // 너비와 높이를 원하는 크기로 설정
    }
}

public class SwingFrame extends JFrame{
	
	public SwingFrame() {
		setTitle("SwingFrame Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(),BorderLayout.NORTH);
		c.add(new CenterPanel(),BorderLayout.CENTER);
		c.add(new SouthPanel(),BorderLayout.SOUTH);
		
		
		setSize(300,400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingFrame();

	}

}
