import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 1- Посчитать и вывести количество попыток за всю игру. 
 * 2- При новой игре счетчик обнулить.
 * 3- Начать игру с определенным количеством попыток. Когда попытки закончатся, 
 * то вывести угадываемое число и сообщить что игра закончена.
 * 4- Добавить поле для ввода количества попыток перед началом игры
 * 5- Релизовать приятный интерфейс
 */
@SuppressWarnings("serial")
public class GuesingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int offNumber;// Переменная кол-ва ходов
	private int numberOfTries=0;

	public void checkGues() {
		String guessText = txtGuess.getText();
		String message = null;

		try {
			int guess = Integer.parseInt(guessText);
			numberOfTries=numberOfTries+1;
			if (guess < theNumber)
				message = guess + " is too low. Try again";
			else if (guess > theNumber)
				message = guess + " is too high. Try again";
			else {
				message = guess + " is correct. You win after "+numberOfTries+" tries! Let's play again!";
				newGame();
				
			}
		} catch (NumberFormatException e) {
			// TODO Автоматически созданный блок catch
			message = "Enter a whole number between -100 and 100";
			
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
		
		
//		System.out.println(numberOfTries);//Проверка на количество кодов.
		
	}

	public void newGame() {
		theNumber = (int) (Math.random() * 200 - 100);
	}

	public GuesingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HiLo");
		getContentPane().setLayout(null);

		JLabel lblNikolasHiloGuesinggame = new JLabel("Nikolas HiLo GuesingGame");
		lblNikolasHiloGuesinggame.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 15));
		lblNikolasHiloGuesinggame.setHorizontalAlignment(SwingConstants.CENTER);
		lblNikolasHiloGuesinggame.setBounds(10, 35, 414, 18);
		getContentPane().add(lblNikolasHiloGuesinggame);

		JLabel lblGuessAsNumber = new JLabel("Guess a number between -100 and 100:");
		lblGuessAsNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessAsNumber.setFont(new Font("Arial Narrow", Font.ITALIC, 15));
		lblGuessAsNumber.setBounds(10, 88, 274, 18);
		getContentPane().add(lblGuessAsNumber);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Arial Narrow", Font.ITALIC, 15));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 199, 414, 23);
		getContentPane().add(lblOutput);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGues();
			}
		});
		txtGuess.setBounds(294, 86, 50, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!.");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGues();
			}
		});
		btnGuess.setBounds(184, 141, 89, 23);
		getContentPane().add(btnGuess);
	}

	public static void main(String[] args) {
		// TODO автоматически созданна¤ заглушка метода

		GuesingGame theGame = new GuesingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);

	}
}
